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

<%@ include file="/html/portlet/communities/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "current");

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);

String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

Group group = (Group)request.getAttribute(WebKeys.GROUP);

String groupName = group.getDescriptiveName();

Role role = (Role)request.getAttribute(WebKeys.ROLE);

long roleId = BeanParamUtil.getLong(role, request, "roleId");

int roleType = RoleConstants.TYPE_COMMUNITY;

Organization organization = null;

if (group.isOrganization()) {
	roleType = RoleConstants.TYPE_ORGANIZATION;

	organization = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/communities/edit_user_roles");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("groupId", String.valueOf(group.getGroupId()));

// Breadcrumbs

if (organization != null) {
	EnterpriseAdminUtil.addPortletBreadcrumbEntries(organization, request, renderResponse);
}
else if (group != null) {
	PortalUtil.addPortletBreadcrumbEntry(request, group.getDescriptiveName(), null);
}

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "assign-user-roles"), portletURL.toString());

if (role != null) {
	portletURL.setParameter("roleId", String.valueOf(roleId));

	PortalUtil.addPortletBreadcrumbEntry(request, HtmlUtil.escape(role.getTitle(locale)), currentURL);
}

request.setAttribute("edit_user_roles.jsp-tabs1", tabs1);

request.setAttribute("edit_user_roles.jsp-cur", cur);

request.setAttribute("edit_user_roles.jsp-redirect", redirect);

request.setAttribute("edit_user_roles.jsp-group", group);
request.setAttribute("edit_user_roles.jsp-groupName", groupName);
request.setAttribute("edit_user_roles.jsp-role", role);
request.setAttribute("edit_user_roles.jsp-roleId", roleId);
request.setAttribute("edit_user_roles.jsp-roleType", roleType);
request.setAttribute("edit_user_roles.jsp-organization", organization);

request.setAttribute("edit_user_roles.jsp-portletURL", portletURL);
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title="<%= group.getDescriptiveName() %>"
/>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="tabs1" type="hidden" value="<%= tabs1 %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="groupId" type="hidden" value="<%= String.valueOf(group.getGroupId()) %>" />
	<aui:input name="roleId" type="hidden" value="<%= roleId %>" />

	<c:choose>
		<c:when test="<%= role == null %>">
			<liferay-util:include page="/html/portlet/communities/edit_user_roles_role.jsp" />
		</c:when>
		<c:otherwise>
			<liferay-util:include page="/html/portlet/communities/edit_user_roles_users.jsp" />
		</c:otherwise>
	</c:choose>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateUserGroupRoleUsers',
		function(redirect) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "user_group_role_users";
			document.<portlet:namespace />fm.<portlet:namespace />redirect.value = redirect;
			document.<portlet:namespace />fm.<portlet:namespace />addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			document.<portlet:namespace />fm.<portlet:namespace />removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
			submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="struts_action" value="/communities/edit_user_roles" /></portlet:actionURL>");
		},
		['liferay-util-list-fields']
	);
</aui:script>