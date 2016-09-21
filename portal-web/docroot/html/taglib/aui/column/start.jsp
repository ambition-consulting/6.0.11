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
int columnWidth = GetterUtil.getInteger((String)request.getAttribute("aui:column:columnWidth"));
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:column:cssClass"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:column:dynamicAttributes");
boolean first = GetterUtil.getBoolean((String)request.getAttribute("aui:column:first"));
boolean last = GetterUtil.getBoolean((String)request.getAttribute("aui:column:last"));

String cssClasses = StringPool.BLANK;

if (Validator.isNotNull(cssClass)) {
	for (String curCssClass : StringUtil.split(cssClass, StringPool.SPACE)) {
		cssClasses += curCssClass + "-content ";
	}
}
%>

<div class="aui-column <%= (columnWidth > 0) ? "aui-w" + columnWidth : StringPool.BLANK %> <%= cssClass %> <%= first ? "aui-column-first" : StringPool.BLANK %> <%= last ? "aui-column-last" : StringPool.BLANK %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
	<div class="aui-column-content <%= first ? "aui-column-content-first" : StringPool.BLANK %> <%= last ? "aui-column-content-last" : StringPool.BLANK %> <%= cssClasses %>">