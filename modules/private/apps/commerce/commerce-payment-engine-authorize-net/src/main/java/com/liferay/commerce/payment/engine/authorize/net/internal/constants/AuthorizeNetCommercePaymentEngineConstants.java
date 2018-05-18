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

package com.liferay.commerce.payment.engine.authorize.net.internal.constants;

import com.liferay.portal.kernel.util.StringUtil;

import net.authorize.Environment;

/**
 * @author Andrea Di Giorgi
 */
public class AuthorizeNetCommercePaymentEngineConstants {

	public static final String[] ENVIRONMENTS = {
		StringUtil.toLowerCase(Environment.PRODUCTION.name()),
		StringUtil.toLowerCase(Environment.SANDBOX.name())
	};

	public static final String SERVICE_NAME =
		"com.liferay.commerce.payment.engine.authorize.net";

}