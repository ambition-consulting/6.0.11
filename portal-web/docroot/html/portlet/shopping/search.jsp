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

<%@ include file="/html/portlet/shopping/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long breadcrumbsCategoryId = ParamUtil.getLong(request, "breadcrumbsCategoryId");

long searchCategoryId = ParamUtil.getLong(request, "searchCategoryId");
long searchCategoryIds = ParamUtil.getLong(request, "searchCategoryIds");

long[] categoryIdsArray = null;

if (searchCategoryId > 0) {
	categoryIdsArray = new long[] {searchCategoryId};
}
else {
	List categoryIds = new ArrayList();

	categoryIds.add(new Long(searchCategoryIds));

	ShoppingCategoryLocalServiceUtil.getSubcategoryIds(categoryIds, scopeGroupId, searchCategoryIds);

	categoryIdsArray = StringUtil.split(StringUtil.merge(categoryIds), 0L);
}

String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="struts_action" value="/shopping/search" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="breadcrumbsCategoryId" type="hidden" value="<%= breadcrumbsCategoryId %>" />
	<aui:input name="searchCategoryId" type="hidden" value="<%= searchCategoryId %>" />
	<aui:input name="searchCategoryIds" type="hidden" value="<%= searchCategoryIds %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="search"
	/>

	<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/shopping/search");
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("breadcrumbsCategoryId", String.valueOf(breadcrumbsCategoryId));
	portletURL.setParameter("searchCategoryId", String.valueOf(searchCategoryId));
	portletURL.setParameter("searchCategoryIds", String.valueOf(searchCategoryIds));
	portletURL.setParameter("keywords", keywords);

	List<String> headerNames = new ArrayList<String>();

	headerNames.add("sku");
	headerNames.add("description");
	headerNames.add("min-qty");
	headerNames.add("price");
	headerNames.add(StringPool.BLANK);

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

	int total = ShoppingItemLocalServiceUtil.searchCount(scopeGroupId, categoryIdsArray, keywords);

	searchContainer.setTotal(total);

	List results = ShoppingItemLocalServiceUtil.search(scopeGroupId, categoryIdsArray, keywords, searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setResults(results);

	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		ShoppingItem item = (ShoppingItem)results.get(i);

		item = item.toEscapedModel();

		ResultRow row = new ResultRow(item, item.getItemId(), i);

		PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setParameter("struts_action", "/shopping/view_item");
		rowURL.setParameter("redirect", currentURL);
		rowURL.setParameter("itemId", String.valueOf(item.getItemId()));

		// SKU and small image

		StringBundler sb = new StringBundler();

		if (item.isSmallImage()) {
			sb.append("<br />");
			sb.append("<img alt=\"");
			sb.append(item.getSku());
			sb.append("\" border=\"0\" src=\"");

			if (Validator.isNotNull(item.getSmallImageURL())) {
				sb.append(item.getSmallImageURL());
			}
			else {
				sb.append(themeDisplay.getPathImage());
				sb.append("/shopping/item?img_id=");
				sb.append(item.getSmallImageId());
				sb.append("&t=");
				sb.append(ImageServletTokenUtil.getToken(item.getSmallImageId()));
			}

			sb.append("\">");
		}
		else {
			sb.append(item.getSku());
		}

		row.addText(sb.toString(), rowURL);

		// Description

		sb = new StringBundler();

		sb.append(item.getName());

		if (Validator.isNotNull(item.getDescription())) {
			sb.append("<br />");
			sb.append(item.getDescription());
		}

		Properties props = new OrderedProperties();

		PropertiesUtil.load(props, item.getProperties());

		Enumeration enu = props.propertyNames();

		while (enu.hasMoreElements()) {
			String propsKey = (String)enu.nextElement();
			String propsValue = props.getProperty(propsKey, StringPool.BLANK);

			sb.append("<br />");
			sb.append(propsKey);
			sb.append(": ");
			sb.append(propsValue);
		}

		row.addText(sb.toString(), rowURL);

		// Minimum quantity

		row.addText(String.valueOf(item.getMinQuantity()), rowURL);

		// Price

		if (item.getDiscount() <= 0) {
			row.addText(currencyFormat.format(item.getPrice()), rowURL);
		}
		else {
			row.addText("<div class=\"portlet-msg-success\">" + currencyFormat.format(ShoppingUtil.calculateActualPrice(item)) + "</div>", rowURL);
		}

		// Action

		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/shopping/item_action.jsp");

		// Add result row

		resultRows.add(row);
	}
	%>

	<aui:fieldset>
		<aui:input label="" name="keywords" size="30" title="search" value="<%= keywords %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="search" />
	</aui:button-row>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />keywords);
	</aui:script>
</c:if>