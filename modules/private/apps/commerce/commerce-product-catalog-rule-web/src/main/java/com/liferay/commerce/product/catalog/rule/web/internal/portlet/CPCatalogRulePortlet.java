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

package com.liferay.commerce.product.catalog.rule.web.internal.portlet;

import com.liferay.commerce.product.catalog.rule.CPRuleTypeJSPContributorRegistry;
import com.liferay.commerce.product.catalog.rule.CPRuleTypeRegistry;
import com.liferay.commerce.product.catalog.rule.web.internal.display.context.CPCatalogRuleDisplayContext;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.commerce.product.service.CPRuleAssetCategoryRelService;
import com.liferay.commerce.product.service.CPRuleService;
import com.liferay.commerce.product.service.CPRuleUserSegmentRelService;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-commerce-product-catalog-rule",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=Catalog Rules",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CPPortletKeys.CP_CATALOG_RULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {CPCatalogRulePortlet.class, Portlet.class}
)
public class CPCatalogRulePortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			renderRequest);

		CPCatalogRuleDisplayContext cpCatalogRuleDisplayContext =
			new CPCatalogRuleDisplayContext(
				_cpRuleAssetCategoryRelService, _cpRuleService,
				_cpRuleTypeJSPContributorRegistry, _cpRuleTypeRegistry,
				_cpRuleUserSegmentRelService, httpServletRequest,
				_itemSelector);

		renderRequest.setAttribute(
			WebKeys.PORTLET_DISPLAY_CONTEXT, cpCatalogRuleDisplayContext);

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private CPRuleAssetCategoryRelService _cpRuleAssetCategoryRelService;

	@Reference
	private CPRuleService _cpRuleService;

	@Reference
	private CPRuleTypeJSPContributorRegistry _cpRuleTypeJSPContributorRegistry;

	@Reference
	private CPRuleTypeRegistry _cpRuleTypeRegistry;

	@Reference
	private CPRuleUserSegmentRelService _cpRuleUserSegmentRelService;

	@Reference
	private ItemSelector _itemSelector;

	@Reference
	private Portal _portal;

}