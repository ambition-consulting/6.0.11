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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ClassName service. Represents a row in the &quot;ClassName_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ClassNameModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ClassNameImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassName
 * @see com.liferay.portal.model.impl.ClassNameImpl
 * @see com.liferay.portal.model.impl.ClassNameModelImpl
 * @generated
 */
public interface ClassNameModel extends BaseModel<ClassName> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a class name model instance should use the {@link ClassName} interface instead.
	 */

	/**
	 * Gets the primary key of this class name.
	 *
	 * @return the primary key of this class name
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this class name
	 *
	 * @param pk the primary key of this class name
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the class name of the model instance this class name is polymorphically associated with.
	 *
	 * @return the class name of the model instance this class name is polymorphically associated with
	 */
	public String getClassName();

	/**
	 * Gets the class name id of this class name.
	 *
	 * @return the class name id of this class name
	 */
	public long getClassNameId();

	/**
	 * Sets the class name id of this class name.
	 *
	 * @param classNameId the class name id of this class name
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Gets the value of this class name.
	 *
	 * @return the value of this class name
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this class name.
	 *
	 * @param value the value of this class name
	 */
	public void setValue(String value);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ClassName className);

	public int hashCode();

	public ClassName toEscapedModel();

	public String toString();

	public String toXmlString();
}