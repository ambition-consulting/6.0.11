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

package com.liferay.portal.scripting.beanshell;

import bsh.Interpreter;

import com.liferay.portal.kernel.scripting.ExecutionException;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public class BeanShellExecutor implements ScriptingExecutor {

	public static final String LANGUAGE = "beanshell";

	public void clearCache() {
	}

	public String getLanguage() {
		return LANGUAGE;
	}

	public Map<String, Object> eval(
			Set<String> allowedClasses, Map<String, Object> inputObjects,
			Set<String> outputNames, String script)
		throws ScriptingException {

		if (allowedClasses != null) {
			throw new ExecutionException(
				"Constrained execution not supported for BeanShell");
		}

		try {
			Interpreter interpreter = new Interpreter();

			for (Map.Entry<String, Object> entry : inputObjects.entrySet()) {
				interpreter.set(entry.getKey(), entry.getValue());
			}

			interpreter.eval(script);

			if (outputNames == null) {
				return null;
			}

			Map<String, Object> outputObjects = new HashMap<String, Object>();

			for (String outputName : outputNames) {
				outputObjects.put(outputName, interpreter.get(outputName));
			}

			return outputObjects;
		}
		catch (Exception e) {
			throw new ScriptingException(e.getMessage(), e);
		}
	}

}