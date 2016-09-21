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

package com.liferay.portlet.social.model.impl;

import com.liferay.portlet.social.model.SocialEquityActionMapping;
import com.liferay.portlet.social.model.SocialEquitySetting;
import com.liferay.portlet.social.model.SocialEquitySettingConstants;

/**
 * @author Zsolt Berentey
 */
public class SocialEquitySettingImpl
	extends SocialEquitySettingModelImpl implements SocialEquitySetting {

	public SocialEquitySettingImpl() {
	}

	public void update(SocialEquityActionMapping equityActionMapping) {
		if (getType() == SocialEquitySettingConstants.TYPE_INFORMATION) {
			setDailyLimit(equityActionMapping.getInformationDailyLimit());
			setLifespan(equityActionMapping.getInformationLifespan());
			setUniqueEntry(equityActionMapping.isInformationUnique());
			setValue(equityActionMapping.getInformationValue());
		}
		else {
			setDailyLimit(equityActionMapping.getParticipationDailyLimit());
			setLifespan(equityActionMapping.getParticipationLifespan());
			setUniqueEntry(equityActionMapping.isParticipationUnique());
			setValue(equityActionMapping.getParticipationValue());
		}
	}

}