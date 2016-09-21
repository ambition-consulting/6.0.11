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

package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.messageboards.model.MBBan;

import java.util.List;

/**
 * The persistence utility for the message boards ban service. This utility wraps {@link MBBanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBBanPersistence
 * @see MBBanPersistenceImpl
 * @generated
 */
public class MBBanUtil {
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
	public static void clearCache(MBBan mbBan) {
		getPersistence().clearCache(mbBan);
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
	public static List<MBBan> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MBBan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MBBan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static MBBan remove(MBBan mbBan) throws SystemException {
		return getPersistence().remove(mbBan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static MBBan update(MBBan mbBan, boolean merge)
		throws SystemException {
		return getPersistence().update(mbBan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static MBBan update(MBBan mbBan, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(mbBan, merge, serviceContext);
	}

	/**
	* Caches the message boards ban in the entity cache if it is enabled.
	*
	* @param mbBan the message boards ban to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.messageboards.model.MBBan mbBan) {
		getPersistence().cacheResult(mbBan);
	}

	/**
	* Caches the message boards bans in the entity cache if it is enabled.
	*
	* @param mbBans the message boards bans to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.messageboards.model.MBBan> mbBans) {
		getPersistence().cacheResult(mbBans);
	}

	/**
	* Creates a new message boards ban with the primary key. Does not add the message boards ban to the database.
	*
	* @param banId the primary key for the new message boards ban
	* @return the new message boards ban
	*/
	public static com.liferay.portlet.messageboards.model.MBBan create(
		long banId) {
		return getPersistence().create(banId);
	}

	/**
	* Removes the message boards ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param banId the primary key of the message boards ban to remove
	* @return the message boards ban that was removed
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan remove(
		long banId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().remove(banId);
	}

	public static com.liferay.portlet.messageboards.model.MBBan updateImpl(
		com.liferay.portlet.messageboards.model.MBBan mbBan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(mbBan, merge);
	}

	/**
	* Finds the message boards ban with the primary key or throws a {@link com.liferay.portlet.messageboards.NoSuchBanException} if it could not be found.
	*
	* @param banId the primary key of the message boards ban to find
	* @return the message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByPrimaryKey(
		long banId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByPrimaryKey(banId);
	}

	/**
	* Finds the message boards ban with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param banId the primary key of the message boards ban to find
	* @return the message boards ban, or <code>null</code> if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan fetchByPrimaryKey(
		long banId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(banId);
	}

	/**
	* Finds all the message boards bans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the message boards bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @return the range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the message boards bans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first message boards ban in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last message boards ban in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the message boards bans before and after the current message boards ban in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banId the primary key of the current message boards ban
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan[] findByGroupId_PrevAndNext(
		long banId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(banId, groupId, orderByComparator);
	}

	/**
	* Finds all the message boards bans where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Finds a range of all the message boards bans where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @return the range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Finds an ordered range of all the message boards bans where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Finds the first message boards ban in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Finds the last message boards ban in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Finds the message boards bans before and after the current message boards ban in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banId the primary key of the current message boards ban
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan[] findByUserId_PrevAndNext(
		long banId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence()
				   .findByUserId_PrevAndNext(banId, userId, orderByComparator);
	}

	/**
	* Finds all the message boards bans where banUserId = &#63;.
	*
	* @param banUserId the ban user id to search with
	* @return the matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
		long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBanUserId(banUserId);
	}

	/**
	* Finds a range of all the message boards bans where banUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banUserId the ban user id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @return the range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
		long banUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBanUserId(banUserId, start, end);
	}

	/**
	* Finds an ordered range of all the message boards bans where banUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banUserId the ban user id to search with
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findByBanUserId(
		long banUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBanUserId(banUserId, start, end, orderByComparator);
	}

	/**
	* Finds the first message boards ban in the ordered set where banUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banUserId the ban user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByBanUserId_First(
		long banUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence()
				   .findByBanUserId_First(banUserId, orderByComparator);
	}

	/**
	* Finds the last message boards ban in the ordered set where banUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banUserId the ban user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByBanUserId_Last(
		long banUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence()
				   .findByBanUserId_Last(banUserId, orderByComparator);
	}

	/**
	* Finds the message boards bans before and after the current message boards ban in the ordered set where banUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param banId the primary key of the current message boards ban
	* @param banUserId the ban user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a message boards ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan[] findByBanUserId_PrevAndNext(
		long banId, long banUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence()
				   .findByBanUserId_PrevAndNext(banId, banUserId,
			orderByComparator);
	}

	/**
	* Finds the message boards ban where groupId = &#63; and banUserId = &#63; or throws a {@link com.liferay.portlet.messageboards.NoSuchBanException} if it could not be found.
	*
	* @param groupId the group id to search with
	* @param banUserId the ban user id to search with
	* @return the matching message boards ban
	* @throws com.liferay.portlet.messageboards.NoSuchBanException if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan findByG_B(
		long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		return getPersistence().findByG_B(groupId, banUserId);
	}

	/**
	* Finds the message boards ban where groupId = &#63; and banUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group id to search with
	* @param banUserId the ban user id to search with
	* @return the matching message boards ban, or <code>null</code> if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
		long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_B(groupId, banUserId);
	}

	/**
	* Finds the message boards ban where groupId = &#63; and banUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group id to search with
	* @param banUserId the ban user id to search with
	* @return the matching message boards ban, or <code>null</code> if a matching message boards ban could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBBan fetchByG_B(
		long groupId, long banUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_B(groupId, banUserId, retrieveFromCache);
	}

	/**
	* Finds all the message boards bans.
	*
	* @return the message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the message boards bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @return the range of message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the message boards bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards bans to return
	* @param end the upper bound of the range of message boards bans to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the message boards bans where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the message boards bans where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the message boards bans where banUserId = &#63; from the database.
	*
	* @param banUserId the ban user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBanUserId(long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBanUserId(banUserId);
	}

	/**
	* Removes the message boards ban where groupId = &#63; and banUserId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param banUserId the ban user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_B(long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.messageboards.NoSuchBanException {
		getPersistence().removeByG_B(groupId, banUserId);
	}

	/**
	* Removes all the message boards bans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the message boards bans where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the message boards bans where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the message boards bans where banUserId = &#63;.
	*
	* @param banUserId the ban user id to search with
	* @return the number of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBanUserId(long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBanUserId(banUserId);
	}

	/**
	* Counts all the message boards bans where groupId = &#63; and banUserId = &#63;.
	*
	* @param groupId the group id to search with
	* @param banUserId the ban user id to search with
	* @return the number of matching message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_B(long groupId, long banUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_B(groupId, banUserId);
	}

	/**
	* Counts all the message boards bans.
	*
	* @return the number of message boards bans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MBBanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MBBanPersistence)PortalBeanLocatorUtil.locate(MBBanPersistence.class.getName());

			ReferenceRegistry.registerReference(MBBanUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(MBBanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(MBBanUtil.class, "_persistence");
	}

	private static MBBanPersistence _persistence;
}