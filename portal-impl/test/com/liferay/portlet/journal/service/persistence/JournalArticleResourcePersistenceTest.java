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

package com.liferay.portlet.journal.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.journal.NoSuchArticleResourceException;
import com.liferay.portlet.journal.model.JournalArticleResource;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class JournalArticleResourcePersistenceTest
	extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (JournalArticleResourcePersistence)PortalBeanLocatorUtil.locate(JournalArticleResourcePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		JournalArticleResource journalArticleResource = _persistence.create(pk);

		assertNotNull(journalArticleResource);

		assertEquals(journalArticleResource.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		JournalArticleResource newJournalArticleResource = addJournalArticleResource();

		_persistence.remove(newJournalArticleResource);

		JournalArticleResource existingJournalArticleResource = _persistence.fetchByPrimaryKey(newJournalArticleResource.getPrimaryKey());

		assertNull(existingJournalArticleResource);
	}

	public void testUpdateNew() throws Exception {
		addJournalArticleResource();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		JournalArticleResource newJournalArticleResource = _persistence.create(pk);

		newJournalArticleResource.setUuid(randomString());
		newJournalArticleResource.setGroupId(nextLong());
		newJournalArticleResource.setArticleId(randomString());

		_persistence.update(newJournalArticleResource, false);

		JournalArticleResource existingJournalArticleResource = _persistence.findByPrimaryKey(newJournalArticleResource.getPrimaryKey());

		assertEquals(existingJournalArticleResource.getUuid(),
			newJournalArticleResource.getUuid());
		assertEquals(existingJournalArticleResource.getResourcePrimKey(),
			newJournalArticleResource.getResourcePrimKey());
		assertEquals(existingJournalArticleResource.getGroupId(),
			newJournalArticleResource.getGroupId());
		assertEquals(existingJournalArticleResource.getArticleId(),
			newJournalArticleResource.getArticleId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		JournalArticleResource newJournalArticleResource = addJournalArticleResource();

		JournalArticleResource existingJournalArticleResource = _persistence.findByPrimaryKey(newJournalArticleResource.getPrimaryKey());

		assertEquals(existingJournalArticleResource, newJournalArticleResource);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchArticleResourceException");
		}
		catch (NoSuchArticleResourceException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		JournalArticleResource newJournalArticleResource = addJournalArticleResource();

		JournalArticleResource existingJournalArticleResource = _persistence.fetchByPrimaryKey(newJournalArticleResource.getPrimaryKey());

		assertEquals(existingJournalArticleResource, newJournalArticleResource);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		JournalArticleResource missingJournalArticleResource = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingJournalArticleResource);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		JournalArticleResource newJournalArticleResource = addJournalArticleResource();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleResource.class,
				JournalArticleResource.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePrimKey",
				newJournalArticleResource.getResourcePrimKey()));

		List<JournalArticleResource> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		JournalArticleResource existingJournalArticleResource = result.get(0);

		assertEquals(existingJournalArticleResource, newJournalArticleResource);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleResource.class,
				JournalArticleResource.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePrimKey",
				nextLong()));

		List<JournalArticleResource> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected JournalArticleResource addJournalArticleResource()
		throws Exception {
		long pk = nextLong();

		JournalArticleResource journalArticleResource = _persistence.create(pk);

		journalArticleResource.setUuid(randomString());
		journalArticleResource.setGroupId(nextLong());
		journalArticleResource.setArticleId(randomString());

		_persistence.update(journalArticleResource, false);

		return journalArticleResource;
	}

	private JournalArticleResourcePersistence _persistence;
}