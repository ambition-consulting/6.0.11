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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link TeamService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TeamService
 * @generated
 */
public class TeamServiceWrapper implements TeamService {
	public TeamServiceWrapper(TeamService teamService) {
		_teamService = teamService;
	}

	public com.liferay.portal.model.Team addTeam(long groupId,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.addTeam(groupId, name, description);
	}

	public void deleteTeam(long teamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_teamService.deleteTeam(teamId);
	}

	public java.util.List<com.liferay.portal.model.Team> getGroupTeams(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.getGroupTeams(groupId);
	}

	public com.liferay.portal.model.Team getTeam(long teamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.getTeam(teamId);
	}

	public com.liferay.portal.model.Team getTeam(long groupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.getTeam(groupId, name);
	}

	public java.util.List<com.liferay.portal.model.Team> getUserTeams(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.getUserTeams(userId);
	}

	public java.util.List<com.liferay.portal.model.Team> getUserTeams(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.getUserTeams(userId, groupId);
	}

	public boolean hasUserTeam(long userId, long teamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.hasUserTeam(userId, teamId);
	}

	public com.liferay.portal.model.Team updateTeam(long teamId,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _teamService.updateTeam(teamId, name, description);
	}

	public TeamService getWrappedTeamService() {
		return _teamService;
	}

	public void setWrappedTeamService(TeamService teamService) {
		_teamService = teamService;
	}

	private TeamService _teamService;
}