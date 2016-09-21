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
 * The utility for the user tracker local service. This utility wraps {@link com.liferay.portal.service.impl.UserTrackerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerLocalService
 * @see com.liferay.portal.service.base.UserTrackerLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserTrackerLocalServiceImpl
 * @generated
 */
public class UserTrackerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserTrackerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user tracker to the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to add
	* @return the user tracker that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker addUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserTracker(userTracker);
	}

	/**
	* Creates a new user tracker with the primary key. Does not add the user tracker to the database.
	*
	* @param userTrackerId the primary key for the new user tracker
	* @return the new user tracker
	*/
	public static com.liferay.portal.model.UserTracker createUserTracker(
		long userTrackerId) {
		return getService().createUserTracker(userTrackerId);
	}

	/**
	* Deletes the user tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerId the primary key of the user tracker to delete
	* @throws PortalException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserTracker(long userTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserTracker(userTrackerId);
	}

	/**
	* Deletes the user tracker from the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserTracker(userTracker);
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
	* Gets the user tracker with the primary key.
	*
	* @param userTrackerId the primary key of the user tracker to get
	* @return the user tracker
	* @throws PortalException if a user tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker getUserTracker(
		long userTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTracker(userTrackerId);
	}

	/**
	* Gets a range of all the user trackers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user trackers to return
	* @param end the upper bound of the range of user trackers to return (not inclusive)
	* @return the range of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserTracker> getUserTrackers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackers(start, end);
	}

	/**
	* Gets the number of user trackers.
	*
	* @return the number of user trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserTrackersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackersCount();
	}

	/**
	* Updates the user tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to update
	* @return the user tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker updateUserTracker(
		com.liferay.portal.model.UserTracker userTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTracker(userTracker);
	}

	/**
	* Updates the user tracker in the database. Also notifies the appropriate model listeners.
	*
	* @param userTracker the user tracker to update
	* @param merge whether to merge the user tracker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserTracker updateUserTracker(
		com.liferay.portal.model.UserTracker userTracker, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTracker(userTracker, merge);
	}

	public static com.liferay.portal.model.UserTracker addUserTracker(
		long companyId, long userId, java.util.Date modifiedDate,
		java.lang.String sessionId, java.lang.String remoteAddr,
		java.lang.String remoteHost, java.lang.String userAgent,
		java.util.List<com.liferay.portal.model.UserTrackerPath> userTrackerPaths)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addUserTracker(companyId, userId, modifiedDate, sessionId,
			remoteAddr, remoteHost, userAgent, userTrackerPaths);
	}

	public static java.util.List<com.liferay.portal.model.UserTracker> getUserTrackers(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTrackers(companyId, start, end);
	}

	public static UserTrackerLocalService getService() {
		if (_service == null) {
			_service = (UserTrackerLocalService)PortalBeanLocatorUtil.locate(UserTrackerLocalService.class.getName());

			ReferenceRegistry.registerReference(UserTrackerLocalServiceUtil.class,
				"_service");
			MethodCache.remove(UserTrackerLocalService.class);
		}

		return _service;
	}

	public void setService(UserTrackerLocalService service) {
		MethodCache.remove(UserTrackerLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(UserTrackerLocalServiceUtil.class,
			"_service");
		MethodCache.remove(UserTrackerLocalService.class);
	}

	private static UserTrackerLocalService _service;
}