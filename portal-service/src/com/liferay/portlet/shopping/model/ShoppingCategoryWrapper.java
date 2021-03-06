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

package com.liferay.portlet.shopping.model;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingCategory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCategory
 * @generated
 */
public class ShoppingCategoryWrapper implements ShoppingCategory {
	public ShoppingCategoryWrapper(ShoppingCategory shoppingCategory) {
		_shoppingCategory = shoppingCategory;
	}

	/**
	* Gets the primary key of this shopping category.
	*
	* @return the primary key of this shopping category
	*/
	public long getPrimaryKey() {
		return _shoppingCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping category
	*
	* @param pk the primary key of this shopping category
	*/
	public void setPrimaryKey(long pk) {
		_shoppingCategory.setPrimaryKey(pk);
	}

	/**
	* Gets the category id of this shopping category.
	*
	* @return the category id of this shopping category
	*/
	public long getCategoryId() {
		return _shoppingCategory.getCategoryId();
	}

	/**
	* Sets the category id of this shopping category.
	*
	* @param categoryId the category id of this shopping category
	*/
	public void setCategoryId(long categoryId) {
		_shoppingCategory.setCategoryId(categoryId);
	}

	/**
	* Gets the group id of this shopping category.
	*
	* @return the group id of this shopping category
	*/
	public long getGroupId() {
		return _shoppingCategory.getGroupId();
	}

	/**
	* Sets the group id of this shopping category.
	*
	* @param groupId the group id of this shopping category
	*/
	public void setGroupId(long groupId) {
		_shoppingCategory.setGroupId(groupId);
	}

	/**
	* Gets the company id of this shopping category.
	*
	* @return the company id of this shopping category
	*/
	public long getCompanyId() {
		return _shoppingCategory.getCompanyId();
	}

	/**
	* Sets the company id of this shopping category.
	*
	* @param companyId the company id of this shopping category
	*/
	public void setCompanyId(long companyId) {
		_shoppingCategory.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this shopping category.
	*
	* @return the user id of this shopping category
	*/
	public long getUserId() {
		return _shoppingCategory.getUserId();
	}

	/**
	* Sets the user id of this shopping category.
	*
	* @param userId the user id of this shopping category
	*/
	public void setUserId(long userId) {
		_shoppingCategory.setUserId(userId);
	}

	/**
	* Gets the user uuid of this shopping category.
	*
	* @return the user uuid of this shopping category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this shopping category.
	*
	* @param userUuid the user uuid of this shopping category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCategory.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this shopping category.
	*
	* @return the user name of this shopping category
	*/
	public java.lang.String getUserName() {
		return _shoppingCategory.getUserName();
	}

	/**
	* Sets the user name of this shopping category.
	*
	* @param userName the user name of this shopping category
	*/
	public void setUserName(java.lang.String userName) {
		_shoppingCategory.setUserName(userName);
	}

	/**
	* Gets the create date of this shopping category.
	*
	* @return the create date of this shopping category
	*/
	public java.util.Date getCreateDate() {
		return _shoppingCategory.getCreateDate();
	}

	/**
	* Sets the create date of this shopping category.
	*
	* @param createDate the create date of this shopping category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_shoppingCategory.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this shopping category.
	*
	* @return the modified date of this shopping category
	*/
	public java.util.Date getModifiedDate() {
		return _shoppingCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this shopping category.
	*
	* @param modifiedDate the modified date of this shopping category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the parent category id of this shopping category.
	*
	* @return the parent category id of this shopping category
	*/
	public long getParentCategoryId() {
		return _shoppingCategory.getParentCategoryId();
	}

	/**
	* Sets the parent category id of this shopping category.
	*
	* @param parentCategoryId the parent category id of this shopping category
	*/
	public void setParentCategoryId(long parentCategoryId) {
		_shoppingCategory.setParentCategoryId(parentCategoryId);
	}

	/**
	* Gets the name of this shopping category.
	*
	* @return the name of this shopping category
	*/
	public java.lang.String getName() {
		return _shoppingCategory.getName();
	}

	/**
	* Sets the name of this shopping category.
	*
	* @param name the name of this shopping category
	*/
	public void setName(java.lang.String name) {
		_shoppingCategory.setName(name);
	}

	/**
	* Gets the description of this shopping category.
	*
	* @return the description of this shopping category
	*/
	public java.lang.String getDescription() {
		return _shoppingCategory.getDescription();
	}

	/**
	* Sets the description of this shopping category.
	*
	* @param description the description of this shopping category
	*/
	public void setDescription(java.lang.String description) {
		_shoppingCategory.setDescription(description);
	}

	public boolean isNew() {
		return _shoppingCategory.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCategory.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCategory.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCategory.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCategory.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ShoppingCategoryWrapper((ShoppingCategory)_shoppingCategory.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingCategory shoppingCategory) {
		return _shoppingCategory.compareTo(shoppingCategory);
	}

	public int hashCode() {
		return _shoppingCategory.hashCode();
	}

	public com.liferay.portlet.shopping.model.ShoppingCategory toEscapedModel() {
		return new ShoppingCategoryWrapper(_shoppingCategory.toEscapedModel());
	}

	public java.lang.String toString() {
		return _shoppingCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCategory.toXmlString();
	}

	public boolean isRoot() {
		return _shoppingCategory.isRoot();
	}

	public ShoppingCategory getWrappedShoppingCategory() {
		return _shoppingCategory;
	}

	private ShoppingCategory _shoppingCategory;
}