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

<%@ include file="/html/portlet/directory/init.jsp" %>

<%
String strutsAction = ParamUtil.getString(request, "struts_action");

UserSearch searchContainer = (UserSearch)request.getAttribute("liferay-ui:search:searchContainer");

UserDisplayTerms displayTerms = (UserDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	id="toggle_id_directory_user_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input name="<%= displayTerms.FIRST_NAME %>" size="20" type="text" value="<%= displayTerms.getFirstName() %>" />

			<aui:input name="<%= displayTerms.SCREEN_NAME %>" size="20" type="text" value="<%= displayTerms.getScreenName() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.MIDDLE_NAME %>" size="20" type="text" value="<%= displayTerms.getMiddleName() %>" />

			<aui:input name="<%= displayTerms.EMAIL_ADDRESS %>" size="20" type="text" value="<%= displayTerms.getEmailAddress() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.LAST_NAME %>" size="20" type="text" value="<%= displayTerms.getLastName() %>" />
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.FIRST_NAME %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</aui:script>
</c:if>