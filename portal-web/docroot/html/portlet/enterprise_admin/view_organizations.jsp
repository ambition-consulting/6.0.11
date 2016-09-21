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
PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");

String viewOrganizationsRedirect = ParamUtil.getString(request, "viewOrganizationsRedirect");

if (Validator.isNotNull(viewOrganizationsRedirect)) {
	portletURL.setParameter("viewOrganizationsRedirect", viewOrganizationsRedirect);
}
%>

<liferay-ui:error exception="<%= RequiredOrganizationException.class %>" message="you-cannot-delete-organizations-that-have-suborganizations-or-users" />

<liferay-util:include page="/html/portlet/enterprise_admin/organization/toolbar.jsp">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<c:if test="<%= Validator.isNotNull(viewOrganizationsRedirect) %>">
	<aui:input name="viewOrganizationsRedirect" type="hidden" value="<%= viewOrganizationsRedirect %>" />
</c:if>

<liferay-ui:search-container
	rowChecker="<%= new RowChecker(renderResponse) %>"
	searchContainer="<%= new OrganizationSearch(renderRequest, portletURL) %>"
>
	<aui:input name="deleteOrganizationIds" type="hidden" />
	<aui:input name="organizationsRedirect" type="hidden" value="<%= portletURL.toString() %>" />

	<liferay-ui:search-form
		page="/html/portlet/enterprise_admin/organization_search.jsp"
	/>

	<%
	OrganizationSearchTerms searchTerms = (OrganizationSearchTerms)searchContainer.getSearchTerms();

	LinkedHashMap organizationParams = new LinkedHashMap();

	if (filterManageableOrganizations) {
		Long[][] leftAndRightOrganizationIds = EnterpriseAdminUtil.getLeftAndRightOrganizationIds(user.getOrganizations());

		organizationParams.put("organizationsTree", leftAndRightOrganizationIds);
	}

	long parentOrganizationId = ParamUtil.getLong(request, "parentOrganizationId", OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID);

	if (parentOrganizationId <= 0) {
		parentOrganizationId = OrganizationConstants.ANY_PARENT_ORGANIZATION_ID;
	}
	%>

	<liferay-ui:search-container-results>
		<c:choose>
			<c:when test="<%= PropsValues.ORGANIZATIONS_SEARCH_WITH_INDEX %>">
				<%@ include file="/html/portlet/enterprise_admin/organization_search_results_index.jspf" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/html/portlet/enterprise_admin/organization_search_results_database.jspf" %>
			</c:otherwise>
		</c:choose>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Organization"
		escapedModel="<%= true %>"
		keyProperty="organizationId"
		modelVar="organization"
	>
		<portlet:renderURL var="rowURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_organization" />
			<portlet:param name="redirect" value="<%= searchContainer.getIteratorURL().toString() %>" />
			<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>" />
		</portlet:renderURL>

		<%
		if (!OrganizationPermissionUtil.contains(permissionChecker, organization.getOrganizationId(), ActionKeys.UPDATE)) {
			rowURL = null;
		}
		%>

		<%@ include file="/html/portlet/enterprise_admin/organization/search_columns.jspf" %>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/portlet/enterprise_admin/organization_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<c:if test="<%= !results.isEmpty() %>">
		<div class="separator"><!-- --></div>

		<aui:button onClick='<%= renderResponse.getNamespace() + "deleteOrganizations();" %>' value="delete" />
	</c:if>

	<br />

	<liferay-ui:search-iterator />
</liferay-ui:search-container>