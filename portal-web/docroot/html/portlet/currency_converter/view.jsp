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

<%@ include file="/html/portlet/currency_converter/init.jsp" %>

<%
String from = ParamUtil.getString(request, "from", com.liferay.portlet.currencyconverter.model.Currency.DEFAULT_FROM);
String to = ParamUtil.getString(request, "to", com.liferay.portlet.currencyconverter.model.Currency.DEFAULT_TO);

com.liferay.portlet.currencyconverter.model.Currency currency = CurrencyUtil.getCurrency(from + to);

double number = ParamUtil.getDouble(request, "number", 1.0);

String chartId = ParamUtil.getString(request, "chartId", "3m");

NumberFormat decimalFormat = NumberFormat.getNumberInstance(locale);

decimalFormat.setMaximumFractionDigits(2);
decimalFormat.setMinimumFractionDigits(2);
%>

<form action="<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/currency_converter/view" /></portlet:renderURL>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">

<input type="submit" value="<liferay-ui:message key="convert" />" />

<input name="<portlet:namespace />number" size="3" type="text" value="<%= number %>" />

<select name="<portlet:namespace />from">

	<%
	Iterator itr = allSymbols.entrySet().iterator();

	while (itr.hasNext()) {
		Map.Entry entry = (Map.Entry)itr.next();

		String symbol = (String)entry.getValue();
		String currencyValue = (String)entry.getKey();
	%>

		<option <%= symbol.equals(from) ? "selected" : "" %> value="<%= symbol %>"><%= currencyValue %></option value>

	<%
	}
	%>

</select>

<strong><liferay-ui:message key="to" /></strong>

<select name="<portlet:namespace />to">

	<%
	itr = allSymbols.entrySet().iterator();

	while (itr.hasNext()) {
		Map.Entry entry = (Map.Entry)itr.next();

		String symbol = (String)entry.getValue();
		String currencyValue = (String)entry.getKey();
	%>

		<option <%= symbol.equals(to) ? "selected" : "" %> value="<%= symbol %>"><%= currencyValue %></option value>

	<%
	}
	%>

</select>

<br /><br />

<c:choose>
	<c:when test="<%= windowState.equals(WindowState.NORMAL) %>">
		<table border="1" cellpadding="3" cellspacing="0" width="100%">
		<tr class="portlet-section-header results-header">
			<td>
				<strong><liferay-ui:message key="currency" /></strong>
			</td>

			<%
			for (int i = 0; i < symbols.length; i++) {
				String symbol = symbols[i];
			%>

				<td class="lfr-top">
					<liferay-ui:message key='<%= "currency." + symbol %>' /><br />
					(<%= symbol %>)
				</td>

			<%
			}
			%>

		</tr>

		<%
		for (int i = 0; i < symbols.length; i++) {
			String symbol = symbols[i];
		%>

			<tr>
				<td class="portlet-section-header results-header">
					<%= symbol %>
				</td>

		<%
				for (int j = 0; j < symbols.length; j++) {
					String symbol2 = symbols[j];

					currency = CurrencyUtil.getCurrency(symbol2 + symbol);

					if (currency != null) {
		%>

						<c:if test="<%= i != j %>">
							<td class="portlet-section-body results-row"><%= currency.getRate() %></td>
						</c:if>

						<c:if test="<%= i == j %>">
							<td class="portlet-section-body results-row">1</td>
						</c:if>

		<%
					}
				}
		%>

			</tr>

		<%
		}
		%>

		</table>
	</c:when>
	<c:otherwise>
		<table border="1" cellpadding="0" cellspacing="0" width="520">
		<tr>
			<td align="center" width="33%">
				<%= currency.getFromSymbol() %><br />
				<strong><%= number %></strong>
			</td>
			<td align="center" width="33%">
				<%= currency.getToSymbol() %><br />
				<strong><%= decimalFormat.format(number * currency.getRate()) %></strong>
			</td>
			<td align="center" width="34%">
				<liferay-ui:message key="historical-charts" /><br />

				<%
				PortletURL portletURL = renderResponse.createRenderURL();

				portletURL.setParameter("struts_action", "/currency_converter/view");
				portletURL.setParameter("number", String.valueOf(number));
				portletURL.setParameter("from", currency.getFromSymbol());
				portletURL.setParameter("to", currency.getToSymbol());
				%>

				<c:if test='<%= chartId.equals("3m") %>'>
					3<liferay-ui:message key="month-abbreviation" />, <a href="<% portletURL.setParameter("chartId", "1y"); %><%= portletURL.toString() %>">1<liferay-ui:message key="year-abbreviation" /></a>, <a href="<% portletURL.setParameter("chartId", "2y"); %><%= portletURL.toString() %>">2<liferay-ui:message key="year-abbreviation" /></a>
				</c:if>

				<c:if test='<%= chartId.equals("1y") %>'>
					<a href="<% portletURL.setParameter("chartId", "3m"); %><%= portletURL.toString() %>">3<liferay-ui:message key="month-abbreviation" /></a>, 1<liferay-ui:message key="year-abbreviation" />, <a href="<% portletURL.setParameter("chartId", "2y"); %><%= portletURL.toString() %>">2<liferay-ui:message key="year-abbreviation" /></a>
				</c:if>

				<c:if test='<%= chartId.equals("2y") %>'>
					<a href="<% portletURL.setParameter("chartId", "3m"); %><%= portletURL.toString() %>">3<liferay-ui:message key="month-abbreviation" /></a>, <a href="<% portletURL.setParameter("chartId", "1y"); %><%= portletURL.toString() %>">1<liferay-ui:message key="year-abbreviation" /></a>, 2<liferay-ui:message key="year-abbreviation" />
				</c:if>
			</td>
		</tr>
		</table>

		<br />

		<table border="1" cellpadding="2" cellspacing="0">
		<tr>
			<td>
				<img height="288" src="http://ichart.yahoo.com/z?s=<%= currency.getSymbol() %>=X&t=<%= chartId %>?" width="512" />
			</td>
		</tr>
		</table>
	</c:otherwise>
</c:choose>

</form>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />number);
	</aui:script>
</c:if>