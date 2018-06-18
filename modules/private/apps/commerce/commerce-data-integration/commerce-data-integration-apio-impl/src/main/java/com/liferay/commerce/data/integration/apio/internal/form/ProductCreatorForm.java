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

package com.liferay.commerce.data.integration.apio.internal.form;

import com.liferay.apio.architect.form.Form;
import com.liferay.apio.architect.form.Form.Builder;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Instances of this class represent the values extracted from a product form.
 *
 * @author Zoltán Takács
 * @review
 */
public class ProductCreatorForm {

	/**
	 * Builds a {@code Form} that generates {@code ProductCreatorForm} depending
	 * on the HTTP body.
	 *
	 * @param  formBuilder the {@code Form} builder
	 * @return a product creator form
	 * @review
	 */
	public static Form<ProductCreatorForm> buildForm(
		Builder<ProductCreatorForm> formBuilder) {

		return formBuilder.title(
			__ -> "The product creator form"
		).description(
			__ -> "This form can be used to create a product"
		).constructor(
			ProductCreatorForm::new
		).addOptionalLongList(
			"assetCategoryIds", ProductCreatorForm::_setAssetCategoryIds
		).addRequiredString(
			"description", ProductCreatorForm::_setDescription
		).addOptionalString(
			"shortDescription", ProductCreatorForm::_setShortDescription
		).addRequiredString(
			"productTypeName", ProductCreatorForm::_setProductTypeName
		).addRequiredString(
			"title", ProductCreatorForm::_setTitle
		).addRequiredString(
			"externalReferenceCode",
			ProductCreatorForm::_setExternalReferenceCode
		).build();
	}

	public List<Long> getAssetCategoryIds() {
		if (_assetCategoryIds == null) {
			return new ArrayList<>();
		}

		return _assetCategoryIds;
	}

	public Map<Locale, String> getDescriptionMap() {
		return Collections.singletonMap(LocaleUtil.getDefault(), _description);
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public String getProductTypeName() {
		return _productTypeName;
	}

	public Map<Locale, String> getShortDescriptionMap() {
		return Collections.singletonMap(LocaleUtil.getDefault(), _shortDescritpion);
	}

	public Map<Locale, String> getTitleMap() {
		return Collections.singletonMap(LocaleUtil.getDefault(), _title);
	}

	private void _setAssetCategoryIds(List<Long> assetCategoryIds) {
		_assetCategoryIds = assetCategoryIds;
	}

	private void _setDescription(String description) {
		_description = description;
	}

	private void _setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	private void _setProductTypeName(String productTypeName) {
		_productTypeName = productTypeName;
	}

	private void _setShortDescription(String shortDescription) {
		_shortDescritpion = shortDescription;
	}

	private void _setTitle(String title) {
		_title = title;
	}

	private List<Long> _assetCategoryIds;
	private String _description;
	private String _externalReferenceCode;
	private String _productTypeName;
	private String _shortDescritpion;
	private String _title;

}