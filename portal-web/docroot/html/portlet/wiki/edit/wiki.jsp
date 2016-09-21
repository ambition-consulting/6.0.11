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
WikiPage wikiPage = (WikiPage)request.getAttribute("edit_page.jsp-wikiPage");

String format = BeanParamUtil.getString(wikiPage, request, "format", WikiPageConstants.DEFAULT_FORMAT);
%>

<div align="right">
	<liferay-ui:toggle
		id="toggle_id_wiki_edit_wiki_syntax_help"
		showMessage='<%= "&laquo; " + LanguageUtil.get(pageContext, "show-syntax-help") %>'
		hideMessage='<%= LanguageUtil.get(pageContext, "hide-syntax-help") + " &raquo;" %>'
	/>
</div>

<table class="lfr-table" width="100%">
<tr>
	<td class="lfr-top" width="70%">
		<liferay-ui:input-field model="<%= WikiPage.class %>" bean="<%= wikiPage %>" field="content" />
	</td>
	<td class="syntax-help" id="toggle_id_wiki_edit_wiki_syntax_help" style="display: <liferay-ui:toggle-value id="toggle_id_wiki_edit_wiki_syntax_help" />" valign="top">
		<h3>
			<liferay-ui:message key="syntax-help" />
		</h3>

		<liferay-util:include page="<%= WikiUtil.getHelpPage(format) %>" />

		<aui:a href="<%= WikiUtil.getHelpURL(format) %>" target="_blank"><liferay-ui:message key="learn-more" /> &raquo;</aui:a>
	</td>
</tr>
</table>