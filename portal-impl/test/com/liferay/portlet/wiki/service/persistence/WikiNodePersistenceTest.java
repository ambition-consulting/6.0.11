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

package com.liferay.portlet.wiki.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.wiki.NoSuchNodeException;
import com.liferay.portlet.wiki.model.WikiNode;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiNodePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (WikiNodePersistence)PortalBeanLocatorUtil.locate(WikiNodePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		WikiNode wikiNode = _persistence.create(pk);

		assertNotNull(wikiNode);

		assertEquals(wikiNode.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		WikiNode newWikiNode = addWikiNode();

		_persistence.remove(newWikiNode);

		WikiNode existingWikiNode = _persistence.fetchByPrimaryKey(newWikiNode.getPrimaryKey());

		assertNull(existingWikiNode);
	}

	public void testUpdateNew() throws Exception {
		addWikiNode();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		WikiNode newWikiNode = _persistence.create(pk);

		newWikiNode.setUuid(randomString());
		newWikiNode.setGroupId(nextLong());
		newWikiNode.setCompanyId(nextLong());
		newWikiNode.setUserId(nextLong());
		newWikiNode.setUserName(randomString());
		newWikiNode.setCreateDate(nextDate());
		newWikiNode.setModifiedDate(nextDate());
		newWikiNode.setName(randomString());
		newWikiNode.setDescription(randomString());
		newWikiNode.setLastPostDate(nextDate());

		_persistence.update(newWikiNode, false);

		WikiNode existingWikiNode = _persistence.findByPrimaryKey(newWikiNode.getPrimaryKey());

		assertEquals(existingWikiNode.getUuid(), newWikiNode.getUuid());
		assertEquals(existingWikiNode.getNodeId(), newWikiNode.getNodeId());
		assertEquals(existingWikiNode.getGroupId(), newWikiNode.getGroupId());
		assertEquals(existingWikiNode.getCompanyId(), newWikiNode.getCompanyId());
		assertEquals(existingWikiNode.getUserId(), newWikiNode.getUserId());
		assertEquals(existingWikiNode.getUserName(), newWikiNode.getUserName());
		assertEquals(Time.getShortTimestamp(existingWikiNode.getCreateDate()),
			Time.getShortTimestamp(newWikiNode.getCreateDate()));
		assertEquals(Time.getShortTimestamp(existingWikiNode.getModifiedDate()),
			Time.getShortTimestamp(newWikiNode.getModifiedDate()));
		assertEquals(existingWikiNode.getName(), newWikiNode.getName());
		assertEquals(existingWikiNode.getDescription(),
			newWikiNode.getDescription());
		assertEquals(Time.getShortTimestamp(existingWikiNode.getLastPostDate()),
			Time.getShortTimestamp(newWikiNode.getLastPostDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		WikiNode newWikiNode = addWikiNode();

		WikiNode existingWikiNode = _persistence.findByPrimaryKey(newWikiNode.getPrimaryKey());

		assertEquals(existingWikiNode, newWikiNode);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchNodeException");
		}
		catch (NoSuchNodeException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		WikiNode newWikiNode = addWikiNode();

		WikiNode existingWikiNode = _persistence.fetchByPrimaryKey(newWikiNode.getPrimaryKey());

		assertEquals(existingWikiNode, newWikiNode);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		WikiNode missingWikiNode = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingWikiNode);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		WikiNode newWikiNode = addWikiNode();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WikiNode.class,
				WikiNode.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("nodeId",
				newWikiNode.getNodeId()));

		List<WikiNode> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		WikiNode existingWikiNode = result.get(0);

		assertEquals(existingWikiNode, newWikiNode);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WikiNode.class,
				WikiNode.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("nodeId", nextLong()));

		List<WikiNode> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected WikiNode addWikiNode() throws Exception {
		long pk = nextLong();

		WikiNode wikiNode = _persistence.create(pk);

		wikiNode.setUuid(randomString());
		wikiNode.setGroupId(nextLong());
		wikiNode.setCompanyId(nextLong());
		wikiNode.setUserId(nextLong());
		wikiNode.setUserName(randomString());
		wikiNode.setCreateDate(nextDate());
		wikiNode.setModifiedDate(nextDate());
		wikiNode.setName(randomString());
		wikiNode.setDescription(randomString());
		wikiNode.setLastPostDate(nextDate());

		_persistence.update(wikiNode, false);

		return wikiNode;
	}

	private WikiNodePersistence _persistence;
}