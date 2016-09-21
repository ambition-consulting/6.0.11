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

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public interface BooleanQuery extends Query {

	public void add(Query query, BooleanClauseOccur booleanClauseOccur)
		throws ParseException;

	public void add(Query query, String occur) throws ParseException;

	public void addExactTerm(String field, boolean value);

	public void addExactTerm(String field, Boolean value);

	public void addExactTerm(String field, double value);

	public void addExactTerm(String field, Double value);

	public void addExactTerm(String field, int value);

	public void addExactTerm(String field, Integer value);

	public void addExactTerm(String field, long value);

	public void addExactTerm(String field, Long value);

	public void addExactTerm(String field, short value);

	public void addExactTerm(String field, Short value);

	public void addExactTerm(String field, String value);

	public void addNumericRangeTerm(String field, int startValue, int endValue);

	public void addNumericRangeTerm(
		String field, Integer startValue, Integer endValue);

	public void addNumericRangeTerm(
		String field, long startValue, long endValue);

	public void addNumericRangeTerm(
		String field, Long startValue, Long endValue);

	public void addNumericRangeTerm(
		String field, short startValue, short endValue);

	public void addNumericRangeTerm(
		String field, Short startValue, Short endValue);

	public void addRangeTerm(String field, int startValue, int endValue);

	public void addRangeTerm(
		String field, Integer startValue, Integer endValue);

	public void addRangeTerm(String field, long startValue, long endValue);

	public void addRangeTerm(String field, Long startValue, Long endValue);

	public void addRangeTerm(String field, short startValue, short endValue);

	public void addRangeTerm(String field, Short startValue, Short endValue);

	public void addRequiredTerm(String field, boolean value);

	public void addRequiredTerm(String field, Boolean value);

	public void addRequiredTerm(String field, double value);

	public void addRequiredTerm(String field, Double value);

	public void addRequiredTerm(String field, int value);

	public void addRequiredTerm(String field, Integer value);

	public void addRequiredTerm(String field, long value);

	public void addRequiredTerm(String field, Long value);

	public void addRequiredTerm(String field, short value);

	public void addRequiredTerm(String field, Short value);

	public void addRequiredTerm(String field, String value);

	public void addRequiredTerm(String field, String value, boolean like);

	public void addTerm(String field, long value) throws ParseException;

	public void addTerm(String field, String value) throws ParseException;

	public void addTerm(String field, String value, boolean like)
		throws ParseException;

	public void addTerms(String[] fields, String values) throws ParseException;

	public List<BooleanClause> clauses();

}