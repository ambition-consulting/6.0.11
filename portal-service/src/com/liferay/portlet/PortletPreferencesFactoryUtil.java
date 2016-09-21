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

package com.liferay.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletPreferencesIds;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PreferencesValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPreferencesFactoryUtil {

	public static PortletPreferences getLayoutPortletSetup(
			Layout layout, String portletId)
		throws SystemException {

		return getPortletPreferencesFactory().getLayoutPortletSetup(
			layout, portletId);
	}

	public static PortalPreferences getPortalPreferences(
			HttpServletRequest request)
		throws SystemException {

		return getPortletPreferencesFactory().getPortalPreferences(request);
	}

	public static PortalPreferences getPortalPreferences(
			PortletRequest portletRequest)
		throws SystemException {

		return getPortletPreferencesFactory().getPortalPreferences(
			portletRequest);
	}

	public static PortletPreferences getPortletPreferences(
			HttpServletRequest request, String portletId)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletPreferences(
			request, portletId);
	}

	public static PortletPreferencesFactory getPortletPreferencesFactory() {
		return _portletPreferencesFactory;
	}

	public static PortletPreferencesIds getPortletPreferencesIds(
			HttpServletRequest request, String portletId)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletPreferencesIds(
			request, portletId);
	}

	public static PortletPreferencesIds getPortletPreferencesIds(
			HttpServletRequest request, Layout selLayout, String portletId)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletPreferencesIds(
			request, selLayout, portletId);
	}

	public static PortletPreferences getPortletSetup(
			Layout layout, String portletId, String defaultPreferences)
		throws SystemException {

		return getPortletPreferencesFactory().getPortletSetup(
			layout, portletId, defaultPreferences);
	}

	public static PortletPreferences getPortletSetup(
			HttpServletRequest request, String portletId)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletSetup(
			request, portletId);
	}

	public static PortletPreferences getPortletSetup(
			HttpServletRequest request, String portletId,
			String defaultPreferences)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletSetup(
			request, portletId, defaultPreferences);
	}

	public static PortletPreferences getPortletSetup(
			PortletRequest portletRequest)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletSetup(portletRequest);
	}

	public static PortletPreferences getPortletSetup(
			PortletRequest portletRequest, String portletId)
		throws PortalException, SystemException {

		return getPortletPreferencesFactory().getPortletSetup(
			portletRequest, portletId);
	}

	public static PortletPreferences getPreferences(
		HttpServletRequest request) {

		return getPortletPreferencesFactory().getPreferences(request);
	}

	public static PreferencesValidator getPreferencesValidator(
		Portlet portlet) {

		return getPortletPreferencesFactory().getPreferencesValidator(portlet);
	}

	public void setPortletPreferencesFactory(
		PortletPreferencesFactory portletPreferencesFactory) {

		_portletPreferencesFactory = portletPreferencesFactory;
	}

	private static PortletPreferencesFactory _portletPreferencesFactory;

}