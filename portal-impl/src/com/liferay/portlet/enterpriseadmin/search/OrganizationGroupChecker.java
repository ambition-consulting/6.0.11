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

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Charles May
 */
public class OrganizationGroupChecker extends RowChecker {

	public OrganizationGroupChecker(
		RenderResponse renderResponse, Group group) {

		super(renderResponse);

		_group = group;
	}

	public boolean isChecked(Object obj) {
		Organization organization = (Organization)obj;

		try {
			return OrganizationLocalServiceUtil.hasGroupOrganization(
				_group.getGroupId(), organization.getOrganizationId());
		}
		catch (Exception e) {
			_log.error(e);

			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		OrganizationGroupChecker.class);

	private Group _group;

}