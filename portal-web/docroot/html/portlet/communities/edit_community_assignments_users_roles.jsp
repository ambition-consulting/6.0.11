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
String tabs1 = (String)request.getAttribute("edit_community_assignments.jsp-tabs1");
String tabs2 = (String)request.getAttribute("edit_community_assignments.jsp-tabs2");

String redirect = (String)request.getAttribute("edit_community_assignments.jsp-redirect");

int cur = (Integer)request.getAttribute("edit_community_assignments.jsp-cur");

Group group = (Group)request.getAttribute("edit_community_assignments.jsp-group");
User selUser = (User)request.getAttribute("edit_community_assignments.jsp-selUser");

PortletURL portletURL = (PortletURL)request.getAttribute("edit_community_assignments.jsp-portletURL");

portletURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
%>

<aui:input name="p_u_i_d" type="hidden" value="<%= selUser.getUserId() %>" />
<aui:input name="addRoleIds" type="hidden" />
<aui:input name="removeRoleIds" type="hidden" />

<liferay-ui:message key="edit-community-roles-for-user" />: <%= HtmlUtil.escape(selUser.getFullName()) %>

<br /><br />

<%
RoleSearch searchContainer = new RoleSearch(renderRequest, portletURL);

searchContainer.setRowChecker(new UserGroupRoleRoleChecker(renderResponse, selUser, group));
%>

<liferay-ui:search-form
	page="/html/portlet/enterprise_admin/role_search.jsp"
	searchContainer="<%= searchContainer %>"
/>

<%
RoleSearchTerms searchTerms = (RoleSearchTerms)searchContainer.getSearchTerms();

List<Role> roles = RoleLocalServiceUtil.search(company.getCompanyId(), searchTerms.getName(), searchTerms.getDescription(), new Integer[] {RoleConstants.TYPE_COMMUNITY}, QueryUtil.ALL_POS, QueryUtil.ALL_POS, searchContainer.getOrderByComparator());

roles = EnterpriseAdminUtil.filterGroupRoles(permissionChecker, group.getGroupId(), roles);

int total = roles.size();

searchContainer.setTotal(total);

List<Role> results = ListUtil.subList(roles, searchContainer.getStart(), searchContainer.getEnd());

searchContainer.setResults(results);

PortletURL updateRoleAssignmentsURL = renderResponse.createRenderURL();

updateRoleAssignmentsURL.setParameter("struts_action", "/communities/edit_community_assignments");
updateRoleAssignmentsURL.setParameter("tabs1", tabs1);
updateRoleAssignmentsURL.setParameter("tabs2", tabs2);
updateRoleAssignmentsURL.setParameter("redirect", redirect);
updateRoleAssignmentsURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
updateRoleAssignmentsURL.setParameter("groupId", String.valueOf(group.getGroupId()));
%>

<div class="separator"><!-- --></div>

<%
String taglibOnClick = renderResponse.getNamespace() + "updateUserGroupRole('" + updateRoleAssignmentsURL.toString() + StringPool.AMPERSAND + renderResponse.getNamespace() + "cur=" + cur + "');";
%>

<aui:button onClick="<%= taglibOnClick %>" value="update-associations" />

<br /><br />

<%
List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	Role role = results.get(i);

	role = role.toEscapedModel();

	ResultRow row = new ResultRow(role, role.getRoleId(), i);

	// Name

	row.addText(role.getTitle(locale));

	// Type

	row.addText(LanguageUtil.get(pageContext, role.getTypeLabel()));

	// Description

	row.addText(role.getDescription());

	// CSS

	row.setClassName(EnterpriseAdminUtil.getCssClassName(role));
	row.setClassHoverName(EnterpriseAdminUtil.getCssClassName(role));

	// Add result row

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />