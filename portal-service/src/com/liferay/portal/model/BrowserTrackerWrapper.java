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
 * This class is a wrapper for {@link BrowserTracker}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BrowserTracker
 * @generated
 */
public class BrowserTrackerWrapper implements BrowserTracker {
	public BrowserTrackerWrapper(BrowserTracker browserTracker) {
		_browserTracker = browserTracker;
	}

	/**
	* Gets the primary key of this browser tracker.
	*
	* @return the primary key of this browser tracker
	*/
	public long getPrimaryKey() {
		return _browserTracker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this browser tracker
	*
	* @param pk the primary key of this browser tracker
	*/
	public void setPrimaryKey(long pk) {
		_browserTracker.setPrimaryKey(pk);
	}

	/**
	* Gets the browser tracker id of this browser tracker.
	*
	* @return the browser tracker id of this browser tracker
	*/
	public long getBrowserTrackerId() {
		return _browserTracker.getBrowserTrackerId();
	}

	/**
	* Sets the browser tracker id of this browser tracker.
	*
	* @param browserTrackerId the browser tracker id of this browser tracker
	*/
	public void setBrowserTrackerId(long browserTrackerId) {
		_browserTracker.setBrowserTrackerId(browserTrackerId);
	}

	/**
	* Gets the user id of this browser tracker.
	*
	* @return the user id of this browser tracker
	*/
	public long getUserId() {
		return _browserTracker.getUserId();
	}

	/**
	* Sets the user id of this browser tracker.
	*
	* @param userId the user id of this browser tracker
	*/
	public void setUserId(long userId) {
		_browserTracker.setUserId(userId);
	}

	/**
	* Gets the user uuid of this browser tracker.
	*
	* @return the user uuid of this browser tracker
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _browserTracker.getUserUuid();
	}

	/**
	* Sets the user uuid of this browser tracker.
	*
	* @param userUuid the user uuid of this browser tracker
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_browserTracker.setUserUuid(userUuid);
	}

	/**
	* Gets the browser key of this browser tracker.
	*
	* @return the browser key of this browser tracker
	*/
	public long getBrowserKey() {
		return _browserTracker.getBrowserKey();
	}

	/**
	* Sets the browser key of this browser tracker.
	*
	* @param browserKey the browser key of this browser tracker
	*/
	public void setBrowserKey(long browserKey) {
		_browserTracker.setBrowserKey(browserKey);
	}

	public boolean isNew() {
		return _browserTracker.isNew();
	}

	public void setNew(boolean n) {
		_browserTracker.setNew(n);
	}

	public boolean isCachedModel() {
		return _browserTracker.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_browserTracker.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _browserTracker.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_browserTracker.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _browserTracker.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _browserTracker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_browserTracker.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new BrowserTrackerWrapper((BrowserTracker)_browserTracker.clone());
	}

	public int compareTo(com.liferay.portal.model.BrowserTracker browserTracker) {
		return _browserTracker.compareTo(browserTracker);
	}

	public int hashCode() {
		return _browserTracker.hashCode();
	}

	public com.liferay.portal.model.BrowserTracker toEscapedModel() {
		return new BrowserTrackerWrapper(_browserTracker.toEscapedModel());
	}

	public java.lang.String toString() {
		return _browserTracker.toString();
	}

	public java.lang.String toXmlString() {
		return _browserTracker.toXmlString();
	}

	public BrowserTracker getWrappedBrowserTracker() {
		return _browserTracker;
	}

	private BrowserTracker _browserTracker;
}