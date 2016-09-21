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

<%@ include file="/html/taglib/ui/asset_categories_selector/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_asset_categories_selector_page") + StringPool.UNDERLINE;

String className = (String)request.getAttribute("liferay-ui:asset-categories-selector:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:asset-categories-selector:classPK"));
String hiddenInput = (String)request.getAttribute("liferay-ui:asset-categories-selector:hiddenInput");
String curCategoryIds = GetterUtil.getString((String)request.getAttribute("liferay-ui:asset-categories-selector:curCategoryIds"), "");
String curCategoryNames = StringPool.BLANK;

if (Validator.isNotNull(className) && (classPK > 0)) {
	List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(className, classPK);

	curCategoryIds = ListUtil.toString(categories, "categoryId");
	curCategoryNames = ListUtil.toString(categories, "name");
}

String curCategoryIdsParam = request.getParameter(hiddenInput);

if (curCategoryIdsParam != null) {
	curCategoryIds = curCategoryIdsParam;
}

if (Validator.isNotNull(curCategoryIds)) {
	long[] curCategoryIdsArray = GetterUtil.getLongValues(StringUtil.split(curCategoryIds));

	if(curCategoryIdsArray.length == 0) {
		curCategoryNames = StringPool.BLANK;
	}
	else {
		StringBundler sb = new StringBundler(curCategoryIdsArray.length * 2);
		for (long curCategoryId : curCategoryIdsArray) {
			AssetCategory category = AssetCategoryServiceUtil.getCategory(curCategoryId);

			sb.append(category.getName());
			sb.append(StringPool.COMMA);
		}

		sb.setIndex(sb.index() - 1);

		curCategoryNames = sb.toString();
	}
}
%>

<div class="lfr-tags-selector-content" id="<%= namespace + randomNamespace %>assetCategoriesSelector">
	<aui:input name="<%= hiddenInput %>" type="hidden" />
</div>

<aui:script use="liferay-asset-categories-selector">
	new Liferay.AssetCategoriesSelector(
		{
			contentBox: '#<%= namespace + randomNamespace %>assetCategoriesSelector',
			curEntries: '<%= HtmlUtil.escapeJS(curCategoryNames) %>',
			curEntryIds: '<%= curCategoryIds %>',
			hiddenInput: '#<%= namespace + hiddenInput %>',
			instanceVar: '<%= namespace + randomNamespace %>'
		}
	).render();
</aui:script>