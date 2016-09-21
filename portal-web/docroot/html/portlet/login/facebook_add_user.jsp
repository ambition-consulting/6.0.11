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

<%@ include file="/html/portlet/login/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<div>
	<liferay-ui:message key="no-user-was-found-with-your-facebook-credentials.-would-you-like-to-import-this-user" />
</div>

<portlet:actionURL var="addUserURL">
	<portlet:param name="saveLastPath" value="0" />
	<portlet:param name="struts_action" value="/login/facebook_connect" />
</portlet:actionURL>

<aui:form action="<%= addUserURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:layout>
		<aui:column columnWidth="10" first="true">
			<img alt="facebook user image" src="<%= FacebookConnectUtil.getProfileImageURL(renderRequest) %>" />
		</aui:column>
		<aui:column columnWidth="90" last="true">
			<aui:button-row>
				<aui:button type="submit" value="add-account" />
			</aui:button-row>
		</aui:column>
	</aui:layout>
</aui:form>

<liferay-util:include page="/html/portlet/login/navigation.jsp" />