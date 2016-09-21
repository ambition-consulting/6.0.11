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

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

DLFolder folder = (DLFolder)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDER);

long folderId = BeanParamUtil.getLong(folder, request, "folderId");

long parentFolderId = BeanParamUtil.getLong(folder, request, "parentFolderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
%>

<liferay-util:include page="/html/portlet/document_library/top_links.jsp" />

<portlet:actionURL var="editFolderURL">
	<portlet:param name="struts_action" value="/document_library/edit_folder" />
</portlet:actionURL>

<aui:form action="<%= editFolderURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveFolder();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
	<aui:input name="parentFolderId" type="hidden" value="<%= parentFolderId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (folder != null) ? folder.getName() : "new-folder" %>'
	/>

	<liferay-ui:error exception="<%= DuplicateFileException.class %>" message="please-enter-a-unique-folder-name" />
	<liferay-ui:error exception="<%= DuplicateFolderNameException.class %>" message="please-enter-a-unique-folder-name" />
	<liferay-ui:error exception="<%= FolderNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= folder %>" model="<%= DLFolder.class %>" />

	<aui:fieldset>
		<c:if test="<%= folder != null %>">
			<aui:field-wrapper label="parent-folder">

				<%
				String parentFolderName = "";

				try {
					DLFolder parentFolder = DLFolderLocalServiceUtil.getFolder(parentFolderId);

					parentFolderName = parentFolder.getName();
				}
				catch (NoSuchFolderException nscce) {
				}
				%>

				<portlet:renderURL var="viewFolderURL">
					<portlet:param name="struts_action" value="/document_library/view" />
					<portlet:param name="folderId" value="<%= String.valueOf(parentFolderId) %>" />
				</portlet:renderURL>

				<aui:a href="<%= viewFolderURL %>" id="parentFolderName"><%= parentFolderName %></aui:a>

				<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="selectFolderURL">
					<portlet:param name="struts_action" value="/document_library/select_folder" />
					<portlet:param name="folderId" value="<%= String.valueOf(parentFolderId) %>" />
				</portlet:renderURL>

				<%
				String taglibOpenFolderWindow = "var folderWindow = window.open('" + selectFolderURL + "','folder', 'directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680'); void(''); folderWindow.focus();";
				%>

				<aui:button onClick='<%= taglibOpenFolderWindow %>' value="select" />

				<aui:button name="removeFolderButton" onClick='<%= renderResponse.getNamespace() + "removeFolder();" %>' value="remove" />
			</aui:field-wrapper>
		</c:if>

		<aui:input name="name" />

		<aui:input name="description" />

		<liferay-ui:custom-attributes-available className="<%= DLFolder.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= DLFolder.class.getName() %>"
				classPK="<%= (folder != null) ? folder.getFolderId() : 0 %>"
				editable="<%= true %>"
				label="<%= true %>"
			/>
		</liferay-ui:custom-attributes-available>

		<c:if test="<%= folder == null %>">
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions
					modelName="<%= DLFolder.class.getName() %>"
				/>
			</aui:field-wrapper>
		</c:if>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button onClick="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />removeFolder() {
		document.<portlet:namespace />fm.<portlet:namespace />parentFolderId.value = "<%= rootFolderId %>";

		var nameEl = document.getElementById("<portlet:namespace />parentFolderName");

		nameEl.href = "";
		nameEl.innerHTML = "";
	}

	function <portlet:namespace />saveFolder() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (folder == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectFolder(parentFolderId, parentFolderName) {
		document.<portlet:namespace />fm.<portlet:namespace />parentFolderId.value = parentFolderId;

		var nameEl = document.getElementById("<portlet:namespace />parentFolderName");

		nameEl.href = "<portlet:renderURL><portlet:param name="struts_action" value="/document_library/view" /></portlet:renderURL>&<portlet:namespace />folderId=" + parentFolderId;
		nameEl.innerHTML = parentFolderName + "&nbsp;";
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) || windowState.equals(LiferayWindowState.POP_UP) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />name);
	</c:if>
</aui:script>

<%
if (folder == null) {
	DLUtil.addPortletBreadcrumbEntries(parentFolderId, request, renderResponse);

	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-folder"), currentURL);
}
else {
	DLUtil.addPortletBreadcrumbEntries(folder.getFolderId(), request, renderResponse);

	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
}
%>