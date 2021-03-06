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

import com.liferay.portlet.social.model.SocialRequest;

/**
 * The persistence interface for the social request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialRequestPersistenceImpl
 * @see SocialRequestUtil
 * @generated
 */
public interface SocialRequestPersistence extends BasePersistence<SocialRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialRequestUtil} to access the social request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the social request in the entity cache if it is enabled.
	*
	* @param socialRequest the social request to cache
	*/
	public void cacheResult(
		com.liferay.portlet.social.model.SocialRequest socialRequest);

	/**
	* Caches the social requests in the entity cache if it is enabled.
	*
	* @param socialRequests the social requests to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.social.model.SocialRequest> socialRequests);

	/**
	* Creates a new social request with the primary key. Does not add the social request to the database.
	*
	* @param requestId the primary key for the new social request
	* @return the new social request
	*/
	public com.liferay.portlet.social.model.SocialRequest create(long requestId);

	/**
	* Removes the social request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the social request to remove
	* @return the social request that was removed
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest remove(long requestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	public com.liferay.portlet.social.model.SocialRequest updateImpl(
		com.liferay.portlet.social.model.SocialRequest socialRequest,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the social request with the primary key or throws a {@link com.liferay.portlet.social.NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the social request to find
	* @return the social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByPrimaryKey(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the social request to find
	* @return the social request, or <code>null</code> if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest fetchByPrimaryKey(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the social requests where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByUuid_PrevAndNext(
		long requestId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social request where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.social.NoSuchRequestException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching social request, or <code>null</code> if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the social request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching social request, or <code>null</code> if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the social requests where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByCompanyId_PrevAndNext(
		long requestId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByUserId_PrevAndNext(
		long requestId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests where receiverUserId = &#63;.
	*
	* @param receiverUserId the receiver user id to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByReceiverUserId(
		long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where receiverUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByReceiverUserId(
		long receiverUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where receiverUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByReceiverUserId(
		long receiverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where receiverUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByReceiverUserId_First(
		long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where receiverUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByReceiverUserId_Last(
		long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where receiverUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param receiverUserId the receiver user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByReceiverUserId_PrevAndNext(
		long requestId, long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests where userId = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_S(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_S(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param userId the user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByU_S_PrevAndNext(
		long requestId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests where receiverUserId = &#63; and status = &#63;.
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByR_S(
		long receiverUserId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByR_S(
		long receiverUserId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByR_S(
		long receiverUserId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByR_S_First(
		long receiverUserId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByR_S_Last(
		long receiverUserId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByR_S_PrevAndNext(
		long requestId, long receiverUserId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social request where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; or throws a {@link com.liferay.portlet.social.NoSuchRequestException} if it could not be found.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @return the matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByU_C_C_T_R(
		long userId, long classNameId, long classPK, int type,
		long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social request where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @return the matching social request, or <code>null</code> if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest fetchByU_C_C_T_R(
		long userId, long classNameId, long classPK, int type,
		long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the social request where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @return the matching social request, or <code>null</code> if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest fetchByU_C_C_T_R(
		long userId, long classNameId, long classPK, int type,
		long receiverUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_C_C_T_S(
		long userId, long classNameId, long classPK, int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_C_C_T_S(
		long userId, long classNameId, long classPK, int type, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByU_C_C_T_S(
		long userId, long classNameId, long classPK, int type, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByU_C_C_T_S_First(
		long userId, long classNameId, long classPK, int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByU_C_C_T_S_Last(
		long userId, long classNameId, long classPK, int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByU_C_C_T_S_PrevAndNext(
		long requestId, long userId, long classNameId, long classPK, int type,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @return the matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByC_C_T_R_S(
		long classNameId, long classPK, int type, long receiverUserId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByC_C_T_R_S(
		long classNameId, long classPK, int type, long receiverUserId,
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findByC_C_T_R_S(
		long classNameId, long classPK, int type, long receiverUserId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first social request in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByC_C_T_R_S_First(
		long classNameId, long classPK, int type, long receiverUserId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the last social request in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a matching social request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest findByC_C_T_R_S_Last(
		long classNameId, long classPK, int type, long receiverUserId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds the social requests before and after the current social request in the ordered set where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current social request
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next social request
	* @throws com.liferay.portlet.social.NoSuchRequestException if a social request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialRequest[] findByC_C_T_R_S_PrevAndNext(
		long requestId, long classNameId, long classPK, int type,
		long receiverUserId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Finds all the social requests.
	*
	* @return the social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the social requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @return the range of social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the social requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social requests to return
	* @param end the upper bound of the range of social requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of social requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social request where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Removes all the social requests where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where receiverUserId = &#63; from the database.
	*
	* @param receiverUserId the receiver user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReceiverUserId(long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_S(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where receiverUserId = &#63; and status = &#63; from the database.
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_S(long receiverUserId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the social request where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_C_C_T_R(long userId, long classNameId, long classPK,
		int type, long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.social.NoSuchRequestException;

	/**
	* Removes all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_C_C_T_S(long userId, long classNameId, long classPK,
		int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63; from the database.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_T_R_S(long classNameId, long classPK, int type,
		long receiverUserId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the social requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where receiverUserId = &#63;.
	*
	* @param receiverUserId the receiver user id to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByReceiverUserId(long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where userId = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param status the status to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_S(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where receiverUserId = &#63; and status = &#63;.
	*
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_S(long receiverUserId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63;.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_C_C_T_R(long userId, long classNameId, long classPK,
		int type, long receiverUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where userId = &#63; and classNameId = &#63; and classPK = &#63; and type = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param status the status to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_C_C_T_S(long userId, long classNameId, long classPK,
		int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests where classNameId = &#63; and classPK = &#63; and type = &#63; and receiverUserId = &#63; and status = &#63;.
	*
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param type the type to search with
	* @param receiverUserId the receiver user id to search with
	* @param status the status to search with
	* @return the number of matching social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_T_R_S(long classNameId, long classPK, int type,
		long receiverUserId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the social requests.
	*
	* @return the number of social requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}