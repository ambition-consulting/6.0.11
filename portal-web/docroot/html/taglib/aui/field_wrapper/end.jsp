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

<%@ include file="/html/taglib/init.jsp" %>

<%
String helpMessage = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:helpMessage"));
String inlineLabel = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:inlineLabel"));
String label = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:label"));
String name = GetterUtil.getString((String)request.getAttribute("aui:field-wrapper:name"));

boolean showForLabel = false;

if (Validator.isNotNull(name)) {
	showForLabel = true;

	name = namespace + name;
}
%>

		<c:if test='<%= inlineLabel.equals("right") %>'>
			<label <%= AUIUtil.buildLabel(inlineLabel, showForLabel, name) %>>
				<liferay-ui:message key="<%= label %>" />

				<c:if test="<%= Validator.isNotNull(helpMessage) %>">
					<liferay-ui:icon-help message="<%= helpMessage %>" />
				</c:if>
			</label>
		</c:if>
	</div>
</div>