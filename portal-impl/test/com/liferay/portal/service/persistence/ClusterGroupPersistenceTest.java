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

import com.liferay.portal.NoSuchClusterGroupException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.ClusterGroup;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClusterGroupPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (ClusterGroupPersistence)PortalBeanLocatorUtil.locate(ClusterGroupPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		ClusterGroup clusterGroup = _persistence.create(pk);

		assertNotNull(clusterGroup);

		assertEquals(clusterGroup.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		ClusterGroup newClusterGroup = addClusterGroup();

		_persistence.remove(newClusterGroup);

		ClusterGroup existingClusterGroup = _persistence.fetchByPrimaryKey(newClusterGroup.getPrimaryKey());

		assertNull(existingClusterGroup);
	}

	public void testUpdateNew() throws Exception {
		addClusterGroup();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		ClusterGroup newClusterGroup = _persistence.create(pk);

		newClusterGroup.setName(randomString());
		newClusterGroup.setClusterNodeIds(randomString());
		newClusterGroup.setWholeCluster(randomBoolean());

		_persistence.update(newClusterGroup, false);

		ClusterGroup existingClusterGroup = _persistence.findByPrimaryKey(newClusterGroup.getPrimaryKey());

		assertEquals(existingClusterGroup.getClusterGroupId(),
			newClusterGroup.getClusterGroupId());
		assertEquals(existingClusterGroup.getName(), newClusterGroup.getName());
		assertEquals(existingClusterGroup.getClusterNodeIds(),
			newClusterGroup.getClusterNodeIds());
		assertEquals(existingClusterGroup.getWholeCluster(),
			newClusterGroup.getWholeCluster());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		ClusterGroup newClusterGroup = addClusterGroup();

		ClusterGroup existingClusterGroup = _persistence.findByPrimaryKey(newClusterGroup.getPrimaryKey());

		assertEquals(existingClusterGroup, newClusterGroup);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchClusterGroupException");
		}
		catch (NoSuchClusterGroupException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		ClusterGroup newClusterGroup = addClusterGroup();

		ClusterGroup existingClusterGroup = _persistence.fetchByPrimaryKey(newClusterGroup.getPrimaryKey());

		assertEquals(existingClusterGroup, newClusterGroup);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		ClusterGroup missingClusterGroup = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingClusterGroup);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ClusterGroup newClusterGroup = addClusterGroup();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ClusterGroup.class,
				ClusterGroup.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("clusterGroupId",
				newClusterGroup.getClusterGroupId()));

		List<ClusterGroup> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		ClusterGroup existingClusterGroup = result.get(0);

		assertEquals(existingClusterGroup, newClusterGroup);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ClusterGroup.class,
				ClusterGroup.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("clusterGroupId", nextLong()));

		List<ClusterGroup> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected ClusterGroup addClusterGroup() throws Exception {
		long pk = nextLong();

		ClusterGroup clusterGroup = _persistence.create(pk);

		clusterGroup.setName(randomString());
		clusterGroup.setClusterNodeIds(randomString());
		clusterGroup.setWholeCluster(randomBoolean());

		_persistence.update(clusterGroup, false);

		return clusterGroup;
	}

	private ClusterGroupPersistence _persistence;
}