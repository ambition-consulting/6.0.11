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

package com.liferay.portal.model.impl;

import com.liferay.portal.model.PortletApp;
import com.liferay.portal.model.PortletFilter;

import java.util.Map;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletFilterImpl implements PortletFilter {

	public PortletFilterImpl(
		String filterName, String filterClass, Set<String> lifecycles,
		Map<String, String> initParams, PortletApp portletApp) {

		_filterName = filterName;
		_filterClass = filterClass;
		_lifecycles = lifecycles;
		_initParams = initParams;
		_portletApp = portletApp;
	}

	public String getFilterName() {
		return _filterName;
	}

	public void setFilterName(String filterName) {
		_filterName = filterName;
	}

	public String getFilterClass() {
		return _filterClass;
	}

	public void setFilterClass(String filterClass) {
		_filterClass = filterClass;
	}

	public Set<String> getLifecycles() {
		return _lifecycles;
	}

	public void setLifecycles(Set<String> lifecycles) {
		_lifecycles = lifecycles;
	}

	public Map<String, String> getInitParams() {
		return _initParams;
	}

	public void setInitParams(Map<String, String> initParams) {
		_initParams = initParams;
	}

	public PortletApp getPortletApp() {
		return _portletApp;
	}

	public void setPortletApp(PortletApp portletApp) {
		_portletApp = portletApp;
	}

	private String _filterName;
	private String _filterClass;
	private Set<String> _lifecycles;
	private Map<String, String> _initParams;
	private PortletApp _portletApp;

}