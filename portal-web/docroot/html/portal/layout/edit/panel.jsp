<%@ page import="com.liferay.portal.util.TreeView" %>
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

<%@ include file="/html/portal/layout/edit/init.jsp" %>

<table class="lfr-table">
<tr>
	<td>
		<liferay-ui:message key="description" />
	</td>
	<td>
		<textarea class="lfr-textarea" name="TypeSettingsProperties--description--" wrap="soft"><bean:write name="SEL_LAYOUT" property="typeSettingsProperties(description)" /></textarea>
	</td>
</tr>
</table>

<br />

<div class="portlet-msg-info">
	<liferay-ui:message key="select-the-applications-that-will-be-available-in-the-panel" />
</div>

<input id="<portlet:namespace />panelSelectedPortlets" name="TypeSettingsProperties--panelSelectedPortlets--" type="hidden" value="<bean:write name="SEL_LAYOUT" property="typeSettingsProperties(panelSelectedPortlets)" />" />

<%
String panelTreeKey = "panelSelectedPortletsPanelTree";
%>

<div id="<portlet:namespace />panelSelectPortletsOutput" style="margin: 4px;"></div>

<aui:script use="aui-tree-view">
	var panelSelectedPortletsEl = A.one('#<portlet:namespace />panelSelectedPortlets');
	var selectedPortlets = panelSelectedPortletsEl.val().split(',');

	var onCheck = function(event, plid) {
		var node = event.target;
		var add = A.Array.indexOf(selectedPortlets, plid) == -1;

		if (plid && add) {
			selectedPortlets.push(plid);

			panelSelectedPortletsEl.val(selectedPortlets.join(','));
		}
	};

	var onUncheck = function(event, plid) {
		var node = event.target;

		if (plid) {
			if (selectedPortlets.length) {
				A.Array.removeItem(selectedPortlets, plid);
			}

			panelSelectedPortletsEl.val( selectedPortlets.join(',') );
		}
	};

	var treeView = new A.TreeView(
		{
			boundingBox: '#<portlet:namespace />panelSelectPortletsOutput'
		}
	).render();

	<%
	PortletLister portletLister = new PortletLister();

	portletLister.setIncludeInstanceablePortlets(false);

	TreeView treeView = portletLister.getTreeView(layoutTypePortlet, LanguageUtil.get(pageContext, "application"), user, application);

	Iterator itr = treeView.getList().iterator();

	for (int i = 0; itr.hasNext(); i++) {
		TreeNodeView treeNodeView = (TreeNodeView)itr.next();
	%>

		var parentNode<%= i %> = treeView.getNodeById('treePanel<%= treeNodeView.getParentId() %>') || treeView;
		var objId<%= i %> = '<%= treeNodeView.getObjId() %>';
		var checked<%= i %> = objId<%= i %> ? (A.Array.indexOf(selectedPortlets, objId<%= i %>) > -1) : false;

		parentNode<%= i %>.appendChild(
			new A.TreeNodeTask(
				{
					checked: checked<%= i %>,
					expanded: <%= treeNodeView.getDepth() == 0 %>,
					id: 'treePanel<%= treeNodeView.getId() %>',
					label: '<%= UnicodeFormatter.toString(treeNodeView.getName()) %>',
					leaf: <%= treeNodeView.getDepth() > 1 %>,
					on: {
						check: A.rbind(onCheck, window, objId<%= i %>),
						uncheck: A.rbind(onUncheck, window, objId<%= i %>)
					}
				}
			)
		);

	<%
	}
	%>

</aui:script>