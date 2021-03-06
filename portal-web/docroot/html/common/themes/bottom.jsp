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

<%@ include file="/html/common/init.jsp" %>

<%@ page import="com.liferay.taglib.aui.ScriptTag" %>

<%-- Portal JavaScript --%>

<%-- Portlet CSS References --%>

<%
List<Portlet> portlets = (List<Portlet>)request.getAttribute(WebKeys.LAYOUT_PORTLETS);
%>

<c:if test="<%= portlets != null %>">

	<%
	Set<String> footerPortalCssSet = new LinkedHashSet<String>();

	for (Portlet portlet : portlets) {
		for (String footerPortalCss : portlet.getFooterPortalCss()) {
			if (!HttpUtil.hasProtocol(footerPortalCss)) {
				footerPortalCss = PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext() + footerPortalCss, portlet.getTimestamp());
			}

			if (!footerPortalCssSet.contains(footerPortalCss)) {
				footerPortalCssSet.add(footerPortalCss);
	%>

				<link href="<%= HtmlUtil.escape(footerPortalCss) %>" rel="stylesheet" type="text/css" />

	<%
			}
		}
	}

	Set<String> footerPortletCssSet = new LinkedHashSet<String>();

	for (Portlet portlet : portlets) {
		for (String footerPortletCss : portlet.getFooterPortletCss()) {
			if (!HttpUtil.hasProtocol(footerPortletCss)) {
				footerPortletCss = PortalUtil.getStaticResourceURL(request, portlet.getStaticResourcePath() + footerPortletCss, portlet.getTimestamp());
			}

			if (!footerPortletCssSet.contains(footerPortletCss)) {
				footerPortletCssSet.add(footerPortletCss);
	%>

				<link href="<%= HtmlUtil.escape(footerPortletCss) %>" rel="stylesheet" type="text/css" />

	<%
			}
		}
	}
	%>

</c:if>

<%-- Portlet JavaScript References --%>

<c:if test="<%= portlets != null %>">

	<%
	Set<String> footerPortalJavaScriptSet = new LinkedHashSet<String>();

	for (Portlet portlet : portlets) {
		for (String footerPortalJavaScript : portlet.getFooterPortalJavaScript()) {
			if (!HttpUtil.hasProtocol(footerPortalJavaScript)) {
				footerPortalJavaScript = PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext() + footerPortalJavaScript, portlet.getTimestamp());
			}

			if (!footerPortalJavaScriptSet.contains(footerPortalJavaScript) && !themeDisplay.isIncludedJs(footerPortalJavaScript)) {
				footerPortalJavaScriptSet.add(footerPortalJavaScript);
	%>

				<script src="<%= HtmlUtil.escape(footerPortalJavaScript) %>" type="text/javascript"></script>

	<%
			}
		}
	}

	Set<String> footerPortletJavaScriptSet = new LinkedHashSet<String>();

	for (Portlet portlet : portlets) {
		for (String footerPortletJavaScript : portlet.getFooterPortletJavaScript()) {
			if (!HttpUtil.hasProtocol(footerPortletJavaScript)) {
				footerPortletJavaScript = PortalUtil.getStaticResourceURL(request, portlet.getStaticResourcePath() + footerPortletJavaScript, portlet.getTimestamp());
			}

			if (!footerPortletJavaScriptSet.contains(footerPortletJavaScript)) {
				footerPortletJavaScriptSet.add(footerPortletJavaScript);
	%>

				<script src="<%= HtmlUtil.escape(footerPortletJavaScript) %>" type="text/javascript"></script>

	<%
			}
		}
	}
	%>

</c:if>

<%@ include file="/html/common/themes/bottom_js.jspf" %>

<%@ include file="/html/common/themes/session_timeout.jspf" %>

<%
ScriptTag.flushScriptData(pageContext);
%>

<%-- Raw Text --%>

<%
StringBundler pageBottomSB = (StringBundler)request.getAttribute(WebKeys.PAGE_BOTTOM);
%>

<c:if test="<%= pageBottomSB != null %>">

	<%
	pageBottomSB.writeTo(out);
	%>

</c:if>

<%-- Theme JavaScript --%>

<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getPathThemeJavaScript() + "/main.js")) %>" type="text/javascript"></script>

<c:if test="<%= layout != null %>">

	<%-- User Inputted Layout JavaScript --%>

	<%
	UnicodeProperties typeSettings = layout.getTypeSettingsProperties();
	%>

	<script type="text/javascript">
		// <![CDATA[
			<%= GetterUtil.getString(typeSettings.getProperty("javascript-1")) %>
			<%= GetterUtil.getString(typeSettings.getProperty("javascript-2")) %>
			<%= GetterUtil.getString(typeSettings.getProperty("javascript-3")) %>
		// ]]>
	</script>

	<%-- Google Analytics --%>

	<%
	UnicodeProperties groupTypeSettings = layout.getGroup().getTypeSettingsProperties();

	String googleAnalyticsId = groupTypeSettings.getProperty("googleAnalyticsId");

	if (Validator.isNotNull(googleAnalyticsId)) {
	%>

		<script type="text/javascript">
			var _gaq = _gaq || [];

			_gaq.push(['_setAccount', '<%= googleAnalyticsId %>']);
			_gaq.push(['_trackPageview']);

			(function() {
				var ga = document.createElement('script');

				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				ga.setAttribute('async', 'true');

				document.documentElement.firstChild.appendChild(ga);
			})();
		</script>

	<%
	}
	%>

</c:if>

<c:if test="<%= PropsValues.MONITORING_PORTAL_REQUEST %>">
	<%@ include file="/html/common/themes/bottom_monitoring.jspf" %>
</c:if>

<liferay-util:include page="/html/common/themes/bottom-ext.jsp" />