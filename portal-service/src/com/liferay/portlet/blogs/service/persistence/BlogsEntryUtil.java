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

package com.liferay.portlet.blogs.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.blogs.model.BlogsEntry;

import java.util.List;

/**
 * The persistence utility for the blogs entry service. This utility wraps {@link BlogsEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsEntryPersistence
 * @see BlogsEntryPersistenceImpl
 * @generated
 */
public class BlogsEntryUtil {
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
	public static void clearCache(BlogsEntry blogsEntry) {
		getPersistence().clearCache(blogsEntry);
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
	public static List<BlogsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BlogsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BlogsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static BlogsEntry remove(BlogsEntry blogsEntry)
		throws SystemException {
		return getPersistence().remove(blogsEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BlogsEntry update(BlogsEntry blogsEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(blogsEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BlogsEntry update(BlogsEntry blogsEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(blogsEntry, merge, serviceContext);
	}

	/**
	* Caches the blogs entry in the entity cache if it is enabled.
	*
	* @param blogsEntry the blogs entry to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.blogs.model.BlogsEntry blogsEntry) {
		getPersistence().cacheResult(blogsEntry);
	}

	/**
	* Caches the blogs entries in the entity cache if it is enabled.
	*
	* @param blogsEntries the blogs entries to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> blogsEntries) {
		getPersistence().cacheResult(blogsEntries);
	}

	/**
	* Creates a new blogs entry with the primary key. Does not add the blogs entry to the database.
	*
	* @param entryId the primary key for the new blogs entry
	* @return the new blogs entry
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the blogs entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the blogs entry to remove
	* @return the blogs entry that was removed
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().remove(entryId);
	}

	public static com.liferay.portlet.blogs.model.BlogsEntry updateImpl(
		com.liferay.portlet.blogs.model.BlogsEntry blogsEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(blogsEntry, merge);
	}

	/**
	* Finds the blogs entry with the primary key or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param entryId the primary key of the blogs entry to find
	* @return the blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Finds the blogs entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the blogs entry to find
	* @return the blogs entry, or <code>null</code> if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Finds all the blogs entries where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Finds a range of all the blogs entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByUuid_PrevAndNext(
		long entryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(entryId, uuid, orderByComparator);
	}

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Finds the blogs entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Finds all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByGroupId_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(entryId, groupId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByCompanyId_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U(companyId, userId);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U(companyId, userId, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U(companyId, userId, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_U_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_First(companyId, userId, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_U_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_Last(companyId, userId, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByC_U_PrevAndNext(
		long entryId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_PrevAndNext(entryId, companyId, userId,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_LtD(companyId, displayDate);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_LtD(companyId, displayDate, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD(
		long companyId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LtD(companyId, displayDate, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_First(
		long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_First(companyId, displayDate, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_Last(
		long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_Last(companyId, displayDate, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByC_LtD_PrevAndNext(
		long entryId, long companyId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_PrevAndNext(entryId, companyId, displayDate,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(companyId, status);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(companyId, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_S(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S(companyId, status, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_S_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_S_First(companyId, status, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_S_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_S_Last(companyId, status, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByC_S_PrevAndNext(
		long entryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_S_PrevAndNext(entryId, companyId, status,
			orderByComparator);
	}

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or throws a {@link com.liferay.portlet.blogs.NoSuchEntryException} if it could not be found.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_UT(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry fetchByG_UT(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	* Finds the blogs entry where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the matching blogs entry, or <code>null</code> if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry fetchByG_UT(
		long groupId, java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_UT(groupId, urlTitle, retrieveFromCache);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_LtD(groupId, displayDate);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_LtD(groupId, displayDate, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LtD(groupId, displayDate, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_First(
		long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_First(groupId, displayDate, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_Last(
		long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_Last(groupId, displayDate, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_LtD_PrevAndNext(
		long entryId, long groupId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_PrevAndNext(entryId, groupId, displayDate,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_LtD(groupId, displayDate);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_LtD(groupId, displayDate, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD(
		long groupId, java.util.Date displayDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_LtD(groupId, displayDate, start, end,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_S_PrevAndNext(
		long entryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_S_PrevAndNext(entryId, groupId, status,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U_S(companyId, userId, status);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_S(companyId, userId, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_U_S(
		long companyId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_S(companyId, userId, status, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_U_S_First(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_S_First(companyId, userId, status,
			orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_U_S_Last(
		long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_S_Last(companyId, userId, status,
			orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByC_U_S_PrevAndNext(
		long entryId, long companyId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_S_PrevAndNext(entryId, companyId, userId, status,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_LtD_S(companyId, displayDate, status);
	}

	/**
	* Finds a range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LtD_S(companyId, displayDate, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByC_LtD_S(
		long companyId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_LtD_S(companyId, displayDate, status, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_S_First(
		long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_S_First(companyId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByC_LtD_S_Last(
		long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_S_Last(companyId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByC_LtD_S_PrevAndNext(
		long entryId, long companyId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByC_LtD_S_PrevAndNext(entryId, companyId, displayDate,
			status, orderByComparator);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U_LtD(groupId, userId, displayDate);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_LtD(groupId, userId, displayDate, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_LtD(groupId, userId, displayDate, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_First(
		long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_First(groupId, userId, displayDate,
			orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_Last(
		long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_Last(groupId, userId, displayDate,
			orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_LtD_PrevAndNext(
		long entryId, long groupId, long userId, java.util.Date displayDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_PrevAndNext(entryId, groupId, userId,
			displayDate, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U_LtD(groupId, userId, displayDate);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_LtD(groupId, userId, displayDate, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD(
		long groupId, long userId, java.util.Date displayDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_LtD(groupId, userId, displayDate, start,
			end, orderByComparator);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_U_S(groupId, userId, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_S(groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_S_First(groupId, userId, status, orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_S_Last(groupId, userId, status, orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_S_PrevAndNext(
		long entryId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_S_PrevAndNext(entryId, groupId, userId, status,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_S(groupId, userId, status, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_S(groupId, userId, status, start, end,
			orderByComparator);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_LtD_S(groupId, displayDate, status);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LtD_S(groupId, displayDate, status, start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_LtD_S(groupId, displayDate, status, start, end,
			orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_S_First(
		long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_S_First(groupId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_LtD_S_Last(
		long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_S_Last(groupId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_LtD_S_PrevAndNext(
		long entryId, long groupId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_LtD_S_PrevAndNext(entryId, groupId, displayDate,
			status, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_LtD_S(groupId, displayDate, status);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_LtD_S(groupId, displayDate, status, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_LtD_S(
		long groupId, java.util.Date displayDate, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_LtD_S(groupId, displayDate, status, start,
			end, orderByComparator);
	}

	/**
	* Finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_LtD_S(groupId, userId, displayDate, status);
	}

	/**
	* Finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_LtD_S(groupId, userId, displayDate, status,
			start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_U_LtD_S(groupId, userId, displayDate, status,
			start, end, orderByComparator);
	}

	/**
	* Finds the first blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_S_First(
		long groupId, long userId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_S_First(groupId, userId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the last blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a matching blogs entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry findByG_U_LtD_S_Last(
		long groupId, long userId, java.util.Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_S_Last(groupId, userId, displayDate, status,
			orderByComparator);
	}

	/**
	* Finds the blogs entries before and after the current blogs entry in the ordered set where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryId the primary key of the current blogs entry
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next blogs entry
	* @throws com.liferay.portlet.blogs.NoSuchEntryException if a blogs entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.blogs.model.BlogsEntry[] findByG_U_LtD_S_PrevAndNext(
		long entryId, long groupId, long userId, java.util.Date displayDate,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_LtD_S_PrevAndNext(entryId, groupId, userId,
			displayDate, status, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_LtD_S(groupId, userId, displayDate, status);
	}

	/**
	* Filters by the user's permissions and finds a range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_LtD_S(groupId, userId, displayDate, status,
			start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> filterFindByG_U_LtD_S(
		long groupId, long userId, java.util.Date displayDate, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_U_LtD_S(groupId, userId, displayDate, status,
			start, end, orderByComparator);
	}

	/**
	* Finds all the blogs entries.
	*
	* @return the blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the blogs entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @return the range of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the blogs entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of blogs entries to return
	* @param end the upper bound of the range of blogs entries to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.blogs.model.BlogsEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the blogs entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the blogs entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_U(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_U(companyId, userId);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_LtD(long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_LtD(companyId, displayDate);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_S(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_S(companyId, status);
	}

	/**
	* Removes the blogs entry where groupId = &#63; and urlTitle = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_UT(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.blogs.NoSuchEntryException {
		getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_LtD(long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_LtD(groupId, displayDate);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_U_S(long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_U_S(companyId, userId, status);
	}

	/**
	* Removes all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_LtD_S(long companyId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_LtD_S(companyId, displayDate, status);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U_LtD(groupId, userId, displayDate);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_LtD_S(long groupId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_LtD_S(groupId, displayDate, status);
	}

	/**
	* Removes all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_U_LtD_S(groupId, userId, displayDate, status);
	}

	/**
	* Removes all the blogs entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the blogs entries where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Counts all the blogs entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Counts all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Counts all the blogs entries where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Counts all the blogs entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_U(companyId, userId);
	}

	/**
	* Counts all the blogs entries where companyId = &#63; and displayDate &lt; &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_LtD(long companyId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_LtD(companyId, displayDate);
	}

	/**
	* Counts all the blogs entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S(companyId, status);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group id to search with
	* @param urlTitle the url title to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_UT(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_LtD(long groupId, java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_LtD(groupId, displayDate);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_LtD(long groupId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_LtD(groupId, displayDate);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	* Counts all the blogs entries where companyId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U_S(long companyId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_U_S(companyId, userId, status);
	}

	/**
	* Counts all the blogs entries where companyId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param companyId the company id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_LtD_S(long companyId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_LtD_S(companyId, displayDate, status);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U_LtD(groupId, userId, displayDate);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_U_LtD(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_U_LtD(groupId, userId, displayDate);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_U_S(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_LtD_S(long groupId, java.util.Date displayDate,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_LtD_S(groupId, displayDate, status);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_LtD_S(long groupId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_LtD_S(groupId, displayDate, status);
	}

	/**
	* Counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_U_LtD_S(groupId, userId, displayDate, status);
	}

	/**
	* Filters by the user's permissions and counts all the blogs entries where groupId = &#63; and userId = &#63; and displayDate &lt; &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param userId the user id to search with
	* @param displayDate the display date to search with
	* @param status the status to search with
	* @return the number of matching blogs entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_U_LtD_S(long groupId, long userId,
		java.util.Date displayDate, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_U_LtD_S(groupId, userId, displayDate, status);
	}

	/**
	* Counts all the blogs entries.
	*
	* @return the number of blogs entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BlogsEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BlogsEntryPersistence)PortalBeanLocatorUtil.locate(BlogsEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(BlogsEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BlogsEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BlogsEntryUtil.class, "_persistence");
	}

	private static BlogsEntryPersistence _persistence;
}