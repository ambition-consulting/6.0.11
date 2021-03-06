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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portal.kernel.search.IndexSearcher;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.NumericField;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopFieldDocs;

/**
 * @author Bruno Farache
 */
public class LuceneIndexSearcherImpl implements IndexSearcher {

	public Hits search(
			long companyId, Query query, Sort[] sorts, int start, int end)
		throws SearchException {

		if (_log.isDebugEnabled()) {
			_log.debug("Query " + query);
		}

		Hits hits = null;

		org.apache.lucene.search.IndexSearcher indexSearcher = null;
		org.apache.lucene.search.Sort luceneSort = null;

		try {
			indexSearcher = LuceneHelperUtil.getSearcher(companyId, true);

			if (sorts != null) {
				indexSearcher.setDefaultFieldSortScoring(true, true);

				SortField[] sortFields = new SortField[sorts.length];

				for (int i = 0; i < sorts.length; i++) {
					Sort sort = sorts[i];

					sortFields[i] = new SortField(
						sort.getFieldName(), sort.getType(), sort.isReverse());
				}

				luceneSort = new org.apache.lucene.search.Sort(sortFields);
			}
			else {
				luceneSort = new org.apache.lucene.search.Sort();
			}

			long startTime = System.currentTimeMillis();

			TopFieldDocs topFieldDocs = indexSearcher.search(
				QueryTranslator.translate(query), null,
				PropsValues.INDEX_SEARCH_LIMIT, luceneSort);

			long endTime = System.currentTimeMillis();

			float searchTime = (float)(endTime - startTime) / Time.SECOND;

			hits = toHits(
				indexSearcher, topFieldDocs, query, startTime, searchTime,
				start, end);
		}
		catch (BooleanQuery.TooManyClauses tmc) {
			int maxClauseCount = BooleanQuery.getMaxClauseCount();

			BooleanQuery.setMaxClauseCount(Integer.MAX_VALUE);

			try {
				long startTime = System.currentTimeMillis();

				TopFieldDocs topFieldDocs = indexSearcher.search(
					QueryTranslator.translate(query), null,
					PropsValues.INDEX_SEARCH_LIMIT, luceneSort);

				long endTime = System.currentTimeMillis();

				float searchTime = (float)(endTime - startTime) / Time.SECOND;

				hits = toHits(
					indexSearcher, topFieldDocs, query, startTime, searchTime,
					start, end);
			}
			catch (Exception e) {
				throw new SearchException(e);
			}
			finally {
				BooleanQuery.setMaxClauseCount(maxClauseCount);
			}
		}
		catch (ParseException pe) {
			_log.error("Query: " + query, pe);

			return new HitsImpl();
		}
		catch (Exception e) {
			throw new SearchException(e);
		}
		finally {
			try {
				if (indexSearcher != null) {
					indexSearcher.close();
				}
			}
			catch (IOException ioe) {
				throw new SearchException(ioe);
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Search found " + hits.getLength() + " results in " +
					hits.getSearchTime() + "ms");
		}

		return hits;
	}

	protected DocumentImpl getDocument(
		org.apache.lucene.document.Document oldDocument) {

		DocumentImpl newDocument = new DocumentImpl();

		List<org.apache.lucene.document.Fieldable> oldFieldables =
			oldDocument.getFields();

		for (org.apache.lucene.document.Fieldable oldFieldable :
				oldFieldables) {

			Field newField = null;

			String[] values = oldDocument.getValues(oldFieldable.name());

			if ((values != null) && (values.length > 1)) {
				newField = new Field(oldFieldable.name(), values);
			}
			else {
				newField = new Field(
					oldFieldable.name(), oldFieldable.stringValue());
			}

			newField.setNumeric(oldFieldable instanceof NumericField);
			newField.setTokenized(oldFieldable.isTokenized());

			newDocument.add(newField);
		}

		return newDocument;
	}

	protected String[] getQueryTerms(Query query) {
		String[] queryTerms = new String[0];

		try {
			queryTerms = LuceneHelperUtil.getQueryTerms(
				QueryTranslator.translate(query));
		}
		catch (ParseException pe) {
			_log.error("Query: " + query, pe);
		}

		return queryTerms;
	}

	protected String getSnippet(
			org.apache.lucene.document.Document doc, Query query, String field)
		throws IOException {

		String[] values = doc.getValues(field);

		String snippet = null;

		if (Validator.isNull(values)) {
			return snippet;
		}

		String s = StringUtil.merge(values);

		try {
			snippet = LuceneHelperUtil.getSnippet(
				QueryTranslator.translate(query), field, s);
		}
		catch (ParseException pe) {
			_log.error("Query: " + query, pe);
		}

		return snippet;
	}

	protected Hits toHits(
			org.apache.lucene.search.IndexSearcher indexSearcher,
			TopFieldDocs topFieldDocs, Query query, long startTime,
			float searchTime, int start, int end)
		throws IOException {

		int length = topFieldDocs.totalHits;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)) {
			start = 0;
			end = length;
		}

		String[] queryTerms = getQueryTerms(query);

		Hits hits = new HitsImpl();

		if ((start > -1) && (start <= end)) {
			if (end > length) {
				end = length;
			}

			int subsetTotal = end - start;

			if (subsetTotal > PropsValues.INDEX_SEARCH_LIMIT) {
				subsetTotal = PropsValues.INDEX_SEARCH_LIMIT;
			}

			List<Document> subsetDocs = new ArrayList<Document>(subsetTotal);
			List<String> subsetSnippets = new ArrayList<String>(subsetTotal);
			List<Float> subsetScores = new ArrayList<Float>(subsetTotal);

			for (int i = start; i < end; i++) {
				if (i >= PropsValues.INDEX_SEARCH_LIMIT) {
					break;
				}

				org.apache.lucene.document.Document document =
					indexSearcher.doc(topFieldDocs.scoreDocs[i].doc);

				Document subsetDocument = getDocument(document);

				subsetDocs.add(subsetDocument);

				String subsetSnippet = getSnippet(
					document, query, Field.CONTENT);

				subsetSnippets.add(subsetSnippet);

				Float subsetScore = topFieldDocs.scoreDocs[i].score;

				subsetScores.add(subsetScore);
			}

			hits.setStart(startTime);
			hits.setSearchTime(searchTime);
			hits.setQueryTerms(queryTerms);
			hits.setDocs(subsetDocs.toArray(new Document[subsetDocs.size()]));
			hits.setLength(length);
			hits.setSnippets(
				subsetSnippets.toArray(new String[subsetSnippets.size()]));
			hits.setScores(
				subsetScores.toArray(new Float[subsetScores.size()]));
		}

		return hits;
	}

	private static Log _log = LogFactoryUtil.getLog(
		LuceneIndexSearcherImpl.class);

}