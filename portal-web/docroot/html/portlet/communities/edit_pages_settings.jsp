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
String tabs1 = ParamUtil.getString(request, "tabs1", "settings");
String tabs2 = ParamUtil.getString(request, "tabs2");
String tabs3 = ParamUtil.getString(request, "tabs3");

Group liveGroup = (Group)request.getAttribute("edit_pages.jsp-liveGroup");
Group stagingGroup = (Group)request.getAttribute("edit_pages.jsp-stagingGroup");
Group group = (Group)request.getAttribute("edit_pages.jsp-group");
long groupId = ((Long)request.getAttribute("edit_pages.jsp-groupId")).longValue();
long liveGroupId = ((Long)request.getAttribute("edit_pages.jsp-liveGroupId")).longValue();
long selPlid = ((Long)request.getAttribute("edit_pages.jsp-selPlid")).longValue();
boolean privateLayout = ((Boolean)request.getAttribute("edit_pages.jsp-privateLayout")).booleanValue();
UnicodeProperties groupTypeSettings = (UnicodeProperties)request.getAttribute("edit_pages.jsp-groupTypeSettings");
Layout selLayout = (Layout)request.getAttribute("edit_pages.jsp-selLayout");

boolean workflowEnabled = ((Boolean)request.getAttribute("edit_pages.jsp-workflowEnabled")).booleanValue();

PortletURL portletURL = (PortletURL)request.getAttribute("edit_pages.jsp-portletURL");

List<String> tabs2NamesList = new ArrayList<String>();

if (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.UPDATE)) {
	tabs2NamesList.add("virtual-host");

	if (company.isCommunityLogo()) {
		tabs2NamesList.add("logo");
	}

	tabs2NamesList.add("sitemap");
	tabs2NamesList.add("robots");
	tabs2NamesList.add("monitoring");

	Group guestGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), GroupConstants.GUEST);

	if (liveGroup.getGroupId() != guestGroup.getGroupId()) {
		tabs2NamesList.add("merge-pages");
	}
}

if (GroupPermissionUtil.contains(permissionChecker, liveGroupId, ActionKeys.MANAGE_STAGING)) {
	tabs2NamesList.add("staging");
}

String tabs2Names = StringUtil.merge(tabs2NamesList);

if (!StringUtil.contains(tabs2Names, tabs2)) {
	int pos = tabs2Names.indexOf(StringPool.COMMA);

	if (pos != -1) {
		tabs2 = tabs2Names.substring(0, pos);
	}
}

if (!tabs2.equals("pages")) {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, TextFormatter.format(tabs2, TextFormatter.O)), currentURL);
}
%>

<liferay-ui:tabs
	names="<%= tabs2Names %>"
	param="tabs2"
	url='<%= portletURL.toString() + "&" + renderResponse.getNamespace() + "selPlid=" + selPlid %>'
/>

<liferay-ui:error exception="<%= ImageTypeException.class %>" message="please-enter-a-file-with-a-valid-file-type" />

<liferay-ui:error exception="<%= LayoutFriendlyURLException.class %>">

	<%
	LayoutFriendlyURLException lfurle = (LayoutFriendlyURLException)errorException;
	%>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.ADJACENT_SLASHES %>">
		<liferay-ui:message key="please-enter-a-friendly-url-that-does-not-have-adjacent-slashes" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.DOES_NOT_START_WITH_SLASH %>">
		<liferay-ui:message key="please-enter-a-friendly-url-that-begins-with-a-slash" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.DUPLICATE %>">
		<liferay-ui:message key="please-enter-a-unique-friendly-url" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.ENDS_WITH_SLASH %>">
		<liferay-ui:message key="please-enter-a-friendly-url-that-does-not-end-with-a-slash" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.INVALID_CHARACTERS %>">
		<liferay-ui:message key="please-enter-a-friendly-url-with-valid-characters" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.KEYWORD_CONFLICT %>">
		<liferay-ui:message arguments="<%= lfurle.getKeywordConflict() %>" key="please-enter-a-friendly-url-that-does-not-conflict-with-the-keyword-x" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.POSSIBLE_DUPLICATE %>">
		<liferay-ui:message key="the-friendly-url-may-conflict-with-another-page" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.TOO_DEEP %>">
		<liferay-ui:message key="the-friendly-url-has-too-many-slashes" />
	</c:if>

	<c:if test="<%= lfurle.getType() == LayoutFriendlyURLException.TOO_SHORT %>">
		<liferay-ui:message key="please-enter-a-friendly-url-that-is-at-least-two-characters-long" />
	</c:if>
