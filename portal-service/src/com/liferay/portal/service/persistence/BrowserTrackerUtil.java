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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.model.BrowserTracker;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the browser tracker service. This utility wraps {@link BrowserTrackerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserTrackerPersistence
 * @see BrowserTrackerPersistenceImpl
 * @generated
 */
public class BrowserTrackerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(BrowserTracker browserTracker) {
		getPersistence().clearCache(browserTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BrowserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BrowserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BrowserTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static BrowserTracker remove(BrowserTracker browserTracker)
		throws SystemException {
		return getPersistence().remove(browserTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BrowserTracker update(BrowserTracker browserTracker,
		boolean merge) throws SystemException {
		return getPersistence().update(browserTracker, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BrowserTracker update(BrowserTracker browserTracker,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(browserTracker, merge, serviceContext);
	}

	/**
	* Caches the browser tracker in the entity cache if it is enabled.
	*
	* @param browserTracker the browser tracker to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.BrowserTracker browserTracker) {
		getPersistence().cacheResult(browserTracker);
	}

	/**
	* Caches the browser trackers in the entity cache if it is enabled.
	*
	* @param browserTrackers the browser trackers to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.BrowserTracker> browserTrackers) {
		getPersistence().cacheResult(browserTrackers);
	}

	/**
	* Creates a new browser tracker with the primary key. Does not add the browser tracker to the database.
	*
	* @param browserTrackerId the primary key for the new browser tracker
	* @return the new browser tracker
	*/
	public static com.liferay.portal.model.BrowserTracker create(
		long browserTrackerId) {
		return getPersistence().create(browserTrackerId);
	}

	/**
	* Removes the browser tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTrackerId the primary key of the browser tracker to remove
	* @return the browser tracker that was removed
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker remove(
		long browserTrackerId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(browserTrackerId);
	}

	public static com.liferay.portal.model.BrowserTracker updateImpl(
		com.liferay.portal.model.BrowserTracker browserTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(browserTracker, merge);
	}

	/**
	* Finds the browser tracker with the primary key or throws a {@link com.liferay.portal.NoSuchBrowserTrackerException} if it could not be found.
	*
	* @param browserTrackerId the primary key of the browser tracker to find
	* @return the browser tracker
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker findByPrimaryKey(
		long browserTrackerId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(browserTrackerId);
	}

	/**
	* Finds the browser tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param browserTrackerId the primary key of the browser tracker to find
	* @return the browser tracker, or <code>null</code> if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker fetchByPrimaryKey(
		long browserTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(browserTrackerId);
	}

	/**
	* Finds the browser tracker where userId = &#63; or throws a {@link com.liferay.portal.NoSuchBrowserTrackerException} if it could not be found.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker
	* @throws com.liferay.portal.NoSuchBrowserTrackerException if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker findByUserId(
		long userId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Finds the browser tracker where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker, or <code>null</code> if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Finds the browser tracker where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @return the matching browser tracker, or <code>null</code> if a matching browser tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Finds all the browser trackers.
	*
	* @return the browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.BrowserTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.portal.model.BrowserTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.portal.model.BrowserTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the browser tracker where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.NoSuchBrowserTrackerException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the browser trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the browser trackers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the browser trackers.
	*
	* @return the number of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BrowserTrackerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BrowserTrackerPersistence)PortalBeanLocatorUtil.locate(BrowserTrackerPersistence.class.getName());

			ReferenceRegistry.registerReference(BrowserTrackerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BrowserTrackerPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BrowserTrackerUtil.class,
			"_persistence");
	}

	private static BrowserTrackerPersistence _persistence;
}