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

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;

/**
 * Represents a URL pointing to a portlet.
 *
 * @author Brian Wing Shun Chan
 * @see	   com.liferay.portlet.PortletURLImpl
 */
public interface LiferayPortletURL
	extends PortletURL, ResourceURL, Serializable {

	/**
	 * Adds a parameter that is included in the friendly URL path and does not
	 * need to appear in the query string.
	 *
	 * @param name the name of the parameter that is included in the path
	 */
	public void addParameterIncludedInPath(String name);

	/**
	 * Gets the lifecycle of the portlet this URL points to.
	 *
	 * @return the portlet lifecycle
	 * @see	   #setLifecycle(String)
	 */
	public String getLifecycle();

	/**
	 * Gets the first value of the URL parameter.
	 *
	 * @param  name the name of the URL parameter to get the value of
	 * @return the first value of the URL parameter
	 */
	public String getParameter(String name);

	/**
	 * Gets the id of the portlet this URL points to.
	 *
	 * @return the id of the portlet this URL points to
	 */
	public String getPortletId();

	/**
	 * Gets the map of reserved parameters for this URL.
	 *
	 * <p>
	 * This method is only used internally. Reserved parameters contain special,
	 * Liferay specific information, such as <code>p_p_id</code> and
	 * <code>p_p_lifecycle</code>.
	 * </p>
	 *
	 * @return the reserved parameter names and values in a read-only map
	 */
	public Map<String, String> getReservedParameterMap();

	/**
	 * Gets the id of the resource this URL points to.
	 *
	 * @return the id of the resource this URL points to
	 */
	public String getResourceID();

	/**
	 * Determines if this URL is an anchor pointing to the specified portlet on
	 * the page.
	 *
	 * @return whether this URL is an anchor pointing to the specified portlet
	 *		   on the page
	 * @see	   #setAnchor(boolean)
	 */
	public boolean isAnchor();

	/**
	 * Determines if the render parameters in the current request should be
	 * copied to this URL.
	 *
	 * @return whether the render parameters in the current request should be
	 *		   copied to this URL
	 * @see	   #setCopyCurrentRenderParameters(boolean)
	 */
	public boolean isCopyCurrentRenderParameters();

	/**
	 * Determines if this URL should be encrypted.
	 *
	 * @return true if this URL should be encrypted; false otherwise
	 * @see	   #setEncrypt(boolean)
	 */
	public boolean isEncrypt();

	/**
	 * Determines if this URL should be XML escaped.
	 *
	 * @return true if this URL should be XML escaped; false otherwise
	 * @see	   #setEscapeXml(boolean)
	 */
	public boolean isEscapeXml();

	/**
	 * Determines if the parameter is included in the friendly URL path.
	 *
	 * @param  name the name of the parameter to check for inclusion in the path
	 * @return whether the parameter is included in the friendly URL path
	 * @see	   #addParameterIncludedInPath(String)
	 */
	public boolean isParameterIncludedInPath(String name);

	/**
	 * Determines if this URL is secure (https).
	 *
	 * @return true if this URL is secure; false otherwise
	 */
	public boolean isSecure();

	/**
	 * Sets the lifecycle of the portlet this URL points to.
	 *
	 * <p>
	 * Valid lifecycles are:
	 * </p>
	 *
	 * <ul>
	 * <li>
	 * {@link javax.portlet.PortletRequest#ACTION_PHASE}
	 * </li>
	 * <li>
	 * {@link javax.portlet.PortletRequest#RENDER_PHASE}
	 * </li>
	 * <li>
	 * {@link javax.portlet.PortletRequest#RESOURCE_PHASE}
	 * </li>
	 * </ul>
	 *
	 * @param lifecycle the lifecycle of the portlet this URL points to
	 */
	public void setLifecycle(String lifecycle);

	/**
	 * Sets the URL parameter to the value.
	 *
	 * @param name the name of the URL parameter
	 * @param value the value of the URL parameter
	 * @param append whether the new value should be appended to any existing
	 *		  values for the parameter. If <code>append</code> is
	 *		  <code>false</code> any existing values will be overwritten with
	 *		  the new value.
	 */
	public void setParameter(String name, String value, boolean append);

	/**
	 * Sets the URL parameter the values.
	 *
	 * @param name the name of the URL parameter
	 * @param append whether the new values should be appended to any existing
	 *		  values for the parameter. If <code>append</code> is
	 *		  <code>false</code> any existing values will be overwritten with
	 *		  the new values.
	 */
	public void setParameter(String name, String[] values, boolean append);

	public Set<String> getParametersIncludedInPath();

	/**
	 * Sets whether this URL is an anchor pointing to the specified portlet on
	 * the page.
	 *
	 * <p>
	 * An anchor URL will cause the user's browser to automatically jump down to
	 * the specified portlet after the page loads, avoiding the need to scroll.
	 * </p>
	 *
	 * @param anchor whether this URL is an anchor pointing to the specified
	 *		  portlet on the page
	 */
	public void setAnchor(boolean anchor);

	/**
	 * Sets whether the render parameters in the current request should be
	 * copied to this URL.
	 *
	 * <p>
	 * New parameters set on this URL will appear before the copied render
	 * parameters.
	 * </p>
	 *
	 * @param copyCurrentRenderParameters whether the render parameters in the
	 *		  current request should be copied to this URL
	 */
	public void setCopyCurrentRenderParameters(
		boolean copyCurrentRenderParameters);

	/**
	 * Sets the id of the user to impersonate.
	 *
	 * <p>
	 * When a page is accessed while impersonating a user, it will appear
	 * exactly as it would to that user.
	 * </p>
	 *
	 * @param doAsUserId the id of the user to impersonate in the portlet this
	 *		  URL points to
	 */
	public void setDoAsUserId(long doAsUserId);

	public void setDoAsUserLanguageId(String doAsUserLanguageId);

	/**
	 * Sets whether this URL should be encrypted.
	 *
	 * <p>
	 * In an encrypted URL, the value of every parameter will be encrypted using
	 * the company's key. This allows sensitive information to be placed in the
	 * URL without being vulnerable to snooping.
	 * </p>
	 *
	 * <p>
	 * Note that this is not the same as making a URL {@link #setSecure(boolean)
	 * secure}.
	 * </p>
	 */
	public void setEncrypt(boolean encrypt);

	/**
	 * Sets whether this URL should be XML escaped.
	 *
	 * <p>
	 * If a URL is XML escaped, it will automatically have special characters
	 * escaped when it is converted to a string or written to a {@link
	 * java.io.Writer}.
	 * </p>
	 *
	 * @param escapeXml whether this URL should be XML escaped
	 */
	public void setEscapeXml(boolean escapeXml);

	/**
	 * Sets the portlet layout id.
	 *
	 * @param plid the portlet layout id
	 */
	public void setPlid(long plid);

	/**
	 * Sets the id of the target portlet.
	 */
	public void setPortletId(String portletId);

}