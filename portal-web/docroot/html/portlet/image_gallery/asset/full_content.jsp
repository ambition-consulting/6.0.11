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

<%@ include file="/html/portlet/image_gallery/init.jsp" %>

<%
IGImage image = (IGImage)request.getAttribute(WebKeys.IMAGE_GALLERY_IMAGE);
%>

<img src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= image.getLargeImageId() %>&amp;t=<%= ImageServletTokenUtil.getToken(image.getLargeImageId()) %>" />

<p class="asset-description"><%= HtmlUtil.escape(image.getDescription()) %></p>

<liferay-ui:custom-attributes-available className="<%= IGImage.class.getName() %>">
	<liferay-ui:custom-attribute-list
		className="<%= IGImage.class.getName() %>"
		classPK="<%= (image != null) ? image.getImageId() : 0 %>"
		editable="<%= false %>"
		label="<%= true %>"
	/>
</liferay-ui:custom-attributes-available>