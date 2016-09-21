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
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

long groupId = ParamUtil.getLong(request, "groupId");

Group group = GroupServiceUtil.getGroup(groupId);

Organization organization = null;

if (group.isOrganization()) {
	organization = OrganizationLocalServiceUtil.getOrganization(group.getOrganizationId());
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/communities/view_teams");
portletURL.setParameter("groupId", String.valueOf(groupId));

pageContext.setAttribute("portletURL", portletURL);
%>

<div>
	<c:choose>
		<c:when test="<%= group.isOrganization() %>">
			<liferay-ui:header
				backURL="<%= backURL %>"
				title="<%= group.getDescriptiveName() %>"
			/>
		</c:when>
		<c:otherwise>
			<liferay-ui:header
				backURL="<%= backURL %>"
				title="<%= group.getDescriptiveName() %>"
			/>
		</c:otherwise>
	</c:choose>
</div>

<br />

<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />

	<%
	TeamSearch searchContainer = new TeamSearch(renderRequest, portletURL);

	List headerNames = searchContainer.getHeaderNames();

	headerNames.add(StringPool.BLANK);
	%>

	<liferay-ui:search-form
		page="/html/portlet/enterprise_admin/team_search.jsp"
		searchContainer="<%= searchContainer %>"
	/>

	<%
	TeamSearchTerms searchTerms = (TeamSearchTerms)searchContainer.getSearchTerms();

	int total = TeamLocalServiceUtil.searchCount(groupId, searchTerms.getName(), searchTerms.getDescription(), new LinkedHashMap<String, Object>());

	searchContainer.setTotal(total);

	List results = TeamLocalServiceUtil.search(groupId, searchTerms.getName(), searchTerms.getDescription(), new LinkedHashMap<String, Object>(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

	searchContainer.setResults(results);

	portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCur()));
	%>

	<div class="separator"><!-- --></div>

	<%
	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		Team team = (Team)results.get(i);

		team = team.toEscapedModel();

		ResultRow row = new ResultRow(team, team.getTeamId(), i);

		PortletURL rowURL = null;

		if (TeamPermissionUtil.contains(permissionChecker, team.getTeamId(), ActionKeys.UPDATE)) {
			rowURL = renderResponse.createRenderURL();

			rowURL.setParameter("struts_action", "/communities/edit_team");
			rowURL.setParameter("redirect", currentURL);
			rowURL.setParameter("teamId", String.valueOf(team.getTeamId()));
		}

		// Name

		row.addText(team.getName(), rowURL);

		// Description

		row.addText(team.getDescription(), rowURL);

		// Action

		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/communities/team_action.jsp");

		// Add result row

		resultRows.add(row);
	}
	%>

	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, groupId, ActionKeys.MANAGE_TEAMS) %>">
		<portlet:renderURL var="addTeamURL">
			<portlet:param name="struts_action" value="/communities/edit_team" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
		</portlet:renderURL>

		<aui:button onClick='<%= addTeamURL %>' value="add-team" />

		<br /><br />
	</c:if>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>

<%
if (group.isOrganization()) {
	EnterpriseAdminUtil.addPortletBreadcrumbEntries(organization, request, renderResponse);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, group.getDescriptiveName(), null);
}

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "manage-teams"), currentURL);
%>