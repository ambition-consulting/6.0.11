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

package com.liferay.portal.search.lucene;

import com.liferay.portal.kernel.search.BaseBooleanQueryImpl;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanClauseOccurImpl;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class BooleanQueryImpl extends BaseBooleanQueryImpl {

	public BooleanQueryImpl() {
		_booleanQuery = new org.apache.lucene.search.BooleanQuery();
	}

	public void add(Query query, BooleanClauseOccur booleanClauseOccur)
		throws ParseException {

		try {
			_booleanQuery.add(
				QueryTranslator.translate(query),
				BooleanClauseOccurTranslator.translate(booleanClauseOccur));
		}
		catch (org.apache.lucene.queryParser.ParseException pe) {
			throw new ParseException(pe.getMessage());
		}
	}

	public void add(Query query, String occur) throws ParseException {
		BooleanClauseOccur booleanClauseOccur = new BooleanClauseOccurImpl(
			occur);

		add(query, booleanClauseOccur);
	}

	public void addExactTerm(String field, boolean value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, Boolean value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, double value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, Double value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, int value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, Integer value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, long value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, Long value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, short value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, Short value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addExactTerm(String field, String value) {
		LuceneHelperUtil.addExactTerm(_booleanQuery, field, value);
	}

	public void addNumericRangeTerm(
		String field, int startValue, int endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addNumericRangeTerm(
		String field, Integer startValue, Integer endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addNumericRangeTerm(
		String field, long startValue, long endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addNumericRangeTerm(
		String field, Long startValue, Long endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addNumericRangeTerm(
		String field, short startValue, short endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addNumericRangeTerm(
		String field, Short startValue, Short endValue) {

		LuceneHelperUtil.addNumericRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(String field, int startValue, int endValue) {
		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(
		String field, Integer startValue, Integer endValue) {

		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(String field, long startValue, long endValue) {
		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(String field, Long startValue, Long endValue) {
		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(String field, short startValue, short endValue) {
		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRangeTerm(String field, Short startValue, Short endValue) {
		LuceneHelperUtil.addRangeTerm(
			_booleanQuery, field, startValue, endValue);
	}

	public void addRequiredTerm(String field, boolean value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, Boolean value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, double value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, Double value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, int value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, Integer value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, long value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, Long value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, short value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, Short value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, String value) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value);
	}

	public void addRequiredTerm(String field, String value, boolean like) {
		LuceneHelperUtil.addRequiredTerm(_booleanQuery, field, value, like);
	}

	public void addTerm(String field, long value) throws ParseException {
		try {
			LuceneHelperUtil.addTerm(_booleanQuery, field, value);
		}
		catch (org.apache.lucene.queryParser.ParseException pe) {
			throw new ParseException(pe.getMessage());
		}
	}

	public void addTerm(String field, String value) throws ParseException {
		try {
			LuceneHelperUtil.addTerm(_booleanQuery, field, value);
		}
		catch (org.apache.lucene.queryParser.ParseException pe) {
			throw new ParseException(pe.getMessage());
		}
	}

	public void addTerm(String field, String value, boolean like)
		throws ParseException {

		try {
			LuceneHelperUtil.addTerm(_booleanQuery, field, value, like);
		}
		catch (org.apache.lucene.queryParser.ParseException pe) {
			throw new ParseException(pe.getMessage());
		}
	}

	public List<BooleanClause> clauses() {
		List<org.apache.lucene.search.BooleanClause> luceneClauses =
			_booleanQuery.clauses();

		List<BooleanClause> clauses = new ArrayList<BooleanClause>(
			luceneClauses.size());

		for (int i = 0; i < luceneClauses.size(); i++) {
			clauses.add(new BooleanClauseImpl(luceneClauses.get(i)));
		}

		return clauses;
	}

	public org.apache.lucene.search.BooleanQuery getBooleanQuery() {
		return _booleanQuery;
	}

	public String toString() {
		return _booleanQuery.toString();
	}

	private org.apache.lucene.search.BooleanQuery _booleanQuery;

}