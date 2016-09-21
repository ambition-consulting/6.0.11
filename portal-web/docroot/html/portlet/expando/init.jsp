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

<%@ page import="com.liferay.portal.ResourcePrimKeyException" %>
<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>
<%@ page import="com.liferay.portlet.bookmarks.model.BookmarksEntry" %>
<%@ page import="com.liferay.portlet.bookmarks.model.BookmarksFolder" %>
<%@ page import="com.liferay.portlet.calendar.model.CalEvent" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFolder" %>
<%@ page import="com.liferay.portlet.expando.ColumnNameException" %>
<%@ page import="com.liferay.portlet.expando.ColumnTypeException" %>
<%@ page import="com.liferay.portlet.expando.DuplicateColumnNameException" %>
<%@ page import="com.liferay.portlet.expando.NoSuchColumnException" %>
<%@ page import="com.liferay.portlet.expando.ValueDataException" %>
<%@ page import="com.liferay.portlet.expando.model.CustomAttributesDisplay" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoBridge" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoColumn" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoColumnConstants" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoTableConstants" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue" %>
<%@ page import="com.liferay.portlet.expando.model.impl.ExpandoValueImpl" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.permission.ExpandoColumnPermission" %>
<%@ page import="com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil" %>
<%@ page import="com.liferay.portlet.expando.util.ExpandoBridgeIndexer" %>
<%@ page import="com.liferay.portlet.expando.util.comparator.CustomAttributesDisplayComparator" %>
<%@ page import="com.liferay.portlet.imagegallery.model.IGFolder" %>
<%@ page import="com.liferay.portlet.imagegallery.model.IGImage" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBCategory" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPage" %>

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>