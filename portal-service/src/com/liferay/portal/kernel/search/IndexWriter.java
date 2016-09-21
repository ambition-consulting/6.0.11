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

import java.util.Collection;

/**
 * @author Bruno Farache
 */
public interface IndexWriter {

	public void addDocument(long companyId, Document document)
		throws SearchException;

	public void addDocuments(long companyId, Collection<Document> documents)
		throws SearchException;

	public void deleteDocument(long companyId, String uid)
		throws SearchException;

	public void deleteDocuments(long companyId, Collection<String> uids)
		throws SearchException;

	public void deletePortletDocuments(long companyId, String portletId)
		throws SearchException;

	public void updateDocument(long companyId, Document document)
		throws SearchException;

	public void updateDocuments(long companyId, Collection<Document> documents)
		throws SearchException;

}