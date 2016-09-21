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

.portlet-configuration .archived-setups {
	margin-bottom: 1em;
	margin-right: 0.5em;
	text-align: right;
}

.portlet-configuration .edit-permissions form:after {
	clear: both;
	content: ".";
	display: block;
	height: 0;
	visibility: hidden;
}

.ie .portlet-configuration .edit-permissions form {
	height: 1%;
}

.portlet-configuration .edit-permissions .assign-permissions {
	float: left;
}

.portlet-configuration .edit-permissions .assign-permissions .aui-button-holder {
	position: relative;
}

.portlet-configuration .edit-permissions .assign-permissions .aui-button-holder .finished {
	position: absolute;
	right: 0;
}