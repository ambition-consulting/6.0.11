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

<%@ include file="/html/portlet/communities/init.jsp" %>

<%
long groupId = ((Long)request.getAttribute("edit_pages.jsp-groupId")).longValue();
long selPlid = ((Long)request.getAttribute("edit_pages.jsp-selPlid")).longValue();
boolean privateLayout = ((Boolean)request.getAttribute("edit_pages.jsp-privateLayout")).booleanValue();

String rootNodeName = (String)request.getAttribute("edit_pages.jsp-rootNodeName");

boolean selectableTree = ParamUtil.getBoolean(request, "selectableTree");
String treeId = ParamUtil.getString(request, "treeId");

PortletURL portletURL = (PortletURL)request.getAttribute("edit_pages.jsp-portletURL");
%>

<div class="lfr-tree-loading" id="<portlet:namespace />treeLoading">
	<span class="aui-icon aui-icon-loading lfr-tree-loading-icon"></span>
</div>

<div class="lfr-tree" id="<portlet:namespace /><%= HtmlUtil.escape(treeId) %>Output"></div>

<aui:script use="aui-io-request,aui-tree-view,dataschema-xml,datatype-xml">
	var TreeUtil = {
		DEFAULT_PARENT_LAYOUT_ID: <%= LayoutConstants.DEFAULT_PARENT_LAYOUT_ID %>,
		OPEN_NODES: '<%= SessionTreeJSClicks.getOpenNodes(request, treeId) %>'.split(','),
		PREFIX_LAYOUT_ID: '_layoutId_',
		PREFIX_PLID: '_plid_',
		SELECTED_NODES: '<%= SessionTreeJSClicks.getOpenNodes(request, treeId + "SelectedNode") %>'.split(','),

		afterRenderTree: function(event) {
			var treeInstance = event.target;

			var rootNode = treeInstance.item(0);
			var loadingEl = A.one('#<portlet:namespace />treeLoading');

			loadingEl.hide();

			TreeUtil.restoreNodeState(rootNode);
		},

		createId: function(layoutId, plid) {
			return '<%= HtmlUtil.escape(treeId) %>' + TreeUtil.PREFIX_LAYOUT_ID + layoutId + TreeUtil.PREFIX_PLID + plid;
		},

		createLink: function(label, plid) {
			return '<a href="<%= portletURL + StringPool.AMPERSAND + portletDisplay.getNamespace() + "selPlid=" %>'+ plid +'">'+ Liferay.Util.escapeHTML(label) +'</a>';
		},

		extractLayoutId: function(node) {
			return node.get('id').match(/layoutId_(\d+)/)[1];
		},

		extractPlid: function(node) {
			return node.get('id').match(/plid_(\d+)/)[1];
		},

		formatJSONResults: function(json) {
			var output = [];

			A.each(
				json,
				function(node) {
					var xmlDoc = A.DataType.XML.parse(node.name);

					var newNode = {
						after: {
							check: function(event) {
								var plid = TreeUtil.extractPlid(event.target);

								TreeUtil.updateSessionTreeClick(plid, true, '<%= HtmlUtil.escape(treeId) %>SelectedNode');
							},
							uncheck: function(event) {
								var plid = TreeUtil.extractPlid(event.target);

								TreeUtil.updateSessionTreeClick(plid, false, '<%= HtmlUtil.escape(treeId) %>SelectedNode');
							}
						},
						alwaysShowHitArea: node.hasChildren,
						id: TreeUtil.createId(node.layoutId, node.plid),
						type: '<%= selectableTree ? "task" : "io" %>'
					};

					newNode.label = TreeUtil.getNodeLabel(xmlDoc);

					if (!<%= selectableTree %>) {
						newNode.label = TreeUtil.createLink(newNode.label, node.plid);
					}

					output.push(newNode);
				}
			);

			return output;
		},

		getLocalizedLabel: function(locale, xmlDoc) {
			var schema = TreeUtil.getSchema('label', 'name[@language-id="' + locale + '"]');
			var localizedLabel = TreeUtil.mergeSchema(schema, xmlDoc);

			return localizedLabel.label;
		},

		getNodeLabel: function(xmlDoc) {
			var label = TreeUtil.getLocalizedLabel('<%= themeDisplay.getLocale() %>', xmlDoc);

			if (!label) {
				var findDefLocaleSchema = TreeUtil.getSchema('locale', '@default-locale');
				var rootDefLocale = TreeUtil.mergeSchema(findDefLocaleSchema, xmlDoc);

				if (rootDefLocale.locale) {
					label = TreeUtil.getLocalizedLabel(rootDefLocale.locale, xmlDoc);
				}
			}

			return label;
		},

		getSchema: function(key, locator) {
			return {
				resultListLocator: 'root',
				resultFields: [
					{
						key: key,
						locator: locator
					}
				]
			};
		},

		mergeSchema: function(schema, xmlDoc, index) {
			return A.DataSchema.XML.apply(schema, xmlDoc).results[0] || {};
		},

		restoreNodeState: function(node) {
			var instance = this;

			var id = node.get('id');
			var plid = TreeUtil.extractPlid(node);

			if (plid == '<%= selPlid %>') {
				node.select();
			}

			if (A.Array.indexOf(TreeUtil.OPEN_NODES, id) > -1) {
				node.expand();
			}

			if (A.Array.indexOf(TreeUtil.SELECTED_NODES, plid) > -1) {
				if (node.check) {
					node.check();
				}
			}
		},

		updateLayout: function(data) {
			var updateURL = themeDisplay.getPathMain() + '/layout_management/update_page';

			A.io.request(
				updateURL,
				{
					data: data
				}
			);
		},

		updateLayoutParent: function(dragPlid, dropPlid) {
			TreeUtil.updateLayout(
				{
					cmd: 'parent_layout_id',
					parentPlid: dropPlid,
					plid: dragPlid
				}
			);
		},

		updateLayoutPriority: function(dragPlid, index) {
			TreeUtil.updateLayout(
				{
					cmd: 'priority',
					plid: dragPlid,
					priority: index
				}
			);
		},

		updateSessionTreeClick: function(id, open, treeId) {
			var sessionClickURL = themeDisplay.getPathMain() + '/portal/session_tree_js_click';

			var data = {
				nodeId: id,
				openNode: open || false,
				treeId: treeId
			};

			A.io.request(
				sessionClickURL,
				{
					data: data
				}
			);
		}
	};

	var getLayoutsURL = themeDisplay.getPathMain() + '/layout_management/get_layouts';
	var rootId = TreeUtil.createId(TreeUtil.DEFAULT_PARENT_LAYOUT_ID, 0);
	var rootLabel = '<%= HtmlUtil.escape(rootNodeName) %>';
	var treeElId = '<portlet:namespace /><%= HtmlUtil.escape(treeId) %>Output';

	var RootNodeType = A.TreeNodeTask;
	var TreeViewType = A.TreeView;

	if (!<%= selectableTree %>) {
		RootNodeType = A.TreeNodeIO;
		TreeViewType = A.TreeViewDD;

		rootLabel = TreeUtil.createLink(rootLabel, TreeUtil.DEFAULT_PARENT_LAYOUT_ID);
	}

	var rootNode = new RootNodeType(
		{
			alwaysShowHitArea: true,
			draggable: false,
			id: rootId,
			label: rootLabel,
			leaf: false
		}
	);

	rootNode.get('contentBox').addClass('lfr-root-node');

	var treeview = new TreeViewType(
		{
			after: {
				collapse: function(event) {
					var id = event.tree.node.get('id');

					TreeUtil.updateSessionTreeClick(id, false, '<%= HtmlUtil.escape(treeId) %>');
				},
				expand: function(event) {
					var id = event.tree.node.get('id');

					TreeUtil.updateSessionTreeClick(id, true, '<%= HtmlUtil.escape(treeId) %>');
				},
				render: TreeUtil.afterRenderTree
			},
			boundingBox: '#' + treeElId,
			children: [rootNode],
			io: {
				cfg: {
					data: function(node) {
						var parentLayoutId = TreeUtil.extractLayoutId(node);

						return {
							groupId: <%= groupId %>,
							privateLayout: <%= privateLayout %>,
							parentLayoutId: parentLayoutId
						};
					},
					method: AUI.defaults.io.method
				},
				formatter: TreeUtil.formatJSONResults,
				url: getLayoutsURL
			},
			on: {
				append: function(event) {
					TreeUtil.restoreNodeState(event.tree.node);
				},
				drop: function(event) {
					var tree = event.tree;

					var index = tree.dragNode.get('parentNode').indexOf(tree.dragNode);

					TreeUtil.updateLayoutPriority(
						TreeUtil.extractPlid(tree.dragNode),
						index
					);
				},
				dropAppend: function(event) {
					var tree = event.tree;

					TreeUtil.updateLayoutParent(
						TreeUtil.extractPlid(tree.dragNode),
						TreeUtil.extractPlid(tree.dropNode)
					);
				},
				dropInsert: function(event) {
					var tree = event.tree;

					TreeUtil.updateLayoutParent(
						TreeUtil.extractPlid(tree.dragNode),
						TreeUtil.extractPlid(tree.dropNode.get('parentNode'))
					);
				}
			},
			paginator: {
				limit: <%= PropsValues.LAYOUT_MANAGE_PAGES_INITIAL_CHILDREN %>,
				offsetParam: 'start'
			},
			type: 'pages'
		}
	).render();
</aui:script>