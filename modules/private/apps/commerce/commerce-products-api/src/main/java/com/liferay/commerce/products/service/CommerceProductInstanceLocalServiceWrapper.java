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

package com.liferay.commerce.products.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceProductInstanceLocalService}.
 *
 * @author Marco Leo
 * @see CommerceProductInstanceLocalService
 * @generated
 */
@ProviderType
public class CommerceProductInstanceLocalServiceWrapper
	implements CommerceProductInstanceLocalService,
		ServiceWrapper<CommerceProductInstanceLocalService> {
	public CommerceProductInstanceLocalServiceWrapper(
		CommerceProductInstanceLocalService commerceProductInstanceLocalService) {
		_commerceProductInstanceLocalService = commerceProductInstanceLocalService;
	}

	/**
	* Adds the commerce product instance to the database. Also notifies the appropriate model listeners.
	*
	* @param commerceProductInstance the commerce product instance
	* @return the commerce product instance that was added
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance addCommerceProductInstance(
		com.liferay.commerce.products.model.CommerceProductInstance commerceProductInstance) {
		return _commerceProductInstanceLocalService.addCommerceProductInstance(commerceProductInstance);
	}

	/**
	* Creates a new commerce product instance with the primary key. Does not add the commerce product instance to the database.
	*
	* @param commerceProductInstanceId the primary key for the new commerce product instance
	* @return the new commerce product instance
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance createCommerceProductInstance(
		long commerceProductInstanceId) {
		return _commerceProductInstanceLocalService.createCommerceProductInstance(commerceProductInstanceId);
	}

	/**
	* Deletes the commerce product instance from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceProductInstance the commerce product instance
	* @return the commerce product instance that was removed
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance deleteCommerceProductInstance(
		com.liferay.commerce.products.model.CommerceProductInstance commerceProductInstance) {
		return _commerceProductInstanceLocalService.deleteCommerceProductInstance(commerceProductInstance);
	}

	/**
	* Deletes the commerce product instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceProductInstanceId the primary key of the commerce product instance
	* @return the commerce product instance that was removed
	* @throws PortalException if a commerce product instance with the primary key could not be found
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance deleteCommerceProductInstance(
		long commerceProductInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceProductInstanceLocalService.deleteCommerceProductInstance(commerceProductInstanceId);
	}

	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance fetchCommerceProductInstance(
		long commerceProductInstanceId) {
		return _commerceProductInstanceLocalService.fetchCommerceProductInstance(commerceProductInstanceId);
	}

	/**
	* Returns the commerce product instance matching the UUID and group.
	*
	* @param uuid the commerce product instance's UUID
	* @param groupId the primary key of the group
	* @return the matching commerce product instance, or <code>null</code> if a matching commerce product instance could not be found
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance fetchCommerceProductInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _commerceProductInstanceLocalService.fetchCommerceProductInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the commerce product instance with the primary key.
	*
	* @param commerceProductInstanceId the primary key of the commerce product instance
	* @return the commerce product instance
	* @throws PortalException if a commerce product instance with the primary key could not be found
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance getCommerceProductInstance(
		long commerceProductInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceProductInstanceLocalService.getCommerceProductInstance(commerceProductInstanceId);
	}

	/**
	* Returns the commerce product instance matching the UUID and group.
	*
	* @param uuid the commerce product instance's UUID
	* @param groupId the primary key of the group
	* @return the matching commerce product instance
	* @throws PortalException if a matching commerce product instance could not be found
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance getCommerceProductInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceProductInstanceLocalService.getCommerceProductInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the commerce product instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commerceProductInstance the commerce product instance
	* @return the commerce product instance that was updated
	*/
	@Override
	public com.liferay.commerce.products.model.CommerceProductInstance updateCommerceProductInstance(
		com.liferay.commerce.products.model.CommerceProductInstance commerceProductInstance) {
		return _commerceProductInstanceLocalService.updateCommerceProductInstance(commerceProductInstance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _commerceProductInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commerceProductInstanceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _commerceProductInstanceLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _commerceProductInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceProductInstanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceProductInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of commerce product instances.
	*
	* @return the number of commerce product instances
	*/
	@Override
	public int getCommerceProductInstancesCount() {
		return _commerceProductInstanceLocalService.getCommerceProductInstancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commerceProductInstanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _commerceProductInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.products.model.impl.CommerceProductInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _commerceProductInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.products.model.impl.CommerceProductInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _commerceProductInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the commerce product instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.products.model.impl.CommerceProductInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commerce product instances
	* @param end the upper bound of the range of commerce product instances (not inclusive)
	* @return the range of commerce product instances
	*/
	@Override
	public java.util.List<com.liferay.commerce.products.model.CommerceProductInstance> getCommerceProductInstances(
		int start, int end) {
		return _commerceProductInstanceLocalService.getCommerceProductInstances(start,
			end);
	}

	/**
	* Returns all the commerce product instances matching the UUID and company.
	*
	* @param uuid the UUID of the commerce product instances
	* @param companyId the primary key of the company
	* @return the matching commerce product instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.commerce.products.model.CommerceProductInstance> getCommerceProductInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _commerceProductInstanceLocalService.getCommerceProductInstancesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of commerce product instances matching the UUID and company.
	*
	* @param uuid the UUID of the commerce product instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of commerce product instances
	* @param end the upper bound of the range of commerce product instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching commerce product instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.commerce.products.model.CommerceProductInstance> getCommerceProductInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.products.model.CommerceProductInstance> orderByComparator) {
		return _commerceProductInstanceLocalService.getCommerceProductInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _commerceProductInstanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _commerceProductInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public CommerceProductInstanceLocalService getWrappedService() {
		return _commerceProductInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		CommerceProductInstanceLocalService commerceProductInstanceLocalService) {
		_commerceProductInstanceLocalService = commerceProductInstanceLocalService;
	}

	private CommerceProductInstanceLocalService _commerceProductInstanceLocalService;
}