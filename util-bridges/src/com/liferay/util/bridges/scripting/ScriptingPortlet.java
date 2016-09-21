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

package com.liferay.util.bridges.scripting;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.servlet.PortletResponseUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 * @author Alberto Montero
 */
public class ScriptingPortlet extends GenericPortlet {

	public void init() {
		actionFile = getInitParameter("action-file");
		editFile = getInitParameter("edit-file");
		helpFile = getInitParameter("help-file");
		resourceFile = getInitParameter("resource-file");
		viewFile = getInitParameter("view-file");

		language = getInitParameter("scripting-language");
		globalFiles = StringUtil.split(getInitParameter("global-files"));
	}

	public void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		String fileName = getFileName(renderRequest);

		if (fileName != null) {
			include(fileName, renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	public void doEdit(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		}
		else {
			include(editFile, renderRequest, renderResponse);
		}
	}

	public void doHelp(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException {

		include(helpFile, renderRequest, renderResponse);
	}

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException {

		include(viewFile, renderRequest, renderResponse);
	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		include(actionFile, actionRequest, actionResponse);
	}

	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			doRender(renderRequest, renderResponse);
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (PortletException pe) {
			throw pe;
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException {

		include(resourceFile, resourceRequest, resourceResponse);
	}

	protected void declareBeans(
			InputStream is, PortletRequest portletRequest,
			PortletResponse portletResponse)
		throws IOException, ScriptingException {

		String script = new String(FileUtil.getBytes(is));

		declareBeans(script, portletRequest, portletResponse);
	}

	protected void declareBeans(
			String script, PortletRequest portletRequest,
			PortletResponse portletResponse)
		throws IOException, ScriptingException {

		script = getGlobalScript() + script;

		PortletConfig portletConfig = getPortletConfig();
		PortletContext portletContext = getPortletContext();

		Map<String, Object> portletObjects = ScriptingUtil.getPortletObjects(
			portletConfig, portletContext, portletRequest, portletResponse);

		ScriptingUtil.exec(null, portletObjects, language, script);
	}

	protected void doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		Object error = SessionErrors.get(renderRequest, _ERROR);

		if (error != null) {
			Exception e = (Exception)error;

			writeErrorMessage(renderRequest, renderResponse, e.getMessage());

			return;
		}

		super.render(renderRequest, renderResponse);

		error = SessionErrors.get(renderRequest, _ERROR);

		if (error != null) {
			Exception e = (Exception)error;

			writeErrorMessage(renderRequest, renderResponse, e.getMessage());
		}
	}

	protected String getFileName(RenderRequest renderRequest) {
		return renderRequest.getParameter("file");
	}

	protected String getGlobalScript() throws IOException {
		if (globalScript != null) {
			return globalScript;
		}

		if (globalFiles.length == 0) {
			globalScript = StringPool.BLANK;

			return globalScript;
		}

		StringBundler sb = new StringBundler();

		for (String globalFile : globalFiles) {
			InputStream is = getPortletContext().getResourceAsStream(
				globalFile);

			if (is == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("Global file " + globalFile + " does not exist");
				}
			}

			try {
				if (is != null) {
					String script = new String(FileUtil.getBytes(is));

					sb.append(script);
					sb.append(StringPool.NEW_LINE);
				}
			}
			finally {
				is.close();
			}
		}

		globalScript = sb.toString();

		return globalScript;
	}

	protected void include(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse)
		throws IOException {

		InputStream is = getPortletContext().getResourceAsStream(path);

		if (is == null) {
			_log.error(path + " is not a valid " + language + " file");

			return;
		}

		try {
			declareBeans(is, portletRequest, portletResponse);
		}
		catch (ScriptingException se) {
			SessionErrors.add(portletRequest, _ERROR, se);
		}
		finally {
			is.close();
		}
	}

	protected void writeErrorMessage(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String errorMessage)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		StringBundler sb = new StringBundler(6);

		sb.append("<div class=\"portlet-msg-error\">");
		sb.append(themeDisplay.translate("an-unexpected-error-occurred"));
		sb.append("</div>");

		if (PortalPermissionUtil.contains(
				permissionChecker, ActionKeys.CONFIGURATION)) {

			sb.append("<pre>");
			sb.append(HtmlUtil.escape(errorMessage));
			sb.append("</pre>");
		}

		renderResponse.setContentType(ContentTypes.TEXT_HTML);

		PortletResponseUtil.write(renderResponse, sb.toString());
	}

	private static final String _ERROR = ScriptingPortlet.class + ".ERROR";

	private static Log _log = LogFactoryUtil.getLog(ScriptingPortlet.class);

	protected String actionFile;
	protected String editFile;
	protected String helpFile;
	protected String[] globalFiles;
	protected String globalScript;
	protected String resourceFile;
	protected String language;
	protected String viewFile;

}