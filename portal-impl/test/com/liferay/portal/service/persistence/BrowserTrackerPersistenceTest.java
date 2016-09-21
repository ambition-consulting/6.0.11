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

import com.liferay.portal.NoSuchBrowserTrackerException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.model.BrowserTracker;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class BrowserTrackerPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (BrowserTrackerPersistence)PortalBeanLocatorUtil.locate(BrowserTrackerPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		BrowserTracker browserTracker = _persistence.create(pk);

		assertNotNull(browserTracker);

		assertEquals(browserTracker.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		BrowserTracker newBrowserTracker = addBrowserTracker();

		_persistence.remove(newBrowserTracker);

		BrowserTracker existingBrowserTracker = _persistence.fetchByPrimaryKey(newBrowserTracker.getPrimaryKey());

		assertNull(existingBrowserTracker);
	}

	public void testUpdateNew() throws Exception {
		addBrowserTracker();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		BrowserTracker newBrowserTracker = _persistence.create(pk);

		newBrowserTracker.setUserId(nextLong());
		newBrowserTracker.setBrowserKey(nextLong());

		_persistence.update(newBrowserTracker, false);

		BrowserTracker existingBrowserTracker = _persistence.findByPrimaryKey(newBrowserTracker.getPrimaryKey());

		assertEquals(existingBrowserTracker.getBrowserTrackerId(),
			newBrowserTracker.getBrowserTrackerId());
		assertEquals(existingBrowserTracker.getUserId(),
			newBrowserTracker.getUserId());
		assertEquals(existingBrowserTracker.getBrowserKey(),
			newBrowserTracker.getBrowserKey());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		BrowserTracker newBrowserTracker = addBrowserTracker();

		BrowserTracker existingBrowserTracker = _persistence.findByPrimaryKey(newBrowserTracker.getPrimaryKey());

		assertEquals(existingBrowserTracker, newBrowserTracker);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchBrowserTrackerException");
		}
		catch (NoSuchBrowserTrackerException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		BrowserTracker newBrowserTracker = addBrowserTracker();

		BrowserTracker existingBrowserTracker = _persistence.fetchByPrimaryKey(newBrowserTracker.getPrimaryKey());

		assertEquals(existingBrowserTracker, newBrowserTracker);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		BrowserTracker missingBrowserTracker = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingBrowserTracker);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		BrowserTracker newBrowserTracker = addBrowserTracker();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BrowserTracker.class,
				BrowserTracker.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("browserTrackerId",
				newBrowserTracker.getBrowserTrackerId()));

		List<BrowserTracker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		BrowserTracker existingBrowserTracker = result.get(0);

		assertEquals(existingBrowserTracker, newBrowserTracker);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BrowserTracker.class,
				BrowserTracker.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("browserTrackerId",
				nextLong()));

		List<BrowserTracker> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected BrowserTracker addBrowserTracker() throws Exception {
		long pk = nextLong();

		BrowserTracker browserTracker = _persistence.create(pk);

		browserTracker.setUserId(nextLong());
		browserTracker.setBrowserKey(nextLong());

		_persistence.update(browserTracker, false);

		return browserTracker;
	}

	private BrowserTrackerPersistence _persistence;
}