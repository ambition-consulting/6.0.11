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
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.social.NoSuchEquityLogException;
import com.liferay.portlet.social.model.SocialEquityLog;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityLogPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialEquityLogPersistence)PortalBeanLocatorUtil.locate(SocialEquityLogPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialEquityLog socialEquityLog = _persistence.create(pk);

		assertNotNull(socialEquityLog);

		assertEquals(socialEquityLog.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialEquityLog newSocialEquityLog = addSocialEquityLog();

		_persistence.remove(newSocialEquityLog);

		SocialEquityLog existingSocialEquityLog = _persistence.fetchByPrimaryKey(newSocialEquityLog.getPrimaryKey());

		assertNull(existingSocialEquityLog);
	}

	public void testUpdateNew() throws Exception {
		addSocialEquityLog();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialEquityLog newSocialEquityLog = _persistence.create(pk);

		newSocialEquityLog.setGroupId(nextLong());
		newSocialEquityLog.setCompanyId(nextLong());
		newSocialEquityLog.setUserId(nextLong());
		newSocialEquityLog.setAssetEntryId(nextLong());
		newSocialEquityLog.setActionId(randomString());
		newSocialEquityLog.setActionDate(nextInt());
		newSocialEquityLog.setActive(randomBoolean());
		newSocialEquityLog.setExpiration(nextInt());
		newSocialEquityLog.setType(nextInt());
		newSocialEquityLog.setValue(nextInt());

		_persistence.update(newSocialEquityLog, false);

		SocialEquityLog existingSocialEquityLog = _persistence.findByPrimaryKey(newSocialEquityLog.getPrimaryKey());

		assertEquals(existingSocialEquityLog.getEquityLogId(),
			newSocialEquityLog.getEquityLogId());
		assertEquals(existingSocialEquityLog.getGroupId(),
			newSocialEquityLog.getGroupId());
		assertEquals(existingSocialEquityLog.getCompanyId(),
			newSocialEquityLog.getCompanyId());
		assertEquals(existingSocialEquityLog.getUserId(),
			newSocialEquityLog.getUserId());
		assertEquals(existingSocialEquityLog.getAssetEntryId(),
			newSocialEquityLog.getAssetEntryId());
		assertEquals(existingSocialEquityLog.getActionId(),
			newSocialEquityLog.getActionId());
		assertEquals(existingSocialEquityLog.getActionDate(),
			newSocialEquityLog.getActionDate());
		assertEquals(existingSocialEquityLog.getActive(),
			newSocialEquityLog.getActive());
		assertEquals(existingSocialEquityLog.getExpiration(),
			newSocialEquityLog.getExpiration());
		assertEquals(existingSocialEquityLog.getType(),
			newSocialEquityLog.getType());
		assertEquals(existingSocialEquityLog.getValue(),
			newSocialEquityLog.getValue());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialEquityLog newSocialEquityLog = addSocialEquityLog();

		SocialEquityLog existingSocialEquityLog = _persistence.findByPrimaryKey(newSocialEquityLog.getPrimaryKey());

		assertEquals(existingSocialEquityLog, newSocialEquityLog);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchEquityLogException");
		}
		catch (NoSuchEquityLogException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialEquityLog newSocialEquityLog = addSocialEquityLog();

		SocialEquityLog existingSocialEquityLog = _persistence.fetchByPrimaryKey(newSocialEquityLog.getPrimaryKey());

		assertEquals(existingSocialEquityLog, newSocialEquityLog);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialEquityLog missingSocialEquityLog = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialEquityLog);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialEquityLog newSocialEquityLog = addSocialEquityLog();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityLog.class,
				SocialEquityLog.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityLogId",
				newSocialEquityLog.getEquityLogId()));

		List<SocialEquityLog> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialEquityLog existingSocialEquityLog = result.get(0);

		assertEquals(existingSocialEquityLog, newSocialEquityLog);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityLog.class,
				SocialEquityLog.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityLogId", nextLong()));

		List<SocialEquityLog> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialEquityLog addSocialEquityLog() throws Exception {
		long pk = nextLong();

		SocialEquityLog socialEquityLog = _persistence.create(pk);

		socialEquityLog.setGroupId(nextLong());
		socialEquityLog.setCompanyId(nextLong());
		socialEquityLog.setUserId(nextLong());
		socialEquityLog.setAssetEntryId(nextLong());
		socialEquityLog.setActionId(randomString());
		socialEquityLog.setActionDate(nextInt());
		socialEquityLog.setActive(randomBoolean());
		socialEquityLog.setExpiration(nextInt());
		socialEquityLog.setType(nextInt());
		socialEquityLog.setValue(nextInt());

		_persistence.update(socialEquityLog, false);

		return socialEquityLog;
	}

	private SocialEquityLogPersistence _persistence;
}