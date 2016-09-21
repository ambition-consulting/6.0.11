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
 * The model interface for the ShoppingItemField service. Represents a row in the &quot;ShoppingItemField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.shopping.model.impl.ShoppingItemFieldImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemFieldModel
 * @see com.liferay.portlet.shopping.model.impl.ShoppingItemFieldImpl
 * @see com.liferay.portlet.shopping.model.impl.ShoppingItemFieldModelImpl
 * @generated
 */
public interface ShoppingItemField extends ShoppingItemFieldModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a shopping item field model instance should use the {@link ShoppingItemField} interface instead.
	 */
	public java.lang.String[] getValuesArray();

	public void setValues(java.lang.String values);

	public void setValuesArray(java.lang.String[] valuesArray);
}