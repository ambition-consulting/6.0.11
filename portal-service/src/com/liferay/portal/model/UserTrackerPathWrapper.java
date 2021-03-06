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
 * This class is a wrapper for {@link UserTrackerPath}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       UserTrackerPath
 * @generated
 */
public class UserTrackerPathWrapper implements UserTrackerPath {
	public UserTrackerPathWrapper(UserTrackerPath userTrackerPath) {
		_userTrackerPath = userTrackerPath;
	}

	/**
	* Gets the primary key of this user tracker path.
	*
	* @return the primary key of this user tracker path
	*/
	public long getPrimaryKey() {
		return _userTrackerPath.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user tracker path
	*
	* @param pk the primary key of this user tracker path
	*/
	public void setPrimaryKey(long pk) {
		_userTrackerPath.setPrimaryKey(pk);
	}

	/**
	* Gets the user tracker path id of this user tracker path.
	*
	* @return the user tracker path id of this user tracker path
	*/
	public long getUserTrackerPathId() {
		return _userTrackerPath.getUserTrackerPathId();
	}

	/**
	* Sets the user tracker path id of this user tracker path.
	*
	* @param userTrackerPathId the user tracker path id of this user tracker path
	*/
	public void setUserTrackerPathId(long userTrackerPathId) {
		_userTrackerPath.setUserTrackerPathId(userTrackerPathId);
	}

	/**
	* Gets the user tracker id of this user tracker path.
	*
	* @return the user tracker id of this user tracker path
	*/
	public long getUserTrackerId() {
		return _userTrackerPath.getUserTrackerId();
	}

	/**
	* Sets the user tracker id of this user tracker path.
	*
	* @param userTrackerId the user tracker id of this user tracker path
	*/
	public void setUserTrackerId(long userTrackerId) {
		_userTrackerPath.setUserTrackerId(userTrackerId);
	}

	/**
	* Gets the path of this user tracker path.
	*
	* @return the path of this user tracker path
	*/
	public java.lang.String getPath() {
		return _userTrackerPath.getPath();
	}

	/**
	* Sets the path of this user tracker path.
	*
	* @param path the path of this user tracker path
	*/
	public void setPath(java.lang.String path) {
		_userTrackerPath.setPath(path);
	}

	/**
	* Gets the path date of this user tracker path.
	*
	* @return the path date of this user tracker path
	*/
	public java.util.Date getPathDate() {
		return _userTrackerPath.getPathDate();
	}

	/**
	* Sets the path date of this user tracker path.
	*
	* @param pathDate the path date of this user tracker path
	*/
	public void setPathDate(java.util.Date pathDate) {
		_userTrackerPath.setPathDate(pathDate);
	}

	public boolean isNew() {
		return _userTrackerPath.isNew();
	}

	public void setNew(boolean n) {
		_userTrackerPath.setNew(n);
	}

	public boolean isCachedModel() {
		return _userTrackerPath.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userTrackerPath.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userTrackerPath.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_userTrackerPath.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userTrackerPath.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userTrackerPath.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userTrackerPath.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new UserTrackerPathWrapper((UserTrackerPath)_userTrackerPath.clone());
	}

	public int compareTo(
		com.liferay.portal.model.UserTrackerPath userTrackerPath) {
		return _userTrackerPath.compareTo(userTrackerPath);
	}

	public int hashCode() {
		return _userTrackerPath.hashCode();
	}

	public com.liferay.portal.model.UserTrackerPath toEscapedModel() {
		return new UserTrackerPathWrapper(_userTrackerPath.toEscapedModel());
	}

	public java.lang.String toString() {
		return _userTrackerPath.toString();
	}

	public java.lang.String toXmlString() {
		return _userTrackerPath.toXmlString();
	}

	public UserTrackerPath getWrappedUserTrackerPath() {
		return _userTrackerPath;
	}

	private UserTrackerPath _userTrackerPath;
}