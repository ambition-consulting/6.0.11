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
 * The utility for the image remote service. This utility wraps {@link com.liferay.portal.service.impl.ImageServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageService
 * @see com.liferay.portal.service.base.ImageServiceBaseImpl
 * @see com.liferay.portal.service.impl.ImageServiceImpl
 * @generated
 */
public class ImageServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.ImageServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.model.Image getImage(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getImage(imageId);
	}

	public static ImageService getService() {
		if (_service == null) {
			_service = (ImageService)PortalBeanLocatorUtil.locate(ImageService.class.getName());

			ReferenceRegistry.registerReference(ImageServiceUtil.class,
				"_service");
			MethodCache.remove(ImageService.class);
		}

		return _service;
	}

	public void setService(ImageService service) {
		MethodCache.remove(ImageService.class);

		_service = service;

		ReferenceRegistry.registerReference(ImageServiceUtil.class, "_service");
		MethodCache.remove(ImageService.class);
	}

	private static ImageService _service;
}