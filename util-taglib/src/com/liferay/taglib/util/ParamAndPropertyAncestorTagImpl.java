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

package com.liferay.taglib.util;

import com.liferay.portal.kernel.servlet.taglib.BaseBodyTagSupport;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.servlet.DynamicServletRequest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class ParamAndPropertyAncestorTagImpl
	extends BaseBodyTagSupport
	implements ParamAncestorTag, PropertyAncestorTag {

	public void addParam(String name, String value) {
		if (_params == null) {
			_params = new LinkedHashMap<String, String[]>();
		}

		String[] values = _params.get(name);

		if (values == null) {
			values = new String[] {value};
		}
		else {
			String[] newValues = new String[values.length + 1];

			System.arraycopy(values, 0, newValues, 0, values.length);

			newValues[newValues.length - 1] = value;

			values = newValues;
		}

		_params.put(name, values);
	}

	public void addProperty(String name, String value) {
		if (_properties == null) {
			_properties = new LinkedHashMap<String, String[]>();
		}

		String[] values = _properties.get(name);

		if (values == null) {
			values = new String[] {value};
		}
		else {
			String[] newValues = new String[values.length + 1];

			System.arraycopy(values, 0, newValues, 0, values.length);

			newValues[newValues.length - 1] = value;

			values = newValues;
		}

		_properties.put(name, values);
	}

	public void clearParams() {
		if (_params != null) {
			_params.clear();
		}
	}

	public void clearProperties() {
		if (_properties != null) {
			_properties.clear();
		}
	}

	public Map<String, String[]> getParams() {
		return _params;
	}

	public Map<String, String[]> getProperties() {
		return _properties;
	}

	public ServletContext getServletContext() {
		if (_servletContext != null) {
			return _servletContext;
		}

		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		ServletContext servletContext = (ServletContext)request.getAttribute(
			WebKeys.CTX);

		if (servletContext == null) {
			servletContext = pageContext.getServletContext();
		}

		return servletContext;
	}

	public HttpServletRequest getServletRequest() {
		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		if (_params != null) {
			request = new DynamicServletRequest(request, _params);
		}

		return request;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private Map<String, String[]> _params;
	private Map<String, String[]> _properties;
	private ServletContext _servletContext;

}