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
 * This class is a wrapper for {@link ShoppingCoupon}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCoupon
 * @generated
 */
public class ShoppingCouponWrapper implements ShoppingCoupon {
	public ShoppingCouponWrapper(ShoppingCoupon shoppingCoupon) {
		_shoppingCoupon = shoppingCoupon;
	}

	/**
	* Gets the primary key of this shopping coupon.
	*
	* @return the primary key of this shopping coupon
	*/
	public long getPrimaryKey() {
		return _shoppingCoupon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping coupon
	*
	* @param pk the primary key of this shopping coupon
	*/
	public void setPrimaryKey(long pk) {
		_shoppingCoupon.setPrimaryKey(pk);
	}

	/**
	* Gets the coupon id of this shopping coupon.
	*
	* @return the coupon id of this shopping coupon
	*/
	public long getCouponId() {
		return _shoppingCoupon.getCouponId();
	}

	/**
	* Sets the coupon id of this shopping coupon.
	*
	* @param couponId the coupon id of this shopping coupon
	*/
	public void setCouponId(long couponId) {
		_shoppingCoupon.setCouponId(couponId);
	}

	/**
	* Gets the group id of this shopping coupon.
	*
	* @return the group id of this shopping coupon
	*/
	public long getGroupId() {
		return _shoppingCoupon.getGroupId();
	}

	/**
	* Sets the group id of this shopping coupon.
	*
	* @param groupId the group id of this shopping coupon
	*/
	public void setGroupId(long groupId) {
		_shoppingCoupon.setGroupId(groupId);
	}

	/**
	* Gets the company id of this shopping coupon.
	*
	* @return the company id of this shopping coupon
	*/
	public long getCompanyId() {
		return _shoppingCoupon.getCompanyId();
	}

	/**
	* Sets the company id of this shopping coupon.
	*
	* @param companyId the company id of this shopping coupon
	*/
	public void setCompanyId(long companyId) {
		_shoppingCoupon.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this shopping coupon.
	*
	* @return the user id of this shopping coupon
	*/
	public long getUserId() {
		return _shoppingCoupon.getUserId();
	}

	/**
	* Sets the user id of this shopping coupon.
	*
	* @param userId the user id of this shopping coupon
	*/
	public void setUserId(long userId) {
		_shoppingCoupon.setUserId(userId);
	}

	/**
	* Gets the user uuid of this shopping coupon.
	*
	* @return the user uuid of this shopping coupon
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCoupon.getUserUuid();
	}

	/**
	* Sets the user uuid of this shopping coupon.
	*
	* @param userUuid the user uuid of this shopping coupon
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCoupon.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this shopping coupon.
	*
	* @return the user name of this shopping coupon
	*/
	public java.lang.String getUserName() {
		return _shoppingCoupon.getUserName();
	}

	/**
	* Sets the user name of this shopping coupon.
	*
	* @param userName the user name of this shopping coupon
	*/
	public void setUserName(java.lang.String userName) {
		_shoppingCoupon.setUserName(userName);
	}

	/**
	* Gets the create date of this shopping coupon.
	*
	* @return the create date of this shopping coupon
	*/
	public java.util.Date getCreateDate() {
		return _shoppingCoupon.getCreateDate();
	}

	/**
	* Sets the create date of this shopping coupon.
	*
	* @param createDate the create date of this shopping coupon
	*/
	public void setCreateDate(java.util.Date createDate) {
		_shoppingCoupon.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this shopping coupon.
	*
	* @return the modified date of this shopping coupon
	*/
	public java.util.Date getModifiedDate() {
		return _shoppingCoupon.getModifiedDate();
	}

	/**
	* Sets the modified date of this shopping coupon.
	*
	* @param modifiedDate the modified date of this shopping coupon
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCoupon.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the code of this shopping coupon.
	*
	* @return the code of this shopping coupon
	*/
	public java.lang.String getCode() {
		return _shoppingCoupon.getCode();
	}

	/**
	* Sets the code of this shopping coupon.
	*
	* @param code the code of this shopping coupon
	*/
	public void setCode(java.lang.String code) {
		_shoppingCoupon.setCode(code);
	}

	/**
	* Gets the name of this shopping coupon.
	*
	* @return the name of this shopping coupon
	*/
	public java.lang.String getName() {
		return _shoppingCoupon.getName();
	}

	/**
	* Sets the name of this shopping coupon.
	*
	* @param name the name of this shopping coupon
	*/
	public void setName(java.lang.String name) {
		_shoppingCoupon.setName(name);
	}

	/**
	* Gets the description of this shopping coupon.
	*
	* @return the description of this shopping coupon
	*/
	public java.lang.String getDescription() {
		return _shoppingCoupon.getDescription();
	}

	/**
	* Sets the description of this shopping coupon.
	*
	* @param description the description of this shopping coupon
	*/
	public void setDescription(java.lang.String description) {
		_shoppingCoupon.setDescription(description);
	}

	/**
	* Gets the start date of this shopping coupon.
	*
	* @return the start date of this shopping coupon
	*/
	public java.util.Date getStartDate() {
		return _shoppingCoupon.getStartDate();
	}

	/**
	* Sets the start date of this shopping coupon.
	*
	* @param startDate the start date of this shopping coupon
	*/
	public void setStartDate(java.util.Date startDate) {
		_shoppingCoupon.setStartDate(startDate);
	}

	/**
	* Gets the end date of this shopping coupon.
	*
	* @return the end date of this shopping coupon
	*/
	public java.util.Date getEndDate() {
		return _shoppingCoupon.getEndDate();
	}

	/**
	* Sets the end date of this shopping coupon.
	*
	* @param endDate the end date of this shopping coupon
	*/
	public void setEndDate(java.util.Date endDate) {
		_shoppingCoupon.setEndDate(endDate);
	}

	/**
	* Gets the active of this shopping coupon.
	*
	* @return the active of this shopping coupon
	*/
	public boolean getActive() {
		return _shoppingCoupon.getActive();
	}

	/**
	* Determines if this shopping coupon is active.
	*
	* @return <code>true</code> if this shopping coupon is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _shoppingCoupon.isActive();
	}

	/**
	* Sets whether this shopping coupon is active.
	*
	* @param active the active of this shopping coupon
	*/
	public void setActive(boolean active) {
		_shoppingCoupon.setActive(active);
	}

	/**
	* Gets the limit categories of this shopping coupon.
	*
	* @return the limit categories of this shopping coupon
	*/
	public java.lang.String getLimitCategories() {
		return _shoppingCoupon.getLimitCategories();
	}

	/**
	* Sets the limit categories of this shopping coupon.
	*
	* @param limitCategories the limit categories of this shopping coupon
	*/
	public void setLimitCategories(java.lang.String limitCategories) {
		_shoppingCoupon.setLimitCategories(limitCategories);
	}

	/**
	* Gets the limit skus of this shopping coupon.
	*
	* @return the limit skus of this shopping coupon
	*/
	public java.lang.String getLimitSkus() {
		return _shoppingCoupon.getLimitSkus();
	}

	/**
	* Sets the limit skus of this shopping coupon.
	*
	* @param limitSkus the limit skus of this shopping coupon
	*/
	public void setLimitSkus(java.lang.String limitSkus) {
		_shoppingCoupon.setLimitSkus(limitSkus);
	}

	/**
	* Gets the min order of this shopping coupon.
	*
	* @return the min order of this shopping coupon
	*/
	public double getMinOrder() {
		return _shoppingCoupon.getMinOrder();
	}

	/**
	* Sets the min order of this shopping coupon.
	*
	* @param minOrder the min order of this shopping coupon
	*/
	public void setMinOrder(double minOrder) {
		_shoppingCoupon.setMinOrder(minOrder);
	}

	/**
	* Gets the discount of this shopping coupon.
	*
	* @return the discount of this shopping coupon
	*/
	public double getDiscount() {
		return _shoppingCoupon.getDiscount();
	}

	/**
	* Sets the discount of this shopping coupon.
	*
	* @param discount the discount of this shopping coupon
	*/
	public void setDiscount(double discount) {
		_shoppingCoupon.setDiscount(discount);
	}

	/**
	* Gets the discount type of this shopping coupon.
	*
	* @return the discount type of this shopping coupon
	*/
	public java.lang.String getDiscountType() {
		return _shoppingCoupon.getDiscountType();
	}

	/**
	* Sets the discount type of this shopping coupon.
	*
	* @param discountType the discount type of this shopping coupon
	*/
	public void setDiscountType(java.lang.String discountType) {
		_shoppingCoupon.setDiscountType(discountType);
	}

	public boolean isNew() {
		return _shoppingCoupon.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCoupon.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCoupon.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCoupon.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCoupon.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCoupon.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCoupon.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCoupon.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCoupon.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ShoppingCouponWrapper((ShoppingCoupon)_shoppingCoupon.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingCoupon shoppingCoupon) {
		return _shoppingCoupon.compareTo(shoppingCoupon);
	}

	public int hashCode() {
		return _shoppingCoupon.hashCode();
	}

	public com.liferay.portlet.shopping.model.ShoppingCoupon toEscapedModel() {
		return new ShoppingCouponWrapper(_shoppingCoupon.toEscapedModel());
	}

	public java.lang.String toString() {
		return _shoppingCoupon.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCoupon.toXmlString();
	}

	public boolean hasValidDateRange() {
		return _shoppingCoupon.hasValidDateRange();
	}

	public boolean hasValidEndDate() {
		return _shoppingCoupon.hasValidEndDate();
	}

	public boolean hasValidStartDate() {
		return _shoppingCoupon.hasValidStartDate();
	}

	public ShoppingCoupon getWrappedShoppingCoupon() {
		return _shoppingCoupon;
	}

	private ShoppingCoupon _shoppingCoupon;
}