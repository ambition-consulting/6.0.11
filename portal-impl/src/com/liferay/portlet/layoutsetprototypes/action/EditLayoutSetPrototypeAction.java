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

package com.liferay.portlet.layoutsetprototypes.action;

import com.liferay.portal.NoSuchLayoutSetPrototypeException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.struts.PortletAction;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 */
public class EditLayoutSetPrototypeAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateLayoutSetPrototype(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteLayoutSetPrototypes(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(
					actionRequest, "portlet.layout_set_prototypes.error");
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getLayoutSetPrototype(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchLayoutSetPrototypeException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward(
					"portlet.layout_set_prototypes.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest,
			"portlet.layout_set_prototypes.edit_layout_set_prototype"));
	}

	protected void deleteLayoutSetPrototypes(ActionRequest actionRequest)
		throws Exception {

		long[] layoutSetPrototypeIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "layoutSetPrototypeIds"), 0L);

		for (long layoutSetPrototypeId : layoutSetPrototypeIds) {
			LayoutSetPrototypeServiceUtil.deleteLayoutSetPrototype(
				layoutSetPrototypeId);
		}
	}

	protected void updateLayoutSetPrototype(ActionRequest actionRequest)
		throws Exception {

		long layoutSetPrototypeId = ParamUtil.getLong(
			actionRequest, "layoutSetPrototypeId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		boolean active = ParamUtil.getBoolean(actionRequest, "active");

		if (layoutSetPrototypeId <= 0) {

			// Add layout prototoype

			LayoutSetPrototypeServiceUtil.addLayoutSetPrototype(
				nameMap, description, active);
		}
		else {

			// Update layout prototoype

			LayoutSetPrototypeServiceUtil.updateLayoutSetPrototype(
				layoutSetPrototypeId, nameMap, description, active);
		}
	}

}