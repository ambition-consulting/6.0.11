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

<%@ include file="/html/taglib/ui/icon/init.jsp" %>

<%
String cssClassHtml = StringPool.BLANK;

if (Validator.isNotNull(cssClass)) {
	cssClassHtml = "class=\"".concat(cssClass).concat("\"");
}

if (themeDisplay.isThemeImagesFastLoad() && !auiImage) {
	SpriteImage spriteImage = null;
	String spriteFileName = null;

	String imageFileName = StringUtil.replace(src, "common/../", "");

	String imagesPath = theme.getContextPath().concat(theme.getImagesPath());

	if (imageFileName.startsWith(imagesPath)) {
		imageFileName = imageFileName.substring(imagesPath.length());

		spriteImage = theme.getSpriteImage(imageFileName);

		if (spriteImage != null) {
			spriteFileName = spriteImage.getSpriteFileName();

			if (BrowserSnifferUtil.isIe(request) && (BrowserSnifferUtil.getMajorVersion(request) < 7)) {
				spriteFileName = StringUtil.replace(spriteFileName, ".png", ".gif");
			}

			spriteFileName = themeDisplay.getPathThemeImages().concat(spriteFileName);
		}
	}

	if (spriteImage == null) {
		Portlet portlet = (Portlet)request.getAttribute("liferay-portlet:icon_portlet:portlet");

		if (portlet == null) {
			portlet = (Portlet)request.getAttribute(WebKeys.RENDER_PORTLET);
		}

		if (portlet != null) {
			PortletApp portletApp = portlet.getPortletApp();

			imageFileName = src;

			if ((portletApp.isWARFile() || !portlet.getContextPath().equals(StringPool.SLASH)) &&
				imageFileName.startsWith(portlet.getContextPath())) {

				imageFileName = imageFileName.substring(portlet.getContextPath().length());
			}

			spriteImage = portletApp.getSpriteImage(imageFileName);

			if (spriteImage != null) {
				spriteFileName = spriteImage.getSpriteFileName();

				if (BrowserSnifferUtil.isIe(request) && (BrowserSnifferUtil.getMajorVersion(request) < 7)) {
					spriteFileName = StringUtil.replace(spriteFileName, ".png", ".gif");
				}

				spriteFileName = portlet.getStaticResourcePath().concat(spriteFileName);
			}
		}
	}

	if (spriteImage != null) {
		src = themeDisplay.getPathThemeImages().concat("/spacer.png");

		StringBundler sb = new StringBundler(10);

		sb.append(details);
		sb.append(" style=\"background-image: url('");
		sb.append(spriteFileName);
		sb.append("'); background-position: 50% -");
		sb.append(spriteImage.getOffset());
		sb.append("px; background-repeat: no-repeat; height: ");
		sb.append(spriteImage.getHeight());
		sb.append("px; width: ");
		sb.append(spriteImage.getWidth());
		sb.append("px;\"");

		details = sb.toString();
	}
}

String imgClass = "icon";

if (auiImage) {
	StringBundler sb = new StringBundler(4);

	sb.append(details);
	sb.append(" style=\"background-image: url('");
	sb.append(themeDisplay.getPathThemeImages());
	sb.append("/aui/icon_sprite.png'); height: 16px; width: 16px;\"");

	details = sb.toString();

	imgClass = imgClass.concat(" aui-icon-").concat(image.substring(_AUI_PATH.length()));
}

boolean urlIsNotNull = Validator.isNotNull(url);
%>

<liferay-util:buffer var="linkContent">
	<img class="<%= imgClass %>" src="<%= src %>" <%= details %> />

	<c:choose>
		<c:when test="<%= (iconMenuIconCount != null) && ((iconMenuSingleIcon == null) || iconMenuShowWhenSingleIcon) %>">
			<liferay-ui:message key="<%= message %>" />
		</c:when>
		<c:when test="<%= (iconListIconCount != null) && ((iconListSingleIcon == null) || iconListShowWhenSingleIcon) %>">
			<span class="taglib-text"><liferay-ui:message key="<%= message %>" /></span>
		</c:when>
		<c:otherwise>
			<c:if test="<%= label %>">
				<span class="taglib-text"><liferay-ui:message key="<%= message %>" /></span>
			</c:if>
		</c:otherwise>
	</c:choose>
</liferay-util:buffer>

<c:choose>
	<c:when test="<%= (iconListIconCount != null) && ((iconListSingleIcon == null) || iconListShowWhenSingleIcon) %>">
		<li <%= cssClassHtml %>>
			<c:choose>
				<c:when test="<%= urlIsNotNull %>">
					<aui:a cssClass="taglib-icon" href="<%= url %>" id="<%= id %>" lang="<%= lang %>" target="<%= target %>">
						<%= linkContent %>
					</aui:a>
				</c:when>
				<c:otherwise>
						<%= linkContent %>
				</c:otherwise>
			</c:choose>
		</li>
	</c:when>
	<c:when test="<%= (iconMenuIconCount != null) && ((iconMenuSingleIcon == null) || iconMenuShowWhenSingleIcon) %>">
		<li <%= cssClassHtml %>>
			<c:choose>
				<c:when test="<%= urlIsNotNull %>">
					<aui:a href="<%= url %>" id="<%= id %>" lang="<%= lang %>" target="<%= target %>">
						<%= linkContent %>
					</aui:a>
				</c:when>
				<c:otherwise>
						<%= linkContent %>
				</c:otherwise>
			</c:choose>
		</li>
	</c:when>
	<c:otherwise>
		<span <%= cssClassHtml %> >
			<c:choose>
				<c:when test="<%= urlIsNotNull %>">
					<aui:a cssClass="taglib-icon" href="<%= url %>" id="<%= id %>" lang="<%= lang %>" target="<%= target %>">
						<%= linkContent %>
					</aui:a>
				</c:when>
				<c:otherwise>
						<%= linkContent %>
				</c:otherwise>
			</c:choose>
		</span>
	</c:otherwise>
</c:choose>

<%
boolean forcePost = method.equals("post") && (url.startsWith(Http.HTTP_WITH_SLASH) || url.startsWith(Http.HTTPS_WITH_SLASH));
%>

<c:if test="<%= Validator.isNotNull(srcHover) || forcePost %>">
	<aui:script use="liferay-icon">
		Liferay.Icon.register(
			{
				forcePost: <%= forcePost %>,
				id: '<portlet:namespace /><%= id %>'

				<c:if test="<%= Validator.isNotNull(srcHover) %>">
					, src: '<%= src %>',
					srcHover: '<%= srcHover %>'
				</c:if>
			}
		);
	</aui:script>
</c:if>