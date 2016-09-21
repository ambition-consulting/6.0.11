/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletApp;
import com.liferay.portal.service.PortletLocalServiceUtil;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayPortlet extends GenericPortlet {

	public void init() throws PortletException {
		super.init();

		addProcessActionSuccessMessage = GetterUtil.getBoolean(
			getInitParameter("add-process-action-success-action"), true);
	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			if (!isProcessActionRequest(actionRequest)) {
				return;
			}

			if (!callActionMethod(actionRequest, actionResponse)) {
				return;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			if (!SessionMessages.isEmpty(actionRequest)) {
				return;
			}

			addSuccessMessage(actionRequest, actionResponse);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(
					actionRequest, cause.getClass().getName(), cause);
			}
			else {
				throw pe;
			}
		}
	}

	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		if (!isProcessResourceRequest(resourceRequest)) {
			return;
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	protected void addSuccessMessage(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		if (!addProcessActionSuccessMessage) {
			return;
		}

		String successMessage = ParamUtil.getString(
			actionRequest, "successMessage");

		SessionMessages.add(actionRequest, "request_processed", successMessage);
	}

	protected boolean callActionMethod(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		String actionName = ParamUtil.getString(
			actionRequest, ActionRequest.ACTION_NAME);

		if (Validator.isNull(actionName)) {
			return false;
		}

		try {
			Method method = MethodCache.get(
				_classesMap, _methodsMap, getClass().getName(), actionName,
				new Class[] {ActionRequest.class, ActionResponse.class});

			method.invoke(this, actionRequest, actionResponse);

			return true;
		}
		catch (NoSuchMethodException nsme) {
			try {
				super.processAction(actionRequest, actionResponse);

				return true;
			}
			catch (Exception e) {
				throw new PortletException(nsme);
			}
		}
		catch (InvocationTargetException ite) {
			Throwable cause = ite.getCause();

			if (cause != null) {
				throw new PortletException(cause);
			}
			else {
				throw new PortletException(ite);
			}
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	protected void checkPath(String path) throws PortletException {
		if (Validator.isNotNull(path) && !isValidPath(path)) {
			throw new PortletException(
				"Path " + path + " is not accessible by this portlet");
		}
	}

	@SuppressWarnings("unused")
	protected void doAbout(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doAbout method not implemented");
	}

	@SuppressWarnings("unused")
	protected void doConfig(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doConfig method not implemented");
	}

	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (!isProcessRenderRequest(renderRequest)) {
			renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.FALSE);

			return;
		}

		WindowState windowState = renderRequest.getWindowState();

		if (windowState.equals(WindowState.MINIMIZED)) {
			return;
		}

		PortletMode portletMode = renderRequest.getPortletMode();

		if (portletMode.equals(PortletMode.VIEW)) {
			doView(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.ABOUT)) {
			doAbout(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.CONFIG)) {
			doConfig(renderRequest, renderResponse);
		}
		else if (portletMode.equals(PortletMode.EDIT)) {
			doEdit(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.EDIT_DEFAULTS)) {
			doEditDefaults(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.EDIT_GUEST)) {
			doEditGuest(renderRequest, renderResponse);
		}
		else if (portletMode.equals(PortletMode.HELP)) {
			doHelp(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.PREVIEW)) {
			doPreview(renderRequest, renderResponse);
		}
		else if (portletMode.equals(LiferayPortletMode.PRINT)) {
			doPrint(renderRequest, renderResponse);
		}
		else {
			throw new PortletException(portletMode.toString());
		}
	}

	@SuppressWarnings("unused")
	protected void doEditDefaults(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doEditDefaults method not implemented");
	}

	@SuppressWarnings("unused")
	protected void doEditGuest(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doEditGuest method not implemented");
	}

	@SuppressWarnings("unused")
	protected void doPreview(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doPreview method not implemented");
	}

	@SuppressWarnings("unused")
	protected void doPrint(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		throw new PortletException("doPrint method not implemented");
	}

	protected Set<String> getPaths(String path, String extension) {
		Set<String> paths = new HashSet<String>();

		PortletContext portletContext = getPortletContext();

		Set<String> childPaths = portletContext.getResourcePaths(path);

		if (childPaths == null) {
			return paths;
		}

		for (String childPath : childPaths) {
			if (childPath.endsWith(StringPool.SLASH)) {
				paths.addAll(getPaths(childPath, extension));
			}
			else if (childPath.endsWith(extension)) {
				paths.add(childPath);
			}
		}

		return paths;
	}

	protected String getRedirect(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		String redirect = (String)actionRequest.getAttribute(WebKeys.REDIRECT);

		if (Validator.isNull(redirect)) {
			redirect = ParamUtil.getString(actionRequest, "redirect");
		}

		return redirect;
	}

	protected void initValidPaths(String rootPath, String extension) {
		if (rootPath.equals(StringPool.SLASH)) {
			PortletContext portletContext = getPortletContext();

			PortletApp portletApp = PortletLocalServiceUtil.getPortletApp(
				portletContext.getPortletContextName());

			if (!portletApp.isWARFile()) {
				_log.error(
					"Disabling paths for portlet " + getPortletName() +
						" because root path is configured to have access to " +
							"all portal paths");

				validPaths = new HashSet<String>();

				return;
			}
		}

		validPaths = getPaths(rootPath, extension);

		validPaths.addAll(
			getPaths(_PATH_META_INF_RESOURCES + rootPath, extension));

		validPaths.addAll(
			Arrays.asList(StringUtil.split(getInitParameter("valid-paths"))));
	}

	protected boolean isProcessActionRequest(ActionRequest actionRequest) {
		return isProcessPortletRequest(actionRequest);
	}

	protected boolean isProcessPortletRequest(PortletRequest portletRequest) {
		return _PROCESS_PORTLET_REQUEST;
	}

	protected boolean isProcessRenderRequest(RenderRequest renderRequest) {
		return isProcessPortletRequest(renderRequest);
	}

	protected boolean isProcessResourceRequest(
		ResourceRequest resourceRequest) {

		return isProcessPortletRequest(resourceRequest);
	}

	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof PortalException) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean isValidPath(String path) throws PortletException {
		if (validPaths.contains(path) ||
			validPaths.contains(_PATH_META_INF_RESOURCES + path)) {

			return true;
		}

		return false;
	}

	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		String redirect = getRedirect(actionRequest, actionResponse);

		if (Validator.isNotNull(redirect)) {
			actionResponse.sendRedirect(redirect);
		}
	}

	protected boolean addProcessActionSuccessMessage;
	protected Set<String> validPaths;

	private static final String _PATH_META_INF_RESOURCES =
		"/META-INF/resources";

	private static final boolean _PROCESS_PORTLET_REQUEST = true;

	private static Log _log = LogFactoryUtil.getLog(LiferayPortlet.class);

	private Map<String, Class<?>> _classesMap = new HashMap<String, Class<?>>();
	private Map<MethodKey, Method> _methodsMap =
		new HashMap<MethodKey, Method>();

}