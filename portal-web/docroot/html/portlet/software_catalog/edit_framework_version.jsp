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

<%@ include file="/html/portlet/software_catalog/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

SCFrameworkVersion frameworkVersion = (SCFrameworkVersion)request.getAttribute(WebKeys.SOFTWARE_CATALOG_FRAMEWORK_VERSION);

long frameworkVersionId = BeanParamUtil.getLong(frameworkVersion, request, "frameworkVersionId");
%>

<form action="<portlet:actionURL><portlet:param name="struts_action" value="/software_catalog/edit_framework_version" /></portlet:actionURL>" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />saveFrameworkVersion(); return false;">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escapeAttribute(redirect) %>" />
<input name="<portlet:namespace />frameworkVersionId" type="hidden" value="<%= frameworkVersionId %>" />

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (frameworkVersion != null) ? frameworkVersion.getName() : "new-framework-version" %>'
/>

<liferay-ui:error exception="<%= FrameworkVersionNameException.class %>" message="please-enter-a-valid-name" />

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="name" />
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="name" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="url" />
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="url" />
	</td>
</tr>
<tr>
	<td>
		<liferay-ui:message key="active" />
	</td>
	<td>
		<liferay-ui:input-field model="<%= SCFrameworkVersion.class %>" bean="<%= frameworkVersion %>" field="active" defaultValue="<%= Boolean.TRUE %>" />
	</td>
</tr>

<c:if test="<%= frameworkVersion == null %>">
	<tr>
		<td colspan="2">
			<br />
		</td>
	</tr>
	<tr>
		<td>
			<liferay-ui:message key="permissions" />
		</td>
		<td>
			<liferay-ui:input-permissions
				modelName="<%= SCFrameworkVersion.class.getName() %>"
			/>
		</td>
	</tr>
</c:if>

</table>

<br />

<input type="submit" value="<liferay-ui:message key="save" />" />

<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(PortalUtil.escapeRedirect(redirect)) %>';" />

</form>

<aui:script>
	function <portlet:namespace />saveFrameworkVersion() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (frameworkVersion == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</c:if>
</aui:script>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/software_catalog/view");
portletURL.setParameter("tabs1", "framework_versions");

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "framework-versions"), portletURL.toString());

if (frameworkVersion != null) {
	PortalUtil.addPortletBreadcrumbEntry(request, frameworkVersion.getName(), null);
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-framework-version"), currentURL);
}
%>