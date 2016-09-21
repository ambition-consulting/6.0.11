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

<%@ include file="/html/taglib/ui/panel/init.jsp" %>

<div class="lfr-panel <%= cssClass %>" id="<%= id %>">
	<div class="lfr-panel-titlebar">
		<div class="lfr-panel-title">
			<span>
				<%= title %>
			</span>
		</div>

		<c:if test="<%= collapsible && extended %>">
			<a class="lfr-panel-button" href="javascript:;"></a>
		</c:if>
	</div>

	<div class="lfr-panel-content">