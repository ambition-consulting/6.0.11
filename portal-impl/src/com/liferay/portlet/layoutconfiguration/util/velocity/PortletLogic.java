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

package com.liferay.portlet.layoutconfiguration.util.velocity;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portlet.layoutconfiguration.util.RuntimePortletUtil;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class PortletLogic extends RuntimeLogic {

	public PortletLogic(
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response, String portletId) {

		this(servletContext, request, response, null, null);

		_portletId = portletId;
	}

	public PortletLogic(
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_servletContext = servletContext;
		_request = request;
		_response = response;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
	}

	public String processContent(Map<String, String> attributes)
		throws Exception {

		String rootPortletId = attributes.get("name");
		String instanceId = attributes.get("instance");
		String queryString = attributes.get("queryString");

		String portletId = _portletId;

		if (portletId == null) {
			portletId = rootPortletId;

			if (Validator.isNotNull(instanceId)) {
				portletId += PortletConstants.INSTANCE_SEPARATOR + instanceId;
			}
		}

		return RuntimePortletUtil.processPortlet(
			_servletContext, _request, _response, _renderRequest,
			_renderResponse, portletId, queryString, false);
	}

	private ServletContext _servletContext;
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	private RenderRequest _renderRequest;
	private RenderResponse _renderResponse;
	private String _portletId;

}