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

import com.liferay.portal.model.Region;

/**
 * The persistence interface for the region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegionPersistenceImpl
 * @see RegionUtil
 * @generated
 */
public interface RegionPersistence extends BasePersistence<Region> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegionUtil} to access the region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the region in the entity cache if it is enabled.
	*
	* @param region the region to cache
	*/
	public void cacheResult(com.liferay.portal.model.Region region);

	/**
	* Caches the regions in the entity cache if it is enabled.
	*
	* @param regions the regions to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.Region> regions);

	/**
	* Creates a new region with the primary key. Does not add the region to the database.
	*
	* @param regionId the primary key for the new region
	* @return the new region
	*/
	public com.liferay.portal.model.Region create(long regionId);

	/**
	* Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param regionId the primary key of the region to remove
	* @return the region that was removed
	* @throws com.liferay.portal.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region remove(long regionId)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Region updateImpl(
		com.liferay.portal.model.Region region, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the region with the primary key or throws a {@link com.liferay.portal.NoSuchRegionException} if it could not be found.
	*
	* @param regionId the primary key of the region to find
	* @return the region
	* @throws com.liferay.portal.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByPrimaryKey(long regionId)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param regionId the primary key of the region to find
	* @return the region, or <code>null</code> if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region fetchByPrimaryKey(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the regions where countryId = &#63;.
	*
	* @param countryId the country id to search with
	* @return the matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByCountryId(
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the regions where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @return the range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByCountryId(
		long countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the regions where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByCountryId(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first region in the ordered set where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByCountryId_First(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last region in the ordered set where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByCountryId_Last(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the regions before and after the current region in the ordered set where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param regionId the primary key of the current region
	* @param countryId the country id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next region
	* @throws com.liferay.portal.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region[] findByCountryId_PrevAndNext(
		long regionId, long countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the regions where active = &#63;.
	*
	* @param active the active to search with
	* @return the matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the regions where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @return the range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the regions where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first region in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByActive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last region in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByActive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the regions before and after the current region in the ordered set where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param regionId the primary key of the current region
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next region
	* @throws com.liferay.portal.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region[] findByActive_PrevAndNext(
		long regionId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the regions where countryId = &#63; and active = &#63;.
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @return the matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByC_A(
		long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the regions where countryId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @return the range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByC_A(
		long countryId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the regions where countryId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findByC_A(
		long countryId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first region in the ordered set where countryId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByC_A_First(long countryId,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last region in the ordered set where countryId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching region
	* @throws com.liferay.portal.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region findByC_A_Last(long countryId,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the regions before and after the current region in the ordered set where countryId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param regionId the primary key of the current region
	* @param countryId the country id to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next region
	* @throws com.liferay.portal.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Region[] findByC_A_PrevAndNext(
		long regionId, long countryId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the regions.
	*
	* @return the regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @return the range of regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of regions to return
	* @param end the upper bound of the range of regions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Region> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the regions where countryId = &#63; from the database.
	*
	* @param countryId the country id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryId(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the regions where active = &#63; from the database.
	*
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the regions where countryId = &#63; and active = &#63; from the database.
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_A(long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the regions where countryId = &#63;.
	*
	* @param countryId the country id to search with
	* @return the number of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryId(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the regions where active = &#63;.
	*
	* @param active the active to search with
	* @return the number of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the regions where countryId = &#63; and active = &#63;.
	*
	* @param countryId the country id to search with
	* @param active the active to search with
	* @return the number of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_A(long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the regions.
	*
	* @return the number of regions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}