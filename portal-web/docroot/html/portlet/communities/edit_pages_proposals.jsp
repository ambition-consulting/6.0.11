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
long liveGroupId = ((Long)request.getAttribute("edit_pages.jsp-liveGroupId")).longValue();

PortletURL portletURL = (PortletURL)request.getAttribute("edit_pages.jsp-portletURL");

List<String> headerNames = new ArrayList<String>();

headerNames.add("name");
headerNames.add("type");
headerNames.add("id");
headerNames.add("user");
headerNames.add("due-date");
headerNames.add("status");
headerNames.add(StringPool.BLANK);

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "no-proposals-were-found");

int total = 0;
List<TasksProposal> results = null;

if (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.ASSIGN_REVIEWER) || GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_STAGING) || GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.PUBLISH_STAGING)) {
	total = TasksProposalLocalServiceUtil.getProposalsCount(liveGroupId);
	results = TasksProposalLocalServiceUtil.getProposals(liveGroupId, searchContainer.getStart(), searchContainer.getEnd());
}
else if (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.APPROVE_PROPOSAL)) {
	total = TasksProposalLocalServiceUtil.getReviewProposalsCount(liveGroupId, user.getUserId());
	results = TasksProposalLocalServiceUtil.getReviewProposals(liveGroupId, user.getUserId(), searchContainer.getStart(), searchContainer.getEnd());
}
else {
	total = TasksProposalLocalServiceUtil.getUserProposalsCount(liveGroupId, user.getUserId());
	results = TasksProposalLocalServiceUtil.getUserProposals(liveGroupId, user.getUserId(), searchContainer.getStart(), searchContainer.getEnd());
}

searchContainer.setTotal(total);
searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	TasksProposal proposal = results.get(i);

	proposal = proposal.toEscapedModel();

	ResultRow row = new ResultRow(proposal, proposal.getProposalId(), i);

	PortletURL rowURL = renderResponse.createRenderURL();

	rowURL.setParameter("struts_action", "/communities/edit_proposal");
	rowURL.setParameter("redirect", currentURL);
	rowURL.setParameter("groupId", String.valueOf(proposal.getGroupId()));
	rowURL.setParameter("proposalId", String.valueOf(proposal.getProposalId()));

	// Name

	row.addText(proposal.getName().concat("<br />").concat(proposal.getDescription()), rowURL);

	// Type

	String className = PortalUtil.getClassName(proposal.getClassNameId());

	row.addText(LanguageUtil.get(pageContext, "model.resource." + className), rowURL);

	// ID

	row.addText(proposal.getClassPK(), rowURL);

	// User

	row.addText(HtmlUtil.escape(PortalUtil.getUserName(proposal.getUserId(), proposal.getUserName())), rowURL);

	// Due date

	if (proposal.getDueDate() == null) {
		row.addText(LanguageUtil.get(pageContext, "never"), rowURL);
	}
	else {
		row.addText(dateFormatDateTime.format(proposal.getDueDate()), rowURL);
	}

	// Status

	row.addText(proposal.getStatus(locale), rowURL);

	// Action

	row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/communities/proposal_action.jsp");

	// Add result row

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />