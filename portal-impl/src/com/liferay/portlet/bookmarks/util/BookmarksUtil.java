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

package com.liferay.portlet.bookmarks.util;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.model.BookmarksFolderConstants;
import com.liferay.portlet.bookmarks.service.BookmarksFolderLocalServiceUtil;
import com.liferay.portlet.bookmarks.util.comparator.EntryCreateDateComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryModifiedDateComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryNameComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryPriorityComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryURLComparator;
import com.liferay.portlet.bookmarks.util.comparator.EntryVisitsComparator;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class BookmarksUtil {

	public static void addPortletBreadcrumbEntries(
			BookmarksEntry entry, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		BookmarksFolder folder = entry.getFolder();

		if (folder.getFolderId() !=
				BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

			addPortletBreadcrumbEntries(folder, request, renderResponse);
		}

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("struts_action", "/bookmarks/view_entry");
		portletURL.setParameter("entryId", String.valueOf(entry.getEntryId()));

		PortalUtil.addPortletBreadcrumbEntry(
			request, entry.getName(), portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
			long folderId, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		if (folderId == BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return;
		}

		BookmarksFolder folder = BookmarksFolderLocalServiceUtil.getFolder(
			folderId);

		addPortletBreadcrumbEntries(folder, request, renderResponse);
	}

	public static void addPortletBreadcrumbEntries(
			BookmarksFolder folder, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		String strutsAction = ParamUtil.getString(
			request, "struts_action");

		boolean selectFolder = strutsAction.equals("/bookmarks/select_folder");

		PortletURL portletURL = renderResponse.createRenderURL();

		if (selectFolder) {
			ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			portletURL.setWindowState(LiferayWindowState.POP_UP);

			portletURL.setParameter(
				"struts_action", "/bookmarks/select_folder");

			PortalUtil.addPortletBreadcrumbEntry(
				request, themeDisplay.translate("bookmarks-home"),
				portletURL.toString());
		}
		else {
			portletURL.setParameter("struts_action", "/bookmarks/view");
		}

		List<BookmarksFolder> ancestorFolders = folder.getAncestors();

		Collections.reverse(ancestorFolders);

		for (BookmarksFolder ancestorFolder : ancestorFolders) {
			portletURL.setParameter(
				"folderId", String.valueOf(ancestorFolder.getFolderId()));

			PortalUtil.addPortletBreadcrumbEntry(
				request, ancestorFolder.getName(), portletURL.toString());
		}

		portletURL.setParameter(
			"folderId", String.valueOf(folder.getFolderId()));

		if (folder.getFolderId() !=
				BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

			PortalUtil.addPortletBreadcrumbEntry(
				request, folder.getName(), portletURL.toString());
		}
	}

	public static OrderByComparator getEntriesOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("create-date")) {
			orderByComparator = new EntryCreateDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("modified-date")) {
			orderByComparator = new EntryModifiedDateComparator(orderByAsc);
		}
		else if (orderByCol.equals("name")) {
			orderByComparator = new EntryNameComparator(orderByAsc);
		}
		else if (orderByCol.equals("priority")) {
			orderByComparator = new EntryPriorityComparator(orderByAsc);
		}
		else if (orderByCol.equals("url")) {
			orderByComparator = new EntryURLComparator(orderByAsc);
		}
		else if (orderByCol.equals("visits")) {
			orderByComparator = new EntryVisitsComparator(orderByAsc);
		}

		return orderByComparator;
	}

}