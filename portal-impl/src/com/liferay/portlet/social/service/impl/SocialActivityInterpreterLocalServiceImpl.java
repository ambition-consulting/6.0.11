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

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.portlet.social.model.SocialActivityInterpreter;
import com.liferay.portlet.social.model.impl.SocialActivityInterpreterImpl;
import com.liferay.portlet.social.service.base.SocialActivityInterpreterLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialActivityInterpreterLocalServiceImpl
	extends SocialActivityInterpreterLocalServiceBaseImpl {

	public void addActivityInterpreter(
		SocialActivityInterpreter activityInterpreter) {

		_activityInterpreters.add(activityInterpreter);
	}

	public void deleteActivityInterpreter(
		SocialActivityInterpreter activityInterpreter) {

		if (activityInterpreter != null) {
			_activityInterpreters.remove(activityInterpreter);
		}
	}

	public SocialActivityFeedEntry interpret(
		SocialActivity activity, ThemeDisplay themeDisplay) {

		if (activity.getMirrorActivityId() > 0) {
			SocialActivity mirrorActivity = null;

			try {
				mirrorActivity = socialActivityLocalService.getActivity(
					activity.getMirrorActivityId());
			}
			catch (Exception e) {
			}

			if (mirrorActivity != null) {
				activity = mirrorActivity;
			}
		}

		String className = PortalUtil.getClassName(activity.getClassNameId());

		for (int i = 0; i < _activityInterpreters.size(); i++) {
			SocialActivityInterpreterImpl activityInterpreter =
				(SocialActivityInterpreterImpl)_activityInterpreters.get(i);

			if (activityInterpreter.hasClassName(className)) {
				SocialActivityFeedEntry activityFeedEntry =
					activityInterpreter.interpret(activity, themeDisplay);

				if (activityFeedEntry != null) {
					activityFeedEntry.setPortletId(
						activityInterpreter.getPortletId());

					return activityFeedEntry;
				}
			}
		}

		return null;
	}

	private List<SocialActivityInterpreter> _activityInterpreters =
		new ArrayList<SocialActivityInterpreter>();

}