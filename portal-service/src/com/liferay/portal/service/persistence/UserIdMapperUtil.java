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
import com.liferay.portal.model.UserIdMapper;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user id mapper service. This utility wraps {@link UserIdMapperPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserIdMapperPersistence
 * @see UserIdMapperPersistenceImpl
 * @generated
 */
public class UserIdMapperUtil {
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
	public static void clearCache(UserIdMapper userIdMapper) {
		getPersistence().clearCache(userIdMapper);
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
	public static List<UserIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserIdMapper remove(UserIdMapper userIdMapper)
		throws SystemException {
		return getPersistence().remove(userIdMapper);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserIdMapper update(UserIdMapper userIdMapper, boolean merge)
		throws SystemException {
		return getPersistence().update(userIdMapper, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserIdMapper update(UserIdMapper userIdMapper, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userIdMapper, merge, serviceContext);
	}

	/**
	* Caches the user id mapper in the entity cache if it is enabled.
	*
	* @param userIdMapper the user id mapper to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.UserIdMapper userIdMapper) {
		getPersistence().cacheResult(userIdMapper);
	}

	/**
	* Caches the user id mappers in the entity cache if it is enabled.
	*
	* @param userIdMappers the user id mappers to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.UserIdMapper> userIdMappers) {
		getPersistence().cacheResult(userIdMappers);
	}

	/**
	* Creates a new user id mapper with the primary key. Does not add the user id mapper to the database.
	*
	* @param userIdMapperId the primary key for the new user id mapper
	* @return the new user id mapper
	*/
	public static com.liferay.portal.model.UserIdMapper create(
		long userIdMapperId) {
		return getPersistence().create(userIdMapperId);
	}

	/**
	* Removes the user id mapper with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapperId the primary key of the user id mapper to remove
	* @return the user id mapper that was removed
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper remove(
		long userIdMapperId)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userIdMapperId);
	}

	public static com.liferay.portal.model.UserIdMapper updateImpl(
		com.liferay.portal.model.UserIdMapper userIdMapper, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userIdMapper, merge);
	}

	/**
	* Finds the user id mapper with the primary key or throws a {@link com.liferay.portal.NoSuchUserIdMapperException} if it could not be found.
	*
	* @param userIdMapperId the primary key of the user id mapper to find
	* @return the user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper findByPrimaryKey(
		long userIdMapperId)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userIdMapperId);
	}

	/**
	* Finds the user id mapper with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userIdMapperId the primary key of the user id mapper to find
	* @return the user id mapper, or <code>null</code> if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper fetchByPrimaryKey(
		long userIdMapperId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userIdMapperId);
	}

	/**
	* Finds all the user id mappers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Finds a range of all the user id mappers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of user id mappers to return
	* @param end the upper bound of the range of user id mappers to return (not inclusive)
	* @return the range of matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Finds an ordered range of all the user id mappers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of user id mappers to return
	* @param end the upper bound of the range of user id mappers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Finds the first user id mapper in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Finds the last user id mapper in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Finds the user id mappers before and after the current user id mapper in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userIdMapperId the primary key of the current user id mapper
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper[] findByUserId_PrevAndNext(
		long userIdMapperId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(userIdMapperId, userId,
			orderByComparator);
	}

	/**
	* Finds the user id mapper where userId = &#63; and type = &#63; or throws a {@link com.liferay.portal.NoSuchUserIdMapperException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper findByU_T(long userId,
		java.lang.String type)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_T(userId, type);
	}

	/**
	* Finds the user id mapper where userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching user id mapper, or <code>null</code> if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper fetchByU_T(
		long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_T(userId, type);
	}

	/**
	* Finds the user id mapper where userId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the matching user id mapper, or <code>null</code> if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper fetchByU_T(
		long userId, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_T(userId, type, retrieveFromCache);
	}

	/**
	* Finds the user id mapper where type = &#63; and externalUserId = &#63; or throws a {@link com.liferay.portal.NoSuchUserIdMapperException} if it could not be found.
	*
	* @param type the type to search with
	* @param externalUserId the external user id to search with
	* @return the matching user id mapper
	* @throws com.liferay.portal.NoSuchUserIdMapperException if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper findByT_E(
		java.lang.String type, java.lang.String externalUserId)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_E(type, externalUserId);
	}

	/**
	* Finds the user id mapper where type = &#63; and externalUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type to search with
	* @param externalUserId the external user id to search with
	* @return the matching user id mapper, or <code>null</code> if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper fetchByT_E(
		java.lang.String type, java.lang.String externalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByT_E(type, externalUserId);
	}

	/**
	* Finds the user id mapper where type = &#63; and externalUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type to search with
	* @param externalUserId the external user id to search with
	* @return the matching user id mapper, or <code>null</code> if a matching user id mapper could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserIdMapper fetchByT_E(
		java.lang.String type, java.lang.String externalUserId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_E(type, externalUserId, retrieveFromCache);
	}

	/**
	* Finds all the user id mappers.
	*
	* @return the user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the user id mappers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user id mappers to return
	* @param end the upper bound of the range of user id mappers to return (not inclusive)
	* @return the range of user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the user id mappers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user id mappers to return
	* @param end the upper bound of the range of user id mappers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserIdMapper> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user id mappers where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes the user id mapper where userId = &#63; and type = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_T(long userId, java.lang.String type)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_T(userId, type);
	}

	/**
	* Removes the user id mapper where type = &#63; and externalUserId = &#63; from the database.
	*
	* @param type the type to search with
	* @param externalUserId the external user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_E(java.lang.String type,
		java.lang.String externalUserId)
		throws com.liferay.portal.NoSuchUserIdMapperException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_E(type, externalUserId);
	}

	/**
	* Removes all the user id mappers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user id mappers where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the user id mappers where userId = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param type the type to search with
	* @return the number of matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_T(long userId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_T(userId, type);
	}

	/**
	* Counts all the user id mappers where type = &#63; and externalUserId = &#63;.
	*
	* @param type the type to search with
	* @param externalUserId the external user id to search with
	* @return the number of matching user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_E(java.lang.String type,
		java.lang.String externalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_E(type, externalUserId);
	}

	/**
	* Counts all the user id mappers.
	*
	* @return the number of user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserIdMapperPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserIdMapperPersistence)PortalBeanLocatorUtil.locate(UserIdMapperPersistence.class.getName());

			ReferenceRegistry.registerReference(UserIdMapperUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(UserIdMapperPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(UserIdMapperUtil.class,
			"_persistence");
	}

	private static UserIdMapperPersistence _persistence;
}