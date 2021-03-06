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
String randomNamespace = (String)request.getAttribute("liferay-ui:search-toggle:randomNamespace");

String id = (String)request.getAttribute("liferay-ui:search-toggle:id");
DisplayTerms displayTerms = (DisplayTerms)request.getAttribute("liferay-ui:search-toggle:displayTerms");
String buttonLabel = (String)request.getAttribute("liferay-ui:search-toggle:buttonLabel");

String clickValue = GetterUtil.getString(SessionClicks.get(request, id, null), "basic");

if (clickValue.equals("basic")) {
	if (displayTerms.isAdvancedSearch()) {
		displayTerms.setAdvancedSearch(false);
	}
}
else {
	if (!displayTerms.isAdvancedSearch()) {
		displayTerms.setAdvancedSearch(true);
	}
}
%>