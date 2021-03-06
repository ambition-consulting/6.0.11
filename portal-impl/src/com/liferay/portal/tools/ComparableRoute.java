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

package com.liferay.portal.tools;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A dummy container for friendly URL route data used by source formatter.
 * Implements the comparable interface to sort routes by increasing generality.
 *
 * @author Connor McKay
 */
public class ComparableRoute implements Comparable<ComparableRoute> {

	public static boolean hasRegex(String fragment) {
		if (fragment.indexOf(":") != -1) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isCaptureFragment(String fragment) {
		if (fragment.indexOf("{") != -1) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isMatchAny(String fragment) {
		return fragment.matches(".*\\{.+?:\\.\\*\\}.*");
	}

	public ComparableRoute(String pattern) {
		_pattern = pattern;
	}

	public void addGeneratedParameter(String name, String pattern) {
		_generatedParameters.put(name, pattern);
	}

	public void addIgnoredParameter(String name) {
		_ignoredParameters.add(name);
	}

	public void addImplicitParameter(String name, String value) {
		_implicitParameters.put(name, value);
	}

	public void addOverriddenParameter(String name, String value) {
		_overriddenParameters.put(name, value);
	}

	public int compareTo(ComparableRoute comparableRoute) {

		// Don't split on .*

		String[] _fragments = _pattern.split("[/\\.](?!\\*)");

		String pattern = comparableRoute.getPattern();

		String[] fragments = pattern.split("[/\\.](?!\\*)");

		int i;

		for (i = 0; (i < _fragments.length) && (i < fragments.length); i++) {
			String _fragment = _fragments[i];
			String fragment = fragments[i];

			// Capture fragments are more general than static ones

			if (!isCaptureFragment(_fragment) && isCaptureFragment(fragment)) {
				return -1;
			}

			if (isCaptureFragment(_fragment) && !isCaptureFragment(fragment)) {
				return 1;
			}

			// A fragment matching .* is more general than anything

			if (!isMatchAny(_fragment) && isMatchAny(fragment)) {
				return -1;
			}

			if (isMatchAny(_fragment) && !isMatchAny(fragment)) {
				return 1;
			}

			// Not having a regex is more general than having a custom one

			if (hasRegex(_fragment) && !hasRegex(fragment)) {
				return -1;
			}

			if (!hasRegex(_fragment) && hasRegex(fragment)) {
				return 1;
			}
		}

		// Having more fragments is more general

		if ((i < fragments.length) && (i >= _fragments.length)) {
			return -1;
		}

		if ((i < _fragments.length) && (i >= fragments.length)) {
			return 1;
		}

		// Having fewer implicit parameters is more general

		Map<String, String> implicitParameters =
			comparableRoute.getImplicitParameters();

		if (_implicitParameters.size() > implicitParameters.size()) {
			return -1;
		}

		if (_implicitParameters.size() < implicitParameters.size()) {
			return 1;
		}

		return _pattern.compareTo(comparableRoute.getPattern());
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComparableRoute)) {
			return false;
		}

		ComparableRoute comparableRoute = (ComparableRoute)obj;

		if (compareTo(comparableRoute) == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Map<String, String> getGeneratedParameters() {
		return _generatedParameters;
	}

	public Set<String> getIgnoredParameters() {
		return _ignoredParameters;
	}

	public Map<String, String> getImplicitParameters() {
		return _implicitParameters;
	}

	public Map<String, String> getOverriddenParameters() {
		return _overriddenParameters;
	}

	public String getPattern() {
		return _pattern;
	}

	private Map<String, String> _generatedParameters =
		new TreeMap<String, String>();
	private Set<String> _ignoredParameters = new TreeSet<String>();
	private Map<String, String> _implicitParameters =
		new TreeMap<String, String>();
	private Map<String, String> _overriddenParameters =
		new TreeMap<String, String>();
	private String _pattern;

}