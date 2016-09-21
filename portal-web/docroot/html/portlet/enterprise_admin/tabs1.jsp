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
PortletURL tabs1URL = renderResponse.createRenderURL();

tabs1URL.setParameter("struts_action", "/enterprise_admin/view");

String tabs1Names = "users,organizations,user-groups";

String tabs1Values = tabs1Names;

if (!filterManageableOrganizations) {
	if (windowState.equals(WindowState.MAXIMIZED)) {
		tabs1Names += ",roles,password-policies,settings,monitoring,plugins";
	}
	else {
		tabs1Names += ",roles,&raquo;";
	}

	tabs1Values = tabs1Names;
}

String backURL = ParamUtil.getString(request, "backURL");
%>

<liferay-ui:tabs
	names="<%= tabs1Names %>"
	tabsValues="<%= tabs1Values %>"
	url="<%= tabs1URL.toString() %>"
	backURL="<%= backURL %>"
/>