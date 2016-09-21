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

import com.liferay.portlet.social.NoSuchActivityException;
import com.liferay.portlet.social.model.SocialActivity;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialActivityPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialActivityPersistence)PortalBeanLocatorUtil.locate(SocialActivityPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialActivity socialActivity = _persistence.create(pk);

		assertNotNull(socialActivity);

		assertEquals(socialActivity.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialActivity newSocialActivity = addSocialActivity();

		_persistence.remove(newSocialActivity);

		SocialActivity existingSocialActivity = _persistence.fetchByPrimaryKey(newSocialActivity.getPrimaryKey());

		assertNull(existingSocialActivity);
	}

	public void testUpdateNew() throws Exception {
		addSocialActivity();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialActivity newSocialActivity = _persistence.create(pk);

		newSocialActivity.setGroupId(nextLong());
		newSocialActivity.setCompanyId(nextLong());
		newSocialActivity.setUserId(nextLong());
		newSocialActivity.setCreateDate(nextLong());
		newSocialActivity.setMirrorActivityId(nextLong());
		newSocialActivity.setClassNameId(nextLong());
		newSocialActivity.setClassPK(nextLong());
		newSocialActivity.setType(nextInt());
		newSocialActivity.setExtraData(randomString());
		newSocialActivity.setReceiverUserId(nextLong());

		_persistence.update(newSocialActivity, false);

		SocialActivity existingSocialActivity = _persistence.findByPrimaryKey(newSocialActivity.getPrimaryKey());

		assertEquals(existingSocialActivity.getActivityId(),
			newSocialActivity.getActivityId());
		assertEquals(existingSocialActivity.getGroupId(),
			newSocialActivity.getGroupId());
		assertEquals(existingSocialActivity.getCompanyId(),
			newSocialActivity.getCompanyId());
		assertEquals(existingSocialActivity.getUserId(),
			newSocialActivity.getUserId());
		assertEquals(existingSocialActivity.getCreateDate(),
			newSocialActivity.getCreateDate());
		assertEquals(existingSocialActivity.getMirrorActivityId(),
			newSocialActivity.getMirrorActivityId());
		assertEquals(existingSocialActivity.getClassNameId(),
			newSocialActivity.getClassNameId());
		assertEquals(existingSocialActivity.getClassPK(),
			newSocialActivity.getClassPK());
		assertEquals(existingSocialActivity.getType(),
			newSocialActivity.getType());
		assertEquals(existingSocialActivity.getExtraData(),
			newSocialActivity.getExtraData());
		assertEquals(existingSocialActivity.getReceiverUserId(),
			newSocialActivity.getReceiverUserId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialActivity newSocialActivity = addSocialActivity();

		SocialActivity existingSocialActivity = _persistence.findByPrimaryKey(newSocialActivity.getPrimaryKey());

		assertEquals(existingSocialActivity, newSocialActivity);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchActivityException");
		}
		catch (NoSuchActivityException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialActivity newSocialActivity = addSocialActivity();

		SocialActivity existingSocialActivity = _persistence.fetchByPrimaryKey(newSocialActivity.getPrimaryKey());

		assertEquals(existingSocialActivity, newSocialActivity);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialActivity missingSocialActivity = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialActivity);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialActivity newSocialActivity = addSocialActivity();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialActivity.class,
				SocialActivity.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("activityId",
				newSocialActivity.getActivityId()));

		List<SocialActivity> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialActivity existingSocialActivity = result.get(0);

		assertEquals(existingSocialActivity, newSocialActivity);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialActivity.class,
				SocialActivity.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("activityId", nextLong()));

		List<SocialActivity> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialActivity addSocialActivity() throws Exception {
		long pk = nextLong();

		SocialActivity socialActivity = _persistence.create(pk);

		socialActivity.setGroupId(nextLong());
		socialActivity.setCompanyId(nextLong());
		socialActivity.setUserId(nextLong());
		socialActivity.setCreateDate(nextLong());
		socialActivity.setMirrorActivityId(nextLong());
		socialActivity.setClassNameId(nextLong());
		socialActivity.setClassPK(nextLong());
		socialActivity.setType(nextInt());
		socialActivity.setExtraData(randomString());
		socialActivity.setReceiverUserId(nextLong());

		_persistence.update(socialActivity, false);

		return socialActivity;
	}

	private SocialActivityPersistence _persistence;
}