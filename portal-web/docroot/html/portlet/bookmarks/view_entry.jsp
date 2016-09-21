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
BookmarksEntry entry = (BookmarksEntry)request.getAttribute(WebKeys.BOOKMARKS_ENTRY);

entry = entry.toEscapedModel();

long entryId = entry.getEntryId();

BookmarksFolder folder = entry.getFolder();

request.setAttribute("view_entry.jsp-entry", entry);
%>

<liferay-util:include page="/html/portlet/bookmarks/top_links.jsp" />

<c:if test="<%= folder != null %>">
	<portlet:renderURL var="backURL">
		<portlet:param name="struts_action" value="/bookmarks/view" />
		<portlet:param name="folderId" value="<%= String.valueOf(folder.getFolderId()) %>" />
	</portlet:renderURL>

	<%
	String folderName = LanguageUtil.get(pageContext, "bookmarks-home");

	if (Validator.isNotNull(folder.getName())) {
		folderName = folder.getName();
	}
	%>

	<liferay-ui:header
		backLabel='<%= "&laquo; " + LanguageUtil.format(pageContext, "back-to-x", HtmlUtil.escape(folderName)) %>'
		backURL="<%= backURL.toString() %>"
		title="<%= entry.getName() %>"
	/>
</c:if>

<aui:layout>
	<aui:column columnWidth="<%= 75 %>" cssClass="lfr-asset-column lfr-asset-column-details" first="<%= true %>">
		<div class="lfr-asset-categories">
			<liferay-ui:asset-categories-summary
				className="<%= BookmarksEntry.class.getName() %>"
				classPK="<%= entryId %>"
			/>
		</div>

		<div class="lfr-asset-tags">
			<liferay-ui:asset-tags-summary
				className="<%= BookmarksEntry.class.getName() %>"
				classPK="<%= entryId %>"
				message="tags"
			/>
		</div>

		<div class="lfr-asset-url">
			<a href="<%= themeDisplay.getPathMain() %>/bookmarks/open_entry?entryId=<%= entry.getEntryId() %>"><%= entry.getUrl() %></a>
		</div>

		<div class="lfr-asset-description">
			<%= entry.getComments() %>
		</div>

		<liferay-ui:custom-attributes-available className="<%= BookmarksEntry.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= BookmarksEntry.class.getName() %>"
				classPK="<%= (entry != null) ? entry.getEntryId() : 0 %>"
				editable="<%= false %>"
				label="<%= true %>"
			/>
		</liferay-ui:custom-attributes-available>

		<div class="lfr-asset-metadata">
			<div class="lfr-asset-icon lfr-asset-author">
				<%= LanguageUtil.format(pageContext, "created-by-x", HtmlUtil.escape(PortalUtil.getUserName(entry.getUserId(), themeDisplay.getScopeGroupName()))) %>
			</div>

			<div class="lfr-asset-icon lfr-asset-date">
				<%= dateFormatDate.format(entry.getCreateDate()) %>
			</div>

			<div class="lfr-asset-icon lfr-asset-downloads last">
				<%= entry.getVisits() %> <liferay-ui:message key="visits" />
			</div>
		</div>

		<div class="lfr-asset-ratings">
			<liferay-ui:ratings
				className="<%= BookmarksEntry.class.getName() %>"
				classPK="<%= entryId %>"
			/>
		</div>
	</aui:column>

	<aui:column columnWidth="<%= 25 %>" cssClass="lfr-asset-column lfr-asset-column-actions" last="<%= true %>">
		<div class="lfr-asset-summary">
			<liferay-ui:icon
				cssClass="lfr-asset-avatar"
				image="../file_system/large/bookmark"
				message="download"
				url="<%= entry.getUrl() %>"
			/>

			<div class="lfr-asset-name">
				<a href="<%= entry.getUrl() %>">
					<%= entry.getName() %>
				</a>
			</div>
		</div>

		<%
		request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		%>

		<liferay-util:include page="/html/portlet/bookmarks/entry_action.jsp" />
	</aui:column>
</aui:layout>

<%
BookmarksUtil.addPortletBreadcrumbEntries(entry, request, renderResponse);
%>