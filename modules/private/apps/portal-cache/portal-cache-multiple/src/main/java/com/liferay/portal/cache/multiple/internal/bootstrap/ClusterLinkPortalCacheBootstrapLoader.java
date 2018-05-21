/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.cache.multiple.internal.bootstrap;

import com.liferay.portal.cache.PortalCacheBootstrapLoader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Properties;

/**
 * @author Tina Tian
 */
public class ClusterLinkPortalCacheBootstrapLoader
	implements PortalCacheBootstrapLoader {

	public ClusterLinkPortalCacheBootstrapLoader(Properties properties) {
		if (properties != null) {
			_bootstrapAsynchronously = GetterUtil.getBoolean(
				properties.getProperty(
					PortalCacheBootstrapLoader.BOOTSTRAP_ASYNCHRONOUSLY),
				PortalCacheBootstrapLoader.DEFAULT_BOOTSTRAP_ASYNCHRONOUSLY);
		}
		else {
			_bootstrapAsynchronously =
				PortalCacheBootstrapLoader.DEFAULT_BOOTSTRAP_ASYNCHRONOUSLY;
		}
	}

	@Override
	public boolean isAsynchronous() {
		return _bootstrapAsynchronously;
	}

	@Override
	public void loadPortalCache(
		String portalCacheManagerName, String portalCacheName) {

		if (ClusterLinkBootstrapLoaderHelperUtil.isSkipped()) {
			return;
		}

		if (_bootstrapAsynchronously) {
			BootstrapLoaderClientThread bootstrapLoaderClientThread =
				new BootstrapLoaderClientThread(
					portalCacheManagerName, portalCacheName);

			bootstrapLoaderClientThread.start();
		}
		else {
			doLoad(portalCacheManagerName, portalCacheName);
		}
	}

	protected void doLoad(
		String portalCacheManagerName, String portalCacheName) {

		if (_log.isDebugEnabled()) {
			_log.debug("Bootstraping " + portalCacheName);
		}

		try {
			ClusterLinkBootstrapLoaderHelperUtil.loadCachesFromCluster(
				portalCacheManagerName, portalCacheName);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to load cache data from the cluster", e);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ClusterLinkPortalCacheBootstrapLoader.class);

	private final boolean _bootstrapAsynchronously;

	private class BootstrapLoaderClientThread extends Thread {

		public BootstrapLoaderClientThread(
			String portalCacheManagerName, String portalCacheName) {

			if (_log.isDebugEnabled()) {
				_log.debug(
					"Bootstrap loader client thread for cache " +
						portalCacheName + " from cache manager " +
							portalCacheManagerName);
			}

			_portalCacheManagerName = portalCacheManagerName;
			_portalCacheName = portalCacheName;

			setDaemon(true);
			setName(
				BootstrapLoaderClientThread.class.getName() + " - " +
					portalCacheManagerName + " - " + portalCacheName);
			setPriority(Thread.NORM_PRIORITY);
		}

		@Override
		public void run() {
			try {
				doLoad(_portalCacheManagerName, _portalCacheName);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to asynchronously stream bootstrap", e);
				}
			}
		}

		private final String _portalCacheManagerName;
		private final String _portalCacheName;

	}

}