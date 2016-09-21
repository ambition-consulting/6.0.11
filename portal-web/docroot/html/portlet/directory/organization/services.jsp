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

<%@ include file="/html/portlet/directory/init.jsp" %>

<%
Organization organization = (Organization)request.getAttribute(WebKeys.ORGANIZATION);

long organizationId = (organization != null) ? organization.getOrganizationId() : 0;

List<OrgLabor> orgLabors = OrgLaborServiceUtil.getOrgLabors(organizationId);

Format timeFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("HH:mm", locale);
%>

<c:if test="<%= !orgLabors.isEmpty() %>">
	<h3><liferay-ui:message key="services" /></h3>

	<%
	Calendar cal = CalendarFactoryUtil.getCalendar();
	String[] days = CalendarUtil.getDays(locale);
	String[] paramPrefixes = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

	for (int i = 0; i < orgLabors.size(); i++) {
		OrgLabor orgLabor = orgLabors.get(i);

		int[] openArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			openArray[j] = BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Open", -1);
		}

		int[] closeArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			closeArray[j] = BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Close", -1);
		}
	%>

		<ul class="property-list">
			<li>
				<h4><%= LanguageUtil.get(pageContext,ListTypeServiceUtil.getListType(orgLabor.getTypeId()).getName()) %></h4>

				<table class="org-labor-table" border="1">
				<tr>
					<td class="no-color"></td>

					<%
					for (String day : days) {
					%>

						<th>
							<label><%= day %></label>
						</th>

					<%
					}
					%>

				</tr>
				<tr>
					<td>
						<strong><liferay-ui:message key="open" /></strong>
					</td>

					<%
					for (int j = 0; j < days.length; j++) {
						int curOpen = openArray[j];

					%>

						<td>
							<%= curOpen != -1 ? timeFormat.format(curOpen) : "" %>
						</td>

					<%
					}
					%>

				</tr>
				<tr>
					<td>
						<strong><liferay-ui:message key="close[status]" /></strong>
					</td>

					<%
					for (int j = 0; j < days.length; j++) {
						String curParam = paramPrefixes[j];
						int curClose = closeArray[j];
					%>

						<td>
							<%= curClose != -1 ? timeFormat.format(curClose) : "" %>
						</td>

					<%
					}
					%>

				</tr>
				</table>
			</li>
		</ul>
	<%
	}
	%>

</c:if>