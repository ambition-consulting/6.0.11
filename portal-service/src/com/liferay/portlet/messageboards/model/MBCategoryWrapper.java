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

package com.liferay.portlet.messageboards.model;

/**
 * <p>
 * This class is a wrapper for {@link MBCategory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBCategory
 * @generated
 */
public class MBCategoryWrapper implements MBCategory {
	public MBCategoryWrapper(MBCategory mbCategory) {
		_mbCategory = mbCategory;
	}

	/**
	* Gets the primary key of this message boards category.
	*
	* @return the primary key of this message boards category
	*/
	public long getPrimaryKey() {
		return _mbCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message boards category
	*
	* @param pk the primary key of this message boards category
	*/
	public void setPrimaryKey(long pk) {
		_mbCategory.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this message boards category.
	*
	* @return the uuid of this message boards category
	*/
	public java.lang.String getUuid() {
		return _mbCategory.getUuid();
	}

	/**
	* Sets the uuid of this message boards category.
	*
	* @param uuid the uuid of this message boards category
	*/
	public void setUuid(java.lang.String uuid) {
		_mbCategory.setUuid(uuid);
	}

	/**
	* Gets the category id of this message boards category.
	*
	* @return the category id of this message boards category
	*/
	public long getCategoryId() {
		return _mbCategory.getCategoryId();
	}

	/**
	* Sets the category id of this message boards category.
	*
	* @param categoryId the category id of this message boards category
	*/
	public void setCategoryId(long categoryId) {
		_mbCategory.setCategoryId(categoryId);
	}

	/**
	* Gets the group id of this message boards category.
	*
	* @return the group id of this message boards category
	*/
	public long getGroupId() {
		return _mbCategory.getGroupId();
	}

	/**
	* Sets the group id of this message boards category.
	*
	* @param groupId the group id of this message boards category
	*/
	public void setGroupId(long groupId) {
		_mbCategory.setGroupId(groupId);
	}

	/**
	* Gets the company id of this message boards category.
	*
	* @return the company id of this message boards category
	*/
	public long getCompanyId() {
		return _mbCategory.getCompanyId();
	}

	/**
	* Sets the company id of this message boards category.
	*
	* @param companyId the company id of this message boards category
	*/
	public void setCompanyId(long companyId) {
		_mbCategory.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this message boards category.
	*
	* @return the user id of this message boards category
	*/
	public long getUserId() {
		return _mbCategory.getUserId();
	}

	/**
	* Sets the user id of this message boards category.
	*
	* @param userId the user id of this message boards category
	*/
	public void setUserId(long userId) {
		_mbCategory.setUserId(userId);
	}

	/**
	* Gets the user uuid of this message boards category.
	*
	* @return the user uuid of this message boards category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this message boards category.
	*
	* @param userUuid the user uuid of this message boards category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mbCategory.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this message boards category.
	*
	* @return the user name of this message boards category
	*/
	public java.lang.String getUserName() {
		return _mbCategory.getUserName();
	}

	/**
	* Sets the user name of this message boards category.
	*
	* @param userName the user name of this message boards category
	*/
	public void setUserName(java.lang.String userName) {
		_mbCategory.setUserName(userName);
	}

	/**
	* Gets the create date of this message boards category.
	*
	* @return the create date of this message boards category
	*/
	public java.util.Date getCreateDate() {
		return _mbCategory.getCreateDate();
	}

	/**
	* Sets the create date of this message boards category.
	*
	* @param createDate the create date of this message boards category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_mbCategory.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this message boards category.
	*
	* @return the modified date of this message boards category
	*/
	public java.util.Date getModifiedDate() {
		return _mbCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this message boards category.
	*
	* @param modifiedDate the modified date of this message boards category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mbCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the parent category id of this message boards category.
	*
	* @return the parent category id of this message boards category
	*/
	public long getParentCategoryId() {
		return _mbCategory.getParentCategoryId();
	}

	/**
	* Sets the parent category id of this message boards category.
	*
	* @param parentCategoryId the parent category id of this message boards category
	*/
	public void setParentCategoryId(long parentCategoryId) {
		_mbCategory.setParentCategoryId(parentCategoryId);
	}

	/**
	* Gets the name of this message boards category.
	*
	* @return the name of this message boards category
	*/
	public java.lang.String getName() {
		return _mbCategory.getName();
	}

	/**
	* Sets the name of this message boards category.
	*
	* @param name the name of this message boards category
	*/
	public void setName(java.lang.String name) {
		_mbCategory.setName(name);
	}

	/**
	* Gets the description of this message boards category.
	*
	* @return the description of this message boards category
	*/
	public java.lang.String getDescription() {
		return _mbCategory.getDescription();
	}

	/**
	* Sets the description of this message boards category.
	*
	* @param description the description of this message boards category
	*/
	public void setDescription(java.lang.String description) {
		_mbCategory.setDescription(description);
	}

	/**
	* Gets the thread count of this message boards category.
	*
	* @return the thread count of this message boards category
	*/
	public int getThreadCount() {
		return _mbCategory.getThreadCount();
	}

	/**
	* Sets the thread count of this message boards category.
	*
	* @param threadCount the thread count of this message boards category
	*/
	public void setThreadCount(int threadCount) {
		_mbCategory.setThreadCount(threadCount);
	}

	/**
	* Gets the message count of this message boards category.
	*
	* @return the message count of this message boards category
	*/
	public int getMessageCount() {
		return _mbCategory.getMessageCount();
	}

	/**
	* Sets the message count of this message boards category.
	*
	* @param messageCount the message count of this message boards category
	*/
	public void setMessageCount(int messageCount) {
		_mbCategory.setMessageCount(messageCount);
	}

	/**
	* Gets the last post date of this message boards category.
	*
	* @return the last post date of this message boards category
	*/
	public java.util.Date getLastPostDate() {
		return _mbCategory.getLastPostDate();
	}

	/**
	* Sets the last post date of this message boards category.
	*
	* @param lastPostDate the last post date of this message boards category
	*/
	public void setLastPostDate(java.util.Date lastPostDate) {
		_mbCategory.setLastPostDate(lastPostDate);
	}

	public boolean isNew() {
		return _mbCategory.isNew();
	}

	public void setNew(boolean n) {
		_mbCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _mbCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mbCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mbCategory.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_mbCategory.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mbCategory.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mbCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mbCategory.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new MBCategoryWrapper((MBCategory)_mbCategory.clone());
	}

	public int compareTo(
		com.liferay.portlet.messageboards.model.MBCategory mbCategory) {
		return _mbCategory.compareTo(mbCategory);
	}

	public int hashCode() {
		return _mbCategory.hashCode();
	}

	public com.liferay.portlet.messageboards.model.MBCategory toEscapedModel() {
		return new MBCategoryWrapper(_mbCategory.toEscapedModel());
	}

	public java.lang.String toString() {
		return _mbCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _mbCategory.toXmlString();
	}

	public java.util.List<java.lang.Long> getAncestorCategoryIds()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategory.getAncestorCategoryIds();
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbCategory.getAncestors();
	}

	public boolean isRoot() {
		return _mbCategory.isRoot();
	}

	public MBCategory getWrappedMBCategory() {
		return _mbCategory;
	}

	private MBCategory _mbCategory;
}