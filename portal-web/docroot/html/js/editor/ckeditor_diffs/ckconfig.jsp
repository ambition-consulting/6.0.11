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

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String cssPath = ParamUtil.getString(request, "cssPath");
%>

CKEDITOR.addStylesSet(
	'liferayStyles',
	[

	// Block Styles

	{name: 'Normal', element : 'p'},
	{name: 'Heading 1', element : 'h1'},
	{name: 'Heading 2', element : 'h2'},
	{name: 'Heading 3', element : 'h3'},
	{name: 'Heading 4', element : 'h4'},

	//Special classes

	{name: 'Preformatted Text', element:'pre'},
	{name: 'Cited Work', element:'cite'},
	{name: 'Computer Code', element:'code'},

	//Custom styles

	{name : 'Info Message', element : 'div', attributes : {'class' : 'portlet-msg-info'}},
	{name : 'Alert Message', element : 'div', attributes : {'class' : 'portlet-msg-alert'}},
	{name : 'Error Message', element : 'div', attributes : {'class' : 'portlet-msg-error'}}
	]
);

CKEDITOR.config.contentsCss = '<%= HtmlUtil.escape(cssPath) %>/main.css';

CKEDITOR.config.entities = false;

CKEDITOR.config.resize_enabled = false;

CKEDITOR.config.height = 265;

CKEDITOR.config.stylesCombo_stylesSet = 'liferayStyles';

CKEDITOR.config.toolbar_liferay = [
	['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'StrikeThrough'],
	['Subscript', 'Superscript'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Find', 'Replace', 'SpellChecker', 'Scayt'],
	['OrderedList', 'UnorderedList', '-', 'Outdent', 'Indent'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	'/',
	['Source'],
	['Link', 'Unlink', 'Anchor'],
	['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar']
];

CKEDITOR.config.toolbar_liferayArticle = [
	['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	['Bold', 'Italic', 'Underline', 'StrikeThrough'],
	['Subscript', 'Superscript'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Find', 'Replace', 'SpellChecker', 'Scayt'],
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	'/',
	['Source'],
	['Link', 'Unlink', 'Anchor'],
	['Image', 'Flash', 'Table', '-', 'Smiley', 'SpecialChar', 'LiferayPageBreak']
];

CKEDITOR.config.toolbar_editInPlace = [
	['Styles'],
	['Bold', 'Italic', 'Underline', 'StrikeThrough'],
	['Subscript', 'Superscript', 'SpecialChar'],
	['Undo', 'Redo'],
	['SpellChecker', 'Scayt'],
	['OrderedList', 'UnorderedList', '-', 'Outdent', 'Indent'], ['Source', 'RemoveFormat'],
];

CKEDITOR.config.toolbar_email = [
	['FontSize', 'TextColor', 'BGColor', '-', 'Bold', 'Italic', 'Underline', 'StrikeThrough'],
	['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	['SpellChecker', 'Scayt'],
	'/',
	['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	['Source'],
	['Link', 'Unlink'],
	['Image']
];