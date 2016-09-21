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

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
AssetSearch searchContainer = (AssetSearch)request.getAttribute("liferay-ui:search:searchContainer");

AssetDisplayTerms displayTerms = (AssetDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	id="toggle_id_asset_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input name="<%= displayTerms.TITLE %>" size="20" type="text" value="<%= displayTerms.getTitle() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.DESCRIPTION %>" size="20" type="text" value="<%= displayTerms.getDescription() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.USER_NAME %>" size="20" type="text" value="<%= displayTerms.getUserName() %>" />
		</aui:column>

		<aui:column>
			<aui:select label="my-places" name="<%= displayTerms.GROUP_ID %>" showEmptyOption="<%= true %>">
				<c:if test="<%= themeDisplay.getCompanyGroupId() != scopeGroupId %>">
					<aui:option label="global" selected="<%= displayTerms.getGroupId() == themeDisplay.getCompanyGroupId() %>" value="<%= themeDisplay.getCompanyGroupId() %>" />
				</c:if>

				<aui:option label="<%= themeDisplay.getScopeGroupName() %>" selected="<%= displayTerms.getGroupId() == scopeGroupId %>" value="<%= scopeGroupId %>" />
			</aui:select>
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>