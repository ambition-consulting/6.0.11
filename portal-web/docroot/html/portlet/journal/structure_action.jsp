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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JournalStructure structure = (JournalStructure)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= JournalStructurePermission.contains(permissionChecker, structure, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/journal/edit_structure" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
			<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= JournalStructurePermission.contains(permissionChecker, structure, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= JournalStructure.class.getName() %>"
			modelResourceDescription="<%= structure.getName() %>"
			resourcePrimKey="<%= String.valueOf(structure.getId()) %>"
			var="permissionsURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsURL %>"
		/>
	</c:if>

	<c:if test="<%= JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_STRUCTURE) %>">
		<portlet:renderURL var="copyURL">
			<portlet:param name="struts_action" value="/journal/copy_structure" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
			<portlet:param name="oldStructureId" value="<%= structure.getStructureId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="copy"
			url="<%= copyURL.toString() %>"
		/>
	</c:if>

	<c:if test="<%= JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ARTICLE) %>">
		<portlet:renderURL var="addArticleURL">
			<portlet:param name="struts_action" value="/journal/edit_article" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
			<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="add_article"
			message="add-web-content"
			url="<%= addArticleURL %>"
		/>
	</c:if>

	<portlet:renderURL var="viewArticleURL">
		<portlet:param name="struts_action" value="/journal/view" />
		<portlet:param name="tabs1" value="web-content" />
		<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
		<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="view_articles"
		message="view-web-content"
		url="<%= viewArticleURL %>"
	/>

	<c:if test="<%= JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_TEMPLATE) %>">
		<portlet:renderURL var="addTemplateURL">
			<portlet:param name="struts_action" value="/journal/edit_template" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
			<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="add_template"
			message="add-template"
			url="<%= addTemplateURL %>"
		/>
	</c:if>

	<portlet:renderURL var="viewTemplateURL">
		<portlet:param name="struts_action" value="/journal/view" />
		<portlet:param name="tabs1" value="templates" />
		<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
		<portlet:param name="structureId" value="<%= structure.getStructureId() %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="view_templates"
		message="view-templates"
		url="<%= viewTemplateURL %>"
	/>

	<c:if test="<%= JournalStructurePermission.contains(permissionChecker, structure, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/journal/edit_structure" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(structure.getGroupId()) %>" />
			<portlet:param name="deleteStructureIds" value="<%= structure.getStructureId() %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>