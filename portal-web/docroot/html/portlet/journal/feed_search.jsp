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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
FeedSearch searchContainer = (FeedSearch)request.getAttribute("liferay-ui:search:searchContainer");

FeedDisplayTerms displayTerms = (FeedDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	id="toggle_id_journal_feed_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input label="id" name="<%= displayTerms.FEED_ID %>" size="20" type="text" value="<%= displayTerms.getFeedId() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.NAME %>" size="20" type="text" value="<%= displayTerms.getName() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.DESCRIPTION %>" size="20" type="text" value="<%= displayTerms.getDescription() %>" />
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>

<%
boolean showAddFeedButtonButton = JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_FEED);
boolean showPermissionsButton = GroupPermissionUtil.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
%>

<c:if test="<%= showAddFeedButtonButton || showPermissionsButton %>">
	<aui:button-row>
		<c:if test="<%= showAddFeedButtonButton %>">
			<aui:button onClick='<%= renderResponse.getNamespace() + "addFeed();" %>' value="add-feed" />
		</c:if>

		<c:if test="<%= showPermissionsButton %>">
			<liferay-security:permissionsURL
				modelResource="com.liferay.portlet.journal"
				modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
				resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
				var="permissionsURL"
			/>

			<aui:button onClick="<%= permissionsURL %>" value="permissions" />
		</c:if>
	</aui:button-row>
</c:if>

<aui:script>
	function <portlet:namespace />addFeed() {
		var url = '<portlet:renderURL><portlet:param name="struts_action" value="/journal/edit_feed" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';

		if (toggle_id_journal_feed_searchcurClickValue == 'basic') {
			url += '&<portlet:namespace /><%= displayTerms.NAME %>=' + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>.value;

			submitForm(document.hrefFm, url);
		}
		else {
			document.<portlet:namespace />fm.method = 'post';
			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.FEED_ID %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</c:if>
</aui:script>