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

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.struts.util.RequestUtils;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletResourceBundles {

	public static String getString(Locale locale, String key) {
		return _instance._getString(locale, key);
	}

	public static String getString(PageContext pageContext, String key) {
		return _instance._getString(pageContext, key);
	}

	public static String getString(String languageId, String key) {
		return _instance._getString(languageId, key);
	}

	public static String getString(
		String servletContextName, String languageId, String key) {

		return _instance._getString(servletContextName, languageId, key);
	}

	public static void put(
		String servletContextName, String languageId,
		ResourceBundle resourceBundle) {

		_instance._put(servletContextName, languageId, resourceBundle);
	}

	public static void remove(String servletContextName) {
		_instance._remove(servletContextName);
	}

	private Map<String, Map<String, ResourceBundle>> _resourceBundles;

	private PortletResourceBundles() {
		_resourceBundles =
			new ConcurrentHashMap<String, Map<String, ResourceBundle>>(
				new LinkedHashMap<String, Map<String, ResourceBundle>>());
	}

	private ResourceBundle _getResourceBundle(
		Map<String, ResourceBundle> resourceBundles, String languageId) {

		ResourceBundle resourceBundle = resourceBundles.get(languageId);

		if (resourceBundle == null) {
			try {
				resourceBundle = new PropertyResourceBundle(
					new UnsyncByteArrayInputStream(new byte[0]));

				resourceBundles.put(languageId, resourceBundle);
			}
			catch (IOException ioe) {
				_log.error(ioe);
			}
		}

		return resourceBundle;
	}

	private ResourceBundle _getResourceBundle(
		String servletContextName, String languageId) {

		Map<String, ResourceBundle> resourceBundles = _getResourceBundles(
			servletContextName);

		return _getResourceBundle(resourceBundles, languageId);
	}

	private Map<String, ResourceBundle> _getResourceBundles(
		String servletContextName) {

		Map<String, ResourceBundle> resourceBundles = _resourceBundles.get(
			servletContextName);

		if (resourceBundles == null) {
			resourceBundles = new HashMap<String, ResourceBundle>();

			_resourceBundles.put(servletContextName, resourceBundles);
		}

		return resourceBundles;
	}

	private String _getString(Locale locale, String key) {
		return _getString(LocaleUtil.toLanguageId(locale), key);
	}

	private String _getString(PageContext pageContext, String key) {
		Locale locale = RequestUtils.getUserLocale(
			(HttpServletRequest)pageContext.getRequest(), null);

		return _getString(locale, key);
	}

	private String _getString(String languageId, String key) {
		return _getString(null, languageId, key);
	}

	private String _getString(
		String servletContextName, String languageId, String key) {

		if (servletContextName != null) {
			ResourceBundle resourceBundle = _getResourceBundle(
				servletContextName, languageId);

			return resourceBundle.getString(key);
		}

		Iterator<Map.Entry<String, Map<String, ResourceBundle>>> itr =
			_resourceBundles.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Map<String, ResourceBundle>> entry = itr.next();

			Map<String, ResourceBundle> resourceBundles = entry.getValue();

			ResourceBundle resourceBundle = _getResourceBundle(
				resourceBundles, languageId);

			try {
				return resourceBundle.getString(key);
			}
			catch (MissingResourceException mre) {
			}
		}

		return null;
	}

	private void _put(
		String servletContextName, String languageId,
		ResourceBundle resourceBundle) {

		Map<String, ResourceBundle> resourceBundles = _getResourceBundles(
			servletContextName);

		resourceBundles.put(languageId, resourceBundle);
	}

	private void _remove(String servletContextName) {
		_resourceBundles.remove(servletContextName);
	}

	private static Log _log = LogFactoryUtil.getLog(
		PortletResourceBundles.class);

	private static PortletResourceBundles _instance =
		new PortletResourceBundles();

}