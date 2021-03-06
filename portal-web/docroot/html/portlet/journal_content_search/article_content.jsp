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

<%@ include file="/html/portlet/journal_content_search/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

String[] queryTerms = (String[])objArray[0];
Document doc = (Document)objArray[1];
String snippet = (String)objArray[2];

String content = snippet;

if (Validator.isNull(snippet)) {
	content = StringUtil.shorten(doc.get(Field.CONTENT), 200);
}

content = StringUtil.highlight(content, queryTerms);

String articleId = doc.get(Field.ENTRY_CLASS_PK);
long articleGroupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));

List hitLayoutIds = JournalContentSearchLocalServiceUtil.getLayoutIds(layout.getGroupId(), layout.isPrivateLayout(), articleId);
%>

<%= content %><br />

<c:choose>
	<c:when test="<%= !hitLayoutIds.isEmpty() %>">
		<span style="font-size: xx-small;">

		<%
		for (int i = 0; i < hitLayoutIds.size(); i++) {
			Long hitLayoutId = (Long)hitLayoutIds.get(i);

			Layout hitLayout = null;

			try {
				hitLayout = LayoutLocalServiceUtil.getLayout(layout.getGroupId(), layout.isPrivateLayout(), hitLayoutId.longValue());
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn("Journal content search is stale and contains layout {" + layout.getGroupId() + ", " + layout.isPrivateLayout() + ", " + hitLayoutId.longValue() + "}");
				}

				continue;
			}

			String hitLayoutURL = PortalUtil.getLayoutFullURL(hitLayout, themeDisplay);
		%>

			<br /><a href="<%= hitLayoutURL %>"><%= StringUtil.shorten(hitLayoutURL, 100) %></a>

		<%
		}
		%>

		</span>
	</c:when>
	<c:otherwise>
		<span style="font-size: xx-small;">

		<%
		if (Validator.isNull(targetPortletId)) {
			targetPortletId = PortletKeys.JOURNAL_CONTENT;
		}

		PortletURL webContentPortletURL = PortletURLFactoryUtil.create(request, targetPortletId, plid, PortletRequest.RENDER_PHASE);

		webContentPortletURL.setParameter("struts_action", "/journal_content/view");
		webContentPortletURL.setParameter("groupId", String.valueOf(articleGroupId));
		webContentPortletURL.setParameter("articleId", articleId);
		%>

		<br /><a href="<%= webContentPortletURL.toString() %>"><%= StringUtil.shorten(webContentPortletURL.toString(), 100) %></a>

		</span>
	</c:otherwise>
</c:choose>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.journal_content_search.article_content.jsp");
%>