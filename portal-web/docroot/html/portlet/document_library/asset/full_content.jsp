<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
--%>

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
DLFileVersion fileVersion = (DLFileVersion)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_VERSION);

DLFileEntry fileEntry = fileVersion.getFileEntry();
%>

<div class="asset-resource-info">
	<aui:a href='<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileVersion.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(fileVersion.getTitle())) %>'>
		<img class="dl-file-icon" src="<%= themeDisplay.getPathThemeImages() %>/file_system/small/<%= fileVersion.getIcon() %>.png" /><%= HtmlUtil.escape(fileVersion.getTitle()) %>
	</aui:a>
</div>

<p class="asset-description"><%= HtmlUtil.escape(fileVersion.getDescription()) %></p>

<liferay-ui:custom-attributes-available className="<%= DLFileEntry.class.getName() %>">
	<liferay-ui:custom-attribute-list
		className="<%= DLFileEntry.class.getName() %>"
		classPK="<%= (fileVersion != null) ? fileVersion.getFileVersionId() : 0 %>"
		editable="<%= false %>"
		label="<%= true %>"
	/>
</liferay-ui:custom-attributes-available>