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

<%@ include file="/html/taglib/ui/header/init.jsp" %>

<%
if (Validator.isNotNull(backURL) && !backURL.equals("javascript:history.go(-1);")) {
	backURL = HtmlUtil.escape(HtmlUtil.escapeHREF(PortalUtil.escapeRedirect(backURL)));
}
%>

<div class="taglib-header <%= (cssClass != null) ? cssClass : "" %>">
	<c:if test="<%= Validator.isNotNull(backURL) %>">
		<span class="header-back-to">
			<a href="<%= backURL %>" id="<%= namespace %>TabsBack"><%= Validator.isNotNull(backLabel) ? backLabel : "&laquo;" + LanguageUtil.get(pageContext, "back") %></a>
		</span>
	</c:if>

	<h1 class="header-title">
		<span>
			<c:choose>
				<c:when test="<%= escapeXml %>">
					<%= HtmlUtil.escape(LanguageUtil.get(pageContext, title)) %>
				</c:when>
				<c:otherwise>
					<%= LanguageUtil.get(pageContext, title) %>
				</c:otherwise>
			</c:choose>
		</span>
	</h1>
</div>