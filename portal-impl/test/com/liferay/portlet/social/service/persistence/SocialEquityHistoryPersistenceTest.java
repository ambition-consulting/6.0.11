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

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.social.NoSuchEquityHistoryException;
import com.liferay.portlet.social.model.SocialEquityHistory;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityHistoryPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialEquityHistoryPersistence)PortalBeanLocatorUtil.locate(SocialEquityHistoryPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialEquityHistory socialEquityHistory = _persistence.create(pk);

		assertNotNull(socialEquityHistory);

		assertEquals(socialEquityHistory.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialEquityHistory newSocialEquityHistory = addSocialEquityHistory();

		_persistence.remove(newSocialEquityHistory);

		SocialEquityHistory existingSocialEquityHistory = _persistence.fetchByPrimaryKey(newSocialEquityHistory.getPrimaryKey());

		assertNull(existingSocialEquityHistory);
	}

	public void testUpdateNew() throws Exception {
		addSocialEquityHistory();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialEquityHistory newSocialEquityHistory = _persistence.create(pk);

		newSocialEquityHistory.setGroupId(nextLong());
		newSocialEquityHistory.setCompanyId(nextLong());
		newSocialEquityHistory.setUserId(nextLong());
		newSocialEquityHistory.setCreateDate(nextDate());
		newSocialEquityHistory.setPersonalEquity(nextInt());

		_persistence.update(newSocialEquityHistory, false);

		SocialEquityHistory existingSocialEquityHistory = _persistence.findByPrimaryKey(newSocialEquityHistory.getPrimaryKey());

		assertEquals(existingSocialEquityHistory.getEquityHistoryId(),
			newSocialEquityHistory.getEquityHistoryId());
		assertEquals(existingSocialEquityHistory.getGroupId(),
			newSocialEquityHistory.getGroupId());
		assertEquals(existingSocialEquityHistory.getCompanyId(),
			newSocialEquityHistory.getCompanyId());
		assertEquals(existingSocialEquityHistory.getUserId(),
			newSocialEquityHistory.getUserId());
		assertEquals(Time.getShortTimestamp(
				existingSocialEquityHistory.getCreateDate()),
			Time.getShortTimestamp(newSocialEquityHistory.getCreateDate()));
		assertEquals(existingSocialEquityHistory.getPersonalEquity(),
			newSocialEquityHistory.getPersonalEquity());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialEquityHistory newSocialEquityHistory = addSocialEquityHistory();

		SocialEquityHistory existingSocialEquityHistory = _persistence.findByPrimaryKey(newSocialEquityHistory.getPrimaryKey());

		assertEquals(existingSocialEquityHistory, newSocialEquityHistory);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchEquityHistoryException");
		}
		catch (NoSuchEquityHistoryException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialEquityHistory newSocialEquityHistory = addSocialEquityHistory();

		SocialEquityHistory existingSocialEquityHistory = _persistence.fetchByPrimaryKey(newSocialEquityHistory.getPrimaryKey());

		assertEquals(existingSocialEquityHistory, newSocialEquityHistory);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialEquityHistory missingSocialEquityHistory = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialEquityHistory);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialEquityHistory newSocialEquityHistory = addSocialEquityHistory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityHistory.class,
				SocialEquityHistory.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityHistoryId",
				newSocialEquityHistory.getEquityHistoryId()));

		List<SocialEquityHistory> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialEquityHistory existingSocialEquityHistory = result.get(0);

		assertEquals(existingSocialEquityHistory, newSocialEquityHistory);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityHistory.class,
				SocialEquityHistory.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityHistoryId",
				nextLong()));

		List<SocialEquityHistory> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialEquityHistory addSocialEquityHistory()
		throws Exception {
		long pk = nextLong();

		SocialEquityHistory socialEquityHistory = _persistence.create(pk);

		socialEquityHistory.setGroupId(nextLong());
		socialEquityHistory.setCompanyId(nextLong());
		socialEquityHistory.setUserId(nextLong());
		socialEquityHistory.setCreateDate(nextDate());
		socialEquityHistory.setPersonalEquity(nextInt());

		_persistence.update(socialEquityHistory, false);

		return socialEquityHistory;
	}

	private SocialEquityHistoryPersistence _persistence;
}