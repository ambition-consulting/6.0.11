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

<%@ page import="com.liferay.portal.kernel.servlet.BrowserSnifferUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.struts.StrutsUtil" %>
<%@ page import="com.liferay.portal.util.PropsValues" %>

<%
String editorImpl = ParamUtil.getString(request, "editorImpl", PropsValues.EDITOR_WYSIWYG_DEFAULT);

if (!BrowserSnifferUtil.isRtf(request)) {
	if (BrowserSnifferUtil.isSafari(request) && BrowserSnifferUtil.isMobile(request)) {
		editorImpl = "simple";
	}
	else if (BrowserSnifferUtil.isSafari(request) && (editorImpl.indexOf("simple") == -1)) {
		editorImpl = "tinymcesimple";
	}
	else {
		editorImpl = "simple";
	}
}

//editorImpl = "fckeditor";
//editorImpl = "liferay";
//editorImpl = "simple";
//editorImpl = "tinymce";
//editorImpl = "tinymcesimple";

// Resin won't allow dynamic content inside the jsp:include tag

RequestDispatcher rd = application.getRequestDispatcher(StrutsUtil.TEXT_HTML_DIR + "/js/editor/" + editorImpl + ".jsp");

rd.include(request, response);
%>

<%--<jsp:include page='<%= StrutsUtil.TEXT_HTML_DIR + "/js/editor/" + editorImpl + ".jsp" %>' />--%>