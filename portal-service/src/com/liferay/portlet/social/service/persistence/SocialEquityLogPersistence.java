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

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.social.model.SocialEquityLog;

/**
 * The persistence interface for the social equity log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityLogPersistenceImpl
 * @see SocialEquityLogUtil
 * @generated
 */
public interface SocialEquityLogPersistence extends BasePersistence<SocialEquityLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialEquityLogUtil} to access the social equity log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the social equity log in the entity cache if it is enabled.
	*
	* @param socialEquityLog the social equity log to cache
	*/
	public void cacheResult(
		com.liferay.portlet.social.model.SocialEquityLog socialEquityLog);

	/**
	* Caches the social equity logs in the entity cache if it is enabled.
	*
	* @param socialEquityLogs the social equity logs to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.social.model.SocialEquityLog> socialEquityLogs);

	/**
	* Creates a new social equity log with the primary key. Does not add the social equity log to the database.
	*
	* @param equityLogId the primary key for the new social equity log
	* @return the new social equity log
	*/
	public com.liferay.portlet.social.model.SocialEquityLog create(
		long equityLogId);

	/**
	* Removes the social equity log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param equityLogId the primary key of the social equity log to remove
	* @return the social equity log that was removed
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog remove(
		long equityLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	public com.liferay.portlet.social.model.SocialEquityLog updateImpl(
		com.liferay.portlet.social.model.SocialEquityLog socialEquityLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the social equity log with the primary key or throws a {@link com.liferay.portlet.social.NoSuchEquityLogException} if it could not be found.
	*
	* @param equityLogId the primary key of the social equity log to find
	* @return the social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByPrimaryKey(
		long equityLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param equityLogId the primary key of the social equity log to find
	* @return the social equity log, or <code>null</code> if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog fetchByPrimaryKey(
		long equityLogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @return the matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_T_A(
		long assetEntryId, int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_T_A(
		long assetEntryId, int type, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_T_A(
		long assetEntryId, int type, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_T_A_First(
		long assetEntryId, int type, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the last social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_T_A_Last(
		long assetEntryId, int type, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param equityLogId the primary key of the current social equity log
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog[] findByAEI_T_A_PrevAndNext(
		long equityLogId, long assetEntryId, int type, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_A_T(
		long userId, java.lang.String actionId, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_A_T(
		long userId, java.lang.String actionId, boolean active, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_A_T(
		long userId, java.lang.String actionId, boolean active, int type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByU_AID_A_T_First(
		long userId, java.lang.String actionId, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the last social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByU_AID_A_T_Last(
		long userId, java.lang.String actionId, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity logs before and after the current social equity log in the ordered set where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param equityLogId the primary key of the current social equity log
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog[] findByU_AID_A_T_PrevAndNext(
		long equityLogId, long userId, java.lang.String actionId,
		boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_A_T(
		long assetEntryId, java.lang.String actionId, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_A_T(
		long assetEntryId, java.lang.String actionId, boolean active, int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_A_T(
		long assetEntryId, java.lang.String actionId, boolean active, int type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_AID_A_T_First(
		long assetEntryId, java.lang.String actionId, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the last social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_AID_A_T_Last(
		long assetEntryId, java.lang.String actionId, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param equityLogId the primary key of the current social equity log
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog[] findByAEI_AID_A_T_PrevAndNext(
		long equityLogId, long assetEntryId, java.lang.String actionId,
		boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_AD_A_T(
		long userId, java.lang.String actionId, int actionDate, boolean active,
		int type) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_AD_A_T(
		long userId, java.lang.String actionId, int actionDate, boolean active,
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByU_AID_AD_A_T(
		long userId, java.lang.String actionId, int actionDate, boolean active,
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByU_AID_AD_A_T_First(
		long userId, java.lang.String actionId, int actionDate, boolean active,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the last social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByU_AID_AD_A_T_Last(
		long userId, java.lang.String actionId, int actionDate, boolean active,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity logs before and after the current social equity log in the ordered set where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param equityLogId the primary key of the current social equity log
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog[] findByU_AID_AD_A_T_PrevAndNext(
		long equityLogId, long userId, java.lang.String actionId,
		int actionDate, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_AD_A_T(
		long assetEntryId, java.lang.String actionId, int actionDate,
		boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_AD_A_T(
		long assetEntryId, java.lang.String actionId, int actionDate,
		boolean active, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findByAEI_AID_AD_A_T(
		long assetEntryId, java.lang.String actionId, int actionDate,
		boolean active, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_AID_AD_A_T_First(
		long assetEntryId, java.lang.String actionId, int actionDate,
		boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the last social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByAEI_AID_AD_A_T_Last(
		long assetEntryId, java.lang.String actionId, int actionDate,
		boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity logs before and after the current social equity log in the ordered set where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param equityLogId the primary key of the current social equity log
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a social equity log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog[] findByAEI_AID_AD_A_T_PrevAndNext(
		long equityLogId, long assetEntryId, java.lang.String actionId,
		int actionDate, boolean active, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or throws a {@link com.liferay.portlet.social.NoSuchEquityLogException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity log
	* @throws com.liferay.portlet.social.NoSuchEquityLogException if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog findByU_AEI_AID_AD_A_T(
		long userId, long assetEntryId, java.lang.String actionId,
		int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity log, or <code>null</code> if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog fetchByU_AEI_AID_AD_A_T(
		long userId, long assetEntryId, java.lang.String actionId,
		int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the matching social equity log, or <code>null</code> if a matching social equity log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityLog fetchByU_AEI_AID_AD_A_T(
		long userId, long assetEntryId, java.lang.String actionId,
		int actionDate, boolean active, int type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the social equity logs.
	*
	* @return the social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social equity logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @return the range of social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social equity logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social equity logs to return
	* @param end the upper bound of the range of social equity logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialEquityLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63; from the database.
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAEI_T_A(long assetEntryId, int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_AID_A_T(long userId, java.lang.String actionId,
		boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63; from the database.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAEI_AID_A_T(long assetEntryId,
		java.lang.String actionId, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_AID_AD_A_T(long userId, java.lang.String actionId,
		int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAEI_AID_AD_A_T(long assetEntryId,
		java.lang.String actionId, int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social equity log where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_AEI_AID_AD_A_T(long userId, long assetEntryId,
		java.lang.String actionId, int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchEquityLogException;

	/**
	* Removes all the social equity logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where assetEntryId = &#63; and type = &#63; and active = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param type the type to search with
	* @param active the active to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAEI_T_A(long assetEntryId, int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where userId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_AID_A_T(long userId, java.lang.String actionId,
		boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where assetEntryId = &#63; and actionId = &#63; and active = &#63; and type = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAEI_AID_A_T(long assetEntryId, java.lang.String actionId,
		boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where userId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_AID_AD_A_T(long userId, java.lang.String actionId,
		int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAEI_AID_AD_A_T(long assetEntryId,
		java.lang.String actionId, int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs where userId = &#63; and assetEntryId = &#63; and actionId = &#63; and actionDate = &#63; and active = &#63; and type = &#63;.
	*
	* @param userId the user id to search with
	* @param assetEntryId the asset entry id to search with
	* @param actionId the action id to search with
	* @param actionDate the action date to search with
	* @param active the active to search with
	* @param type the type to search with
	* @return the number of matching social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_AEI_AID_AD_A_T(long userId, long assetEntryId,
		java.lang.String actionId, int actionDate, boolean active, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social equity logs.
	*
	* @return the number of social equity logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}