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
String randomId = StringPool.BLANK;

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

WorkflowTask workflowTask = null;

if (row != null) {
	randomId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);

	Object result = row.getObject();

	workflowTask = (WorkflowTask)row.getParameter("workflowTask");
}
else {
	workflowTask = (WorkflowTask)request.getAttribute(WebKeys.WORKFLOW_TASK);
}

long[] pooledActorsIds = WorkflowTaskManagerUtil.getPooledActorsIds(company.getCompanyId(), workflowTask.getWorkflowTaskId());

Calendar dueDate = CalendarFactoryUtil.getCalendar(timeZone, locale);

if (workflowTask.getDueDate() != null) {
	dueDate.setTime(workflowTask.getDueDate());
}
%>

<liferay-ui:icon-menu showExpanded="<%= (row == null) %>" showWhenSingleIcon="<%= (row == null) %>">
	<c:if test="<%= !workflowTask.isCompleted() && isAssignedToUser(workflowTask, user) %>">

		<%
		List<String> transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(company.getCompanyId(), user.getUserId(), workflowTask.getWorkflowTaskId());

		for (String transitionName : transitionNames) {
			String message = "proceed";

			if (Validator.isNotNull(transitionName)) {
				message = transitionName;
			}
		%>

			<portlet:actionURL var="editURL">
				<portlet:param name="struts_action" value="/workflow_tasks/edit_workflow_task" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SAVE %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="workflowTaskId" value="<%= StringUtil.valueOf(workflowTask.getWorkflowTaskId()) %>" />
				<portlet:param name="assigneeUserId" value="<%= StringUtil.valueOf(workflowTask.getAssigneeUserId()) %>" />

				<c:if test="<%= transitionName != null %>">
					<portlet:param name="transitionName" value="<%= transitionName %>" />
				</c:if>
			</portlet:actionURL>

			<liferay-ui:icon
				cssClass='<%= "workflow-task-" + randomId + " task-change-status-link" %>'
				id='<%= randomId + transitionName + "taskChangeStatusLink" %>'
				image="../aui/shuffle"
				message="<%= message %>"
				method="get"
				url="<%= editURL %>"
			/>

		<%
		}
		%>

	</c:if>

	<c:if test="<%= !workflowTask.isCompleted() && !isAssignedToUser(workflowTask, user) %>">
		<portlet:actionURL var="assignToMeURL">
			<portlet:param name="struts_action" value="/workflow_tasks/edit_workflow_task" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ASSIGN %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="workflowTaskId" value="<%= String.valueOf(workflowTask.getWorkflowTaskId()) %>" />
			<portlet:param name="assigneeUserId" value="<%= String.valueOf(user.getUserId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			cssClass='<%= "workflow-task-" + randomId + " task-assign-to-me-link" %>'
			id='<%= randomId + "taskAssignToMeLink" %>'
			image="assign"
			message="assign-to-me"
			method="get"
			url="<%= assignToMeURL %>"
		/>
	</c:if>

	<c:if test="<%= _hasOtherAssignees(pooledActorsIds, workflowTask, user) %>">
		<portlet:actionURL var="assignURL">
			<portlet:param name="struts_action" value="/workflow_tasks/edit_workflow_task" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ASSIGN %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="workflowTaskId" value="<%= String.valueOf(workflowTask.getWorkflowTaskId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			cssClass='<%= "workflow-task-" + randomId + " task-assign-link" %>'
			id='<%= randomId + "taskAssignLink" %>'
			image="assign"
			message="assign-to-..."
			method="get"
			url="<%= assignURL %>"
		/>
	</c:if>

	<c:if test="<%= !workflowTask.isCompleted() %>">
		<portlet:actionURL var="updateDueDateURL">
			<portlet:param name="struts_action" value="/workflow_tasks/edit_workflow_task" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="workflowTaskId" value="<%= StringUtil.valueOf(workflowTask.getWorkflowTaskId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			cssClass='<%= "workflow-task-" + randomId + " task-due-date-link" %>'
			id='<%= randomId + "taskDueDateLink" %>'
			image="time"
			message="update-due-date"
			method="get"
			url="<%= updateDueDateURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>

<div class="aui-helper-hidden" id="<%= randomId %>updateAsignee">
	<c:if test="<%= _hasOtherAssignees(pooledActorsIds, workflowTask, user) %>">
		<aui:select label="assign-to" name="assigneeUserId">

			<%
			for (long pooledActorId : pooledActorsIds) {
				if (pooledActorId == user.getUserId()) {
					continue;
				}
			%>

				<aui:option label="<%= HtmlUtil.escape(PortalUtil.getUserName(pooledActorId, StringPool.BLANK)) %>" selected="<%= workflowTask.getAssigneeUserId() == pooledActorId %>" value="<%= String.valueOf(pooledActorId) %>" />

			<%
			}
			%>

		</aui:select>
	</c:if>
</div>

<div class="aui-helper-hidden" id="<%= randomId %>updateAsigneeToMe">
	<aui:input name="asigneeUserId" type="hidden" value="<%= user.getUserId() %>" />
</div>

<div class="aui-helper-hidden" id="<%= randomId %>updateDueDate">
	<aui:input bean="<%= workflowTask %>" model="<%= WorkflowTask.class %>" name="dueDate" value="<%= dueDate %>" />
</div>

<div class="aui-helper-hidden" id="<%= randomId %>updateComments">
	<aui:input cols="55" name="comment" type="textarea" rows="10" />
</div>

<aui:script use="liferay-workflow-tasks">
	var onTaskClickFn = A.rbind(Liferay.WorkflowTasks.onTaskClick, Liferay.WorkflowTasks, '<%= randomId %>');

	<c:if test="<%= !workflowTask.isCompleted() && isAssignedToUser(workflowTask, user) %>">

		<%
		List<String> transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(company.getCompanyId(), user.getUserId(), workflowTask.getWorkflowTaskId());

		for (String transitionName : transitionNames) {
			String message = "proceed";

			if (Validator.isNotNull(transitionName)) {
				message = transitionName;
			}
		%>

			Liferay.delegateClick('<portlet:namespace /><%= randomId + transitionName %>taskChangeStatusLink', onTaskClickFn);

		<%
		}
		%>

	</c:if>

	Liferay.delegateClick('<portlet:namespace /><%= randomId %>taskAssignToMeLink', onTaskClickFn);
	Liferay.delegateClick('<portlet:namespace /><%= randomId %>taskAssignLink', onTaskClickFn);
	Liferay.delegateClick('<portlet:namespace /><%= randomId %>taskDueDateLink', onTaskClickFn);
</aui:script>