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

package com.liferay.portlet.shopping.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.shopping.model.ShoppingCategory;

import java.util.List;

/**
 * The persistence utility for the shopping category service. This utility wraps {@link ShoppingCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCategoryPersistence
 * @see ShoppingCategoryPersistenceImpl
 * @generated
 */
public class ShoppingCategoryUtil {
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
	public static void clearCache(ShoppingCategory shoppingCategory) {
		getPersistence().clearCache(shoppingCategory);
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
	public static List<ShoppingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingCategory remove(ShoppingCategory shoppingCategory)
		throws SystemException {
		return getPersistence().remove(shoppingCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ShoppingCategory update(ShoppingCategory shoppingCategory,
		boolean merge) throws SystemException {
		return getPersistence().update(shoppingCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ShoppingCategory update(ShoppingCategory shoppingCategory,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shoppingCategory, merge, serviceContext);
	}

	/**
	* Caches the shopping category in the entity cache if it is enabled.
	*
	* @param shoppingCategory the shopping category to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.shopping.model.ShoppingCategory shoppingCategory) {
		getPersistence().cacheResult(shoppingCategory);
	}

	/**
	* Caches the shopping categories in the entity cache if it is enabled.
	*
	* @param shoppingCategories the shopping categories to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> shoppingCategories) {
		getPersistence().cacheResult(shoppingCategories);
	}

	/**
	* Creates a new shopping category with the primary key. Does not add the shopping category to the database.
	*
	* @param categoryId the primary key for the new shopping category
	* @return the new shopping category
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the shopping category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category to remove
	* @return the shopping category that was removed
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.liferay.portlet.shopping.model.ShoppingCategory updateImpl(
		com.liferay.portlet.shopping.model.ShoppingCategory shoppingCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingCategory, merge);
	}

	/**
	* Finds the shopping category with the primary key or throws a {@link com.liferay.portlet.shopping.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the shopping category to find
	* @return the shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Finds the shopping category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the shopping category to find
	* @return the shopping category, or <code>null</code> if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Finds all the shopping categories where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the shopping categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the shopping categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first shopping category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a matching shopping category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last shopping category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a matching shopping category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the shopping categories before and after the current shopping category in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current shopping category
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory[] findByGroupId_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the shopping categories where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the shopping categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the shopping categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @return the matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByG_P(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P(groupId, parentCategoryId);
	}

	/**
	* Finds a range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByG_P(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P(groupId, parentCategoryId, start, end);
	}

	/**
	* Finds an ordered range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findByG_P(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P(groupId, parentCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a matching shopping category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory findByG_P_First(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence()
				   .findByG_P_First(groupId, parentCategoryId, orderByComparator);
	}

	/**
	* Finds the last shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a matching shopping category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory findByG_P_Last(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence()
				   .findByG_P_Last(groupId, parentCategoryId, orderByComparator);
	}

	/**
	* Finds the shopping categories before and after the current shopping category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current shopping category
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping category
	* @throws com.liferay.portlet.shopping.NoSuchCategoryException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.shopping.model.ShoppingCategory[] findByG_P_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.shopping.NoSuchCategoryException {
		return getPersistence()
				   .findByG_P_PrevAndNext(categoryId, groupId,
			parentCategoryId, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @return the matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByG_P(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_P(groupId, parentCategoryId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByG_P(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P(groupId, parentCategoryId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> filterFindByG_P(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P(groupId, parentCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the shopping categories.
	*
	* @return the shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the shopping categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the shopping categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shopping categories where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the shopping categories where groupId = &#63; and parentCategoryId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P(groupId, parentCategoryId);
	}

	/**
	* Removes all the shopping categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the shopping categories where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and counts all the shopping categories where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Counts all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @return the number of matching shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P(groupId, parentCategoryId);
	}

	/**
	* Filters by the user's permissions and counts all the shopping categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentCategoryId the parent category id to search with
	* @return the number of matching shopping categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_P(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_P(groupId, parentCategoryId);
	}

	/**
	* Counts all the shopping categories.
	*
	* @return the number of shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingCategoryPersistence)PortalBeanLocatorUtil.locate(ShoppingCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoppingCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ShoppingCategoryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ShoppingCategoryUtil.class,
			"_persistence");
	}

	private static ShoppingCategoryPersistence _persistence;
}