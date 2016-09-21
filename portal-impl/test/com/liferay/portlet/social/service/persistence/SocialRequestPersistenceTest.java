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

import com.liferay.portlet.social.NoSuchRequestException;
import com.liferay.portlet.social.model.SocialRequest;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialRequestPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (SocialRequestPersistence)PortalBeanLocatorUtil.locate(SocialRequestPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		SocialRequest socialRequest = _persistence.create(pk);

		assertNotNull(socialRequest);

		assertEquals(socialRequest.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		SocialRequest newSocialRequest = addSocialRequest();

		_persistence.remove(newSocialRequest);

		SocialRequest existingSocialRequest = _persistence.fetchByPrimaryKey(newSocialRequest.getPrimaryKey());

		assertNull(existingSocialRequest);
	}

	public void testUpdateNew() throws Exception {
		addSocialRequest();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		SocialRequest newSocialRequest = _persistence.create(pk);

		newSocialRequest.setUuid(randomString());
		newSocialRequest.setGroupId(nextLong());
		newSocialRequest.setCompanyId(nextLong());
		newSocialRequest.setUserId(nextLong());
		newSocialRequest.setCreateDate(nextLong());
		newSocialRequest.setModifiedDate(nextLong());
		newSocialRequest.setClassNameId(nextLong());
		newSocialRequest.setClassPK(nextLong());
		newSocialRequest.setType(nextInt());
		newSocialRequest.setExtraData(randomString());
		newSocialRequest.setReceiverUserId(nextLong());
		newSocialRequest.setStatus(nextInt());

		_persistence.update(newSocialRequest, false);

		SocialRequest existingSocialRequest = _persistence.findByPrimaryKey(newSocialRequest.getPrimaryKey());

		assertEquals(existingSocialRequest.getUuid(), newSocialRequest.getUuid());
		assertEquals(existingSocialRequest.getRequestId(),
			newSocialRequest.getRequestId());
		assertEquals(existingSocialRequest.getGroupId(),
			newSocialRequest.getGroupId());
		assertEquals(existingSocialRequest.getCompanyId(),
			newSocialRequest.getCompanyId());
		assertEquals(existingSocialRequest.getUserId(),
			newSocialRequest.getUserId());
		assertEquals(existingSocialRequest.getCreateDate(),
			newSocialRequest.getCreateDate());
		assertEquals(existingSocialRequest.getModifiedDate(),
			newSocialRequest.getModifiedDate());
		assertEquals(existingSocialRequest.getClassNameId(),
			newSocialRequest.getClassNameId());
		assertEquals(existingSocialRequest.getClassPK(),
			newSocialRequest.getClassPK());
		assertEquals(existingSocialRequest.getType(), newSocialRequest.getType());
		assertEquals(existingSocialRequest.getExtraData(),
			newSocialRequest.getExtraData());
		assertEquals(existingSocialRequest.getReceiverUserId(),
			newSocialRequest.getReceiverUserId());
		assertEquals(existingSocialRequest.getStatus(),
			newSocialRequest.getStatus());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		SocialRequest newSocialRequest = addSocialRequest();

		SocialRequest existingSocialRequest = _persistence.findByPrimaryKey(newSocialRequest.getPrimaryKey());

		assertEquals(existingSocialRequest, newSocialRequest);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchRequestException");
		}
		catch (NoSuchRequestException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		SocialRequest newSocialRequest = addSocialRequest();

		SocialRequest existingSocialRequest = _persistence.fetchByPrimaryKey(newSocialRequest.getPrimaryKey());

		assertEquals(existingSocialRequest, newSocialRequest);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		SocialRequest missingSocialRequest = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingSocialRequest);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		SocialRequest newSocialRequest = addSocialRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialRequest.class,
				SocialRequest.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("requestId",
				newSocialRequest.getRequestId()));

		List<SocialRequest> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		SocialRequest existingSocialRequest = result.get(0);

		assertEquals(existingSocialRequest, newSocialRequest);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SocialRequest.class,
				SocialRequest.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("requestId", nextLong()));

		List<SocialRequest> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected SocialRequest addSocialRequest() throws Exception {
		long pk = nextLong();

		SocialRequest socialRequest = _persistence.create(pk);

		socialRequest.setUuid(randomString());
		socialRequest.setGroupId(nextLong());
		socialRequest.setCompanyId(nextLong());
		socialRequest.setUserId(nextLong());
		socialRequest.setCreateDate(nextLong());
		socialRequest.setModifiedDate(nextLong());
		socialRequest.setClassNameId(nextLong());
		socialRequest.setClassPK(nextLong());
		socialRequest.setType(nextInt());
		socialRequest.setExtraData(randomString());
		socialRequest.setReceiverUserId(nextLong());
		socialRequest.setStatus(nextInt());

		_persistence.update(socialRequest, false);

		return socialRequest;
	}

	private SocialRequestPersistence _persistence;
}