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

<%@ include file="/html/portlet/page_ratings/init.jsp" %>

<%
long reportedUserId = themeDisplay.getDefaultUserId();

Group group = layout.getGroup();

if (group.isUser()) {
	reportedUserId = group.getClassPK();
}
%>

<liferay-ui:flags
	className="<%= Layout.class.getName() %>"
	classPK="<%= layout.getPlid() %>"
	contentTitle="<%= layout.getHTMLTitle(LocaleUtil.getDefault()) %>"
	message="flag-this-page"
	reportedUserId="<%= reportedUserId %>"
/>