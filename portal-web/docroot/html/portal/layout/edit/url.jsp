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
		<liferay-ui:message key="url" />
	</td>
	<td>
		<input class="lfr-input-text" name="TypeSettingsProperties--url--" type="text" value="<bean:write name="SEL_LAYOUT" property="typeSettingsProperties(url)" />" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="description" />
	</td>
	<td>
		<textarea class="lfr-textarea" name="TypeSettingsProperties--description--" wrap="soft"><bean:write name="SEL_LAYOUT" property="typeSettingsProperties(description)" /></textarea>
	</td>
</tr>
</table>