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

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseBooleanQueryImpl implements BooleanQuery{

	public void addTerms(String[] fields, String values) throws ParseException {
		if (Validator.isNull(values)) {
			return;
		}

		if (fields == null) {
			fields = new String[0];
		}

		Map<String, List<String>> termFieldsValuesMap = getTermFieldsValuesMap(
			fields, values);

		List<String> valuesList = termFieldsValuesMap.remove("no_field");

		if (!valuesList.isEmpty()) {
			String value = valuesList.get(0);

			for (String field : fields) {
				addTerm(field, value);
			}
		}

		addTerms(fields, termFieldsValuesMap);
	}

	protected void addTerms(
			String[] fields, Map<String, List<String>> termFieldsValuesMap)
		throws ParseException {

		for (String field : fields) {
			List<String> valuesList = termFieldsValuesMap.get(field);

			for (String value : valuesList) {
				addTerm(field, value);
			}
		}
	}

	protected String getTermFieldRemainderValues(
			String field, String values, List<String> valuesList,
			String pattern, String replacement) {

		if (Validator.isNull(values)) {
			return values;
		}

		if (Validator.isNull(pattern) || Validator.isNull(replacement)) {
			return values;
		}

		if (Validator.isNotNull(field)) {
			field += ":";
		}
		else {
			field = StringPool.BLANK;
		}

		while (values.matches(pattern)) {
			String value = values.replaceAll(pattern, replacement);

			valuesList.add(value);

			String duplicate =
				"(?i)\\s*" + Pattern.quote(field + value) + "\\s*";

			values = values.replaceAll(duplicate, StringPool.SPACE);
			values = values.trim();
		}

		return values;
	}

	protected Map<String, List<String>> getTermFieldsValuesMap(
		String[] fields, String values) {

		Map<String, List<String>> termFieldsValuesMap =
			new HashMap<String, List<String>>();

		for (String field : fields) {
			List<String> valuesList = new ArrayList<String>();

			values = getTermFieldRemainderValues(
				field, values, valuesList,
				"(?i)^.*" + field + ":([\"\'])(.+?)(\\1).*$", "$1$2$3");

			values = getTermFieldRemainderValues(
				field, values, valuesList,
				"(?i)^.*" + field + ":([^\\s\"']*).*$", "$1");

			termFieldsValuesMap.put(field, valuesList);
		}

		values = values.trim();

		List<String> valuesList = new ArrayList<String>();

		if (Validator.isNotNull(values)) {
			values = getTermFieldRemainderValues(
				null, values, valuesList,
				"^[^\"\']*([\"\'])(.+?)(\\1)[^\"\']*$", "$1$2$3");

			valuesList.add(values);
		}

		termFieldsValuesMap.put("no_field", valuesList);

		return termFieldsValuesMap;
	}

}