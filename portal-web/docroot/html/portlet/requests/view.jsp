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

<%@ include file="/html/portlet/requests/init.jsp" %>

<%
List<SocialRequest> requests = (List<SocialRequest>)request.getAttribute(WebKeys.SOCIAL_REQUESTS);
%>

<c:if test="<%= requests != null %>">

	<%
	PortletURL portletURL = renderResponse.createActionURL();

	portletURL.setParameter("struts_action", "/requests/update_request");
	portletURL.setParameter("redirect", currentURL);
	%>

	<table class="lfr-table" width="100%">

	<%
	for (int i = 0; i < requests.size(); i++) {
		SocialRequest socialRequest = requests.get(i);

		SocialRequestFeedEntry requestFeedEntry = SocialRequestInterpreterLocalServiceUtil.interpret(socialRequest, themeDisplay);
	%>

		<tr>
			<td align="center" class="lfr-top">
				<liferay-ui:user-display
					userId="<%= socialRequest.getUserId() %>"
					displayStyle="<%= 2 %>"
				/>
			</td>
			<td class="lfr-top" width="99%">
				<c:choose>
					<c:when test="<%= requestFeedEntry == null %>">
						<div class="portlet-msg-error">
							<liferay-ui:message key="request-cannot-be-interpreted-because-it-does-not-have-an-associated-interpreter" />
						</div>
					</c:when>
					<c:otherwise>

						<%
						portletURL.setParameter("requestId", String.valueOf(socialRequest.getRequestId()));
						%>

						<div>
							<%= requestFeedEntry.getTitle() %>
						</div>

						<br />

						<c:if test="<%= Validator.isNotNull(requestFeedEntry.getBody()) %>">
							<div>
								<%= requestFeedEntry.getBody() %>
							</div>

							<br />
						</c:if>

						<liferay-ui:icon-list>

							<%
							portletURL.setParameter("status", String.valueOf(SocialRequestConstants.STATUS_CONFIRM));
							%>

							<liferay-ui:icon
								image="activate"
								message="confirm"
								url="<%= portletURL.toString() %>"
							/>

							<%
							portletURL.setParameter("status", String.valueOf(SocialRequestConstants.STATUS_IGNORE));
							%>

							<liferay-ui:icon
								image="deactivate"
								message="ignore"
								url="<%= portletURL.toString() %>"
							/>
						</liferay-ui:icon-list>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>

		<c:if test="<%= (i + 1) < requests.size() %>">
			<tr>
				<td colspan="2">
					<div class="separator"><!-- --></div>
				</td>
			</tr>
		</c:if>

	<%
	}
	%>

	</table>
</c:if>