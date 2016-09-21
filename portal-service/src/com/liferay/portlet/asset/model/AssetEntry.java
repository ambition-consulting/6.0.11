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
 * The model interface for the AssetEntry service. Represents a row in the &quot;AssetEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.asset.model.impl.AssetEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntryModel
 * @see com.liferay.portlet.asset.model.impl.AssetEntryImpl
 * @see com.liferay.portlet.asset.model.impl.AssetEntryModelImpl
 * @generated
 */
public interface AssetEntry extends AssetEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a asset entry model instance should use the {@link AssetEntry} interface instead.
	 */
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getCategories()
		throws com.liferay.portal.kernel.exception.SystemException;

	public long[] getCategoryIds()
		throws com.liferay.portal.kernel.exception.SystemException;

	public double getSocialInformationEquity();

	public java.lang.String[] getTagNames()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portlet.asset.model.AssetTag> getTags()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateSocialInformationEquity(double value);
}