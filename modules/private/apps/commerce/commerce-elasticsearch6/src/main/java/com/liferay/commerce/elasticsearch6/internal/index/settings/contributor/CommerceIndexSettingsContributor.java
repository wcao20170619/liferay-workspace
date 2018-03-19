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

package com.liferay.commerce.elasticsearch6.internal.index.settings.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.elasticsearch6.settings.IndexSettingsContributor;
import com.liferay.portal.search.elasticsearch6.settings.IndexSettingsHelper;
import com.liferay.portal.search.elasticsearch6.settings.TypeMappingsHelper;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marco Leo
 */
@Component(immediate = true)
public class CommerceIndexSettingsContributor
	implements IndexSettingsContributor {

	@Override
	public int compareTo(IndexSettingsContributor indexSettingsContributor) {
		if (getPriority() > indexSettingsContributor.getPriority()) {
			return 1;
		}
		else if (getPriority() == indexSettingsContributor.getPriority()) {
			return 0;
		}

		return -1;
	}

	@Override
	public void contribute(
		String indexName, TypeMappingsHelper typeMappingsHelper) {

		try {
			Class<?> clazz = getClass();

			String mappingsPath =
				"com/liferay/commerce/elasticsearch6/internal/index/settings" +
					"/contributor/AdditionalTypeMappings.json";

			String mappings = StringUtil.read(
				clazz.getClassLoader(), mappingsPath, false);

			typeMappingsHelper.addTypeMappings(indexName, mappings);
		}
		catch (IOException ioe) {
			_log.error("Could not load AdditionalTypeMappings.json", ioe);
		}
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public void populate(IndexSettingsHelper indexSettingsHelper) {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceIndexSettingsContributor.class);

}