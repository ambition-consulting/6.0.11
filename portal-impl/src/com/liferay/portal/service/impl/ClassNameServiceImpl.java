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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.base.ClassNameServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassNameServiceImpl extends ClassNameServiceBaseImpl {

	public ClassName getClassName(long classNameId)
		throws PortalException, SystemException {

		return classNameLocalService.getClassName(classNameId);
	}

	public ClassName getClassName(String value) throws SystemException {
		return classNameLocalService.getClassName(value);
	}

	public long getClassNameId(Class<?> classObj) {
		return classNameLocalService.getClassNameId(classObj);
	}

	public long getClassNameId(String value) {
		return classNameLocalService.getClassNameId(value);
	}

}