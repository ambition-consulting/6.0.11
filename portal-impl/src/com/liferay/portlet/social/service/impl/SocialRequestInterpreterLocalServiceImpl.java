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
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestFeedEntry;
import com.liferay.portlet.social.model.SocialRequestInterpreter;
import com.liferay.portlet.social.model.impl.SocialRequestInterpreterImpl;
import com.liferay.portlet.social.service.base.SocialRequestInterpreterLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialRequestInterpreterLocalServiceImpl
	extends SocialRequestInterpreterLocalServiceBaseImpl {

	public void addRequestInterpreter(
		SocialRequestInterpreter requestInterpreter) {

		_requestInterpreters.add(requestInterpreter);
	}

	public void deleteRequestInterpreter(
		SocialRequestInterpreter requestInterpreter) {

		if (requestInterpreter != null) {
			_requestInterpreters.remove(requestInterpreter);
		}
	}

	public SocialRequestFeedEntry interpret(
		SocialRequest request, ThemeDisplay themeDisplay) {

		String className = PortalUtil.getClassName(request.getClassNameId());

		for (int i = 0; i < _requestInterpreters.size(); i++) {
			SocialRequestInterpreterImpl requestInterpreter =
				(SocialRequestInterpreterImpl)_requestInterpreters.get(i);

			if (requestInterpreter.hasClassName(className)) {
				SocialRequestFeedEntry requestFeedEntry =
					requestInterpreter.interpret(request, themeDisplay);

				if (requestFeedEntry != null) {
					requestFeedEntry.setPortletId(
						requestInterpreter.getPortletId());

					return requestFeedEntry;
				}
			}
		}

		return null;
	}

	public void processConfirmation(
		SocialRequest request, ThemeDisplay themeDisplay) {

		String className = PortalUtil.getClassName(request.getClassNameId());

		for (int i = 0; i < _requestInterpreters.size(); i++) {
			SocialRequestInterpreterImpl requestInterpreter =
				(SocialRequestInterpreterImpl)_requestInterpreters.get(i);

			if (requestInterpreter.hasClassName(className)) {
				boolean value = requestInterpreter.processConfirmation(
					request, themeDisplay);

				if (value) {
					return;
				}
			}
		}
	}

	public void processRejection(
		SocialRequest request, ThemeDisplay themeDisplay) {

		String className = PortalUtil.getClassName(request.getClassNameId());

		for (int i = 0; i < _requestInterpreters.size(); i++) {
			SocialRequestInterpreterImpl requestInterpreter =
				(SocialRequestInterpreterImpl)_requestInterpreters.get(i);

			if (requestInterpreter.hasClassName(className)) {
				boolean value = requestInterpreter.processRejection(
					request, themeDisplay);

				if (value) {
					return;
				}
			}
		}
	}

	private List<SocialRequestInterpreter> _requestInterpreters =
		new ArrayList<SocialRequestInterpreter>();

}