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

import com.liferay.portal.NoSuchTeamException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.model.Team;
import com.liferay.portal.service.persistence.BasePersistenceTestCase;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class TeamPersistenceTest extends BasePersistenceTestCase {
	public void setUp() throws Exception {
		super.setUp();

		_persistence = (TeamPersistence)PortalBeanLocatorUtil.locate(TeamPersistence.class.getName());
	}

	public void testCreate() throws Exception {
		long pk = nextLong();

		Team team = _persistence.create(pk);

		assertNotNull(team);

		assertEquals(team.getPrimaryKey(), pk);
	}

	public void testRemove() throws Exception {
		Team newTeam = addTeam();

		_persistence.remove(newTeam);

		Team existingTeam = _persistence.fetchByPrimaryKey(newTeam.getPrimaryKey());

		assertNull(existingTeam);
	}

	public void testUpdateNew() throws Exception {
		addTeam();
	}

	public void testUpdateExisting() throws Exception {
		long pk = nextLong();

		Team newTeam = _persistence.create(pk);

		newTeam.setCompanyId(nextLong());
		newTeam.setUserId(nextLong());
		newTeam.setUserName(randomString());
		newTeam.setCreateDate(nextDate());
		newTeam.setModifiedDate(nextDate());
		newTeam.setGroupId(nextLong());
		newTeam.setName(randomString());
		newTeam.setDescription(randomString());

		_persistence.update(newTeam, false);

		Team existingTeam = _persistence.findByPrimaryKey(newTeam.getPrimaryKey());

		assertEquals(existingTeam.getTeamId(), newTeam.getTeamId());
		assertEquals(existingTeam.getCompanyId(), newTeam.getCompanyId());
		assertEquals(existingTeam.getUserId(), newTeam.getUserId());
		assertEquals(existingTeam.getUserName(), newTeam.getUserName());
		assertEquals(Time.getShortTimestamp(existingTeam.getCreateDate()),
			Time.getShortTimestamp(newTeam.getCreateDate()));
		assertEquals(Time.getShortTimestamp(existingTeam.getModifiedDate()),
			Time.getShortTimestamp(newTeam.getModifiedDate()));
		assertEquals(existingTeam.getGroupId(), newTeam.getGroupId());
		assertEquals(existingTeam.getName(), newTeam.getName());
		assertEquals(existingTeam.getDescription(), newTeam.getDescription());
	}

	public void testFindByPrimaryKeyExisting() throws Exception {
		Team newTeam = addTeam();

		Team existingTeam = _persistence.findByPrimaryKey(newTeam.getPrimaryKey());

		assertEquals(existingTeam, newTeam);
	}

	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			fail("Missing entity did not throw NoSuchTeamException");
		}
		catch (NoSuchTeamException nsee) {
		}
	}

	public void testFetchByPrimaryKeyExisting() throws Exception {
		Team newTeam = addTeam();

		Team existingTeam = _persistence.fetchByPrimaryKey(newTeam.getPrimaryKey());

		assertEquals(existingTeam, newTeam);
	}

	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = nextLong();

		Team missingTeam = _persistence.fetchByPrimaryKey(pk);

		assertNull(missingTeam);
	}

	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Team newTeam = addTeam();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Team.class,
				Team.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("teamId",
				newTeam.getTeamId()));

		List<Team> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(1, result.size());

		Team existingTeam = result.get(0);

		assertEquals(existingTeam, newTeam);
	}

	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Team.class,
				Team.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("teamId", nextLong()));

		List<Team> result = _persistence.findWithDynamicQuery(dynamicQuery);

		assertEquals(0, result.size());
	}

	protected Team addTeam() throws Exception {
		long pk = nextLong();

		Team team = _persistence.create(pk);

		team.setCompanyId(nextLong());
		team.setUserId(nextLong());
		team.setUserName(randomString());
		team.setCreateDate(nextDate());
		team.setModifiedDate(nextDate());
		team.setGroupId(nextLong());
		team.setName(randomString());
		team.setDescription(randomString());

		_persistence.update(team, false);

		return team;
	}

	private TeamPersistence _persistence;
}