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

<%@ include file="/html/portlet/layout_set_prototypes/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

LayoutSetPrototype layoutSetPrototype = (LayoutSetPrototype)request.getAttribute(WebKeys.LAYOUT_PROTOTYPE);

if (layoutSetPrototype == null) {
	layoutSetPrototype = new LayoutSetPrototypeImpl();

	layoutSetPrototype.setNew(true);
	layoutSetPrototype.setActive(true);
}

long layoutSetPrototypeId = BeanParamUtil.getLong(layoutSetPrototype, request, "layoutSetPrototypeId");

Locale defaultLocale = LocaleUtil.getDefault();
String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

Locale[] locales = LanguageUtil.getAvailableLocales();
%>

<liferay-util:include page="/html/portlet/layout_set_prototypes/toolbar.jsp">
	<liferay-util:param name="toolbarItem" value='<%= layoutSetPrototype.isNew() ? "add" : "view-all" %>' />
</liferay-util:include>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= (layoutSetPrototype.isNew()) ? "new-site-template" : layoutSetPrototype.getName(locale) %>'
/>

<aui:form method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveLayoutSetPrototype();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="layoutSetPrototypeId" type="hidden" value="<%= layoutSetPrototypeId %>" />

	<aui:model-context bean="<%= layoutSetPrototype %>" model="<%= LayoutSetPrototype.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<aui:input name="description" />

		<aui:input inlineLabel="left" name="active" />

		<c:if test="<%= !layoutSetPrototype.isNew() %>">
			<aui:field-wrapper label="configuration">
				<liferay-portlet:actionURL var="viewURL" portletName="<%= PortletKeys.MY_PLACES %>">
					<portlet:param name="struts_action" value="/my_places/view" />
					<portlet:param name="groupId" value="<%= String.valueOf(layoutSetPrototype.getGroup().getGroupId()) %>" />
					<portlet:param name="privateLayout" value="<%= Boolean.TRUE.toString() %>" />
				</liferay-portlet:actionURL>

				<liferay-ui:icon
					image="view"
					label="<%= true %>"
					message="open-site-template"
					method="get"
					target="_blank"
					url="<%= viewURL %>"
				/>
			</aui:field-wrapper>
		</c:if>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button onClick="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />saveLayoutSetPrototype() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (layoutSetPrototype == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="struts_action" value="/layout_set_prototypes/edit_layout_set_prototype" /></portlet:actionURL>");
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</c:if>
</aui:script>

<%
if (!layoutSetPrototype.isNew()) {
	PortalUtil.addPortletBreadcrumbEntry(request, layoutSetPrototype.getName(locale), null);
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-page"), currentURL);
}
%>