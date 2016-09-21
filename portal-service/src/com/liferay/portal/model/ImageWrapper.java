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
 * This class is a wrapper for {@link Image}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Image
 * @generated
 */
public class ImageWrapper implements Image {
	public ImageWrapper(Image image) {
		_image = image;
	}

	/**
	* Gets the primary key of this image.
	*
	* @return the primary key of this image
	*/
	public long getPrimaryKey() {
		return _image.getPrimaryKey();
	}

	/**
	* Sets the primary key of this image
	*
	* @param pk the primary key of this image
	*/
	public void setPrimaryKey(long pk) {
		_image.setPrimaryKey(pk);
	}

	/**
	* Gets the image id of this image.
	*
	* @return the image id of this image
	*/
	public long getImageId() {
		return _image.getImageId();
	}

	/**
	* Sets the image id of this image.
	*
	* @param imageId the image id of this image
	*/
	public void setImageId(long imageId) {
		_image.setImageId(imageId);
	}

	/**
	* Gets the modified date of this image.
	*
	* @return the modified date of this image
	*/
	public java.util.Date getModifiedDate() {
		return _image.getModifiedDate();
	}

	/**
	* Sets the modified date of this image.
	*
	* @param modifiedDate the modified date of this image
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_image.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the text of this image.
	*
	* @return the text of this image
	*/
	public java.lang.String getText() {
		return _image.getText();
	}

	/**
	* Sets the text of this image.
	*
	* @param text the text of this image
	*/
	public void setText(java.lang.String text) {
		_image.setText(text);
	}

	/**
	* Gets the type of this image.
	*
	* @return the type of this image
	*/
	public java.lang.String getType() {
		return _image.getType();
	}

	/**
	* Sets the type of this image.
	*
	* @param type the type of this image
	*/
	public void setType(java.lang.String type) {
		_image.setType(type);
	}

	/**
	* Gets the height of this image.
	*
	* @return the height of this image
	*/
	public int getHeight() {
		return _image.getHeight();
	}

	/**
	* Sets the height of this image.
	*
	* @param height the height of this image
	*/
	public void setHeight(int height) {
		_image.setHeight(height);
	}

	/**
	* Gets the width of this image.
	*
	* @return the width of this image
	*/
	public int getWidth() {
		return _image.getWidth();
	}

	/**
	* Sets the width of this image.
	*
	* @param width the width of this image
	*/
	public void setWidth(int width) {
		_image.setWidth(width);
	}

	/**
	* Gets the size of this image.
	*
	* @return the size of this image
	*/
	public int getSize() {
		return _image.getSize();
	}

	/**
	* Sets the size of this image.
	*
	* @param size the size of this image
	*/
	public void setSize(int size) {
		_image.setSize(size);
	}

	public boolean isNew() {
		return _image.isNew();
	}

	public void setNew(boolean n) {
		_image.setNew(n);
	}

	public boolean isCachedModel() {
		return _image.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_image.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _image.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_image.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _image.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _image.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_image.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ImageWrapper((Image)_image.clone());
	}

	public int compareTo(com.liferay.portal.model.Image image) {
		return _image.compareTo(image);
	}

	public int hashCode() {
		return _image.hashCode();
	}

	public com.liferay.portal.model.Image toEscapedModel() {
		return new ImageWrapper(_image.toEscapedModel());
	}

	public java.lang.String toString() {
		return _image.toString();
	}

	public java.lang.String toXmlString() {
		return _image.toXmlString();
	}

	public byte[] getTextObj() {
		return _image.getTextObj();
	}

	public void setTextObj(byte[] textObj) {
		_image.setTextObj(textObj);
	}

	public Image getWrappedImage() {
		return _image;
	}

	private Image _image;
}