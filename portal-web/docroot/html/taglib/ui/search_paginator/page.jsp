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

<%@ include file="/html/taglib/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

String type = (String)request.getAttribute("liferay-ui:search:type");

PortletURL iteratorURL = searchContainer.getIteratorURL();

String url = StringPool.BLANK;

if (iteratorURL != null) {
	url = HttpUtil.removeParameter(iteratorURL.toString(), namespace + searchContainer.getCurParam());
}
%>

<liferay-ui:page-iterator
	cur="<%= searchContainer.getCur() %>"
	curParam="<%= searchContainer.getCurParam() %>"
	delta="<%= searchContainer.getDelta() %>"
	deltaConfigurable="<%= searchContainer.isDeltaConfigurable() %>"
	deltaParam="<%= searchContainer.getDeltaParam() %>"
	maxPages="<%= PropsValues.SEARCH_CONTAINER_PAGE_ITERATOR_MAX_PAGES %>"
	total="<%= searchContainer.getTotal() %>"
	type="<%= type %>"
	url="<%= url %>"
/>