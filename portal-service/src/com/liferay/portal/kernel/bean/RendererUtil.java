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

package com.liferay.portal.kernel.bean;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Raymond Augé
 */
public class RendererUtil {

	public static Renderer getRenderer() {
		return _renderer;
	}

	public static String renderBean(
			HttpServletRequest request, HttpServletResponse response,
			Object bean)
		throws RendererException {

		return getRenderer().renderBean(request, response, bean);
	}

	public static String renderBean(
			HttpServletRequest request, HttpServletResponse response,
			Object bean, String varientSuffix)
		throws RendererException {

		return getRenderer().renderBean(request, response, bean, varientSuffix);
	}

	public static String renderBean(
			HttpServletRequest request, HttpServletResponse response,
			String servletContextName, Object bean)
		throws RendererException {

		return getRenderer().renderBean(
			request, response, servletContextName, bean);
	}

	public static String renderBean(
			HttpServletRequest request, HttpServletResponse response,
			String servletContextName, Object bean, String varientSuffix)
		throws RendererException {

		return getRenderer().renderBean(
			request, response, servletContextName, bean, varientSuffix);
	}

	public static String renderBean(
			PortletRequest portletRequest, PortletResponse portletResponse,
			Object bean)
		throws RendererException {

		return getRenderer().renderBean(portletRequest, portletResponse, bean);
	}

	public static String renderBean(
			PortletRequest portletRequest, PortletResponse portletResponse,
			Object bean, String varientSuffix)
		throws RendererException {

		return getRenderer().renderBean(
			portletRequest, portletResponse, bean, varientSuffix);
	}

	public static String renderBean(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String servletContextName, Object bean)
		throws RendererException {

		return getRenderer().renderBean(
			portletRequest, portletResponse, servletContextName, bean);
	}

	public static String renderBean(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String servletContextName, Object bean, String varientSuffix)
		throws RendererException {

		return getRenderer().renderBean(
			portletRequest, portletResponse, servletContextName, bean,
			varientSuffix);
	}

	public static String renderEntity(
			HttpServletRequest request, HttpServletResponse response,
			String className, Object classPK)
		throws RendererException {

		return getRenderer().renderEntity(
			request, response, className, classPK);
	}

	public static String renderEntity(
			HttpServletRequest request, HttpServletResponse response,
			String className, Object classPK, String varientSuffix)
		throws RendererException {

		return getRenderer().renderEntity(
			request, response, className, classPK, varientSuffix);
	}

	public static String renderEntity(
			HttpServletRequest request, HttpServletResponse response,
			String servletContextName, String className, Object classPK)
		throws RendererException {

		return getRenderer().renderEntity(
			request, response, servletContextName, className, classPK);
	}

	public static String renderEntity(
			HttpServletRequest request, HttpServletResponse response,
			String servletContextName, String className, Object classPK,
			String varientSuffix)
		throws RendererException {

		return getRenderer().renderEntity(
			request, response, servletContextName, className, classPK,
			varientSuffix);
	}

	public static String renderEntity(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String className, Object classPK)
		throws RendererException {

		return getRenderer().renderEntity(
			portletRequest, portletResponse, className, classPK);
	}

	public static String renderEntity(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String className, Object classPK, String varientSuffix)
		throws RendererException {

		return getRenderer().renderEntity(
			portletRequest, portletResponse, className, classPK, varientSuffix);
	}

	public static String renderEntity(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String servletContextName, String className, Object classPK)
		throws RendererException {

		return getRenderer().renderEntity(
			portletRequest, portletResponse, servletContextName, className,
			classPK);
	}

	public static String renderEntity(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String servletContextName, String className, Object classPK,
			String varientSuffix)
		throws RendererException {

		return getRenderer().renderEntity(
			portletRequest, portletResponse, servletContextName, className,
			classPK, varientSuffix);
	}

	public void setRenderer(Renderer renderer) {
		_renderer = renderer;
	}

	private static Renderer _renderer;

}