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
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.TagPropertyKeyException;
import com.liferay.portlet.asset.TagPropertyValueException;
import com.liferay.portlet.asset.model.AssetTagProperty;
import com.liferay.portlet.asset.service.base.AssetTagPropertyLocalServiceBaseImpl;
import com.liferay.portlet.asset.util.AssetUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetTagPropertyLocalServiceImpl
	extends AssetTagPropertyLocalServiceBaseImpl {

	public AssetTagProperty addTagProperty(
			long userId, long tagId, String key, String value)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		validate(key, value);

		long tagPropertyId = counterLocalService.increment();

		AssetTagProperty tagProperty = assetTagPropertyPersistence.create(
			tagPropertyId);

		tagProperty.setCompanyId(user.getCompanyId());
		tagProperty.setUserId(user.getUserId());
		tagProperty.setUserName(user.getFullName());
		tagProperty.setCreateDate(now);
		tagProperty.setModifiedDate(now);
		tagProperty.setTagId(tagId);
		tagProperty.setKey(key);
		tagProperty.setValue(value);

		assetTagPropertyPersistence.update(tagProperty, false);

		return tagProperty;
	}

	public void deleteTagProperties(long tagId) throws SystemException {
		List<AssetTagProperty> tagProperties =
			assetTagPropertyPersistence.findByTagId(tagId);

		for (AssetTagProperty tagProperty : tagProperties) {
			deleteTagProperty(tagProperty);
		}
	}

	public void deleteTagProperty(AssetTagProperty tagProperty)
		throws SystemException {

		assetTagPropertyPersistence.remove(tagProperty);
	}

	public void deleteTagProperty(long tagPropertyId)
		throws PortalException, SystemException {

		AssetTagProperty tagProperty =
			assetTagPropertyPersistence.findByPrimaryKey(tagPropertyId);

		deleteTagProperty(tagProperty);
	}

	public List<AssetTagProperty> getTagProperties() throws SystemException {
		return assetTagPropertyPersistence.findAll();
	}

	public List<AssetTagProperty> getTagProperties(long tagId)
		throws SystemException {

		return assetTagPropertyPersistence.findByTagId(tagId);
	}

	public AssetTagProperty getTagProperty(long tagPropertyId)
		throws PortalException, SystemException {

		return assetTagPropertyPersistence.findByPrimaryKey(tagPropertyId);
	}

	public AssetTagProperty getTagProperty(long tagId, String key)
		throws PortalException, SystemException {

		return assetTagPropertyPersistence.findByT_K(tagId, key);
	}

	public String[] getTagPropertyKeys(long groupId) throws SystemException {
		return assetTagPropertyKeyFinder.findByGroupId(groupId);
	}

	public List<AssetTagProperty> getTagPropertyValues(long groupId, String key)
		throws SystemException {

		return assetTagPropertyFinder.findByG_K(groupId, key);
	}

	public AssetTagProperty updateTagProperty(
			long tagPropertyId, String key, String value)
		throws PortalException, SystemException {

		validate(key, value);

		AssetTagProperty tagProperty =
			assetTagPropertyPersistence.findByPrimaryKey(tagPropertyId);

		tagProperty.setModifiedDate(new Date());
		tagProperty.setKey(key);
		tagProperty.setValue(value);

		assetTagPropertyPersistence.update(tagProperty, false);

		return tagProperty;
	}

	protected void validate(String key, String value) throws PortalException {
		if (!AssetUtil.isValidWord(key)) {
			throw new TagPropertyKeyException();
		}

		if (!AssetUtil.isValidWord(value)) {
			throw new TagPropertyValueException();
		}
	}

}