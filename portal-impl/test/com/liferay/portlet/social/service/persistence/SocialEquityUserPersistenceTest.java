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

import com.liferay.portlet.social.NoSuchEquityUserException;
import com.liferay.portlet.social.model.SocialEquityUser;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityUserPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialEquityUserPersistence)PortalBeanLocatorUtil.locate(SocialEquityUserPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialEquityUser socialEquityUser = _persistence.create(pk);

		assertNotNull(socialEquityUser);

		assertEquals(socialEquityUser.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialEquityUser newSocialEquityUser = addSocialEquityUser();

		_persistence.remove(newSocialEquityUser);

		SocialEquityUser existingSocialEquityUser = _persistence.fetchByPrimaryKey(newSocialEquityUser.getPrimaryKey());

		assertNull(existingSocialEquityUser);
	}

	public void testUpdateNew() throws Exception {
		addSocialEquityUser();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialEquityUser newSocialEquityUser = _persistence.create(pk);

		newSocialEquityUser.setGroupId(nextLong());
		newSocialEquityUser.setCompanyId(nextLong());
		newSocialEquityUser.setUserId(nextLong());
		newSocialEquityUser.setContributionK(nextDouble());
		newSocialEquityUser.setContributionB(nextDouble());
		newSocialEquityUser.setParticipationK(nextDouble());
		newSocialEquityUser.setParticipationB(nextDouble());
		newSocialEquityUser.setRank(nextInt());

		_persistence.update(newSocialEquityUser, false);

		SocialEquityUser existingSocialEquityUser = _persistence.findByPrimaryKey(newSocialEquityUser.getPrimaryKey());

		assertEquals(existingSocialEquityUser.getEquityUserId(),
			newSocialEquityUser.getEquityUserId());
		assertEquals(existingSocialEquityUser.getGroupId(),
			newSocialEquityUser.getGroupId());
		assertEquals(existingSocialEquityUser.getCompanyId(),
			newSocialEquityUser.getCompanyId());
		assertEquals(existingSocialEquityUser.getUserId(),
			newSocialEquityUser.getUserId());
		assertEquals(existingSocialEquityUser.getContributionK(),
			newSocialEquityUser.getContributionK());
		assertEquals(existingSocialEquityUser.getContributionB(),
			newSocialEquityUser.getContributionB());
		assertEquals(existingSocialEquityUser.getParticipationK(),
			newSocialEquityUser.getParticipationK());
		assertEquals(existingSocialEquityUser.getParticipationB(),
			newSocialEquityUser.getParticipationB());
		assertEquals(existingSocialEquityUser.getRank(),
			newSocialEquityUser.getRank());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialEquityUser newSocialEquityUser = addSocialEquityUser();

		SocialEquityUser existingSocialEquityUser = _persistence.findByPrimaryKey(newSocialEquityUser.getPrimaryKey());

		assertEquals(existingSocialEquityUser, newSocialEquityUser);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchEquityUserException");
		}
		catch (NoSuchEquityUserException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialEquityUser newSocialEquityUser = addSocialEquityUser();

		SocialEquityUser existingSocialEquityUser = _persistence.fetchByPrimaryKey(newSocialEquityUser.getPrimaryKey());

		assertEquals(existingSocialEquityUser, newSocialEquityUser);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialEquityUser missingSocialEquityUser = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialEquityUser);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialEquityUser newSocialEquityUser = addSocialEquityUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityUser.class,
				SocialEquityUser.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityUserId",
				newSocialEquityUser.getEquityUserId()));

		List<SocialEquityUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialEquityUser existingSocialEquityUser = result.get(0);

		assertEquals(existingSocialEquityUser, newSocialEquityUser);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialEquityUser.class,
				SocialEquityUser.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("equityUserId", nextLong()));

		List<SocialEquityUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialEquityUser addSocialEquityUser() throws Exception {
		long pk = nextLong();

		SocialEquityUser socialEquityUser = _persistence.create(pk);

		socialEquityUser.setGroupId(nextLong());
		socialEquityUser.setCompanyId(nextLong());
		socialEquityUser.setUserId(nextLong());
		socialEquityUser.setContributionK(nextDouble());
		socialEquityUser.setContributionB(nextDouble());
		socialEquityUser.setParticipationK(nextDouble());
		socialEquityUser.setParticipationB(nextDouble());
		socialEquityUser.setRank(nextInt());

		_persistence.update(socialEquityUser, false);

		return socialEquityUser;
	}

	private SocialEquityUserPersistence _persistence;
}