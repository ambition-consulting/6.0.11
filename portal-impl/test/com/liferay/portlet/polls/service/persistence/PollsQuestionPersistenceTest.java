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

package com.liferay.portlet.polls.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.polls.NoSuchQuestionException;
import com.liferay.portlet.polls.model.PollsQuestion;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class PollsQuestionPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (PollsQuestionPersistence)PortalBeanLocatorUtil.locate(PollsQuestionPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		PollsQuestion pollsQuestion = _persistence.create(pk);

		assertNotNull(pollsQuestion);

		assertEquals(pollsQuestion.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		PollsQuestion newPollsQuestion = addPollsQuestion();

		_persistence.remove(newPollsQuestion);

		PollsQuestion existingPollsQuestion = _persistence.fetchByPrimaryKey(newPollsQuestion.getPrimaryKey());

		assertNull(existingPollsQuestion);
	}

	public void testUpdateNew() throws Exception {
		addPollsQuestion();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		PollsQuestion newPollsQuestion = _persistence.create(pk);

		newPollsQuestion.setUuid(randomString());
		newPollsQuestion.setGroupId(nextLong());
		newPollsQuestion.setCompanyId(nextLong());
		newPollsQuestion.setUserId(nextLong());
		newPollsQuestion.setUserName(randomString());
		newPollsQuestion.setCreateDate(nextDate());
		newPollsQuestion.setModifiedDate(nextDate());
		newPollsQuestion.setTitle(randomString());
		newPollsQuestion.setDescription(randomString());
		newPollsQuestion.setExpirationDate(nextDate());
		newPollsQuestion.setLastVoteDate(nextDate());

		_persistence.update(newPollsQuestion, false);

		PollsQuestion existingPollsQuestion = _persistence.findByPrimaryKey(newPollsQuestion.getPrimaryKey());

		assertEquals(existingPollsQuestion.getUuid(), newPollsQuestion.getUuid());
		assertEquals(existingPollsQuestion.getQuestionId(),
			newPollsQuestion.getQuestionId());
		assertEquals(existingPollsQuestion.getGroupId(),
			newPollsQuestion.getGroupId());
		assertEquals(existingPollsQuestion.getCompanyId(),
			newPollsQuestion.getCompanyId());
		assertEquals(existingPollsQuestion.getUserId(),
			newPollsQuestion.getUserId());
		assertEquals(existingPollsQuestion.getUserName(),
			newPollsQuestion.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingPollsQuestion.getCreateDate()),
			Time.getShortTimestamp(newPollsQuestion.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingPollsQuestion.getModifiedDate()),
			Time.getShortTimestamp(newPollsQuestion.getModifiedDate()));
		assertEquals(existingPollsQuestion.getTitle(),
			newPollsQuestion.getTitle());
		assertEquals(existingPollsQuestion.getDescription(),
			newPollsQuestion.getDescription());
		assertEquals(Time.getShortTimestamp(
				existingPollsQuestion.getExpirationDate()),
			Time.getShortTimestamp(newPollsQuestion.getExpirationDate()));
		assertEquals(Time.getShortTimestamp(
				existingPollsQuestion.getLastVoteDate()),
			Time.getShortTimestamp(newPollsQuestion.getLastVoteDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		PollsQuestion newPollsQuestion = addPollsQuestion();

		PollsQuestion existingPollsQuestion = _persistence.findByPrimaryKey(newPollsQuestion.getPrimaryKey());

		assertEquals(existingPollsQuestion, newPollsQuestion);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchQuestionException");
		}
		catch (NoSuchQuestionException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		PollsQuestion newPollsQuestion = addPollsQuestion();

		PollsQuestion existingPollsQuestion = _persistence.fetchByPrimaryKey(newPollsQuestion.getPrimaryKey());

		assertEquals(existingPollsQuestion, newPollsQuestion);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		PollsQuestion missingPollsQuestion = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingPollsQuestion);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		PollsQuestion newPollsQuestion = addPollsQuestion();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsQuestion.class,
				PollsQuestion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("questionId",
				newPollsQuestion.getQuestionId()));

		List<PollsQuestion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		PollsQuestion existingPollsQuestion = result.get(0);

		assertEquals(existingPollsQuestion, newPollsQuestion);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PollsQuestion.class,
				PollsQuestion.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("questionId", nextLong()));

		List<PollsQuestion> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected PollsQuestion addPollsQuestion() throws Exception {
		long pk = nextLong();

		PollsQuestion pollsQuestion = _persistence.create(pk);

		pollsQuestion.setUuid(randomString());
		pollsQuestion.setGroupId(nextLong());
		pollsQuestion.setCompanyId(nextLong());
		pollsQuestion.setUserId(nextLong());
		pollsQuestion.setUserName(randomString());
		pollsQuestion.setCreateDate(nextDate());
		pollsQuestion.setModifiedDate(nextDate());
		pollsQuestion.setTitle(randomString());
		pollsQuestion.setDescription(randomString());
		pollsQuestion.setExpirationDate(nextDate());
		pollsQuestion.setLastVoteDate(nextDate());

		_persistence.update(pollsQuestion, false);

		return pollsQuestion;
	}

	private PollsQuestionPersistence _persistence;
}