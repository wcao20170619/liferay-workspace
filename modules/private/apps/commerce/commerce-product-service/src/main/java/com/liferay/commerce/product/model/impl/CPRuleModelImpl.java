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

import com.liferay.commerce.product.model.CPRule;
import com.liferay.commerce.product.model.CPRuleModel;
import com.liferay.commerce.product.model.CPRuleSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CPRule service. Represents a row in the &quot;CPRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPRuleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPRuleImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPRuleImpl
 * @see CPRule
 * @see CPRuleModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CPRuleModelImpl extends BaseModelImpl<CPRule>
	implements CPRuleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp rule model instance should use the {@link CPRule} interface instead.
	 */
	public static final String TABLE_NAME = "CPRule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CPRuleId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "active_", Types.BOOLEAN },
			{ "type_", Types.VARCHAR },
			{ "typeSettings", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CPRuleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table CPRule (CPRuleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,active_ BOOLEAN,type_ VARCHAR(75) null,typeSettings VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CPRule";
	public static final String ORDER_BY_JPQL = " ORDER BY cpRule.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CPRule.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPRule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPRule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPRule"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CPRule toModel(CPRuleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPRule model = new CPRuleImpl();

		model.setCPRuleId(soapModel.getCPRuleId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setActive(soapModel.getActive());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CPRule> toModels(CPRuleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CPRule> models = new ArrayList<CPRule>(soapModels.length);

		for (CPRuleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.product.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.model.CPRule"));

	public CPRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPRule.class;
	}

	@Override
	public String getModelClassName() {
		return CPRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CPRuleId", getCPRuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("active", getActive());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CPRuleId = (Long)attributes.get("CPRuleId");

		if (CPRuleId != null) {
			setCPRuleId(CPRuleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@JSON
	@Override
	public long getCPRuleId() {
		return _CPRuleId;
	}

	@Override
	public void setCPRuleId(long CPRuleId) {
		_CPRuleId = CPRuleId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPRule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPRule toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPRule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPRuleImpl cpRuleImpl = new CPRuleImpl();

		cpRuleImpl.setCPRuleId(getCPRuleId());
		cpRuleImpl.setGroupId(getGroupId());
		cpRuleImpl.setCompanyId(getCompanyId());
		cpRuleImpl.setUserId(getUserId());
		cpRuleImpl.setUserName(getUserName());
		cpRuleImpl.setCreateDate(getCreateDate());
		cpRuleImpl.setModifiedDate(getModifiedDate());
		cpRuleImpl.setName(getName());
		cpRuleImpl.setActive(getActive());
		cpRuleImpl.setType(getType());
		cpRuleImpl.setTypeSettings(getTypeSettings());

		cpRuleImpl.resetOriginalValues();

		return cpRuleImpl;
	}

	@Override
	public int compareTo(CPRule cpRule) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), cpRule.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPRule)) {
			return false;
		}

		CPRule cpRule = (CPRule)obj;

		long primaryKey = cpRule.getPrimaryKey();

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
		CPRuleModelImpl cpRuleModelImpl = this;

		cpRuleModelImpl._originalGroupId = cpRuleModelImpl._groupId;

		cpRuleModelImpl._setOriginalGroupId = false;

		cpRuleModelImpl._setModifiedDate = false;

		cpRuleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPRule> toCacheModel() {
		CPRuleCacheModel cpRuleCacheModel = new CPRuleCacheModel();

		cpRuleCacheModel.CPRuleId = getCPRuleId();

		cpRuleCacheModel.groupId = getGroupId();

		cpRuleCacheModel.companyId = getCompanyId();

		cpRuleCacheModel.userId = getUserId();

		cpRuleCacheModel.userName = getUserName();

		String userName = cpRuleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpRuleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			cpRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpRuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpRuleCacheModel.name = getName();

		String name = cpRuleCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cpRuleCacheModel.name = null;
		}

		cpRuleCacheModel.active = getActive();

		cpRuleCacheModel.type = getType();

		String type = cpRuleCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			cpRuleCacheModel.type = null;
		}

		cpRuleCacheModel.typeSettings = getTypeSettings();

		String typeSettings = cpRuleCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			cpRuleCacheModel.typeSettings = null;
		}

		return cpRuleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{CPRuleId=");
		sb.append(getCPRuleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.product.model.CPRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CPRuleId</column-name><column-value><![CDATA[");
		sb.append(getCPRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPRule.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPRule.class
		};
	private long _CPRuleId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private boolean _active;
	private String _type;
	private String _typeSettings;
	private long _columnBitmask;
	private CPRule _escapedModel;
}