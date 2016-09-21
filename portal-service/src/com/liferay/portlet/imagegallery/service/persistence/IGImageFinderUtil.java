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

package com.liferay.portlet.imagegallery.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class IGImageFinderUtil {
	public static com.liferay.portlet.imagegallery.model.IGImage fetchByAnyImageId(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().fetchByAnyImageId(imageId);
	}

	public static com.liferay.portlet.imagegallery.model.IGImage findByAnyImageId(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.imagegallery.NoSuchImageException {
		return getFinder().findByAnyImageId(imageId);
	}

	public static java.util.List<com.liferay.portlet.imagegallery.model.IGImage> findByNoAssets()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByNoAssets();
	}

	public static IGImageFinder getFinder() {
		if (_finder == null) {
			_finder = (IGImageFinder)PortalBeanLocatorUtil.locate(IGImageFinder.class.getName());

			ReferenceRegistry.registerReference(IGImageFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(IGImageFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(IGImageFinderUtil.class, "_finder");
	}

	private static IGImageFinder _finder;
}