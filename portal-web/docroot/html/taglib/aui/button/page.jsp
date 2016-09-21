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
String cssClass = GetterUtil.getString((String)request.getAttribute("aui:button:cssClass"));
boolean disabled = GetterUtil.getBoolean((String)request.getAttribute("aui:button:disabled"));
Map<String, Object> data = (Map<String, Object>)request.getAttribute("aui:button:data");
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:button:dynamicAttributes");
String inputCssClass = GetterUtil.getString((String)request.getAttribute("aui:button:inputCssClass"));
String name = GetterUtil.getString((String)request.getAttribute("aui:button:name"));
String onClick = GetterUtil.getString((String)request.getAttribute("aui:button:onClick"));
String type = GetterUtil.getString((String)request.getAttribute("aui:button:type"));
String value = (String)request.getAttribute("aui:button:value");

if (onClick.startsWith(Http.HTTP_WITH_SLASH) || onClick.startsWith(Http.HTTPS_WITH_SLASH) || onClick.startsWith(StringPool.SLASH)) {
	onClick = "location.href = '" + HtmlUtil.escape(PortalUtil.escapeRedirect(onClick)) + "';";
}
else if (onClick.startsWith("wsrp_rewrite?")){
	onClick = "location.href = '" + HtmlUtil.escape(onClick) + "';";
}
%>

<span class="<%= AUIUtil.buildCss(AUIUtil.BUTTON_PREFIX, type, false, disabled, false, false, false, cssClass) %>">
	<span class="aui-button-content">
		<input class="<%= AUIUtil.buildCss(AUIUtil.BUTTON_INPUT_PREFIX, type, false, false, false, false, false, inputCssClass) %>" <%= disabled ? "disabled" : StringPool.BLANK %> <%= Validator.isNotNull(name) ? "id=\"" + namespace + name + "\"" : StringPool.BLANK %> <%= Validator.isNotNull(onClick) ? "onClick=\"" + onClick + "\"" : StringPool.BLANK %> type='<%= type.equals("cancel") ? "button" : type %>' value="<%= LanguageUtil.get(pageContext, value) %>" <%= AUIUtil.buildData(data) %> <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %> />
	</span>
</span>