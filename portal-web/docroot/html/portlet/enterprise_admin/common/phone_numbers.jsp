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
String className = (String)request.getAttribute("phones.className");
long classPK = (Long)request.getAttribute("phones.classPK");

List<Phone> phones = Collections.EMPTY_LIST;

int[] phonesIndexes = null;

String phonesIndexesParam = ParamUtil.getString(request, "phonesIndexes");

if (Validator.isNotNull(phonesIndexesParam)) {
	phones = new ArrayList<Phone>();

	phonesIndexes = StringUtil.split(phonesIndexesParam, 0);

	for (int phonesIndex : phonesIndexes) {
		phones.add(new PhoneImpl());
	}
}
else {

	if (classPK > 0) {
		phones = PhoneServiceUtil.getPhones(className, classPK);

		phonesIndexes = new int[phones.size()];

		for (int i = 0; i < phones.size() ; i++) {
			phonesIndexes[i] = i;
		}
	}

	if (phones.isEmpty()) {
		phones = new ArrayList<Phone>();

		phones.add(new PhoneImpl());

		phonesIndexes = new int[] {0};
	}

	if (phonesIndexes == null) {
		phonesIndexes = new int[0];
	}
}

%>

<liferay-ui:error-marker key="errorSection" value="phoneNumbers" />

<h3><liferay-ui:message key="phone-numbers" /></h3>

<liferay-ui:error key="<%= NoSuchListTypeException.class.getName() + className + ListTypeConstants.PHONE %>" message="please-select-a-type" />
<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />

<aui:fieldset>

	<%
	for (int i = 0; i < phonesIndexes.length; i++) {
		int phonesIndex = phonesIndexes[i];

		Phone phone = phones.get(i);
	%>

		<aui:model-context bean="<%= phone %>" model="<%= Phone.class %>" />

		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields">
				<aui:input name='<%= "phoneId" + phonesIndex %>' type="hidden" value="<%= phone.getPhoneId() %>" />

				<aui:input fieldParam='<%= "phoneNumber" + phonesIndex %>' name="number" />

				<aui:input fieldParam='<%= "phoneExtension" + phonesIndex %>' name="extension" />

				<aui:select label="type" name='<%= "phoneTypeId" + phonesIndex %>' listType="<%= className + ListTypeConstants.PHONE %>" />

				<aui:input checked="<%= phone.isPrimary() %>" cssClass="primary-ctrl" id='<%= "phonePrimary" + phonesIndex %>' inlineLabel="left" label="primary" name="phonePrimary" type="radio" value="<%= phonesIndex %>" />
			</div>
		</div>

	<%
	}
	%>

	<aui:input name="phonesIndexes" type="hidden" value="<%= StringUtil.merge(phonesIndexes) %>" />
</aui:fieldset>

<aui:script use="liferay-auto-fields">
	Liferay.once(
		'enterpriseAdmin:revealphoneNumbers',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#phoneNumbers > fieldset',
					fieldIndexes: '<portlet:namespace />phonesIndexes'
				}
			).render();
		}
	);
</aui:script>