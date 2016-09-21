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

<%@ page import="com.liferay.portlet.asset.NoSuchTagException" %>
<%@ page import="com.liferay.portlet.asset.NoSuchTagPropertyException" %>
<%@ page import="com.liferay.portlet.asset.model.AssetTag" %>
<%@ page import="com.liferay.portlet.asset.model.AssetTagProperty" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagPropertyLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.xslcontent.util.XSLContentUtil" %>

<%@ page import="java.net.URL" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String xmlURL = ParamUtil.getString(request, "xmlURL", preferences.getValue("xml-url", XSLContentUtil.DEFAULT_XML_URL));
String xslURL = ParamUtil.getString(request, "xslURL", preferences.getValue("xsl-url", XSLContentUtil.DEFAULT_XSL_URL));
%>