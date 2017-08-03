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

package com.liferay.portal.reports.engine.console.web.admin.internal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Rafael Praxedes
 */
public class EntrySearchTerms extends EntryDisplayTerms {

	public EntrySearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		definitionName = DAOParamUtil.getString(
			portletRequest, DEFINITION_NAME);
		endDateDay = DAOParamUtil.getInteger(portletRequest, END_DATE_DAY);
		endDateMonth = DAOParamUtil.getInteger(portletRequest, END_DATE_MONTH);
		endDateYear = DAOParamUtil.getInteger(portletRequest, END_DATE_YEAR);
		startDateDay = DAOParamUtil.getInteger(portletRequest, START_DATE_DAY);
		startDateMonth = DAOParamUtil.getInteger(
			portletRequest, START_DATE_MONTH);
		startDateYear = DAOParamUtil.getInteger(
			portletRequest, START_DATE_YEAR);
		userName = DAOParamUtil.getString(portletRequest, USERNAME);
	}

}