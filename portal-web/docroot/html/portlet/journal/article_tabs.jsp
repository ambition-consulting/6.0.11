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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String originalRedirect = ParamUtil.getString(request, "originalRedirect", StringPool.BLANK);

if (originalRedirect.equals(StringPool.BLANK)) {
	originalRedirect = redirect;
}
else {
	redirect = originalRedirect;
}

JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);

PortletURL editArticleURL = renderResponse.createRenderURL();

editArticleURL.setParameter("struts_action", "/journal/edit_article");
editArticleURL.setParameter("redirect", redirect);

if (article != null) {
	editArticleURL.setParameter("groupId", String.valueOf(article.getGroupId()));
	editArticleURL.setParameter("articleId", article.getArticleId());
}

PortletURL viewArticleHistoryURL = renderResponse.createRenderURL();

viewArticleHistoryURL.setParameter("struts_action", "/journal/view_article_history");
viewArticleHistoryURL.setParameter("redirect", redirect);

if (article != null) {
	viewArticleHistoryURL.setParameter("groupId", String.valueOf(article.getGroupId()));
	viewArticleHistoryURL.setParameter("articleId", article.getArticleId());
}
%>

<c:choose>
	<c:when test="<%= article != null %>">
		<liferay-ui:header
			backURL="<%= redirect %>"
			title='<%= article.getTitle() %>'
		/>

		<liferay-ui:tabs
			names="content,history"
			url0="<%= editArticleURL.toString() %>"
			url1="<%= viewArticleHistoryURL.toString() %>"
		/>
	</c:when>
	<c:otherwise>
		<liferay-ui:header
			backURL="<%= redirect %>"
			title="new-web-content"
		/>
	</c:otherwise>
</c:choose>