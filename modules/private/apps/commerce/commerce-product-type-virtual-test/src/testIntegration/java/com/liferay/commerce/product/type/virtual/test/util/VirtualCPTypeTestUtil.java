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

package com.liferay.commerce.product.type.virtual.test.util;

import com.liferay.commerce.product.type.virtual.model.CPDefinitionVirtualSetting;
import com.liferay.commerce.product.type.virtual.service.CPDefinitionVirtualSettingLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.test.util.DDMStructureTestUtil;
import com.liferay.dynamic.data.mapping.test.util.DDMTemplateTestUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author Andrea Di Giorgi
 */
public class VirtualCPTypeTestUtil {

	public static CPDefinitionVirtualSetting addCPDefinitionVirtualSetting(
			long groupId, long cpDefinitionId, long fileEntryId,
			long sampleFileEntryId,
			long termsOfUseJournalArticleResourcePrimKey)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(groupId);

		String url = null;

		if (fileEntryId <= 0) {
			url = "http://www.example.com/download";
		}

		String sampleUrl = null;

		if (sampleFileEntryId <= 0) {
			sampleUrl = "http://www.example.com/sample";
		}

		Map<Locale, String> termsOfUseContentMap = null;

		if (termsOfUseJournalArticleResourcePrimKey <= 0) {
			termsOfUseContentMap = RandomTestUtil.randomLocaleStringMap();
		}

		return CPDefinitionVirtualSettingLocalServiceUtil.
			addCPDefinitionVirtualSetting(
				cpDefinitionId, fileEntryId, url, RandomTestUtil.randomString(),
				RandomTestUtil.randomInt(), RandomTestUtil.randomInt(), true,
				sampleFileEntryId, sampleUrl, true, termsOfUseContentMap,
				termsOfUseJournalArticleResourcePrimKey, serviceContext);
	}

	public static JournalArticle addJournalArticle(long groupId)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(groupId);

		Map<Locale, String> contentMap = RandomTestUtil.randomLocaleStringMap();

		Locale defaultLocale = LocaleUtil.getSiteDefault();
		Set<Locale> locales = contentMap.keySet();

		String content = DDMStructureTestUtil.getSampleStructuredContent(
			contentMap, LocaleUtil.toLanguageId(defaultLocale));

		DDMForm ddmForm = DDMStructureTestUtil.getSampleDDMForm(
			locales.toArray(new Locale[locales.size()]), defaultLocale);

		long ddmGroupId = GetterUtil.getLong(
			serviceContext.getAttribute("ddmGroupId"), groupId);

		DDMStructure ddmStructure = DDMStructureTestUtil.addStructure(
			ddmGroupId, JournalArticle.class.getName(), ddmForm, defaultLocale);

		DDMTemplate ddmTemplate = DDMTemplateTestUtil.addTemplate(
			ddmGroupId, ddmStructure.getStructureId(),
			PortalUtil.getClassNameId(JournalArticle.class));

		return JournalArticleLocalServiceUtil.addArticle(
			serviceContext.getUserId(), groupId,
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			RandomTestUtil.randomLocaleStringMap(),
			RandomTestUtil.randomLocaleStringMap(), content,
			ddmStructure.getStructureKey(), ddmTemplate.getTemplateKey(),
			serviceContext);
	}

}