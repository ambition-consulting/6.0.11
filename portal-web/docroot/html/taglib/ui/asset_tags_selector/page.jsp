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

<%@ include file="/html/taglib/ui/asset_tags_selector/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_asset_tags_selector_page") + StringPool.UNDERLINE;

String className = (String)request.getAttribute("liferay-ui:asset-tags-selector:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:asset-tags-selector:classPK"));
String hiddenInput = (String)request.getAttribute("liferay-ui:asset-tags-selector:hiddenInput");
String curTags = GetterUtil.getString((String)request.getAttribute("liferay-ui:asset-tags-selector:curTags"));
boolean focus = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:asset-tags-selector:focus"));
String contentCallback = GetterUtil.getString((String)request.getAttribute("liferay-ui:asset-tags-selector:contentCallback"));

boolean suggestible = Validator.isNotNull(contentCallback);

if (Validator.isNotNull(className) && (classPK > 0)) {
	List<AssetTag> tags = AssetTagServiceUtil.getTags(className, classPK);

	curTags = ListUtil.toString(tags, "name");
}

String curTagsParam = request.getParameter(hiddenInput);

if (curTagsParam != null) {
	curTags = curTagsParam;
}
%>

<div class="lfr-tags-selector-content" id="<%= namespace + randomNamespace %>assetTagsSelector">
	<aui:input name="<%= hiddenInput %>" type="hidden" />

	<input class="lfr-tag-selector-input" id="<%= randomNamespace %>assetTagNames" size="15" type="text" />
</div>

<aui:script use="liferay-asset-tags-selector">
	new Liferay.AssetTagsSelector(
		{
			allowSuggestions: true,
			contentBox: '#<%= namespace + randomNamespace %>assetTagsSelector',

			<c:if test="<%= suggestible %>">
				contentCallback: function() {
					if (window.<%= contentCallback %>) {
						return <%= contentCallback %>();
					}
				},
			</c:if>

			curEntries: '<%= HtmlUtil.escapeJS(curTags) %>',
			focused: <%= focus %>,
			hiddenInput: '#<%= namespace + hiddenInput %>',
			input: '#<%= randomNamespace %>assetTagNames',
			instanceVar: '<%= namespace + randomNamespace %>'
		}
	).render();
</aui:script>