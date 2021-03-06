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

<%@ include file="/html/portlet/asset_tags_navigation/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

List<AssetRendererFactory> assetRendererFactories = AssetRendererFactoryRegistryUtil.getAssetRendererFactories();
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset>
		<ul class="lfr-tree lfr-component">
			<li class="tree-item">
				<aui:input inlineLabel="left" label="show-tags-with-zero-assets" name="showZeroAssetCount" type="checkbox" value="<%= showZeroAssetCount %>" />
			</li>

			<li class="tree-item">
				<aui:input inlineLabel="left" name="showAssetCount" type="checkbox" value="<%= showAssetCount %>" />

				<ul class="lfr-tree lfr-component aui-helper-hidden" id="<portlet:namespace />assetCountOptions">
					<li class="tree-item">
						<aui:select helpMessage="asset-type-asset-count-help" label="asset-type" name="classNameId">
							<aui:option label="any" value="<%= classNameId == 0 %>" />

							<%
							for (AssetRendererFactory assetRendererFactory : assetRendererFactories) {
							%>

								<aui:option label='<%= "model.resource." + assetRendererFactory.getClassName() %>' selected="<%= classNameId == assetRendererFactory.getClassNameId() %>" value="<%= assetRendererFactory.getClassNameId() %>" />

							<%
							}
							%>

						</aui:select>
					</li>

					<li class="tree-item">
						<aui:select name="displayStyle">
							<aui:option label="number" selected='<%= displayStyle.equals("number") %>' />
							<aui:option label="cloud" selected='<%= displayStyle.equals("cloud") %>' />
						</aui:select>
					</li>
				</ul>
			</li>
		</ul>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	var showAssetCount = A.one('#<portlet:namespace />showAssetCountCheckbox');

	function showHiddenFields() {
		var assetCountOptions = A.one('#<portlet:namespace />assetCountOptions');

		if (showAssetCount && assetCountOptions) {
			if (showAssetCount.get('checked')) {
				assetCountOptions.show();
			}
			else {
				assetCountOptions.hide();
			}
		}
	}

	showHiddenFields();

	showAssetCount.on('change', showHiddenFields);
</aui:script>