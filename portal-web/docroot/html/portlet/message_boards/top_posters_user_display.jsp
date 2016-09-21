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

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

MBStatsUser statsUser = (MBStatsUser)row.getObject();

String[] ranks = MBUtil.getUserRank(preferences, themeDisplay.getLanguageId(), statsUser);
%>

<liferay-ui:user-display userId="<%= statsUser.getUserId() %>">
	<c:if test="<%= Validator.isNotNull(ranks[0]) %>">
		<liferay-ui:message key="rank" />: <%= ranks[0] %><br />
	</c:if>

	<liferay-ui:message key="posts" />: <%= statsUser.getMessageCount() %><br />
	<liferay-ui:message key="join-date" />: <%= dateFormatDate.format(userDisplay.getCreateDate()) %><br />

	<c:if test="<%= statsUser.getLastPostDate() != null %>">
		<liferay-ui:message key="last-post-date" />: <%= dateFormatDate.format(statsUser.getLastPostDate()) %>
	</c:if>
</liferay-ui:user-display>