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
int abstractLength = (Integer)request.getAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH);
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute(WebKeys.ASSET_RENDERER);

DLFileVersion fileVersion = (DLFileVersion)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_VERSION);

DLFileEntry fileEntry = fileVersion.getFileEntry();
%>

<c:if test="<%= fileVersion.isApproved() %>">
	<div class="asset-resource-info">
		<liferay-ui:icon
			image='<%= "../file_system/small/" + fileVersion.getIcon() %>'
			label="<%= true %>"
			message="<%= HtmlUtil.escape(fileVersion.getTitle()) %>"
			url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + fileVersion.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(fileVersion.getTitle())) %>'
		/>
	</div>
</c:if>

<p class="asset-description">
	<%= HtmlUtil.escape(StringUtil.shorten(fileVersion.getDescription(), abstractLength)) %>
</p>