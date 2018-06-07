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

package com.liferay.commerce.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceWarehouseService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommerceWarehouseService
 * @generated
 */
@ProviderType
public class CommerceWarehouseServiceWrapper implements CommerceWarehouseService,
	ServiceWrapper<CommerceWarehouseService> {
	public CommerceWarehouseServiceWrapper(
		CommerceWarehouseService commerceWarehouseService) {
		_commerceWarehouseService = commerceWarehouseService;
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse addCommerceWarehouse(
		String name, String description, boolean active, String street1,
		String street2, String street3, String city, String zip,
		long commerceRegionId, long commerceCountryId, double latitude,
		double longitude,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.addCommerceWarehouse(name,
			description, active, street1, street2, street3, city, zip,
			commerceRegionId, commerceCountryId, latitude, longitude,
			serviceContext);
	}

	@Override
	public void deleteCommerceWarehouse(long commerceWarehouseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_commerceWarehouseService.deleteCommerceWarehouse(commerceWarehouseId);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse fetchDefaultCommerceWarehouse(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.fetchDefaultCommerceWarehouse(groupId);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse geolocateCommerceWarehouse(
		long commerceWarehouseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.geolocateCommerceWarehouse(commerceWarehouseId);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse getCommerceWarehouse(
		long commerceWarehouseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.getCommerceWarehouse(commerceWarehouseId);
	}

	@Override
	public java.util.List<com.liferay.commerce.model.CommerceWarehouse> getCommerceWarehouses(
		long groupId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.model.CommerceWarehouse> orderByComparator) {
		return _commerceWarehouseService.getCommerceWarehouses(groupId, active,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.commerce.model.CommerceWarehouse> getCommerceWarehouses(
		long groupId, boolean active, long commerceCountryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.model.CommerceWarehouse> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.getCommerceWarehouses(groupId, active,
			commerceCountryId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.commerce.model.CommerceWarehouse> getCommerceWarehouses(
		long groupId, long commerceCountryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.model.CommerceWarehouse> orderByComparator) {
		return _commerceWarehouseService.getCommerceWarehouses(groupId,
			commerceCountryId, start, end, orderByComparator);
	}

	@Override
	public int getCommerceWarehousesCount(long groupId, boolean active,
		long commerceCountryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.getCommerceWarehousesCount(groupId,
			active, commerceCountryId);
	}

	@Override
	public int getCommerceWarehousesCount(long groupId, long commerceCountryId) {
		return _commerceWarehouseService.getCommerceWarehousesCount(groupId,
			commerceCountryId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _commerceWarehouseService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.commerce.model.CommerceWarehouse> search(
		long groupId, String keywords, boolean all, long commerceCountryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.model.CommerceWarehouse> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.search(groupId, keywords, all,
			commerceCountryId, start, end, orderByComparator);
	}

	@Override
	public int searchCount(long groupId, String keywords, Boolean active,
		long commerceCountryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.searchCount(groupId, keywords, active,
			commerceCountryId);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse setActive(
		long commerceWarehouseId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.setActive(commerceWarehouseId, active);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse updateCommerceWarehouse(
		long commerceWarehouseId, String name, String description,
		boolean active, String street1, String street2, String street3,
		String city, String zip, long commerceRegionId, long commerceCountryId,
		double latitude, double longitude,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.updateCommerceWarehouse(commerceWarehouseId,
			name, description, active, street1, street2, street3, city, zip,
			commerceRegionId, commerceCountryId, latitude, longitude,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceWarehouse updateDefaultCommerceWarehouse(
		String name, String street1, String street2, String street3,
		String city, String zip, long commerceRegionId, long commerceCountryId,
		double latitude, double longitude,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceWarehouseService.updateDefaultCommerceWarehouse(name,
			street1, street2, street3, city, zip, commerceRegionId,
			commerceCountryId, latitude, longitude, serviceContext);
	}

	@Override
	public CommerceWarehouseService getWrappedService() {
		return _commerceWarehouseService;
	}

	@Override
	public void setWrappedService(
		CommerceWarehouseService commerceWarehouseService) {
		_commerceWarehouseService = commerceWarehouseService;
	}

	private CommerceWarehouseService _commerceWarehouseService;
}