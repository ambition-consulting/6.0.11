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

<%@ include file="/html/portlet/xsl_content/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<liferay-ui:error key="xmlURL" message="please-enter-a-valid-xml-url" />
	<liferay-ui:error key="xslURL" message="please-enter-a-valid-xsl-url" />
	<liferay-ui:error key="transformation" message="an-error-occurred-while-processing-your-xml-and-xsl" />

	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" label="xml-url" name="xmlURL" type="text" value="<%= xmlURL %>" />

		<aui:input cssClass="lfr-input-text-container" label="xsl-url" name="xslURL" type="text" value="<%= xslURL %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>