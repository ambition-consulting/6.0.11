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

User user2 = (User)row.getObject();

Group group = (Group)row.getParameter("group");
%>

<liferay-ui:icon-menu>
	<c:if test="<%= permissionChecker.isCommunityOwner(group.getGroupId()) %>">
		<portlet:renderURL var="assignURL">
			<portlet:param name="struts_action" value="/communities/edit_community_assignments" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="p_u_i_d" value="<%= String.valueOf(user2.getUserId()) %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="assign_user_roles"
			url="<%= assignURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>