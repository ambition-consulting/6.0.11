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

<%@ include file="/html/portlet/bookmarks/init.jsp" %>

<%
String topLink = ParamUtil.getString(request, "topLink", "bookmarks-home");

long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

boolean viewFolder = GetterUtil.getBoolean((String)request.getAttribute("view.jsp-viewFolder"));

boolean useAssetEntryQuery = GetterUtil.getBoolean((String)request.getAttribute("view.jsp-useAssetEntryQuery"));

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("categoryId", StringPool.BLANK);
portletURL.setParameter("tag", StringPool.BLANK);
%>

<div class="top-links-container">
	<div class="top-links">
		<div class="top-links-navigation">

			<%
			portletURL.setParameter("topLink", "bookmarks-home");
			%>

			<liferay-ui:icon
				cssClass="top-link"
				image="../aui/home"
				label="<%= true %>"
				message="bookmarks-home"
				url='<%= (topLink.equals("bookmarks-home") && folderId == 0 && viewFolder && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
			/>

			<%
			portletURL.setParameter("topLink", "recent-entries");
			%>

			<liferay-ui:icon
				cssClass='<%= "top-link" + (themeDisplay.isSignedIn() ? StringPool.BLANK : " last") %>'
				image="../aui/clock" label="<%= true %>"
				message="recent-entries" url='<%= (topLink.equals("recent-entries") && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
			/>

			<c:if test="<%= themeDisplay.isSignedIn() %>">

				<%
				portletURL.setParameter("topLink", "my-entries");
				%>

				<liferay-ui:icon
					cssClass="top-link last"
					image="../aui/person"
					label="<%= true %>"
					message="my-entries"
					url='<%= (topLink.equals("my-entries") && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
				/>
			</c:if>
		</div>

		<liferay-portlet:renderURL varImpl="searchURL">
			<portlet:param name="struts_action" value="/bookmarks/search" />
		</liferay-portlet:renderURL>

		<c:if test="<%= showFoldersSearch %>">
			<div class="folder-search">
				<aui:form action="<%= searchURL %>" method="get" name="searchFm">
					<liferay-portlet:renderURLParams varImpl="searchURL" />
					<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
					<aui:input name="breadcrumbsFolderId" type="hidden" value="<%= folderId %>" />
					<aui:input name="searchFolderIds" type="hidden" value="<%= folderId %>" />

					<span class="aui-search-bar">
						<aui:input inlineField="<%= true %>" id="keywords1" label="" name="keywords" size="30" title="search-bookmarks" type="text" />

						<aui:button type="submit" value="search" />
					</span>
				</aui:form>
			</div>
		</c:if>
	</div>
</div>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />searchFm.<portlet:namespace />keywords);
	</aui:script>
</c:if>