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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link MembershipRequestLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MembershipRequestLocalService
 * @generated
 */
public class MembershipRequestLocalServiceWrapper
	implements MembershipRequestLocalService {
	public MembershipRequestLocalServiceWrapper(
		MembershipRequestLocalService membershipRequestLocalService) {
		_membershipRequestLocalService = membershipRequestLocalService;
	}

	/**
	* Adds the membership request to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipRequest the membership request to add
	* @return the membership request that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.MembershipRequest addMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.addMembershipRequest(membershipRequest);
	}

	/**
	* Creates a new membership request with the primary key. Does not add the membership request to the database.
	*
	* @param membershipRequestId the primary key for the new membership request
	* @return the new membership request
	*/
	public com.liferay.portal.model.MembershipRequest createMembershipRequest(
		long membershipRequestId) {
		return _membershipRequestLocalService.createMembershipRequest(membershipRequestId);
	}

	/**
	* Deletes the membership request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipRequestId the primary key of the membership request to delete
	* @throws PortalException if a membership request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMembershipRequest(long membershipRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.deleteMembershipRequest(membershipRequestId);
	}

	/**
	* Deletes the membership request from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipRequest the membership request to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.deleteMembershipRequest(membershipRequest);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the membership request with the primary key.
	*
	* @param membershipRequestId the primary key of the membership request to get
	* @return the membership request
	* @throws PortalException if a membership request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.MembershipRequest getMembershipRequest(
		long membershipRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.getMembershipRequest(membershipRequestId);
	}

	/**
	* Gets a range of all the membership requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of membership requests to return
	* @param end the upper bound of the range of membership requests to return (not inclusive)
	* @return the range of membership requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.MembershipRequest> getMembershipRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.getMembershipRequests(start, end);
	}

	/**
	* Gets the number of membership requests.
	*
	* @return the number of membership requests
	* @throws SystemException if a system exception occurred
	*/
	public int getMembershipRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.getMembershipRequestsCount();
	}

	/**
	* Updates the membership request in the database. Also notifies the appropriate model listeners.
	*
	* @param membershipRequest the membership request to update
	* @return the membership request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.MembershipRequest updateMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.updateMembershipRequest(membershipRequest);
	}

	/**
	* Updates the membership request in the database. Also notifies the appropriate model listeners.
	*
	* @param membershipRequest the membership request to update
	* @param merge whether to merge the membership request with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the membership request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.MembershipRequest updateMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.updateMembershipRequest(membershipRequest,
			merge);
	}

	public com.liferay.portal.model.MembershipRequest addMembershipRequest(
		long userId, long groupId, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.addMembershipRequest(userId,
			groupId, comments);
	}

	public void deleteMembershipRequests(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.deleteMembershipRequests(groupId);
	}

	public void deleteMembershipRequests(long groupId, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.deleteMembershipRequests(groupId,
			statusId);
	}

	public void deleteMembershipRequestsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.deleteMembershipRequestsByUserId(userId);
	}

	public java.util.List<com.liferay.portal.model.MembershipRequest> search(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.search(groupId, status, start, end);
	}

	public int searchCount(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipRequestLocalService.searchCount(groupId, status);
	}

	public void updateStatus(long replierUserId, long membershipRequestId,
		java.lang.String replyComments, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_membershipRequestLocalService.updateStatus(replierUserId,
			membershipRequestId, replyComments, statusId);
	}

	public MembershipRequestLocalService getWrappedMembershipRequestLocalService() {
		return _membershipRequestLocalService;
	}

	public void setWrappedMembershipRequestLocalService(
		MembershipRequestLocalService membershipRequestLocalService) {
		_membershipRequestLocalService = membershipRequestLocalService;
	}

	private MembershipRequestLocalService _membershipRequestLocalService;
}