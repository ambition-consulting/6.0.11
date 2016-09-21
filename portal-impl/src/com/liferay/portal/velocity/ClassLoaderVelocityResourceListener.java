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

package com.liferay.portal.velocity;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.InputStream;

import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * @author Brian Wing Shun Chan
 */
public class ClassLoaderVelocityResourceListener
	extends VelocityResourceListener {

	public InputStream getResourceStream(String source)
		throws ResourceNotFoundException {

		InputStream is = null;

		int pos = source.indexOf(JOURNAL_SEPARATOR);

		if (pos == -1) {
			pos = source.indexOf(SERVLET_SEPARATOR);
		}

		if (pos == -1) {
			pos = source.indexOf(THEME_LOADER_SEPARATOR);
		}

		if (pos == -1) {
			ClassLoader classLoader = getClass().getClassLoader();

			if (_log.isDebugEnabled()) {
				_log.debug("Loading " + source);
			}

			is = classLoader.getResourceAsStream(source);
		}

		return is;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ClassLoaderVelocityResourceListener.class);

}