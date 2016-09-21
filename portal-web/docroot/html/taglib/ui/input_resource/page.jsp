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

<%@ include file="/html/taglib/init.jsp" %>

<%
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-resource:cssClass"));
String url = (String)request.getAttribute("liferay-ui:input-resource:url");
%>

<input class="form-text <%= cssClass %>" readonly="true" style="width: <%= ModelHintsConstants.TEXT_DISPLAY_WIDTH %>px;" type="text" value="<%= HtmlUtil.escapeAttribute(url) %>" onClick="Liferay.Util.selectAndCopy(this);" />