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

package com.liferay.portlet.portletconfiguration.action;

import com.liferay.portal.NoSuchPortletItemException;
import com.liferay.portal.PortletItemNameException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.PortletPreferencesServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Jorge Ferrer
 */
public class EditArchivedSetupsAction extends EditConfigurationAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		Portlet portlet = null;

		try {
			portlet = getPortlet(actionRequest);
		}
		catch (PrincipalException pe) {
			SessionErrors.add(
				actionRequest, PrincipalException.class.getName());

			setForward(actionRequest, "portlet.portlet_configuration.error");
		}

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.SAVE)) {
				updateSetup(actionRequest, portlet);

				sendRedirect(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.RESTORE)) {
				restoreSetup(actionRequest, portlet);

				sendRedirect(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteSetup(actionRequest);

				sendRedirect(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchPortletItemException ||
				e instanceof PortletItemNameException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				sendRedirect(actionRequest, actionResponse);
			}
			else if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(
					actionRequest, "portlet.portlet_configuration.error");
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

		Portlet portlet = null;

		try {
			portlet = getPortlet(renderRequest);
		}
		catch (PrincipalException pe) {
			SessionErrors.add(
				renderRequest, PrincipalException.class.getName());

			return mapping.findForward("portlet.portlet_configuration.error");
		}

		renderResponse.setTitle(getTitle(portlet, renderRequest));

		return mapping.findForward(getForward(
			renderRequest,
			"portlet.portlet_configuration.edit_archived_setups"));
	}

	private void deleteSetup(ActionRequest actionRequest) throws Exception {
		long portletItemId = ParamUtil.getLong(actionRequest, "portletItemId");

		PortletPreferencesServiceUtil.deleteArchivedPreferences(portletItemId);
	}

	private void restoreSetup(ActionRequest actionRequest, Portlet portlet)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String name = ParamUtil.getString(actionRequest, "name");

		PortletPreferences setup =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portlet.getPortletId());

		PortletPreferencesServiceUtil.restoreArchivedPreferences(
			themeDisplay.getScopeGroupId(), name, portlet.getRootPortletId(),
			setup);
	}

	protected void updateSetup(ActionRequest actionRequest, Portlet portlet)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String name = ParamUtil.getString(actionRequest, "name");

		PortletPreferences setup =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portlet.getPortletId());

		PortletPreferencesServiceUtil.updateArchivePreferences(
			themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
			name, portlet.getRootPortletId(), setup);
	}

}