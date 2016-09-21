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

package com.liferay.portal.scripting.python;

import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.scripting.ExecutionException;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.python.core.CompileMode;
import org.python.core.Py;
import org.python.core.PyCode;
import org.python.core.PySystemState;
import org.python.util.InteractiveInterpreter;

/**
 * @author Alberto Montero
 */
public class PythonExecutor implements ScriptingExecutor {

	public static final String CACHE_NAME = PythonExecutor.class.getName();

	public static final String LANGUAGE = "python";

	public void clearCache() {
		SingleVMPoolUtil.clear(CACHE_NAME);
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
				"Constrained execution not supported for Python");
		}

		PyCode compiledScript = getCompiledScript(script);

		InteractiveInterpreter interactiveInterpreter =
			new InteractiveInterpreter();

		for (Map.Entry<String, Object> entry : inputObjects.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			interactiveInterpreter.set(key, value);
		}

		interactiveInterpreter.exec(compiledScript);

		if (outputNames == null) {
			return null;
		}

		Map<String, Object> outputObjects = new HashMap<String, Object>();

		for (String outputName : outputNames) {
			outputObjects.put(
				outputName, interactiveInterpreter.get(outputName));
		}

		return outputObjects;
	}

	protected PyCode getCompiledScript(String script) {
		if (!_initialized) {
			synchronized (this) {
				if (!_initialized) {
					PySystemState.initialize();

					_initialized = true;
				}
			}
		}

		String key = String.valueOf(script.hashCode());

		PyCode compiledScript = (PyCode)SingleVMPoolUtil.get(CACHE_NAME, key);

		if (compiledScript == null) {
			compiledScript = Py.compile_flags(
				script, "<string>", CompileMode.exec, Py.getCompilerFlags());

			SingleVMPoolUtil.put(CACHE_NAME, key, compiledScript);
		}

		return compiledScript;
	}

	private volatile boolean _initialized;

}