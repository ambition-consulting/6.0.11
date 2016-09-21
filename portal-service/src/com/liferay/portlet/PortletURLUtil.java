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

package com.liferay.portlet;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.util.Enumeration;

import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletURLUtil {

	public static PortletURL getCurrent(
		PortletRequest portletRequest, MimeResponse mimeResponse) {

		PortletURL portletURL = mimeResponse.createRenderURL();

		Enumeration<String> enu = portletRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();
			String[] values = portletRequest.getParameterValues(param);

			boolean addParam = true;

			// Don't set paramter values that are over 32 kb. See LEP-1755.

			for (int i = 0; i < values.length; i++) {
				if (values[i].length() > _CURRENT_URL_PARAMETER_THRESHOLD) {
					addParam = false;

					break;
				}
			}

			if (addParam) {
				portletURL.setParameter(param, values);
			}
		}

		return portletURL;
	}

	public static PortletURL clone(
			PortletURL portletURL, MimeResponse mimeResponse)
		throws PortletException {

		LiferayPortletURL liferayPortletURL = (LiferayPortletURL)portletURL;

		return clone(
			liferayPortletURL, liferayPortletURL.getLifecycle(), mimeResponse);
	}

	public static PortletURL clone(
			PortletURL portletURL, String lifecycle, MimeResponse mimeResponse)
		throws PortletException {

		LiferayPortletURL liferayPortletURL = (LiferayPortletURL)portletURL;

		return clone(liferayPortletURL, lifecycle, mimeResponse);
	}

	public static PortletURL clone(
			LiferayPortletURL liferayPortletURL, String lifecycle,
			MimeResponse mimeResponse)
		throws PortletException {

		LiferayPortletURL newURLImpl = null;

		if (lifecycle.equals(PortletRequest.ACTION_PHASE)) {
			newURLImpl = (LiferayPortletURL)mimeResponse.createActionURL();
		}
		else if (lifecycle.equals(PortletRequest.RENDER_PHASE)) {
			newURLImpl = (LiferayPortletURL)mimeResponse.createRenderURL();
		}

		newURLImpl.setPortletId(liferayPortletURL.getPortletId());

		WindowState windowState = liferayPortletURL.getWindowState();

		if (windowState != null) {
			newURLImpl.setWindowState(windowState);
		}

		PortletMode portletMode = liferayPortletURL.getPortletMode();

		if (portletMode != null) {
			newURLImpl.setPortletMode(portletMode);
		}

		newURLImpl.setParameters(liferayPortletURL.getParameterMap());

		return newURLImpl;
	}

	public static String getRefreshURL(
		HttpServletRequest request, ThemeDisplay themeDisplay) {

		StringBundler sb = new StringBundler();

		sb.append(themeDisplay.getPathMain());
		sb.append("/portal/render_portlet?");

		long plid = themeDisplay.getPlid();

		sb.append("p_l_id=");
		sb.append(plid);

		Portlet portlet = (Portlet)request.getAttribute(
			WebKeys.RENDER_PORTLET);

		String portletId = portlet.getPortletId();

		sb.append("&p_p_id=");
		sb.append(portletId);

		sb.append("&p_p_lifecycle=0");

		WindowState windowState = WindowState.NORMAL;

		LayoutTypePortlet layoutTypePortlet =
			themeDisplay.getLayoutTypePortlet();

		if (layoutTypePortlet.hasStateMaxPortletId(portletId)) {
			windowState = WindowState.MAXIMIZED;
		}
		else if (layoutTypePortlet.hasStateMinPortletId(portletId)) {
			windowState = WindowState.MINIMIZED;
		}

		sb.append("&p_p_state=");
		sb.append(windowState);

		sb.append("&p_p_mode=view");

		String columnId = (String)request.getAttribute(
			WebKeys.RENDER_PORTLET_COLUMN_ID);

		sb.append("&p_p_col_id=");
		sb.append(columnId);

		Integer columnPos = (Integer)request.getAttribute(
			WebKeys.RENDER_PORTLET_COLUMN_POS);

		sb.append("&p_p_col_pos=");
		sb.append(columnPos);

		Integer columnCount = (Integer)request.getAttribute(
			WebKeys.RENDER_PORTLET_COLUMN_COUNT);

		sb.append("&p_p_col_count=");
		sb.append(columnCount);

		if (portlet.isStatic()) {
			sb.append("&p_p_static=1");

			if (portlet.isStaticStart()) {
				sb.append("&p_p_static_start=1");
			}
		}

		sb.append("&p_p_isolated=1");

		String doAsUserId = themeDisplay.getDoAsUserId();

		if (Validator.isNotNull(doAsUserId)) {
			sb.append("&doAsUserId=");
			sb.append(HttpUtil.encodeURL(doAsUserId));
		}

		String currentURL = PortalUtil.getCurrentURL(request);

		sb.append("&currentURL=");
		sb.append(HttpUtil.encodeURL(currentURL));

		String ppid = ParamUtil.getString(request, "p_p_id");

		if (ppid.equals(portletId)) {
			Enumeration<String> enu = request.getParameterNames();

			while (enu.hasMoreElements()) {
				String name = enu.nextElement();

				if (!PortalUtil.isReservedParameter(name) &&
					!name.equals("currentURL")) {

					String[] values = request.getParameterValues(name);

					for (int i = 0; i < values.length; i++) {
						sb.append(StringPool.AMPERSAND);
						sb.append(name);
						sb.append(StringPool.EQUAL);
						sb.append(HttpUtil.encodeURL(values[i]));
					}
				}
			}
		}

		String outerPortletId = PortalUtil.getOuterPortletId(request);

		if (outerPortletId != null) {
			sb.append(StringPool.AMPERSAND);
			sb.append("p_o_p_id");
			sb.append(StringPool.EQUAL);
			sb.append(HttpUtil.encodeURL(outerPortletId));
		}

		return sb.toString();
	}

	private static final int _CURRENT_URL_PARAMETER_THRESHOLD = 32768;

}