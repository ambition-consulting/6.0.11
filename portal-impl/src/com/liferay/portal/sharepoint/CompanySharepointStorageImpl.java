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

package com.liferay.portal.sharepoint;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Bruno Farache
 */
public class CompanySharepointStorageImpl extends BaseSharepointStorageImpl {

	public Tree getFoldersTree(SharepointRequest sharepointRequest)
		throws Exception {

		Tree foldersTree = new Tree();

		LinkedHashMap<String, Object> groupParams =
			new LinkedHashMap<String, Object>();

		groupParams.put("usersGroups", new Long(sharepointRequest.getUserId()));

		List<Group> groups = GroupLocalServiceUtil.search(
			sharepointRequest.getCompanyId(), null, null, groupParams,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		Group userGroup = GroupLocalServiceUtil.getUserGroup(
			sharepointRequest.getCompanyId(), sharepointRequest.getUserId());

		groups.add(userGroup);

		List<Organization> organizations =
			OrganizationLocalServiceUtil.getUserOrganizations(
				sharepointRequest.getUserId(), true);

		for (Organization organization : organizations) {
			groups.add(organization.getGroup());
		}

		for (Group group : groups) {
			String path = getGroupPath(group);

			foldersTree.addChild(getFolderTree(path));
		}

		foldersTree.addChild(getFolderTree(StringPool.BLANK));

		return foldersTree;
	}

	protected String getGroupPath(Group group) throws Exception {
		StringBundler sb = new StringBundler(5);

		String name = group.getName();

		if (group.isUser()) {
			User user = UserServiceUtil.getUserById(group.getClassPK());

			name = user.getFullName();
		}
		else if (group.isOrganization()) {
			Organization organization =
				OrganizationLocalServiceUtil.getOrganization(
					group.getOrganizationId());

			name = organization.getName();
		}

		sb.append(name);
		sb.append(StringPool.SPACE);
		sb.append(StringPool.OPEN_BRACKET);
		sb.append(group.getGroupId());
		sb.append(StringPool.CLOSE_BRACKET);

		return sb.toString();
	}

}