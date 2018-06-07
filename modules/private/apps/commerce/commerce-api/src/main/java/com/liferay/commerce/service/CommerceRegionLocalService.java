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

import com.liferay.commerce.model.CommerceRegion;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for CommerceRegion. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Alessio Antonio Rendina
 * @see CommerceRegionLocalServiceUtil
 * @see com.liferay.commerce.service.base.CommerceRegionLocalServiceBaseImpl
 * @see com.liferay.commerce.service.impl.CommerceRegionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CommerceRegionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommerceRegionLocalServiceUtil} to access the commerce region local service. Add custom service methods to {@link com.liferay.commerce.service.impl.CommerceRegionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the commerce region to the database. Also notifies the appropriate model listeners.
	*
	* @param commerceRegion the commerce region
	* @return the commerce region that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CommerceRegion addCommerceRegion(CommerceRegion commerceRegion);

	public CommerceRegion addCommerceRegion(long commerceCountryId,
		String name, String code, double priority, boolean active,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new commerce region with the primary key. Does not add the commerce region to the database.
	*
	* @param commerceRegionId the primary key for the new commerce region
	* @return the new commerce region
	*/
	@Transactional(enabled = false)
	public CommerceRegion createCommerceRegion(long commerceRegionId);

	/**
	* Deletes the commerce region from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceRegion the commerce region
	* @return the commerce region that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CommerceRegion deleteCommerceRegion(CommerceRegion commerceRegion)
		throws PortalException;

	/**
	* Deletes the commerce region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commerceRegionId the primary key of the commerce region
	* @return the commerce region that was removed
	* @throws PortalException if a commerce region with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CommerceRegion deleteCommerceRegion(long commerceRegionId)
		throws PortalException;

	public void deleteCommerceRegions(long commerceCountryId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.model.impl.CommerceRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.model.impl.CommerceRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommerceRegion fetchCommerceRegion(long commerceRegionId);

	/**
	* Returns the commerce region matching the UUID and group.
	*
	* @param uuid the commerce region's UUID
	* @param groupId the primary key of the group
	* @return the matching commerce region, or <code>null</code> if a matching commerce region could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommerceRegion fetchCommerceRegionByUuidAndGroupId(String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the commerce region with the primary key.
	*
	* @param commerceRegionId the primary key of the commerce region
	* @return the commerce region
	* @throws PortalException if a commerce region with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommerceRegion getCommerceRegion(long commerceRegionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommerceRegion getCommerceRegion(long commerceCountryId, String code)
		throws PortalException;

	/**
	* Returns the commerce region matching the UUID and group.
	*
	* @param uuid the commerce region's UUID
	* @param groupId the primary key of the group
	* @return the matching commerce region
	* @throws PortalException if a matching commerce region could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommerceRegion getCommerceRegionByUuidAndGroupId(String uuid,
		long groupId) throws PortalException;

	/**
	* Returns a range of all the commerce regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.model.impl.CommerceRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of commerce regions
	* @param end the upper bound of the range of commerce regions (not inclusive)
	* @return the range of commerce regions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegions(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegions(long commerceCountryId,
		boolean active);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegions(long commerceCountryId,
		boolean active, int start, int end,
		OrderByComparator<CommerceRegion> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegions(long commerceCountryId,
		int start, int end, OrderByComparator<CommerceRegion> orderByComparator);

	/**
	* Returns all the commerce regions matching the UUID and company.
	*
	* @param uuid the UUID of the commerce regions
	* @param companyId the primary key of the company
	* @return the matching commerce regions, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegionsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	* Returns a range of commerce regions matching the UUID and company.
	*
	* @param uuid the UUID of the commerce regions
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of commerce regions
	* @param end the upper bound of the range of commerce regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching commerce regions, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommerceRegion> getCommerceRegionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommerceRegion> orderByComparator);

	/**
	* Returns the number of commerce regions.
	*
	* @return the number of commerce regions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCommerceRegionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCommerceRegionsCount(long commerceCountryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCommerceRegionsCount(long commerceCountryId, boolean active);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public CommerceRegion setActive(long commerceRegionId, boolean active)
		throws PortalException;

	/**
	* Updates the commerce region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commerceRegion the commerce region
	* @return the commerce region that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CommerceRegion updateCommerceRegion(CommerceRegion commerceRegion);

	public CommerceRegion updateCommerceRegion(long commerceRegionId,
		String name, String code, double priority, boolean active,
		ServiceContext serviceContext) throws PortalException;
}