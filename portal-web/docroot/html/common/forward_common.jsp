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

<%@ include file="/html/common/init.jsp" %>

<%
String forwardURL = null;

String forwardParam = PortalUtil.escapeRedirect(request.getParameter(WebKeys.FORWARD_URL));
String forwardRequest = (String)request.getAttribute(WebKeys.FORWARD_URL);
String forwardSession = (String)session.getAttribute(WebKeys.FORWARD_URL);

if ((forwardParam != null) && (!forwardParam.equals(StringPool.NULL)) && (!forwardParam.equals(StringPool.BLANK))) {
	forwardURL = forwardParam;
}
else if ((forwardRequest != null) && (!forwardRequest.equals(StringPool.NULL)) && (!forwardRequest.equals(StringPool.BLANK))) {
	forwardURL = forwardRequest;
}
else if ((forwardSession != null) && (!forwardSession.equals(StringPool.NULL)) && (!forwardSession.equals(StringPool.BLANK))) {
	forwardURL = forwardSession;
}
else if (themeDisplay != null) {
	forwardURL = themeDisplay.getPathMain();
}
else {
	forwardURL = PortalUtil.getPathMain();
}
%>