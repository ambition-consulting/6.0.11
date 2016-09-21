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

package com.liferay.portlet.words.action;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.words.ScramblerException;
import com.liferay.portlet.words.util.WordsUtil;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAction extends PortletAction {

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

			if (cmd.equals(Constants.SEARCH)) {
				String word = ParamUtil.getString(renderRequest, "word");
				boolean scramble = ParamUtil.getBoolean(
					renderRequest, "scramble");

				String[] words = null;

				if (scramble) {
					words = WordsUtil.scramble(word);
				}
				else {
					words = WordsUtil.unscramble(word);
				}

				renderRequest.setAttribute(WebKeys.WORDS_LIST, words);
			}
		}
		catch (ScramblerException se) {
			SessionErrors.add(renderRequest, se.getClass().getName());
		}

		return mapping.findForward("portlet.words.view");
	}

}