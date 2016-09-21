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

<%@ include file="/html/portlet/document_library/init.jsp" %>

<c:choose>
	<c:when test="<%= showTabs && portletName.equals(PortletKeys.DOCUMENT_LIBRARY) %>">

		<%
		String topLink = ParamUtil.getString(request, "topLink", "documents-home");

		long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

		long defaultFolderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-defaultFolderId"));

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
					portletURL.setParameter("topLink", "documents-home");
					%>

					<liferay-ui:icon
						cssClass="top-link"
						image="../aui/home"
						label="<%= true %>"
						message="documents-home"
						url='<%= (topLink.equals("documents-home") && (folderId == defaultFolderId) && viewFolder && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
					/>

					<%
					portletURL.setParameter("topLink", "recent-documents");
					%>

					<liferay-ui:icon
						cssClass='<%= "top-link" + (themeDisplay.isSignedIn() ? StringPool.BLANK : " last") %>'
						image="../aui/clock"
						label="<%= true %>"
						message="recent-documents"
						url='<%= (topLink.equals("recent-documents") && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
					/>

					<c:if test="<%= themeDisplay.isSignedIn() %>">

						<%
						portletURL.setParameter("topLink", "my-documents");
						%>

						<liferay-ui:icon
							cssClass="top-link last"
							image="../aui/person"
							label="<%= true %>"
							message="my-documents"
							url='<%= (topLink.equals("my-documents") && !useAssetEntryQuery) ? StringPool.BLANK : portletURL.toString() %>'
						/>
					</c:if>
				</div>

				<liferay-portlet:renderURL varImpl="searchURL">
					<portlet:param name="struts_action" value="/document_library/search" />
				</liferay-portlet:renderURL>

				<c:if test="<%= showFoldersSearch %>">
					<div class="folder-search">
						<aui:form action="<%= searchURL %>" method="get" name="searchFm">
							<liferay-portlet:renderURLParams varImpl="searchURL" />
							<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
							<aui:input name="breadcrumbsFolderId" type="hidden" value="<%= folderId %>" />
							<aui:input name="searchFolderIds" type="hidden" value="<%= folderId %>" />

							<span class="aui-search-bar">
								<aui:input id="keywords1" inlineField="<%= true %>" label="" name="keywords" size="30" title="search-documents" type="text" />

								<aui:button type="submit" value="search" />
							</span>
						</aui:form>
					</div>

					<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
						<aui:script>
							Liferay.Util.focusFormField(document.<portlet:namespace />searchFm.<portlet:namespace />keywords);
						</aui:script>
					</c:if>
				</c:if>
			</div>
		</div>
	</c:when>
	<c:when test="<%= showTabs && portletName.equals(PortletKeys.DOCUMENT_LIBRARY_DISPLAY) %>">

		<%
		long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));
		%>

		<div class="top-links-container">
			<div class="top-links">
				<liferay-portlet:renderURL varImpl="searchURL">
					<portlet:param name="struts_action" value="/document_library/search" />
				</liferay-portlet:renderURL>

				<c:if test="<%= showFoldersSearch %>">
					<div class="folder-search">
						<aui:form action="<%= searchURL %>" method="get" name="searchFm">
							<liferay-portlet:renderURLParams varImpl="searchURL" />
							<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
							<aui:input name="breadcrumbsFolderId" type="hidden" value="<%= folderId %>" />
							<aui:input name="searchFolderIds" type="hidden" value="<%= folderId %>" />

							<span class="aui-search-bar">
								<aui:input id="keywords1" inlineField="<%= true %>" label="" name="keywords" size="30" title="search-documents" type="text" />

								<aui:button type="submit" value="search" />
							</span>
						</aui:form>
					</div>

					<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
						<aui:script>
							Liferay.Util.focusFormField(document.<portlet:namespace />searchFm.<portlet:namespace />keywords);
						</aui:script>
					</c:if>
				</c:if>
			</div>
		</div>
	</c:when>
	<c:when test="<%= showTabs && showSubfolders %>">
		<liferay-ui:header
			title="documents-home"
		/>
	</c:when>
</c:choose>