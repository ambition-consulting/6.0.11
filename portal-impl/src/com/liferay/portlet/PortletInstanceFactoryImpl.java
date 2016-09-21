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

import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletApp;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.PortletLocalServiceUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletInstanceFactoryImpl implements PortletInstanceFactory {

	public PortletInstanceFactoryImpl() {
		_pool = new ConcurrentHashMap<String, Map<String, InvokerPortlet>>();
	}

	public void clear(Portlet portlet) {
		clear(portlet, true);
	}

	public void clear(Portlet portlet, boolean resetRemotePortletBag) {
		Map<String, InvokerPortlet> portletInstances = _pool.get(
			portlet.getRootPortletId());

		if (portletInstances != null) {
			Iterator<Map.Entry<String, InvokerPortlet>> itr =
				portletInstances.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, InvokerPortlet> entry = itr.next();

				String portletId = entry.getKey();
				InvokerPortlet invokerPortletInstance = entry.getValue();

				if (PortletConstants.getInstanceId(portletId) == null) {
					invokerPortletInstance.destroy();

					break;
				}
			}
		}

		_pool.remove(portlet.getRootPortletId());

		PortletApp portletApp = portlet.getPortletApp();

		if (resetRemotePortletBag && portletApp.isWARFile()) {
			PortletBagPool.remove(portlet.getRootPortletId());
		}
	}

	public InvokerPortlet create(Portlet portlet, ServletContext servletContext)
		throws PortletException {

		boolean instanceable = false;

		if ((portlet.isInstanceable()) &&
			(PortletConstants.getInstanceId(portlet.getPortletId()) != null)) {

			instanceable = true;
		}

		Map<String, InvokerPortlet> portletInstances = _pool.get(
			portlet.getRootPortletId());

		if (portletInstances == null) {
			portletInstances = new ConcurrentHashMap<String, InvokerPortlet>();

			_pool.put(portlet.getRootPortletId(), portletInstances);
		}

		InvokerPortlet instanceInvokerPortletInstance = null;

		if (instanceable) {
			instanceInvokerPortletInstance = portletInstances.get(
				portlet.getPortletId());
		}

		InvokerPortlet rootInvokerPortletInstance = null;

		if (instanceInvokerPortletInstance == null) {
			rootInvokerPortletInstance = portletInstances.get(
				portlet.getRootPortletId());

			if (rootInvokerPortletInstance == null) {
				PortletBag portletBag = PortletBagPool.get(
					portlet.getRootPortletId());

				// Portlet bag should never be null unless the portlet has been
				// undeployed

				if (portletBag == null) {
					PortletBagFactory portletBagFactory =
						new PortletBagFactory();

					portletBagFactory.setClassLoader(
						PortalClassLoaderUtil.getClassLoader());
					portletBagFactory.setServletContext(servletContext);
					portletBagFactory.setWARFile(false);

					try {
						portletBag = portletBagFactory.create(portlet);
					}
					catch (Exception e) {
						throw new PortletException(e);
					}
				}

				PortletConfig portletConfig = PortletConfigFactoryUtil.create(
					portlet, servletContext);

				rootInvokerPortletInstance = init(
					portlet, portletConfig, portletBag.getPortletInstance());

				portletInstances.put(
					portlet.getRootPortletId(), rootInvokerPortletInstance);
			}
		}

		if (instanceable) {
			if (instanceInvokerPortletInstance == null) {
				javax.portlet.Portlet portletInstance =
					rootInvokerPortletInstance.getPortletInstance();

				PortletConfig portletConfig =
					PortletConfigFactoryUtil.create(portlet, servletContext);

				PortletContext portletContext =
					portletConfig.getPortletContext();
				boolean checkAuthToken =
					rootInvokerPortletInstance.isCheckAuthToken();
				boolean facesPortlet =
					rootInvokerPortletInstance.isFacesPortlet();
				boolean strutsPortlet =
					rootInvokerPortletInstance.isStrutsPortlet();
				boolean strutsBridgePortlet =
					rootInvokerPortletInstance.isStrutsBridgePortlet();

				instanceInvokerPortletInstance =
					_internalInvokerPortletPrototype.create(
						portlet, portletInstance, portletConfig, portletContext,
						checkAuthToken, facesPortlet, strutsPortlet,
						strutsBridgePortlet);

				portletInstances.put(
					portlet.getPortletId(), instanceInvokerPortletInstance);
			}
		}
		else {
			if (rootInvokerPortletInstance != null) {
				instanceInvokerPortletInstance = rootInvokerPortletInstance;
			}
		}

		return instanceInvokerPortletInstance;
	}

	public void destroy() {

		// LPS-10473

	}

	public void destroy(Portlet portlet) {
		clear(portlet);

		PortletConfigFactoryUtil.destroy(portlet);
		PortletContextFactory.destroy(portlet);

		PortletLocalServiceUtil.destroyPortlet(portlet);
	}

	public void setInternalInvokerPortletPrototype(
		InvokerPortlet internalInvokerPortletPrototype) {

		_internalInvokerPortletPrototype = internalInvokerPortletPrototype;
	}

	protected InvokerPortlet init(
			Portlet portlet, PortletConfig portletConfig,
			javax.portlet.Portlet portletInstance)
		throws PortletException {

		PortletContext portletContext = portletConfig.getPortletContext();

		InvokerPortlet invokerPortlet = _internalInvokerPortletPrototype.create(
			portlet, portletInstance, portletContext);

		invokerPortlet.init(portletConfig);

		return invokerPortlet;
	}

	private InvokerPortlet _internalInvokerPortletPrototype;
	private Map<String, Map<String, InvokerPortlet>> _pool;

}