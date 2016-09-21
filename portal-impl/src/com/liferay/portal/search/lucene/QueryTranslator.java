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

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.StringPool;

import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;

/**
 * @author Brian Wing Shun Chan
 */
public class QueryTranslator {

	public static org.apache.lucene.search.Query translate(Query query)
		throws ParseException {

		if (query instanceof BooleanQueryImpl) {
			return ((BooleanQueryImpl)query).getBooleanQuery();
		}
		else if (query instanceof LuceneQueryImpl) {
			return ((LuceneQueryImpl)query).getQuery();
		}
		else if (query instanceof StringQueryImpl) {
			QueryParser parser = new QueryParser(
				LuceneHelperUtil.getVersion(), StringPool.BLANK,
				LuceneHelperUtil.getAnalyzer());

			return parser.parse(query.toString());
		}
		else if (query instanceof TermQueryImpl) {
			return ((TermQueryImpl)query).getTermQuery();
		}
		else {
			return null;
		}
	}

}