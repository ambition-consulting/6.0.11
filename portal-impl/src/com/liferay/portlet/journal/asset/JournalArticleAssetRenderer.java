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

package com.liferay.portlet.journal.asset;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.permission.JournalArticlePermission;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Julio Camarero
 * @author Juan Fernández
 */
public class JournalArticleAssetRenderer extends BaseAssetRenderer {

	public JournalArticleAssetRenderer(JournalArticle article) {
		_article = article;
	}

	public String[] getAvailableLocales() {
		return _article.getAvailableLocales();
	}

	public long getClassPK() {
		if ((_article.isDraft() || _article.isPending()) &&
			(_article.getVersion() !=
				JournalArticleConstants.DEFAULT_VERSION)) {

			return _article.getPrimaryKey();
		}
		else {
			return _article.getResourcePrimKey();
		}
	}

	public String getDiscussionPath() {
		if (PropsValues.JOURNAL_ARTICLE_COMMENTS_ENABLED) {
			return "edit_article_discussion";
		}
		else {
			return null;
		}
	}

	public long getGroupId() {
		return _article.getGroupId();
	}

	public String getSummary() {
		return HtmlUtil.stripHtml(_article.getContent());
	}

	public String getTitle() {
			return _article.getTitle();
	}

	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		PortletURL editPortletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.JOURNAL);

		editPortletURL.setParameter(
			"struts_action", "/journal/edit_article");
		editPortletURL.setParameter(
			"groupId", String.valueOf(_article.getGroupId()));
		editPortletURL.setParameter(
			"articleId", _article.getArticleId());
		editPortletURL.setParameter(
			"version", String.valueOf(_article.getVersion()));

		return editPortletURL;
	}

	public PortletURL getURLExport(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		PortletURL exportPortletURL = liferayPortletResponse.createActionURL();

		exportPortletURL.setParameter(
			"struts_action", "/asset_publisher/export_journal_article");
		exportPortletURL.setParameter(
			"groupId", String.valueOf(_article.getGroupId()));
		exportPortletURL.setParameter("articleId", _article.getArticleId());

		return exportPortletURL;
	}

	public String getUrlTitle() {
		return _article.getUrlTitle();
	}

	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String languageId = LanguageUtil.getLanguageId(liferayPortletRequest);

		JournalArticleDisplay articleDisplay =
			JournalContentUtil.getDisplay(
				_article.getGroupId(), _article.getArticleId(),
				null, null, languageId, themeDisplay);

		String viewURL = StringPool.BLANK;

		if (articleDisplay != null) {

			PortletURL viewPortletURL =
				liferayPortletResponse.createRenderURL();

			viewPortletURL.setParameter(
				"struts_action", "/asset_publisher/view_content");
			viewPortletURL.setParameter("urlTitle", _article.getUrlTitle());
			viewPortletURL.setParameter(
				"type", JournalArticleAssetRendererFactory.TYPE);

			viewURL = viewPortletURL.toString();
		}

		return viewURL;
	}

	public long getUserId() {
		return _article.getUserId();
	}

	public String getUuid() {
		return _article.getUuid();
	}

	public String getViewInContextMessage() {
		return "view";
	}

	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		return JournalArticlePermission.contains(
			permissionChecker,_article, ActionKeys.UPDATE);
	}

	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		return JournalArticlePermission.contains(
			permissionChecker,_article, ActionKeys.VIEW);
	}

	public boolean isConvertible() {
		return true;
	}

	public boolean isLocalizable() {
		return true;
	}

	public boolean isPrintable() {
		return true;
	}

	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(WebKeys.JOURNAL_ARTICLE, _article);

			return "/html/portlet/journal/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/history.png";
	}

	private JournalArticle _article;

}