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

package com.liferay.portlet.enterpriseadmin.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.enterpriseadmin.util.EnterpriseAdminUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Brian Wing Shun Chan
 */
public class GroupSearch extends SearchContainer<Group> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("name");
		headerNames.add("type");

		orderableHeaders.put("name", "name");
		orderableHeaders.put("type", "type");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-communities-were-found";

	public GroupSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new GroupDisplayTerms(portletRequest),
			new GroupSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		GroupDisplayTerms displayTerms = (GroupDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			GroupDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(
			GroupDisplayTerms.NAME, displayTerms.getName());

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeys.ENTERPRISE_ADMIN, "groups-order-by-col",
					orderByCol);
				preferences.setValue(
					PortletKeys.ENTERPRISE_ADMIN, "groups-order-by-type",
					orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeys.ENTERPRISE_ADMIN, "groups-order-by-col",
					"name");
				orderByType = preferences.getValue(
					PortletKeys.ENTERPRISE_ADMIN, "groups-order-by-type",
					"asc");
			}

			OrderByComparator orderByComparator =
				EnterpriseAdminUtil.getGroupOrderByComparator(
					orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(GroupSearch.class);

}