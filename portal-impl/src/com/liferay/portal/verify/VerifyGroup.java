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

package com.liferay.portal.verify;

import com.liferay.portal.GroupFriendlyURLException;
import com.liferay.portal.NoSuchShardException;
import com.liferay.portal.kernel.dao.shard.ShardUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Shard;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ShardLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PropsValues;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class VerifyGroup extends VerifyProcess {

	protected void doVerify() throws Exception {
		verifyCompanyGroups();
		verifyNullFriendlyURLGroups();
		verifyStagedGroups();
	}

	protected void verifyCompanyGroups() throws Exception {
		List<Company> companies = CompanyLocalServiceUtil.getCompanies();

		String currentShardName = ShardUtil.getCurrentShardName();

		for (Company company : companies) {
			String shardName = null;

			try {
				shardName = company.getShardName();
			}
			catch (NoSuchShardException nsse) {
				Shard shard = ShardLocalServiceUtil.addShard(
					Company.class.getName(), company.getCompanyId(),
					PropsValues.SHARD_DEFAULT_NAME);

				shardName = shard.getName();
			}

			if (!ShardUtil.isEnabled() || shardName.equals(currentShardName)) {
				GroupLocalServiceUtil.checkCompanyGroup(company.getCompanyId());
			}
		}
	}

	protected void verifyNullFriendlyURLGroups() throws Exception {
		List<Group> groups = GroupLocalServiceUtil.getNullFriendlyURLGroups();

		for (Group group : groups) {
			String friendlyURL = StringPool.SLASH + group.getGroupId();

			User user = null;

			if (group.isUser()) {
				user = UserLocalServiceUtil.getUserById(group.getClassPK());

				friendlyURL = StringPool.SLASH + user.getScreenName();
			}
			else if (group.getClassPK() > 0) {
				friendlyURL = StringPool.SLASH + group.getClassPK();
			}

			try {
				GroupLocalServiceUtil.updateFriendlyURL(
					group.getGroupId(), friendlyURL);
			}
			catch (GroupFriendlyURLException gfurle) {
				if (user != null) {
					long userId = user.getUserId();
					String screenName = user.getScreenName();

					if (_log.isInfoEnabled()) {
						_log.info(
							"Updating user screen name " + screenName + " to " +
								userId + " because it is generating an " +
									"invalid friendly URL");
					}

					UserLocalServiceUtil.updateScreenName(
						userId, String.valueOf(userId));
				}
				else {
					_log.error("Invalid Friendly URL " + friendlyURL);

					throw gfurle;
				}
			}
		}
	}

	protected void verifyStagedGroups() throws Exception {
		List<Group> groups = GroupLocalServiceUtil.getLiveGroups();

		for (Group group : groups) {
			if (!group.hasStagingGroup()) {
				continue;
			}

			UnicodeProperties typeSettingsProperties =
				group.getTypeSettingsProperties();

			typeSettingsProperties.setProperty(
				"staged", Boolean.TRUE.toString());
			typeSettingsProperties.setProperty(
				"stagedRemotely", Boolean.FALSE.toString());

			GroupLocalServiceUtil.updateGroup(
				group.getGroupId(), typeSettingsProperties.toString());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VerifyGroup.class);

}