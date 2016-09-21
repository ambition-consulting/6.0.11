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

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author Brian Wing Shun Chan
 */
public class PropsUtilTask extends Task {

	public void execute() throws BuildException {
		ClassLoader antClassLoader = getClass().getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(antClassLoader);

			getProject().setUserProperty(_result, PropsUtil.get(_key));
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	public void setKey(String key) {
		_key = key;
	}

	public void setResult(String result) {
		_result = result;
	}

	private String _key;
	private String _result;

}