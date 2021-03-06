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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String langType = ParamUtil.getString(request, "langType");

String editorType = ParamUtil.getString(request, "editorType");

if (Validator.isNotNull(editorType)) {
	portalPreferences.setValue(PortletKeys.JOURNAL, "editor-type", editorType);
}
else {
	editorType = portalPreferences.getValue(PortletKeys.JOURNAL, "editor-type", "html");
}

boolean useEditorCodepress = editorType.equals("codepress");

String defaultContent = ContentUtil.get(PropsUtil.get(PropsKeys.JOURNAL_TEMPLATE_LANGUAGE_CONTENT, new Filter(langType)));
%>

<aui:form method="post" name="editorForm">
	<aui:fieldset>
		<aui:select name="editorType" onChange='<%= renderResponse.getNamespace() + "updateEditorType();" %>'>
			<aui:option label="plain" value="1" />
			<aui:option label="rich" selected="<%= useEditorCodepress %>" value="0" />
		</aui:select>

		<c:choose>
			<c:when test="<%= useEditorCodepress %>">
				 <aui:input inputCssClass="codepress html" label="" name="xslContent" type="textarea" wrap="off" />
			</c:when>
			<c:otherwise>
				<aui:input inputCssClass="lfr-textarea" label="" name="xslContent" onKeyDown="Liferay.Util.checkTab(this); Liferay.Util.disableEsc();" type="textarea" wrap="off" />
			</c:otherwise>
		</c:choose>
	</aui:fieldset>

	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "updateTemplateXsl();" %>' value="update" />

		<c:if test="<%= !useEditorCodepress %>">
			<aui:button onClick='<%= "Liferay.Util.selectAndCopy(document." + renderResponse.getNamespace() + "editorForm." + renderResponse.getNamespace() + "xslContent);" %>' value="select-and-copy" />
		</c:if>

		<aui:button onClick="AUI().DialogManager.closeByChild(this);" value="cancel" />
	</aui:button-row>
</aui:form>

<c:if test="<%= useEditorCodepress %>">
	<script src="<%= themeDisplay.getPathContext() %>/html/js/editor/codepress/codepress.js" type="text/javascript"></script>
</c:if>

<aui:script>
	function <portlet:namespace />getEditorContent() {
		var xslContent = AUI().one('input[name=<portlet:namespace />xslContent]');

		if (xslContent) {
			var content = decodeURIComponent(xslContent.val());
		}

		if (!content) {
			content = "<%= UnicodeFormatter.toString(defaultContent) %>";
		}

		return content;
	}

	Liferay.provide(
		window,
		'<portlet:namespace />updateEditorType',
		function() {
			var A = AUI();

			<%
			String newEditorType = "codepress";

			if (useEditorCodepress) {
				newEditorType = "html";
			}
			%>

			var editorForm = A.one(document.<portlet:namespace />editorForm);

			if (editorForm) {
				var popup = editorForm.ancestor('.aui-widget-bd');

				if (popup) {
					popup = popup.getDOM();
				}
			}

			Liferay.Util.switchEditor(
				{
					popup: popup,
					textarea: '<portlet:namespace />xslContent',
					url: '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="struts_action" value="/journal/edit_template_xsl" /><portlet:param name="langType" value="<%= langType %>" /><portlet:param name="editorType" value="<%= newEditorType %>" /></portlet:renderURL>'
				}
			);
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateTemplateXsl',
		function() {
			var A = AUI();

			var xslContent = A.one('input[name=<portlet:namespace />xslContent]');
			var content = '';

			<c:choose>
				<c:when test="<%= useEditorCodepress %>">
					content = <portlet:namespace />xslContent.getCode();
				</c:when>
				<c:otherwise>
					content = document.<portlet:namespace />editorForm.<portlet:namespace />xslContent.value;
				</c:otherwise>
			</c:choose>

			xslContent.attr('value', encodeURIComponent(content));

			A.DialogManager.closeByChild(document.<portlet:namespace />editorForm);
		},
		['aui-dialog']
	);

	if (<%= useEditorCodepress %>) {
		document.<portlet:namespace />editorForm.<portlet:namespace />xslContent_cp.value = <portlet:namespace />getEditorContent();
	}
	else {
		document.<portlet:namespace />editorForm.<portlet:namespace />xslContent.value = <portlet:namespace />getEditorContent();
	}

	Liferay.Util.resizeTextarea('<portlet:namespace />xslContent', <%= useEditorCodepress %>, true);
</aui:script>