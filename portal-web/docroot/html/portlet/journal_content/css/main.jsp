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

<%@ include file="/html/portlet/css_init.jsp" %>

.portlet-journal-content .icon-actions {
	float: left;
	margin: 1px 10px 1px 1px;
}

.portlet-journal-content .icons-container {
	clear: both;
	height: auto;
	margin-top: 1em;
	overflow: hidden;
	width: auto;
}

.ie6 .portlet-journal-content .icons-container {
	height: 1%;
}

.portlet-journal-content .journal-content-article {
	clear: right;
}

.portlet-journal-content .journal-content-article:after {
	clear: both;
	content: "";
	display: block;
	height: 0;
}

.ie .portlet-journal-content .journal-content-article {
	zoom: 1;
}

.portlet-journal-content .taglib-discussion {
	margin-top: 18px;
}

.portlet-journal-content .taglib-ratings-wrapper {
	margin-top: 1em;
}

.portlet-journal-content .aui-tabview-list {
	margin: 18px 0;
}

.portlet-journal-content .user-actions {
	padding-bottom: 2.5em;
}

.portlet-journal-content .user-actions .export-actions, .portlet-journal-content .user-actions .print-action, .portlet-journal-content .user-actions .locale-actions {
	float: right;
}

.portlet-journal-content .user-actions .print-action {
	margin-left: 1em;
}

.portlet-journal-content .user-actions .locale-separator {
	border-right: 1px solid #CCC;
	float: right;
	margin-right: 1em;
	padding: 0.8em 0.5em;
}

.portlet-configuration .displaying-article-id.modified {
	color: #4DCF0C;
}