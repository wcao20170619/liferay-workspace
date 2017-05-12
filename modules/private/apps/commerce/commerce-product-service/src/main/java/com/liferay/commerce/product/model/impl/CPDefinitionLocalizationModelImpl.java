/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CPDefinitionLocalization;
import com.liferay.commerce.product.model.CPDefinitionLocalizationModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CPDefinitionLocalization service. Represents a row in the &quot;CPDefinitionLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPDefinitionLocalizationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionLocalizationImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionLocalizationImpl
 * @see CPDefinitionLocalization
 * @see CPDefinitionLocalizationModel
 * @generated
 */
@ProviderType
public class CPDefinitionLocalizationModelImpl extends BaseModelImpl<CPDefinitionLocalization>
	implements CPDefinitionLocalizationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition localization model instance should use the {@link CPDefinitionLocalization} interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionLocalization";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "cpDefinitionLocalizationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "cpDefinitionPK", Types.BIGINT },
			{ "languageId", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "urlTitle", Types.VARCHAR },
			{ "shortDescription", Types.VARCHAR },
			{ "description", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cpDefinitionLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cpDefinitionPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("urlTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table CPDefinitionLocalization (mvccVersion LONG default 0 not null,cpDefinitionLocalizationId LONG not null primary key,companyId LONG,cpDefinitionPK LONG,languageId VARCHAR(75) null,title VARCHAR(75) null,urlTitle VARCHAR(75) null,shortDescription VARCHAR(75) null,description TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table CPDefinitionLocalization";
	public static final String ORDER_BY_JPQL = " ORDER BY cpDefinitionLocalization.cpDefinitionLocalizationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPDefinitionLocalization.cpDefinitionLocalizationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPDefinitionLocalization"),
			true);
	public static final long CPDEFINITIONPK_COLUMN_BITMASK = 1L;
	public static final long LANGUAGEID_COLUMN_BITMASK = 2L;
	public static final long CPDEFINITIONLOCALIZATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.product.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionLocalization"));

	public CPDefinitionLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCpDefinitionLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("cpDefinitionLocalizationId",
			getCpDefinitionLocalizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("cpDefinitionPK", getCpDefinitionPK());
		attributes.put("languageId", getLanguageId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("description", getDescription());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long cpDefinitionLocalizationId = (Long)attributes.get(
				"cpDefinitionLocalizationId");

		if (cpDefinitionLocalizationId != null) {
			setCpDefinitionLocalizationId(cpDefinitionLocalizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long cpDefinitionPK = (Long)attributes.get("cpDefinitionPK");

		if (cpDefinitionPK != null) {
			setCpDefinitionPK(cpDefinitionPK);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getCpDefinitionLocalizationId() {
		return _cpDefinitionLocalizationId;
	}

	@Override
	public void setCpDefinitionLocalizationId(long cpDefinitionLocalizationId) {
		_cpDefinitionLocalizationId = cpDefinitionLocalizationId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getCpDefinitionPK() {
		return _cpDefinitionPK;
	}

	@Override
	public void setCpDefinitionPK(long cpDefinitionPK) {
		_columnBitmask |= CPDEFINITIONPK_COLUMN_BITMASK;

		if (!_setOriginalCpDefinitionPK) {
			_setOriginalCpDefinitionPK = true;

			_originalCpDefinitionPK = _cpDefinitionPK;
		}

		_cpDefinitionPK = cpDefinitionPK;
	}

	public long getOriginalCpDefinitionPK() {
		return _originalCpDefinitionPK;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getUrlTitle() {
		if (_urlTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _urlTitle;
		}
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	@Override
	public String getShortDescription() {
		if (_shortDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _shortDescription;
		}
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPDefinitionLocalization.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDefinitionLocalization toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPDefinitionLocalization)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDefinitionLocalizationImpl cpDefinitionLocalizationImpl = new CPDefinitionLocalizationImpl();

		cpDefinitionLocalizationImpl.setMvccVersion(getMvccVersion());
		cpDefinitionLocalizationImpl.setCpDefinitionLocalizationId(getCpDefinitionLocalizationId());
		cpDefinitionLocalizationImpl.setCompanyId(getCompanyId());
		cpDefinitionLocalizationImpl.setCpDefinitionPK(getCpDefinitionPK());
		cpDefinitionLocalizationImpl.setLanguageId(getLanguageId());
		cpDefinitionLocalizationImpl.setTitle(getTitle());
		cpDefinitionLocalizationImpl.setUrlTitle(getUrlTitle());
		cpDefinitionLocalizationImpl.setShortDescription(getShortDescription());
		cpDefinitionLocalizationImpl.setDescription(getDescription());

		cpDefinitionLocalizationImpl.resetOriginalValues();

		return cpDefinitionLocalizationImpl;
	}

	@Override
	public int compareTo(CPDefinitionLocalization cpDefinitionLocalization) {
		long primaryKey = cpDefinitionLocalization.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPDefinitionLocalization)) {
			return false;
		}

		CPDefinitionLocalization cpDefinitionLocalization = (CPDefinitionLocalization)obj;

		long primaryKey = cpDefinitionLocalization.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CPDefinitionLocalizationModelImpl cpDefinitionLocalizationModelImpl = this;

		cpDefinitionLocalizationModelImpl._originalCpDefinitionPK = cpDefinitionLocalizationModelImpl._cpDefinitionPK;

		cpDefinitionLocalizationModelImpl._setOriginalCpDefinitionPK = false;

		cpDefinitionLocalizationModelImpl._originalLanguageId = cpDefinitionLocalizationModelImpl._languageId;

		cpDefinitionLocalizationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionLocalization> toCacheModel() {
		CPDefinitionLocalizationCacheModel cpDefinitionLocalizationCacheModel = new CPDefinitionLocalizationCacheModel();

		cpDefinitionLocalizationCacheModel.mvccVersion = getMvccVersion();

		cpDefinitionLocalizationCacheModel.cpDefinitionLocalizationId = getCpDefinitionLocalizationId();

		cpDefinitionLocalizationCacheModel.companyId = getCompanyId();

		cpDefinitionLocalizationCacheModel.cpDefinitionPK = getCpDefinitionPK();

		cpDefinitionLocalizationCacheModel.languageId = getLanguageId();

		String languageId = cpDefinitionLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			cpDefinitionLocalizationCacheModel.languageId = null;
		}

		cpDefinitionLocalizationCacheModel.title = getTitle();

		String title = cpDefinitionLocalizationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			cpDefinitionLocalizationCacheModel.title = null;
		}

		cpDefinitionLocalizationCacheModel.urlTitle = getUrlTitle();

		String urlTitle = cpDefinitionLocalizationCacheModel.urlTitle;

		if ((urlTitle != null) && (urlTitle.length() == 0)) {
			cpDefinitionLocalizationCacheModel.urlTitle = null;
		}

		cpDefinitionLocalizationCacheModel.shortDescription = getShortDescription();

		String shortDescription = cpDefinitionLocalizationCacheModel.shortDescription;

		if ((shortDescription != null) && (shortDescription.length() == 0)) {
			cpDefinitionLocalizationCacheModel.shortDescription = null;
		}

		cpDefinitionLocalizationCacheModel.description = getDescription();

		String description = cpDefinitionLocalizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cpDefinitionLocalizationCacheModel.description = null;
		}

		return cpDefinitionLocalizationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", cpDefinitionLocalizationId=");
		sb.append(getCpDefinitionLocalizationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", cpDefinitionPK=");
		sb.append(getCpDefinitionPK());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.product.model.CPDefinitionLocalization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpDefinitionLocalizationId</column-name><column-value><![CDATA[");
		sb.append(getCpDefinitionLocalizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpDefinitionPK</column-name><column-value><![CDATA[");
		sb.append(getCpDefinitionPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPDefinitionLocalization.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPDefinitionLocalization.class
		};
	private long _mvccVersion;
	private long _cpDefinitionLocalizationId;
	private long _companyId;
	private long _cpDefinitionPK;
	private long _originalCpDefinitionPK;
	private boolean _setOriginalCpDefinitionPK;
	private String _languageId;
	private String _originalLanguageId;
	private String _title;
	private String _urlTitle;
	private String _shortDescription;
	private String _description;
	private long _columnBitmask;
	private CPDefinitionLocalization _escapedModel;
}