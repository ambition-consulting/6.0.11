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

package com.liferay.portlet.social.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the social equity user local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityUserLocalServiceUtil
 * @see com.liferay.portlet.social.service.base.SocialEquityUserLocalServiceBaseImpl
 * @see com.liferay.portlet.social.service.impl.SocialEquityUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SocialEquityUserLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialEquityUserLocalServiceUtil} to access the social equity user local service. Add custom service methods to {@link com.liferay.portlet.social.service.impl.SocialEquityUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the social equity user to the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityUser the social equity user to add
	* @return the social equity user that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityUser addSocialEquityUser(
		com.liferay.portlet.social.model.SocialEquityUser socialEquityUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new social equity user with the primary key. Does not add the social equity user to the database.
	*
	* @param equityUserId the primary key for the new social equity user
	* @return the new social equity user
	*/
	public com.liferay.portlet.social.model.SocialEquityUser createSocialEquityUser(
		long equityUserId);

	/**
	* Deletes the social equity user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param equityUserId the primary key of the social equity user to delete
	* @throws PortalException if a social equity user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSocialEquityUser(long equityUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the social equity user from the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityUser the social equity user to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSocialEquityUser(
		com.liferay.portlet.social.model.SocialEquityUser socialEquityUser)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the social equity user with the primary key.
	*
	* @param equityUserId the primary key of the social equity user to get
	* @return the social equity user
	* @throws PortalException if a social equity user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.social.model.SocialEquityUser getSocialEquityUser(
		long equityUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the social equity users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of social equity users to return
	* @param end the upper bound of the range of social equity users to return (not inclusive)
	* @return the range of social equity users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.social.model.SocialEquityUser> getSocialEquityUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of social equity users.
	*
	* @return the number of social equity users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSocialEquityUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the social equity user in the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityUser the social equity user to update
	* @return the social equity user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityUser updateSocialEquityUser(
		com.liferay.portlet.social.model.SocialEquityUser socialEquityUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the social equity user in the database. Also notifies the appropriate model listeners.
	*
	* @param socialEquityUser the social equity user to update
	* @param merge whether to merge the social equity user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the social equity user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.social.model.SocialEquityUser updateSocialEquityUser(
		com.liferay.portlet.social.model.SocialEquityUser socialEquityUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.social.model.SocialEquityValue getContributionEquity(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portlet.social.model.SocialEquityValue getParticipationEquity(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRank(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.social.model.SocialEquityUser> getRankedEquityUsers(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRankedEquityUsersCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;
}