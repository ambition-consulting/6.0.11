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

package com.liferay.portlet.shopping.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the shopping item remote service. This utility wraps {@link com.liferay.portlet.shopping.service.impl.ShoppingItemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemService
 * @see com.liferay.portlet.shopping.service.base.ShoppingItemServiceBaseImpl
 * @see com.liferay.portlet.shopping.service.impl.ShoppingItemServiceImpl
 * @generated
 */
public class ShoppingItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.shopping.service.impl.ShoppingItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addBookItems(long groupId, long categoryId,
		java.lang.String[] isbns)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addBookItems(groupId, categoryId, isbns);
	}

	public static com.liferay.portlet.shopping.model.ShoppingItem addItem(
		long groupId, long categoryId, java.lang.String sku,
		java.lang.String name, java.lang.String description,
		java.lang.String properties, java.lang.String fieldsQuantities,
		boolean requiresShipping, int stockQuantity, boolean featured,
		java.lang.Boolean sale, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		boolean mediumImage, java.lang.String mediumImageURL,
		java.io.File mediumFile, boolean largeImage,
		java.lang.String largeImageURL, java.io.File largeFile,
		java.util.List<com.liferay.portlet.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.portlet.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addItem(groupId, categoryId, sku, name, description,
			properties, fieldsQuantities, requiresShipping, stockQuantity,
			featured, sale, smallImage, smallImageURL, smallFile, mediumImage,
			mediumImageURL, mediumFile, largeImage, largeImageURL, largeFile,
			itemFields, itemPrices, serviceContext);
	}

	public static void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteItem(itemId);
	}

	public static com.liferay.portlet.shopping.model.ShoppingItem getItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItem(itemId);
	}

	public static com.liferay.portlet.shopping.model.ShoppingItem updateItem(
		long itemId, long groupId, long categoryId, java.lang.String sku,
		java.lang.String name, java.lang.String description,
		java.lang.String properties, java.lang.String fieldsQuantities,
		boolean requiresShipping, int stockQuantity, boolean featured,
		java.lang.Boolean sale, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		boolean mediumImage, java.lang.String mediumImageURL,
		java.io.File mediumFile, boolean largeImage,
		java.lang.String largeImageURL, java.io.File largeFile,
		java.util.List<com.liferay.portlet.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.portlet.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateItem(itemId, groupId, categoryId, sku, name,
			description, properties, fieldsQuantities, requiresShipping,
			stockQuantity, featured, sale, smallImage, smallImageURL,
			smallFile, mediumImage, mediumImageURL, mediumFile, largeImage,
			largeImageURL, largeFile, itemFields, itemPrices, serviceContext);
	}

	public static ShoppingItemService getService() {
		if (_service == null) {
			_service = (ShoppingItemService)PortalBeanLocatorUtil.locate(ShoppingItemService.class.getName());

			ReferenceRegistry.registerReference(ShoppingItemServiceUtil.class,
				"_service");
			MethodCache.remove(ShoppingItemService.class);
		}

		return _service;
	}

	public void setService(ShoppingItemService service) {
		MethodCache.remove(ShoppingItemService.class);

		_service = service;

		ReferenceRegistry.registerReference(ShoppingItemServiceUtil.class,
			"_service");
		MethodCache.remove(ShoppingItemService.class);
	}

	private static ShoppingItemService _service;
}