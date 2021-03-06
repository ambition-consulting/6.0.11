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

import com.liferay.portal.NoSuchMembershipRequestException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MembershipRequestPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (MembershipRequestPersistence)PortalBeanLocatorUtil.locate(MembershipRequestPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		MembershipRequest membershipRequest = _persistence.create(pk);

		assertNotNull(membershipRequest);

		assertEquals(membershipRequest.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		MembershipRequest newMembershipRequest = addMembershipRequest();

		_persistence.remove(newMembershipRequest);

		MembershipRequest existingMembershipRequest = _persistence.fetchByPrimaryKey(newMembershipRequest.getPrimaryKey());

		assertNull(existingMembershipRequest);
	}

	public void testUpdateNew() throws Exception {
		addMembershipRequest();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		MembershipRequest newMembershipRequest = _persistence.create(pk);

		newMembershipRequest.setCompanyId(nextLong());
		newMembershipRequest.setUserId(nextLong());
		newMembershipRequest.setCreateDate(nextDate());
		newMembershipRequest.setGroupId(nextLong());
		newMembershipRequest.setComments(randomString());
		newMembershipRequest.setReplyComments(randomString());
		newMembershipRequest.setReplyDate(nextDate());
		newMembershipRequest.setReplierUserId(nextLong());
		newMembershipRequest.setStatusId(nextInt());

		_persistence.update(newMembershipRequest, false);

		MembershipRequest existingMembershipRequest = _persistence.findByPrimaryKey(newMembershipRequest.getPrimaryKey());

		assertEquals(existingMembershipRequest.getMembershipRequestId(),
			newMembershipRequest.getMembershipRequestId());
		assertEquals(existingMembershipRequest.getCompanyId(),
			newMembershipRequest.getCompanyId());
		assertEquals(existingMembershipRequest.getUserId(),
			newMembershipRequest.getUserId());
		assertEquals(Time.getShortTimestamp(
				existingMembershipRequest.getCreateDate()),
			Time.getShortTimestamp(newMembershipRequest.getCreateDate()));
		assertEquals(existingMembershipRequest.getGroupId(),
			newMembershipRequest.getGroupId());
		assertEquals(existingMembershipRequest.getComments(),
			newMembershipRequest.getComments());
		assertEquals(existingMembershipRequest.getReplyComments(),
			newMembershipRequest.getReplyComments());
		assertEquals(Time.getShortTimestamp(
				existingMembershipRequest.getReplyDate()),
			Time.getShortTimestamp(newMembershipRequest.getReplyDate()));
		assertEquals(existingMembershipRequest.getReplierUserId(),
			newMembershipRequest.getReplierUserId());
		assertEquals(existingMembershipRequest.getStatusId(),
			newMembershipRequest.getStatusId());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		MembershipRequest newMembershipRequest = addMembershipRequest();

		MembershipRequest existingMembershipRequest = _persistence.findByPrimaryKey(newMembershipRequest.getPrimaryKey());

		assertEquals(existingMembershipRequest, newMembershipRequest);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail(
				"Missing entity did not throw NoSuchMembershipRequestException");
		}
		catch (NoSuchMembershipRequestException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		MembershipRequest newMembershipRequest = addMembershipRequest();

		MembershipRequest existingMembershipRequest = _persistence.fetchByPrimaryKey(newMembershipRequest.getPrimaryKey());

		assertEquals(existingMembershipRequest, newMembershipRequest);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		MembershipRequest missingMembershipRequest = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingMembershipRequest);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		MembershipRequest newMembershipRequest = addMembershipRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MembershipRequest.class,
				MembershipRequest.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("membershipRequestId",
				newMembershipRequest.getMembershipRequestId()));

		List<MembershipRequest> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		MembershipRequest existingMembershipRequest = result.get(0);

		assertEquals(existingMembershipRequest, newMembershipRequest);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MembershipRequest.class,
				MembershipRequest.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("membershipRequestId",
				nextLong()));

		List<MembershipRequest> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected MembershipRequest addMembershipRequest()
		throws Exception {
		long pk = nextLong();

		MembershipRequest membershipRequest = _persistence.create(pk);

		membershipRequest.setCompanyId(nextLong());
		membershipRequest.setUserId(nextLong());
		membershipRequest.setCreateDate(nextDate());
		membershipRequest.setGroupId(nextLong());
		membershipRequest.setComments(randomString());
		membershipRequest.setReplyComments(randomString());
		membershipRequest.setReplyDate(nextDate());
		membershipRequest.setReplierUserId(nextLong());
		membershipRequest.setStatusId(nextInt());

		_persistence.update(membershipRequest, false);

		return membershipRequest;
	}

	private MembershipRequestPersistence _persistence;
}