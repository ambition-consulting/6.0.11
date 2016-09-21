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

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portlet.blogs.EntryContentException" %>
<%@ page import="com.liferay.portlet.blogs.EntryDisplayDateException" %>
<%@ page import="com.liferay.portlet.blogs.EntryTitleException" %>
<%@ page import="com.liferay.portlet.blogs.NoSuchEntryException" %>
<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.service.permission.BlogsEntryPermission" %>
<%@ page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String selectionMethod = preferences.getValue("selection-method", "users");
long organizationId = GetterUtil.getLong(preferences.getValue("organization-id", "0"));
String displayStyle = preferences.getValue("display-style", "abstract");
int max = GetterUtil.getInteger(preferences.getValue("max", "20"));
boolean enableRssSubscription = GetterUtil.getBoolean(preferences.getValue("enable-rss-subscription", null), true);
boolean showTags = GetterUtil.getBoolean(preferences.getValue("show-tags", null), true);

if (organizationId == 0) {
	Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

	if (group.isOrganization()) {
		organizationId = group.getOrganizationId();
	}
}

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>