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

package com.liferay.portlet.shopping.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.service.base.ShoppingCategoryServiceBaseImpl;
import com.liferay.portlet.shopping.service.permission.ShoppingCategoryPermission;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCategoryServiceImpl
	extends ShoppingCategoryServiceBaseImpl {

	public ShoppingCategory addCategory(
			long parentCategoryId, String name, String description,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ShoppingCategoryPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			parentCategoryId, ActionKeys.ADD_CATEGORY);

		return shoppingCategoryLocalService.addCategory(
			getUserId(), parentCategoryId, name, description, serviceContext);
	}

	public void deleteCategory(long categoryId)
		throws PortalException, SystemException {

		ShoppingCategory category = shoppingCategoryLocalService.getCategory(
			categoryId);

		ShoppingCategoryPermission.check(
			getPermissionChecker(), category, ActionKeys.DELETE);

		shoppingCategoryLocalService.deleteCategory(categoryId);
	}

	public ShoppingCategory getCategory(long categoryId)
		throws PortalException, SystemException {

		ShoppingCategory category = shoppingCategoryLocalService.getCategory(
			categoryId);

		ShoppingCategoryPermission.check(
			getPermissionChecker(), category, ActionKeys.VIEW);

		return category;
	}

	public ShoppingCategory updateCategory(
			long categoryId, long parentCategoryId, String name,
			String description, boolean mergeWithParentCategory,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ShoppingCategory category = shoppingCategoryLocalService.getCategory(
			categoryId);

		ShoppingCategoryPermission.check(
			getPermissionChecker(), category, ActionKeys.UPDATE);

		return shoppingCategoryLocalService.updateCategory(
			categoryId, parentCategoryId, name, description,
			mergeWithParentCategory, serviceContext);
	}

}