/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.freemarker;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PropsUtil;

import freemarker.core.Environment;
import freemarker.core.TemplateClassResolver;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.utility.Execute;
import freemarker.template.utility.ObjectConstructor;

/**
 * @author Raymond Augé
 */
public class LiferayTemplateClassResolver implements TemplateClassResolver {

	public Class<?> resolve(
			String className, Environment environment, Template template)
		throws TemplateException {

		if (className.equals(Execute.class.getName()) ||
			className.equals(ObjectConstructor.class.getName())) {

			throw new TemplateException(
				"Instantiating " + className + " is not allowed in the " +
					"template for security reasons",
				environment);
		}

		String[] restrictedClassNames = getStringValues(
			PropsUtil.getArray("freemarker.engine.restricted.classes"),
			new String[0]);

		for (String restrictedClassName : restrictedClassNames) {
			if (restrictedClassName.equals(StringPool.STAR)) {
				throw new TemplateException(
					"Instantiating " + className + " is not allowed in the " +
						"template for security reasons",
					environment);
			}
			else if (restrictedClassName.endsWith(StringPool.STAR)) {
				restrictedClassName = restrictedClassName.substring(
					0, restrictedClassName.length() -1);

				if (className.startsWith(restrictedClassName)) {
					throw new TemplateException(
						"Instantiating " + className + " is not allowed in " +
							"the template for security reasons",
						environment);
				}
			}
			else if (className.equals(restrictedClassName)) {
				throw new TemplateException(
					"Instantiating " + className + " is not allowed in the " +
						"template for security reasons",
					environment);
			}
		}

		for (String restrictedPackageName :
				PropsUtil.getArray("freemarker.engine.restricted.packages")) {

			if (className.startsWith(restrictedPackageName)) {
				throw new TemplateException(
					"Instantiating " + className + " is not allowed in the " +
						"template for security reasons",
					environment);
			}
		}

		boolean allowed = false;

		String[] allowedClassNames = getStringValues(
			PropsUtil.getArray("freemarker.engine.allowed.classes"),
			new String[0]);

		for (String allowedClassName : allowedClassNames) {
			if (allowedClassName.equals(StringPool.STAR)) {
				allowed = true;
				break;
			}
			else if (allowedClassName.endsWith(StringPool.STAR)) {
				allowedClassName = allowedClassName.substring(
						0, allowedClassName.length() - 1);

				if (className.startsWith(allowedClassName)) {
					allowed = true;
					break;
				}
			}
			else if (allowedClassName.equals(className)) {
				allowed = true;
				break;
			}
		}

		if (allowed) {
			try {
				return Class.forName(
					className, true, PortalClassLoaderUtil.getClassLoader());
			}
			catch (Exception e) {
				throw new TemplateException(e, environment);
			}
		}

		throw new TemplateException(
			"Instantiating " + className + " is not allowed in the template " +
				"for security reasons",
			environment);
	}

	protected String[] getStringValues(
		Object[] values, String[] defaultValue) {

		if (values == null) {
			return defaultValue;
		}

		String[] stringValues = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			stringValues[i] = String.valueOf(values[i]);
		}

		return stringValues;
	}

}