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

package com.liferay.commerce.product.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alessio Antonio Rendina
 */
public interface CommerceStarterRegistry {

	public CommerceStarter getCommerceStarter(String key);

	public List<CommerceStarter> getCommerceStarters(
		boolean active, HttpServletRequest httpServletRequest);

	public List<CommerceStarter> getCommerceStarters(
		HttpServletRequest httpServletRequest);

	public CommerceStarter getNextCommerceStarter(
		String commerceStarterKey, boolean active,
		HttpServletRequest httpServletRequest);

	public CommerceStarter getPreviousCommerceStarter(
		String commerceStarterKey, boolean active,
		HttpServletRequest httpServletRequest);

}