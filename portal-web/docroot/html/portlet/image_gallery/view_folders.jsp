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

<%@ include file="/html/portlet/image_gallery/init.jsp" %>

<%
long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");
%>

<liferay-ui:search-container
	curParam="cur1"
	headerNames="folder,num-of-folders,num-of-images"
	iteratorURL="<%= portletURL %>"
>
	<liferay-ui:search-container-results
		results="<%= IGFolderServiceUtil.getFolders(scopeGroupId, folderId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= IGFolderServiceUtil.getFoldersCount(scopeGroupId, folderId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portlet.imagegallery.model.IGFolder"
		escapedModel="<%= true %>"
		keyProperty="folderId"
		modelVar="curFolder"
	>
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="struts_action" value="/image_gallery/view" />
			<portlet:param name="folderId" value="<%= String.valueOf(curFolder.getFolderId()) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container-column-text
			buffer="buffer"
			name="folder"
		>

			<%
			buffer.append("<a href=\"");
			buffer.append(rowURL);
			buffer.append("\">");
			buffer.append("<img alt=\"");
			buffer.append(LanguageUtil.get(pageContext, "folder"));
			buffer.append("\" class=\"label-icon\" src=\"");
			buffer.append(themeDisplay.getPathThemeImages());
			buffer.append("/common/folder.png\">");
			buffer.append("<strong>");
			buffer.append(curFolder.getName());
			buffer.append("</strong>");

			if (Validator.isNotNull(curFolder.getDescription())) {
				buffer.append("<br />");
				buffer.append(curFolder.getDescription());
			}

			buffer.append("</a>");

			List subfolders = IGFolderServiceUtil.getFolders(scopeGroupId, curFolder.getFolderId(), 0, 5);

			if (!subfolders.isEmpty()) {
				int subfoldersCount = IGFolderServiceUtil.getFoldersCount(scopeGroupId, curFolder.getFolderId());

				buffer.append("<br /><u>");
				buffer.append(LanguageUtil.get(pageContext, "subfolders"));
				buffer.append("</u>: ");

				for (int j = 0; j < subfolders.size(); j++) {
					IGFolder subfolder = (IGFolder)subfolders.get(j);

					subfolder = subfolder.toEscapedModel();

					rowURL.setParameter("folderId", String.valueOf(subfolder.getFolderId()));

					buffer.append("<a href=\"");
					buffer.append(rowURL);
					buffer.append("\">");
					buffer.append(subfolder.getName());
					buffer.append("</a>");

					if ((j + 1) < subfolders.size()) {
						buffer.append(", ");
					}
				}

				if (subfoldersCount > subfolders.size()) {
					rowURL.setParameter("folderId", String.valueOf(curFolder.getFolderId()));

					buffer.append(", <a href=\"");
					buffer.append(rowURL);
					buffer.append("\">");
					buffer.append(LanguageUtil.get(pageContext, "more"));
					buffer.append(" &raquo;");
					buffer.append("</a>");
				}

				rowURL.setParameter("folderId", String.valueOf(curFolder.getFolderId()));
			}
			%>

		</liferay-ui:search-container-column-text>

		<%
		List subfolderIds = new ArrayList();

		subfolderIds.add(new Long(curFolder.getFolderId()));

		IGFolderServiceUtil.getSubfolderIds(subfolderIds, scopeGroupId, curFolder.getFolderId());

		int subFoldersCount = subfolderIds.size() - 1;
		int subEntriesCount = IGImageServiceUtil.getFoldersImagesCount(scopeGroupId, subfolderIds);
		%>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="num-of-folders"
			value="<%= String.valueOf(subFoldersCount) %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="num-of-entries"
			value="<%= String.valueOf(subEntriesCount) %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/portlet/image_gallery/folder_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>