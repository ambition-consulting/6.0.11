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

package com.liferay.portlet.messageboards.action;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class FindMessageAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			long plid = ParamUtil.getLong(request, "p_l_id");
			long messageId = ParamUtil.getLong(request, "messageId");

			plid = getPlid(plid, messageId);

			PortletURL portletURL = new PortletURLImpl(
				request, PortletKeys.MESSAGE_BOARDS, plid,
				PortletRequest.RENDER_PHASE);

			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);

			portletURL.setParameter(
				"struts_action", "/message_boards/view_message");
			portletURL.setParameter("messageId", String.valueOf(messageId));

			response.sendRedirect(portletURL.toString());

			return null;
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);

			return null;
		}
	}

	protected long getPlid(long plid, long messageId) throws Exception {
		if (plid != LayoutConstants.DEFAULT_PLID) {
			try {
				Layout layout = LayoutLocalServiceUtil.getLayout(plid);

				LayoutTypePortlet layoutTypePortlet =
					(LayoutTypePortlet)layout.getLayoutType();

				if (layoutTypePortlet.hasPortletId(
						PortletKeys.MESSAGE_BOARDS)) {

					return plid;
				}
			}
			catch (NoSuchLayoutException nsle) {
			}
		}

		MBMessage message = MBMessageLocalServiceUtil.getMessage(messageId);

		plid = PortalUtil.getPlidFromPortletId(
			message.getGroupId(), PortletKeys.MESSAGE_BOARDS);

		if (plid != LayoutConstants.DEFAULT_PLID) {
			return plid;
		}
		else {
			throw new NoSuchLayoutException(
				"No page was found with the Message Boards portlet.");
		}
	}

}