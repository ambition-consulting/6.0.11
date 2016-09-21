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

<%@ include file="/html/portlet/navigation/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String[] bulletStyleOptions = StringUtil.split(themeDisplay.getTheme().getSetting("bullet-style-options"));
%>

<liferay-portlet:preview
	portletName="<%= portletResource %>"
	queryString="struts_action=/navigation/view"
/>

<div class="separator"><!-- --></div>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset>
		<aui:select name="displayStyle">

			<%
			for (int i = 1; i <= 6; i++) {
			%>

				<aui:option label="<%= i %>" selected="<%= displayStyle.equals(String.valueOf(i)) %>" />

			<%
			}
			%>

			<aui:option label="custom" selected='<%= displayStyle.equals("[custom]") %>' value="[custom]" />
		</aui:select>

		<aui:select name="bulletStyle">

			<%
			for (int i = 0; i < bulletStyleOptions.length; i++) {
			%>

				<aui:option label="<%= bulletStyleOptions[i] %>" selected="<%= bulletStyleOptions[i].equals(bulletStyle) %>" />

			<%
			}
			%>

			<c:if test="<%= bulletStyleOptions.length == 0 %>">
				<aui:option label="default" value="" />
			</c:if>
		</aui:select>
	</aui:fieldset>

	<aui:fieldset>
		<div id="<portlet:namespace />customDisplayOptions">
			<aui:select label="header" name="headerType">
				<aui:option label="none" selected='<%= headerType.equals("none") %>' />
				<aui:option label="portlet-title" selected='<%= headerType.equals("portlet-title") %>' />
				<aui:option label="root-layout" selected='<%= headerType.equals("root-layout") %>' />
				<aui:option label="breadcrumb" selected='<%= headerType.equals("breadcrumb") %>' />
			</aui:select>

			<aui:select label="root-layout" name="rootLayoutType">
				<aui:option label="parent-at-level" selected='<%= rootLayoutType.equals("absolute") %>' value="absolute" />
				<aui:option label="relative-parent-up-by" selected='<%= rootLayoutType.equals("relative") %>' value="relative" />
			</aui:select>

			<aui:select name="rootLayoutLevel">

				<%
				for (int i = 0; i <= 4; i++) {
				%>

					<aui:option label="<%= i %>" selected="<%= rootLayoutLevel == i %>" />

				<%
				}
				%>

			</aui:select>

			<aui:select name="includedLayouts">
				<aui:option label="auto" selected='<%= includedLayouts.equals("auto") %>' />
				<aui:option label="all" selected='<%= includedLayouts.equals("all") %>' />
			</aui:select>

			<aui:select name="nestedChildren">
				<aui:option label="yes" selected="<%= nestedChildren %>" value="1" />
				<aui:option label="no" selected="<%= !nestedChildren %>" value="0" />
			</aui:select>
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	var select = A.one('#<portlet:namespace />displayStyle');

	var toggleCustomFields = function() {
		var customDisplayOptions = A.one('#<portlet:namespace />customDisplayOptions');

		if (customDisplayOptions) {
			var action = 'hide';

			var displayStyle = select.val();

			if (displayStyle == '[custom]') {
				action = 'show';
			}

			customDisplayOptions[action]();
		}
	}

	if (select) {
		select.on('change', toggleCustomFields);

		toggleCustomFields();
	}
</aui:script>