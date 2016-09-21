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

package com.liferay.portlet.journalcontent.action;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.portlet.PortletRequestUtil;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class ViewAction extends WebContentAction {

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		PortletPreferences preferences = renderRequest.getPreferences();

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long groupId = ParamUtil.getLong(renderRequest, "groupId");

		if (groupId <= 0) {
			groupId = GetterUtil.getLong(
				preferences.getValue("group-id", StringPool.BLANK));
		}

		String articleId = ParamUtil.getString(renderRequest, "articleId");
		String templateId = ParamUtil.getString(renderRequest, "templateId");

		if (Validator.isNull(articleId)) {
			articleId = GetterUtil.getString(
				preferences.getValue("article-id", StringPool.BLANK));
			templateId = GetterUtil.getString(
				preferences.getValue("template-id", StringPool.BLANK));
		}

		String viewMode = ParamUtil.getString(renderRequest, "viewMode");
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		int page = ParamUtil.getInteger(renderRequest, "page", 1);
		String xmlRequest = PortletRequestUtil.toXML(
			renderRequest, renderResponse);

		JournalArticleDisplay articleDisplay = null;

		if ((groupId > 0) && Validator.isNotNull(articleId)) {
			articleDisplay = JournalContentUtil.getDisplay(
				groupId, articleId, templateId, viewMode, languageId,
				themeDisplay, page, xmlRequest);
		}

		if (articleDisplay != null) {
			renderRequest.setAttribute(
				WebKeys.JOURNAL_ARTICLE_DISPLAY, articleDisplay);
		}
		else {
			renderRequest.removeAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);
		}

		return mapping.findForward("portlet.journal_content.view");
	}

}