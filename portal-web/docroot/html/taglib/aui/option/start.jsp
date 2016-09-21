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
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:option:cssClass"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:option:dynamicAttributes");
String label = GetterUtil.getString((String)request.getAttribute("aui:option:label"));
boolean selected = GetterUtil.getBoolean((String)request.getAttribute("aui:option:selected"));
String style = GetterUtil.getString((String)request.getAttribute("aui:option:style"));
String value = GetterUtil.getString((String)request.getAttribute("aui:option:value"));
%>

<option <%= Validator.isNotNull(cssClass) ? "class=\"" + cssClass + "\"" : StringPool.BLANK %> <%= selected ? "selected" : StringPool.BLANK %> <%= Validator.isNotNull(style) ? "style=\"" + style + "\"" : StringPool.BLANK %> value="<%= value %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>

<c:if test="<%= Validator.isNotNull(label) %>">
	<liferay-ui:message key="<%= label %>" />
</c:if>