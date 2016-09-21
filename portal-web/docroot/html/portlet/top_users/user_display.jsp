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

<%@ include file="/html/portlet/top_users/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SocialEquityUser socialEquityUser = (SocialEquityUser)row.getObject();
%>

<liferay-ui:user-display
	userId="<%= socialEquityUser.getUserId() %>"
	userName=""
>
	<c:if test="<%= userDisplay != null %>">
		<liferay-ui:message key="rank" />: <%= socialEquityUser.getRank() %><br />

		<liferay-ui:message key="contribution-score" />: <%= Math.round(socialEquityUser.getContributionEquity()) %><br />

		<liferay-ui:message key="participation-score" />: <%= Math.round(socialEquityUser.getParticipationEquity()) %>
	</c:if>
</liferay-ui:user-display>