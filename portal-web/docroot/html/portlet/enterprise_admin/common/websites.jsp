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
String className = (String)request.getAttribute("websites.className");
long classPK = (Long)request.getAttribute("websites.classPK");

List<Website> websites = Collections.EMPTY_LIST;

int[] websitesIndexes = null;

String websitesIndexesParam = ParamUtil.getString(request, "websitesIndexes");

if (Validator.isNotNull(websitesIndexesParam)) {
	websites = new ArrayList<Website>();

	websitesIndexes = StringUtil.split(websitesIndexesParam, 0);

	for (int websitesIndex : websitesIndexes) {
		websites.add(new WebsiteImpl());
	}
}
else {
	if (classPK > 0) {
		websites = WebsiteServiceUtil.getWebsites(className, classPK);

		websitesIndexes = new int[websites.size()];

		for (int i = 0; i < websites.size(); i++) {
			websitesIndexes[i] = i;
		}
	}

	if (websites.isEmpty()) {
		websites = new ArrayList<Website>();

		websites.add(new WebsiteImpl());

		websitesIndexes = new int[] {0};
	}

	if (websitesIndexes == null) {
		websitesIndexes = new int[0];
	}
}
%>

<liferay-ui:error-marker key="errorSection" value="websites" />

<h3><liferay-ui:message key="websites" /></h3>

<liferay-ui:error key="<%= NoSuchListTypeException.class.getName() + className + ListTypeConstants.WEBSITE %>" message="please-select-a-type" />
<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

<aui:fieldset>

	<%
	for (int i = 0; i < websitesIndexes.length; i++) {
		int websitesIndex = websitesIndexes[i];

		Website website = websites.get(i);
	%>

		<aui:model-context bean="<%= website %>" model="<%= Website.class %>" />

		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">

				<aui:input name='<%= "websiteId" + websitesIndex %>' type="hidden" />

				<aui:input fieldParam='<%= "websiteUrl" + websitesIndex %>' name="url" />

				<aui:select label="type" name='<%= "websiteTypeId" + websitesIndex %>' listType="<%= className + ListTypeConstants.WEBSITE %>" />

				<aui:input checked="<%= website.isPrimary() %>" cssClass="primary-ctrl" id='<%= "websitePrimary" + websitesIndex %>' inlineLabel="left" label="primary" name="websitePrimary" type="radio" value="<%= websitesIndex %>" />
			</div>
		</div>

	<%
	}
	%>

	<aui:input name="websitesIndex" type="hidden" value="<%= StringUtil.merge(websitesIndexes) %>" />
</aui:fieldset>

<aui:script use="liferay-auto-fields">
	Liferay.once(
		'enterpriseAdmin:revealwebsites',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#websites > fieldset',
					fieldIndexes: '<portlet:namespace />websitesIndexes'
				}
			).render();
		}
	);
</aui:script>