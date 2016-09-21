<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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

	<%
	String[] validUrlPrefixesArray = PropsUtil.getArray("xsl.content.valid.url.prefixes");

	if (Validator.isNotNull(validUrlPrefixesArray)) {
		for (int i = 0; i < validUrlPrefixesArray.length; i++) {
			validUrlPrefixesArray[i] = XSLContentUtil.replaceUrlTokens(themeDisplay, validUrlPrefixesArray[i]);
		}
	}

	String validUrlPrefixes = StringUtil.merge(validUrlPrefixesArray, StringPool.COMMA_AND_SPACE);
	%>

	<c:if test="<%= Validator.isNotNull(validUrlPrefixes) %>">
		<div class="portlet-msg-info">
			<liferay-ui:message arguments="<%= validUrlPrefixes %>" key="urls-must-begin-with-one-of-the-following" />
		</div>
	</c:if>

	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" label="xml-url" name="xmlURL" type="text" value="<%= xmlURL %>" />

		<aui:input cssClass="lfr-input-text-container" label="xsl-url" name="xslURL" type="text" value="<%= xslURL %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>