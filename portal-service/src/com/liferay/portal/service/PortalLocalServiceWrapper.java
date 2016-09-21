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
 * This class is a wrapper for {@link PortalLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PortalLocalService
 * @generated
 */
public class PortalLocalServiceWrapper implements PortalLocalService {
	public PortalLocalServiceWrapper(PortalLocalService portalLocalService) {
		_portalLocalService = portalLocalService;
	}

	public PortalLocalService getWrappedPortalLocalService() {
		return _portalLocalService;
	}

	public void setWrappedPortalLocalService(
		PortalLocalService portalLocalService) {
		_portalLocalService = portalLocalService;
	}

	private PortalLocalService _portalLocalService;
}