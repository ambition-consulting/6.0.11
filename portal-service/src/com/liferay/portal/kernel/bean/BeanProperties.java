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

package com.liferay.portal.kernel.bean;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public interface BeanProperties {

	public void copyProperties(Object source, Object target);

	public void copyProperties(Object source, Object target, Class<?> editable);

	public void copyProperties(
		Object source, Object target, String[] ignoreProperties);

	public boolean getBoolean(Object bean, String param);

	public boolean getBoolean(Object bean, String param, boolean defaultValue);

	public boolean getBooleanSilent(Object bean, String param);

	public boolean getBooleanSilent(
		Object bean, String param, boolean defaultValue);

	public byte getByte(Object bean, String param);

	public byte getByte(Object bean, String param, byte defaultValue);

	public byte getByteSilent(Object bean, String param);

	public byte getByteSilent(Object bean, String param, byte defaultValue);

	public double getDouble(Object bean, String param);

	public double getDouble(Object bean, String param, double defaultValue);

	public double getDoubleSilent(Object bean, String param);

	public double getDoubleSilent(
		Object bean, String param, double defaultValue);

	public float getFloat(Object bean, String param);

	public float getFloat(Object bean, String param, float defaultValue);

	public float getFloatSilent(Object bean, String param);

	public float getFloatSilent(Object bean, String param, float defaultValue);

	public int getInteger(Object bean, String param);

	public int getInteger(Object bean, String param, int defaultValue);

	public int getIntegerSilent(Object bean, String param);

	public int getIntegerSilent(Object bean, String param, int defaultValue);

	public long getLong(Object bean, String param);

	public long getLong(Object bean, String param, long defaultValue);

	public long getLongSilent(Object bean, String param);

	public long getLongSilent(Object bean, String param, long defaultValue);

	public Object getObject(Object bean, String param);

	public Object getObject(Object bean, String param, Object defaultValue);

	public Object getObjectSilent(Object bean, String param);

	public Object getObjectSilent(
		Object bean, String param, Object defaultValue);

	public short getShort(Object bean, String param);

	public short getShort(Object bean, String param, short defaultValue);

	public short getShortSilent(Object bean, String param);

	public short getShortSilent(Object bean, String param, short defaultValue);

	public String getString(Object bean, String param);

	public String getString(Object bean, String param, String defaultValue);

	public String getStringSilent(Object bean, String param);

	public String getStringSilent(
		Object bean, String param, String defaultValue);

	public void setProperties(Object bean, HttpServletRequest request);

	public void setProperty(Object bean, String param, Object value);

}