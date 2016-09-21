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

import javax.portlet.EventPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceServingPortlet;

/**
 * @author Michael Young
 */
public interface InvokerPortlet
	extends Cloneable, EventPortlet, Portlet, ResourceServingPortlet {

	public static final String INIT_INVOKER_PORTLET_NAME =
		"com.liferay.portal.invokerPortletName";

	public InvokerPortlet create(
			com.liferay.portal.model.Portlet portletModel, Portlet portlet,
			PortletContext portletContext)
		throws PortletException;

	public InvokerPortlet create(
			com.liferay.portal.model.Portlet portletModel, Portlet portlet,
			PortletConfig portletConfig, PortletContext portletContext,
			boolean checkAuthToken, boolean facesPortlet, boolean strutsPortlet,
			boolean strutsBridgePortlet)
		throws PortletException;

	public Portlet getPortlet();

	public ClassLoader getPortletClassLoader();

	public PortletConfig getPortletConfig();

	public PortletContext getPortletContext();

	public Portlet getPortletInstance();

	public Integer getExpCache();

	public boolean isCheckAuthToken();

	public boolean isDestroyable();

	public boolean isFacesPortlet();

	public boolean isStrutsBridgePortlet();

	public boolean isStrutsPortlet();

	public void prepare(
			com.liferay.portal.model.Portlet portletModel, Portlet portlet,
			PortletContext portletContext)
		throws PortletException;

	public void prepare(
			com.liferay.portal.model.Portlet portletModel, Portlet portlet,
			PortletConfig portletConfig, PortletContext portletContext,
			boolean checkAuthToken, boolean facesPortlet, boolean strutsPortlet,
			boolean strutsBridgePortlet)
		throws PortletException;

	public void setPortletFilters() throws PortletException;

}