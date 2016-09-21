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
String tabs4 = (String)request.getAttribute("edit_pages.jsp-tab4");

long groupId = ((Long)request.getAttribute("edit_pages.jsp-groupId")).longValue();
long liveGroupId = ((Long)request.getAttribute("edit_pages.jsp-liveGroupId")).longValue();
long selPlid = ((Long)request.getAttribute("edit_pages.jsp-selPlid")).longValue();
boolean privateLayout = ((Boolean)request.getAttribute("edit_pages.jsp-privateLayout")).booleanValue();
Layout selLayout = (Layout)request.getAttribute("edit_pages.jsp-selLayout");

PortletURL portletURL = (PortletURL)request.getAttribute("edit_pages.jsp-portletURL");
%>

<liferay-ui:tabs
	names="regular-browsers,mobile-devices"
	param="tabs4"
	url='<%= portletURL.toString() + "&" + renderResponse.getNamespace() + "selPlid=" + selPlid %>'
/>

<c:choose>
	<c:when test='<%= tabs4.equals("regular-browsers") %>'>

		<%
		Theme selTheme = null;
		ColorScheme selColorScheme = null;

		if (selLayout != null) {
			selTheme = selLayout.getTheme();
			selColorScheme = selLayout.getColorScheme();
		}
		else {
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);

			selTheme = layoutSet.getTheme();
			selColorScheme = layoutSet.getColorScheme();
		}
		%>

		<c:if test="<%= selLayout != null %>">
			<table class="lfr-table">
			<tr>
				<td class="lfr-label">
					<%= LanguageUtil.get(pageContext, "use-the-general-look-and-feel-for-the-" + (privateLayout ? "private" : "public") + "-pages") %>
				</td>
				<td>
					<select name="<portlet:namespace />hidden" onChange="if (this.value == 1) { <portlet:namespace />updateLookAndFeel('', ''); } else { <portlet:namespace />updateLookAndFeel('<%= selTheme.getThemeId() %>', '<%= selColorScheme.getColorSchemeId() %>'); }">
						<option <%= (selLayout.isInheritLookAndFeel()) ? "selected" : "" %> value="1"><liferay-ui:message key="yes" /></option>
						<option <%= (!selLayout.isInheritLookAndFeel()) ? "selected" : "" %> value="0"><liferay-ui:message key="no" /></option>
					</select>
				</td>
			</table>

			<br />
		</c:if>

		<liferay-ui:tabs
			names="themes,css"
			param="tabs5"
			refresh="<%= false %>"
		>
			<liferay-ui:section>

				<%
				List<Theme> themes = ThemeLocalServiceUtil.getThemes(company.getCompanyId(), liveGroupId, user.getUserId(), false);
				%>

				<%@ include file="/html/portlet/communities/edit_pages_look_and_feel_themes.jspf" %>
			</liferay-ui:section>
			<liferay-ui:section>

				<%
				String selColorSchemeId = StringPool.BLANK;

				if (selTheme.hasColorSchemes()) {
					selColorSchemeId = selColorScheme.getColorSchemeId();
				}

				String cssText = null;

				if ((selLayout != null) && !selLayout.isInheritLookAndFeel()) {
					cssText = selLayout.getCssText();
				}
				else {
					LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);

					cssText = layoutSet.getCss();
				}
				%>

				<liferay-ui:message key="insert-custom-css-that-will-be-loaded-after-the-theme" />

				<br /><br />

				<textarea class="lfr-textarea" name="<portlet:namespace />css"><%= cssText %></textarea>

				<br /><br />

				<input type="button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />updateLookAndFeel('<%= selTheme.getThemeId() %>', '<%= selColorSchemeId %>', '<%= sectionParam %>', '<%= sectionName %>');" />
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:when>
	<c:when test='<%= tabs4.equals("mobile-devices") %>'>

		<%
		Theme selTheme = null;
		ColorScheme selColorScheme = null;

		if (selLayout != null) {
			selTheme = selLayout.getWapTheme();
			selColorScheme = selLayout.getWapColorScheme();
		}
		else {
			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);

			selTheme = layoutSet.getWapTheme();
			selColorScheme = layoutSet.getWapColorScheme();
		}
		%>

		<c:if test="<%= selLayout != null %>">
			<table class="lfr-table">
			<tr>
				<td class="lfr-label">
					<%= LanguageUtil.get(pageContext, "use-the-general-look-and-feel-for-the-" + (privateLayout ? "private" : "public") + "-pages") %>
				</td>
				<td>
					<select name="<portlet:namespace />hidden" onChange="if (this.value == 1) { <portlet:namespace />updateLookAndFeel('', ''); } else { <portlet:namespace />updateLookAndFeel('<%= selTheme.getThemeId() %>', '<%= selColorScheme.getColorSchemeId() %>'); }">
						<option <%= (selLayout.isInheritWapLookAndFeel()) ? "selected" : "" %> value="1"><liferay-ui:message key="yes" /></option>
						<option <%= (!selLayout.isInheritWapLookAndFeel()) ? "selected" : "" %> value="0"><liferay-ui:message key="no" /></option>
					</select>
				</td>
			</table>

			<br />
		</c:if>

		<liferay-ui:tabs names="themes" />

		<%
		List<Theme> themes = ThemeLocalServiceUtil.getThemes(company.getCompanyId(), liveGroupId, user.getUserId(), true);
		%>

		<%@ include file="/html/portlet/communities/edit_pages_look_and_feel_themes.jspf" %>
	</c:when>
</c:choose>