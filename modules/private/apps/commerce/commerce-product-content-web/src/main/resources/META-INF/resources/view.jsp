<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
CPDefinition cpDefinition = (CPDefinition)request.getAttribute(CPWebKeys.CP_DEFINITION);

long cpDefinitionId = ParamUtil.getLong(request, "cpDefinitionId");
%>

<c:if test="<%= cpDefinition != null %>">
<h1><%= cpDefinition.getTitle(languageId) %></h1>
<img src="<%= cpDefinition.getDefaultImageThumbnailSrc(themeDisplay) %>">
<p><%= cpDefinition.getDescription(languageId) %></p>
</c:if>