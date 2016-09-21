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
 * This class is a wrapper for {@link AssetCategoryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AssetCategoryService
 * @generated
 */
public class AssetCategoryServiceWrapper implements AssetCategoryService {
	public AssetCategoryServiceWrapper(
		AssetCategoryService assetCategoryService) {
		_assetCategoryService = assetCategoryService;
	}

	public com.liferay.portlet.asset.model.AssetCategory addCategory(
		long parentCategoryId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		long vocabularyId, java.lang.String[] categoryProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.addCategory(parentCategoryId, titleMap,
			vocabularyId, categoryProperties, serviceContext);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_assetCategoryService.deleteCategory(categoryId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getCategories(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getCategories(className, classPK);
	}

	public com.liferay.portlet.asset.model.AssetCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getCategory(categoryId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getChildCategories(
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getChildCategories(parentCategoryId);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getChildCategories(
		long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getChildCategories(parentCategoryId,
			start, end, obc);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long vocabularyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getVocabularyCategories(vocabularyId,
			start, end, obc);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long parentCategoryId, long vocabularyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getVocabularyCategories(parentCategoryId,
			vocabularyId, start, end, obc);
	}

	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyRootCategories(
		long vocabularyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.getVocabularyRootCategories(vocabularyId,
			start, end, obc);
	}

	public com.liferay.portal.kernel.json.JSONArray search(long groupId,
		java.lang.String name, java.lang.String[] categoryProperties,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.search(groupId, name, categoryProperties,
			start, end);
	}

	public com.liferay.portlet.asset.model.AssetCategory updateCategory(
		long categoryId, long parentCategoryId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		long vocabularyId, java.lang.String[] categoryProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _assetCategoryService.updateCategory(categoryId,
			parentCategoryId, titleMap, vocabularyId, categoryProperties,
			serviceContext);
	}

	public AssetCategoryService getWrappedAssetCategoryService() {
		return _assetCategoryService;
	}

	public void setWrappedAssetCategoryService(
		AssetCategoryService assetCategoryService) {
		_assetCategoryService = assetCategoryService;
	}

	private AssetCategoryService _assetCategoryService;
}