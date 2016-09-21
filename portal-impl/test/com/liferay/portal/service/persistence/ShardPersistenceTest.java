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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchShardException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.Shard;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShardPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ShardPersistence)PortalBeanLocatorUtil.locate(ShardPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Shard shard = _persistence.create(pk);

		assertNotNull(shard);

		assertEquals(shard.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Shard newShard = addShard();

		_persistence.remove(newShard);

		Shard existingShard = _persistence.fetchByPrimaryKey(newShard.getPrimaryKey());

		assertNull(existingShard);
	}

	public void testUpdateNew() throws Exception {
		addShard();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Shard newShard = _persistence.create(pk);

		newShard.setClassNameId(nextLong());
		newShard.setClassPK(nextLong());
		newShard.setName(randomString());

		_persistence.update(newShard, false);

		Shard existingShard = _persistence.findByPrimaryKey(newShard.getPrimaryKey());

		assertEquals(existingShard.getShardId(), newShard.getShardId());
		assertEquals(existingShard.getClassNameId(), newShard.getClassNameId());
		assertEquals(existingShard.getClassPK(), newShard.getClassPK());
		assertEquals(existingShard.getName(), newShard.getName());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Shard newShard = addShard();

		Shard existingShard = _persistence.findByPrimaryKey(newShard.getPrimaryKey());

		assertEquals(existingShard, newShard);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchShardException");
		}
		catch (NoSuchShardException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Shard newShard = addShard();

		Shard existingShard = _persistence.fetchByPrimaryKey(newShard.getPrimaryKey());

		assertEquals(existingShard, newShard);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Shard missingShard = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingShard);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Shard newShard = addShard();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("shardId",
				newShard.getShardId()));

		List<Shard> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Shard existingShard = result.get(0);

		assertEquals(existingShard, newShard);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Shard.class,
				Shard.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("shardId", nextLong()));

		List<Shard> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Shard addShard() throws Exception {
		long pk = nextLong();

		Shard shard = _persistence.create(pk);

		shard.setClassNameId(nextLong());
		shard.setClassPK(nextLong());
		shard.setName(randomString());

		_persistence.update(shard, false);

		return shard;
	}

	private ShardPersistence _persistence;
}