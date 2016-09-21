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

package com.liferay.portlet.imagegallery.action;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;

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
public class FindImageAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		try {
			long plid = ParamUtil.getLong(request, "p_l_id");
			long imageId = ParamUtil.getLong(request, "imageId");

			plid = getPlid(plid, imageId);

			PortletURL portletURL = new PortletURLImpl(
				request, PortletKeys.IMAGE_GALLERY, plid,
				PortletRequest.RENDER_PHASE);

			portletURL.setWindowState(WindowState.MAXIMIZED);
			portletURL.setPortletMode(PortletMode.VIEW);

			portletURL.setParameter(
				"struts_action", "/image_gallery/edit_image");
			portletURL.setParameter("imageId", String.valueOf(imageId));

			response.sendRedirect(portletURL.toString());

			return null;
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);

			return null;
		}
	}

	protected long getPlid(long plid, long imageId) throws Exception {
		if (plid != LayoutConstants.DEFAULT_PLID) {
			try {
				Layout layout = LayoutLocalServiceUtil.getLayout(plid);

				LayoutTypePortlet layoutTypePortlet =
					(LayoutTypePortlet)layout.getLayoutType();

				if (layoutTypePortlet.hasPortletId(PortletKeys.IMAGE_GALLERY)) {
					return plid;
				}
			}
			catch (NoSuchLayoutException nsle) {
			}
		}

		IGImage image = IGImageLocalServiceUtil.getImage(imageId);

		plid = PortalUtil.getPlidFromPortletId(
			image.getGroupId(), PortletKeys.IMAGE_GALLERY);

		if (plid != LayoutConstants.DEFAULT_PLID) {
			return plid;
		}
		else {
			throw new NoSuchLayoutException(
				"No page was found with the Image Gallery portlet.");
		}
	}

}