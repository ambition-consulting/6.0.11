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

<%@ include file="/html/portal/init.jsp" %>

<%
String emailAddress1 = ParamUtil.getString(request, "emailAddress1");
String emailAddress2 = ParamUtil.getString(request, "emailAddress2");
%>

<aui:form action='<%= themeDisplay.getPathMain() + "/portal/update_email_address" %>' method="post" name="fm">
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value='<%= themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId() %>' />

	<c:choose>
		<c:when test="<%= SessionErrors.contains(request, DuplicateUserEmailAddressException.class.getName()) %>">
			<div class="portlet-msg-error">
				<liferay-ui:message key="the-email-address-you-requested-is-already-taken" />
			</div>
		</c:when>
		<c:when test="<%= SessionErrors.contains(request, ReservedUserEmailAddressException.class.getName()) %>">
			<div class="portlet-msg-error">
				<liferay-ui:message key="the-email-address-you-requested-is-reserved" />
			</div>
		</c:when>
		<c:when test="<%= SessionErrors.contains(request, UserEmailAddressException.class.getName()) %>">
			<div class="portlet-msg-error">
				<liferay-ui:message key="please-enter-a-valid-email-address" />
			</div>
		</c:when>
		<c:otherwise>
			<div class="portlet-msg-info">
				<liferay-ui:message key="please-enter-a-valid-email-address" />
			</div>
		</c:otherwise>
	</c:choose>

	<aui:fieldset label="email-address">
		<aui:input class="lfr-input-text-container" label="email-address" name="emailAddress1" type="text" value="<%= emailAddress1 %>" />

		<aui:input class="lfr-input-text-container" label="enter-again" name="emailAddress2" type="text" value="<%= emailAddress2 %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	Liferay.Util.focusFormField(document.fm.emailAddress1);
</aui:script>