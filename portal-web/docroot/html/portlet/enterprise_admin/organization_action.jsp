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
OrganizationSearch searchContainer = (OrganizationSearch)request.getAttribute("liferay-ui:search:searchContainer");

String redirect = searchContainer.getIteratorURL().toString();

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Organization organization = (Organization)row.getObject();

long organizationId = organization.getOrganizationId();

long organizationGroupId = organization.getGroup().getGroupId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editOrganizationURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_organization" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="organizationId" value="<%= String.valueOf(organizationId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editOrganizationURL %>"
		/>
	</c:if>

	<%--<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Organization.class.getName() %>"
			modelResourceDescription="<%= HtmlUtil.escape(organization.getName()) %>"
			resourcePrimKey="<%= String.valueOf(organization.getOrganizationId()) %>"
			var="editOrganizationPermissionsURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= editOrganizationPermissionsURL %>"
		/>
	</c:if>--%>

	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.MANAGE_LAYOUTS) %>">
		<portlet:renderURL var="managePagesURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_pages" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(organizationGroupId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="pages"
			message="manage-pages"
			url="<%= managePagesURL %>"
		/>
	</c:if>

	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.MANAGE_TEAMS) %>">
		<portlet:renderURL var="manageTeamsURL">
			<portlet:param name="struts_action" value="/enterprise_admin/view_teams" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(organizationGroupId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="group"
			message="manage-teams"
			url="<%= manageTeamsURL %>"
		/>
	</c:if>

	<c:if test="<%= permissionChecker.isCommunityOwner(organizationGroupId) || OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.ASSIGN_USER_ROLES) %>">
		<portlet:renderURL var="assignUserRolesURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user_roles" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(organizationGroupId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="assign_user_roles"
			url="<%= assignUserRolesURL %>"
		/>
	</c:if>

	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.ASSIGN_MEMBERS) %>">
		<portlet:renderURL var="assignMembersURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_organization_assignments" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="organizationId" value="<%= String.valueOf(organizationId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="assign"
			message="assign-members"
			url="<%= assignMembersURL %>"
		/>
	</c:if>

	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.MANAGE_USERS) %>">
		<portlet:renderURL var="addUserURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="organizationsSearchContainerPrimaryKeys" value="<%= String.valueOf(organizationId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="add_user"
			message="add-user"
			url="<%= addUserURL %>"
		/>
	</c:if>

	<portlet:renderURL var="viewUsersURL">
		<portlet:param name="struts_action" value="/enterprise_admin/view" />
		<portlet:param name="tabs1" value="users" />
		<portlet:param name="viewUsersRedirect" value="<%= redirect %>" />
		<portlet:param name="organizationId" value="<%= String.valueOf(organizationId) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="view_users"
		message="view-users"
		method="get"
		url="<%= viewUsersURL %>"
	/>

	<c:if test="<%= organization.isParentable() %>">

		<%
		String[] childrenTypes = organization.getChildrenTypes();

		for (String childrenType : childrenTypes) {
		%>

			<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.MANAGE_SUBORGANIZATIONS) %>">
				<portlet:renderURL var="addSuborganizationURL">
					<portlet:param name="struts_action" value="/enterprise_admin/edit_organization" />
					<portlet:param name="redirect" value="<%= redirect %>" />
					<portlet:param name="parentOrganizationSearchContainerPrimaryKeys" value="<%= String.valueOf(organizationId) %>" />
					<portlet:param name="type" value="<%= childrenType %>" />
				</portlet:renderURL>

				<liferay-ui:icon
					image="add_location"
					message='<%= LanguageUtil.format(pageContext, "add-x", new String[] {LanguageUtil.get(pageContext, childrenType)}) %>'
					url="<%= addSuborganizationURL %>"
				/>
			</c:if>

		<%
		}
		%>

		<portlet:renderURL var="viewSuborganizationsURL">
			<portlet:param name="struts_action" value="/enterprise_admin/view" />
			<portlet:param name="tabs1" value="organizations" />
			<portlet:param name="viewOrganizationsRedirect" value="<%= redirect %>" />
			<portlet:param name="parentOrganizationId" value="<%= String.valueOf(organizationId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="view_locations"
			message="view-suborganizations"
			method="get"
			url="<%= viewSuborganizationsURL %>"
		/>

	</c:if>

	<c:if test="<%= OrganizationPermissionUtil.contains(permissionChecker, organizationId, ActionKeys.DELETE) %>">

		<%
		String taglibDeleteURL = "javascript:" + renderResponse.getNamespace() + "deleteOrganization('" + organizationId + "');";
		%>

		<liferay-ui:icon
			image="delete"
			url="<%= taglibDeleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>