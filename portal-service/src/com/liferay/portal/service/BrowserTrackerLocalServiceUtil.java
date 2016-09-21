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

package com.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the browser tracker local service. This utility wraps {@link com.liferay.portal.service.impl.BrowserTrackerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserTrackerLocalService
 * @see com.liferay.portal.service.base.BrowserTrackerLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.BrowserTrackerLocalServiceImpl
 * @generated
 */
public class BrowserTrackerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.BrowserTrackerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the browser tracker to the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker to add
	* @return the browser tracker that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker addBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBrowserTracker(browserTracker);
	}

	/**
	* Creates a new browser tracker with the primary key. Does not add the browser tracker to the database.
	*
	* @param browserTrackerId the primary key for the new browser tracker
	* @return the new browser tracker
	*/
	public static com.liferay.portal.model.BrowserTracker createBrowserTracker(
		long browserTrackerId) {
		return getService().createBrowserTracker(browserTrackerId);
	}

	/**
	* Deletes the browser tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTrackerId the primary key of the browser tracker to delete
	* @throws PortalException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBrowserTracker(long browserTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBrowserTracker(browserTrackerId);
	}

	/**
	* Deletes the browser tracker from the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBrowserTracker(browserTracker);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the browser tracker with the primary key.
	*
	* @param browserTrackerId the primary key of the browser tracker to get
	* @return the browser tracker
	* @throws PortalException if a browser tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker getBrowserTracker(
		long browserTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBrowserTracker(browserTrackerId);
	}

	/**
	* Gets a range of all the browser trackers.
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
	public static java.util.List<com.liferay.portal.model.BrowserTracker> getBrowserTrackers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBrowserTrackers(start, end);
	}

	/**
	* Gets the number of browser trackers.
	*
	* @return the number of browser trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int getBrowserTrackersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBrowserTrackersCount();
	}

	/**
	* Updates the browser tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker to update
	* @return the browser tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBrowserTracker(browserTracker);
	}

	/**
	* Updates the browser tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param browserTracker the browser tracker to update
	* @param merge whether to merge the browser tracker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the browser tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		com.liferay.portal.model.BrowserTracker browserTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBrowserTracker(browserTracker, merge);
	}

	public static void deleteUserBrowserTracker(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserBrowserTracker(userId);
	}

	public static com.liferay.portal.model.BrowserTracker getBrowserTracker(
		long userId, long browserKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBrowserTracker(userId, browserKey);
	}

	public static com.liferay.portal.model.BrowserTracker updateBrowserTracker(
		long userId, long browserKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBrowserTracker(userId, browserKey);
	}

	public static BrowserTrackerLocalService getService() {
		if (_service == null) {
			_service = (BrowserTrackerLocalService)PortalBeanLocatorUtil.locate(BrowserTrackerLocalService.class.getName());

			ReferenceRegistry.registerReference(BrowserTrackerLocalServiceUtil.class,
				"_service");
			MethodCache.remove(BrowserTrackerLocalService.class);
		}

		return _service;
	}

	public void setService(BrowserTrackerLocalService service) {
		MethodCache.remove(BrowserTrackerLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(BrowserTrackerLocalServiceUtil.class,
			"_service");
		MethodCache.remove(BrowserTrackerLocalService.class);
	}

	private static BrowserTrackerLocalService _service;
}