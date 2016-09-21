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

package com.liferay.portal.search.generic;

import com.liferay.portal.kernel.search.BaseBooleanQueryImpl;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanClauseOccurImpl;
import com.liferay.portal.kernel.search.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class BooleanQueryImpl extends BaseBooleanQueryImpl {

	public void add(Query query, BooleanClauseOccur booleanClauseOccur) {
		_clauses.add(new BooleanClauseImpl(query, booleanClauseOccur));
	}

	public void add(Query query, String occur) {
		BooleanClauseOccur booleanClauseOccur = new BooleanClauseOccurImpl(
			occur);

		add(query, booleanClauseOccur);
	}

	public void addExactTerm(String field, boolean value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, Boolean value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, double value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, Double value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, int value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, Integer value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, long value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, Long value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, short value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, Short value) {
		addExactTerm(field, String.valueOf(value));
	}

	public void addExactTerm(String field, String value) {
		TermQueryImpl termQuery = new TermQueryImpl(
			new QueryTermImpl(field, String.valueOf(value)));

		add(termQuery, BooleanClauseOccur.SHOULD);
	}

	public void addNumericRangeTerm(
		String field, int startValue, int endValue) {

		for (int i = startValue; i <= endValue; i++) {
			addExactTerm(field, i);
		}
	}

	public void addNumericRangeTerm(
		String field, Integer startValue, Integer endValue) {

		addNumericRangeTerm(field, startValue.intValue(), endValue.intValue());
	}

	public void addNumericRangeTerm(
		String field, long startValue, long endValue) {

		for (long i = startValue; i <= endValue; i++) {
			addExactTerm(field, i);
		}
	}

	public void addNumericRangeTerm(
		String field, Long startValue, Long endValue) {

		addNumericRangeTerm(
			field, startValue.longValue(), endValue.longValue());
	}

	public void addNumericRangeTerm(
		String field, short startValue, short endValue) {

		for (short i = startValue; i <= endValue; i++) {
			addExactTerm(field, i);
		}
	}

	public void addNumericRangeTerm(
		String field, Short startValue, Short endValue) {

		addNumericRangeTerm(
			field, startValue.shortValue(), endValue.shortValue());
	}

	public void addRangeTerm(String field, int startValue, int endValue) {
		for (int i = startValue; i <= endValue; i++) {
			addTerm(field, i);
		}
	}

	public void addRangeTerm(
		String field, Integer startValue, Integer endValue) {

		addRangeTerm(field, startValue.intValue(), endValue.intValue());
	}

	public void addRangeTerm(String field, long startValue, long endValue) {
		for (long i = startValue; i <= endValue; i++) {
			addTerm(field, i);
		}
	}

	public void addRangeTerm(String field, Long startValue, Long endValue) {
		addRangeTerm(field, startValue.longValue(), endValue.longValue());
	}

	public void addRangeTerm(String field, short startValue, short endValue) {
		for (short i = startValue; i <= endValue; i++) {
			addTerm(field, i);
		}
	}

	public void addRangeTerm(String field, Short startValue, Short endValue) {
		addRangeTerm(field, startValue.shortValue(), endValue.shortValue());
	}

	public void addRequiredTerm(String field, boolean value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, Boolean value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, double value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, Double value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, int value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, Integer value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, long value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, Long value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, short value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, Short value) {
		addRequiredTerm(field, String.valueOf(value), false);
	}

	public void addRequiredTerm(String field, String value) {
		addRequiredTerm(field, value, false);
	}

	public void addRequiredTerm(String field, String value, boolean like) {
		Query query = null;

		if (like) {
			query = new WildcardQueryImpl(
				new QueryTermImpl(field, String.valueOf(value)));
		}
		else {
			query = new TermQueryImpl(
				new QueryTermImpl(field, String.valueOf(value)));
		}

		add(query , BooleanClauseOccur.MUST);
	}

	public void addTerm(String field, long value) {
		addTerm(field, String.valueOf(value), false);
	}

	public void addTerm(String field, String value) {
		addTerm(field, value, false);
	}

	public void addTerm(String field, String value, boolean like) {
		Query query = null;

		if (like) {
			query = new WildcardQueryImpl(
				new QueryTermImpl(field, String.valueOf(value)));
		}
		else {
			query = new TermQueryImpl(
				new QueryTermImpl(field, String.valueOf(value)));
		}

		add(query , BooleanClauseOccur.SHOULD);
	}

	public List<BooleanClause> clauses() {
		return Collections.unmodifiableList(_clauses);
	}

	private List<BooleanClause> _clauses = new ArrayList<BooleanClause>();

}