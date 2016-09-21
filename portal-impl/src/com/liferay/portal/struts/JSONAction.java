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

package com.liferay.portal.struts;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Ming-Gih Lam
 */
public abstract class JSONAction extends Action {

	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		String callback = ParamUtil.getString(request, "callback");
		String instance = ParamUtil.getString(request, "inst");

		String json = null;

		try {
			json = getJSON(mapping, form, request, response);

			if (Validator.isNotNull(callback)) {
				json = callback + "(" + json + ");";
			}
			else if (Validator.isNotNull(instance)) {
				json = "var " + instance + "=" + json + ";";
			}
		}
		catch (Exception e) {
			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);

			return null;
		}

		if (Validator.isNotNull(json)) {
			response.setContentType(ContentTypes.TEXT_JAVASCRIPT);
			response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");

			PrintWriter printWriter = response.getWriter();

			printWriter.write(json);

			printWriter.close();
		}

		return null;
	}

	public abstract String getJSON(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception;

}