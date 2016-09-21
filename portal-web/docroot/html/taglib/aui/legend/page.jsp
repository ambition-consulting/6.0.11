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
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:legend:cssClass"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:legend:dynamicAttributes");
String label = GetterUtil.getString((String)request.getAttribute("aui:legend:label"));
%>

<legend class="aui-fieldset-legend" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>><span class="aui-legend <%= cssClass %>"><liferay-ui:message key="<%= label %>" /></span></legend>