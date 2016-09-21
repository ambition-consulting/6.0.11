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

<%@ page import="com.liferay.portal.NoSuchWorkflowInstanceLinkException" %>

<%
Object bean = request.getAttribute("aui:workflow-status:bean");
String id = GetterUtil.getString((String)request.getAttribute("aui:workflow-status:id"));
Class<?> model = (Class<?>)request.getAttribute("aui:workflow-status:model");
int status = GetterUtil.getInteger((String)request.getAttribute("aui:workflow-status:status"));
String version = GetterUtil.getString((String)request.getAttribute("aui:workflow-status:version"));
%>

<div class="taglib-workflow-status">
	<c:if test="<%= Validator.isNotNull(id) %>">
		<span class="workflow-id"><liferay-ui:message key="id" />: <%= HtmlUtil.escape(id) %></span>
	</c:if>

	<c:if test="<%= Validator.isNotNull(version) %>">
		<span class="workflow-version"><liferay-ui:message key="version" />: <strong><%= version %></strong></span>
	</c:if>

	<%
	String statusMessage = StringPool.BLANK;
	String additionalText = StringPool.BLANK;

	if (status == WorkflowConstants.STATUS_APPROVED) {
		statusMessage = "approved";
	}
	else if (status == WorkflowConstants.STATUS_DRAFT) {
		statusMessage = "draft";
	}
	else if (status == WorkflowConstants.STATUS_EXPIRED) {
		statusMessage = "expired";
	}
	else if (status == WorkflowConstants.STATUS_PENDING) {
		statusMessage = "pending";

		long companyId = BeanPropertiesUtil.getLong(bean, "companyId");
		long groupId = BeanPropertiesUtil.getLong(bean, "groupId");
		long classPK = BeanPropertiesUtil.getLong(bean, "primaryKey");

		StringBundler sb = new StringBundler(4);

		try {
			String workflowStatus = WorkflowInstanceLinkLocalServiceUtil.getState(companyId, groupId, model.getName(), classPK);

			sb.append(StringPool.SPACE);
			sb.append(StringPool.OPEN_PARENTHESIS);
			sb.append(LanguageUtil.get(pageContext, workflowStatus));
			sb.append(StringPool.CLOSE_PARENTHESIS);

			additionalText = sb.toString();
		}
		catch (NoSuchWorkflowInstanceLinkException nswile) {
		}
	}
	%>

	<span class="workflow-status"><liferay-ui:message key="status" />: <strong class="workflow-status-<%= statusMessage %>"><liferay-ui:message key="<%= statusMessage %>" /><%= additionalText %></strong></span>

	<c:if test="<%= (status == WorkflowConstants.STATUS_APPROVED) && Validator.isNotNull(version) %>">
		<liferay-ui:icon-help message="a-new-version-will-be-created-automatically-if-this-content-is-modified" />
	</c:if>
</div>