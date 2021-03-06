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
 * This class is a wrapper for {@link UserIdMapperLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserIdMapperLocalService
 * @generated
 */
public class UserIdMapperLocalServiceWrapper implements UserIdMapperLocalService {
	public UserIdMapperLocalServiceWrapper(
		UserIdMapperLocalService userIdMapperLocalService) {
		_userIdMapperLocalService = userIdMapperLocalService;
	}

	/**
	* Adds the user id mapper to the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapper the user id mapper to add
	* @return the user id mapper that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserIdMapper addUserIdMapper(
		com.liferay.portal.model.UserIdMapper userIdMapper)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.addUserIdMapper(userIdMapper);
	}

	/**
	* Creates a new user id mapper with the primary key. Does not add the user id mapper to the database.
	*
	* @param userIdMapperId the primary key for the new user id mapper
	* @return the new user id mapper
	*/
	public com.liferay.portal.model.UserIdMapper createUserIdMapper(
		long userIdMapperId) {
		return _userIdMapperLocalService.createUserIdMapper(userIdMapperId);
	}

	/**
	* Deletes the user id mapper with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapperId the primary key of the user id mapper to delete
	* @throws PortalException if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserIdMapper(long userIdMapperId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userIdMapperLocalService.deleteUserIdMapper(userIdMapperId);
	}

	/**
	* Deletes the user id mapper from the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapper the user id mapper to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserIdMapper(
		com.liferay.portal.model.UserIdMapper userIdMapper)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userIdMapperLocalService.deleteUserIdMapper(userIdMapper);
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
		return _userIdMapperLocalService.dynamicQuery(dynamicQuery);
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
		return _userIdMapperLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userIdMapperLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _userIdMapperLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user id mapper with the primary key.
	*
	* @param userIdMapperId the primary key of the user id mapper to get
	* @return the user id mapper
	* @throws PortalException if a user id mapper with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserIdMapper getUserIdMapper(
		long userIdMapperId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMapper(userIdMapperId);
	}

	/**
	* Gets a range of all the user id mappers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user id mappers to return
	* @param end the upper bound of the range of user id mappers to return (not inclusive)
	* @return the range of user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserIdMapper> getUserIdMappers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMappers(start, end);
	}

	/**
	* Gets the number of user id mappers.
	*
	* @return the number of user id mappers
	* @throws SystemException if a system exception occurred
	*/
	public int getUserIdMappersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMappersCount();
	}

	/**
	* Updates the user id mapper in the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapper the user id mapper to update
	* @return the user id mapper that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserIdMapper updateUserIdMapper(
		com.liferay.portal.model.UserIdMapper userIdMapper)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.updateUserIdMapper(userIdMapper);
	}

	/**
	* Updates the user id mapper in the database. Also notifies the appropriate model listeners.
	*
	* @param userIdMapper the user id mapper to update
	* @param merge whether to merge the user id mapper with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user id mapper that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.UserIdMapper updateUserIdMapper(
		com.liferay.portal.model.UserIdMapper userIdMapper, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.updateUserIdMapper(userIdMapper, merge);
	}

	public void deleteUserIdMappers(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userIdMapperLocalService.deleteUserIdMappers(userId);
	}

	public com.liferay.portal.model.UserIdMapper getUserIdMapper(long userId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMapper(userId, type);
	}

	public com.liferay.portal.model.UserIdMapper getUserIdMapperByExternalUserId(
		java.lang.String type, java.lang.String externalUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMapperByExternalUserId(type,
			externalUserId);
	}

	public java.util.List<com.liferay.portal.model.UserIdMapper> getUserIdMappers(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.getUserIdMappers(userId);
	}

	public com.liferay.portal.model.UserIdMapper updateUserIdMapper(
		long userId, java.lang.String type, java.lang.String description,
		java.lang.String externalUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapperLocalService.updateUserIdMapper(userId, type,
			description, externalUserId);
	}

	public UserIdMapperLocalService getWrappedUserIdMapperLocalService() {
		return _userIdMapperLocalService;
	}

	public void setWrappedUserIdMapperLocalService(
		UserIdMapperLocalService userIdMapperLocalService) {
		_userIdMapperLocalService = userIdMapperLocalService;
	}

	private UserIdMapperLocalService _userIdMapperLocalService;
}