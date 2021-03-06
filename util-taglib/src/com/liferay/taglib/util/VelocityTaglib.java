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

package com.liferay.taglib.util;

import com.liferay.portal.kernel.servlet.PipingPageContext;
import com.liferay.portal.kernel.servlet.taglib.TagSupport;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.Theme;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.taglib.portlet.ActionURLTag;
import com.liferay.taglib.portletext.IconBackTag;
import com.liferay.taglib.portletext.IconCloseTag;
import com.liferay.taglib.portletext.IconConfigurationTag;
import com.liferay.taglib.portletext.IconEditDefaultsTag;
import com.liferay.taglib.portletext.IconEditGuestTag;
import com.liferay.taglib.portletext.IconEditTag;
import com.liferay.taglib.portletext.IconHelpTag;
import com.liferay.taglib.portletext.IconMaximizeTag;
import com.liferay.taglib.portletext.IconMinimizeTag;
import com.liferay.taglib.portletext.IconOptionsTag;
import com.liferay.taglib.portletext.IconPortletCssTag;
import com.liferay.taglib.portletext.IconPortletTag;
import com.liferay.taglib.portletext.IconPrintTag;
import com.liferay.taglib.portletext.IconRefreshTag;
import com.liferay.taglib.portletext.RuntimeTag;
import com.liferay.taglib.security.DoAsURLTag;
import com.liferay.taglib.security.PermissionsURLTag;
import com.liferay.taglib.theme.LayoutIconTag;
import com.liferay.taglib.theme.MetaTagsTag;
import com.liferay.taglib.theme.WrapPortletTag;
import com.liferay.taglib.ui.BreadcrumbTag;
import com.liferay.taglib.ui.JournalContentSearchTag;
import com.liferay.taglib.ui.LanguageTag;
import com.liferay.taglib.ui.MyPlacesTag;
import com.liferay.taglib.ui.PngImageTag;
import com.liferay.taglib.ui.SearchTag;
import com.liferay.taglib.ui.StagingTag;
import com.liferay.taglib.ui.ToggleTag;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class VelocityTaglib {

	public VelocityTaglib() {
	}

	public VelocityTaglib(
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response, PageContext pageContext) {

		init(servletContext, request, response, pageContext);
	}

	public void actionURL(long plid, String portletName, String queryString)
		throws Exception {

		String windowState = WindowState.NORMAL.toString();
		String portletMode = PortletMode.VIEW.toString();

		actionURL(windowState, portletMode, plid, portletName, queryString);
	}

	public void actionURL(String portletName, String queryString)
		throws Exception {

		actionURL(LayoutConstants.DEFAULT_PLID, portletName, queryString);
	}

	public void actionURL(
			String windowState, String portletMode, Boolean secure,
			Boolean copyCurrentRenderParameters, Boolean escapeXml, String name,
			long plid, String portletName, Boolean anchor, Boolean encrypt,
			long doAsUserId, Boolean portletConfiguration, String queryString)
		throws Exception {

		String var = null;
		String varImpl = null;
		String resourceID = null;
		String cacheability = null;
		Map<String, String[]> params = HttpUtil.parameterMapFromString(
			queryString);

		ActionURLTag.doTag(
			PortletRequest.ACTION_PHASE, windowState, portletMode, var, varImpl,
			secure, copyCurrentRenderParameters, escapeXml, name, resourceID,
			cacheability, plid, portletName, anchor, encrypt, doAsUserId,
			portletConfiguration, params, _pageContext);
	}

	public void actionURL(
			String windowState, String portletMode, long plid,
			String portletName, String queryString)
		throws Exception {

		Boolean secure = null;
		Boolean copyCurrentRenderParameters = null;
		Boolean escapeXml = null;
		String name = null;
		Boolean anchor = null;
		Boolean encrypt = null;
		long doAsUserId = 0;
		Boolean portletConfiguration = null;

		actionURL(
			windowState, portletMode, secure, copyCurrentRenderParameters,
			escapeXml, name, plid, portletName, anchor, encrypt, doAsUserId,
			portletConfiguration, queryString);
	}

	public void actionURL(
			String windowState, String portletMode, String portletName,
			String queryString)
		throws Exception {

		actionURL(
			windowState, portletMode, LayoutConstants.DEFAULT_PLID, portletName,
			queryString);
	}

	public void breadcrumb() throws Exception {
		BreadcrumbTag breadcrumbTag = new BreadcrumbTag();

		setUp(breadcrumbTag);

		breadcrumbTag.runTag();
	}

	public void breadcrumb(
			int displayStyle, boolean showGuestGroup, boolean showParentGroups,
			boolean showLayout, boolean showPortletBreadcrumb)
		throws Exception {

		BreadcrumbTag breadcrumbTag = new BreadcrumbTag();

		setUp(breadcrumbTag);

		breadcrumbTag.setDisplayStyle(displayStyle);
		breadcrumbTag.setShowGuestGroup(showGuestGroup);
		breadcrumbTag.setShowLayout(showLayout);
		breadcrumbTag.setShowParentGroups(showParentGroups);
		breadcrumbTag.setShowPortletBreadcrumb(showPortletBreadcrumb);

		breadcrumbTag.runTag();
	}

	public void doAsURL(long doAsUserId) throws Exception {
		DoAsURLTag.doTag(doAsUserId, null, _pageContext);
	}

	public BreadcrumbTag getBreadcrumbTag() throws Exception {
		BreadcrumbTag breadcrumbTag = new BreadcrumbTag();

		setUp(breadcrumbTag);

		return breadcrumbTag;
	}

	public MyPlacesTag getMyPlacesTag() throws Exception {
		MyPlacesTag myPlacesTag = new MyPlacesTag();

		setUp(myPlacesTag);

		return myPlacesTag;
	}

	public PngImageTag getPngImageTag() throws Exception {
		PngImageTag pngImageTag = new PngImageTag();

		setUp(pngImageTag);

		return pngImageTag;
	}

	public String getSetting(String name) {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Theme theme = themeDisplay.getTheme();

		return theme.getSetting(name);
	}

	public void iconBack() throws Exception {
		IconBackTag iconBackTag = new IconBackTag();

		setUp(iconBackTag);

		iconBackTag.runTag();
	}

	public void iconClose() throws Exception {
		IconCloseTag iconCloseTag = new IconCloseTag();

		setUp(iconCloseTag);

		iconCloseTag.runTag();
	}

	public void iconConfiguration() throws Exception {
		IconConfigurationTag iconConfigurationTag = new IconConfigurationTag();

		setUp(iconConfigurationTag);

		iconConfigurationTag.runTag();
	}

	public void iconEdit() throws Exception {
		IconEditTag iconEditTag = new IconEditTag();

		setUp(iconEditTag);

		iconEditTag.runTag();
	}

	public void iconEditDefaults() throws Exception {
		IconEditDefaultsTag iconEditDefaultsTag = new IconEditDefaultsTag();

		setUp(iconEditDefaultsTag);

		iconEditDefaultsTag.runTag();
	}

	public void iconEditGuest() throws Exception {
		IconEditGuestTag iconEditGuestTag = new IconEditGuestTag();

		setUp(iconEditGuestTag);

		iconEditGuestTag.runTag();
	}

	public void iconHelp() throws Exception {
		IconHelpTag iconHelpTag = new IconHelpTag();

		setUp(iconHelpTag);

		iconHelpTag.runTag();
	}

	public void iconMaximize() throws Exception {
		IconMaximizeTag iconMaximizeTag = new IconMaximizeTag();

		setUp(iconMaximizeTag);

		iconMaximizeTag.runTag();
	}

	public void iconMinimize() throws Exception {
		IconMinimizeTag iconMinimizeTag = new IconMinimizeTag();

		setUp(iconMinimizeTag);

		iconMinimizeTag.runTag();
	}

	public void iconOptions() throws Exception {
		IconOptionsTag iconOptionsTag = new IconOptionsTag();

		setUp(iconOptionsTag);

		iconOptionsTag.runTag();
	}

	public void iconPortlet() throws Exception {
		IconPortletTag iconPortletTag = new IconPortletTag();

		setUp(iconPortletTag);

		iconPortletTag.runTag();
	}

	public void iconPortlet(Portlet portlet) throws Exception {
		IconPortletTag iconPortletTag = new IconPortletTag();

		setUp(iconPortletTag);

		iconPortletTag.setPortlet(portlet);

		iconPortletTag.runTag();
	}

	public void iconPortletCss() throws Exception {
		IconPortletCssTag iconPortletCssTag = new IconPortletCssTag();

		setUp(iconPortletCssTag);

		iconPortletCssTag.runTag();
	}

	public void iconPrint() throws Exception {
		IconPrintTag iconPrintTag = new IconPrintTag();

		setUp(iconPrintTag);

		iconPrintTag.runTag();
	}

	public void iconRefresh() throws Exception {
		IconRefreshTag iconRefreshTag = new IconRefreshTag();

		setUp(iconRefreshTag);

		iconRefreshTag.runTag();
	}

	public void include(ServletContext servletContext, String page)
		throws Exception {

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(page);

		requestDispatcher.include(_request, _response);
	}

	public void include(String page) throws Exception {
		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(page);

		requestDispatcher.include(_request, _response);
	}

	public VelocityTaglib init(
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response, PageContext pageContext) {

		_servletContext = servletContext;
		_request = request;
		_response = response;
		_pageContext = pageContext;

		return this;
	}

	public void journalContentSearch() throws Exception {
		JournalContentSearchTag journalContentSearchTag =
			new JournalContentSearchTag();

		setUp(journalContentSearchTag);

		journalContentSearchTag.runTag();
	}

	public void language() throws Exception {
		LanguageTag languageTag = new LanguageTag();

		setUp(languageTag);

		languageTag.runTag();
	}

	public void language(
			String formName, String formAction, String name, int displayStyle)
		throws Exception {

		LanguageTag languageTag = new LanguageTag();

		setUp(languageTag);

		languageTag.setDisplayStyle(displayStyle);
		languageTag.setFormAction(formAction);
		languageTag.setFormName(formName);
		languageTag.setName(name);

		languageTag.runTag();
	}

	public void language(
			String formName, String formAction, String name,
			String[] languageIds, int displayStyle)
		throws Exception {

		LanguageTag languageTag = new LanguageTag();

		setUp(languageTag);

		languageTag.setDisplayStyle(displayStyle);
		languageTag.setFormAction(formAction);
		languageTag.setFormName(formName);
		languageTag.setLanguageIds(languageIds);
		languageTag.setName(name);

		languageTag.runTag();
	}

	public void layoutIcon(Layout layout) throws Exception {
		LayoutIconTag.doTag(layout, _servletContext, _request, _response);
	}

	public void metaTags() throws Exception {
		MetaTagsTag.doTag(_servletContext, _request, _response);
	}

	public void myPlaces() throws Exception {
		MyPlacesTag myPlacesTag = new MyPlacesTag();

		setUp(myPlacesTag);

		myPlacesTag.runTag();
	}

	public void myPlaces(int max) throws Exception {
		MyPlacesTag myPlacesTag = new MyPlacesTag();

		setUp(myPlacesTag);

		myPlacesTag.setMax(max);

		myPlacesTag.runTag();
	}

	/**
	 * @deprecated
	 */
	public void permissionsURL(
			String redirect, String modelResource,
			String modelResourceDescription, String resourcePrimKey)
		throws Exception {

		permissionsURL(
			redirect, modelResource, modelResourceDescription, resourcePrimKey);
	}

	public void permissionsURL(
			String redirect, String modelResource,
			String modelResourceDescription, String resourcePrimKey,
			int[] roleTypes)
		throws Exception {

		PermissionsURLTag.doTag(
			redirect, modelResource, modelResourceDescription, resourcePrimKey,
			null, roleTypes, _pageContext);
	}

	public void renderURL(long plid, String portletName, String queryString)
		throws Exception {

		String windowState = WindowState.NORMAL.toString();
		String portletMode = PortletMode.VIEW.toString();

		renderURL(windowState, portletMode, plid, portletName, queryString);
	}

	public void renderURL(String portletName, String queryString)
		throws Exception {

		renderURL(LayoutConstants.DEFAULT_PLID, portletName, queryString);
	}

	public void renderURL(
			String windowState, String portletMode, Boolean secure,
			Boolean copyCurrentRenderParameters, Boolean escapeXml,
			long plid, String portletName, Boolean anchor, Boolean encrypt,
			long doAsUserId, Boolean portletConfiguration, String queryString)
		throws Exception {

		String var = null;
		String varImpl = null;
		String name = null;
		String resourceID = null;
		String cacheability = null;
		Map<String, String[]> params = HttpUtil.parameterMapFromString(
			queryString);

		ActionURLTag.doTag(
			PortletRequest.RENDER_PHASE, windowState, portletMode, var, varImpl,
			secure, copyCurrentRenderParameters, escapeXml, name, resourceID,
			cacheability, plid, portletName, anchor, encrypt, doAsUserId,
			portletConfiguration, params, _pageContext);
	}

	public void renderURL(
			String windowState, String portletMode, long plid,
			String portletName, String queryString)
		throws Exception {

		Boolean secure = null;
		Boolean copyCurrentRenderParameters = null;
		Boolean escapeXml = null;
		Boolean anchor = null;
		Boolean encrypt = null;
		long doAsUserId = 0;
		Boolean portletConfiguration = null;

		renderURL(
			windowState, portletMode, secure, copyCurrentRenderParameters,
			escapeXml, plid, portletName, anchor, encrypt, doAsUserId,
			portletConfiguration, queryString);
	}

	public void renderURL(
			String windowState, String portletMode, String portletName,
			String queryString)
		throws Exception {

		renderURL(
			windowState, portletMode, LayoutConstants.DEFAULT_PLID, portletName,
			queryString);
	}

	public void runtime(String portletName)
		throws Exception {

		runtime(portletName, null);
	}

	public void runtime(String portletName, String queryString)
		throws Exception {

		RuntimeTag.doTag(
			portletName, queryString, null, _servletContext, _request,
			_response);
	}

	public void runtime(
			String portletName, String queryString, String defaultPreferences)
		throws Exception {

		RuntimeTag.doTag(
			portletName, queryString, defaultPreferences, null, _servletContext,
			_request, _response);
	}

	public void search() throws Exception {
		SearchTag searchTag = new SearchTag();

		setUp(searchTag);

		searchTag.runTag();
	}

	public void staging() throws Exception {
		StagingTag stagingTag = new StagingTag();

		setUp(stagingTag);

		stagingTag.runTag();
	}

	public void toggle(
			String id, String showImage, String hideImage, String showMessage,
			String hideMessage, boolean defaultShowContent)
		throws Exception {

		ToggleTag.doTag(
			id, showImage, hideImage, showMessage, hideMessage,
			defaultShowContent, null, _servletContext, _request, _response);
	}

	public String wrapPortlet(String wrapPage, String portletPage)
		throws Exception {

		return WrapPortletTag.doTag(
			wrapPage, portletPage, _servletContext, _request, _response,
			_pageContext);
	}

	protected void setUp(TagSupport tagSupport) throws Exception {
		tagSupport.setPageContext(
			new PipingPageContext(_pageContext, _response.getWriter()));
	}

	private PageContext _pageContext;
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	private ServletContext _servletContext;

}