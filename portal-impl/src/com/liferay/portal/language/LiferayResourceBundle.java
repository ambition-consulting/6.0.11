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

package com.liferay.portal.language;

import com.liferay.portal.kernel.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class LiferayResourceBundle extends ResourceBundle {

	public LiferayResourceBundle(String string, String charsetName)
		throws IOException {

		_map = new HashMap<String, String>();

		Properties properties = PropertiesUtil.load(string, charsetName);

		LanguageResources.fixValues(_map, properties);
	}

	public LiferayResourceBundle(InputStream inputStream, String charsetName)
		throws IOException {

		_map = new HashMap<String, String>();

		Properties properties = PropertiesUtil.load(inputStream, charsetName);

		LanguageResources.fixValues(_map, properties);
	}

	public Object handleGetObject(String key) {
		if (key == null) {
			throw new NullPointerException();
		}

		return _map.get(key);
	}

	public Enumeration<String> getKeys() {
		final Set<String> keys = _map.keySet();

		final Enumeration<String> parentKeys = parent.getKeys();

		final Iterator<String> itr = keys.iterator();

		return new Enumeration<String>() {
			String next = null;

			public boolean hasMoreElements() {
				if (next == null) {
					if (itr.hasNext()) {
						next = itr.next();
					}
					else if (parentKeys != null) {
						while ((next == null) && parentKeys.hasMoreElements()) {
							next = parentKeys.nextElement();

							if (keys.contains(next)) {
								next = null;
							}
						}
					}
				}

				if (next != null) {
					return true;
				}
				else {
					return false;
				}
			}

			public String nextElement() {
				if (hasMoreElements()) {
					String result = next;

					next = null;

					return result;
				}
				else {
					throw new NoSuchElementException();
				}
			}
		};
	}

	private Map<String, String> _map;

}