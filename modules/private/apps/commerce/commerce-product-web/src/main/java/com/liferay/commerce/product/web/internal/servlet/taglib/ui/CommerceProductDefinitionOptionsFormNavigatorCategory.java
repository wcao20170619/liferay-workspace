/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.web.internal.servlet.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorCategory;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	property = {"form.navigator.category.order:Integer=80"},
	service = FormNavigatorCategory.class
)
public class CommerceProductDefinitionOptionsFormNavigatorCategory
	implements FormNavigatorCategory {

	@Override
	public String getFormNavigatorId() {
		return CommerceProductFormNavigatorConstants.
			FORM_NAVIGATOR_ID_COMMERCE_PRODUCT_DEFINITION;
	}

	@Override
	public String getKey() {
		return CommerceProductFormNavigatorConstants.
			CATEGORY_KEY_COMMERCE_PRODUCT_OPTIONS;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "options");
	}

}