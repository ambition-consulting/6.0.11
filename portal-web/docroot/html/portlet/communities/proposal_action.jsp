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

TasksProposal proposal = (TasksProposal)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, proposal.getGroupId(), ActionKeys.APPROVE_PROPOSAL) || GroupPermissionUtil.contains(permissionChecker, proposal.getGroupId(), ActionKeys.MANAGE_LAYOUTS) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/communities/edit_proposal" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(proposal.getGroupId()) %>" />
			<portlet:param name="proposalId" value="<%= String.valueOf(proposal.getProposalId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, proposal.getGroupId(), ActionKeys.MANAGE_LAYOUTS) %>">
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/communities/edit_proposal" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(proposal.getGroupId()) %>" />
			<portlet:param name="proposalId" value="<%= String.valueOf(proposal.getProposalId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>