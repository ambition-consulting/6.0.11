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

<%@ include file="/html/portlet/workflow_tasks/init.jsp" %>

<%
WorkflowTaskDisplayTerms displayTerms = new WorkflowTaskDisplayTerms(renderRequest);
%>

<liferay-ui:search-toggle
	id="toggle_id_workflow_task_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>

	<aui:fieldset>
		<aui:column>
			<aui:input name="<%= displayTerms.NAME %>" size="20" value="<%= displayTerms.getName() %>" />
		</aui:column>
		<aui:column>
			<aui:select name="<%= displayTerms.TYPE %>">

				<%
				String displayTermsType = displayTerms.getType();

				List<WorkflowHandler> workflowHhandlers = WorkflowHandlerRegistryUtil.getWorkflowHandlers();

				for (WorkflowHandler workflowHandler : workflowHhandlers) {
					String defaultWorkflowHandlerType = workflowHandler.getClassName();
				%>

					<aui:option label="<%= workflowHandler.getType(locale) %>" selected="<%= displayTermsType.equals(defaultWorkflowHandlerType) %>" value="<%= defaultWorkflowHandlerType %>" />

				<%
				}
				%>

			</aui:select>
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.NAME %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</aui:script>
</c:if>