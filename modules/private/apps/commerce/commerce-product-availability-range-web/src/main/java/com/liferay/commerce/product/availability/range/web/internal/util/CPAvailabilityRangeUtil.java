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

package com.liferay.commerce.product.availability.range.web.internal.util;

import com.liferay.commerce.product.model.CPAvailabilityRange;
import com.liferay.commerce.product.util.comparator.CPAvailabilityRangeTitleComparator;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Alessio Antonio Rendina
 */
public class CPAvailabilityRangeUtil {

	public static OrderByComparator<CPAvailabilityRange>
		getCPAvailabilityRangeOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<CPAvailabilityRange> orderByComparator = null;

		if (orderByCol.equals("title")) {
			orderByComparator = new CPAvailabilityRangeTitleComparator(
				orderByAsc);
		}

		return orderByComparator;
	}

}