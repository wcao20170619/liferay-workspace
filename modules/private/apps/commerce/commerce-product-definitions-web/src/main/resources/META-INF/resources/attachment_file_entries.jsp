<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CPAttachmentFileEntriesDisplayContext cpAttachmentFileEntriesDisplayContext = (CPAttachmentFileEntriesDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

CPDefinition cpDefinition = cpAttachmentFileEntriesDisplayContext.getCPDefinition();

long cpDefinitionId = cpAttachmentFileEntriesDisplayContext.getCPDefinitionId();

List<CPDefinitionOptionRel> cpDefinitionOptionRels = cpAttachmentFileEntriesDisplayContext.getCPDefinitionOptionRels();

String displayStyle = cpAttachmentFileEntriesDisplayContext.getDisplayStyle();

SearchContainer<CPAttachmentFileEntry> cpAttachmentFileEntrySearchContainer = cpAttachmentFileEntriesDisplayContext.getSearchContainer();

String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-product-definition-images");

PortletURL portletURL = cpAttachmentFileEntriesDisplayContext.getPortletURL();

renderResponse.setTitle(cpDefinition.getTitle(languageId));

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);

request.setAttribute("view.jsp-cpDefinition", cpDefinition);
request.setAttribute("view.jsp-cpType", cpAttachmentFileEntriesDisplayContext.getCPType());
request.setAttribute("view.jsp-portletURL", portletURL);
request.setAttribute("view.jsp-showSearch", true);
request.setAttribute("view.jsp-toolbarItem", toolbarItem);
%>

<liferay-util:include page="/definition_navbar.jsp" servletContext="<%= application %>" />

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="cpAttachmentFileEntries"
>
	<liferay-frontend:management-bar-buttons>
		<c:if test="<%= cpAttachmentFileEntriesDisplayContext.isShowInfoPanel() %>">
			<liferay-frontend:management-bar-sidenav-toggler-button
				icon="info-circle"
				label="info"
			/>
		</c:if>

		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"icon", "descriptive", "list"} %>'
			portletURL="<%= portletURL %>"
			selectedDisplayStyle="<%= cpAttachmentFileEntriesDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= portletURL %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= cpAttachmentFileEntriesDisplayContext.getOrderByCol() %>"
			orderByType="<%= cpAttachmentFileEntriesDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"priority", "create-date", "display-date"} %>'
			portletURL="<%= portletURL %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-action-buttons>
		<c:if test="<%= cpAttachmentFileEntriesDisplayContext.isShowInfoPanel() %>">
			<liferay-frontend:management-bar-sidenav-toggler-button
				icon="info-circle"
				label="info"
			/>
		</c:if>

		<liferay-frontend:management-bar-button href='<%= "javascript:" + renderResponse.getNamespace() + "deleteCPAttachmentFileEntries();" %>' icon="trash" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<div id="<portlet:namespace />attachmentFileEntriesContainer">
	<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
		<c:if test="<%= cpAttachmentFileEntriesDisplayContext.isShowInfoPanel() %>">
			<liferay-portlet:resourceURL
				copyCurrentRenderParameters="<%= false %>"
				id="cpAttachmentFileEntryInfoPanel"
				var="sidebarPanelURL"
			/>

			<liferay-frontend:sidebar-panel
				resourceURL="<%= sidebarPanelURL %>"
				searchContainerId="cpAttachmentFileEntries"
			>
				<liferay-util:include page="/attachment_file_entry_info_panel.jsp" servletContext="<%= application %>" />
			</liferay-frontend:sidebar-panel>
		</c:if>

		<div class="sidenav-content">
			<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="fm">
				<aui:input name="<%= Constants.CMD %>" type="hidden" />
				<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
				<aui:input name="deleteCPAttachmentFileEntryIds" type="hidden" />

				<liferay-ui:error exception="<%= NoSuchSkuContributorCPDefinitionOptionRelException.class %>" message="there-are-no-options-set-as-sku-contributor" />

				<div class="product-skus-container" id="<portlet:namespace />entriesContainer">
					<liferay-ui:search-container
						id="cpAttachmentFileEntries"
						iteratorURL="<%= portletURL %>"
						searchContainer="<%= cpAttachmentFileEntrySearchContainer %>"
					>
						<liferay-ui:search-container-row
							className="com.liferay.commerce.product.model.CPAttachmentFileEntry"
							cssClass="entry-display-style"
							keyProperty="CPAttachmentFileEntryId"
							modelVar="cpAttachmentFileEntry"
						>

							<%
							Map<CPDefinitionOptionRel, List<CPDefinitionOptionValueRel>>
									cpDefinitionOptionRelListMap =
										cpAttachmentFileEntriesDisplayContext.
												parseCPAttachmentFileEntry(
													cpAttachmentFileEntry.getCPAttachmentFileEntryId());

							PortletURL rowURL = renderResponse.createRenderURL();

							rowURL.setParameter("mvcRenderCommandName", "editCPAttachmentFileEntry");
							rowURL.setParameter("redirect", currentURL);
							rowURL.setParameter("cpDefinitionId", String.valueOf(cpDefinitionId));
							rowURL.setParameter("cpAttachmentFileEntryId", String.valueOf(cpAttachmentFileEntry.getCPAttachmentFileEntryId()));

							FileEntry fileEntry = cpAttachmentFileEntry.getFileEntry();

							String thumbnailSrc = DLUtil.getThumbnailSrc(fileEntry, themeDisplay);
							%>

							<c:choose>
								<c:when test='<%= displayStyle.equals("descriptive") %>'>
									<%@ include file="/attachment_file_entry_descriptive.jspf" %>
								</c:when>
								<c:when test='<%= displayStyle.equals("icon") %>'>

									<%
									row.setCssClass("entry-card lfr-asset-item");
									%>

									<liferay-ui:search-container-column-text>
										<c:choose>
											<c:when test="<%= Validator.isNull(thumbnailSrc) %>">
												<liferay-frontend:icon-vertical-card
													actionJsp="/attachment_file_entry_action.jsp"
													actionJspServletContext="<%= application %>"
													cssClass="entry-display-style"
													icon="documents-and-media"
													resultRow="<%= row %>"
													rowChecker="<%= cpAttachmentFileEntriesDisplayContext.getRowChecker() %>"
													title="<%= fileEntry.getTitle() %>"
													url="<%= rowURL != null ? rowURL.toString() : null %>"
												>
													<%@ include file="/attachment_file_entry_vertical_card.jspf" %>
												</liferay-frontend:icon-vertical-card>
											</c:when>
											<c:otherwise>
												<liferay-frontend:vertical-card
													actionJsp="/attachment_file_entry_action.jsp"
													actionJspServletContext="<%= application %>"
													cssClass="entry-display-style"
													imageUrl="<%= thumbnailSrc %>"
													resultRow="<%= row %>"
													rowChecker="<%= cpAttachmentFileEntriesDisplayContext.getRowChecker() %>"
													title="<%= fileEntry.getTitle() %>"
													url="<%= rowURL != null ? rowURL.toString() : null %>"
												>
													<%@ include file="/attachment_file_entry_vertical_card.jspf" %>
												</liferay-frontend:vertical-card>
											</c:otherwise>
										</c:choose>
									</liferay-ui:search-container-column-text>
								</c:when>
								<c:otherwise>
									<%@ include file="/attachment_file_entry_columns.jspf" %>
								</c:otherwise>
							</c:choose>
						</liferay-ui:search-container-row>

						<liferay-ui:search-iterator displayStyle="<%= displayStyle %>" markupView="lexicon" searchContainer="<%= cpAttachmentFileEntrySearchContainer %>" />
					</liferay-ui:search-container>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<liferay-portlet:renderURL var="addAttachmentFileEntryURL">
	<portlet:param name="mvcRenderCommandName" value="editCPAttachmentFileEntry" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="cpDefinitionId" value="<%= String.valueOf(cpDefinitionId) %>" />
