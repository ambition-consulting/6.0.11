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

package com.liferay.portlet.asset.service;

/**
 * <p>
 * This class is a wrapper for {@link AssetTagPropertyService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetTagPropertyService
 * @generated
 */
public class AssetTagPropertyServiceWrapper implements AssetTagPropertyService {
	public AssetTagPropertyServiceWrapper(
		AssetTagPropertyService assetTagPropertyService) {
		_assetTagPropertyService = assetTagPropertyService;
	}

	public com.liferay.portlet.asset.model.AssetTagProperty addTagProperty(
		long tagId, java.lang.String key, java.lang.String value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagPropertyService.addTagProperty(tagId, key, value);
	}

	public void deleteTagProperty(long tagPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetTagPropertyService.deleteTagProperty(tagPropertyId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getTagProperties(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return _assetTagPropertyService.getTagProperties(tagId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getTagPropertyValues(
		long companyId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assetTagPropertyService.getTagPropertyValues(companyId, key);
	}

	public com.liferay.portlet.asset.model.AssetTagProperty updateTagProperty(
		long tagPropertyId, java.lang.String key, java.lang.String value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagPropertyService.updateTagProperty(tagPropertyId, key,
			value);
	}

	public AssetTagPropertyService getWrappedAssetTagPropertyService() {
		return _assetTagPropertyService;
	}

	public void setWrappedAssetTagPropertyService(
		AssetTagPropertyService assetTagPropertyService) {
		_assetTagPropertyService = assetTagPropertyService;
	}

	private AssetTagPropertyService _assetTagPropertyService;
}