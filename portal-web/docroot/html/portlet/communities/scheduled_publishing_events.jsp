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
long groupId = ParamUtil.getLong(request, "groupId");

String destinationName = ParamUtil.getString(request, "destinationName");

SearchContainer searchContainer = new SearchContainer();

List<String> headerNames = new ArrayList<String>();

headerNames.add("description");
headerNames.add("start-date");
headerNames.add("end-date");
headerNames.add(StringPool.BLANK);

searchContainer.setHeaderNames(headerNames);
searchContainer.setEmptyResultsMessage("there-are-no-scheduled-events");

List<SchedulerRequest> results = SchedulerEngineUtil.getScheduledJobs(StagingUtil.getSchedulerGroupName(destinationName, groupId));

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	SchedulerRequest schedulerRequest = results.get(i);

	Trigger trigger = schedulerRequest.getTrigger();

	ResultRow row = new ResultRow(schedulerRequest, trigger.getJobName(), i);

	// Description

	row.addText(schedulerRequest.getDescription());

	// Start date

	row.addText(dateFormatDateTime.format(trigger.getStartDate()));

	// End date

	if (trigger.getEndDate() != null) {
		row.addText(dateFormatDateTime.format(trigger.getEndDate()));
	}
	else {
		row.addText(LanguageUtil.get(pageContext, "no-end-date"));
	}

	// Action

	StringBundler sb = new StringBundler(4);

	sb.append(portletDisplay.getNamespace());
	sb.append("unschedulePublishEvent('");
	sb.append(trigger.getJobName());
	sb.append("');");

	row.addButton("right", SearchEntry.DEFAULT_VALIGN, LanguageUtil.get(pageContext, "delete"), sb.toString());

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="<%= false %>" />