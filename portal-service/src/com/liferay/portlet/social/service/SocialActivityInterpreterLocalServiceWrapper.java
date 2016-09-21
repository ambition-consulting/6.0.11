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

package com.liferay.portlet.social.service;

/**
 * <p>
 * This class is a wrapper for {@link SocialActivityInterpreterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialActivityInterpreterLocalService
 * @generated
 */
public class SocialActivityInterpreterLocalServiceWrapper
	implements SocialActivityInterpreterLocalService {
	public SocialActivityInterpreterLocalServiceWrapper(
		SocialActivityInterpreterLocalService socialActivityInterpreterLocalService) {
		_socialActivityInterpreterLocalService = socialActivityInterpreterLocalService;
	}

	public void addActivityInterpreter(
		com.liferay.portlet.social.model.SocialActivityInterpreter activityInterpreter) {
		_socialActivityInterpreterLocalService.addActivityInterpreter(activityInterpreter);
	}

	public void deleteActivityInterpreter(
		com.liferay.portlet.social.model.SocialActivityInterpreter activityInterpreter) {
		_socialActivityInterpreterLocalService.deleteActivityInterpreter(activityInterpreter);
	}

	public com.liferay.portlet.social.model.SocialActivityFeedEntry interpret(
		com.liferay.portlet.social.model.SocialActivity activity,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _socialActivityInterpreterLocalService.interpret(activity,
			themeDisplay);
	}

	public SocialActivityInterpreterLocalService getWrappedSocialActivityInterpreterLocalService() {
		return _socialActivityInterpreterLocalService;
	}

	public void setWrappedSocialActivityInterpreterLocalService(
		SocialActivityInterpreterLocalService socialActivityInterpreterLocalService) {
		_socialActivityInterpreterLocalService = socialActivityInterpreterLocalService;
	}

	private SocialActivityInterpreterLocalService _socialActivityInterpreterLocalService;
}