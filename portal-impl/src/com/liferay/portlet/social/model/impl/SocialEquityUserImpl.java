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

import com.liferay.portlet.social.model.SocialEquityUser;
import com.liferay.portlet.social.model.SocialEquityValue;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialEquityUserImpl
	extends SocialEquityUserModelImpl implements SocialEquityUser {

	public SocialEquityUserImpl() {
	}

	public double getContributionEquity() {
		SocialEquityValue socialEquityValue = new SocialEquityValue(
			getContributionK(), getContributionB());

		return socialEquityValue.getValue();
	}

	public double getParticipationEquity() {
		SocialEquityValue socialEquityValue = new SocialEquityValue(
			getParticipationK(), getParticipationB());

		return socialEquityValue.getValue();
	}

}