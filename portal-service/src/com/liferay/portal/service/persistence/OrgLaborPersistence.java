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

import com.liferay.portal.model.OrgLabor;

/**
 * The persistence interface for the org labor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgLaborPersistenceImpl
 * @see OrgLaborUtil
 * @generated
 */
public interface OrgLaborPersistence extends BasePersistence<OrgLabor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrgLaborUtil} to access the org labor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the org labor in the entity cache if it is enabled.
	*
	* @param orgLabor the org labor to cache
	*/
	public void cacheResult(com.liferay.portal.model.OrgLabor orgLabor);

	/**
	* Caches the org labors in the entity cache if it is enabled.
	*
	* @param orgLabors the org labors to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.OrgLabor> orgLabors);

	/**
	* Creates a new org labor with the primary key. Does not add the org labor to the database.
	*
	* @param orgLaborId the primary key for the new org labor
	* @return the new org labor
	*/
	public com.liferay.portal.model.OrgLabor create(long orgLaborId);

	/**
	* Removes the org labor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgLaborId the primary key of the org labor to remove
	* @return the org labor that was removed
	* @throws com.liferay.portal.NoSuchOrgLaborException if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor remove(long orgLaborId)
		throws com.liferay.portal.NoSuchOrgLaborException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.OrgLabor updateImpl(
		com.liferay.portal.model.OrgLabor orgLabor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the org labor with the primary key or throws a {@link com.liferay.portal.NoSuchOrgLaborException} if it could not be found.
	*
	* @param orgLaborId the primary key of the org labor to find
	* @return the org labor
	* @throws com.liferay.portal.NoSuchOrgLaborException if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor findByPrimaryKey(long orgLaborId)
		throws com.liferay.portal.NoSuchOrgLaborException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the org labor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgLaborId the primary key of the org labor to find
	* @return the org labor, or <code>null</code> if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor fetchByPrimaryKey(long orgLaborId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the org labors where organizationId = &#63;.
	*
	* @param organizationId the organization id to search with
	* @return the matching org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the org labors where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizationId the organization id to search with
	* @param start the lower bound of the range of org labors to return
	* @param end the upper bound of the range of org labors to return (not inclusive)
	* @return the range of matching org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findByOrganizationId(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the org labors where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizationId the organization id to search with
	* @param start the lower bound of the range of org labors to return
	* @param end the upper bound of the range of org labors to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first org labor in the ordered set where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizationId the organization id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching org labor
	* @throws com.liferay.portal.NoSuchOrgLaborException if a matching org labor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor findByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchOrgLaborException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last org labor in the ordered set where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizationId the organization id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching org labor
	* @throws com.liferay.portal.NoSuchOrgLaborException if a matching org labor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor findByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchOrgLaborException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the org labors before and after the current org labor in the ordered set where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orgLaborId the primary key of the current org labor
	* @param organizationId the organization id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next org labor
	* @throws com.liferay.portal.NoSuchOrgLaborException if a org labor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.OrgLabor[] findByOrganizationId_PrevAndNext(
		long orgLaborId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchOrgLaborException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the org labors.
	*
	* @return the org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the org labors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of org labors to return
	* @param end the upper bound of the range of org labors to return (not inclusive)
	* @return the range of org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the org labors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of org labors to return
	* @param end the upper bound of the range of org labors to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of org labors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.OrgLabor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the org labors where organizationId = &#63; from the database.
	*
	* @param organizationId the organization id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the org labors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the org labors where organizationId = &#63;.
	*
	* @param organizationId the organization id to search with
	* @return the number of matching org labors
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the org labors.
	*
	* @return the number of org labors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}