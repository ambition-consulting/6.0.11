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
 * The model interface for the Image service. Represents a row in the &quot;Image&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.ImageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageModel
 * @see com.liferay.portal.model.impl.ImageImpl
 * @see com.liferay.portal.model.impl.ImageModelImpl
 * @generated
 */
public interface Image extends ImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a image model instance should use the {@link Image} interface instead.
	 */
	public byte[] getTextObj();

	public void setTextObj(byte[] textObj);
}