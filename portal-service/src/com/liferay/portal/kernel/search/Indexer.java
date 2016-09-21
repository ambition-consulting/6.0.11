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

import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public interface Indexer {

	public static final int DEFAULT_INTERVAL = 1000;

	public void delete(Object obj) throws SearchException;

	public String[] getClassNames();

	public Document getDocument(Object obj) throws SearchException;

	public Summary getSummary(
		Document document, String snippet, PortletURL portletURL);

	public void reindex(Object obj) throws SearchException;

	public void reindex(String className, long classPK) throws SearchException;

	public void reindex(String[] ids) throws SearchException;

	public Hits search(SearchContext searchContext) throws SearchException;

}