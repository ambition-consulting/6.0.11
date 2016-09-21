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

import com.liferay.portal.kernel.search.IndexSearcher;
import com.liferay.portal.kernel.search.IndexWriter;
import com.liferay.portal.kernel.search.SearchEngine;

/**
 * @author Bruno Farache
 */
public class LuceneSearchEngineImpl implements SearchEngine {

	public static final String NAME = "LUCENE";

	public String getName() {
		return NAME;
	}

	public IndexSearcher getSearcher() {
		return _searcher;
	}

	public IndexWriter getWriter() {
		return _writer;
	}

	public void setSearcher(IndexSearcher searcher) {
		_searcher = searcher;
	}

	public void setWriter(IndexWriter writer) {
		_writer = writer;
	}

	private IndexSearcher _searcher;
	private IndexWriter _writer;

}