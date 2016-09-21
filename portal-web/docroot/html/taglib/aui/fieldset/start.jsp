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
boolean column = GetterUtil.getBoolean((String)request.getAttribute("aui:fieldset:column"));
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:fieldset:cssClass"));
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:fieldset:dynamicAttributes");
String label = GetterUtil.getString((String)request.getAttribute("aui:fieldset:label"));
%>

<fieldset class="aui-fieldset <%= cssClass %> <%= column ? "aui-column aui-form-column" : StringPool.BLANK %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
	<c:if test="<%= Validator.isNotNull(label) %>">
		<aui:legend label="<%= label %>" />
	</c:if>

	<div class="aui-fieldset-content <%= column ? "aui-column-content" : StringPool.BLANK %>">