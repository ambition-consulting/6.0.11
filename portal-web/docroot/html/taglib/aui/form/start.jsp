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
String action = GetterUtil.getString((String)request.getAttribute("aui:form:action"));
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:form:cssClass"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:form:dynamicAttributes");
boolean inlineLabels = GetterUtil.getBoolean((String)request.getAttribute("aui:form:inlineLabels"));
String name = GetterUtil.getString((String)request.getAttribute("aui:form:name"));
%>

<form action="<%= action %>" class="aui-form <%= cssClass %> <%= inlineLabels ? "aui-field-labels-inline" : StringPool.BLANK %>" id="<%= namespace + name %>" name="<%= namespace + name %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>