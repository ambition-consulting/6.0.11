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
import com.liferay.portal.model.PasswordPolicyRel;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the password policy rel service. This utility wraps {@link PasswordPolicyRelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PasswordPolicyRelPersistence
 * @see PasswordPolicyRelPersistenceImpl
 * @generated
 */
public class PasswordPolicyRelUtil {
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
	public static void clearCache(PasswordPolicyRel passwordPolicyRel) {
		getPersistence().clearCache(passwordPolicyRel);
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
	public static List<PasswordPolicyRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PasswordPolicyRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PasswordPolicyRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static PasswordPolicyRel remove(PasswordPolicyRel passwordPolicyRel)
		throws SystemException {
		return getPersistence().remove(passwordPolicyRel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PasswordPolicyRel update(
		PasswordPolicyRel passwordPolicyRel, boolean merge)
		throws SystemException {
		return getPersistence().update(passwordPolicyRel, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PasswordPolicyRel update(
		PasswordPolicyRel passwordPolicyRel, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(passwordPolicyRel, merge, serviceContext);
	}

	/**
	* Caches the password policy rel in the entity cache if it is enabled.
	*
	* @param passwordPolicyRel the password policy rel to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel) {
		getPersistence().cacheResult(passwordPolicyRel);
	}

	/**
	* Caches the password policy rels in the entity cache if it is enabled.
	*
	* @param passwordPolicyRels the password policy rels to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.PasswordPolicyRel> passwordPolicyRels) {
		getPersistence().cacheResult(passwordPolicyRels);
	}

	/**
	* Creates a new password policy rel with the primary key. Does not add the password policy rel to the database.
	*
	* @param passwordPolicyRelId the primary key for the new password policy rel
	* @return the new password policy rel
	*/
	public static com.liferay.portal.model.PasswordPolicyRel create(
		long passwordPolicyRelId) {
		return getPersistence().create(passwordPolicyRelId);
	}

	/**
	* Removes the password policy rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to remove
	* @return the password policy rel that was removed
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel remove(
		long passwordPolicyRelId)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(passwordPolicyRelId);
	}

	public static com.liferay.portal.model.PasswordPolicyRel updateImpl(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(passwordPolicyRel, merge);
	}

	/**
	* Finds the password policy rel with the primary key or throws a {@link com.liferay.portal.NoSuchPasswordPolicyRelException} if it could not be found.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to find
	* @return the password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel findByPrimaryKey(
		long passwordPolicyRelId)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(passwordPolicyRelId);
	}

	/**
	* Finds the password policy rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to find
	* @return the password policy rel, or <code>null</code> if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel fetchByPrimaryKey(
		long passwordPolicyRelId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(passwordPolicyRelId);
	}

	/**
	* Finds all the password policy rels where passwordPolicyId = &#63;.
	*
	* @param passwordPolicyId the password policy id to search with
	* @return the matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findByPasswordPolicyId(
		long passwordPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPasswordPolicyId(passwordPolicyId);
	}

	/**
	* Finds a range of all the password policy rels where passwordPolicyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param passwordPolicyId the password policy id to search with
	* @param start the lower bound of the range of password policy rels to return
	* @param end the upper bound of the range of password policy rels to return (not inclusive)
	* @return the range of matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findByPasswordPolicyId(
		long passwordPolicyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPasswordPolicyId(passwordPolicyId, start, end);
	}

	/**
	* Finds an ordered range of all the password policy rels where passwordPolicyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param passwordPolicyId the password policy id to search with
	* @param start the lower bound of the range of password policy rels to return
	* @param end the upper bound of the range of password policy rels to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findByPasswordPolicyId(
		long passwordPolicyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPasswordPolicyId(passwordPolicyId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first password policy rel in the ordered set where passwordPolicyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param passwordPolicyId the password policy id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel findByPasswordPolicyId_First(
		long passwordPolicyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPasswordPolicyId_First(passwordPolicyId,
			orderByComparator);
	}

	/**
	* Finds the last password policy rel in the ordered set where passwordPolicyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param passwordPolicyId the password policy id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel findByPasswordPolicyId_Last(
		long passwordPolicyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPasswordPolicyId_Last(passwordPolicyId,
			orderByComparator);
	}

	/**
	* Finds the password policy rels before and after the current password policy rel in the ordered set where passwordPolicyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param passwordPolicyRelId the primary key of the current password policy rel
	* @param passwordPolicyId the password policy id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel[] findByPasswordPolicyId_PrevAndNext(
		long passwordPolicyRelId, long passwordPolicyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPasswordPolicyId_PrevAndNext(passwordPolicyRelId,
			passwordPolicyId, orderByComparator);
	}

	/**
	* Finds the password policy rel where classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.NoSuchPasswordPolicyRelException} if it could not be found.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel findByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	* Finds the password policy rel where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel, or <code>null</code> if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel fetchByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	* Finds the password policy rel where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel, or <code>null</code> if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Finds the password policy rel where passwordPolicyId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.NoSuchPasswordPolicyRelException} if it could not be found.
	*
	* @param passwordPolicyId the password policy id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel
	* @throws com.liferay.portal.NoSuchPasswordPolicyRelException if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel findByP_C_C(
		long passwordPolicyId, long classNameId, long classPK)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_C_C(passwordPolicyId, classNameId, classPK);
	}

	/**
	* Finds the password policy rel where passwordPolicyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param passwordPolicyId the password policy id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel, or <code>null</code> if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel fetchByP_C_C(
		long passwordPolicyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_C_C(passwordPolicyId, classNameId, classPK);
	}

	/**
	* Finds the password policy rel where passwordPolicyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param passwordPolicyId the password policy id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching password policy rel, or <code>null</code> if a matching password policy rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.PasswordPolicyRel fetchByP_C_C(
		long passwordPolicyId, long classNameId, long classPK,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_C_C(passwordPolicyId, classNameId, classPK,
			retrieveFromCache);
	}

	/**
	* Finds all the password policy rels.
	*
	* @return the password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the password policy rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of password policy rels to return
	* @param end the upper bound of the range of password policy rels to return (not inclusive)
	* @return the range of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the password policy rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of password policy rels to return
	* @param end the upper bound of the range of password policy rels to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.PasswordPolicyRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the password policy rels where passwordPolicyId = &#63; from the database.
	*
	* @param passwordPolicyId the password policy id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPasswordPolicyId(long passwordPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPasswordPolicyId(passwordPolicyId);
	}

	/**
	* Removes the password policy rel where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C(long classNameId, long classPK)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	* Removes the password policy rel where passwordPolicyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param passwordPolicyId the password policy id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_C_C(long passwordPolicyId, long classNameId,
		long classPK)
		throws com.liferay.portal.NoSuchPasswordPolicyRelException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_C_C(passwordPolicyId, classNameId, classPK);
	}

	/**
	* Removes all the password policy rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the password policy rels where passwordPolicyId = &#63;.
	*
	* @param passwordPolicyId the password policy id to search with
	* @return the number of matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPasswordPolicyId(long passwordPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPasswordPolicyId(passwordPolicyId);
	}

	/**
	* Counts all the password policy rels where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	* Counts all the password policy rels where passwordPolicyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param passwordPolicyId the password policy id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_C_C(long passwordPolicyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByP_C_C(passwordPolicyId, classNameId, classPK);
	}

	/**
	* Counts all the password policy rels.
	*
	* @return the number of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PasswordPolicyRelPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PasswordPolicyRelPersistence)PortalBeanLocatorUtil.locate(PasswordPolicyRelPersistence.class.getName());

			ReferenceRegistry.registerReference(PasswordPolicyRelUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(PasswordPolicyRelPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(PasswordPolicyRelUtil.class,
			"_persistence");
	}

	private static PasswordPolicyRelPersistence _persistence;
}