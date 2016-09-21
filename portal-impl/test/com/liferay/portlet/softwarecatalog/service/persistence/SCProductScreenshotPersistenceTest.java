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

package com.liferay.portlet.softwarecatalog.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.softwarecatalog.NoSuchProductScreenshotException;
import com.liferay.portlet.softwarecatalog.model.SCProductScreenshot;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SCProductScreenshotPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SCProductScreenshotPersistence)PortalBeanLocatorUtil.locate(SCProductScreenshotPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SCProductScreenshot scProductScreenshot = _persistence.create(pk);

		assertNotNull(scProductScreenshot);

		assertEquals(scProductScreenshot.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SCProductScreenshot newSCProductScreenshot = addSCProductScreenshot();

		_persistence.remove(newSCProductScreenshot);

		SCProductScreenshot existingSCProductScreenshot = _persistence.fetchByPrimaryKey(newSCProductScreenshot.getPrimaryKey());

		assertNull(existingSCProductScreenshot);
	}

	public void testUpdateNew() throws Exception {
		addSCProductScreenshot();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SCProductScreenshot newSCProductScreenshot = _persistence.create(pk);

		newSCProductScreenshot.setCompanyId(nextLong());
		newSCProductScreenshot.setGroupId(nextLong());
		newSCProductScreenshot.setProductEntryId(nextLong());
		newSCProductScreenshot.setThumbnailId(nextLong());
		newSCProductScreenshot.setFullImageId(nextLong());
		newSCProductScreenshot.setPriority(nextInt());

		_persistence.update(newSCProductScreenshot, false);

		SCProductScreenshot existingSCProductScreenshot = _persistence.findByPrimaryKey(newSCProductScreenshot.getPrimaryKey());

		assertEquals(existingSCProductScreenshot.getProductScreenshotId(),
			newSCProductScreenshot.getProductScreenshotId());
		assertEquals(existingSCProductScreenshot.getCompanyId(),
			newSCProductScreenshot.getCompanyId());
		assertEquals(existingSCProductScreenshot.getGroupId(),
			newSCProductScreenshot.getGroupId());
		assertEquals(existingSCProductScreenshot.getProductEntryId(),
			newSCProductScreenshot.getProductEntryId());
		assertEquals(existingSCProductScreenshot.getThumbnailId(),
			newSCProductScreenshot.getThumbnailId());
		assertEquals(existingSCProductScreenshot.getFullImageId(),
			newSCProductScreenshot.getFullImageId());
		assertEquals(existingSCProductScreenshot.getPriority(),
			newSCProductScreenshot.getPriority());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SCProductScreenshot newSCProductScreenshot = addSCProductScreenshot();

		SCProductScreenshot existingSCProductScreenshot = _persistence.findByPrimaryKey(newSCProductScreenshot.getPrimaryKey());

		assertEquals(existingSCProductScreenshot, newSCProductScreenshot);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchProductScreenshotException");
		}
		catch (NoSuchProductScreenshotException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SCProductScreenshot newSCProductScreenshot = addSCProductScreenshot();

		SCProductScreenshot existingSCProductScreenshot = _persistence.fetchByPrimaryKey(newSCProductScreenshot.getPrimaryKey());

		assertEquals(existingSCProductScreenshot, newSCProductScreenshot);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SCProductScreenshot missingSCProductScreenshot = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSCProductScreenshot);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SCProductScreenshot newSCProductScreenshot = addSCProductScreenshot();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SCProductScreenshot.class,
				SCProductScreenshot.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("productScreenshotId",
				newSCProductScreenshot.getProductScreenshotId()));

		List<SCProductScreenshot> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SCProductScreenshot existingSCProductScreenshot = result.get(0);

		assertEquals(existingSCProductScreenshot, newSCProductScreenshot);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SCProductScreenshot.class,
				SCProductScreenshot.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("productScreenshotId",
				nextLong()));

		List<SCProductScreenshot> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SCProductScreenshot addSCProductScreenshot()
		throws Exception {
		long pk = nextLong();

		SCProductScreenshot scProductScreenshot = _persistence.create(pk);

		scProductScreenshot.setCompanyId(nextLong());
		scProductScreenshot.setGroupId(nextLong());
		scProductScreenshot.setProductEntryId(nextLong());
		scProductScreenshot.setThumbnailId(nextLong());
		scProductScreenshot.setFullImageId(nextLong());
		scProductScreenshot.setPriority(nextInt());

		_persistence.update(scProductScreenshot, false);

		return scProductScreenshot;
	}

	private SCProductScreenshotPersistence _persistence;
}