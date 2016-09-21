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

.portlet-rss .feed-date {
	background: url(<%= themeImagesPath %>/common/time.png) no-repeat 0 50%;
	margin: 0.3em 0;
	padding-left: 20px;
}

.portlet-rss .feed-description {
 	margin: 0 0 5px 0;
}

.portlet-rss .feed-entries {
	font-size: 1.1em;
}

.portlet-rss .feed-entry {
	margin-bottom: 4px;
}

.portlet-rss .feed-entry-author {
	display: block;
	font-size: 0.9em;
}

.portlet-rss .feed-entry-content {
	padding-left: 1.8em;
}

.portlet-rss .feed-entry-content img {
	margin-right: 0.5em;
}

.portlet-rss .feed-entry-expander {
	cursor: pointer;
	float: left;
	padding-right: 5px;
}

.portlet-rss .feed-entry-title {
	display: block;
	font-weight: bold;
}

.portlet-rss .feed-image-left {
 	margin: 4px 0 4px 20px;
 	text-align: left;
}

.portlet-rss .feed-image-right {
	float: right;
 	margin: 0 0 4px 4px;
}

.portlet-rss .feed-published-date.feed-date {
	background-image: url(<%= themeImagesPath %>/common/date.png)
}

.portlet-rss .feed-published-date a {
	font-weight: bold;
	text-decoration: none;
}

.portlet-rss .feed-title {
	font-size: 1.2em;
	font-weight: bold;
	margin: 0 0 0.5em -20px;
}

.portlet-rss .feed-title a {
	background: url(<%= themeImagesPath %>/common/news.png) no-repeat 0 50%;
	padding-left: 20px;
}

.portlet-rss .feed {
	padding-left: 20px;
}

.portlet-rss .feed .separator {
	margin-left: -20px;
}

.portlet-rss .header {
	cursor: default;
	font-weight: bold;
	margin-top: 2px;
	padding: 2px 5px;
}