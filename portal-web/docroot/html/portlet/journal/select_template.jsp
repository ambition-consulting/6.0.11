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

<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param name="struts_action" value="/journal/select_template" />
</liferay-portlet:renderURL>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">

	<%
	TemplateSearch searchContainer = new TemplateSearch(renderRequest, 10, portletURL);
	%>

	<liferay-ui:header
		title="templates"
	/>

	<liferay-ui:search-form
		page="/html/portlet/journal/template_search.jsp"
		searchContainer="<%= searchContainer %>"
	/>

	<%
	TemplateSearchTerms searchTerms = (TemplateSearchTerms)searchContainer.getSearchTerms();

	searchTerms.setStructureId(StringPool.BLANK);
	searchTerms.setStructureIdComparator(StringPool.NOT_EQUAL);
	%>

	<%@ include file="/html/portlet/journal/template_search_results.jspf" %>

	<div class="separator"><!-- --></div>

	<%

	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		JournalTemplate template = (JournalTemplate)results.get(i);

		template = template.toEscapedModel();

		ResultRow row = new ResultRow(template, template.getId(), i);

		StringBundler sb = new StringBundler(7);

		sb.append("javascript:opener.");
		sb.append(renderResponse.getNamespace());
		sb.append("selectTemplate('");
		sb.append(template.getStructureId());
		sb.append("', '");
		sb.append(template.getTemplateId());
		sb.append("'); window.close();");

		String rowHREF = sb.toString();

		row.setParameter("rowHREF", rowHREF);

		// Template id

		row.addText(template.getTemplateId(), rowHREF);

		// Name, description, and image

		row.addJSP("/html/portlet/journal/template_description.jsp");

		// Add result row

		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>

<aui:script>
	Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />searchTemplateId);
</aui:script>