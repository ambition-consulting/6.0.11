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
long groupId = ParamUtil.getLong(request, "groupId");

PortletURLImpl searchURL = new PortletURLImpl(request, PortletKeys.SEARCH, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

searchURL.setEscapeXml(true);

searchURL.setParameter("struts_action", "/search/search");
searchURL.setParameter("groupId", String.valueOf(groupId));

response.setContentType(ContentTypes.TEXT_XML_UTF8);
%>

<OpenSearchDescription xmlns="http://a9.com/-/spec/opensearch/1.1/">
	<ShortName><%= LanguageUtil.format(pageContext, "x-search", company.getName(), false) %></ShortName>
	<Description><%= LanguageUtil.format(pageContext, "x-search-provider", company.getName(), false) %></Description>
	<Url type="text/html" template="<%= searchURL.toString() %>&amp;keywords={searchTerms}" />
	<Url type="application/atom+xml" template="<%= themeDisplay.getPortalURL() %><%= PortalUtil.getPathMain() %>/search/open_search?keywords={searchTerms}&amp;p={startPage?}&amp;c={count?}&amp;format=atom" />
	<Url type="application/rss+xml" template="<%= themeDisplay.getPortalURL() %><%= PortalUtil.getPathMain() %>/search/open_search?keywords={searchTerms}&amp;p={startPage?}&amp;c={count?}&amp;format=rss" />
</OpenSearchDescription>