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

package com.liferay.portal.search;

import com.liferay.portal.kernel.search.PortalSearchEngine;
import com.liferay.portal.util.PropsValues;

/**
 * @author Bruno Farache
 */
public class PortalSearchEngineImpl implements PortalSearchEngine {

	public PortalSearchEngineImpl() {
		_indexReadOnly = PropsValues.INDEX_READ_ONLY;
	}

	public boolean isIndexReadOnly() {
		return _indexReadOnly;
	}

	public void setIndexReadOnly(boolean indexReadOnly) {
		_indexReadOnly = indexReadOnly;
	}

	private boolean _indexReadOnly;

}