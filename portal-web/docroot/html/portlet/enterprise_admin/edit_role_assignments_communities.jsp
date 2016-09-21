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
String tabs3 = (String)request.getAttribute("edit_role_assignments.jsp-tabs3");

int cur = (Integer)request.getAttribute("edit_role_assignments.jsp-cur");

Role role = (Role)request.getAttribute("edit_role_assignments.jsp-role");

PortletURL portletURL = (PortletURL)request.getAttribute("edit_role_assignments.jsp-portletURL");
%>

<aui:input name="addGroupIds" type="hidden" />
<aui:input name="removeGroupIds" type="hidden" />

<liferay-ui:tabs
	names="current,available"
	param="tabs3"
	url="<%= portletURL.toString() %>"
/>

<%
GroupSearch searchContainer = new GroupSearch(renderRequest, portletURL);

searchContainer.setRowChecker(new GroupRoleChecker(renderResponse, role));
%>

<liferay-ui:search-form
	page="/html/portlet/enterprise_admin/group_search.jsp"
	searchContainer="<%= searchContainer %>"
/>

<%
GroupSearchTerms searchTerms = (GroupSearchTerms)searchContainer.getSearchTerms();

LinkedHashMap groupParams = new LinkedHashMap();

if (tabs3.equals("current")) {
	groupParams.put("groupsRoles", new Long(role.getRoleId()));
}

int total = GroupLocalServiceUtil.searchCount(company.getCompanyId(), searchTerms.getName(), searchTerms.getDescription(), groupParams);

searchContainer.setTotal(total);

List results = GroupLocalServiceUtil.search(company.getCompanyId(), searchTerms.getName(), searchTerms.getDescription(), groupParams, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

searchContainer.setResults(results);
%>

<div class="separator"><!-- --></div>

<%
String taglibOnClick = renderResponse.getNamespace() + "updateRoleGroups('" + portletURL.toString() + StringPool.AMPERSAND + renderResponse.getNamespace() + "cur=" + cur + "');";
%>

<aui:button onClick="<%= taglibOnClick %>" value="update-associations" />

<br /><br />

<%
List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	Group group = (Group)results.get(i);

	ResultRow row = new ResultRow(group, group.getGroupId(), i);

	// Name

	row.addText(group.getDescriptiveName());

	// Type

	row.addText(LanguageUtil.get(pageContext, group.getTypeLabel()));

	// Add result row

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />