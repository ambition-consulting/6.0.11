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

package com.liferay.portal.service.persistence;

import com.liferay.portal.model.BrowserTracker;

/**
 * The persistence interface for the browser tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserTrackerPersistenceImpl
 * @see BrowserTrackerUtil
 * @generated
 */
public interface BrowserTrackerPersistence extends BasePersistence<BrowserTracker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrowserTrackerUtil} to access the browser tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the browser tracker in the entity cache if it is enabled.
	*
	* @param browserTracker the browser tracker to cache
	*/
	public void cacheResult(
		com.liferay.portal.model.BrowserTracker browserTracker);

	/**
	* Caches the browser trackers in the entity cache if it is enabled.
	*
	* @param browserTrackers the browser trackers to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.BrowserTracker> browserTrackers);

	/**
	* Creates a new browser tracker with the primary key. Does not add the browser tracker to the database.
	*
	* @param browserTrackerId the primary key for the new browser tracker
	* @return the new browser tracker
	*/
	public com.liferay.portal.model.BrowserTracker create(long browserTrackerId);

	/**
	* Removes the browser tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTrackerId the primary key of the browser tracker to remove
	* @return the browser tracker that was removed
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker remove(long browserTrackerId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.BrowserTracker updateImpl(
		com.liferay.portal.model.BrowserTracker browserTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the browser tracker with the primary key or throws a {@link com.liferay.portal.NoSuchBrowserTrackerException} if it could not be found.
	*
	* @param browserTrackerId the primary key of the browser tracker to find
	* @return the browser tracker
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker findByPrimaryKey(
		long browserTrackerId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the browser tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param browserTrackerId the primary key of the browser tracker to find
	* @return the browser tracker, or <code>null</code> if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker fetchByPrimaryKey(
		long browserTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the browser tracker where userId = &#63; or throws a {@link com.liferay.portal.NoSuchBrowserTrackerException} if it could not be found.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker findByUserId(long userId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the browser tracker where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker, or <code>null</code> if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the browser tracker where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker, or <code>null</code> if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.BrowserTracker fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the browser trackers.
	*
	* @return the browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.BrowserTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the browser trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browser trackers to return
	* @param end the upper bound of the range of browser trackers to return (not inclusive)
	* @return the range of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.BrowserTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the browser trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of browser trackers to return
	* @param end the upper bound of the range of browser trackers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.BrowserTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the browser tracker where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the browser trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the browser trackers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the browser trackers.
	*
	* @return the number of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}