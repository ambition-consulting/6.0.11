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

<%@ include file="/html/portlet/nested_portlets/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset label="layout-template">
		<table border="0" cellpadding="0" cellspacing="10" style="margin-top: 10px;" width="100%">

		<%
		int CELLS_PER_ROW = 4;

		String layoutTemplateId = preferences.getValue("layout-template-id", PropsValues.NESTED_PORTLETS_LAYOUT_TEMPLATE_DEFAULT);

		List layoutTemplates = LayoutTemplateLocalServiceUtil.getLayoutTemplates(theme.getThemeId());

		layoutTemplates = PluginUtil.restrictPlugins(layoutTemplates, user);

		List unsupportedLayoutTemplates = ListUtil.fromArray(PropsUtil.getArray(PropsKeys.NESTED_PORTLETS_LAYOUT_TEMPLATE_UNSUPPORTED));

		for (int i = 0; i < layoutTemplates.size(); i++) {
			LayoutTemplate curLayoutTemplate = (LayoutTemplate)layoutTemplates.get(i);

			if (unsupportedLayoutTemplates.contains(curLayoutTemplate.getLayoutTemplateId())) {
				layoutTemplates.remove(i);
			}
		}

		for (int i = 0; i < layoutTemplates.size(); i++) {
			LayoutTemplate curLayoutTemplate = (LayoutTemplate)layoutTemplates.get(i);
		%>

			<c:if test="<%= (i % CELLS_PER_ROW) == 0 %>">
				<tr>
			</c:if>

			<td align="center" width="<%= 100 / CELLS_PER_ROW %>%">
				<img onclick="document.getElementById('<portlet:namespace />layoutTemplateId<%= i %>').checked = true;" src="<%= curLayoutTemplate.getStaticResourcePath() %><%= curLayoutTemplate.getThumbnailPath() %>" /><br />

				<aui:input checked="<%= layoutTemplateId.equals(curLayoutTemplate.getLayoutTemplateId()) %>" id='<%= "layoutTemplateId" + i %>' label="<%= curLayoutTemplate.getName() %>" name="layoutTemplateId" type="radio" value="<%= curLayoutTemplate.getLayoutTemplateId() %>" />
			</td>

			<c:if test="<%= (i % CELLS_PER_ROW) == (CELLS_PER_ROW - 1) %>">
				</tr>
			</c:if>

		<%
		}
		%>

		</table>
	</aui:fieldset>

	<%
	boolean portletDecorateDefault = GetterUtil.getBoolean(theme.getSetting("portlet-setup-show-borders-default"), true);

	boolean portletSetupShowBorders = GetterUtil.getBoolean(preferences.getValue("portlet-setup-show-borders", String.valueOf(portletDecorateDefault)));
	%>

	<aui:fieldset label="display-settings">
		<aui:input inlineLabel="left" label="show-borders" name="portletSetupShowBorders" type="checkbox" value="<%= portletSetupShowBorders %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>