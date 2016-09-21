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

import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetVocabulary;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetVocabularyPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (AssetVocabularyPersistence)PortalBeanLocatorUtil.locate(AssetVocabularyPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		AssetVocabulary assetVocabulary = _persistence.create(pk);

		assertNotNull(assetVocabulary);

		assertEquals(assetVocabulary.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		AssetVocabulary newAssetVocabulary = addAssetVocabulary();

		_persistence.remove(newAssetVocabulary);

		AssetVocabulary existingAssetVocabulary = _persistence.fetchByPrimaryKey(newAssetVocabulary.getPrimaryKey());

		assertNull(existingAssetVocabulary);
	}

	public void testUpdateNew() throws Exception {
		addAssetVocabulary();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		AssetVocabulary newAssetVocabulary = _persistence.create(pk);

		newAssetVocabulary.setUuid(randomString());
		newAssetVocabulary.setGroupId(nextLong());
		newAssetVocabulary.setCompanyId(nextLong());
		newAssetVocabulary.setUserId(nextLong());
		newAssetVocabulary.setUserName(randomString());
		newAssetVocabulary.setCreateDate(nextDate());
		newAssetVocabulary.setModifiedDate(nextDate());
		newAssetVocabulary.setName(randomString());
		newAssetVocabulary.setTitle(randomString());
		newAssetVocabulary.setDescription(randomString());
		newAssetVocabulary.setSettings(randomString());

		_persistence.update(newAssetVocabulary, false);

		AssetVocabulary existingAssetVocabulary = _persistence.findByPrimaryKey(newAssetVocabulary.getPrimaryKey());

		assertEquals(existingAssetVocabulary.getUuid(),
			newAssetVocabulary.getUuid());
		assertEquals(existingAssetVocabulary.getVocabularyId(),
			newAssetVocabulary.getVocabularyId());
		assertEquals(existingAssetVocabulary.getGroupId(),
			newAssetVocabulary.getGroupId());
		assertEquals(existingAssetVocabulary.getCompanyId(),
			newAssetVocabulary.getCompanyId());
		assertEquals(existingAssetVocabulary.getUserId(),
			newAssetVocabulary.getUserId());
		assertEquals(existingAssetVocabulary.getUserName(),
			newAssetVocabulary.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingAssetVocabulary.getCreateDate()),
			Time.getShortTimestamp(newAssetVocabulary.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingAssetVocabulary.getModifiedDate()),
			Time.getShortTimestamp(newAssetVocabulary.getModifiedDate()));
		assertEquals(existingAssetVocabulary.getName(),
			newAssetVocabulary.getName());
		assertEquals(existingAssetVocabulary.getTitle(),
			newAssetVocabulary.getTitle());
		assertEquals(existingAssetVocabulary.getDescription(),
			newAssetVocabulary.getDescription());
		assertEquals(existingAssetVocabulary.getSettings(),
			newAssetVocabulary.getSettings());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		AssetVocabulary newAssetVocabulary = addAssetVocabulary();

		AssetVocabulary existingAssetVocabulary = _persistence.findByPrimaryKey(newAssetVocabulary.getPrimaryKey());

		assertEquals(existingAssetVocabulary, newAssetVocabulary);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchVocabularyException");
		}
		catch (NoSuchVocabularyException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		AssetVocabulary newAssetVocabulary = addAssetVocabulary();

		AssetVocabulary existingAssetVocabulary = _persistence.fetchByPrimaryKey(newAssetVocabulary.getPrimaryKey());

		assertEquals(existingAssetVocabulary, newAssetVocabulary);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		AssetVocabulary missingAssetVocabulary = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingAssetVocabulary);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AssetVocabulary newAssetVocabulary = addAssetVocabulary();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetVocabulary.class,
				AssetVocabulary.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("vocabularyId",
				newAssetVocabulary.getVocabularyId()));

		List<AssetVocabulary> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		AssetVocabulary existingAssetVocabulary = result.get(0);

		assertEquals(existingAssetVocabulary, newAssetVocabulary);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetVocabulary.class,
				AssetVocabulary.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("vocabularyId", nextLong()));

		List<AssetVocabulary> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected AssetVocabulary addAssetVocabulary() throws Exception {
		long pk = nextLong();

		AssetVocabulary assetVocabulary = _persistence.create(pk);

		assetVocabulary.setUuid(randomString());
		assetVocabulary.setGroupId(nextLong());
		assetVocabulary.setCompanyId(nextLong());
		assetVocabulary.setUserId(nextLong());
		assetVocabulary.setUserName(randomString());
		assetVocabulary.setCreateDate(nextDate());
		assetVocabulary.setModifiedDate(nextDate());
		assetVocabulary.setName(randomString());
		assetVocabulary.setTitle(randomString());
		assetVocabulary.setDescription(randomString());
		assetVocabulary.setSettings(randomString());

		_persistence.update(assetVocabulary, false);

		return assetVocabulary;
	}

	private AssetVocabularyPersistence _persistence;
}