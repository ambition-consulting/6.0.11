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

package com.liferay.portlet.blogs.lar;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerControl;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.blogs.service.persistence.BlogsEntryUtil;

import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Bruno Farache
 * @author Raymond Augé
 * @author Juan Fernández
 */
public class BlogsPortletDataHandlerImpl extends BasePortletDataHandler {

	public PortletDataHandlerControl[] getExportControls() {
		return new PortletDataHandlerControl[] {
			_entries, _categories, _comments, _ratings, _tags
		};
	}

	public PortletDataHandlerControl[] getImportControls() {
		return new PortletDataHandlerControl[] {
			_entries, _categories, _comments, _ratings, _tags, _wordpress
		};
	}

	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		if (!portletDataContext.addPrimaryKey(
				BlogsPortletDataHandlerImpl.class, "deleteData")) {

			BlogsEntryLocalServiceUtil.deleteEntries(
				portletDataContext.getScopeGroupId());
		}

		return null;
	}

	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletDataContext.addPermissions(
			"com.liferay.portlet.blogs", portletDataContext.getScopeGroupId());

		Document document = SAXReaderUtil.createDocument();

		Element rootElement = document.addElement("blogs-data");

		rootElement.addAttribute(
			"group-id", String.valueOf(portletDataContext.getScopeGroupId()));

		List<BlogsEntry> entries = BlogsEntryUtil.findByGroupId(
			portletDataContext.getScopeGroupId());

		for (BlogsEntry entry : entries) {
			exportEntry(portletDataContext, rootElement, entry);
		}

		return document.formattedString();
	}

	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		portletDataContext.importPermissions(
			"com.liferay.portlet.blogs", portletDataContext.getSourceGroupId(),
			portletDataContext.getScopeGroupId());

		Document document = SAXReaderUtil.read(data);

		Element rootElement = document.getRootElement();

		for (Element entryElement : rootElement.elements("entry")) {
			String path = entryElement.attributeValue("path");

			if (!portletDataContext.isPathNotProcessed(path)) {
				continue;
			}

			BlogsEntry entry =
				(BlogsEntry)portletDataContext.getZipEntryAsObject(path);

			importEntry(portletDataContext, entry);
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "wordpress")) {
			WordPressImporter.importData(portletDataContext);
		}

		return null;
	}

	protected void exportEntry(
			PortletDataContext portletDataContext, Element rootElement,
			BlogsEntry entry)
		throws PortalException, SystemException {

		if (!portletDataContext.isWithinDateRange(entry.getModifiedDate())) {
			return;
		}

		if (entry.getStatus() != WorkflowConstants.STATUS_APPROVED) {
			return;
		}

		String path = getEntryPath(portletDataContext, entry);

		if (!portletDataContext.isPathNotProcessed(path)) {
			return;
		}

		Element entryElement = rootElement.addElement("entry");

		entryElement.addAttribute("path", path);

		portletDataContext.addPermissions(BlogsEntry.class, entry.getEntryId());

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "categories")) {
			portletDataContext.addAssetCategories(
				BlogsEntry.class, entry.getEntryId());
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "comments")) {
			portletDataContext.addComments(
				BlogsEntry.class, entry.getEntryId());
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "ratings")) {
			portletDataContext.addRatingsEntries(
				BlogsEntry.class, entry.getEntryId());
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "tags")) {
			portletDataContext.addAssetTags(
				BlogsEntry.class, entry.getEntryId());
		}

		entry.setUserUuid(entry.getUserUuid());

		portletDataContext.addZipEntry(path, entry);
	}

	protected String getEntryPath(
		PortletDataContext portletDataContext, BlogsEntry entry) {

		StringBundler sb = new StringBundler(4);

		sb.append(portletDataContext.getPortletPath(PortletKeys.BLOGS));
		sb.append("/entries/");
		sb.append(entry.getEntryId());
		sb.append(".xml");

		return sb.toString();
	}

	protected void importEntry(
			PortletDataContext portletDataContext, BlogsEntry entry)
		throws Exception {

		long userId = portletDataContext.getUserId(entry.getUserUuid());

		Calendar displayDateCal = CalendarFactoryUtil.getCalendar();

		displayDateCal.setTime(entry.getDisplayDate());

		int displayDateMonth = displayDateCal.get(Calendar.MONTH);
		int displayDateDay = displayDateCal.get(Calendar.DATE);
		int displayDateYear = displayDateCal.get(Calendar.YEAR);
		int displayDateHour = displayDateCal.get(Calendar.HOUR);
		int displayDateMinute = displayDateCal.get(Calendar.MINUTE);

		if (displayDateCal.get(Calendar.AM_PM) == Calendar.PM) {
			displayDateHour += 12;
		}

		boolean allowPingbacks = entry.isAllowPingbacks();
		boolean allowTrackbacks = entry.isAllowTrackbacks();
		String[] trackbacks = StringUtil.split(entry.getTrackbacks());
		int status = entry.getStatus();

		long[] assetCategoryIds = null;
		String[] assetTagNames = null;

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "categories")) {
			assetCategoryIds = portletDataContext.getAssetCategoryIds(
				BlogsEntry.class, entry.getEntryId());
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "tags")) {
			assetTagNames = portletDataContext.getAssetTagNames(
				BlogsEntry.class, entry.getEntryId());
		}

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setAssetCategoryIds(assetCategoryIds);
		serviceContext.setAssetTagNames(assetTagNames);
		serviceContext.setCreateDate(entry.getCreateDate());
		serviceContext.setModifiedDate(entry.getModifiedDate());
		serviceContext.setScopeGroupId(portletDataContext.getScopeGroupId());

		if (status != WorkflowConstants.STATUS_APPROVED) {
			serviceContext.setWorkflowAction(
				WorkflowConstants.ACTION_SAVE_DRAFT);
		}

		BlogsEntry importedEntry = null;

		if (portletDataContext.isDataStrategyMirror()) {
			BlogsEntry existingEntry = BlogsEntryUtil.fetchByUUID_G(
				entry.getUuid(), portletDataContext.getScopeGroupId());

			if (existingEntry == null) {
				serviceContext.setUuid(entry.getUuid());

				importedEntry = BlogsEntryLocalServiceUtil.addEntry(
					userId, entry.getTitle(), entry.getContent(),
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, allowPingbacks,
					allowTrackbacks, trackbacks, serviceContext);
			}
			else {
				importedEntry = BlogsEntryLocalServiceUtil.updateEntry(
					userId, existingEntry.getEntryId(), entry.getTitle(),
					entry.getContent(), displayDateMonth, displayDateDay,
					displayDateYear, displayDateHour, displayDateMinute,
					allowPingbacks, allowTrackbacks, trackbacks,
					serviceContext);
			}
		}
		else {
			importedEntry = BlogsEntryLocalServiceUtil.addEntry(
				userId, entry.getTitle(), entry.getContent(), displayDateMonth,
				displayDateDay, displayDateYear, displayDateHour,
				displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
				serviceContext);
		}

		portletDataContext.importPermissions(
			BlogsEntry.class, entry.getEntryId(), importedEntry.getEntryId());

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "comments")) {
			portletDataContext.importComments(
				BlogsEntry.class, entry.getEntryId(),
				importedEntry.getEntryId(),
				portletDataContext.getScopeGroupId());
		}

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "ratings")) {
			portletDataContext.importRatingsEntries(
				BlogsEntry.class, entry.getEntryId(),
				importedEntry.getEntryId());
		}
	}

	private static final String _NAMESPACE = "blogs";

	private static PortletDataHandlerBoolean _categories =
		new PortletDataHandlerBoolean(_NAMESPACE, "categories");

	private static PortletDataHandlerBoolean _comments =
		new PortletDataHandlerBoolean(_NAMESPACE, "comments");

	private static PortletDataHandlerBoolean _entries =
		new PortletDataHandlerBoolean(_NAMESPACE, "entries", true, true);

	private static PortletDataHandlerBoolean _ratings =
		new PortletDataHandlerBoolean(_NAMESPACE, "ratings");

	private static PortletDataHandlerBoolean _tags =
		new PortletDataHandlerBoolean(_NAMESPACE, "tags");

	private static PortletDataHandlerBoolean _wordpress =
		new PortletDataHandlerBoolean(_NAMESPACE, "wordpress");

}