</liferay-ui:error>

<liferay-ui:error exception="<%= LayoutSetVirtualHostException.class %>">
	<liferay-ui:message key="please-enter-a-unique-virtual-host" />

	<liferay-ui:message key="virtual-hosts-must-be-valid-domain-names" />
</liferay-ui:error>

<c:choose>
	<c:when test='<%= tabs2.equals("staging") %>'>
		<liferay-util:include page="/html/portlet/communities/edit_pages_staging.jsp" />
	</c:when>
	<c:when test='<%= tabs2.equals("virtual-host") %>'>
		<liferay-ui:message key="enter-the-public-and-private-virtual-host-that-will-map-to-the-public-and-private-friendly-url" />

		<liferay-ui:message arguments="<%= new Object[] {HttpUtil.getProtocol(request), themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic()} %>" key="for-example,-if-the-public-virtual-host-is-www.helloworld.com-and-the-friendly-url-is-/helloworld" />

		<br /><br />

		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message key="public-virtual-host" />
			</td>
			<td>

				<%
				LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, false);

				String publicVirtualHost = ParamUtil.getString(request, "publicVirtualHost", BeanParamUtil.getString(publicLayoutSet, request, "virtualHost"));
				%>

				<input name="<portlet:namespace />publicVirtualHost" size="50" type="text" value="<%= HtmlUtil.escape(publicVirtualHost) %>" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="private-virtual-host" />
			</td>
			<td>

				<%
				LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, true);

				String privateVirtualHost = ParamUtil.getString(request, "privateVirtualHost", BeanParamUtil.getString(privateLayoutSet, request, "virtualHost"));
				%>

				<input name="<portlet:namespace />privateVirtualHost" size="50" type="text" value="<%= HtmlUtil.escape(privateVirtualHost) %>" />
			</td>
		</tr>
		</table>

		<c:if test="<%= liveGroup.isCommunity() || liveGroup.isOrganization() %>">
			<br />

			<liferay-ui:message key="enter-the-friendly-url-that-will-be-used-by-both-public-and-private-pages" />

			<liferay-ui:message arguments="<%= new Object[] {publicVirtualHost + themeDisplay.getPathFriendlyURLPublic(), themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPrivateGroup()} %>" key="the-friendly-url-is-appended-to-x-for-public-pages-and-x-for-private-pages" />

			<br /><br />

			<table class="lfr-table">
			<tr>
				<td>
					<liferay-ui:message key="friendly-url" />
				</td>
				<td>

					<%
					String friendlyURL = BeanParamUtil.getString(liveGroup, request, "friendlyURL");
					%>

					<input name="<portlet:namespace />friendlyURL" size="30" type="text" value="<%= HtmlUtil.escape(friendlyURL) %>" />
				</td>
			</tr>
			</table>
		</c:if>

		<c:if test="<%= liveGroup.hasStagingGroup() %>">
			<br />

			<strong><liferay-ui:message key="staging" /></strong>

			<table class="lfr-table">
			<tr>
				<td>
					<liferay-ui:message key="public-virtual-host" />
				</td>
				<td>

					<%
					long stagingGroupId = stagingGroup.getGroupId();

					LayoutSet stagingPublicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(stagingGroupId, false);

					String stagingPublicVirtualHost = ParamUtil.getString(request, "stagingPublicVirtualHost", stagingPublicLayoutSet.getVirtualHost());
					%>

					<input name="<portlet:namespace />stagingPublicVirtualHost" size="50" type="text" value="<%= HtmlUtil.escape(stagingPublicVirtualHost) %>" />
				</td>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="private-virtual-host" />
				</td>
				<td>

					<%
					LayoutSet stagingPrivateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(stagingGroupId, true);

					String stagingPrivateVirtualHost = ParamUtil.getString(request, "stagingPrivateVirtualHost", stagingPrivateLayoutSet.getVirtualHost());
					%>

					<input name="<portlet:namespace />stagingPrivateVirtualHost" size="50" type="text" value="<%= HtmlUtil.escape(stagingPrivateVirtualHost) %>" />
				</td>
			</tr>
			</table>

			<c:if test="<%= liveGroup.isCommunity() || liveGroup.isOrganization() %>">
				<br />

				<table class="lfr-table">
				<tr>
					<td>
						<liferay-ui:message key="friendly-url" />
					</td>
					<td>

						<%
						String friendlyURL = ParamUtil.getString(request, "stagingFriendlyURL", stagingGroup.getFriendlyURL());
						%>

						<input name="<portlet:namespace />stagingFriendlyURL" size="30" type="text" value="<%= HtmlUtil.escape(friendlyURL) %>" />
					</td>
				</tr>
				</table>
			</c:if>
		</c:if>

		<br />

		<input type="submit" value="<liferay-ui:message key="save" />" />
	</c:when>
	<c:when test='<%= tabs2.equals("sitemap") %>'>

		<%
		String host = PortalUtil.getHost(request);

		String sitemapUrl = PortalUtil.getPortalURL(host, request.getServerPort(), request.isSecure()) + themeDisplay.getPathContext() + "/sitemap.xml";

		LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);

		String virtualHost = layoutSet.getVirtualHost();

		if (!host.equals(virtualHost)) {
			sitemapUrl += "?groupId=" + groupId + "&privateLayout=" + privateLayout;
		}
		%>

		<liferay-util:buffer var="linkContent">
			<aui:a href="http://www.sitemaps.org" target="_blank">http://www.sitemaps.org</aui:a>
		</liferay-util:buffer>

		<liferay-ui:message key="the-sitemap-protocol-notifies-search-engines-of-the-structure-of-the-website" /> <liferay-ui:message arguments="<%= linkContent %>" key="see-x-for-more-information" />

		<br /><br />

		<%= LanguageUtil.format(pageContext, "send-sitemap-information-to-preview", new Object[] {"<a target=\"_blank\" href=\"" + sitemapUrl + "\">", "</a>"}) %>

		<ul>
			<li>
				<aui:a href='<%= "http://www.google.com/webmasters/sitemaps/ping?sitemap=" + HtmlUtil.escapeURL(sitemapUrl) %>' target="_blank">Google</aui:a>
			</li>
			<li>
				<aui:a href='<%= "https://siteexplorer.search.yahoo.com/submit/ping?sitemap=" + HtmlUtil.escapeURL(sitemapUrl) %>' target="_blank">Yahoo!</aui:a> (<liferay-ui:message key="requires-login" />)
			</li>
		</ul>
	</c:when>
	<c:when test='<%= tabs2.equals("robots") %>'>

		<%
		LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, false);

		String defaultPublicRobots = RobotsUtil.getRobots(publicLayoutSet);

		String publicRobots = ParamUtil.getString(request, "robots", defaultPublicRobots);

		LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, true);

		String defaultPrivateRobots = RobotsUtil.getRobots(privateLayoutSet);

		String privateRobots = ParamUtil.getString(request, "robots", defaultPrivateRobots);
		%>

		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message key="set-the-robots-txt-for-public-pages" />
			</td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="<%= Validator.isNotNull(publicLayoutSet.getVirtualHost()) %>">
						<textarea cols="60" name="<portlet:namespace />publicRobots" rows="15"><%= HtmlUtil.escape(publicRobots) %></textarea>
					</c:when>
					<c:otherwise>
						<div class="portlet-msg-info">
							<liferay-ui:message key="please-set-the-virtual-host-before-you-set-the-robots-txt" />
						</div>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<br />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="set-the-robots-txt-for-private-pages" />
			</td>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="<%= Validator.isNotNull(privateLayoutSet.getVirtualHost()) %>">
						<textarea cols="60" name="<portlet:namespace />privateRobots" rows="15"><%= HtmlUtil.escape(privateRobots) %></textarea>
					</c:when>
					<c:otherwise>
						<div class="portlet-msg-info">
							<liferay-ui:message key="please-set-the-virtual-host-before-you-set-the-robots-txt" />
						</div>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<br />
			</td>
		</tr>
		</table>

		<input type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />updateRobots();" />
	</c:when>
	<c:when test='<%= tabs2.equals("monitoring") %>'>
		<liferay-ui:message key="set-the-google-analytics-id-that-will-be-used-for-this-set-of-pages" />

		<br /><br />

		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message key="google-analytics-id" />
			</td>
			<td>

				<%
				String googleAnalyticsId = PropertiesParamUtil.getString(groupTypeSettings, request, "googleAnalyticsId");
				%>

				<input name="<portlet:namespace />googleAnalyticsId" size="30" type="text" value="<%= HtmlUtil.escape(googleAnalyticsId) %>" />
			</td>
		</tr>
		</table>

		<br />

		<input type="submit" value="<liferay-ui:message key="save" />" />
	</c:when>
	<c:when test='<%= tabs2.equals("logo") %>'>
		<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />

		<%
		LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, privateLayout);
		%>

		<%= LanguageUtil.get(pageContext, "upload-a-logo-for-the-" + (privateLayout ? "private" : "public") + "-pages-that-will-be-used-instead-of-the-default-enterprise-logo") %>

		<br /><br />

		<c:if test="<%= layoutSet.isLogo() %>">
			<span class="lfr-change-logo">
				<img alt="<liferay-ui:message key="logo" />" src="<%= themeDisplay.getPathImage() %>/layout_set_logo?img_id=<%= layoutSet.getLogoId() %>&t=<%= ImageServletTokenUtil.getToken(layoutSet.getLogoId()) %>" />
			</span>
		</c:if>

		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message key="logo" />
			</td>
			<td>
				<input name="<portlet:namespace />logoFileName" size="30" type="file" onChange="document.<portlet:namespace />fm.<portlet:namespace />logo.value = true; document.<portlet:namespace />fm.<portlet:namespace />logoCheckbox.checked = true;" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="use-logo" />
			</td>
			<td>
				<liferay-ui:input-checkbox param="logo" defaultValue="<%= layoutSet.isLogo() %>" />
			</td>
		</tr>
		</table>

		<br />

		<input type="button" value="<liferay-ui:message key="save" />" onClick="<portlet:namespace />updateLogo();" />
	</c:when>
	<c:when test='<%= tabs2.equals("merge-pages") %>'>

		<%
		boolean mergeGuestPublicPages = PropertiesParamUtil.getBoolean(groupTypeSettings, request, "mergeGuestPublicPages");
		%>

		<div class="portlet-msg-info">
			<liferay-ui:message arguments="<%= company.getGroup().getDescriptiveName() %>" key="you-can-configure-the-top-level-pages-of-this-public-website-to-merge-with-the-top-level-pages-of-the-public-x-community" />
		</div>

		<table class="lfr-table">
		<tr>
			<td>
				<liferay-ui:message arguments="<%= company.getGroup().getDescriptiveName() %>" key="merge-x-public-pages" />
			</td>
			<td>
				<liferay-ui:input-checkbox param="mergeGuestPublicPages" defaultValue="<%= mergeGuestPublicPages %>" />
			</td>
		</tr>
		</table>

		<br />

		<input type="submit" value="<liferay-ui:message key="save" />" />
	</c:when>
</c:choose>