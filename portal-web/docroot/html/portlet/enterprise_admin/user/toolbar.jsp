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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewUsersURL">
		<portlet:param name="struts_action" value="/enterprise_admin/view" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewUsersURL %>"><liferay-ui:message key="view-all" /></a>
	</span>

	<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_USER) %>">
		<portlet:renderURL var="addUserURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>

		<span class="lfr-toolbar-button add-button <%= toolbarItem.equals("add") ? "current" : StringPool.BLANK %>"><a href="<%= addUserURL %>"><liferay-ui:message key="add" /></a></span>
	</c:if>

	<c:if test="<%= RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.ADMINISTRATOR, true) %>">
		<liferay-portlet:renderURL var="expandoURL" portletName="<%= PortletKeys.EXPANDO %>">
			<portlet:param name="struts_action" value="/expando/view_attributes" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="modelResource" value="<%= User.class.getName() %>" />
		</liferay-portlet:renderURL>
	</c:if>

	<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.EXPORT_USER) %>">
		<portlet:renderURL var="addUserURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>

		<span class="lfr-toolbar-button export-button"><a href="javascript:<portlet:namespace />exportUsers();"><liferay-ui:message key="export" /></a></span>
	</c:if>
</div>