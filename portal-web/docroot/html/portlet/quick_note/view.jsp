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

<%@ include file="/html/portlet/quick_note/init.jsp" %>

<div id="<portlet:namespace />pad" style="background: <%= color %>;">
	<c:if test="<%= portletDisplay.isShowConfigurationIcon() %>">
		<div class="portlet-title-default">
			<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td>
					<span class="note-color yellow"></span>
					<span class="note-color green"></span>
					<span class="note-color blue"></span>
					<span class="note-color red"></span>
				</td>

				<c:if test="<%= portletDisplay.isShowCloseIcon() %>">
					<td>
						<a border="0" class="close-note" href="<%= portletDisplay.getURLClose() %>"><img alt="<liferay-ui:message key="close" />" src="<%= themeDisplay.getPathThemeImages() %>/portlet/close.png" /></a>
					</td>
				</c:if>
			</tr>
			</table>
		</div>
	</c:if>

	<div id="<portlet:namespace />note"><%= StringUtil.replace(HtmlUtil.escape(data), "&lt;br /&gt;", "<br />") %></div>
</div>

<c:if test="<%= portletDisplay.isShowConfigurationIcon() %>">
	<aui:script use="aui-editable,aui-io-request">
		var quickNotePad = A.one('#<portlet:namespace />pad');

		if (quickNotePad) {
			quickNotePad.all('.note-color').on(
				'click',
				function(event) {
					var box = event.currentTarget;

					var bgColor = box.getStyle('backgroundColor');

					quickNotePad.setStyle('backgroundColor', bgColor);

					A.io.request(
						'<%= themeDisplay.getPathMain() %>/quick_note/save',
						{
							data: {
								color: bgColor,
								p_l_id: '<%= plid %>',
								portletId: '<%= portletDisplay.getId() %>'
							}
						}
					);
				}
			);
		}

		new A.Editable(
			{
				inputType: 'textarea',
				node: '#<portlet:namespace />note',
				on: {
					contentTextChange: function(event) {
						var instance = this;

						if (!event.initial) {
							var newValue = event.newVal.replace(/\n/gi, '<br />');

							event.newVal = instance._toText(event.newVal);

							A.io.request(
								'<%= themeDisplay.getPathMain() %>/quick_note/save',
								{
									data: {
										data: newValue,
										p_l_id: '<%= plid %>',
										portletId: '<%= portletDisplay.getId() %>'
									}
								}
							);
						}
					}
				}
			}
		);
	</aui:script>
</c:if>