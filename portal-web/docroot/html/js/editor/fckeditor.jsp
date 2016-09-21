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

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%
long plid = ParamUtil.getLong(request, "p_l_id");
String portletId = ParamUtil.getString(request, "p_p_id");
String mainPath = ParamUtil.getString(request, "p_main_path");
String doAsUserId = ParamUtil.getString(request, "doAsUserId");
String doAsGroupId = ParamUtil.getString(request, "doAsGroupId");
String initMethod = ParamUtil.getString(request, "initMethod", DEFAULT_INIT_METHOD);
String onChangeMethod = ParamUtil.getString(request, "onChangeMethod");
String toolbarSet = ParamUtil.getString(request, "toolbarSet", "liferay");
String cssPath = ParamUtil.getString(request, "cssPath");
String cssClasses = ParamUtil.getString(request, "cssClasses");

// To upgrade FCKEditor, download the latest version and unzip it to fckeditor.
// Add custom configuration to fckeditor/fckconfig.jsp. Copy
// fckeditor/editor/filemanager/browser/default to
// fckeditor/editor/filemanager/browser/liferay. Modify browser.html,
// frmresourceslist.html, frmresourcetype.html, and frmupload.html.

%>

<html>

<head>
	<title>Editor</title>

	<script src="fckeditor/fckeditor.js" type="text/javascript"></script>

	<script type="text/javascript">
		function getHTML() {
			return FCKeditorAPI.GetInstance("FCKeditor1").GetXHTML();
		}

		function getText() {
			return FCKeditorAPI.GetInstance("FCKeditor1").GetXHTML();
		}

		function initFckArea() {

			// LEP-3563

			if (!window.frameElement || (!document.all && window.frameElement.clientWidth == 0)) {

				// This is hack since FCKEditor doesn't initialize properly in
				// Gecko if the editor is hidden.

				setTimeout('initFckArea();',250);
			}
			else {
				var textArea = document.getElementById("FCKeditor1");

				textArea.value = parent.<%= HtmlUtil.escape(initMethod) %>();

				var fckEditor = new FCKeditor("FCKeditor1");

				fckEditor.Config["CustomConfigurationsPath"] = "<%= PortalUtil.getPathContext() %>/html/js/editor/fckeditor/fckconfig.jsp?p_l_id=<%= plid %>&p_p_id=<%= HttpUtil.encodeURL(portletId) %>&p_main_path=<%= HttpUtil.encodeURL(mainPath) %>&doAsUserId=<%= HttpUtil.encodeURL(doAsUserId) %>&doAsGroupId=<%= HttpUtil.encodeURL(doAsGroupId) %>&cssPath=<%= HttpUtil.encodeURL(cssPath) %>&cssClasses=<%= HttpUtil.encodeURL(cssClasses) %>";

				fckEditor.BasePath = "fckeditor/";
				fckEditor.Width = "100%";
				fckEditor.Height = "100%";
				fckEditor.ToolbarSet = '<%= HtmlUtil.escape(toolbarSet) %>';

				fckEditor.ReplaceTextarea();

				// LEP-5707

				var ua = navigator.userAgent, isFirefox2andBelow = false;
				var agent = /(Firefox)\/(.+)/.exec(ua);

				if (agent && agent.length && (agent.length == 3)) {
					if (parseInt(agent[2]) && parseInt(agent[2]) < 3) {
						isFirefox2andBelow = true;
					}
				}

				if (isFirefox2andBelow) {
					var fckInstanceName = fckEditor.InstanceName;
					var fckIframe = document.getElementById(fckInstanceName + '___Frame');

					var interval = setInterval(
						function() {
							var iframe = fckIframe.contentDocument.getElementsByTagName('iframe');

							if (iframe.length) {
								iframe = iframe[0];

								iframe.onload = function(event) {
									clearInterval(interval);
									parent.stop();
								};
							}
						},
						500);
				}
			}

			setInterval(
				function() {
					try {
						onChangeCallback();
					}
					catch(e) {
					}
				},
				300
			);
		}

		function setHTML(value) {
			FCKeditorAPI.GetInstance("FCKeditor1").SetHTML(value);
		}

		function onChangeCallback() {

			<%
			if (Validator.isNotNull(onChangeMethod)) {
			%>

				var dirty = FCKeditorAPI.GetInstance("FCKeditor1").IsDirty();

				if (dirty) {
					parent.<%= HtmlUtil.escape(onChangeMethod) %>(getText());

					FCKeditorAPI.GetInstance("FCKeditor1").ResetIsDirty();
				}

			<%
			}
			%>

		}

		window.onload = function() {
			initFckArea();
		}
	</script>
</head>

<body leftmargin="0" marginheight="0" marginwidth="0" rightmargin="0" topmargin="0">

<textarea id="FCKeditor1" name="FCKeditor1" style="display: none"></textarea>

</body>

</html>

<%!
public static final String DEFAULT_INIT_METHOD = "initEditor";
%>