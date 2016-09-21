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

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Map;

/**
 * The base implementation of {@link FriendlyURLMapper}.
 *
 * <p>
 * Typically not subclassed directly. {@link DefaultFriendlyURLMapper} and a
 * <code>friendly-url-routes.xml</code> file will handle the needs of most
 * portlets.
 * </p>
 *
 * @author Jorge Ferrer
 * @author Brian Wing Shun Chan
 * @author Connor McKay
 * @see	   DefaultFriendlyURLMapper
 */
public abstract class BaseFriendlyURLMapper implements FriendlyURLMapper {

	public String getMapping() {
		return _mapping;
	}

	public String getPortletId() {
		return _portletId;
	}

	public Router getRouter() {
		return router;
	}

	public boolean isCheckMappingWithPrefix() {
		return _CHECK_MAPPING_WITH_PREFIX;
	}

	public boolean isPortletInstanceable() {
		return _portletInstanceable;
	}

	public void setMapping(String mapping) {
		_mapping = mapping;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setPortletInstanceable(boolean portletInstanceable) {
		_portletInstanceable = portletInstanceable;
	}

	public void setRouter(Router router) {
		this.router = router;
	}

	/**
	 * @deprecated use {@link #addParameter(Map, String, Object)} instead
	 */
	protected void addParam(
		Map<String, String[]> parameterMap, String name, Object value) {

		addParameter(parameterMap, name, value);
	}

	/**
	 * @deprecated use {@link #addParameter(String, Map, String, String)}
	 *			   instead
	 */
	protected void addParam(
		Map<String, String[]> parameterMap, String name, String value) {

		addParameter(parameterMap, name, value);
	}

	/**
	 * Adds a default namespaced parameter of any type to the parameter map.
	 *
	 * <p>
	 * <b>Do not use this method with an instanceable portlet, it will not
	 * properly namespace parameter names.</b>
	 * </p>
	 *
	 * @param parameterMap the parameter map to populate
	 * @param name the name of the parameter
	 * @param value the value of the parameter
	 * @see	  #addParameter(Map, String, String)
	 */
	protected void addParameter(
		Map<String, String[]> parameterMap, String name, Object value) {

		addParameter(getNamespace(), parameterMap, name, String.valueOf(value));
	}

	/**
	 * Adds a default namespaced string parameter to the parameter map.
	 *
	 * <p>
	 * <b>Do not use this method with an instanceable portlet, it will not
	 * properly namespace parameter names.</b>
	 * </p>
	 *
	 * @param parameterMap the parameter map to populate
	 * @param name the name of the parameter
	 * @param value the value of the parameter
	 * @see	  #getNamespace()
	 */
	protected void addParameter(
		Map<String, String[]> parameterMap, String name, String value) {

		addParameter(getNamespace(), parameterMap, name, value);
	}

	/**
	 * Adds a namespaced parameter of any type to the parameter map.
	 *
	 * @param namespace the namespace for portlet parameters. For instanceable
	 *		  portlets this must include the instance id.
	 * @param parameterMap the parameter map to populate
	 * @param name space the namespace for portlet parameters. For instanceable
	 *		  portlets this must include the instance id.
	 * @param value the value of the parameter
	 * @see	  #addParameter(String, Map, String, String)
	 */
	protected void addParameter(
		String namespace, Map<String, String[]> parameterMap, String name,
		Object value) {

		addParameter(namespace, parameterMap, name, String.valueOf(value));
	}

	/**
	 * Adds a namespaced string parameter to the parameter map.
	 *
	 * @param namespace the namespace for portlet parameters. For instanceable
	 *		  portlets this must include the instance id.
	 * @param parameterMap the parameter map to populate
	 * @param name space the namespace for portlet parameters. For instanceable
	 *		  portlets this must include the instance id.
	 * @param value the value of the parameter
	 * @see	  PortalUtil#getPortletNamespace(String)
	 * @see	  DefaultFriendlyURLMapper#getPortletId(Map)
	 */
	protected void addParameter(
		String namespace, Map<String, String[]> parameterMap, String name,
		String value) {

		try {
			if (!PortalUtil.isReservedParameter(name)) {
				Map<String, String> prpIdentifers =
					FriendlyURLMapperThreadLocal.getPRPIdentifiers();

				if (prpIdentifers.containsKey(name)) {
					name = prpIdentifers.get(name);
				}
				else {
					name = namespace + name;
				}
			}

			parameterMap.put(name, new String[] {value});
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	/**
	 * Gets the default namespace.
	 *
	 * <p>
	 * <b>Do not use this method with an instanceable portlet, it will not
	 * include the instance id.</b>
	 * </p>
	 *
	 * @return the default namespace, not including the instance id
	 * @see	   PortalUtil#getPortletNamespace(String)
	 */
	protected String getNamespace() {
		return PortalUtil.getPortletNamespace(getPortletId());
	}

	protected Router router;

	private static final boolean _CHECK_MAPPING_WITH_PREFIX = true;

	private static Log _log = LogFactoryUtil.getLog(
		BaseFriendlyURLMapper.class);

	private String _mapping;
	private String _portletId;
	private boolean _portletInstanceable;

}