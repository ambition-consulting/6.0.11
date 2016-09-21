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
 * This class is a wrapper for {@link PortletPreferencesService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PortletPreferencesService
 * @generated
 */
public class PortletPreferencesServiceWrapper
	implements PortletPreferencesService {
	public PortletPreferencesServiceWrapper(
		PortletPreferencesService portletPreferencesService) {
		_portletPreferencesService = portletPreferencesService;
	}

	public void deleteArchivedPreferences(long portletItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesService.deleteArchivedPreferences(portletItemId);
	}

	public void restoreArchivedPreferences(long groupId, java.lang.String name,
		java.lang.String portletId, javax.portlet.PortletPreferences preferences)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesService.restoreArchivedPreferences(groupId, name,
			portletId, preferences);
	}

	public void updateArchivePreferences(long userId, long groupId,
		java.lang.String name, java.lang.String portletId,
		javax.portlet.PortletPreferences preferences)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portletPreferencesService.updateArchivePreferences(userId, groupId,
			name, portletId, preferences);
	}

	public PortletPreferencesService getWrappedPortletPreferencesService() {
		return _portletPreferencesService;
	}

	public void setWrappedPortletPreferencesService(
		PortletPreferencesService portletPreferencesService) {
		_portletPreferencesService = portletPreferencesService;
	}

	private PortletPreferencesService _portletPreferencesService;
}