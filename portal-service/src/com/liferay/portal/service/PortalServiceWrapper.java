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
 * This class is a wrapper for {@link PortalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PortalService
 * @generated
 */
public class PortalServiceWrapper implements PortalService {
	public PortalServiceWrapper(PortalService portalService) {
		_portalService = portalService;
	}

	public java.lang.String getAutoDeployDirectory()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portalService.getAutoDeployDirectory();
	}

	public int getBuildNumber() {
		return _portalService.getBuildNumber();
	}

	public void test() {
		_portalService.test();
	}

	public void testCounterRollback()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portalService.testCounterRollback();
	}

	public PortalService getWrappedPortalService() {
		return _portalService;
	}

	public void setWrappedPortalService(PortalService portalService) {
		_portalService = portalService;
	}

	private PortalService _portalService;
}