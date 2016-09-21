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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the layout set remote service. This utility wraps {@link com.liferay.portal.service.impl.LayoutSetServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetService
 * @see com.liferay.portal.service.base.LayoutSetServiceBaseImpl
 * @see com.liferay.portal.service.impl.LayoutSetServiceImpl
 * @generated
 */
public class LayoutSetServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.LayoutSetServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void updateLogo(long groupId, boolean privateLayout,
		boolean logo, java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateLogo(groupId, privateLayout, logo, file);
	}

	public static com.liferay.portal.model.LayoutSet updateLookAndFeel(
		long groupId, boolean privateLayout, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLookAndFeel(groupId, privateLayout, themeId,
			colorSchemeId, css, wapTheme);
	}

	public static com.liferay.portal.model.LayoutSet updateSettings(
		long groupId, boolean privateLayout, java.lang.String settings)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSettings(groupId, privateLayout, settings);
	}

	public static com.liferay.portal.model.LayoutSet updateVirtualHost(
		long groupId, boolean privateLayout, java.lang.String virtualHost)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVirtualHost(groupId, privateLayout, virtualHost);
	}

	public static LayoutSetService getService() {
		if (_service == null) {
			_service = (LayoutSetService)PortalBeanLocatorUtil.locate(LayoutSetService.class.getName());

			ReferenceRegistry.registerReference(LayoutSetServiceUtil.class,
				"_service");
			MethodCache.remove(LayoutSetService.class);
		}

		return _service;
	}

	public void setService(LayoutSetService service) {
		MethodCache.remove(LayoutSetService.class);

		_service = service;

		ReferenceRegistry.registerReference(LayoutSetServiceUtil.class,
			"_service");
		MethodCache.remove(LayoutSetService.class);
	}

	private static LayoutSetService _service;
}