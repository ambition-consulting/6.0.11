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

package com.liferay.portlet.asset.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetTagProperty;
import com.liferay.portlet.asset.service.base.AssetTagPropertyServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTagPropertyServiceImpl
	extends AssetTagPropertyServiceBaseImpl {

	public AssetTagProperty addTagProperty(long tagId, String key, String value)
		throws PortalException, SystemException {

		return assetTagPropertyLocalService.addTagProperty(
			getUserId(), tagId, key, value);
	}

	public void deleteTagProperty(long tagPropertyId)
		throws PortalException, SystemException {

		assetTagPropertyLocalService.deleteTagProperty(tagPropertyId);
	}

	public List<AssetTagProperty> getTagProperties(long tagId)
		throws SystemException {

		return assetTagPropertyLocalService.getTagProperties(tagId);
	}

	public List<AssetTagProperty> getTagPropertyValues(
			long companyId, String key)
		throws SystemException {

		return assetTagPropertyLocalService.getTagPropertyValues(
			companyId, key);
	}

	public AssetTagProperty updateTagProperty(
			long tagPropertyId, String key, String value)
		throws PortalException, SystemException {

		return assetTagPropertyLocalService.updateTagProperty(
			tagPropertyId, key, value);
	}

}