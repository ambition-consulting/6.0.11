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

import com.liferay.portal.model.ResourceAction;

/**
 * The persistence interface for the resource action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceActionPersistenceImpl
 * @see ResourceActionUtil
 * @generated
 */
public interface ResourceActionPersistence extends BasePersistence<ResourceAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceActionUtil} to access the resource action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the resource action in the entity cache if it is enabled.
	*
	* @param resourceAction the resource action to cache
	*/
	public void cacheResult(
		com.liferay.portal.model.ResourceAction resourceAction);

	/**
	* Caches the resource actions in the entity cache if it is enabled.
	*
	* @param resourceActions the resource actions to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.ResourceAction> resourceActions);

	/**
	* Creates a new resource action with the primary key. Does not add the resource action to the database.
	*
	* @param resourceActionId the primary key for the new resource action
	* @return the new resource action
	*/
	public com.liferay.portal.model.ResourceAction create(long resourceActionId);

	/**
	* Removes the resource action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceActionId the primary key of the resource action to remove
	* @return the resource action that was removed
	* @throws com.liferay.portal.NoSuchResourceActionException if a resource action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction remove(long resourceActionId)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.ResourceAction updateImpl(
		com.liferay.portal.model.ResourceAction resourceAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource action with the primary key or throws a {@link com.liferay.portal.NoSuchResourceActionException} if it could not be found.
	*
	* @param resourceActionId the primary key of the resource action to find
	* @return the resource action
	* @throws com.liferay.portal.NoSuchResourceActionException if a resource action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction findByPrimaryKey(
		long resourceActionId)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param resourceActionId the primary key of the resource action to find
	* @return the resource action, or <code>null</code> if a resource action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction fetchByPrimaryKey(
		long resourceActionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the resource actions where name = &#63;.
	*
	* @param name the name to search with
	* @return the matching resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the resource actions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param start the lower bound of the range of resource actions to return
	* @param end the upper bound of the range of resource actions to return (not inclusive)
	* @return the range of matching resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the resource actions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param start the lower bound of the range of resource actions to return
	* @param end the upper bound of the range of resource actions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first resource action in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching resource action
	* @throws com.liferay.portal.NoSuchResourceActionException if a matching resource action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last resource action in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching resource action
	* @throws com.liferay.portal.NoSuchResourceActionException if a matching resource action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource actions before and after the current resource action in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourceActionId the primary key of the current resource action
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next resource action
	* @throws com.liferay.portal.NoSuchResourceActionException if a resource action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction[] findByName_PrevAndNext(
		long resourceActionId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource action where name = &#63; and actionId = &#63; or throws a {@link com.liferay.portal.NoSuchResourceActionException} if it could not be found.
	*
	* @param name the name to search with
	* @param actionId the action id to search with
	* @return the matching resource action
	* @throws com.liferay.portal.NoSuchResourceActionException if a matching resource action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction findByN_A(
		java.lang.String name, java.lang.String actionId)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource action where name = &#63; and actionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @param actionId the action id to search with
	* @return the matching resource action, or <code>null</code> if a matching resource action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction fetchByN_A(
		java.lang.String name, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the resource action where name = &#63; and actionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @param actionId the action id to search with
	* @return the matching resource action, or <code>null</code> if a matching resource action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.ResourceAction fetchByN_A(
		java.lang.String name, java.lang.String actionId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the resource actions.
	*
	* @return the resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the resource actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resource actions to return
	* @param end the upper bound of the range of resource actions to return (not inclusive)
	* @return the range of resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the resource actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resource actions to return
	* @param end the upper bound of the range of resource actions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of resource actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.ResourceAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resource actions where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the resource action where name = &#63; and actionId = &#63; from the database.
	*
	* @param name the name to search with
	* @param actionId the action id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_A(java.lang.String name, java.lang.String actionId)
		throws com.liferay.portal.NoSuchResourceActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resource actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the resource actions where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching resource actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the resource actions where name = &#63; and actionId = &#63;.
	*
	* @param name the name to search with
	* @param actionId the action id to search with
	* @return the number of matching resource actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_A(java.lang.String name, java.lang.String actionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the resource actions.
	*
	* @return the number of resource actions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}