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
	<portlet:param name="struts_action" value="/journal/select_structure" />
</liferay-portlet:renderURL>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">

	<%
	StructureSearch searchContainer = new StructureSearch(renderRequest, 10, portletURL);
	%>

	<liferay-ui:header
		title="structures"
	/>

	<liferay-ui:search-form
		page="/html/portlet/journal/structure_search.jsp"
		searchContainer="<%= searchContainer %>"
	/>

	<%
	StructureSearchTerms searchTerms = (StructureSearchTerms)searchContainer.getSearchTerms();
	%>

	<%@ include file="/html/portlet/journal/structure_search_results.jspf" %>

	<div class="separator"><!-- --></div>

	<%

	List resultRows = searchContainer.getResultRows();

	for (int i = 0; i < results.size(); i++) {
		JournalStructure structure = (JournalStructure)results.get(i);

		structure = structure.toEscapedModel();

		ResultRow row = new ResultRow(structure, structure.getId(), i);

		StringBundler sb = new StringBundler(7);

		sb.append("javascript:opener.");
		sb.append(renderResponse.getNamespace());
		sb.append("selectStructure('");
		sb.append(structure.getStructureId());
		sb.append("', '");
		sb.append(structure.getName());
		sb.append("'); window.close();");

		String rowHREF = sb.toString();

		// Structure id

		row.addText(structure.getStructureId(), rowHREF);

		// Name and description

		if (Validator.isNotNull(structure.getDescription())) {
			row.addText(structure.getName().concat("<br />").concat(structure.getDescription()), rowHREF);
		}
		else {
			row.addText(structure.getName(), rowHREF);
		}

		// Add result row

		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</aui:form>

<aui:script>
	Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />searchStructureId);
</aui:script>