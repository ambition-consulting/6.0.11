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

import com.liferay.portal.model.UserTrackerPath;

/**
 * The persistence interface for the user tracker path service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPathPersistenceImpl
 * @see UserTrackerPathUtil
 * @generated
 */
public interface UserTrackerPathPersistence extends BasePersistence<UserTrackerPath> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserTrackerPathUtil} to access the user tracker path persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user tracker path in the entity cache if it is enabled.
	*
	* @param userTrackerPath the user tracker path to cache
	*/
	public void cacheResult(
		com.liferay.portal.model.UserTrackerPath userTrackerPath);

	/**
	* Caches the user tracker paths in the entity cache if it is enabled.
	*
	* @param userTrackerPaths the user tracker paths to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.UserTrackerPath> userTrackerPaths);

	/**
	* Creates a new user tracker path with the primary key. Does not add the user tracker path to the database.
	*
	* @param userTrackerPathId the primary key for the new user tracker path
	* @return the new user tracker path
	*/
	public com.liferay.portal.model.UserTrackerPath create(
		long userTrackerPathId);

	/**
	* Removes the user tracker path with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userTrackerPathId the primary key of the user tracker path to remove
	* @return the user tracker path that was removed
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath remove(
		long userTrackerPathId)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.UserTrackerPath updateImpl(
		com.liferay.portal.model.UserTrackerPath userTrackerPath, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the user tracker path with the primary key or throws a {@link com.liferay.portal.NoSuchUserTrackerPathException} if it could not be found.
	*
	* @param userTrackerPathId the primary key of the user tracker path to find
	* @return the user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath findByPrimaryKey(
		long userTrackerPathId)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the user tracker path with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userTrackerPathId the primary key of the user tracker path to find
	* @return the user tracker path, or <code>null</code> if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath fetchByPrimaryKey(
		long userTrackerPathId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the user tracker paths where userTrackerId = &#63;.
	*
	* @param userTrackerId the user tracker id to search with
	* @return the matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the user tracker paths where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @return the range of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the user tracker paths where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findByUserTrackerId(
		long userTrackerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a matching user tracker path could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath findByUserTrackerId_First(
		long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a matching user tracker path could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath findByUserTrackerId_Last(
		long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the user tracker paths before and after the current user tracker path in the ordered set where userTrackerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userTrackerPathId the primary key of the current user tracker path
	* @param userTrackerId the user tracker id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user tracker path
	* @throws com.liferay.portal.NoSuchUserTrackerPathException if a user tracker path with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserTrackerPath[] findByUserTrackerId_PrevAndNext(
		long userTrackerPathId, long userTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserTrackerPathException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the user tracker paths.
	*
	* @return the user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the user tracker paths.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @return the range of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the user tracker paths.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tracker paths to return
	* @param end the upper bound of the range of user tracker paths to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserTrackerPath> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user tracker paths where userTrackerId = &#63; from the database.
	*
	* @param userTrackerId the user tracker id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserTrackerId(long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user tracker paths from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the user tracker paths where userTrackerId = &#63;.
	*
	* @param userTrackerId the user tracker id to search with
	* @return the number of matching user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTrackerId(long userTrackerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the user tracker paths.
	*
	* @return the number of user tracker paths
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}