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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.MultiValueMap;
import com.liferay.portal.kernel.util.MultiValueMapFactory;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class MultiValueMapFactoryImpl implements MultiValueMapFactory {

	public MultiValueMap<?, ?> getMultiValueMap(int type) {
		if (type == MultiValueMapFactory.FILE) {
			return new FileMultiValueMap<Serializable, Serializable>();
		}
		else {
			return new MemoryMultiValueMap<Serializable, Serializable>();
		}
	}

}