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

import com.liferay.portlet.asset.NoSuchLinkException;
import com.liferay.portlet.asset.model.AssetLink;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetLinkPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (AssetLinkPersistence)PortalBeanLocatorUtil.locate(AssetLinkPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		AssetLink assetLink = _persistence.create(pk);

		assertNotNull(assetLink);

		assertEquals(assetLink.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		AssetLink newAssetLink = addAssetLink();

		_persistence.remove(newAssetLink);

		AssetLink existingAssetLink = _persistence.fetchByPrimaryKey(newAssetLink.getPrimaryKey());

		assertNull(existingAssetLink);
	}

	public void testUpdateNew() throws Exception {
		addAssetLink();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		AssetLink newAssetLink = _persistence.create(pk);

		newAssetLink.setCompanyId(nextLong());
		newAssetLink.setUserId(nextLong());
		newAssetLink.setUserName(randomString());
		newAssetLink.setCreateDate(nextDate());
		newAssetLink.setEntryId1(nextLong());
		newAssetLink.setEntryId2(nextLong());
		newAssetLink.setType(nextInt());
		newAssetLink.setWeight(nextInt());

		_persistence.update(newAssetLink, false);

		AssetLink existingAssetLink = _persistence.findByPrimaryKey(newAssetLink.getPrimaryKey());

		assertEquals(existingAssetLink.getLinkId(), newAssetLink.getLinkId());
		assertEquals(existingAssetLink.getCompanyId(),
			newAssetLink.getCompanyId());
		assertEquals(existingAssetLink.getUserId(), newAssetLink.getUserId());
		assertEquals(existingAssetLink.getUserName(), newAssetLink.getUserName());
		assertEquals(Time.getShortTimestamp(existingAssetLink.getCreateDate()),
			Time.getShortTimestamp(newAssetLink.getCreateDate()));
		assertEquals(existingAssetLink.getEntryId1(), newAssetLink.getEntryId1());
		assertEquals(existingAssetLink.getEntryId2(), newAssetLink.getEntryId2());
		assertEquals(existingAssetLink.getType(), newAssetLink.getType());
		assertEquals(existingAssetLink.getWeight(), newAssetLink.getWeight());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		AssetLink newAssetLink = addAssetLink();

		AssetLink existingAssetLink = _persistence.findByPrimaryKey(newAssetLink.getPrimaryKey());

		assertEquals(existingAssetLink, newAssetLink);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchLinkException");
		}
		catch (NoSuchLinkException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		AssetLink newAssetLink = addAssetLink();

		AssetLink existingAssetLink = _persistence.fetchByPrimaryKey(newAssetLink.getPrimaryKey());

		assertEquals(existingAssetLink, newAssetLink);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		AssetLink missingAssetLink = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingAssetLink);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AssetLink newAssetLink = addAssetLink();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetLink.class,
				AssetLink.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("linkId",
				newAssetLink.getLinkId()));

		List<AssetLink> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		AssetLink existingAssetLink = result.get(0);

		assertEquals(existingAssetLink, newAssetLink);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetLink.class,
				AssetLink.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("linkId", nextLong()));

		List<AssetLink> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected AssetLink addAssetLink() throws Exception {
		long pk = nextLong();

		AssetLink assetLink = _persistence.create(pk);

		assetLink.setCompanyId(nextLong());
		assetLink.setUserId(nextLong());
		assetLink.setUserName(randomString());
		assetLink.setCreateDate(nextDate());
		assetLink.setEntryId1(nextLong());
		assetLink.setEntryId2(nextLong());
		assetLink.setType(nextInt());
		assetLink.setWeight(nextInt());

		_persistence.update(assetLink, false);

		return assetLink;
	}

	private AssetLinkPersistence _persistence;
}