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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
User selUser = (User)request.getAttribute("user.selUser");
%>

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<h3><liferay-ui:message key="open-id" /></h3>

<aui:fieldset>
	<aui:input label="" name="openId" />
</aui:fieldset>