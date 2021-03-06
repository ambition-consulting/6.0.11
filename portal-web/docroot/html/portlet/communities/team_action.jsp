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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Team team = (Team)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= TeamPermissionUtil.contains(permissionChecker, team.getTeamId(), ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/communities/edit_team" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="teamId" value="<%= String.valueOf(team.getTeamId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= TeamPermissionUtil.contains(permissionChecker, team.getTeamId(), ActionKeys.ASSIGN_MEMBERS) %>">
		<portlet:renderURL var="assignMembersURL">
			<portlet:param name="struts_action" value="/communities/edit_team_assignments" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="teamId" value="<%= String.valueOf(team.getTeamId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="assign"
			message="assign-members"
			url="<%= assignMembersURL %>"
		/>
	</c:if>

	<c:if test="<%= TeamPermissionUtil.contains(permissionChecker, team.getTeamId(), ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/communities/edit_team" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="teamId" value="<%= String.valueOf(team.getTeamId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>