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
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.wiki.NoSuchPageResourceException;
import com.liferay.portlet.wiki.model.WikiPageResource;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WikiPageResourcePersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (WikiPageResourcePersistence)PortalBeanLocatorUtil.locate(WikiPageResourcePersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		WikiPageResource wikiPageResource = _persistence.create(pk);

		assertNotNull(wikiPageResource);

		assertEquals(wikiPageResource.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		WikiPageResource newWikiPageResource = addWikiPageResource();

		_persistence.remove(newWikiPageResource);

		WikiPageResource existingWikiPageResource = _persistence.fetchByPrimaryKey(newWikiPageResource.getPrimaryKey());

		assertNull(existingWikiPageResource);
	}

	public void testUpdateNew() throws Exception {
		addWikiPageResource();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		WikiPageResource newWikiPageResource = _persistence.create(pk);

		newWikiPageResource.setUuid(randomString());
		newWikiPageResource.setNodeId(nextLong());
		newWikiPageResource.setTitle(randomString());

		_persistence.update(newWikiPageResource, false);

		WikiPageResource existingWikiPageResource = _persistence.findByPrimaryKey(newWikiPageResource.getPrimaryKey());

		assertEquals(existingWikiPageResource.getUuid(),
			newWikiPageResource.getUuid());
		assertEquals(existingWikiPageResource.getResourcePrimKey(),
			newWikiPageResource.getResourcePrimKey());
		assertEquals(existingWikiPageResource.getNodeId(),
			newWikiPageResource.getNodeId());
		assertEquals(existingWikiPageResource.getTitle(),
			newWikiPageResource.getTitle());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		WikiPageResource newWikiPageResource = addWikiPageResource();

		WikiPageResource existingWikiPageResource = _persistence.findByPrimaryKey(newWikiPageResource.getPrimaryKey());

		assertEquals(existingWikiPageResource, newWikiPageResource);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchPageResourceException");
		}
		catch (NoSuchPageResourceException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		WikiPageResource newWikiPageResource = addWikiPageResource();

		WikiPageResource existingWikiPageResource = _persistence.fetchByPrimaryKey(newWikiPageResource.getPrimaryKey());

		assertEquals(existingWikiPageResource, newWikiPageResource);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		WikiPageResource missingWikiPageResource = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingWikiPageResource);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		WikiPageResource newWikiPageResource = addWikiPageResource();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WikiPageResource.class,
				WikiPageResource.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePrimKey",
				newWikiPageResource.getResourcePrimKey()));

		List<WikiPageResource> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		WikiPageResource existingWikiPageResource = result.get(0);

		assertEquals(existingWikiPageResource, newWikiPageResource);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(WikiPageResource.class,
				WikiPageResource.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("resourcePrimKey",
				nextLong()));

		List<WikiPageResource> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected WikiPageResource addWikiPageResource() throws Exception {
		long pk = nextLong();

		WikiPageResource wikiPageResource = _persistence.create(pk);

		wikiPageResource.setUuid(randomString());
		wikiPageResource.setNodeId(nextLong());
		wikiPageResource.setTitle(randomString());

		_persistence.update(wikiPageResource, false);

		return wikiPageResource;
	}

	private WikiPageResourcePersistence _persistence;
}