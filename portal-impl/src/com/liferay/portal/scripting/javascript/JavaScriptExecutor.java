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

package com.liferay.portal.scripting.javascript;

import com.liferay.mozilla.javascript.Context;
import com.liferay.mozilla.javascript.Script;
import com.liferay.mozilla.javascript.Scriptable;
import com.liferay.mozilla.javascript.ScriptableObject;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alberto Montero
 */
public class JavaScriptExecutor implements ScriptingExecutor {

	public static final String CACHE_NAME = JavaScriptExecutor.class.getName();

	public static final String LANGUAGE = "javascript";

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

		Script compiledScript = getCompiledScript(script);

		try {
			Context context = Context.enter();

			Scriptable scriptable = context.initStandardObjects();

			for (Map.Entry<String, Object> entry : inputObjects.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				ScriptableObject.putProperty(
					scriptable, key, Context.javaToJS(value, scriptable));
			}

			if (allowedClasses != null) {
				context.setClassShutter(
					new JavaScriptClassVisibilityChecker(allowedClasses));
			}

			compiledScript.exec(context, scriptable);

			if (outputNames == null) {
				return null;
			}

			Map<String, Object> outputObjects = new HashMap<String, Object>();

			for (String outputName : outputNames) {
				outputObjects.put(
					outputName,
					ScriptableObject.getProperty(scriptable, outputName));
			}

			return outputObjects;
		}
		catch (Exception e) {
			throw new ScriptingException(e.getMessage() + "\n\n", e);
		}
		finally {
			Context.exit();
		}
	}

	protected Script getCompiledScript(String script) {
		String key = String.valueOf(script.hashCode());

		Script compiledScript = (Script)SingleVMPoolUtil.get(CACHE_NAME, key);

		if (compiledScript == null) {
			try {
				Context context = Context.enter();

				compiledScript = context.compileString(
					script, "script", 0, null);
			}
			finally {
				Context.exit();
			}

			SingleVMPoolUtil.put(CACHE_NAME, key, compiledScript);
		}

		return compiledScript;
	}

}