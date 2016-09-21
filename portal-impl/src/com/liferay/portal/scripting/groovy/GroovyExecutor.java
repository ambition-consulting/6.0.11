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

package com.liferay.portal.scripting.groovy;

import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.scripting.ExecutionException;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingExecutor;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alberto Montero
 * @author Brian Wing Shun Chan
 */
public class GroovyExecutor implements ScriptingExecutor {

	public static final String CACHE_NAME = GroovyExecutor.class.getName();

	public static final String LANGUAGE = "groovy";

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
				"Constrained execution not supported for Groovy");
		}

		Script compiledScript = getCompiledScript(script);

		Binding binding = new Binding(inputObjects);

		compiledScript.setBinding(binding);

		compiledScript.run();

		if (outputNames == null) {
			return null;
		}

		Map<String, Object> outputObjects = new HashMap<String, Object>();

		for (String outputName : outputNames) {
			outputObjects.put(outputName, binding.getVariable(outputName));
		}

		return outputObjects;
	}

	protected Script getCompiledScript(String script) {
		if (_groovyShell == null) {
			synchronized (this) {
				if (_groovyShell == null) {
					_groovyShell = new GroovyShell();
				}
			}
		}

		String key = String.valueOf(script.hashCode());

		Script compiledScript = (Script)SingleVMPoolUtil.get(CACHE_NAME, key);

		if (compiledScript == null) {
			compiledScript = _groovyShell.parse(script);

			SingleVMPoolUtil.put(CACHE_NAME, key, compiledScript);
		}

		return compiledScript;
	}

	private volatile GroovyShell _groovyShell;

}