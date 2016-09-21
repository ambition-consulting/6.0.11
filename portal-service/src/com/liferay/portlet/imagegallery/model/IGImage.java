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

package com.liferay.portlet.imagegallery.model;

/**
 * The model interface for the IGImage service. Represents a row in the &quot;IGImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.imagegallery.model.impl.IGImageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IGImageModel
 * @see com.liferay.portlet.imagegallery.model.impl.IGImageImpl
 * @see com.liferay.portlet.imagegallery.model.impl.IGImageModelImpl
 * @generated
 */
public interface IGImage extends IGImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a i g image model instance should use the {@link IGImage} interface instead.
	 */
	public com.liferay.portlet.imagegallery.model.IGFolder getFolder();

	public int getImageSize();

	public java.lang.String getImageType();

	public java.lang.String getNameWithExtension();

	public void setImageType(java.lang.String imageType);
}