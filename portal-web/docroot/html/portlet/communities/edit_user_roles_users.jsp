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

<%@ include file="/html/portlet/communities/init.jsp" %>

<%
String tabs1 = (String)request.getAttribute("edit_user_roles.jsp-tabs1");

int cur = (Integer)request.getAttribute("edit_user_roles.jsp-cur");

Group group = (Group)request.getAttribute("edit_user_roles.jsp-group");
String groupName = (String)request.getAttribute("edit_user_roles.jsp-groupName");
Role role = (Role)request.getAttribute("edit_user_roles.jsp-role");
long roleId = (Long)request.getAttribute("edit_user_roles.jsp-roleId");
Organization organization = (Organization)request.getAttribute("edit_user_roles.jsp-organization");

PortletURL portletURL = (PortletURL)request.getAttribute("edit_user_roles.jsp-portletURL");
%>

<aui:input name="addUserIds" type="hidden" />
<aui:input name="removeUserIds" type="hidden" />

<div class="portlet-section-body results-row" style="border: 1px solid; padding: 5px;">
	<%= LanguageUtil.format(pageContext, "step-x-of-x", new String[] {"2", "2"}) %>

	<em>Current</em> signifies current users associated with the <em><%= HtmlUtil.escape(role.getTitle(locale)) %></em> role. <em>Available</em> signifies all users associated with the <em><%= HtmlUtil.escape(groupName) %></em> <%= (group.isOrganization()) ? "organization" : "community" %>.
</div>

<br />

<h3><liferay-ui:message key="users" /></h3>

<liferay-ui:tabs
	names="current,available"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<liferay-ui:search-container
	rowChecker="<%= new UserGroupRoleUserChecker(renderResponse, group, role) %>"
	searchContainer="<%= new UserSearch(renderRequest, portletURL) %>"
>
	<liferay-ui:search-form
		page="/html/portlet/enterprise_admin/user_search.jsp"
	/>

	<%
	UserSearchTerms searchTerms = (UserSearchTerms)searchContainer.getSearchTerms();

	LinkedHashMap userParams = new LinkedHashMap();

	if (group.isOrganization()) {
		userParams.put("usersOrgs", new Long(organization.getOrganizationId()));
	}
	else {
		userParams.put("usersGroups", new Long(group.getGroupId()));
	}

	if (tabs1.equals("current")) {
		userParams.put("userGroupRole", new Long[] {new Long(group.getGroupId()), new Long(roleId)});
	}
	%>

	<liferay-ui:search-container-results>
		<%@ include file="/html/portlet/enterprise_admin/user_search_results.jspf" %>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user2"
	>
		<liferay-ui:search-container-column-text
			name="name"
			property="fullName"
		/>

		<liferay-ui:search-container-column-text
			name="screen-name"
			property="screenName"
		/>
	</liferay-ui:search-container-row>

	<div class="separator"><!-- --></div>

	<%
	String taglibOnClick = renderResponse.getNamespace() + "updateUserGroupRoleUsers('" + portletURL.toString() + StringPool.AMPERSAND + renderResponse.getNamespace() + "cur=" + cur + "');";
	%>

	<aui:button onClick="<%= taglibOnClick %>" value="update-associations" />

	<br /><br />

	<liferay-ui:search-iterator />
</liferay-ui:search-container>