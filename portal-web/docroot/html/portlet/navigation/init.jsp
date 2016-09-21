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

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String bulletStyle = GetterUtil.getString(preferences.getValue("bullet-style", null), "1");
String displayStyle = GetterUtil.getString(preferences.getValue("display-style", null), "1");

String headerType = GetterUtil.getString(preferences.getValue("header-type", null), "root-layout");

String rootLayoutType = GetterUtil.getString(preferences.getValue("root-layout-type", null), "absolute");
int rootLayoutLevel = GetterUtil.getInteger(preferences.getValue("root-layout-level", null), 1);

String includedLayouts = GetterUtil.getString(preferences.getValue("included-layouts", null), "current");

boolean nestedChildren = GetterUtil.getBoolean(preferences.getValue("nested-children", null), true);
%>