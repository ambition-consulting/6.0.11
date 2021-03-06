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
String tabs2 = ParamUtil.getString(request, "tabs2");

String portletURLString = (String)request.getAttribute("view.jsp-portletURLString");
%>

<c:choose>
	<c:when test="<%= PropsValues.LIVE_USERS_ENABLED && PropsValues.SESSION_TRACKER_MEMORY_ENABLED %>">
		<liferay-ui:header
			title="live-sessions"
		/>

		<liferay-ui:search-container
			headerNames="session-id,user-id,name,screen-name,last-request,num-of-hits"
			emptyResultsMessage="there-are-no-live-sessions"
		>

			<%
			Map<String, UserTracker> sessionUsers = LiveUsers.getSessionUsers(company.getCompanyId());

			List<UserTracker> userTrackers = new ArrayList<UserTracker>(sessionUsers.values());

			userTrackers = ListUtil.sort(userTrackers, new UserTrackerModifiedDateComparator());
			%>

			<liferay-ui:search-container-results
				results="<%= ListUtil.subList(userTrackers, searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%= userTrackers.size() %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portal.model.UserTracker"
				escapedModel="<%= false %>"
				keyProperty="userTrackerId"
				modelVar="userTracker"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="struts_action" value="/enterprise_admin/edit_session" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="sessionId" value="<%= userTracker.getSessionId() %>" />
				</portlet:renderURL>

				<%
				User user2 = null;

				try {
					user2 = UserLocalServiceUtil.getUserById(userTracker.getUserId());
				}
				catch (NoSuchUserException nsue) {
				}
				%>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="session-id"
					property="sessionId"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="user-id"
					property="userId"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="user-id"
					value='<%= ((user2 != null) ? HtmlUtil.escape(user2.getFullName()) : LanguageUtil.get(pageContext, "not-available")) %>'
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="screen-name"
					value='<%= ((user2 != null) ? user2.getScreenName() : LanguageUtil.get(pageContext, "not-available")) %>'
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="last-request"
					value="<%= dateFormatDateTime.format(userTracker.getModifiedDate()) %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="num-of-hits"
					property="hits"
				/>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>
	<c:when test="<%= !PropsValues.LIVE_USERS_ENABLED %>">
		<%= LanguageUtil.format(pageContext, "display-of-live-session-data-is-disabled", PropsKeys.LIVE_USERS_ENABLED) %>
	</c:when>
	<c:otherwise>
		<%= LanguageUtil.format(pageContext, "display-of-live-session-data-is-disabled", PropsKeys.SESSION_TRACKER_MEMORY_ENABLED) %>
	</c:otherwise>
</c:choose>