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

package com.liferay.commerce.product.type.virtual.web.internal.portlet.action;

import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingFileEntryIdException;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingSampleFileEntryIdException;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingSampleUrlException;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingTermsOfUseArticleResourcePKException;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingTermsOfUseContentException;
import com.liferay.commerce.product.type.virtual.exception.CPDefinitionVirtualSettingUrlException;
import com.liferay.commerce.product.type.virtual.exception.NoSuchCPDefinitionVirtualSettingException;
import com.liferay.commerce.product.type.virtual.model.CPDefinitionVirtualSetting;
import com.liferay.commerce.product.type.virtual.service.CPDefinitionVirtualSettingService;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CPPortletKeys.COMMERCE_PRODUCT_DEFINITIONS,
		"mvc.command.name=editProductDefinitionVirtualSetting"
	},
	service = MVCActionCommand.class
)
public class EditCPDefinitionVirtualSettingMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		String redirect = getSaveAndContinueRedirect(
			actionRequest, actionResponse);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateCPDefinitionVirtualSetting(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse, redirect);
		}
		catch (Exception e) {
			if (e instanceof CPDefinitionVirtualSettingFileEntryIdException ||
				e instanceof
					CPDefinitionVirtualSettingSampleFileEntryIdException ||
				e instanceof CPDefinitionVirtualSettingSampleUrlException ||
				e instanceof
					CPDefinitionVirtualSettingTermsOfUseArticleResourcePKException ||
				e instanceof
					CPDefinitionVirtualSettingTermsOfUseContentException ||
				e instanceof CPDefinitionVirtualSettingUrlException ||
				e instanceof NoSuchCPDefinitionVirtualSettingException ||
				e instanceof PrincipalException) {

				hideDefaultErrorMessage(actionRequest);
				hideDefaultSuccessMessage(actionRequest);

				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"editProductDefinitionVirtualSetting");

				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
	}

	protected String getSaveAndContinueRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletProviderUtil.getPortletURL(
			actionRequest, themeDisplay.getScopeGroup(),
			CPDefinition.class.getName(), PortletProvider.Action.EDIT);

		long cpDefinitionId = ParamUtil.getLong(
			actionRequest, "cpDefinitionId");

		portletURL.setParameter(
			"mvcRenderCommandName", "editProductDefinitionVirtualSetting");
		portletURL.setParameter(
			"cpDefinitionId", String.valueOf(cpDefinitionId));
		portletURL.setWindowState(actionRequest.getWindowState());

		return portletURL.toString();
	}

	protected CPDefinitionVirtualSetting updateCPDefinitionVirtualSetting(
			ActionRequest actionRequest)
		throws Exception {

		long cpDefinitionVirtualSettingId = ParamUtil.getLong(
			actionRequest, "cpDefinitionVirtualSettingId");

		long cpDefinitionId = ParamUtil.getLong(
			actionRequest, "cpDefinitionId");

		boolean useUrl = ParamUtil.getBoolean(actionRequest, "useUrl");
		long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");
		String url = ParamUtil.getString(actionRequest, "url");
		String activationStatus = ParamUtil.getString(
			actionRequest, "activationStatus");
		long durationDays = ParamUtil.getLong(actionRequest, "durationDays");
		int maxUsages = ParamUtil.getInteger(actionRequest, "maxUsages");
		boolean useSample = ParamUtil.getBoolean(actionRequest, "useSample");
		boolean useSampleUrl = ParamUtil.getBoolean(
			actionRequest, "useSampleUrl");
		long sampleFileEntryId = ParamUtil.getLong(
			actionRequest, "sampleFileEntryId");
		String sampleUrl = ParamUtil.getString(actionRequest, "sampleUrl");
		boolean termsOfUseRequired = ParamUtil.getBoolean(
			actionRequest, "termsOfUseRequired");
		boolean useTermsOfUseJournal = ParamUtil.getBoolean(
			actionRequest, "useTermsOfUseJournal");
		Map<Locale, String> termsOfUseContentMap =
			LocalizationUtil.getLocalizationMap(
				actionRequest, "termsOfUseContent");
		long termsOfUseJournalArticleResourcePrimKey = ParamUtil.getLong(
			actionRequest, "termsOfUseJournalArticleResourcePrimKey");

		long duration = durationDays * Time.DAY;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			CPDefinitionVirtualSetting.class.getName(), actionRequest);

		CPDefinitionVirtualSetting cpDefinitionVirtualSetting = null;

		if (cpDefinitionVirtualSettingId <= 0) {

			// Add commerce product definition virtual setting

			cpDefinitionVirtualSetting =
				_cpDefinitionVirtualSettingService.
					addCPDefinitionVirtualSetting(
						cpDefinitionId, useUrl, fileEntryId, url,
						activationStatus, duration, maxUsages, useSample,
						useSampleUrl, sampleFileEntryId, sampleUrl,
						termsOfUseRequired, useTermsOfUseJournal,
						termsOfUseContentMap,
						termsOfUseJournalArticleResourcePrimKey,
						serviceContext);
		}
		else {

			// Update commerce product definition virtual setting

			cpDefinitionVirtualSetting =
				_cpDefinitionVirtualSettingService.
					updateCPDefinitionVirtualSetting(
						cpDefinitionVirtualSettingId, useUrl, fileEntryId, url,
						activationStatus, duration, maxUsages, useSample,
						useSampleUrl, sampleFileEntryId, sampleUrl,
						termsOfUseRequired, useTermsOfUseJournal,
						termsOfUseContentMap,
						termsOfUseJournalArticleResourcePrimKey,
						serviceContext);
		}

		return cpDefinitionVirtualSetting;
	}

	@Reference
	private CPDefinitionVirtualSettingService
		_cpDefinitionVirtualSettingService;

}