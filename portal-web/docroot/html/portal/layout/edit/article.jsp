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

<%@ include file="/html/portal/layout/edit/init.jsp" %>

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="web-content-id" />
	</td>
	<td>
		<input class="lfr-input-text" name="TypeSettingsProperties--article-id--" type="text" value="<bean:write name="SEL_LAYOUT" property="typeSettingsProperties(article-id)" />" />
	</td>
</tr>
</table>