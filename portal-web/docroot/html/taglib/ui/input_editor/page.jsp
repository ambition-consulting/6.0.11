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
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:cssClass"));
String name = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:name"), namespace + "editor");

String editorImpl = (String)request.getAttribute("liferay-ui:input-editor:editorImpl");

if (Validator.isNull(editorImpl)) {
	editorImpl = PropsValues.EDITOR_WYSIWYG_DEFAULT;
}
else {
	editorImpl = PropsUtil.get(editorImpl);
}

String toolbarSet = (String)request.getAttribute("liferay-ui:input-editor:toolbarSet");
String initMethod = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:initMethod"), namespace + "initEditor");
String onChangeMethod = (String)request.getAttribute("liferay-ui:input-editor:onChangeMethod");
String height = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:height"), "450");
String width = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:width"), "640");

StringBundler sb = new StringBundler();

sb.append(themeDisplay.getPathContext());
sb.append("/html/js/editor/editor.jsp?p_l_id=");
sb.append(plid);

if (Validator.isNotNull(portletDisplay.getRootPortletId())) {
	sb.append("&amp;p_p_id=");
	sb.append(HttpUtil.encodeURL(portletDisplay.getRootPortletId()));
}

sb.append("&amp;p_main_path=");
sb.append(HttpUtil.encodeURL(themeDisplay.getPathMain()));

sb.append("&amp;doAsUserId=");

String doAsUserId = themeDisplay.getDoAsUserId();

if (Validator.isNull(doAsUserId)) {
	doAsUserId = Encryptor.encrypt(company.getKeyObj(), String.valueOf(themeDisplay.getUserId()));
}

sb.append(HttpUtil.encodeURL(doAsUserId));

sb.append("&amp;doAsGroupId=");
sb.append(themeDisplay.getDoAsGroupId());

sb.append("&amp;editorImpl=");
sb.append(editorImpl);

if (Validator.isNotNull(toolbarSet)) {
	sb.append("&amp;toolbarSet=");
	sb.append(toolbarSet);
}

if (Validator.isNotNull(initMethod)) {
	sb.append("&amp;initMethod=");
	sb.append(initMethod);
}

if (Validator.isNotNull(onChangeMethod)) {
	sb.append("&amp;onChangeMethod=");
	sb.append(onChangeMethod);
}

sb.append("&amp;cssPath=");
sb.append(HttpUtil.encodeURL(themeDisplay.getPathThemeCss()));

String cssClasses = "portlet ";

Portlet portlet = (Portlet)request.getAttribute(WebKeys.RENDER_PORTLET);

if (portlet != null) {
	cssClasses += portlet.getCssClassWrapper();
}

sb.append("&amp;cssClasses=");
sb.append(HttpUtil.encodeURL(cssClasses));

String editorURL = sb.toString();
%>

<iframe <%= Validator.isNotNull(cssClass) ? "class=\"" + cssClass + "\"" : StringPool.BLANK %> <%= BrowserSnifferUtil.isIe(request) && (BrowserSnifferUtil.getMajorVersion(request) <= 8) ? "frameborder=\"0\"" : StringPool.BLANK  %> height="<%= height %>" id="<%= name %>" name="<%= name %>" src="<%= editorURL %>" style="border: none;" width="<%= width %>"></iframe>