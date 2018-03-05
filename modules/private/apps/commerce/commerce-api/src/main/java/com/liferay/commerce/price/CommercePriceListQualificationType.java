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

package com.liferay.commerce.price;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.model.CommercePriceList;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Locale;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
@ProviderType
public interface CommercePriceListQualificationType {

	public void contributeToDocument(
		CommercePriceList commercePriceList, Document document);

	public String getKey();

	public String getLabel(Locale locale);

	public boolean isQualified(
			long commercePriceListQualificationTypeRelId,
			ServiceContext serviceContext)
		throws PortalException;

	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws PortalException;

}