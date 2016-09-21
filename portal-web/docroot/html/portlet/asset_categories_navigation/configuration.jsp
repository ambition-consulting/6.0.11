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

<%@ include file="/html/portlet/asset_categories_navigation/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset>
		<liferay-ui:message key="vocabularies" />

		<select name="<portlet:namespace />allAssetVocabularies" id="<portlet:namespace />allAssetVocabularies">
			<option <%= allAssetVocabularies ? "selected" : StringPool.BLANK %> value="<%= true %>"><liferay-ui:message key="all" /></option>
			<option <%= !allAssetVocabularies ? "selected" : StringPool.BLANK %> value="<%= false %>"><liferay-ui:message key="filter[action]" />...</option>
		</select>

		<input name="<portlet:namespace />assetVocabularyIds" type="hidden" value="" />

		<%
		Set<Long> availableAssetVocabularyIdsSet = SetUtil.fromArray(availableAssetVocabularyIds);

		// Left list

		List<KeyValuePair> typesLeftList = new ArrayList<KeyValuePair>();

		for (long vocabularyId : assetVocabularyIds) {
			try {
				AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(vocabularyId);

				typesLeftList.add(new KeyValuePair(String.valueOf(vocabularyId), _getName(vocabulary, themeDisplay)));
			}
			catch (NoSuchVocabularyException nsve) {
			}
		}

		// Right list

		List<KeyValuePair> typesRightList = new ArrayList<KeyValuePair>();

		Arrays.sort(assetVocabularyIds);

		for (long vocabularyId : availableAssetVocabularyIdsSet) {
			if (Arrays.binarySearch(assetVocabularyIds, vocabularyId) < 0) {
				AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(vocabularyId);

				typesRightList.add(new KeyValuePair(String.valueOf(vocabularyId), _getName(vocabulary, themeDisplay)));
			}
		}

		typesRightList = ListUtil.sort(typesRightList, new KeyValuePairComparator(false, true));
		%>

		<div class="<%= allAssetVocabularies ? "aui-helper-hidden" : "" %>" id="<portlet:namespace />assetVocabulariesBoxes">
			<liferay-ui:input-move-boxes
				leftTitle="current"
				rightTitle="available"
				leftBoxName="currentAssetVocabularyIds"
				rightBoxName="availableAssetVocabularyIds"
				leftReorder="true"
				leftList="<%= typesLeftList %>"
				rightList="<%= typesRightList %>"
			/>
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />saveConfiguration',
		function(){
			if (document.<portlet:namespace />fm.<portlet:namespace />assetVocabularyIds) {
				document.<portlet:namespace />fm.<portlet:namespace />assetVocabularyIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentAssetVocabularyIds);
			}

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.Util.toggleSelectBox('<portlet:namespace />allAssetVocabularies', 'false', '<portlet:namespace />assetVocabulariesBoxes');
</aui:script>

<%!
private String _getName(AssetVocabulary vocabulary, ThemeDisplay themeDisplay) {
	String name = vocabulary.getName();

	if (vocabulary.getGroupId() == themeDisplay.getCompanyGroupId()) {
		name += " (" + LanguageUtil.get(themeDisplay.getLocale(), "global") + ")";
	}

	return name;
}
%>