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

<%@ page import="com.liferay.portlet.polls.DuplicateVoteException" %>
<%@ page import="com.liferay.portlet.polls.NoSuchChoiceException" %>
<%@ page import="com.liferay.portlet.polls.NoSuchQuestionException" %>
<%@ page import="com.liferay.portlet.polls.QuestionExpiredException" %>
<%@ page import="com.liferay.portlet.polls.model.PollsChoice" %>
<%@ page import="com.liferay.portlet.polls.model.PollsQuestion" %>
<%@ page import="com.liferay.portlet.polls.model.PollsVote" %>
<%@ page import="com.liferay.portlet.polls.service.PollsChoiceLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.polls.service.PollsVoteLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.polls.service.PollsVoteServiceUtil" %>
<%@ page import="com.liferay.portlet.polls.service.permission.PollsQuestionPermission" %>
<%@ page import="com.liferay.portlet.polls.util.PollsUtil" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

long questionId = GetterUtil.getLong(preferences.getValue("question-id", StringPool.BLANK));

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>