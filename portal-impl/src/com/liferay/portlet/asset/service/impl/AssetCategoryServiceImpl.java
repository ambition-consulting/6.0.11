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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.base.AssetCategoryServiceBaseImpl;
import com.liferay.portlet.asset.service.permission.AssetCategoryPermission;
import com.liferay.util.Autocomplete;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @author Alvaro del Castillo
 * @author Eduardo Lundgren
 * @author Bruno Farache
 */
public class AssetCategoryServiceImpl extends AssetCategoryServiceBaseImpl {

	public AssetCategory addCategory(
			long parentCategoryId, Map<Locale, String> titleMap,
			long vocabularyId, String[] categoryProperties,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		AssetCategoryPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			parentCategoryId, ActionKeys.ADD_CATEGORY);

		return assetCategoryLocalService.addCategory(
			getUserId(), parentCategoryId, titleMap, vocabularyId,
			categoryProperties, serviceContext);
	}

	public void deleteCategory(long categoryId)
		throws PortalException, SystemException {

		AssetCategoryPermission.check(
			getPermissionChecker(), categoryId, ActionKeys.DELETE);

		assetCategoryLocalService.deleteCategory(categoryId);
	}

	public List<AssetCategory> getCategories(String className, long classPK)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getCategories(className, classPK));
	}

	public AssetCategory getCategory(long categoryId)
		throws PortalException, SystemException {

		AssetCategoryPermission.check(
			getPermissionChecker(), categoryId, ActionKeys.VIEW);

		return assetCategoryLocalService.getCategory(categoryId);
	}

	public List<AssetCategory> getChildCategories(long parentCategoryId)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getChildCategories(parentCategoryId));
	}

	public List<AssetCategory> getChildCategories(
			long parentCategoryId, int start, int end, OrderByComparator obc)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getChildCategories(
				parentCategoryId, start, end, obc));
	}

	public List<AssetCategory> getVocabularyCategories(
			long vocabularyId, int start, int end, OrderByComparator obc)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getVocabularyCategories(
				vocabularyId, start, end, obc));
	}

	public List<AssetCategory> getVocabularyCategories(
			long parentCategoryId, long vocabularyId, int start, int end,
			OrderByComparator obc)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getVocabularyCategories(
				parentCategoryId, vocabularyId, start, end, obc));
	}

	public List<AssetCategory> getVocabularyRootCategories(
			long vocabularyId, int start, int end, OrderByComparator obc)
		throws PortalException, SystemException {

		return filterCategories(
			assetCategoryLocalService.getVocabularyRootCategories(
				vocabularyId, start, end, obc));
	}

	public JSONArray search(
			long groupId, String name, String[] categoryProperties, int start,
			int end)
		throws PortalException, SystemException {

		List<AssetCategory> categories = assetCategoryLocalService.search(
			groupId, name, categoryProperties, start, end);

		categories = filterCategories(categories);

		return Autocomplete.listToJson(categories, "name", "name");
	}

	public AssetCategory updateCategory(
			long categoryId, long parentCategoryId,
			Map<Locale, String> titleMap, long vocabularyId,
			String[] categoryProperties, ServiceContext serviceContext)
		throws PortalException, SystemException {

		AssetCategoryPermission.check(
			getPermissionChecker(), categoryId, ActionKeys.UPDATE);

		return assetCategoryLocalService.updateCategory(
			getUserId(), categoryId, parentCategoryId, titleMap, vocabularyId,
			categoryProperties, serviceContext);
	}

	protected List<AssetCategory> filterCategories(
			List<AssetCategory> categories)
		throws PortalException {

		PermissionChecker permissionChecker = getPermissionChecker();

		categories = ListUtil.copy(categories);

		Iterator<AssetCategory> itr = categories.iterator();

		while (itr.hasNext()) {
			AssetCategory category = itr.next();

			if (!AssetCategoryPermission.contains(
					permissionChecker, category, ActionKeys.VIEW)) {

				itr.remove();
			}
		}

		return categories;
	}

}