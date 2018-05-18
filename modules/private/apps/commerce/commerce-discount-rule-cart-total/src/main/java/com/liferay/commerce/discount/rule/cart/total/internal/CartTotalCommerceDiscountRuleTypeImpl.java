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

package com.liferay.commerce.discount.rule.cart.total.internal;

import com.liferay.commerce.discount.model.CommerceDiscountRuleConstants;
import com.liferay.commerce.discount.rule.type.CommerceDiscountRuleType;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	immediate = true,
	property = {
		"commerce.discount.rule.type.key=" + CommerceDiscountRuleConstants.TYPE_CART_TOTAL,
		"commerce.discount.rule.type.order:Integer=10"
	},
	service = CommerceDiscountRuleType.class
)
public class CartTotalCommerceDiscountRuleTypeImpl
	implements CommerceDiscountRuleType {

	@Override
	public boolean evaluate(CommerceOrder commerceOrder) {
		return false;
	}

	@Override
	public String getKey() {
		return CommerceDiscountRuleConstants.TYPE_CART_TOTAL;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			locale, CommerceDiscountRuleConstants.TYPE_CART_TOTAL);
	}

}