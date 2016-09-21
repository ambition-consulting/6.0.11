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

package com.liferay.portlet.directory.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeIndexer;

import java.io.Serializable;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 * @author Marcellus Tavares
 */
public class DirectoryOpenSearchImpl extends HitsOpenSearchImpl {

	public static final String SEARCH_PATH = "/c/directory/open_search";

	public static final String TITLE = "Liferay Directory Search: ";

	public String getPortletId() {
		return DirectoryIndexer.PORTLET_ID;
	}

	public String getSearchPath() {
		return SEARCH_PATH;
	}

	public Summary getSummary(
		Indexer indexer, Document document, String snippet,
		PortletURL portletURL) {

		Summary summary = super.getSummary(
			indexer, document, snippet, portletURL);

		portletURL = summary.getPortletURL();

		portletURL.setParameter("struts_action", "/directory/view_user");

		return summary;
	}

	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

	protected void addSearchAttributes(
		long companyId, SearchContext searchContext, String keywords) {

		if (Validator.isNotNull(keywords)) {
			Map<String, Serializable> attributes =
				new HashMap<String, Serializable>();

			attributes.put("emailAddress", keywords);
			attributes.put("firstName", keywords);
			attributes.put("lastName", keywords);
			attributes.put("middleName", keywords);
			attributes.put("params", getUserParams(companyId, keywords));
			attributes.put("screenName", keywords);

			searchContext.setAttributes(attributes);
		}
	}

	protected LinkedHashMap<String, Object> getUserParams(
		long companyId, String keywords) {

		LinkedHashMap<String, Object> userParams =
			new LinkedHashMap<String, Object>();

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			companyId, User.class.getName());

		Enumeration<String> enu = expandoBridge.getAttributeNames();

		while (enu.hasMoreElements()) {
			String attributeName = enu.nextElement();

			UnicodeProperties properties = expandoBridge.getAttributeProperties(
				attributeName);

			String indexable = properties.getProperty(
				ExpandoBridgeIndexer.INDEXABLE);

			if (GetterUtil.getBoolean(indexable)) {
				int type = expandoBridge.getAttributeType(attributeName);

				if (type == ExpandoColumnConstants.STRING) {
					userParams.put(attributeName, keywords);
				}
			}
		}

		return userParams;
	}

}