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

package com.liferay.portlet.softwarecatalog.model;

/**
 * <p>
 * This class is a wrapper for {@link SCProductScreenshot}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SCProductScreenshot
 * @generated
 */
public class SCProductScreenshotWrapper implements SCProductScreenshot {
	public SCProductScreenshotWrapper(SCProductScreenshot scProductScreenshot) {
		_scProductScreenshot = scProductScreenshot;
	}

	/**
	* Gets the primary key of this s c product screenshot.
	*
	* @return the primary key of this s c product screenshot
	*/
	public long getPrimaryKey() {
		return _scProductScreenshot.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s c product screenshot
	*
	* @param pk the primary key of this s c product screenshot
	*/
	public void setPrimaryKey(long pk) {
		_scProductScreenshot.setPrimaryKey(pk);
	}

	/**
	* Gets the product screenshot id of this s c product screenshot.
	*
	* @return the product screenshot id of this s c product screenshot
	*/
	public long getProductScreenshotId() {
		return _scProductScreenshot.getProductScreenshotId();
	}

	/**
	* Sets the product screenshot id of this s c product screenshot.
	*
	* @param productScreenshotId the product screenshot id of this s c product screenshot
	*/
	public void setProductScreenshotId(long productScreenshotId) {
		_scProductScreenshot.setProductScreenshotId(productScreenshotId);
	}

	/**
	* Gets the company id of this s c product screenshot.
	*
	* @return the company id of this s c product screenshot
	*/
	public long getCompanyId() {
		return _scProductScreenshot.getCompanyId();
	}

	/**
	* Sets the company id of this s c product screenshot.
	*
	* @param companyId the company id of this s c product screenshot
	*/
	public void setCompanyId(long companyId) {
		_scProductScreenshot.setCompanyId(companyId);
	}

	/**
	* Gets the group id of this s c product screenshot.
	*
	* @return the group id of this s c product screenshot
	*/
	public long getGroupId() {
		return _scProductScreenshot.getGroupId();
	}

	/**
	* Sets the group id of this s c product screenshot.
	*
	* @param groupId the group id of this s c product screenshot
	*/
	public void setGroupId(long groupId) {
		_scProductScreenshot.setGroupId(groupId);
	}

	/**
	* Gets the product entry id of this s c product screenshot.
	*
	* @return the product entry id of this s c product screenshot
	*/
	public long getProductEntryId() {
		return _scProductScreenshot.getProductEntryId();
	}

	/**
	* Sets the product entry id of this s c product screenshot.
	*
	* @param productEntryId the product entry id of this s c product screenshot
	*/
	public void setProductEntryId(long productEntryId) {
		_scProductScreenshot.setProductEntryId(productEntryId);
	}

	/**
	* Gets the thumbnail id of this s c product screenshot.
	*
	* @return the thumbnail id of this s c product screenshot
	*/
	public long getThumbnailId() {
		return _scProductScreenshot.getThumbnailId();
	}

	/**
	* Sets the thumbnail id of this s c product screenshot.
	*
	* @param thumbnailId the thumbnail id of this s c product screenshot
	*/
	public void setThumbnailId(long thumbnailId) {
		_scProductScreenshot.setThumbnailId(thumbnailId);
	}

	/**
	* Gets the full image id of this s c product screenshot.
	*
	* @return the full image id of this s c product screenshot
	*/
	public long getFullImageId() {
		return _scProductScreenshot.getFullImageId();
	}

	/**
	* Sets the full image id of this s c product screenshot.
	*
	* @param fullImageId the full image id of this s c product screenshot
	*/
	public void setFullImageId(long fullImageId) {
		_scProductScreenshot.setFullImageId(fullImageId);
	}

	/**
	* Gets the priority of this s c product screenshot.
	*
	* @return the priority of this s c product screenshot
	*/
	public int getPriority() {
		return _scProductScreenshot.getPriority();
	}

	/**
	* Sets the priority of this s c product screenshot.
	*
	* @param priority the priority of this s c product screenshot
	*/
	public void setPriority(int priority) {
		_scProductScreenshot.setPriority(priority);
	}

	public boolean isNew() {
		return _scProductScreenshot.isNew();
	}

	public void setNew(boolean n) {
		_scProductScreenshot.setNew(n);
	}

	public boolean isCachedModel() {
		return _scProductScreenshot.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_scProductScreenshot.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _scProductScreenshot.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_scProductScreenshot.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _scProductScreenshot.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scProductScreenshot.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scProductScreenshot.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SCProductScreenshotWrapper((SCProductScreenshot)_scProductScreenshot.clone());
	}

	public int compareTo(
		com.liferay.portlet.softwarecatalog.model.SCProductScreenshot scProductScreenshot) {
		return _scProductScreenshot.compareTo(scProductScreenshot);
	}

	public int hashCode() {
		return _scProductScreenshot.hashCode();
	}

	public com.liferay.portlet.softwarecatalog.model.SCProductScreenshot toEscapedModel() {
		return new SCProductScreenshotWrapper(_scProductScreenshot.toEscapedModel());
	}

	public java.lang.String toString() {
		return _scProductScreenshot.toString();
	}

	public java.lang.String toXmlString() {
		return _scProductScreenshot.toXmlString();
	}

	public SCProductScreenshot getWrappedSCProductScreenshot() {
		return _scProductScreenshot;
	}

	private SCProductScreenshot _scProductScreenshot;
}