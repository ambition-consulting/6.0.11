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

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

/**
 * @author Bruno Farache
 */
public interface LuceneHelper {

	public void addDocument(long companyId, Document document)
		throws IOException;

	public void addExactTerm(
		BooleanQuery booleanQuery, String field, String value);

	public void addNumericRangeTerm(
		BooleanQuery booleanQuery, String field, String startValue,
		String endValue);

	public void addRangeTerm(
		BooleanQuery booleanQuery, String field, String startValue,
		String endValue);

	public void addRequiredTerm(
		BooleanQuery booleanQuery, String field, String value, boolean like);

	public void addTerm(
			BooleanQuery booleanQuery, String field, String value, boolean like)
		throws ParseException;

	public void delete(long companyId);

	public void deleteDocuments(long companyId, Term term) throws IOException;

	public Analyzer getAnalyzer();

	public String[] getQueryTerms(Query query);

	public IndexSearcher getSearcher(long companyId, boolean readOnly)
		throws IOException;

	public String getSnippet(
			Query query, String field, String s, int maxNumFragments,
			int fragmentLength, String fragmentSuffix, String preTag,
			String postTag)
		throws IOException;

	public Version getVersion();

	public void shutdown();

	public void updateDocument(long companyId, Term term, Document document)
		throws IOException;

}