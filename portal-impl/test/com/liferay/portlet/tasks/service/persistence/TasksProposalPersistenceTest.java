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

package com.liferay.portlet.tasks.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import com.liferay.portlet.tasks.NoSuchProposalException;
import com.liferay.portlet.tasks.model.TasksProposal;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class TasksProposalPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (TasksProposalPersistence)PortalBeanLocatorUtil.locate(TasksProposalPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		TasksProposal tasksProposal = _persistence.create(pk);

		assertNotNull(tasksProposal);

		assertEquals(tasksProposal.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		TasksProposal newTasksProposal = addTasksProposal();

		_persistence.remove(newTasksProposal);

		TasksProposal existingTasksProposal = _persistence.fetchByPrimaryKey(newTasksProposal.getPrimaryKey());

		assertNull(existingTasksProposal);
	}

	public void testUpdateNew() throws Exception {
		addTasksProposal();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		TasksProposal newTasksProposal = _persistence.create(pk);

		newTasksProposal.setGroupId(nextLong());
		newTasksProposal.setCompanyId(nextLong());
		newTasksProposal.setUserId(nextLong());
		newTasksProposal.setUserName(randomString());
		newTasksProposal.setCreateDate(nextDate());
		newTasksProposal.setModifiedDate(nextDate());
		newTasksProposal.setClassNameId(nextLong());
		newTasksProposal.setClassPK(randomString());
		newTasksProposal.setName(randomString());
		newTasksProposal.setDescription(randomString());
		newTasksProposal.setPublishDate(nextDate());
		newTasksProposal.setDueDate(nextDate());

		_persistence.update(newTasksProposal, false);

		TasksProposal existingTasksProposal = _persistence.findByPrimaryKey(newTasksProposal.getPrimaryKey());

		assertEquals(existingTasksProposal.getProposalId(),
			newTasksProposal.getProposalId());
		assertEquals(existingTasksProposal.getGroupId(),
			newTasksProposal.getGroupId());
		assertEquals(existingTasksProposal.getCompanyId(),
			newTasksProposal.getCompanyId());
		assertEquals(existingTasksProposal.getUserId(),
			newTasksProposal.getUserId());
		assertEquals(existingTasksProposal.getUserName(),
			newTasksProposal.getUserName());
		assertEquals(Time.getShortTimestamp(
				existingTasksProposal.getCreateDate()),
			Time.getShortTimestamp(newTasksProposal.getCreateDate()));
		assertEquals(Time.getShortTimestamp(
				existingTasksProposal.getModifiedDate()),
			Time.getShortTimestamp(newTasksProposal.getModifiedDate()));
		assertEquals(existingTasksProposal.getClassNameId(),
			newTasksProposal.getClassNameId());
		assertEquals(existingTasksProposal.getClassPK(),
			newTasksProposal.getClassPK());
		assertEquals(existingTasksProposal.getName(), newTasksProposal.getName());
		assertEquals(existingTasksProposal.getDescription(),
			newTasksProposal.getDescription());
		assertEquals(Time.getShortTimestamp(
				existingTasksProposal.getPublishDate()),
			Time.getShortTimestamp(newTasksProposal.getPublishDate()));
		assertEquals(Time.getShortTimestamp(existingTasksProposal.getDueDate()),
			Time.getShortTimestamp(newTasksProposal.getDueDate()));
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		TasksProposal newTasksProposal = addTasksProposal();

		TasksProposal existingTasksProposal = _persistence.findByPrimaryKey(newTasksProposal.getPrimaryKey());

		assertEquals(existingTasksProposal, newTasksProposal);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchProposalException");
		}
		catch (NoSuchProposalException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		TasksProposal newTasksProposal = addTasksProposal();

		TasksProposal existingTasksProposal = _persistence.fetchByPrimaryKey(newTasksProposal.getPrimaryKey());

		assertEquals(existingTasksProposal, newTasksProposal);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		TasksProposal missingTasksProposal = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingTasksProposal);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		TasksProposal newTasksProposal = addTasksProposal();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TasksProposal.class,
				TasksProposal.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("proposalId",
				newTasksProposal.getProposalId()));

		List<TasksProposal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		TasksProposal existingTasksProposal = result.get(0);

		assertEquals(existingTasksProposal, newTasksProposal);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TasksProposal.class,
				TasksProposal.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("proposalId", nextLong()));

		List<TasksProposal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected TasksProposal addTasksProposal() throws Exception {
		long pk = nextLong();

		TasksProposal tasksProposal = _persistence.create(pk);

		tasksProposal.setGroupId(nextLong());
		tasksProposal.setCompanyId(nextLong());
		tasksProposal.setUserId(nextLong());
		tasksProposal.setUserName(randomString());
		tasksProposal.setCreateDate(nextDate());
		tasksProposal.setModifiedDate(nextDate());
		tasksProposal.setClassNameId(nextLong());
		tasksProposal.setClassPK(randomString());
		tasksProposal.setName(randomString());
		tasksProposal.setDescription(randomString());
		tasksProposal.setPublishDate(nextDate());
		tasksProposal.setDueDate(nextDate());

		_persistence.update(tasksProposal, false);

		return tasksProposal;
	}

	private TasksProposalPersistence _persistence;
}