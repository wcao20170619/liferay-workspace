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

package com.liferay.commerce.service.impl;

import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.base.CommerceOrderItemServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;

/**
 * @author Andrea Di Giorgi
 */
public class CommerceOrderItemServiceImpl
	extends CommerceOrderItemServiceBaseImpl {

	@Override
	public void deleteCommerceOrderItem(long commerceOrderItemId)
		throws PortalException {

		CommerceOrderItem commerceOrderItem =
			commerceOrderItemLocalService.getCommerceOrderItem(
				commerceOrderItemId);

		checkCommerceOrder(commerceOrderItem.getCommerceOrderId());

		commerceOrderItemLocalService.deleteCommerceOrderItem(
			commerceOrderItem);
	}

	@Override
	public BaseModelSearchResult<CommerceOrderItem> search(
			long commerceOrderId, String keywords, int start, int end,
			Sort sort)
		throws PortalException {

		checkCommerceOrder(commerceOrderId);

		return commerceOrderItemLocalService.search(
			commerceOrderId, keywords, start, end, sort);
	}

	@Override
	public BaseModelSearchResult<CommerceOrderItem> search(
			long commerceOrderId, String sku, String title, boolean andOperator,
			int start, int end, Sort sort)
		throws PortalException {

		checkCommerceOrder(commerceOrderId);

		return commerceOrderItemLocalService.search(
			commerceOrderId, sku, title, andOperator, start, end, sort);
	}

	protected void checkCommerceOrder(long commerceOrderId)
		throws PortalException {

		commerceOrderService.getCommerceOrder(commerceOrderId);
	}

}