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

<%@ include file="/html/taglib/ui/social_bookmarks/init.jsp" %>

<c:if test="<%= typesArray.length > 0 %>">

	<%
	String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_social_bookmarks_page") + StringPool.UNDERLINE;
	%>

	<div class="taglib-social-bookmarks" id="<%= randomNamespace %>socialBookmarks">
		<a class="show-bookmarks" href="javascript:;"><liferay-ui:message key="add-this-to" /><img alt="delicious" src="<%= themeDisplay.getPathThemeImages() %>/social_bookmarks/delicious.png" width="10" /> <img alt="digg" src="<%= themeDisplay.getPathThemeImages() %>/social_bookmarks/digg.png" width="10" /> <img alt="furl" src="<%= themeDisplay.getPathThemeImages() %>/social_bookmarks/furl.png" width="10" /></a>

		<ul class="lfr-component">

			<%
			for (int i = 0; i < typesArray.length; i++) {
			%>

				<li>
					<liferay-ui:social-bookmark type="<%= typesArray[i] %>" url="<%= url %>" title="<%= title %>" target="<%= target %>" />
				</li>

			<%
			}
			%>

		</ul>
	</div>

	<aui:script use="aui-base">
		var socialBookmarks = A.one('#<%= randomNamespace %>socialBookmarks');

		if (socialBookmarks) {
			var linkSocialBookmarks = socialBookmarks.all('.show-bookmarks');

			if (linkSocialBookmarks) {
				linkSocialBookmarks.on(
					'click',
					function(event) {
						socialBookmarks.toggleClass('visible');
					}
				);
			}
		}
	</aui:script>
</c:if>