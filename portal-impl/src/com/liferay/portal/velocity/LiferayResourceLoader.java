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
import com.liferay.portal.util.PropsValues;

import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;

/**
 * @author Brian Wing Shun Chan
 */
public class LiferayResourceLoader extends ResourceLoader {

	public static void setListeners(String[] listeners) {
		_listeners = new VelocityResourceListener[listeners.length];

		for (int i = 0; i < listeners.length; i++) {
			try {
				_listeners[i] = (VelocityResourceListener)Class.forName(
					listeners[i]).newInstance();
			}
			catch (Exception ex) {
				_log.error(ex);

				_listeners[i] = null;
			}
		}
	}

	public long getLastModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Get last modified for " + resource.getName());
		}

		return 0;
	}

	public InputStream getResourceStream(String source)
		throws ResourceNotFoundException {

		if (_log.isDebugEnabled()) {
			_log.debug("Get resource for " + source);
		}

		InputStream is = null;

		for (int i = 0; (is == null) && (i < _listeners.length); i++) {
			if (_listeners[i] != null) {
				is = _listeners[i].getResourceStream(source);
			}
		}

		if (is == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Could not find " + source);
			}

			throw new ResourceNotFoundException(source);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Successfully got " + source);
		}

		return is;
	}

	public void init(ExtendedProperties props) {
		setCachingOn(
			PropsValues.VELOCITY_ENGINE_RESOURCE_MANAGER_CACHE_ENABLED);
		setModificationCheckInterval(
			PropsValues.
				VELOCITY_ENGINE_RESOURCE_MANAGER_MODIFICATION_CHECK_INTERVAL);
	}

	public boolean isSourceModified(Resource resource) {
		if (_log.isDebugEnabled()) {
			_log.debug("Check modified status for " + resource.getName());
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
		LiferayResourceLoader.class);

	private static VelocityResourceListener[] _listeners =
		new VelocityResourceListener[0];

}