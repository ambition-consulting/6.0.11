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

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;

/**
 * @author Bruno Farache
 */
public interface IndexAccessor {

	public void addDocument(Document document) throws IOException;

	public void close();

	public void delete() ;

	public void deleteDocuments(Term term) throws IOException;

	public long getCompanyId();

	public Directory getLuceneDir();

	public void updateDocument(Term term, Document document) throws IOException;

}