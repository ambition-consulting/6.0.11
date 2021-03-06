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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.asset.model.AssetTagStats;

import java.util.List;

/**
 * The persistence utility for the asset tag stats service. This utility wraps {@link AssetTagStatsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagStatsPersistence
 * @see AssetTagStatsPersistenceImpl
 * @generated
 */
public class AssetTagStatsUtil {
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
	public static void clearCache(AssetTagStats assetTagStats) {
		getPersistence().clearCache(assetTagStats);
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
	public static List<AssetTagStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AssetTagStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AssetTagStats> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static AssetTagStats remove(AssetTagStats assetTagStats)
		throws SystemException {
		return getPersistence().remove(assetTagStats);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AssetTagStats update(AssetTagStats assetTagStats,
		boolean merge) throws SystemException {
		return getPersistence().update(assetTagStats, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AssetTagStats update(AssetTagStats assetTagStats,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(assetTagStats, merge, serviceContext);
	}

	/**
	* Caches the asset tag stats in the entity cache if it is enabled.
	*
	* @param assetTagStats the asset tag stats to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats) {
		getPersistence().cacheResult(assetTagStats);
	}

	/**
	* Caches the asset tag statses in the entity cache if it is enabled.
	*
	* @param assetTagStatses the asset tag statses to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.asset.model.AssetTagStats> assetTagStatses) {
		getPersistence().cacheResult(assetTagStatses);
	}

	/**
	* Creates a new asset tag stats with the primary key. Does not add the asset tag stats to the database.
	*
	* @param tagStatsId the primary key for the new asset tag stats
	* @return the new asset tag stats
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats create(
		long tagStatsId) {
		return getPersistence().create(tagStatsId);
	}

	/**
	* Removes the asset tag stats with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagStatsId the primary key of the asset tag stats to remove
	* @return the asset tag stats that was removed
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats remove(
		long tagStatsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence().remove(tagStatsId);
	}

	public static com.liferay.portlet.asset.model.AssetTagStats updateImpl(
		com.liferay.portlet.asset.model.AssetTagStats assetTagStats,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(assetTagStats, merge);
	}

	/**
	* Finds the asset tag stats with the primary key or throws a {@link com.liferay.portlet.asset.NoSuchTagStatsException} if it could not be found.
	*
	* @param tagStatsId the primary key of the asset tag stats to find
	* @return the asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByPrimaryKey(
		long tagStatsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence().findByPrimaryKey(tagStatsId);
	}

	/**
	* Finds the asset tag stats with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagStatsId the primary key of the asset tag stats to find
	* @return the asset tag stats, or <code>null</code> if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats fetchByPrimaryKey(
		long tagStatsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tagStatsId);
	}

	/**
	* Finds all the asset tag statses where tagId = &#63;.
	*
	* @param tagId the tag id to search with
	* @return the matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByTagId(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagId(tagId);
	}

	/**
	* Finds a range of all the asset tag statses where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @return the range of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByTagId(
		long tagId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagId(tagId, start, end);
	}

	/**
	* Finds an ordered range of all the asset tag statses where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByTagId(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTagId(tagId, start, end, orderByComparator);
	}

	/**
	* Finds the first asset tag stats in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByTagId_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence().findByTagId_First(tagId, orderByComparator);
	}

	/**
	* Finds the last asset tag stats in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByTagId_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence().findByTagId_Last(tagId, orderByComparator);
	}

	/**
	* Finds the asset tag statses before and after the current asset tag stats in the ordered set where tagId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagStatsId the primary key of the current asset tag stats
	* @param tagId the tag id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats[] findByTagId_PrevAndNext(
		long tagStatsId, long tagId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence()
				   .findByTagId_PrevAndNext(tagStatsId, tagId, orderByComparator);
	}

	/**
	* Finds all the asset tag statses where classNameId = &#63;.
	*
	* @param classNameId the class name id to search with
	* @return the matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByClassNameId(
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameId(classNameId);
	}

	/**
	* Finds a range of all the asset tag statses where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @return the range of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByClassNameId(
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameId(classNameId, start, end);
	}

	/**
	* Finds an ordered range of all the asset tag statses where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findByClassNameId(
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameId(classNameId, start, end, orderByComparator);
	}

	/**
	* Finds the first asset tag stats in the ordered set where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByClassNameId_First(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence()
				   .findByClassNameId_First(classNameId, orderByComparator);
	}

	/**
	* Finds the last asset tag stats in the ordered set where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByClassNameId_Last(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence()
				   .findByClassNameId_Last(classNameId, orderByComparator);
	}

	/**
	* Finds the asset tag statses before and after the current asset tag stats in the ordered set where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tagStatsId the primary key of the current asset tag stats
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a asset tag stats with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats[] findByClassNameId_PrevAndNext(
		long tagStatsId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence()
				   .findByClassNameId_PrevAndNext(tagStatsId, classNameId,
			orderByComparator);
	}

	/**
	* Finds the asset tag stats where tagId = &#63; and classNameId = &#63; or throws a {@link com.liferay.portlet.asset.NoSuchTagStatsException} if it could not be found.
	*
	* @param tagId the tag id to search with
	* @param classNameId the class name id to search with
	* @return the matching asset tag stats
	* @throws com.liferay.portlet.asset.NoSuchTagStatsException if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats findByT_C(
		long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		return getPersistence().findByT_C(tagId, classNameId);
	}

	/**
	* Finds the asset tag stats where tagId = &#63; and classNameId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tagId the tag id to search with
	* @param classNameId the class name id to search with
	* @return the matching asset tag stats, or <code>null</code> if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats fetchByT_C(
		long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByT_C(tagId, classNameId);
	}

	/**
	* Finds the asset tag stats where tagId = &#63; and classNameId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tagId the tag id to search with
	* @param classNameId the class name id to search with
	* @return the matching asset tag stats, or <code>null</code> if a matching asset tag stats could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagStats fetchByT_C(
		long tagId, long classNameId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByT_C(tagId, classNameId, retrieveFromCache);
	}

	/**
	* Finds all the asset tag statses.
	*
	* @return the asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the asset tag statses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @return the range of asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the asset tag statses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag statses to return
	* @param end the upper bound of the range of asset tag statses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagStats> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the asset tag statses where tagId = &#63; from the database.
	*
	* @param tagId the tag id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTagId(tagId);
	}

	/**
	* Removes all the asset tag statses where classNameId = &#63; from the database.
	*
	* @param classNameId the class name id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassNameId(classNameId);
	}

	/**
	* Removes the asset tag stats where tagId = &#63; and classNameId = &#63; from the database.
	*
	* @param tagId the tag id to search with
	* @param classNameId the class name id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_C(long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.asset.NoSuchTagStatsException {
		getPersistence().removeByT_C(tagId, classNameId);
	}

	/**
	* Removes all the asset tag statses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the asset tag statses where tagId = &#63;.
	*
	* @param tagId the tag id to search with
	* @return the number of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTagId(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTagId(tagId);
	}

	/**
	* Counts all the asset tag statses where classNameId = &#63;.
	*
	* @param classNameId the class name id to search with
	* @return the number of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassNameId(classNameId);
	}

	/**
	* Counts all the asset tag statses where tagId = &#63; and classNameId = &#63;.
	*
	* @param tagId the tag id to search with
	* @param classNameId the class name id to search with
	* @return the number of matching asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_C(long tagId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_C(tagId, classNameId);
	}

	/**
	* Counts all the asset tag statses.
	*
	* @return the number of asset tag statses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AssetTagStatsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AssetTagStatsPersistence)PortalBeanLocatorUtil.locate(AssetTagStatsPersistence.class.getName());

			ReferenceRegistry.registerReference(AssetTagStatsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AssetTagStatsPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AssetTagStatsUtil.class,
			"_persistence");
	}

	private static AssetTagStatsPersistence _persistence;
}