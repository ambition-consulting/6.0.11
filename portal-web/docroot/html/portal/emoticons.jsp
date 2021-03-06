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

<%@ include file="/html/portal/init.jsp" %>

<%@ page import="com.liferay.portlet.messageboards.util.BBCodeUtil" %>

<%
for (int i = 0; i < BBCodeUtil.EMOTICONS.length; i++) {
	String image = StringUtil.replace(BBCodeUtil.EMOTICONS[i][0], "@theme_images_path@", themeDisplay.getPathThemeImages());
%>

	<a class="lfr-button emoticon" emoticonCode="<%= BBCodeUtil.EMOTICONS[i][1] %>"><%= image %></a>

<%
}
%>