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
long categoryId = GetterUtil.getLong(ParamUtil.getString(request, "categoryId"));

String categoryName = null;
String vocabularyName = null;

if (categoryId != 0) {
	AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);

	categoryName = assetCategory.getName();

	AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(assetCategory.getVocabularyId());

	vocabularyName = assetVocabulary.getName();
}
%>

<liferay-util:include page="/html/portlet/wiki/top_links.jsp" />

<liferay-ui:header
	escapeXml="<%= false %>"
	title='<%= LanguageUtil.format(pageContext, "pages-with-x-x", new String[] {vocabularyName, categoryName}) %>'
/>

<liferay-util:include page="/html/portlet/wiki/page_iterator.jsp">
	<liferay-util:param name="type" value="categorized_pages" />
</liferay-util:include>