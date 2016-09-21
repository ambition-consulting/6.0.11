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
 * This class is a wrapper for {@link QuartzLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       QuartzLocalService
 * @generated
 */
public class QuartzLocalServiceWrapper implements QuartzLocalService {
	public QuartzLocalServiceWrapper(QuartzLocalService quartzLocalService) {
		_quartzLocalService = quartzLocalService;
	}

	public void checkQuartzTables()
		throws com.liferay.portal.kernel.exception.SystemException {
		_quartzLocalService.checkQuartzTables();
	}

	public QuartzLocalService getWrappedQuartzLocalService() {
		return _quartzLocalService;
	}

	public void setWrappedQuartzLocalService(
		QuartzLocalService quartzLocalService) {
		_quartzLocalService = quartzLocalService;
	}

	private QuartzLocalService _quartzLocalService;
}