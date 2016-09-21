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

package com.liferay.portal.kernel.cache;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Michael C. Han
 */
public abstract class BasePortalCache implements PortalCache {

	public void destroy() {
	}

	public boolean isDebug() {
		return _debug;
	}

	public void setDebug(boolean debug) {
		_debug = debug;
	}

	protected String processKey(String key) {
		if (!_debug && (key.length() > _CACHE_KEY_LENGTH_THRESHOLD)) {
			return StringUtil.toHexString(key.hashCode());
		}
		else {
			return key;
		}
	}

	private static final int _CACHE_KEY_LENGTH_THRESHOLD = 16;

	private boolean _debug;

}