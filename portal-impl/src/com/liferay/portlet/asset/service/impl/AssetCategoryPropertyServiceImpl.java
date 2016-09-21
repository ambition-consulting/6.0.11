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
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.service.base.AssetCategoryPropertyServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class AssetCategoryPropertyServiceImpl
	extends AssetCategoryPropertyServiceBaseImpl {

	public AssetCategoryProperty addCategoryProperty(
			long entryId, String key, String value)
		throws PortalException, SystemException {

		return assetCategoryPropertyLocalService.addCategoryProperty(
			getUserId(), entryId, key, value);
	}

	public void deleteCategoryProperty(long categoryPropertyId)
		throws PortalException, SystemException {

		assetCategoryPropertyLocalService.deleteCategoryProperty(
			categoryPropertyId);
	}

	public List<AssetCategoryProperty> getCategoryProperties(long entryId)
		throws SystemException {

		return assetCategoryPropertyLocalService.getCategoryProperties(entryId);
	}

	public List<AssetCategoryProperty> getCategoryPropertyValues(
			long companyId, String key)
		throws SystemException {

		return assetCategoryPropertyLocalService.getCategoryPropertyValues(
			companyId, key);
	}

	public AssetCategoryProperty updateCategoryProperty(
			long categoryPropertyId, String key, String value)
		throws PortalException, SystemException {

		return assetCategoryPropertyLocalService.updateCategoryProperty(
			categoryPropertyId, key, value);
	}

}