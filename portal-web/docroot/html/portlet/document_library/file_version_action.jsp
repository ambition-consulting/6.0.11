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
int fileVersionsCount = (Integer)objArray[2];
String[] conversions = (String[])objArray[3];
Boolean isLocked = (Boolean)objArray[4];
Boolean hasLock = (Boolean)objArray[5];
%>

<liferay-ui:icon-menu>
	<c:if test="<%= showActions && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.DELETE) && (!isLocked || hasLock) %>">
		<portlet:renderURL var="redirectURL">
			<portlet:param name="struts_action" value="/document_library/view" />
			<portlet:param name="folderId" value="<%= String.valueOf(fileEntry.getFolderId()) %>" />
		</portlet:renderURL>

		<portlet:actionURL var="portletURL">
			<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= (fileVersionsCount == 1) ? redirectURL : currentURL %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(fileEntry.getFolderId()) %>" />
			<portlet:param name="name" value="<%= fileEntry.getName() %>" />
			<portlet:param name="version" value="<%= String.valueOf(fileVersion.getVersion()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= portletURL %>" />
	</c:if>
</liferay-ui:icon-menu>