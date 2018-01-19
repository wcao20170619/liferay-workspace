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

package com.liferay.portal.workflow.kaleo.designer.web.internal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManager;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.parser.WorkflowModelParser;
import com.liferay.portal.workflow.kaleo.designer.web.constants.KaleoDesignerPortletKeys;
import com.liferay.portal.workflow.kaleo.designer.web.internal.constants.KaleoDesignerWebKeys;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionVersionLocalService;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Inácio Nery
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + KaleoDesignerPortletKeys.KALEO_DESIGNER,
		"mvc.command.name=addKaleoDefinitionVersion"
	},
	service = MVCActionCommand.class
)
public class AddKaleoDefinitionVersionMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		try {
			doProcessAction(actionRequest, actionResponse);

			addSuccessMessage(actionRequest, actionResponse);

			setCloseRedirect(actionRequest);

			sendRedirect(actionRequest, actionResponse);

			return SessionErrors.isEmpty(actionRequest);
		}
		catch (WorkflowException we) {
			hideDefaultErrorMessage(actionRequest);

			SessionErrors.add(actionRequest, we.getClass(), we);

			return false;
		}
		catch (PortletException pe) {
			throw pe;
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	@Override
	protected void addSuccessMessage(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(
			portal.getLocale(actionRequest));

		String successMessage = getSuccessMessage(resourceBundle);

		SessionMessages.add(actionRequest, "requestProcessed", successMessage);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String content = ParamUtil.getString(actionRequest, "content");

		Definition definition = new Definition(
			StringPool.BLANK, StringPool.BLANK, content, 0);

		try {
			definition = workflowModelParser.parse(content);
		}
		catch (Exception e) {
		}

		String name = ParamUtil.getString(actionRequest, "name");

		String definitionName = getDefinitionName(definition, name);

		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "title");

		String title = titleMap.get(LocaleUtil.getDefault());

		String definitionDescription = getDefinitionDescription(
			actionRequest, definition, title);

		KaleoDefinitionVersion kaleoDefinitionVersion =
			kaleoDefinitionVersionLocalService.
				fetchLatestKaleoDefinitionVersion(
					themeDisplay.getCompanyId(), definitionName, null);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			KaleoDefinitionVersion.class.getName(), actionRequest);

		serviceContext.setAttribute("status", WorkflowConstants.STATUS_DRAFT);

		if (kaleoDefinitionVersion == null) {
			kaleoDefinitionVersion =
				kaleoDefinitionVersionLocalService.addKaleoDefinitionVersion(
					definitionName, getTitle(titleMap), definitionDescription,
					definition.getContent(), "0.1", serviceContext);
		}
		else {
			String version = getNextVersion(
				kaleoDefinitionVersion.getVersion());

			kaleoDefinitionVersion =
				kaleoDefinitionVersionLocalService.addKaleoDefinitionVersion(
					definitionName, getTitle(titleMap), definitionDescription,
					definition.getContent(), version, serviceContext);
		}

		actionRequest.setAttribute(
			KaleoDesignerWebKeys.KALEO_DRAFT_DEFINITION,
			kaleoDefinitionVersion);

		setRedirectAttribute(actionRequest, kaleoDefinitionVersion);
	}

	protected String getDefinitionDescription(
		ActionRequest actionRequest, Definition definition,
		String defaultDescription) {

		if (Validator.isNotNull(definition.getDescription())) {
			return definition.getDescription();
		}

		if (Validator.isNotNull(defaultDescription)) {
			return defaultDescription;
		}

		ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(
			portal.getLocale(actionRequest));

		return LanguageUtil.get(resourceBundle, "untitled-workflow");
	}

	protected String getDefinitionName(Definition definition, String name) {
		if (Validator.isNotNull(name)) {
			return name;
		}

		if (Validator.isNotNull(definition.getName())) {
			return definition.getName();
		}

		return portalUUID.generate();
	}

	protected String getNextVersion(String version) {
		int[] versionParts = StringUtil.split(version, StringPool.PERIOD, 0);

		return versionParts[0] + StringPool.PERIOD + ++versionParts[1];
	}

	protected String getSuccessMessage(ResourceBundle resourceBundle) {
		return LanguageUtil.get(
			resourceBundle, "workflow-updated-successfully");
	}

	protected String getTitle(Map<Locale, String> titleMap)
		throws WorkflowException {

		if (titleMap == null) {
			return null;
		}

		String value = StringPool.BLANK;

		for (Locale locale : LanguageUtil.getAvailableLocales()) {
			String languageId = LocaleUtil.toLanguageId(locale);
			String title = titleMap.get(locale);

			if (Validator.isNotNull(title)) {
				value = LocalizationUtil.updateLocalization(
					value, "Title", title, languageId);
			}
			else {
				value = LocalizationUtil.removeLocalization(
					value, "Title", languageId);
			}
		}

		return value;
	}

	protected void setCloseRedirect(ActionRequest actionRequest) {
		String closeRedirect = ParamUtil.getString(
			actionRequest, "closeRedirect");

		if (Validator.isNull(closeRedirect)) {
			return;
		}

		SessionMessages.add(
			actionRequest,
			portal.getPortletId(actionRequest) +
				SessionMessages.KEY_SUFFIX_CLOSE_REDIRECT,
			closeRedirect);
	}

	protected void setRedirectAttribute(
			ActionRequest actionRequest,
			KaleoDefinitionVersion kaleoDefinitionVersion)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		LiferayPortletURL portletURL = PortletURLFactoryUtil.create(
			actionRequest, themeDisplay.getPpid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcPath", "/designer/edit_kaleo_definition_version.jsp");

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		portletURL.setParameter("redirect", redirect, false);

		portletURL.setParameter(
			"name", kaleoDefinitionVersion.getName(), false);
		portletURL.setParameter(
			"draftVersion", kaleoDefinitionVersion.getVersion(), false);
		portletURL.setWindowState(actionRequest.getWindowState());

		actionRequest.setAttribute(WebKeys.REDIRECT, portletURL.toString());
	}

	@Reference(
		target = "(bundle.symbolic.name=com.liferay.portal.workflow.kaleo.designer.web)",
		unbind = "-"
	)
	protected void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		this.resourceBundleLoader = resourceBundleLoader;
	}

	@Reference
	protected KaleoDefinitionLocalService kaleoDefinitionLocalService;

	@Reference
	protected KaleoDefinitionVersionLocalService
		kaleoDefinitionVersionLocalService;

	@Reference
	protected Portal portal;

	@Reference
	protected PortalUUID portalUUID;

	protected ResourceBundleLoader resourceBundleLoader;

	@Reference
	protected WorkflowDefinitionManager workflowDefinitionManager;

	@Reference
	protected WorkflowModelParser workflowModelParser;

}