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
 * This class is a wrapper for {@link AssetTagService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetTagService
 * @generated
 */
public class AssetTagServiceWrapper implements AssetTagService {
	public AssetTagServiceWrapper(AssetTagService assetTagService) {
		_assetTagService = assetTagService;
	}

	public com.liferay.portlet.asset.model.AssetTag addTag(
		java.lang.String name, java.lang.String[] tagProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.addTag(name, tagProperties, serviceContext);
	}

	public void deleteTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetTagService.deleteTag(tagId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetTag> getGroupTags(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.getGroupTags(groupId);
	}

	public com.liferay.portlet.asset.model.AssetTag getTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.getTag(tagId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetTag> getTags(
		long groupId, long classNameId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.getTags(groupId, classNameId, name);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetTag> getTags(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.getTags(className, classPK);
	}

	public void mergeTags(long fromTagId, long toTagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetTagService.mergeTags(fromTagId, toTagId);
	}

	public com.liferay.portal.kernel.json.JSONArray search(long groupId,
		java.lang.String name, java.lang.String[] tagProperties, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.search(groupId, name, tagProperties, start, end);
	}

	public com.liferay.portlet.asset.model.AssetTag updateTag(long tagId,
		java.lang.String name, java.lang.String[] tagProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetTagService.updateTag(tagId, name, tagProperties,
			serviceContext);
	}

	public AssetTagService getWrappedAssetTagService() {
		return _assetTagService;
	}

	public void setWrappedAssetTagService(AssetTagService assetTagService) {
		_assetTagService = assetTagService;
	}

	private AssetTagService _assetTagService;
}