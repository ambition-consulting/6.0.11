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

<%@ include file="/html/portlet/wiki/init.jsp" %>

<%
String tagName = ParamUtil.getString(request, "tag");

String title = "pages-with-tag-x";
String description = null;

try {
	AssetTag assetTag = AssetTagLocalServiceUtil.getTag(scopeGroupId, tagName);

	AssetTagProperty assetTagProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(assetTag.getTagId(), "description");

	description = assetTagProperty.getValue();
}
catch (NoSuchTagException nste) {
}
catch (NoSuchTagPropertyException nstpe) {
}
%>

<liferay-util:include page="/html/portlet/wiki/top_links.jsp" />

<liferay-ui:header
	escapeXml="<%= false %>"
	title="<%= LanguageUtil.format(pageContext, title, HtmlUtil.escape(tagName)) %>"
/>

<c:if test="<%= Validator.isNotNull(description) %>">
	<p class="tag-description">
		<%= description %>
	</p>
</c:if>

<liferay-util:include page="/html/portlet/wiki/page_iterator.jsp">
	<liferay-util:param name="type" value="tagged_pages" />
</liferay-util:include>