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

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class UserDisplayTerms extends DisplayTerms {

	public static final String ACTIVE = "active";

	public static final String EMAIL_ADDRESS = "emailAddress";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String MIDDLE_NAME = "middleName";

	public static final String ORGANIZATION_ID = "organizationId";

	public static final String ROLE_ID = "roleId";

	public static final String SCREEN_NAME = "screenName";

	public static final String USER_GROUP_ID = "userGroupId";

	public UserDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		String activeString = ParamUtil.getString(portletRequest, ACTIVE);

		if (Validator.isNotNull(activeString)) {
			active = GetterUtil.getBoolean(activeString);
		}

		emailAddress = ParamUtil.getString(portletRequest, EMAIL_ADDRESS);
		firstName = ParamUtil.getString(portletRequest, FIRST_NAME);
		lastName = ParamUtil.getString(portletRequest, LAST_NAME);
		middleName = ParamUtil.getString(portletRequest, MIDDLE_NAME);
		organizationId = ParamUtil.getLong(portletRequest, ORGANIZATION_ID);
		roleId = ParamUtil.getLong(portletRequest, ROLE_ID);
		screenName = ParamUtil.getString(portletRequest, SCREEN_NAME);
		userGroupId = ParamUtil.getLong(portletRequest, USER_GROUP_ID);
	}

	public Boolean getActive() {
		return active;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public long getRoleId() {
		return roleId;
	}

	public String getScreenName() {
		return screenName;
	}

	public long getUserGroupId() {
		return userGroupId;
	}

	public boolean hasActive() {
		if (active == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean isActive() {
		if (active == null) {
			return true;
		}

		return active.booleanValue();
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	protected Boolean active;
	protected String emailAddress;
	protected String firstName;
	protected String lastName;
	protected String middleName;
	protected long organizationId;
	protected long roleId;
	protected String screenName;
	protected long userGroupId;

}