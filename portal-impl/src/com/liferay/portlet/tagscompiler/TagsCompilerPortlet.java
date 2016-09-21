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

package com.liferay.portlet.tagscompiler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.RenderParametersPool;
import com.liferay.portlet.tagscompiler.util.TagsCompilerSessionUtil;

import java.util.Collection;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class TagsCompilerPortlet extends LiferayPortlet {

	public void render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		// Compile entries

		String entriesFromURL = ParamUtil.getString(renderRequest, "entries");
		String[] entriesFromURLArray = StringUtil.split(entriesFromURL);

		if (_log.isDebugEnabled()) {
			_log.debug("Entries from friendly URL " + entriesFromURL);
		}

		Collection<String> entriesFromSession =
			TagsCompilerSessionUtil.getEntries(renderRequest);
		String[] entriesFromSessionArray = entriesFromSession.toArray(
			new String[entriesFromSession.size()]);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Entries from session " +
					StringUtil.merge(entriesFromSessionArray));
		}

		String[] entries = ArrayUtil.append(
			entriesFromURLArray, entriesFromSessionArray);

		renderRequest.setAttribute(WebKeys.TAGS_COMPILER_ENTRIES, entries);

		// Clear render parameters cache

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		RenderParametersPool.clear(
			request, themeDisplay.getPlid(), PortletKeys.TAGS_COMPILER);
	}

	private static Log _log = LogFactoryUtil.getLog(TagsCompilerPortlet.class);

}