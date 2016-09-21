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

<c:choose>
	<c:when test="<%= themeDisplay.isFacebook() || themeDisplay.isStateExclusive() %>">

		<%
		StringBundler sb = (StringBundler)request.getAttribute(WebKeys.LAYOUT_CONTENT);

		sb.writeTo(out);

		request.removeAttribute(WebKeys.LAYOUT_CONTENT);
		%>

	</c:when>
	<c:when test="<%= themeDisplay.isStatePopUp() || themeDisplay.isWidget() %>">
		<liferay-theme:include page="portal_pop_up.jsp" />
	</c:when>
	<c:otherwise>
		<liferay-theme:include page="portal_normal.jsp" />
	</c:otherwise>
</c:choose>

<%
SessionMessages.clear(request);
SessionErrors.clear(request);
%>