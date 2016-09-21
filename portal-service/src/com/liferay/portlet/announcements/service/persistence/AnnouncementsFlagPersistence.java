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

package com.liferay.portlet.announcements.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.announcements.model.AnnouncementsFlag;

/**
 * The persistence interface for the announcements flag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsFlagPersistenceImpl
 * @see AnnouncementsFlagUtil
 * @generated
 */
public interface AnnouncementsFlagPersistence extends BasePersistence<AnnouncementsFlag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementsFlagUtil} to access the announcements flag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the announcements flag in the entity cache if it is enabled.
	*
	* @param announcementsFlag the announcements flag to cache
	*/
	public void cacheResult(
		com.liferay.portlet.announcements.model.AnnouncementsFlag announcementsFlag);

	/**
	* Caches the announcements flags in the entity cache if it is enabled.
	*
	* @param announcementsFlags the announcements flags to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> announcementsFlags);

	/**
	* Creates a new announcements flag with the primary key. Does not add the announcements flag to the database.
	*
	* @param flagId the primary key for the new announcements flag
	* @return the new announcements flag
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag create(
		long flagId);

	/**
	* Removes the announcements flag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagId the primary key of the announcements flag to remove
	* @return the announcements flag that was removed
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a announcements flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag remove(
		long flagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	public com.liferay.portlet.announcements.model.AnnouncementsFlag updateImpl(
		com.liferay.portlet.announcements.model.AnnouncementsFlag announcementsFlag,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the announcements flag with the primary key or throws a {@link com.liferay.portlet.announcements.NoSuchFlagException} if it could not be found.
	*
	* @param flagId the primary key of the announcements flag to find
	* @return the announcements flag
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a announcements flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag findByPrimaryKey(
		long flagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Finds the announcements flag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param flagId the primary key of the announcements flag to find
	* @return the announcements flag, or <code>null</code> if a announcements flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag fetchByPrimaryKey(
		long flagId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the announcements flags where entryId = &#63;.
	*
	* @param entryId the entry id to search with
	* @return the matching announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findByEntryId(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the announcements flags where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry id to search with
	* @param start the lower bound of the range of announcements flags to return
	* @param end the upper bound of the range of announcements flags to return (not inclusive)
	* @return the range of matching announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findByEntryId(
		long entryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the announcements flags where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry id to search with
	* @param start the lower bound of the range of announcements flags to return
	* @param end the upper bound of the range of announcements flags to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findByEntryId(
		long entryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first announcements flag in the ordered set where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching announcements flag
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a matching announcements flag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag findByEntryId_First(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Finds the last announcements flag in the ordered set where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the entry id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching announcements flag
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a matching announcements flag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag findByEntryId_Last(
		long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Finds the announcements flags before and after the current announcements flag in the ordered set where entryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param flagId the primary key of the current announcements flag
	* @param entryId the entry id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next announcements flag
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a announcements flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag[] findByEntryId_PrevAndNext(
		long flagId, long entryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Finds the announcements flag where userId = &#63; and entryId = &#63; and value = &#63; or throws a {@link com.liferay.portlet.announcements.NoSuchFlagException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param entryId the entry id to search with
	* @param value the value to search with
	* @return the matching announcements flag
	* @throws com.liferay.portlet.announcements.NoSuchFlagException if a matching announcements flag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag findByU_E_V(
		long userId, long entryId, int value)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Finds the announcements flag where userId = &#63; and entryId = &#63; and value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param entryId the entry id to search with
	* @param value the value to search with
	* @return the matching announcements flag, or <code>null</code> if a matching announcements flag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag fetchByU_E_V(
		long userId, long entryId, int value)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the announcements flag where userId = &#63; and entryId = &#63; and value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param entryId the entry id to search with
	* @param value the value to search with
	* @return the matching announcements flag, or <code>null</code> if a matching announcements flag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.announcements.model.AnnouncementsFlag fetchByU_E_V(
		long userId, long entryId, int value, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the announcements flags.
	*
	* @return the announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the announcements flags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of announcements flags to return
	* @param end the upper bound of the range of announcements flags to return (not inclusive)
	* @return the range of announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the announcements flags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of announcements flags to return
	* @param end the upper bound of the range of announcements flags to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.announcements.model.AnnouncementsFlag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the announcements flags where entryId = &#63; from the database.
	*
	* @param entryId the entry id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEntryId(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the announcements flag where userId = &#63; and entryId = &#63; and value = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param entryId the entry id to search with
	* @param value the value to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_E_V(long userId, long entryId, int value)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.announcements.NoSuchFlagException;

	/**
	* Removes all the announcements flags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the announcements flags where entryId = &#63;.
	*
	* @param entryId the entry id to search with
	* @return the number of matching announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntryId(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the announcements flags where userId = &#63; and entryId = &#63; and value = &#63;.
	*
	* @param userId the user id to search with
	* @param entryId the entry id to search with
	* @param value the value to search with
	* @return the number of matching announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_E_V(long userId, long entryId, int value)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the announcements flags.
	*
	* @return the number of announcements flags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}