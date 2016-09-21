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
PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");
%>

<liferay-ui:error exception="<%= RequiredUserGroupException.class %>" message="you-cannot-delete-user-groups-that-have-users" />

<liferay-util:include page="/html/portlet/enterprise_admin/user_group/toolbar.jsp">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<%
RowChecker rowChecker = null;

if (PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_USER_GROUP)) {
	rowChecker = new RowChecker(renderResponse);
}
%>

<liferay-ui:search-container
	rowChecker="<%= rowChecker %>"
	searchContainer="<%= new UserGroupSearch(renderRequest, portletURL) %>"
>
	<aui:input name="deleteUserGroupIds" type="hidden" />
	<aui:input name="userGroupsRedirect" type="hidden" value="<%= portletURL.toString() %>" />

	<liferay-ui:search-form
		page="/html/portlet/enterprise_admin/user_group_search.jsp"
	/>

	<%
	UserGroupSearchTerms searchTerms = (UserGroupSearchTerms)searchContainer.getSearchTerms();
	%>

	<liferay-ui:search-container-results
		results="<%= UserGroupLocalServiceUtil.search(company.getCompanyId(), searchTerms.getName(), searchTerms.getDescription(), null, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator()) %>"
		total="<%= UserGroupLocalServiceUtil.searchCount(company.getCompanyId(), searchTerms.getName(), searchTerms.getDescription(), null) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.UserGroup"
		escapedModel="<%= true %>"
		keyProperty="userGroupId"
		modelVar="userGroup"
	>
		<portlet:renderURL var="rowURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user_group" />
			<portlet:param name="redirect" value="<%= searchContainer.getIteratorURL().toString() %>" />
			<portlet:param name="userGroupId" value="<%= String.valueOf(userGroup.getUserGroupId()) %>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="name"
			orderable="<%= true %>"
			property="name"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="description"
			orderable="<%= true %>"
			property="description"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/portlet/enterprise_admin/user_group_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<div class="separator"><!-- --></div>

	<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_USER_GROUP) %>">
		<aui:button onClick='<%= renderResponse.getNamespace() + "deleteUserGroups();" %>' value="delete" />

		<br /><br />
	</c:if>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>