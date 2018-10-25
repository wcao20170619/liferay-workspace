#!/bin/sh
##########################################################################################################################
# The script will download elasticsearch, plugin and X-Pack and pack it as zip file with pre-config or without configuration.
# It takes  the following parameters -v <elastic_version_number>,  -c <cluster_name>,  -p <Linux|Darwin|CYGWIN> and 
#-x <without xpack pre-config>. For elasticsearch 6.3.x and later version, The elastic has integrated with xpack but
# the trail license won't support xpack security. 
#For xpack pre-config, the password of elasticsearch built-in users will be set as 'liferay'
#The script requires some of the system utilities such as zip/unzip, rm etc. And it also needs
#JAVA_HOME to be set, utilities like curl, sleep, kill etc. when xpack pre-config needed.
#
#NOTES: The ssl certificate paths in kibana.yam are set to be relative. There is a bug in Kibana[see below url]. 
#https://github.com/elastic/kibana/issues/11775 Users must be in the kibana executable directory to bring up
#the kibana server. 
#########################################################################################################################
version="6.1.3"
download_url="https://artifacts.elastic.co/downloads"
cluster_name="LiferayElasticsearchCluster"
elastic_url="http://localhost:9200"
platform="windows-x86_64"
file_ext="zip"
unpack_cmd="unzip"
exclude_xpack=0

usage() 
{ 
  echo "Usage: $0 [-v <version>] [-c <cluster_name>] [-p <Linux|Darwin|CYGWIN>] [-x <no xpack>] [-h <help>]" 
  echo ""
  echo "\t-h 					output usage information"
  echo "\t-v <version> 				default: $version"
  echo "\t-c <cluseter_name> 			default: $cluster_name" 
  echo "\t-p <platform: Linux|Darwin|CYGWIN> 	default: `uname`"
  echo "\t-x 					without xpack security"
  exit 1; 
}

javahome_curl_chk() {
  if [ -z $JAVA_HOME ] 
  then 
     echo "NO JAVA HOME SET AND IT IS REQUIRED!" 
     1>&2; exit 1;
  fi

  if ! [ -x "$(command -v curl)" ]; then
     echo "NO curl PROGRAM INSTALLED AND IT IS REQUIRED!"
     1>&2; exit 1;
  fi 
}

version_gt() { test "$(echo "$@" | tr " " "\n" | sort -V | head -n 1)" != "$1"; }

set_init_passwd() {
  curr_dir=`pwd`
  elastic_home=$1

  ###Add a "bootstrap.password" to the keystore on that node
  printf "liferay" | $elastic_home/bin/elasticsearch-keystore add "bootstrap.password" -x

  sleep 2s

  ###Briing up elastic server for password changes
  $elastic_home/bin/elasticsearch -d -p $curr_dir/my_tmp

  sleep 20s

  curl --insecure -uelastic:liferay -XPUT -H 'Content-Type: application/json' 'https://localhost:9200/_xpack/security/user/kibana/_password' -d '{ "password":"liferay" }'

  kill -9 `cat $curr_dir/my_tmp`

  rm $curr_dir/my_tmp
}

enable_es_xpack() {
  es_home=$1
  certutil_cmd=$2

  zip_file="elastic-stack-ca.zip"
  printf '\n' | $es_home/$certutil_cmd ca --pem --ca-dn CN=localhost
  unzip $zip_file -d $es_home/config
  rm $zip_file

  zip_file="certificate-bundle.zip"
  printf '\n' | $es_home/$certutil_cmd cert --pem --ca-cert ./$es_home/config/ca/ca.crt --ca-key ./$es_home/config/ca/ca.key --dns localhost --ip 127.0.0.1 --name localhost
  unzip $zip_file -d $es_home/config
  rm $zip_file

  echo "xpack.ssl.certificate: \${path.home}/config/localhost/localhost.crt" >> $es_home/config/elasticsearch.yml
  echo "xpack.ssl.key: \${path.home}/config/localhost/localhost.key" >> $es_home/config/elasticsearch.yml
  echo "xpack.ssl.certificate_authorities: \${path.home}/config/ca/ca.crt" >> $es_home/config/elasticsearch.yml

  echo "xpack.security.transport.ssl.enabled: true" >> $es_home/config/elasticsearch.yml
  echo "xpack.security.transport.ssl.verification_mode: certificate" >> $es_home/config/elasticsearch.yml
  echo "xpack.security.http.ssl.enabled: true" >> $es_home/config/elasticsearch.yml

}

