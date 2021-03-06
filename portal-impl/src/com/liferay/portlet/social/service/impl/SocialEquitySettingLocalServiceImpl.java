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

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.social.NoSuchEquitySettingException;
import com.liferay.portlet.social.model.SocialEquityActionMapping;
import com.liferay.portlet.social.model.SocialEquitySetting;
import com.liferay.portlet.social.model.SocialEquitySettingConstants;
import com.liferay.portlet.social.model.impl.SocialEquitySettingImpl;
import com.liferay.portlet.social.service.base.SocialEquitySettingLocalServiceBaseImpl;

import java.util.Collections;
import java.util.List;

/**
 * @author Zsolt Berentey
 * @author Brian Wing Shun Chan
 */
public class SocialEquitySettingLocalServiceImpl
	extends SocialEquitySettingLocalServiceBaseImpl {

	public static final String CACHE_NAME =
		SocialEquitySettingLocalServiceImpl.class.getName();

	public List<SocialEquitySetting> getEquitySettings(
			long groupId, String className, String actionId)
		throws SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		return getEquitySettings(groupId, classNameId, actionId);
	}

	public List<SocialEquitySetting> getEquitySettings(
			long groupId, long classNameId, String actionId)
		throws SystemException {

		String key = encodeKey(classNameId, actionId);

		List<SocialEquitySetting> socialEquitySettings =
			(List<SocialEquitySetting>)_portalCache.get(key);

		if (socialEquitySettings != null) {
			return socialEquitySettings;
		}

		String className = PortalUtil.getClassName(classNameId);

		SocialEquityActionMapping equityActionMapping =
			ResourceActionsUtil.getSocialEquityActionMapping(
				className, actionId);

		if (equityActionMapping == null) {
			socialEquitySettings = Collections.EMPTY_LIST;

			_portalCache.put(key, socialEquitySettings);

			return socialEquitySettings;
		}

		List<SocialEquitySetting> equitySettings =
			socialEquitySettingPersistence.findByG_C_A(
				groupId, classNameId, actionId);

		equitySettings = ListUtil.copy(equitySettings);

		if (equitySettings.isEmpty()) {
			if (equityActionMapping.getInformationValue() > 0) {
				SocialEquitySetting informationEquitySetting =
					getInformationEquitySetting(actionId, equityActionMapping);

				equitySettings.add(informationEquitySetting);
			}

			if (equityActionMapping.getParticipationValue() > 0) {
				SocialEquitySetting participationEquitySetting =
					getParticipationEquitySetting(
						actionId, equityActionMapping);

				equitySettings.add(participationEquitySetting);
			}
		}
		else if (equitySettings.size() == 1) {
			SocialEquitySetting equitySetting = equitySettings.get(0);

			if ((equityActionMapping.getInformationValue() > 0) &&
				(equitySetting.getType() ==
					SocialEquitySettingConstants.TYPE_PARTICIPATION)) {

				SocialEquitySetting informationEquitySetting =
					getInformationEquitySetting(actionId, equityActionMapping);

				equitySettings.add(informationEquitySetting);
			}
			else if ((equityActionMapping.getParticipationValue() > 0) &&
					 (equitySetting.getType() ==
						SocialEquitySettingConstants.TYPE_INFORMATION)) {

				SocialEquitySetting participationEquitySetting =
					getParticipationEquitySetting(
						actionId, equityActionMapping);

				equitySettings.add(participationEquitySetting);
			}
		}

		_portalCache.put(key, socialEquitySettings);

		return equitySettings;
	}

	public void updateEquitySettings(
			long groupId, String className,
			List<SocialEquityActionMapping> equityActionMappings)
		throws PortalException, SystemException {

		for (SocialEquityActionMapping equityActionMapping :
				equityActionMappings) {

			updateEquitySettings(groupId, className, equityActionMapping);
		}
	}

	protected String encodeKey(long classNameId, String actionId) {
		StringBundler sb = new StringBundler(5);

		sb.append(CACHE_NAME);
		sb.append(StringPool.POUND);
		sb.append(StringUtil.toHexString(classNameId));
		sb.append(StringPool.POUND);
		sb.append(actionId);

		return sb.toString();
	}

	protected SocialEquitySetting getEquitySetting(
			long groupId, String className, String actionId, int type)
		throws PortalException, SystemException {

		long classNameId = PortalUtil.getClassNameId(className);

		SocialEquitySetting equitySetting = null;

		try {
			equitySetting = socialEquitySettingPersistence.findByG_C_A_T(
				groupId, classNameId, actionId, type);
		}
		catch (NoSuchEquitySettingException nsqse) {
			Group group = groupLocalService.getGroup(groupId);

			long equitySettingId = counterLocalService.increment();

			equitySetting = socialEquitySettingPersistence.create(
				equitySettingId);

			equitySetting.setGroupId(groupId);
			equitySetting.setCompanyId(group.getCompanyId());
			equitySetting.setClassNameId(classNameId);
			equitySetting.setActionId(actionId);
			equitySetting.setType(type);
		}

		return equitySetting;
	}

	protected SocialEquitySetting getInformationEquitySetting(
		String actionId, SocialEquityActionMapping equityActionMapping) {

		SocialEquitySetting equitySetting = new SocialEquitySettingImpl();

		equitySetting.setActionId(actionId);
		equitySetting.setDailyLimit(
			equityActionMapping.getInformationDailyLimit());
		equitySetting.setLifespan(equityActionMapping.getInformationLifespan());
		equitySetting.setType(SocialEquitySettingConstants.TYPE_INFORMATION);
		equitySetting.setUniqueEntry(equityActionMapping.isInformationUnique());
		equitySetting.setValue(equityActionMapping.getInformationValue());

		return equitySetting;
	}

	protected SocialEquitySetting getParticipationEquitySetting(
		String actionId, SocialEquityActionMapping equityActionMapping) {

		SocialEquitySetting equitySetting = new SocialEquitySettingImpl();

		equitySetting.setActionId(actionId);
		equitySetting.setDailyLimit(
			equityActionMapping.getParticipationDailyLimit());
		equitySetting.setLifespan(
			equityActionMapping.getParticipationLifespan());
		equitySetting.setType(SocialEquitySettingConstants.TYPE_PARTICIPATION);
		equitySetting.setUniqueEntry(
			equityActionMapping.isParticipationUnique());
		equitySetting.setValue(equityActionMapping.getParticipationValue());

		return equitySetting;
	}

	protected void updateEquitySettings(
			long groupId, String className,
			SocialEquityActionMapping equityActionMapping)
		throws PortalException, SystemException {

		SocialEquityActionMapping defaultEquityActionMapping =
			PortalUtil.getSocialEquityActionMapping(
				className, equityActionMapping.getActionId());

		if ((equityActionMapping.getInformationValue() > 0) &&
			!equityActionMapping.equals(
				defaultEquityActionMapping,
				SocialEquitySettingConstants.TYPE_INFORMATION)) {

			SocialEquitySetting equitySetting = getEquitySetting(
				groupId, className, equityActionMapping.getActionId(),
				SocialEquitySettingConstants.TYPE_INFORMATION);

			if (!equityActionMapping.equals(equitySetting)) {
				equitySetting.update(equityActionMapping);

				socialEquitySettingPersistence.update(equitySetting, false);
			}
		}

		if ((equityActionMapping.getParticipationValue() > 0) &&
			!equityActionMapping.equals(
				defaultEquityActionMapping,
				SocialEquitySettingConstants.TYPE_PARTICIPATION)) {

			SocialEquitySetting equitySetting = getEquitySetting(
				groupId, className, equityActionMapping.getActionId(),
				SocialEquitySettingConstants.TYPE_PARTICIPATION);

			if (!equityActionMapping.equals(equitySetting)) {
				equitySetting.update(equityActionMapping);

				socialEquitySettingPersistence.update(equitySetting, false);
			}
		}

		long classNameId = PortalUtil.getClassNameId(className);

		String key = encodeKey(classNameId, equityActionMapping.getActionId());

		_portalCache.remove(key);
	}

	private static PortalCache _portalCache = MultiVMPoolUtil.getCache(
		CACHE_NAME);

}