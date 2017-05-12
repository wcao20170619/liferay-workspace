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

package com.liferay.commerce.product.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the CPDefinitionLocalization service. Represents a row in the &quot;CPDefinitionLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.product.model.impl.CPDefinitionLocalizationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.product.model.impl.CPDefinitionLocalizationImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionLocalization
 * @see com.liferay.commerce.product.model.impl.CPDefinitionLocalizationImpl
 * @see com.liferay.commerce.product.model.impl.CPDefinitionLocalizationModelImpl
 * @generated
 */
@ProviderType
public interface CPDefinitionLocalizationModel extends BaseModel<CPDefinitionLocalization>,
	MVCCModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cp definition localization model instance should use the {@link CPDefinitionLocalization} interface instead.
	 */

	/**
	 * Returns the primary key of this cp definition localization.
	 *
	 * @return the primary key of this cp definition localization
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cp definition localization.
	 *
	 * @param primaryKey the primary key of this cp definition localization
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this cp definition localization.
	 *
	 * @return the mvcc version of this cp definition localization
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this cp definition localization.
	 *
	 * @param mvccVersion the mvcc version of this cp definition localization
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the cp definition localization ID of this cp definition localization.
	 *
	 * @return the cp definition localization ID of this cp definition localization
	 */
	public long getCpDefinitionLocalizationId();

	/**
	 * Sets the cp definition localization ID of this cp definition localization.
	 *
	 * @param cpDefinitionLocalizationId the cp definition localization ID of this cp definition localization
	 */
	public void setCpDefinitionLocalizationId(long cpDefinitionLocalizationId);

	/**
	 * Returns the company ID of this cp definition localization.
	 *
	 * @return the company ID of this cp definition localization
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cp definition localization.
	 *
	 * @param companyId the company ID of this cp definition localization
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the cp definition pk of this cp definition localization.
	 *
	 * @return the cp definition pk of this cp definition localization
	 */
	public long getCpDefinitionPK();

	/**
	 * Sets the cp definition pk of this cp definition localization.
	 *
	 * @param cpDefinitionPK the cp definition pk of this cp definition localization
	 */
	public void setCpDefinitionPK(long cpDefinitionPK);

	/**
	 * Returns the language ID of this cp definition localization.
	 *
	 * @return the language ID of this cp definition localization
	 */
	@AutoEscape
	public String getLanguageId();

	/**
	 * Sets the language ID of this cp definition localization.
	 *
	 * @param languageId the language ID of this cp definition localization
	 */
	public void setLanguageId(String languageId);

	/**
	 * Returns the title of this cp definition localization.
	 *
	 * @return the title of this cp definition localization
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this cp definition localization.
	 *
	 * @param title the title of this cp definition localization
	 */
	public void setTitle(String title);

	/**
	 * Returns the url title of this cp definition localization.
	 *
	 * @return the url title of this cp definition localization
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this cp definition localization.
	 *
	 * @param urlTitle the url title of this cp definition localization
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the short description of this cp definition localization.
	 *
	 * @return the short description of this cp definition localization
	 */
	@AutoEscape
	public String getShortDescription();

	/**
	 * Sets the short description of this cp definition localization.
	 *
	 * @param shortDescription the short description of this cp definition localization
	 */
	public void setShortDescription(String shortDescription);

	/**
	 * Returns the description of this cp definition localization.
	 *
	 * @return the description of this cp definition localization
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this cp definition localization.
	 *
	 * @param description the description of this cp definition localization
	 */
	public void setDescription(String description);

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
	public int compareTo(CPDefinitionLocalization cpDefinitionLocalization);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CPDefinitionLocalization> toCacheModel();

	@Override
	public CPDefinitionLocalization toEscapedModel();

	@Override
	public CPDefinitionLocalization toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}