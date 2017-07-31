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

package com.liferay.commerce.address.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceCountry service. Represents a row in the &quot;CommerceCountry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.address.model.impl.CommerceCountryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.address.model.impl.CommerceCountryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceCountry
 * @see com.liferay.commerce.address.model.impl.CommerceCountryImpl
 * @see com.liferay.commerce.address.model.impl.CommerceCountryModelImpl
 * @generated
 */
@ProviderType
public interface CommerceCountryModel extends BaseModel<CommerceCountry>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce country model instance should use the {@link CommerceCountry} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce country.
	 *
	 * @return the primary key of this commerce country
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce country.
	 *
	 * @param primaryKey the primary key of this commerce country
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce country ID of this commerce country.
	 *
	 * @return the commerce country ID of this commerce country
	 */
	public long getCommerceCountryId();

	/**
	 * Sets the commerce country ID of this commerce country.
	 *
	 * @param commerceCountryId the commerce country ID of this commerce country
	 */
	public void setCommerceCountryId(long commerceCountryId);

	/**
	 * Returns the group ID of this commerce country.
	 *
	 * @return the group ID of this commerce country
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce country.
	 *
	 * @param groupId the group ID of this commerce country
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce country.
	 *
	 * @return the company ID of this commerce country
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce country.
	 *
	 * @param companyId the company ID of this commerce country
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce country.
	 *
	 * @return the user ID of this commerce country
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce country.
	 *
	 * @param userId the user ID of this commerce country
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce country.
	 *
	 * @return the user uuid of this commerce country
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce country.
	 *
	 * @param userUuid the user uuid of this commerce country
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce country.
	 *
	 * @return the user name of this commerce country
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce country.
	 *
	 * @param userName the user name of this commerce country
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce country.
	 *
	 * @return the create date of this commerce country
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce country.
	 *
	 * @param createDate the create date of this commerce country
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce country.
	 *
	 * @return the modified date of this commerce country
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce country.
	 *
	 * @param modifiedDate the modified date of this commerce country
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this commerce country.
	 *
	 * @return the name of this commerce country
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this commerce country.
	 *
	 * @param name the name of this commerce country
	 */
	public void setName(String name);

	/**
	 * Returns the allows billing of this commerce country.
	 *
	 * @return the allows billing of this commerce country
	 */
	public boolean getAllowsBilling();

	/**
	 * Returns <code>true</code> if this commerce country is allows billing.
	 *
	 * @return <code>true</code> if this commerce country is allows billing; <code>false</code> otherwise
	 */
	public boolean isAllowsBilling();

	/**
	 * Sets whether this commerce country is allows billing.
	 *
	 * @param allowsBilling the allows billing of this commerce country
	 */
	public void setAllowsBilling(boolean allowsBilling);

	/**
	 * Returns the allows shipping of this commerce country.
	 *
	 * @return the allows shipping of this commerce country
	 */
	public boolean getAllowsShipping();

	/**
	 * Returns <code>true</code> if this commerce country is allows shipping.
	 *
	 * @return <code>true</code> if this commerce country is allows shipping; <code>false</code> otherwise
	 */
	public boolean isAllowsShipping();

	/**
	 * Sets whether this commerce country is allows shipping.
	 *
	 * @param allowsShipping the allows shipping of this commerce country
	 */
	public void setAllowsShipping(boolean allowsShipping);

	/**
	 * Returns the two letters iso code of this commerce country.
	 *
	 * @return the two letters iso code of this commerce country
	 */
	@AutoEscape
	public String getTwoLettersISOCode();

	/**
	 * Sets the two letters iso code of this commerce country.
	 *
	 * @param twoLettersISOCode the two letters iso code of this commerce country
	 */
	public void setTwoLettersISOCode(String twoLettersISOCode);

	/**
	 * Returns the three letters iso code of this commerce country.
	 *
	 * @return the three letters iso code of this commerce country
	 */
	@AutoEscape
	public String getThreeLettersISOCode();

	/**
	 * Sets the three letters iso code of this commerce country.
	 *
	 * @param threeLettersISOCode the three letters iso code of this commerce country
	 */
	public void setThreeLettersISOCode(String threeLettersISOCode);

	/**
	 * Returns the numeric iso code of this commerce country.
	 *
	 * @return the numeric iso code of this commerce country
	 */
	public int getNumericISOCode();

	/**
	 * Sets the numeric iso code of this commerce country.
	 *
	 * @param numericISOCode the numeric iso code of this commerce country
	 */
	public void setNumericISOCode(int numericISOCode);

	/**
	 * Returns the priority of this commerce country.
	 *
	 * @return the priority of this commerce country
	 */
	public int getPriority();

	/**
	 * Sets the priority of this commerce country.
	 *
	 * @param priority the priority of this commerce country
	 */
	public void setPriority(int priority);

	/**
	 * Returns the published of this commerce country.
	 *
	 * @return the published of this commerce country
	 */
	public boolean getPublished();

	/**
	 * Returns <code>true</code> if this commerce country is published.
	 *
	 * @return <code>true</code> if this commerce country is published; <code>false</code> otherwise
	 */
	public boolean isPublished();

	/**
	 * Sets whether this commerce country is published.
	 *
	 * @param published the published of this commerce country
	 */
	public void setPublished(boolean published);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceCountry commerceCountry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceCountry> toCacheModel();

	@Override
	public CommerceCountry toEscapedModel();

	@Override
	public CommerceCountry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}