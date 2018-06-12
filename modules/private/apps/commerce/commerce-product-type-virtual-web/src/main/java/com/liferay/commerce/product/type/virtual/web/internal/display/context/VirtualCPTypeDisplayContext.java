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

package com.liferay.commerce.product.type.virtual.web.internal.display.context;

import com.liferay.asset.kernel.service.AssetCategoryService;
import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.content.web.configuration.CPContentConfigurationHelper;
import com.liferay.commerce.product.content.web.display.context.CPTypeDisplayContext;
import com.liferay.commerce.product.service.CPAttachmentFileEntryService;
import com.liferay.commerce.product.service.CPDefinitionSpecificationOptionValueService;
import com.liferay.commerce.product.service.CPOptionCategoryService;
import com.liferay.commerce.product.type.virtual.model.CPDefinitionVirtualSetting;
import com.liferay.commerce.product.type.virtual.service.CPDefinitionVirtualSettingLocalService;
import com.liferay.commerce.product.util.CPContentContributorRegistry;
import com.liferay.commerce.product.util.CPInstanceHelper;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco Leo
 */
public class VirtualCPTypeDisplayContext extends CPTypeDisplayContext {

	public VirtualCPTypeDisplayContext(
			AssetCategoryService assetCategoryService,
			CPAttachmentFileEntryService cpAttachmentFileEntryService,
			CPCatalogEntry cpCatalogEntry,
			CPContentConfigurationHelper cpContentConfigurationHelper,
			CPContentContributorRegistry cpContentContributorRegistry,
			CPDefinitionVirtualSettingLocalService
				cpDefinitionVirtualSettingLocalService,
			DLAppService dlAppService, CPInstanceHelper cpInstanceHelper,
			CPDefinitionSpecificationOptionValueService
				cpDefinitionSpecificationOptionValueService,
			CPOptionCategoryService cpOptionCategoryService,
			HttpServletRequest httpServletRequest, Portal portal)
		throws Exception {

		super(
			assetCategoryService, cpAttachmentFileEntryService, cpCatalogEntry,
			cpContentConfigurationHelper, cpContentContributorRegistry,
			cpInstanceHelper, cpDefinitionSpecificationOptionValueService,
			cpOptionCategoryService, httpServletRequest, portal);

		_dlAppService = dlAppService;

		_cpDefinitionVirtualSetting =
			cpDefinitionVirtualSettingLocalService.
				fetchCPDefinitionVirtualSettingByCPDefinitionId(
					cpCatalogEntry.getCPDefinitionId());
	}

	public CPDefinitionVirtualSetting getCPDefinitionVirtualSetting() {
		return _cpDefinitionVirtualSetting;
	}

	public String getSampleURL(ThemeDisplay themeDisplay)
		throws PortalException {

		if (!_cpDefinitionVirtualSetting.isUseSample()) {
			return StringPool.BLANK;
		}

		if (_cpDefinitionVirtualSetting.isUseSampleUrl()) {
			return _cpDefinitionVirtualSetting.getSampleUrl();
		}

		FileEntry fileEntry = _dlAppService.getFileEntry(
			_cpDefinitionVirtualSetting.getSampleFileEntryId());

		return DLUtil.getDownloadURL(
			fileEntry, fileEntry.getFileVersion(), themeDisplay,
			StringPool.BLANK);
	}

	public boolean hasSampleURL() {
		return _cpDefinitionVirtualSetting.isUseSample();
	}

	private final CPDefinitionVirtualSetting _cpDefinitionVirtualSetting;
	private final DLAppService _dlAppService;

}