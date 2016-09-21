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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.asset.NoSuchCategoryPropertyException;
import com.liferay.portlet.asset.model.AssetCategoryProperty;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetCategoryPropertyPersistenceTest
	extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (AssetCategoryPropertyPersistence)PortalBeanLocatorUtil.locate(AssetCategoryPropertyPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		AssetCategoryProperty assetCategoryProperty = _persistence.create(pk);

		assertNotNull(assetCategoryProperty);

		assertEquals(assetCategoryProperty.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		AssetCategoryProperty newAssetCategoryProperty = addAssetCategoryProperty();

		_persistence.remove(newAssetCategoryProperty);

		AssetCategoryProperty existingAssetCategoryProperty = _persistence.fetchByPrimaryKey(newAssetCategoryProperty.getPrimaryKey());

		assertNull(existingAssetCategoryProperty);
	}

	public void testUpdateNew() throws Exception {
		addAssetCategoryProperty();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		AssetCategoryProperty newAssetCategoryProperty = _persistence.create(pk);

		newAssetCategoryProperty.setCompanyId(nextLong());
		newAssetCategoryProperty.setUserId(nextLong());
		newAssetCategoryProperty.setUserName(randomString());
		newAssetCategoryProperty.setCreateDate(nextDate());
		newAssetCategoryProperty.setModifiedDate(nextDate());
		newAssetCategoryProperty.setCategoryId(nextLong());
		newAssetCategoryProperty.setKey(randomString());
		newAssetCategoryProperty.setValue(randomString());

		_persistence.update(newAssetCategoryProperty, false);

		AssetCategoryProperty existingAssetCategoryProperty = _persistence.findByPrimaryKey(newAssetCategoryProperty.getPrimaryKey());

		assertEquals(existingAssetCategoryProperty.getCategoryPropertyId(),
			newAssetCategoryProperty.getCategoryPropertyId());
		assertEquals(existingAssetCategoryProperty.getCompanyId(),
			newAssetCategoryProperty.getCompanyId());
		assertEquals(existingAssetCategoryProperty.getUserId(),
			newAssetCategoryProperty.getUserId());
		assertEquals(existingAssetCategoryProperty.getUserName(),
			newAssetCategoryProperty.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingAssetCategoryProperty.getCreateDate()),
			Time.getShortTimestamp(newAssetCategoryProperty.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingAssetCategoryProperty.getModifiedDate()),
			Time.getShortTimestamp(newAssetCategoryProperty.getModifiedDate()));
		assertEquals(existingAssetCategoryProperty.getCategoryId(),
			newAssetCategoryProperty.getCategoryId());
		assertEquals(existingAssetCategoryProperty.getKey(),
			newAssetCategoryProperty.getKey());
		assertEquals(existingAssetCategoryProperty.getValue(),
			newAssetCategoryProperty.getValue());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		AssetCategoryProperty newAssetCategoryProperty = addAssetCategoryProperty();

		AssetCategoryProperty existingAssetCategoryProperty = _persistence.findByPrimaryKey(newAssetCategoryProperty.getPrimaryKey());

		assertEquals(existingAssetCategoryProperty, newAssetCategoryProperty);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchCategoryPropertyException");
		}
		catch (NoSuchCategoryPropertyException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		AssetCategoryProperty newAssetCategoryProperty = addAssetCategoryProperty();

		AssetCategoryProperty existingAssetCategoryProperty = _persistence.fetchByPrimaryKey(newAssetCategoryProperty.getPrimaryKey());

		assertEquals(existingAssetCategoryProperty, newAssetCategoryProperty);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		AssetCategoryProperty missingAssetCategoryProperty = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingAssetCategoryProperty);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AssetCategoryProperty newAssetCategoryProperty = addAssetCategoryProperty();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetCategoryProperty.class,
				AssetCategoryProperty.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("categoryPropertyId",
				newAssetCategoryProperty.getCategoryPropertyId()));

		List<AssetCategoryProperty> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		AssetCategoryProperty existingAssetCategoryProperty = result.get(0);

		assertEquals(existingAssetCategoryProperty, newAssetCategoryProperty);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetCategoryProperty.class,
				AssetCategoryProperty.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("categoryPropertyId",
				nextLong()));

		List<AssetCategoryProperty> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected AssetCategoryProperty addAssetCategoryProperty()
		throws Exception {
		long pk = nextLong();

		AssetCategoryProperty assetCategoryProperty = _persistence.create(pk);

		assetCategoryProperty.setCompanyId(nextLong());
		assetCategoryProperty.setUserId(nextLong());
		assetCategoryProperty.setUserName(randomString());
		assetCategoryProperty.setCreateDate(nextDate());
		assetCategoryProperty.setModifiedDate(nextDate());
		assetCategoryProperty.setCategoryId(nextLong());
		assetCategoryProperty.setKey(randomString());
		assetCategoryProperty.setValue(randomString());

		_persistence.update(assetCategoryProperty, false);

		return assetCategoryProperty;
	}

	private AssetCategoryPropertyPersistence _persistence;
}