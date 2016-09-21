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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link ClassNameService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ClassNameService
 * @generated
 */
public class ClassNameServiceWrapper implements ClassNameService {
	public ClassNameServiceWrapper(ClassNameService classNameService) {
		_classNameService = classNameService;
	}

	public com.liferay.portal.model.ClassName getClassName(long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _classNameService.getClassName(classNameId);
	}

	public com.liferay.portal.model.ClassName getClassName(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classNameService.getClassName(value);
	}

	public long getClassNameId(java.lang.Class<?> classObj) {
		return _classNameService.getClassNameId(classObj);
	}

	public long getClassNameId(java.lang.String value) {
		return _classNameService.getClassNameId(value);
	}

	public ClassNameService getWrappedClassNameService() {
		return _classNameService;
	}

	public void setWrappedClassNameService(ClassNameService classNameService) {
		_classNameService = classNameService;
	}

	private ClassNameService _classNameService;
}