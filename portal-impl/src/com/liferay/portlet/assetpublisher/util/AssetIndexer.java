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

package com.liferay.portlet.assetpublisher.util;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetEntry;

import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class AssetIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {AssetEntry.class.getName()};

	public static final String PORTLET_ID = PortletKeys.ASSET_PUBLISHER;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public Summary getSummary(
		Document document, String snippet, PortletURL portletURL) {

		return null;
	}

	protected void doDelete(Object obj) {
	}

	protected Document doGetDocument(Object obj) {
		return null;
	}

	protected void doReindex(Object obj) {
	}

	protected void doReindex(String className, long classPK) {
	}

	protected void doReindex(String[] ids) {
	}

	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		String description = (String)searchContext.getAttribute(
			Field.DESCRIPTION);

		if (Validator.isNotNull(description)) {
			if (searchContext.isAndSearch()) {
				searchQuery.addRequiredTerm(
					Field.DESCRIPTION, description, true);
			}
			else {
				searchQuery.addTerm(Field.DESCRIPTION, description, true);
			}
		}

		String title = (String)searchContext.getAttribute(Field.TITLE);

		if (Validator.isNotNull(title)) {
			if (searchContext.isAndSearch()) {
				searchQuery.addRequiredTerm(Field.TITLE, title, true);
			}
			else {
				searchQuery.addTerm(Field.TITLE, title, true);
			}
		}

		String userName = (String)searchContext.getAttribute(Field.USER_NAME);

		if (Validator.isNotNull(userName)) {
			if (searchContext.isAndSearch()) {
				searchQuery.addRequiredTerm(Field.USER_NAME, userName, true);
			}
			else {
				searchQuery.addTerm(Field.USER_NAME, userName, true);
			}
		}
	}

}