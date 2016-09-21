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

<%@ page import="com.liferay.portal.security.permission.ResourceActionsUtil" %>
<%@ page import="com.liferay.portlet.social.model.SocialEquityActionMapping" %>
<%@ page import="com.liferay.portlet.social.model.SocialEquityUser" %>
<%@ page import="com.liferay.portlet.social.service.SocialEquityGroupSettingLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.social.service.SocialEquityUserLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.social.util.comparator.SocialEquityUserRankComparator" %>