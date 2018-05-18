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

package com.liferay.commerce.product.service.impl;

import com.liferay.commerce.product.constants.CPActionKeys;
import com.liferay.commerce.product.model.CPMeasurementUnit;
import com.liferay.commerce.product.service.base.CPMeasurementUnitServiceBaseImpl;
import com.liferay.commerce.product.service.permission.CPMeasurementUnitPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
public class CPMeasurementUnitServiceImpl
	extends CPMeasurementUnitServiceBaseImpl {

	@Override
	public CPMeasurementUnit addCPMeasurementUnit(
			Map<Locale, String> nameMap, String key, double rate,
			boolean primary, double priority, int type,
			ServiceContext serviceContext)
		throws PortalException {

		CPMeasurementUnitPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_MEASUREMENT_UNITS);

		return cpMeasurementUnitLocalService.addCPMeasurementUnit(
			nameMap, key, rate, primary, priority, type, serviceContext);
	}

	@Override
	public void deleteCPMeasurementUnit(long cpMeasurementUnitId)
		throws PortalException {

		CPMeasurementUnit cpMeasurementUnit =
			cpMeasurementUnitPersistence.findByPrimaryKey(cpMeasurementUnitId);

		CPMeasurementUnitPermission.check(
			getPermissionChecker(), cpMeasurementUnit.getGroupId(),
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_MEASUREMENT_UNITS);

		cpMeasurementUnitLocalService.deleteCPMeasurementUnit(
			cpMeasurementUnit);
	}

	@Override
	public CPMeasurementUnit fetchPrimaryCPMeasurementUnit(
		long groupId, int type) {

		return cpMeasurementUnitLocalService.fetchPrimaryCPMeasurementUnit(
			groupId, type);
	}

	@Override
	public CPMeasurementUnit getCPMeasurementUnit(long cpMeasurementUnitId)
		throws PortalException {

		return cpMeasurementUnitLocalService.getCPMeasurementUnit(
			cpMeasurementUnitId);
	}

	@Override
	public List<CPMeasurementUnit> getCPMeasurementUnits(
		long groupId, int type, int start, int end,
		OrderByComparator<CPMeasurementUnit> orderByComparator) {

		return cpMeasurementUnitLocalService.getCPMeasurementUnits(
			groupId, type, start, end, orderByComparator);
	}

	@Override
	public int getCPMeasurementUnitsCount(long groupId, int type) {
		return cpMeasurementUnitLocalService.getCPMeasurementUnitsCount(
			groupId, type);
	}

	@Override
	public CPMeasurementUnit updateCPMeasurementUnit(
			long cpMeasurementUnitId, Map<Locale, String> nameMap, String key,
			double rate, boolean primary, double priority, int type,
			ServiceContext serviceContext)
		throws PortalException {

		CPMeasurementUnit cpMeasurementUnit =
			cpMeasurementUnitPersistence.findByPrimaryKey(cpMeasurementUnitId);

		CPMeasurementUnitPermission.check(
			getPermissionChecker(), cpMeasurementUnit.getGroupId(),
			CPActionKeys.MANAGE_COMMERCE_PRODUCT_MEASUREMENT_UNITS);

		return cpMeasurementUnitLocalService.updateCPMeasurementUnit(
			cpMeasurementUnitId, nameMap, key, rate, primary, priority, type,
			serviceContext);
	}

}