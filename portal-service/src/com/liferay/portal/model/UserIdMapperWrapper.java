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

package com.liferay.portal.model;

/**
 * <p>
 * This class is a wrapper for {@link UserIdMapper}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserIdMapper
 * @generated
 */
public class UserIdMapperWrapper implements UserIdMapper {
	public UserIdMapperWrapper(UserIdMapper userIdMapper) {
		_userIdMapper = userIdMapper;
	}

	/**
	* Gets the primary key of this user id mapper.
	*
	* @return the primary key of this user id mapper
	*/
	public long getPrimaryKey() {
		return _userIdMapper.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user id mapper
	*
	* @param pk the primary key of this user id mapper
	*/
	public void setPrimaryKey(long pk) {
		_userIdMapper.setPrimaryKey(pk);
	}

	/**
	* Gets the user id mapper id of this user id mapper.
	*
	* @return the user id mapper id of this user id mapper
	*/
	public long getUserIdMapperId() {
		return _userIdMapper.getUserIdMapperId();
	}

	/**
	* Sets the user id mapper id of this user id mapper.
	*
	* @param userIdMapperId the user id mapper id of this user id mapper
	*/
	public void setUserIdMapperId(long userIdMapperId) {
		_userIdMapper.setUserIdMapperId(userIdMapperId);
	}

	/**
	* Gets the user id of this user id mapper.
	*
	* @return the user id of this user id mapper
	*/
	public long getUserId() {
		return _userIdMapper.getUserId();
	}

	/**
	* Sets the user id of this user id mapper.
	*
	* @param userId the user id of this user id mapper
	*/
	public void setUserId(long userId) {
		_userIdMapper.setUserId(userId);
	}

	/**
	* Gets the user uuid of this user id mapper.
	*
	* @return the user uuid of this user id mapper
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userIdMapper.getUserUuid();
	}

	/**
	* Sets the user uuid of this user id mapper.
	*
	* @param userUuid the user uuid of this user id mapper
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userIdMapper.setUserUuid(userUuid);
	}

	/**
	* Gets the type of this user id mapper.
	*
	* @return the type of this user id mapper
	*/
	public java.lang.String getType() {
		return _userIdMapper.getType();
	}

	/**
	* Sets the type of this user id mapper.
	*
	* @param type the type of this user id mapper
	*/
	public void setType(java.lang.String type) {
		_userIdMapper.setType(type);
	}

	/**
	* Gets the description of this user id mapper.
	*
	* @return the description of this user id mapper
	*/
	public java.lang.String getDescription() {
		return _userIdMapper.getDescription();
	}

	/**
	* Sets the description of this user id mapper.
	*
	* @param description the description of this user id mapper
	*/
	public void setDescription(java.lang.String description) {
		_userIdMapper.setDescription(description);
	}

	/**
	* Gets the external user id of this user id mapper.
	*
	* @return the external user id of this user id mapper
	*/
	public java.lang.String getExternalUserId() {
		return _userIdMapper.getExternalUserId();
	}

	/**
	* Sets the external user id of this user id mapper.
	*
	* @param externalUserId the external user id of this user id mapper
	*/
	public void setExternalUserId(java.lang.String externalUserId) {
		_userIdMapper.setExternalUserId(externalUserId);
	}

	public boolean isNew() {
		return _userIdMapper.isNew();
	}

	public void setNew(boolean n) {
		_userIdMapper.setNew(n);
	}

	public boolean isCachedModel() {
		return _userIdMapper.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userIdMapper.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userIdMapper.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_userIdMapper.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userIdMapper.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userIdMapper.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userIdMapper.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new UserIdMapperWrapper((UserIdMapper)_userIdMapper.clone());
	}

	public int compareTo(com.liferay.portal.model.UserIdMapper userIdMapper) {
		return _userIdMapper.compareTo(userIdMapper);
	}

	public int hashCode() {
		return _userIdMapper.hashCode();
	}

	public com.liferay.portal.model.UserIdMapper toEscapedModel() {
		return new UserIdMapperWrapper(_userIdMapper.toEscapedModel());
	}

	public java.lang.String toString() {
		return _userIdMapper.toString();
	}

	public java.lang.String toXmlString() {
		return _userIdMapper.toXmlString();
	}

	public UserIdMapper getWrappedUserIdMapper() {
		return _userIdMapper;
	}

	private UserIdMapper _userIdMapper;
}