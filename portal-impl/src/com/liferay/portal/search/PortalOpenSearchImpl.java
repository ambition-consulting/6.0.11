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

package com.liferay.portal.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseOpenSearchImpl;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Charles May
 * @author Brian Wing Shun Chan
 */
public class PortalOpenSearchImpl extends BaseOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/search/open_search";

	public String search(
			HttpServletRequest request, long groupId, long userId,
			String keywords, int startPage, int itemsPerPage, String format)
		throws SearchException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			int start = (startPage * itemsPerPage) - itemsPerPage;
			int end = startPage * itemsPerPage;

			Hits results = CompanyLocalServiceUtil.search(
				themeDisplay.getCompanyId(), userId, keywords, start, end);

			String[] queryTerms = results.getQueryTerms();

			int total = results.getLength();

			Object[] values = addSearchResults(
				queryTerms, keywords, startPage, itemsPerPage, total, start,
				"Liferay Portal Search: " + keywords, SEARCH_PATH, format,
				themeDisplay);

			com.liferay.portal.kernel.xml.Document doc =
				(com.liferay.portal.kernel.xml.Document)values[0];
			Element root = (Element)values[1];

			for (int i = 0; i < results.getDocs().length; i++) {
				Document result = results.doc(i);

				String portletId = result.get(Field.PORTLET_ID);

				Portlet portlet = PortletLocalServiceUtil.getPortletById(
					themeDisplay.getCompanyId(), portletId);

				if (portlet == null) {
					continue;
				}

				String portletTitle = PortalUtil.getPortletTitle(
					portletId, themeDisplay.getUser());

				long resultGroupId = GetterUtil.getLong(
					result.get(Field.GROUP_ID));

				long resultScopeGroupId = GetterUtil.getLong(
					result.get(Field.SCOPE_GROUP_ID));

				String entryClassName = GetterUtil.getString(
					result.get(Field.ENTRY_CLASS_NAME));

				long entryClassPK = GetterUtil.getLong(
					result.get(Field.ENTRY_CLASS_PK));

				String title = StringPool.BLANK;

				PortletURL portletURL = getPortletURL(
					request, portletId, resultGroupId);

				String url = portletURL.toString();

				Date modifedDate = result.getDate(Field.MODIFIED);

				String content = StringPool.BLANK;

				if (Validator.isNotNull(portlet.getIndexerClass())) {
					Indexer indexer = (Indexer)InstancePool.get(
						portlet.getIndexerClass());

					String snippet = results.snippet(i);

					Summary summary = indexer.getSummary(
						result, snippet, portletURL);

					title = summary.getTitle();
					url = portletURL.toString();
					content = summary.getContent();

					if (portlet.getPortletId().equals(PortletKeys.JOURNAL)) {
						url = getJournalURL(
							themeDisplay, resultGroupId, result);
					}
				}

				double score = results.score(i);

				addSearchResult(
					root, resultGroupId, resultScopeGroupId, entryClassName,
					entryClassPK,
					portletTitle + " " + CharPool.RAQUO + " " + title, url,
					modifedDate, content, score, format);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Return\n" + doc.asXML());
			}

			return doc.asXML();

		}
		catch (Exception e) {
			throw new SearchException(e);
		}
	}

	protected String getJournalURL(
			ThemeDisplay themeDisplay, long groupId, Document result)
		throws Exception {

		Layout layout = themeDisplay.getLayout();

		String articleId = result.get(Field.ENTRY_CLASS_PK);
		String version = result.get("version");

		List<Long> hitLayoutIds =
			JournalContentSearchLocalServiceUtil.getLayoutIds(
				layout.getGroupId(), layout.isPrivateLayout(), articleId);

		if (hitLayoutIds.size() > 0) {
			Long hitLayoutId = hitLayoutIds.get(0);

			Layout hitLayout = LayoutLocalServiceUtil.getLayout(
				layout.getGroupId(), layout.isPrivateLayout(),
				hitLayoutId.longValue());

			return PortalUtil.getLayoutURL(hitLayout, themeDisplay);
		}
		else {
			StringBundler sb = new StringBundler(7);

			sb.append(themeDisplay.getPathMain());
			sb.append("/journal/view_article_content?groupId=");
			sb.append(groupId);
			sb.append("&articleId=");
			sb.append(articleId);
			sb.append("&version=");
			sb.append(version);

			return sb.toString();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PortalOpenSearchImpl.class);

}