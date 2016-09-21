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

package com.liferay.portlet.asset.model;

/**
 * The model interface for the AssetCategory service. Represents a row in the &quot;AssetCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.asset.model.impl.AssetCategoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryModel
 * @see com.liferay.portlet.asset.model.impl.AssetCategoryImpl
 * @see com.liferay.portlet.asset.model.impl.AssetCategoryModelImpl
 * @generated
 */
public interface AssetCategory extends AssetCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a asset category model instance should use the {@link AssetCategory} interface instead.
	 */
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean isRootCategory();
}