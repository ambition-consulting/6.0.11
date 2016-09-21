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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriter;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.util.Collection;

import org.apache.lucene.index.Term;

/**
 * @author Bruno Farache
 * @author Brian Wing Shun Chan
 * @author Allen Chiang
 * @author Alex Wallace
 */
public class LuceneIndexWriterImpl implements IndexWriter {

	public void addDocument(long companyId, Document document)
		throws SearchException {

		try {
			LuceneHelperUtil.addDocument(
				companyId, _getLuceneDocument(document));

			if (_log.isDebugEnabled()) {
				_log.debug("Added document " + document.get(Field.UID));
			}
		}
		catch (IOException ioe) {
			throw new SearchException(ioe);
		}
	}

	public void addDocuments(long companyId, Collection<Document> documents)
		throws SearchException {

		for (Document document : documents) {
			addDocument(companyId, document);
		}
	}

	public void deleteDocument(long companyId, String uid)
		throws SearchException {

		try {
			LuceneHelperUtil.deleteDocuments(
				companyId, new Term(Field.UID, uid));

			if (_log.isDebugEnabled()) {
				_log.debug("Deleted document " + uid);
			}
		}
		catch (IOException ioe) {
			throw new SearchException(ioe);
		}
	}

	public void deleteDocuments(long companyId, Collection<String> uids)
		throws SearchException {

		for (String uid : uids) {
			deleteDocument(companyId, uid);
		}
	}

	public void deletePortletDocuments(long companyId, String portletId)
		throws SearchException {

		try {
			LuceneHelperUtil.deleteDocuments(
				companyId, new Term(Field.PORTLET_ID, portletId));
		}
		catch (IOException ioe) {
			throw new SearchException(ioe);
		}
	}

	public void updateDocument(long companyId, Document document)
		throws SearchException {

		try {
			LuceneHelperUtil.updateDocument(
				companyId, new Term(Field.UID, document.getUID()),
				_getLuceneDocument(document));

			if (_log.isDebugEnabled()) {
				_log.debug("Updated document " + document.get(Field.UID));
			}
		}
		catch (IOException ioe) {
			throw new SearchException(ioe);
		}
	}

	public void updateDocuments(long companyId, Collection<Document> documents)
		throws SearchException {

		for (Document document : documents) {
			updateDocument(companyId, document);
		}
	}

	private org.apache.lucene.document.Document _getLuceneDocument(
		Document document) {

		org.apache.lucene.document.Document luceneDocument =
			new org.apache.lucene.document.Document();

		Collection<Field> fields = document.getFields().values();

		for (Field field : fields) {
			String name = field.getName();
			boolean numeric = field.isNumeric();
			boolean tokenized = field.isTokenized();
			float boost = field.getBoost();

			for (String value : field.getValues()) {
				if (Validator.isNull(value)) {
					continue;
				}

				org.apache.lucene.document.Fieldable luceneFieldable = null;

				if (numeric) {
					luceneFieldable = LuceneFields.getNumber(name, value);
				}
				else {
					if (tokenized) {
						luceneFieldable = LuceneFields.getText(name, value);
					}
					else {
						luceneFieldable = LuceneFields.getKeyword(name, value);
					}
				}

				luceneFieldable.setBoost(boost);

				luceneDocument.add(luceneFieldable);
			}
		}

		return luceneDocument;
	}

	private static Log _log = LogFactoryUtil.getLog(
		LuceneIndexWriterImpl.class);

}