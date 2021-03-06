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
 * This class is a wrapper for {@link ShoppingOrderItem}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemWrapper implements ShoppingOrderItem {
	public ShoppingOrderItemWrapper(ShoppingOrderItem shoppingOrderItem) {
		_shoppingOrderItem = shoppingOrderItem;
	}

	/**
	* Gets the primary key of this shopping order item.
	*
	* @return the primary key of this shopping order item
	*/
	public long getPrimaryKey() {
		return _shoppingOrderItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping order item
	*
	* @param pk the primary key of this shopping order item
	*/
	public void setPrimaryKey(long pk) {
		_shoppingOrderItem.setPrimaryKey(pk);
	}

	/**
	* Gets the order item id of this shopping order item.
	*
	* @return the order item id of this shopping order item
	*/
	public long getOrderItemId() {
		return _shoppingOrderItem.getOrderItemId();
	}

	/**
	* Sets the order item id of this shopping order item.
	*
	* @param orderItemId the order item id of this shopping order item
	*/
	public void setOrderItemId(long orderItemId) {
		_shoppingOrderItem.setOrderItemId(orderItemId);
	}

	/**
	* Gets the order id of this shopping order item.
	*
	* @return the order id of this shopping order item
	*/
	public long getOrderId() {
		return _shoppingOrderItem.getOrderId();
	}

	/**
	* Sets the order id of this shopping order item.
	*
	* @param orderId the order id of this shopping order item
	*/
	public void setOrderId(long orderId) {
		_shoppingOrderItem.setOrderId(orderId);
	}

	/**
	* Gets the item id of this shopping order item.
	*
	* @return the item id of this shopping order item
	*/
	public java.lang.String getItemId() {
		return _shoppingOrderItem.getItemId();
	}

	/**
	* Sets the item id of this shopping order item.
	*
	* @param itemId the item id of this shopping order item
	*/
	public void setItemId(java.lang.String itemId) {
		_shoppingOrderItem.setItemId(itemId);
	}

	/**
	* Gets the sku of this shopping order item.
	*
	* @return the sku of this shopping order item
	*/
	public java.lang.String getSku() {
		return _shoppingOrderItem.getSku();
	}

	/**
	* Sets the sku of this shopping order item.
	*
	* @param sku the sku of this shopping order item
	*/
	public void setSku(java.lang.String sku) {
		_shoppingOrderItem.setSku(sku);
	}

	/**
	* Gets the name of this shopping order item.
	*
	* @return the name of this shopping order item
	*/
	public java.lang.String getName() {
		return _shoppingOrderItem.getName();
	}

	/**
	* Sets the name of this shopping order item.
	*
	* @param name the name of this shopping order item
	*/
	public void setName(java.lang.String name) {
		_shoppingOrderItem.setName(name);
	}

	/**
	* Gets the description of this shopping order item.
	*
	* @return the description of this shopping order item
	*/
	public java.lang.String getDescription() {
		return _shoppingOrderItem.getDescription();
	}

	/**
	* Sets the description of this shopping order item.
	*
	* @param description the description of this shopping order item
	*/
	public void setDescription(java.lang.String description) {
		_shoppingOrderItem.setDescription(description);
	}

	/**
	* Gets the properties of this shopping order item.
	*
	* @return the properties of this shopping order item
	*/
	public java.lang.String getProperties() {
		return _shoppingOrderItem.getProperties();
	}

	/**
	* Sets the properties of this shopping order item.
	*
	* @param properties the properties of this shopping order item
	*/
	public void setProperties(java.lang.String properties) {
		_shoppingOrderItem.setProperties(properties);
	}

	/**
	* Gets the price of this shopping order item.
	*
	* @return the price of this shopping order item
	*/
	public double getPrice() {
		return _shoppingOrderItem.getPrice();
	}

	/**
	* Sets the price of this shopping order item.
	*
	* @param price the price of this shopping order item
	*/
	public void setPrice(double price) {
		_shoppingOrderItem.setPrice(price);
	}

	/**
	* Gets the quantity of this shopping order item.
	*
	* @return the quantity of this shopping order item
	*/
	public int getQuantity() {
		return _shoppingOrderItem.getQuantity();
	}

	/**
	* Sets the quantity of this shopping order item.
	*
	* @param quantity the quantity of this shopping order item
	*/
	public void setQuantity(int quantity) {
		_shoppingOrderItem.setQuantity(quantity);
	}

	/**
	* Gets the shipped date of this shopping order item.
	*
	* @return the shipped date of this shopping order item
	*/
	public java.util.Date getShippedDate() {
		return _shoppingOrderItem.getShippedDate();
	}

	/**
	* Sets the shipped date of this shopping order item.
	*
	* @param shippedDate the shipped date of this shopping order item
	*/
	public void setShippedDate(java.util.Date shippedDate) {
		_shoppingOrderItem.setShippedDate(shippedDate);
	}

	public boolean isNew() {
		return _shoppingOrderItem.isNew();
	}

	public void setNew(boolean n) {
		_shoppingOrderItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingOrderItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingOrderItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingOrderItem.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingOrderItem.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingOrderItem.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrderItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ShoppingOrderItemWrapper((ShoppingOrderItem)_shoppingOrderItem.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItem.compareTo(shoppingOrderItem);
	}

	public int hashCode() {
		return _shoppingOrderItem.hashCode();
	}

	public com.liferay.portlet.shopping.model.ShoppingOrderItem toEscapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toEscapedModel());
	}

	public java.lang.String toString() {
		return _shoppingOrderItem.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingOrderItem.toXmlString();
	}

	public ShoppingOrderItem getWrappedShoppingOrderItem() {
		return _shoppingOrderItem;
	}

	private ShoppingOrderItem _shoppingOrderItem;
}