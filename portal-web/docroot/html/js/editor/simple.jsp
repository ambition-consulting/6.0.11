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
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%
String initMethod = ParamUtil.get(request, "initMethod", DEFAULT_INIT_METHOD);
String onChangeMethod = ParamUtil.getString(request, "onChangeMethod");
%>

<html>

<head>
	<title>Editor</title>

	<script type="text/javascript">
		function getHTML() {
			return document.getElementById("textArea").value;
		}

		function setHTML(value) {
			document.getElementById("textArea").value = value;
		}

		function initEditor() {
			setHTML(parent.<%= initMethod %>());
		}
	</script>
</head>

<body leftmargin="0" marginheight="0" marginwidth="0" rightmargin="0" topmargin="0" onLoad="initEditor();">

<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0" height="100%" width="100%">
<tr>
	<td bgcolor="#FFFFFF" height="100%">
		<textarea style="font-family: monospace; height: 100%; width: 100%;" id="textArea" name="textArea"

		<%
		if (Validator.isNotNull(onChangeMethod)) {
		%>

			onChange="parent.<%= HtmlUtil.escape(onChangeMethod) %>(this.value)"

		<%
		}
		%>

		></textarea>
	</td>
</tr>
</table>

</body>

</html>

<%!
public static final String DEFAULT_INIT_METHOD = "initEditor";
%>