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

package com.liferay.portal.kernel.bi.rules;

import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class RulesEngineUtil {

	public static void add(
			String domainName, RulesResourceRetriever rulesResourceRetriever)
		throws RulesEngineException {

		_rulesEngine.add(domainName, rulesResourceRetriever);
	}

	public static void add(
			String domainName, RulesResourceRetriever rulesResourceRetriever,
			ClassLoader... classloaders)
		throws RulesEngineException {

		_rulesEngine.add(domainName, rulesResourceRetriever, classloaders);
	}

	public static boolean containsRuleDomain(String domainName)
		throws RulesEngineException {

		return _rulesEngine.containsRuleDomain(domainName);
	}

	public static void execute(
			RulesResourceRetriever rulesResourceRetriever, List<Fact<?>> facts)
		throws RulesEngineException {

		_rulesEngine.execute(rulesResourceRetriever, facts);
	}

	public static void execute(
			RulesResourceRetriever rulesResourceRetriever, List<Fact<?>> facts,
			ClassLoader... classloaders)
		throws RulesEngineException {

		_rulesEngine.execute(rulesResourceRetriever, facts, classloaders);
	}

	public static Map<String, ?> execute(
			RulesResourceRetriever rulesResourceRetriever, List<Fact<?>> facts,
			Query query)
		throws RulesEngineException {

		return _rulesEngine.execute(rulesResourceRetriever, facts, query);
	}

	public static Map<String, ?> execute(
			RulesResourceRetriever rulesResourceRetriever, List<Fact<?>> facts,
			Query query, ClassLoader... classloaders)
		throws RulesEngineException {

		return _rulesEngine.execute(
			rulesResourceRetriever, facts, query, classloaders);
	}

	public static void execute(String domainName, List<Fact<?>> facts)
		throws RulesEngineException {

		_rulesEngine.execute(domainName, facts);
	}

	public static void execute(
			String domainName, List<Fact<?>> facts, ClassLoader... classloaders)
		throws RulesEngineException {

		_rulesEngine.execute(domainName, facts, classloaders);
	}

	public static Map<String, ?> execute(
			String domainName, List<Fact<?>> facts, Query query)
		throws RulesEngineException {

		return _rulesEngine.execute(domainName, facts, query);
	}

	public static Map<String, ?> execute(
			String domainName, List<Fact<?>> facts, Query query,
			ClassLoader... classloaders)
		throws RulesEngineException {

		return _rulesEngine.execute(domainName, facts, query, classloaders);
	}

	public static void remove(String domainName) throws RulesEngineException {
		_rulesEngine.remove(domainName);
	}

	public static void update(
			String domainName, RulesResourceRetriever rulesResourceRetriever)
		throws RulesEngineException {

		_rulesEngine.update(domainName, rulesResourceRetriever);
	}

	public static void update(
			String domainName, RulesResourceRetriever rulesResourceRetriever,
			ClassLoader... classloaders)
		throws RulesEngineException {

		_rulesEngine.update(domainName, rulesResourceRetriever, classloaders);
	}

	public void setRulesEngine(RulesEngine rulesEngine) {
		_rulesEngine = rulesEngine;
	}

	private static RulesEngine _rulesEngine;

}