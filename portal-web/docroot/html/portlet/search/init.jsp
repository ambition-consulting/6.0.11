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

<%@ page import="com.liferay.portal.kernel.search.OpenSearch" %>
<%@ page import="com.liferay.portal.kernel.search.OpenSearchUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchException" %>
<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.Element" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPage" %>
<%@ page import="com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.util.WikiUtil" %>

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

boolean dlLinkToViewURL = false;
boolean includeSystemPortlets = false;
%>

<%@ include file="/html/portlet/search/init-ext.jsp" %>