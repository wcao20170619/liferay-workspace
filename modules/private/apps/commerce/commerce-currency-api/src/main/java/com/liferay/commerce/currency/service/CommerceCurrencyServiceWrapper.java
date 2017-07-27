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

package com.liferay.commerce.currency.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceCurrencyService}.
 *
 * @author Andrea Di Giorgi
 * @see CommerceCurrencyService
 * @generated
 */
@ProviderType
public class CommerceCurrencyServiceWrapper implements CommerceCurrencyService,
	ServiceWrapper<CommerceCurrencyService> {
	public CommerceCurrencyServiceWrapper(
		CommerceCurrencyService commerceCurrencyService) {
		_commerceCurrencyService = commerceCurrencyService;
	}

	@Override
	public com.liferay.commerce.currency.model.CommerceCurrency addCommerceCurrency(
		java.util.Map<java.util.Locale, java.lang.String> codeMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap, double rate,
		java.lang.String roundingType, boolean primary, double priority,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceCurrencyService.addCommerceCurrency(codeMap, nameMap,
			rate, roundingType, primary, priority, active, serviceContext);
	}

	@Override
	public com.liferay.commerce.currency.model.CommerceCurrency fetchPrimaryCommerceCurrency(
		long groupId) {
		return _commerceCurrencyService.fetchPrimaryCommerceCurrency(groupId);
	}

	@Override
	public com.liferay.commerce.currency.model.CommerceCurrency getCommerceCurrency(
		long commerceCurrencyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceCurrencyService.getCommerceCurrency(commerceCurrencyId);
	}

	@Override
	public com.liferay.commerce.currency.model.CommerceCurrency updateCommerceCurrency(
		long commerceCurrencyId,
		java.util.Map<java.util.Locale, java.lang.String> codeMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap, double rate,
		java.lang.String roundingType, boolean primary, double priority,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceCurrencyService.updateCommerceCurrency(commerceCurrencyId,
			codeMap, nameMap, rate, roundingType, primary, priority, active,
			serviceContext);
	}

	@Override
	public int getCommerceCurrenciesCount(long groupId) {
		return _commerceCurrencyService.getCommerceCurrenciesCount(groupId);
	}

	@Override
	public int getCommerceCurrenciesCount(long groupId, boolean active) {
		return _commerceCurrencyService.getCommerceCurrenciesCount(groupId,
			active);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commerceCurrencyService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.commerce.currency.model.CommerceCurrency> getCommerceCurrencies(
		long groupId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.currency.model.CommerceCurrency> orderByComparator) {
		return _commerceCurrencyService.getCommerceCurrencies(groupId, active,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.commerce.currency.model.CommerceCurrency> getCommerceCurrencies(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.currency.model.CommerceCurrency> orderByComparator) {
		return _commerceCurrencyService.getCommerceCurrencies(groupId, start,
			end, orderByComparator);
	}

	@Override
	public void deleteCommerceCurrency(long commerceCurrencyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_commerceCurrencyService.deleteCommerceCurrency(commerceCurrencyId);
	}

	@Override
	public CommerceCurrencyService getWrappedService() {
		return _commerceCurrencyService;
	}

	@Override
	public void setWrappedService(
		CommerceCurrencyService commerceCurrencyService) {
		_commerceCurrencyService = commerceCurrencyService;
	}

	private CommerceCurrencyService _commerceCurrencyService;
}