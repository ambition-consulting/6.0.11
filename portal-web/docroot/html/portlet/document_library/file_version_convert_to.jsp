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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

DLFileEntry fileEntry = (DLFileEntry)objArray[0];
DLFileVersion fileVersion = (DLFileVersion)objArray[1];
String[] conversions = (String[])objArray[3];
Boolean isLocked = (Boolean)objArray[4];
Boolean hasLock = (Boolean)objArray[5];
%>

<table class="lfr-table">
<tr>

<%
for (int i = 0; i < conversions.length; i++) {
	String conversion = conversions[i];

%>

	<td>
		<liferay-ui:icon
			image='<%= "../file_system/small/" + conversion %>'
			label="<%= true %>"
			message="<%= conversion.toUpperCase() %>"
			url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle())) + "?version=" + fileVersion.getVersion() + "&targetExtension=" + conversion %>'
		/>
	</td>

<%
}
%>

</tr>
</table>