enable_kibana_xpack() {
  
  k_home=$1
  echo "xpack.security.encryptionKey: \"xsomethingxatxleastx32xcharactersx\"" >> $k_home/config/kibana.yml
  echo "xpack.security.sessionTimeout: 600000" >> $k_home/config/kibana.yml
  echo "elasticsearch.ssl.verificationMode: certificate" >> $k_home/config/kibana.yml
  echo "elasticsearch.ssl.certificateAuthorities: ../../elasticsearch-$version/config/ca/ca.crt" >> $k_home/config/kibana.yml
  echo "server.ssl.enabled: true" >> $k_home/config/kibana.yml
  echo "server.ssl.certificate: ../../elasticsearch-$version/config/localhost/localhost.crt" >> $k_home/config/kibana.yml
  echo "server.ssl.key: ../../elasticsearch-$version/config/localhost/localhost.key" >> $k_home/config/kibana.yml

}

uname_out="$(uname -s)"

while getopts ":v:c:p:x" o; do
    case "${o}" in
        v)
            version=${OPTARG}
            ;;
        c)
	    cluster_name=${OPTARG}
	    ;;
	p)
	    uname_out=${OPTARG}
	    ;;	
	x)
	    exclude_xpack=1
	    ;;
        *)
            usage
            ;;
    esac
done
shift $((OPTIND-1))

if $(version_gt 6.0.0 $version); 
then
   echo "Elasticsearch $version is not supported"
   1>&2; exit 1;
fi

if [ "$exclude_xpack" -eq 0 ] 
then
   javahome_curl_chk
fi

case "$uname_out" in
   Linux*)   platform="linux-x86_64"
             file_ext="tar.gz"
             unpack_cmd="tar -xzf kibana-$version-$platform.$file_ext"
             ;;
   Darwin*)  platform="darwin-x86_64.tar.gz"
             file_ext="tar.gz"
             unpack_cmd="gunzip -c kibana-$version-$platform.$file_ext | tar xopf -"
             ;;
   CYGWIN*)  platform="windows-x86_64"
             file_ext="zip"
             unpack_cmd="unzip kibana-$version-$platform.$file_ext"
             ;;
   *)        usage
             ;;
esac

if [ -d liferay-enterprise-search-server-1.0 ]
then
   rm -rf liferay-enterprise-search-server-1.0
fi

mkdir liferay-enterprise-search-server-1.0

cd liferay-enterprise-search-server-1.0

### installing elasticsearch
wget "$download_url/elasticsearch/elasticsearch-$version.zip"

#if [ test ! -f elasticsearch-$version.zip ]
if [ ! -f elasticsearch-$version.zip ]
then
  echo "unable to download elasticsearch-$version.zip"
  exit 1;
fi
unzip elasticsearch-$version.zip
rm elasticsearch-$version.zip

elasticsearch-$version/bin/elasticsearch-plugin install analysis-kuromoji || true
elasticsearch-$version/bin/elasticsearch-plugin install analysis-icu || true
elasticsearch-$version/bin/elasticsearch-plugin install analysis-smartcn || true
elasticsearch-$version/bin/elasticsearch-plugin install analysis-stempel || true

echo "cluster.name: $cluster_name" >> elasticsearch-$version/config/elasticsearch.yml

### installing X-Pack
if $(version_gt 6.3 $version) && [ "$exclude_xpack" -eq 0 ];
then
  elasticsearch-$version/bin/elasticsearch-plugin install x-pack --batch
fi

### installing kibana
wget "$download_url/kibana/kibana-$version-$platform.$file_ext"

$unpack_cmd
rm kibana-$version-$platform.$file_ext

### installing x-pack for kibana
if $(version_gt 6.3 $version) && [ "$exclude_xpack" -eq 0 ];
then
  kibana-$version-$platform/bin/kibana-plugin install x-pack
fi


if [ "$exclude_xpack" -eq 0 ]
then
  if $(version_gt 6.3 $version);
  then
     enable_es_xpack elasticsearch-$version bin/x-pack/certutil
  else
     enable_es_xpack elasticsearch-$version bin/elasticsearch-certutil
  fi

  enable_kibana_xpack kibana-$version-$platform
 
  elastic_url="https://localhost:9200"

  set_init_passwd elasticsearch-$version 
fi

echo "elasticsearch.url: $elastic_url" >> kibana-$version-$platform/config/kibana.yml
echo "elasticsearch.username: kibana" >> kibana-$version-$platform/config/kibana.yml
echo "elasticsearch.password: liferay" >> kibana-$version-$platform/config/kibana.yml

cd ..

zip -r liferay-enterprise-search-server-1.0.zip liferay-enterprise-search-server-1.0
rm -rf liferay-enterprise-search-server-1.0

