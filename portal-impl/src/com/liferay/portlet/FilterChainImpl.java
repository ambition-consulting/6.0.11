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

package com.liferay.portlet;

import java.io.IOException;

import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

/**
 * @author Brian Wing Shun Chan
 */
public class FilterChainImpl implements FilterChain {

	public FilterChainImpl(
		Portlet portlet, List<? extends PortletFilter> portletFilters) {

		_portlet = portlet;

		if (portletFilters != null) {
			_portletFilters = portletFilters;
		}
		else {
			_portletFilters = Collections.EMPTY_LIST;
		}
	}

	public void doFilter(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		if (_portletFilters.size() > _pos) {
			ActionFilter portletFilter = (ActionFilter)_portletFilters.get(
				_pos++);

			portletFilter.doFilter(actionRequest, actionResponse, this);
		}
		else {
			_portlet.processAction(actionRequest, actionResponse);
		}
	}

	public void doFilter(EventRequest eventRequest, EventResponse eventResponse)
		throws IOException, PortletException {

		if (_portletFilters.size() > _pos) {
			EventFilter portletFilter = (EventFilter)_portletFilters.get(
				_pos++);

			portletFilter.doFilter(eventRequest, eventResponse, this);
		}
		else {
			EventPortlet eventPortlet = (EventPortlet)_portlet;

			eventPortlet.processEvent(eventRequest, eventResponse);
		}
	}

	public void doFilter(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (_portletFilters.size() > _pos) {
			RenderFilter portletFilter = (RenderFilter)_portletFilters.get(
				_pos++);

			portletFilter.doFilter(renderRequest, renderResponse, this);
		}
		else {
			_portlet.render(renderRequest, renderResponse);
		}
	}

	public void doFilter(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		if (_portletFilters.size() > _pos) {
			ResourceFilter portletFilter = (ResourceFilter)_portletFilters.get(
				_pos++);

			portletFilter.doFilter(resourceRequest, resourceResponse, this);
		}
		else {
			ResourceServingPortlet resourceServingPortlet =
				(ResourceServingPortlet)_portlet;

			resourceServingPortlet.serveResource(
				resourceRequest, resourceResponse);
		}
	}

	private Portlet _portlet;
	private List<? extends PortletFilter> _portletFilters;
	private int _pos;

}