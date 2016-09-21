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

<%@ include file="/html/portlet/social_equity_admin/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "settings");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/social_equity_admin/view");
portletURL.setParameter("tabs1", tabs1);
%>

<liferay-ui:tabs
	names="settings,rankings"
	url="<%= portletURL.toString() %>"
/>

<portlet:actionURL var="saveEquitySettingsURL">
	<portlet:param name="struts_action" value="/social_equity_admin/view" />
</portlet:actionURL>

<aui:form action="<%= saveEquitySettingsURL.toString() %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="updateSettings" />
	<aui:input name="tabs1" value="<%= tabs1 %>" type="hidden" />
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden" />

	<c:choose>
		<c:when test='<%= tabs1.equals("settings") %>'>
			<%@ include file="/html/portlet/social_equity_admin/settings.jspf" %>
		</c:when>
		<c:when test='<%= tabs1.equals("rankings") %>'>
			<%@ include file="/html/portlet/social_equity_admin/rankings.jspf" %>
		</c:when>
	</c:choose>
</aui:form>

<aui:script>
	function <portlet:namespace />saveEquitySettings(cmd) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;

		submitForm(document.<portlet:namespace />fm);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />toggleEquitySection',
		function(selector) {
			var section = AUI().one(selector);

			if (section) {
				section.toggle();
			}
		},
		['aui-base']
	);
</aui:script>