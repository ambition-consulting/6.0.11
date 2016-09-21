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

<%@ page import="com.liferay.taglib.aui.ToolTag" %>

<%
boolean collapsible = GetterUtil.getBoolean((String)request.getAttribute("aui:panel:collapsible"));
String label = GetterUtil.getString((String)request.getAttribute("aui:panel:label"));
String id = namespace + GetterUtil.getString((String)request.getAttribute("aui:panel:id"));
List<ToolTag> toolTags = (List<ToolTag>)request.getAttribute("aui:panel:toolTags");
%>

</div>

<aui:script use="anim,aui-panel">
	var container = new A.Panel(
		{
			bodyContent: A.one('#<%= id %>bodyContent'),
			collapsible: <%= collapsible %>,
			contentBox: '#<%= id %>',
			headerContent: '<liferay-ui:message key="<%= label %>" />'

			<c:if test="<%= toolTags != null %>">
				,tools: [

				<%
				for (int i = 0; i < toolTags.size(); i++) {
					ToolTag toolTag = toolTags.get(i);
				%>

					{
						icon: '<%= toolTag.getIcon() %>',
						id: '<%= toolTag.getId() %>',
						handler: function(event, panel) {
							<%= toolTag.getHandler() %>
						}

					}

					<c:if test="<%= (i + 1) < toolTags.size() %>">
						,
					</c:if>

				<%
				}
				%>

				]
			</c:if>

		}
	).render();
</aui:script>