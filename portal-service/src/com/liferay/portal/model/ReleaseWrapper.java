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
 * This class is a wrapper for {@link Release}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Release
 * @generated
 */
public class ReleaseWrapper implements Release {
	public ReleaseWrapper(Release release) {
		_release = release;
	}

	/**
	* Gets the primary key of this release.
	*
	* @return the primary key of this release
	*/
	public long getPrimaryKey() {
		return _release.getPrimaryKey();
	}

	/**
	* Sets the primary key of this release
	*
	* @param pk the primary key of this release
	*/
	public void setPrimaryKey(long pk) {
		_release.setPrimaryKey(pk);
	}

	/**
	* Gets the release id of this release.
	*
	* @return the release id of this release
	*/
	public long getReleaseId() {
		return _release.getReleaseId();
	}

	/**
	* Sets the release id of this release.
	*
	* @param releaseId the release id of this release
	*/
	public void setReleaseId(long releaseId) {
		_release.setReleaseId(releaseId);
	}

	/**
	* Gets the create date of this release.
	*
	* @return the create date of this release
	*/
	public java.util.Date getCreateDate() {
		return _release.getCreateDate();
	}

	/**
	* Sets the create date of this release.
	*
	* @param createDate the create date of this release
	*/
	public void setCreateDate(java.util.Date createDate) {
		_release.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this release.
	*
	* @return the modified date of this release
	*/
	public java.util.Date getModifiedDate() {
		return _release.getModifiedDate();
	}

	/**
	* Sets the modified date of this release.
	*
	* @param modifiedDate the modified date of this release
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_release.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the servlet context name of this release.
	*
	* @return the servlet context name of this release
	*/
	public java.lang.String getServletContextName() {
		return _release.getServletContextName();
	}

	/**
	* Sets the servlet context name of this release.
	*
	* @param servletContextName the servlet context name of this release
	*/
	public void setServletContextName(java.lang.String servletContextName) {
		_release.setServletContextName(servletContextName);
	}

	/**
	* Gets the build number of this release.
	*
	* @return the build number of this release
	*/
	public int getBuildNumber() {
		return _release.getBuildNumber();
	}

	/**
	* Sets the build number of this release.
	*
	* @param buildNumber the build number of this release
	*/
	public void setBuildNumber(int buildNumber) {
		_release.setBuildNumber(buildNumber);
	}

	/**
	* Gets the build date of this release.
	*
	* @return the build date of this release
	*/
	public java.util.Date getBuildDate() {
		return _release.getBuildDate();
	}

	/**
	* Sets the build date of this release.
	*
	* @param buildDate the build date of this release
	*/
	public void setBuildDate(java.util.Date buildDate) {
		_release.setBuildDate(buildDate);
	}

	/**
	* Gets the verified of this release.
	*
	* @return the verified of this release
	*/
	public boolean getVerified() {
		return _release.getVerified();
	}

	/**
	* Determines if this release is verified.
	*
	* @return <code>true</code> if this release is verified; <code>false</code> otherwise
	*/
	public boolean isVerified() {
		return _release.isVerified();
	}

	/**
	* Sets whether this release is verified.
	*
	* @param verified the verified of this release
	*/
	public void setVerified(boolean verified) {
		_release.setVerified(verified);
	}

	/**
	* Gets the test string of this release.
	*
	* @return the test string of this release
	*/
	public java.lang.String getTestString() {
		return _release.getTestString();
	}

	/**
	* Sets the test string of this release.
	*
	* @param testString the test string of this release
	*/
	public void setTestString(java.lang.String testString) {
		_release.setTestString(testString);
	}

	public boolean isNew() {
		return _release.isNew();
	}

	public void setNew(boolean n) {
		_release.setNew(n);
	}

	public boolean isCachedModel() {
		return _release.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_release.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _release.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_release.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _release.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _release.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_release.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ReleaseWrapper((Release)_release.clone());
	}

	public int compareTo(com.liferay.portal.model.Release release) {
		return _release.compareTo(release);
	}

	public int hashCode() {
		return _release.hashCode();
	}

	public com.liferay.portal.model.Release toEscapedModel() {
		return new ReleaseWrapper(_release.toEscapedModel());
	}

	public java.lang.String toString() {
		return _release.toString();
	}

	public java.lang.String toXmlString() {
		return _release.toXmlString();
	}

	public Release getWrappedRelease() {
		return _release;
	}

	private Release _release;
}