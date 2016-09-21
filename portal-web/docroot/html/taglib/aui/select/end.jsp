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
boolean changesContext = GetterUtil.getBoolean((String)request.getAttribute("aui:select:changesContext"));
String helpMessage = GetterUtil.getString((String)request.getAttribute("aui:select:helpMessage"));
String id = namespace + GetterUtil.getString((String)request.getAttribute("aui:select:id"));
String inlineLabel = GetterUtil.getString((String)request.getAttribute("aui:select:inlineLabel"));
String label = GetterUtil.getString((String)request.getAttribute("aui:select:label"));
String suffix = GetterUtil.getString((String)request.getAttribute("aui:select:suffix"));
%>

			</select>
		</span>

		<c:if test="<%= Validator.isNotNull(suffix) %>">
			<span class="aui-suffix">
				<liferay-ui:message key="<%= suffix %>" />
			</span>
		</c:if>

		<c:if test='<%= inlineLabel.equals("right") %>'>
			<label <%= AUIUtil.buildLabel(inlineLabel, true, id) %>>
				<liferay-ui:message key="<%= label %>" />

				<c:if test="<%= Validator.isNotNull(helpMessage) %>">
					<liferay-ui:icon-help message="<%= helpMessage %>" />
				</c:if>

				<c:if test="<%= changesContext %>">
					<span class="aui-helper-hidden-accessible"><liferay-ui:message key="changing-the-value-of-this-field-will-reload-the-page" />)</span>
				</c:if>
			</label>
		</c:if>
	</span>
</span>