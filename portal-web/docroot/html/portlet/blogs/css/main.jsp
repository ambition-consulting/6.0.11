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

.portlet-blogs .comments {
}

.portlet-blogs .taglib-custom-attributes-list {
	margin-bottom: 1em;
}

.portlet-blogs .taglib-custom-attributes-list label {
	display: block;
	font-weight: bold;
}

.portlet-blogs .edit-actions {
	margin: 1.5em 0;
}

.portlet-blogs .entry-author {
	background: url(<%= themeImagesPath %>/portlet/edit_guest.png) no-repeat 0 50%;
	border-right: 1px solid #999;
	color: #999;
	float: left;
	font-weight: bold;
	margin-right: 10px;
	padding-left: 25px;
	padding-right: 10px;
}

.portlet-blogs .entry-body {
	margin-bottom: 10px;
}

.portlet-blogs .entry-date {
	background: url(<%= themeImagesPath %>/common/date.png) no-repeat 0 50%;
	color: #999;
	padding-left: 25px;
}

.portlet-blogs .taglib-asset-categories-summary, .portlet-blogs .taglib-asset-tags-summary {
	border-left: 1px solid #999;
	padding-left: 10px;
}

.portlet-blogs .entry-title {
	display: block;
	font-size: 1.5em;
	font-weight: bold;
	margin-bottom: 0.5em;
}

.portlet-blogs .entry.draft {
	background: #eee;
	border: 1px solid #ccc;
	color: #555;
	padding: 5px;
}

.portlet-blogs .entry.draft h3 {
	background: url(<%= themeImagesPath %>/common/page.png) no-repeat 0 50%;
	margin-top: 0;
	padding-left: 20px;
}

.portlet-blogs .entry-navigation {
	background: #eee;
	border-top: 1px solid #ccc;
	margin: 15px 0 0;
	overflow: hidden;
	padding: 5px;
}

.portlet-blogs .entry-navigation a, .portlet-blogs .entry-navigation span {
	background: url() no-repeat;
}

.portlet-blogs .entry-navigation .previous {
	background-image: url(<%= themeImagesPath %>/arrows/paging_previous.png);
	float: left;
	padding-left: 15px;
}

.portlet-blogs .entry-navigation span.previous {
	background-position: 0 100%;
}

.portlet-blogs .entry-navigation .next {
	background-image: url(<%= themeImagesPath %>/arrows/paging_next.png);
	background-position: 100% 0;
	float: right;
	padding-right: 15px;
}

.portlet-blogs .entry-navigation span.next {
	background-position: 100% 100%;
}

.portlet-blogs .search-form {
	float: right
}

.portlet-blogs .stats {
	color: #999;
	float: left;
	padding-right: 10px;
}

.portlet-blogs .subscribe {
	margin-bottom: 1.5em;
}

.portlet-blogs .taglib-flags {
	border-left: 1px solid #999;
	color: #999;
	padding-left: 10px;
	padding-right: 10px;
}

.portlet-blogs .taglib-ratings.stars {
	margin-top: 0.5em;
}

.portlet-blogs .taglib-social-bookmarks {
	clear: both;
	margin-top: 1.5em;
}

.portlet-blogs .taglib-social-bookmarks ul {
	padding: 1em;
}

.portlet-blogs #blogsCommentsPanelContainer {
	border-width: 0;
}