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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.concurrent.ConcurrentHashSet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.lang.reflect.Field;

import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class ReferenceRegistry {

	public static void registerReference(
		Class<?> clazz, Object object, String fieldName) {

		try {
			Field field = clazz.getDeclaredField(fieldName);

			_referenceEntries.add(new ReferenceEntry(object, field));
		}
		catch (Exception e) {
			_log.error(
				"Failed the get field " + fieldName + " for class " + clazz, e);
		}
	}

	public static void registerReference(Class<?> clazz, String fieldName) {
		registerReference(clazz, null, fieldName);
	}

	public static void registerReference(Field field) {
		_referenceEntries.add(new ReferenceEntry(field));
	}

	public static void registerReference(Object object, Field field) {
		_referenceEntries.add(new ReferenceEntry(object, field));
	}

	public static void releaseReferences() {
		for (ReferenceEntry referenceEntry : _referenceEntries) {
			try {
				referenceEntry.setValue(null);
			}
			catch (Exception e) {
				_log.error(
					"Failed to release reference for " + referenceEntry, e);
			}
		}

		_referenceEntries.clear();
	}

	private static Log _log = LogFactoryUtil.getLog(ReferenceRegistry.class);

	private static Set<ReferenceEntry> _referenceEntries =
		new ConcurrentHashSet<ReferenceEntry>();

}