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

package com.liferay.portal.search;

import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriter;

import java.util.Collection;

/**
 * @author Bruno Farache
 * @author Tina Tian
 */
public class IndexWriterProxyBean extends BaseProxyBean implements IndexWriter {

	public void addDocument(long companyId, Document document) {
		throw new UnsupportedOperationException();
	}

	public void addDocuments(long companyId, Collection<Document> documents) {
		throw new UnsupportedOperationException();
	}

	public void deleteDocument(long companyId, String uid) {
		throw new UnsupportedOperationException();
	}

	public void deleteDocuments(long companyId, Collection<String> uids) {
		throw new UnsupportedOperationException();
	}

	public void deletePortletDocuments(long companyId, String portletId) {
		throw new UnsupportedOperationException();
	}

	public void updateDocument(long companyId, Document document) {
		throw new UnsupportedOperationException();
	}

	public void updateDocuments(
		long companyId, Collection<Document> documents) {

		throw new UnsupportedOperationException();
	}

}