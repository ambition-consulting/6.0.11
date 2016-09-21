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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.social.model.SocialEquityGroupSetting;
import com.liferay.portlet.social.model.SocialEquitySettingConstants;
import com.liferay.portlet.social.service.base.SocialEquityGroupSettingLocalServiceBaseImpl;

/**
 * @author Zsolt Berentey
 */
public class SocialEquityGroupSettingLocalServiceImpl
	extends SocialEquityGroupSettingLocalServiceBaseImpl {

	public boolean isEnabled(long groupId, String className)
		throws SystemException {

		if (isEnabled(
				groupId, className,
				SocialEquitySettingConstants.TYPE_INFORMATION) &&
			isEnabled(
				groupId, className,
				SocialEquitySettingConstants.TYPE_PARTICIPATION)) {

			return true;
		}
		else {
			return false;
		}
	}

	public boolean isEnabled(long groupId, String className, int type)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		SocialEquityGroupSetting equityGroupSetting =
			socialEquityGroupSettingPersistence.fetchByG_C_T(
				groupId, classNameId, type);

		if (equityGroupSetting != null) {
			return equityGroupSetting.isEnabled();
		}

		if (className.equals(Group.class.getName())) {
			return false;
		}

		return true;
	}

	public void updateEquityGroupSetting(
			long groupId, String className, int type, boolean enabled)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		SocialEquityGroupSetting equityGroupSetting =
			socialEquityGroupSettingPersistence.fetchByG_C_T(
				groupId, classNameId, type);

		if (equityGroupSetting == null) {
			Group group = groupLocalService.getGroup(groupId);

			long equityGroupSettingId = counterLocalService.increment();

			equityGroupSetting = socialEquityGroupSettingPersistence.create(
				equityGroupSettingId);

			equityGroupSetting.setGroupId(groupId);
			equityGroupSetting.setCompanyId(group.getCompanyId());
			equityGroupSetting.setClassNameId(classNameId);
			equityGroupSetting.setType(type);
		}

		equityGroupSetting.setEnabled(enabled);

		socialEquityGroupSettingPersistence.update(equityGroupSetting, false);
	}

}