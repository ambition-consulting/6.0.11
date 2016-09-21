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

package com.liferay.util.servlet.filters;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 */
public class DynamicFilterConfig implements FilterConfig {

	public DynamicFilterConfig(FilterConfig filterConfig) {
		Enumeration<String> enu = filterConfig.getInitParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();

			addInitParameter(name, filterConfig.getInitParameter(name));
		}
	}

	public DynamicFilterConfig(
		String filterName, ServletContext servletContext) {

		_filterName = filterName;
		_servletContext = servletContext;
	}

	public String getFilterName() {
		return _filterName;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	public void addInitParameter(String name, String value) {
		_parameters.put(name, value);
	}

	public String getInitParameter(String name) {
		return _parameters.get(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return Collections.enumeration(_parameters.keySet());
	}

	private String _filterName;
	private ServletContext _servletContext;
	private Map<String, String> _parameters =
		new LinkedHashMap<String, String>();

}