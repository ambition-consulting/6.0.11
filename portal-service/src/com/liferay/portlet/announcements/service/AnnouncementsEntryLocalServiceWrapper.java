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

package com.liferay.portlet.announcements.service;

/**
 * <p>
 * This class is a wrapper for {@link AnnouncementsEntryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AnnouncementsEntryLocalService
 * @generated
 */
public class AnnouncementsEntryLocalServiceWrapper
	implements AnnouncementsEntryLocalService {
	public AnnouncementsEntryLocalServiceWrapper(
		AnnouncementsEntryLocalService announcementsEntryLocalService) {
		_announcementsEntryLocalService = announcementsEntryLocalService;
	}

	/**
	* Adds the announcements entry to the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsEntry the announcements entry to add
	* @return the announcements entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsEntry addAnnouncementsEntry(
		com.liferay.portlet.announcements.model.AnnouncementsEntry announcementsEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.addAnnouncementsEntry(announcementsEntry);
	}

	/**
	* Creates a new announcements entry with the primary key. Does not add the announcements entry to the database.
	*
	* @param entryId the primary key for the new announcements entry
	* @return the new announcements entry
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsEntry createAnnouncementsEntry(
		long entryId) {
		return _announcementsEntryLocalService.createAnnouncementsEntry(entryId);
	}

	/**
	* Deletes the announcements entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the announcements entry to delete
	* @throws PortalException if a announcements entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnnouncementsEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_announcementsEntryLocalService.deleteAnnouncementsEntry(entryId);
	}

	/**
	* Deletes the announcements entry from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsEntry the announcements entry to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteAnnouncementsEntry(
		com.liferay.portlet.announcements.model.AnnouncementsEntry announcementsEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_announcementsEntryLocalService.deleteAnnouncementsEntry(announcementsEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the announcements entry with the primary key.
	*
	* @param entryId the primary key of the announcements entry to get
	* @return the announcements entry
	* @throws PortalException if a announcements entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsEntry getAnnouncementsEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getAnnouncementsEntry(entryId);
	}

	/**
	* Gets a range of all the announcements entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of announcements entries to return
	* @param end the upper bound of the range of announcements entries to return (not inclusive)
	* @return the range of announcements entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getAnnouncementsEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getAnnouncementsEntries(start,
			end);
	}

	/**
	* Gets the number of announcements entries.
	*
	* @return the number of announcements entries
	* @throws SystemException if a system exception occurred
	*/
	public int getAnnouncementsEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getAnnouncementsEntriesCount();
	}

	/**
	* Updates the announcements entry in the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsEntry the announcements entry to update
	* @return the announcements entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsEntry updateAnnouncementsEntry(
		com.liferay.portlet.announcements.model.AnnouncementsEntry announcementsEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.updateAnnouncementsEntry(announcementsEntry);
	}

	/**
	* Updates the announcements entry in the database. Also notifies the appropriate model listeners.
	*
	* @param announcementsEntry the announcements entry to update
	* @param merge whether to merge the announcements entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the announcements entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsEntry updateAnnouncementsEntry(
		com.liferay.portlet.announcements.model.AnnouncementsEntry announcementsEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.updateAnnouncementsEntry(announcementsEntry,
			merge);
	}

	public com.liferay.portlet.announcements.model.AnnouncementsEntry addEntry(
		long userId, long classNameId, long classPK, java.lang.String title,
		java.lang.String content, java.lang.String url, java.lang.String type,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, int priority, boolean alert)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.addEntry(userId, classNameId,
			classPK, title, content, url, type, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			priority, alert);
	}

	public void checkEntries()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_announcementsEntryLocalService.checkEntries();
	}

	public void deleteEntry(
		com.liferay.portlet.announcements.model.AnnouncementsEntry entry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_announcementsEntryLocalService.deleteEntry(entry);
	}

	public void deleteEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_announcementsEntryLocalService.deleteEntry(entryId);
	}

	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getEntries(
		long userId, java.util.LinkedHashMap<java.lang.Long, long[]> scopes,
		boolean alert, int flagValue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntries(userId, scopes,
			alert, flagValue, start, end);
	}

	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getEntries(
		long userId, java.util.LinkedHashMap<java.lang.Long, long[]> scopes,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean alert, int flagValue, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntries(userId, scopes,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			alert, flagValue, start, end);
	}

	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getEntries(
		long classNameId, long classPK, boolean alert, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntries(classNameId, classPK,
			alert, start, end);
	}

	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getEntries(
		long userId, long classNameId, long[] classPKs, int displayDateMonth,
		int displayDateDay, int displayDateYear, int displayDateHour,
		int displayDateMinute, int expirationDateMonth, int expirationDateDay,
		int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean alert, int flagValue, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntries(userId, classNameId,
			classPKs, displayDateMonth, displayDateDay, displayDateYear,
			displayDateHour, displayDateMinute, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, alert, flagValue, start, end);
	}

	public int getEntriesCount(long userId,
		java.util.LinkedHashMap<java.lang.Long, long[]> scopes, boolean alert,
		int flagValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntriesCount(userId, scopes,
			alert, flagValue);
	}

	public int getEntriesCount(long userId,
		java.util.LinkedHashMap<java.lang.Long, long[]> scopes,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean alert, int flagValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntriesCount(userId, scopes,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			alert, flagValue);
	}

	public int getEntriesCount(long classNameId, long classPK, boolean alert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntriesCount(classNameId,
			classPK, alert);
	}

	public int getEntriesCount(long userId, long classNameId, long[] classPKs,
		boolean alert, int flagValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntriesCount(userId,
			classNameId, classPKs, alert, flagValue);
	}

	public int getEntriesCount(long userId, long classNameId, long[] classPKs,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean alert, int flagValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntriesCount(userId,
			classNameId, classPKs, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, alert, flagValue);
	}

	public com.liferay.portlet.announcements.model.AnnouncementsEntry getEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getEntry(entryId);
	}

	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsEntry> getUserEntries(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getUserEntries(userId, start, end);
	}

	public int getUserEntriesCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.getUserEntriesCount(userId);
	}

	public com.liferay.portlet.announcements.model.AnnouncementsEntry updateEntry(
		long userId, long entryId, java.lang.String title,
		java.lang.String content, java.lang.String url, java.lang.String type,
		int displayDateMonth, int displayDateDay, int displayDateYear,
		int displayDateHour, int displayDateMinute, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, int priority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementsEntryLocalService.updateEntry(userId, entryId,
			title, content, url, type, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, priority);
	}

	public AnnouncementsEntryLocalService getWrappedAnnouncementsEntryLocalService() {
		return _announcementsEntryLocalService;
	}

	public void setWrappedAnnouncementsEntryLocalService(
		AnnouncementsEntryLocalService announcementsEntryLocalService) {
		_announcementsEntryLocalService = announcementsEntryLocalService;
	}

	private AnnouncementsEntryLocalService _announcementsEntryLocalService;
}