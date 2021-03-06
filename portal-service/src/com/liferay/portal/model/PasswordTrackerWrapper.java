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
 * This class is a wrapper for {@link PasswordTracker}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PasswordTracker
 * @generated
 */
public class PasswordTrackerWrapper implements PasswordTracker {
	public PasswordTrackerWrapper(PasswordTracker passwordTracker) {
		_passwordTracker = passwordTracker;
	}

	/**
	* Gets the primary key of this password tracker.
	*
	* @return the primary key of this password tracker
	*/
	public long getPrimaryKey() {
		return _passwordTracker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this password tracker
	*
	* @param pk the primary key of this password tracker
	*/
	public void setPrimaryKey(long pk) {
		_passwordTracker.setPrimaryKey(pk);
	}

	/**
	* Gets the password tracker id of this password tracker.
	*
	* @return the password tracker id of this password tracker
	*/
	public long getPasswordTrackerId() {
		return _passwordTracker.getPasswordTrackerId();
	}

	/**
	* Sets the password tracker id of this password tracker.
	*
	* @param passwordTrackerId the password tracker id of this password tracker
	*/
	public void setPasswordTrackerId(long passwordTrackerId) {
		_passwordTracker.setPasswordTrackerId(passwordTrackerId);
	}

	/**
	* Gets the user id of this password tracker.
	*
	* @return the user id of this password tracker
	*/
	public long getUserId() {
		return _passwordTracker.getUserId();
	}

	/**
	* Sets the user id of this password tracker.
	*
	* @param userId the user id of this password tracker
	*/
	public void setUserId(long userId) {
		_passwordTracker.setUserId(userId);
	}

	/**
	* Gets the user uuid of this password tracker.
	*
	* @return the user uuid of this password tracker
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordTracker.getUserUuid();
	}

	/**
	* Sets the user uuid of this password tracker.
	*
	* @param userUuid the user uuid of this password tracker
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_passwordTracker.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this password tracker.
	*
	* @return the create date of this password tracker
	*/
	public java.util.Date getCreateDate() {
		return _passwordTracker.getCreateDate();
	}

	/**
	* Sets the create date of this password tracker.
	*
	* @param createDate the create date of this password tracker
	*/
	public void setCreateDate(java.util.Date createDate) {
		_passwordTracker.setCreateDate(createDate);
	}

	/**
	* Gets the password of this password tracker.
	*
	* @return the password of this password tracker
	*/
	public java.lang.String getPassword() {
		return _passwordTracker.getPassword();
	}

	/**
	* Sets the password of this password tracker.
	*
	* @param password the password of this password tracker
	*/
	public void setPassword(java.lang.String password) {
		_passwordTracker.setPassword(password);
	}

	public boolean isNew() {
		return _passwordTracker.isNew();
	}

	public void setNew(boolean n) {
		_passwordTracker.setNew(n);
	}

	public boolean isCachedModel() {
		return _passwordTracker.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_passwordTracker.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _passwordTracker.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_passwordTracker.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _passwordTracker.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _passwordTracker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_passwordTracker.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new PasswordTrackerWrapper((PasswordTracker)_passwordTracker.clone());
	}

	public int compareTo(
		com.liferay.portal.model.PasswordTracker passwordTracker) {
		return _passwordTracker.compareTo(passwordTracker);
	}

	public int hashCode() {
		return _passwordTracker.hashCode();
	}

	public com.liferay.portal.model.PasswordTracker toEscapedModel() {
		return new PasswordTrackerWrapper(_passwordTracker.toEscapedModel());
	}

	public java.lang.String toString() {
		return _passwordTracker.toString();
	}

	public java.lang.String toXmlString() {
		return _passwordTracker.toXmlString();
	}

	public PasswordTracker getWrappedPasswordTracker() {
		return _passwordTracker;
	}

	private PasswordTracker _passwordTracker;
}