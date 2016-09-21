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

<%@ include file="/html/portlet/recent_bloggers/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

BlogsStatsUser statsUser = (BlogsStatsUser)objArray[0];
String rowHREF = (String)objArray[1];
%>

<liferay-ui:user-display userId="<%= statsUser.getUserId() %>" url="<%= rowHREF %>">
	<liferay-ui:message key="posts" />: <%= statsUser.getEntryCount() %><br />
	<liferay-ui:message key="stars" />: <%= statsUser.getRatingsTotalEntries() %><br />
	<liferay-ui:message key="date" />: <%= dateFormatDate.format(statsUser.getLastPostDate()) %>
</liferay-ui:user-display>