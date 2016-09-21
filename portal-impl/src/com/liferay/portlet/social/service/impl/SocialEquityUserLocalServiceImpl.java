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

package com.liferay.portlet.social.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.social.model.SocialEquityUser;
import com.liferay.portlet.social.model.SocialEquityValue;
import com.liferay.portlet.social.service.base.SocialEquityUserLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Zsolt Berentey
 */
public class SocialEquityUserLocalServiceImpl
	extends SocialEquityUserLocalServiceBaseImpl {

	public SocialEquityValue getContributionEquity(long userId)
		throws SystemException {

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		projectionList.add(ProjectionFactoryUtil.sum("contributionK"));
		projectionList.add(ProjectionFactoryUtil.sum("contributionB"));

		return getEquityValue(userId, projectionList);
	}

	public SocialEquityValue getParticipationEquity(long userId)
		throws SystemException {

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		projectionList.add(ProjectionFactoryUtil.sum("participationK"));
		projectionList.add(ProjectionFactoryUtil.sum("participationB"));

		return getEquityValue(userId, projectionList);
	}

	public int getRank(long groupId, long userId) throws SystemException {
		SocialEquityUser equityUser = socialEquityUserPersistence.fetchByG_U(
			groupId, userId);

		if (equityUser == null) {
			return 0;
		}

		return equityUser.getRank();
	}

	public List<SocialEquityUser> getRankedEquityUsers(
			long groupId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return socialEquityUserPersistence.findByGroupRanked(
			groupId, start, end, orderByComparator);
	}

	public int getRankedEquityUsersCount(long groupId) throws SystemException {
		return socialEquityUserPersistence.countByGroupRanked(groupId);
	}

	protected SocialEquityValue getEquityValue(
			long userId, ProjectionList projectionList)
		throws SystemException {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SocialEquityUser.class);

		dynamicQuery.setProjection(projectionList);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));

		List<?> results = dynamicQuery(dynamicQuery);

		Object[] values = (Object[])results.get(0);

		SocialEquityValue socialEquityValue = null;

		if (values[0] != null) {
			socialEquityValue = new SocialEquityValue(
				(Double)values[0], (Double)values[1]);
		}
		else {
			socialEquityValue = new SocialEquityValue(0, 0);
		}

		return socialEquityValue;
	}

}