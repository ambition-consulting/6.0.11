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
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute(WebKeys.ASSET_RENDERER);
int abstractLength = (Integer)request.getAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH);

IGImage image = (IGImage)request.getAttribute(WebKeys.IMAGE_GALLERY_IMAGE);

Image smallImage = ImageLocalServiceUtil.getImage(image.getSmallImageId());
%>

<c:if test="<%= smallImage != null %>">
	<aui:a href="<%= assetRenderer.getURLViewInContext((LiferayPortletRequest)renderRequest, (LiferayPortletResponse)renderResponse, StringPool.BLANK) %>">
		<img alt="<liferay-ui:message key="<%= assetRenderer.getViewInContextMessage() %>" />" class="asset-small-image" src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= smallImage.getImageId() %>" style="text-align: left;" />
	</aui:a>
</c:if>

<p class="asset-description">
	<%= HtmlUtil.escape(StringUtil.shorten(image.getDescription(), abstractLength)) %>
</p>