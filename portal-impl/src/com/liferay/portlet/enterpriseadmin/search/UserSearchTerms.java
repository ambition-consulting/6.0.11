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

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class UserSearchTerms extends UserDisplayTerms {

	public UserSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		if (Validator.isNotNull(ParamUtil.getString(portletRequest, ACTIVE))) {
			active = ParamUtil.getBoolean(portletRequest, ACTIVE, true);
		}

		emailAddress = DAOParamUtil.getLike(portletRequest, EMAIL_ADDRESS);
		firstName = DAOParamUtil.getLike(portletRequest, FIRST_NAME);
		lastName = DAOParamUtil.getLike(portletRequest, LAST_NAME);
		middleName = DAOParamUtil.getLike(portletRequest, MIDDLE_NAME);
		organizationId = ParamUtil.getLong(portletRequest, ORGANIZATION_ID);
		roleId = ParamUtil.getLong(portletRequest, ROLE_ID);
		screenName = DAOParamUtil.getLike(portletRequest, SCREEN_NAME);
		userGroupId = ParamUtil.getLong(portletRequest, USER_GROUP_ID);
	}

}