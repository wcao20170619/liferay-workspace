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

package com.liferay.vldap.server.internal.directory.ldap;

import com.liferay.portal.kernel.model.Company;

/**
 * @author Brian Wing Shun Chan
 * @author Jonathan Potter
 */
public class CommunitiesDirectory extends Directory {

	public CommunitiesDirectory(String top, Company company) {
		addAttribute("objectclass", "organizationalUnit");
		addAttribute("objectclass", "top");
		addAttribute("ou", "Communities");

		setName(top, company, "Communities");
	}

}