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
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:cssClass"));
boolean first = GetterUtil.getBoolean((String)request.getAttribute("aui:field-wrapper:first"));
String helpMessage = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:helpMessage"));
boolean inlineField = GetterUtil.getBoolean((String)request.getAttribute("aui:field-wrapper:inlineField"));
String inlineLabel = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:inlineLabel"));
String label = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:label"));
String name = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:name"));
boolean last = GetterUtil.getBoolean((String)request.getAttribute("aui:field-wrapper:last"));

boolean showForLabel = false;

if (Validator.isNotNull(name)) {
	showForLabel = true;

	name = namespace + name;
}

String fieldCss = AUIUtil.buildCss(AUIUtil.FIELD_PREFIX, "wrapper", inlineField, false, false, first, last, cssClass);
%>

<div class="<%= fieldCss %>">
	<div class="aui-field-wrapper-content">
		<c:if test='<%= Validator.isNotNull(label) && !inlineLabel.equals("right") %>'>
			<label <%= AUIUtil.buildLabel(inlineLabel, showForLabel, name) %>>
				<liferay-ui:message key="<%= label %>" />

				<c:if test="<%= Validator.isNotNull(helpMessage) %>">
					<liferay-ui:icon-help message="<%= helpMessage %>" />
				</c:if>
			</label>
		</c:if>