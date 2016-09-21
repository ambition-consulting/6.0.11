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

<c:choose>
	<c:when test="<%= !PropsValues.SOCIAL_EQUITY_EQUITY_LOG_ENABLED %>">
		<div class="portlet-msg-error">
			<liferay-ui:message key="social-equity-is-not-enabled" />
		</div>
	</c:when>
	<c:otherwise>
		<%@ include file="/html/portlet/top_users/view_top_users.jspf" %>
	</c:otherwise>
</c:choose>