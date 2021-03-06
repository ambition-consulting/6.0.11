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

package com.liferay.portlet.documentlibrary.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class DLUtil {

	public static void addPortletBreadcrumbEntries(
			DLFileEntry fileEntry, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		DLFolder folder = fileEntry.getFolder();

		if (folder.getFolderId() !=
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

			addPortletBreadcrumbEntries(folder, request, renderResponse);
		}

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter(
			"struts_action", "/document_library/view_file_entry");
		portletURL.setParameter(
			"folderId", String.valueOf(fileEntry.getFolderId()));
		portletURL.setParameter("name", fileEntry.getName());

		PortalUtil.addPortletBreadcrumbEntry(
			request, fileEntry.getTitle(), portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
			DLFileShortcut fileShortcut, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		DLFolder folder = fileShortcut.getFolder();

		if (folder.getFolderId() !=
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

			addPortletBreadcrumbEntries(folder, request, renderResponse);
		}

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter(
			"struts_action", "/document_library/view_file_shortcut");
		portletURL.setParameter(
			"fileShortcutId", String.valueOf(fileShortcut.getFileShortcutId()));

		PortalUtil.addPortletBreadcrumbEntry(
			request, fileShortcut.getToTitle(), portletURL.toString());
	}

	public static void addPortletBreadcrumbEntries(
			long folderId, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		if (folderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(folderId);

			if (folder.getFolderId() !=
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

				addPortletBreadcrumbEntries(folder, request, renderResponse);
			}
		}
	}

	public static void addPortletBreadcrumbEntries(
			DLFolder folder, HttpServletRequest request,
			RenderResponse renderResponse)
		throws Exception {

		String strutsAction = ParamUtil.getString(
			request, "struts_action");

		long groupId = ParamUtil.getLong(request, "groupId");

		PortletURL portletURL = renderResponse.createRenderURL();

		if (strutsAction.equals("/journal/select_document_library") ||
			strutsAction.equals("/document_library/select_file_entry") ||
			strutsAction.equals("/document_library/select_folder") ||
			strutsAction.equals("/document_library_display/select_folder")) {

			ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			portletURL.setWindowState(LiferayWindowState.POP_UP);

			portletURL.setParameter("struts_action", strutsAction);
			portletURL.setParameter("groupId", String.valueOf(groupId));

			PortalUtil.addPortletBreadcrumbEntry(
				request, themeDisplay.translate("documents-home"),
				portletURL.toString());
		}
		else {
			portletURL.setParameter("struts_action", "/document_library/view");
		}

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletPreferences(
				request, PortalUtil.getPortletId(request));

		long defaultFolderId = GetterUtil.getLong(
			preferences.getValue(
				"rootFolderId",
				String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)));

		List<DLFolder> ancestorFolders = Collections.EMPTY_LIST;

		if (folder.getFolderId() != defaultFolderId) {
			ancestorFolders = folder.getAncestors();

			int indexOfRootFolder = -1;

			for (int i = 0; i < ancestorFolders.size(); i++) {
				DLFolder ancestorFolder = ancestorFolders.get(i);

				if (defaultFolderId == ancestorFolder.getFolderId()) {
					indexOfRootFolder = i;
				}
			}

			if (indexOfRootFolder > -1) {
				ancestorFolders = ancestorFolders.subList(0, indexOfRootFolder);
			}
		}

		Collections.reverse(ancestorFolders);

		for (DLFolder ancestorFolder : ancestorFolders) {
			portletURL.setParameter(
				"folderId", String.valueOf(ancestorFolder.getFolderId()));

			PortalUtil.addPortletBreadcrumbEntry(
				request, ancestorFolder.getName(), portletURL.toString());
		}

		portletURL.setParameter(
			"folderId", String.valueOf(folder.getFolderId()));

		if ((folder.getFolderId() !=
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) &&
			(folder.getFolderId() != defaultFolderId)) {

			PortalUtil.addPortletBreadcrumbEntry(
				request, folder.getName(), portletURL.toString());
		}
	}

	public static int compareVersions(String version1, String version2) {
		int[] splitVersion1 = StringUtil.split(version1, StringPool.PERIOD, 0);
		int[] splitVersion2 = StringUtil.split(version2, StringPool.PERIOD, 0);

		if ((splitVersion1.length != 2) && (splitVersion2.length != 2)) {
			return 0;
		}
		else if ((splitVersion1.length != 2)) {
			return -1;
		}
		else if ((splitVersion2.length != 2)) {
			return 1;
		}

		if (splitVersion1[0] > splitVersion2[0]) {
			return 1;
		}
		else if (splitVersion1[0] < splitVersion2[0]) {
			return -1;
		}
		else if (splitVersion1[1] > splitVersion2[1]) {
			return 1;
		}
		else if (splitVersion1[1] < splitVersion2[1]) {
			return -1;
		}

		return 0;
	}

	public static String getFileIcon(String extension) {
		return _instance._getFileIcon(extension);
	}

	public static String getGenericName(String extension) {
		return _instance._getGenericName(extension);
	}

	public static String getLockId(long groupId, long folderId, String name) {
		StringBundler sb = new StringBundler(5);

		sb.append(groupId);
		sb.append(StringPool.POUND);
		sb.append(folderId);
		sb.append(StringPool.POUND);
		sb.append(name);

		return sb.toString();
	}

	private DLUtil() {
		_fileIcons = new HashSet<String>();

		String[] fileIcons = null;

		try {
			fileIcons = PrefsPropsUtil.getStringArray(
				PropsKeys.DL_FILE_ICONS, StringPool.COMMA);
		}
		catch (Exception e) {
			_log.error(e, e);

			fileIcons = new String[] {StringPool.BLANK};
		}

		for (int i = 0; i < fileIcons.length; i++) {

			// Only process non wildcard extensions

			if (!StringPool.STAR.equals(fileIcons[i])) {

				// Strip starting period

				String extension = fileIcons[i];
				extension = extension.substring(1, extension.length());

				_fileIcons.add(extension);
			}
		}

		_genericNames = new HashMap<String, String>();

		_genericNames.put("lar", "compressed");
		_genericNames.put("rar", "compressed");
		_genericNames.put("zip", "compressed");

		_genericNames.put("doc", "document");
		_genericNames.put("docx", "document");
		_genericNames.put("rtf", "document");
		_genericNames.put("odt", "document");

		_genericNames.put("flv", "flash");
		_genericNames.put("swf", "flash");

		_genericNames.put("bmp", "image");
		_genericNames.put("gif", "image");
		_genericNames.put("jpeg", "image");
		_genericNames.put("jpg", "image");
		_genericNames.put("odg", "image");
		_genericNames.put("png", "image");
		_genericNames.put("svg", "image");

		_genericNames.put("acc", "music");
		_genericNames.put("mid", "music");
		_genericNames.put("mp3", "music");
		_genericNames.put("ogg", "music");
		_genericNames.put("wav", "music");
		_genericNames.put("wma", "music");

		_genericNames.put("pdf", "pdf");

		_genericNames.put("key", "presentation");
		_genericNames.put("odp", "presentation");
		_genericNames.put("pps", "presentation");
		_genericNames.put("ppt", "presentation");
		_genericNames.put("pptx", "presentation");

		_genericNames.put("csv", "spreadsheet");
		_genericNames.put("ods", "spreadsheet");
		_genericNames.put("xls", "spreadsheet");
		_genericNames.put("xlsx", "spreadsheet");

		_genericNames.put("avi", "video");
		_genericNames.put("mov", "video");
		_genericNames.put("mp4", "video");
		_genericNames.put("mpg", "video");
		_genericNames.put("qt", "video");
		_genericNames.put("rm", "video");
		_genericNames.put("wmv", "video");
	}

	private String _getFileIcon(String extension) {
		if (!_fileIcons.contains(extension)) {
			extension = _DEFAULT_FILE_ICON;
		}

		return extension;
	}

	private String _getGenericName(String extension) {
		String genericName = _genericNames.get(extension);

		if (genericName == null) {
			genericName = _DEFAULT_GENERIC_NAME;
		}

		return genericName;
	}

	private static final String _DEFAULT_GENERIC_NAME = "default";

	private static final String _DEFAULT_FILE_ICON = "page";

	private static Log _log = LogFactoryUtil.getLog(DLUtil.class);

	private static DLUtil _instance = new DLUtil();

	private Map<String, String> _genericNames;
	private Set<String> _fileIcons;

}