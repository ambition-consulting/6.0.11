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

package com.liferay.portlet.messageboards.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the message boards message flag remote service. This utility wraps {@link com.liferay.portlet.messageboards.service.impl.MBMessageFlagServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBMessageFlagService
 * @see com.liferay.portlet.messageboards.service.base.MBMessageFlagServiceBaseImpl
 * @see com.liferay.portlet.messageboards.service.impl.MBMessageFlagServiceImpl
 * @generated
 */
public class MBMessageFlagServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.messageboards.service.impl.MBMessageFlagServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAnswerFlag(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addAnswerFlag(messageId);
	}

	public static void deleteAnswerFlag(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnswerFlag(messageId);
	}

	public static MBMessageFlagService getService() {
		if (_service == null) {
			_service = (MBMessageFlagService)PortalBeanLocatorUtil.locate(MBMessageFlagService.class.getName());

			ReferenceRegistry.registerReference(MBMessageFlagServiceUtil.class,
				"_service");
			MethodCache.remove(MBMessageFlagService.class);
		}

		return _service;
	}

	public void setService(MBMessageFlagService service) {
		MethodCache.remove(MBMessageFlagService.class);

		_service = service;

		ReferenceRegistry.registerReference(MBMessageFlagServiceUtil.class,
			"_service");
		MethodCache.remove(MBMessageFlagService.class);
	}

	private static MBMessageFlagService _service;
}