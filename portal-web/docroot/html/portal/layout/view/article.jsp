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

<%@ include file="/html/portal/init.jsp" %>

<%
String articleId = layout.getTypeSettingsProperties().getProperty("article-id");
String languageId = LanguageUtil.getLanguageId(request);

String content = JournalContentUtil.getContent(scopeGroupId, articleId, null, languageId, themeDisplay);
%>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td>
		<%= content %>
	</td>
</tr>
</table>

<%@ include file="/html/portal/layout/view/common.jspf" %>