</liferay-portlet:renderURL>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-single-attachment") %>' url="<%= addAttachmentFileEntryURL.toString() %>" />
	<liferay-frontend:add-menu-item id="addAttachmentFileEntry" title='<%= LanguageUtil.get(request, "add-multiple-attachments") %>' url="javascript:;" />
</liferay-frontend:add-menu>

<aui:script use="liferay-item-selector-dialog">
	$('#<portlet:namespace />addAttachmentFileEntry').on(
		'click',
		function(event) {
			event.preventDefault();

			var itemSelectorDialog = new A.LiferayItemSelectorDialog(
				{
					eventName: 'addCPAttachmentFileEntry',
					on: {
						selectedItemChange: function(event) {
							var selectedItems = event.newVal;

							if (selectedItems) {

								$('#<portlet:namespace />cpOptionIds').val(selectedItems);

								var addCPDefinitionOptionRelFm = $('#<portlet:namespace />addCPDefinitionOptionRelFm');

								submitForm(addCPDefinitionOptionRelFm);
							}
						}
					},
					title: '<liferay-ui:message arguments="<%= cpDefinition.getTitle(languageId) %>" key="add-new-option-to-x" />',
					url: '<%= cpAttachmentFileEntriesDisplayContext.getItemSelectorUrl() %>'
				}
			);

			itemSelectorDialog.open();
		}
	);
</aui:script>

<aui:script>
	function <portlet:namespace />deleteCPAttachmentFileEntries() {
		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-attachments") %>')) {
			var form = AUI.$(document.<portlet:namespace />fm);

			form.attr('method', 'post');
			form.fm('<%= Constants.CMD %>').val('<%= Constants.DELETE %>');
			form.fm('deleteCPAttachmentFileEntryIds').val(Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));

			submitForm(form, '<portlet:actionURL name="editCPAttachmentFileEntry" />');
		}
	}
</aui:script>