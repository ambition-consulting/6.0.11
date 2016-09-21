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
 * This class is a wrapper for {@link PortletService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PortletService
 * @generated
 */
public class PortletServiceWrapper implements PortletService {
	public PortletServiceWrapper(PortletService portletService) {
		_portletService = portletService;
	}

	public com.liferay.portal.kernel.json.JSONArray getWARPortlets() {
		return _portletService.getWARPortlets();
	}

	public com.liferay.portal.model.Portlet updatePortlet(long companyId,
		java.lang.String portletId, java.lang.String roles, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portletService.updatePortlet(companyId, portletId, roles, active);
	}

	public PortletService getWrappedPortletService() {
		return _portletService;
	}

	public void setWrappedPortletService(PortletService portletService) {
		_portletService = portletService;
	}

	private PortletService _portletService;
}