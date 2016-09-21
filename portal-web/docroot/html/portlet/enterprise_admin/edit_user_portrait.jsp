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

<%@ include file="/html/portlet/enterprise_admin/init.jsp" %>

<%
User selUser = PortalUtil.getSelectedUser(request);
%>

<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "request_processed") %>'>
		<aui:script>
			window.close();
			opener.<portlet:namespace />changePortrait('<%= selUser.getPortraitURL(themeDisplay) %>');
		</aui:script>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="editUserPortraitURL">
			<portlet:param name="struts_action" value="/enterprise_admin/edit_user_portrait" />
		</portlet:actionURL>

		<aui:form action="<%= editUserPortraitURL %>" enctype="multipart/form-data" method="post" name="fm">
			<aui:input name="p_u_i_d" type="hidden" value="<%= selUser.getUserId() %>" />

			<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />
			<liferay-ui:error exception="<%= UserPortraitSizeException.class %>" message="please-enter-a-file-with-a-valid-file-size" />
			<liferay-ui:error exception="<%= UserPortraitTypeException.class %>" message="please-enter-a-file-with-a-valid-file-type" />

			<aui:fieldset>
				<aui:input label='<%= LanguageUtil.format(pageContext, "upload-a-gif-or-jpeg-that-is-x-pixels-tall-and-x-pixels-wide", new Object[] {"120", "100"}, false) %>' name="fileName" size="50" type="file" />

				<aui:button-row>
					<aui:button type="submit" />

					<aui:button onClick="window.close();" type="cancel" value="close" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>

		<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
			<aui:script>
				Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />fileName);
			</aui:script>
		</c:if>
	</c:otherwise>
</c:choose>