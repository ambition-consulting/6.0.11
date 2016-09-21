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

<%@ include file="/html/portlet/activities/init.jsp" %>

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

int start = 0;
int end = 10;

List<SocialActivity> activities = null;

if (group.isCommunity()) {
	activities = SocialActivityLocalServiceUtil.getGroupActivities(group.getGroupId(), start, end);
}
else if (group.isOrganization()) {
	activities = SocialActivityLocalServiceUtil.getOrganizationActivities(group.getOrganizationId(), start, end);
}
else if (group.isUser()) {
	activities = SocialActivityLocalServiceUtil.getUserActivities(group.getClassPK(), start, end);
}

PortletURL rssURL = renderResponse.createRenderURL();

rssURL.setParameter("rss", "1");

String taglibFeedTitle = LanguageUtil.format(pageContext, "subscribe-to-x's-activities", group.getDescriptiveName());
String taglibFeedLinkMessage = LanguageUtil.format(pageContext, "subscribe-to-x's-activities", group.getDescriptiveName());
%>

<liferay-ui:social-activities
	activities="<%= activities %>"
	feedEnabled="<%= true %>"
	feedTitle="<%= HtmlUtil.escape(taglibFeedTitle) %>"
	feedLink="<%= rssURL.toString() %>"
	feedLinkMessage="<%= HtmlUtil.escape(taglibFeedLinkMessage) %>"
/>