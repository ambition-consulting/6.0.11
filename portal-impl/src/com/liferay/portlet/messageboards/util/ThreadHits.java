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

package com.liferay.portlet.messageboards.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class ThreadHits {

	public void recordHits(Hits hits, int start, int end) throws Exception {
		Set<Long> threadIds = new HashSet<Long>();

		List<Document> docs = new ArrayList<Document>();
		List<Float> scores = new ArrayList<Float>();

		for (int i = 0; i < hits.getDocs().length; i++) {
			Document doc = hits.doc(i);

			Long threadId = GetterUtil.getLong(doc.get("threadId"));

			if (!threadIds.contains(threadId)) {
				threadIds.add(threadId);

				docs.add(hits.doc(i));
				scores.add(hits.score(i));
			}
		}

		int length = docs.size();

		hits.setLength(length);

		if (end > length) {
			end = length;
		}

		docs = docs.subList(start, end);

		hits.setDocs(docs.toArray(new Document[docs.size()]));
		hits.setScores(scores.toArray(new Float[docs.size()]));

		hits.setSearchTime(
			(float)(System.currentTimeMillis() - hits.getStart()) /
				Time.SECOND);
	}

}