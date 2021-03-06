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

package com.liferay.portal.struts;

import java.util.Map;

/**
 * @author	   Brian Wing Shun Chan
 * @deprecated {@link com.liferay.portal.kernel.struts.LastPath}
 */
public class LastPath extends com.liferay.portal.kernel.struts.LastPath {

	public LastPath(String contextPath, String path) {
		super(contextPath, path);
	}

	public LastPath(
		String contextPath, String path, Map<String, String[]> parameterMap) {

		super(contextPath, path, parameterMap);
	}

}