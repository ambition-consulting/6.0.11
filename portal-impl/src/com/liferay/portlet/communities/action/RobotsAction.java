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

package com.liferay.portlet.communities.action;

import com.liferay.portal.NoSuchLayoutSetException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.RobotsUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author David Truong
 */
public class RobotsAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			String virtualHost = PortalUtil.getHost(request);

			LayoutSet layoutSet = null;

			try {
				layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(virtualHost);
			}
			catch (NoSuchLayoutSetException nslse) {
			}

			String robots = RobotsUtil.getRobots(layoutSet);

			ServletResponseUtil.sendFile(
				request, response, null, robots.getBytes(StringPool.UTF8),
				ContentTypes.TEXT_PLAIN_UTF8);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(e, e);
			}

			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);
		}

		return null;
	}

	private static Log _log = LogFactoryUtil.getLog(RobotsAction.class);

}