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

package com.liferay.portlet.enterpriseadmin.action;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.RolePermissionsException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.security.permission.comparator.ActionComparator;
import com.liferay.portal.service.PermissionServiceUtil;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class EditRolePermissionsAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals("actions")) {
				updateActions(actionRequest, actionResponse);
			}
			else if (cmd.equals("delete_permission")) {
				deletePermission(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchRoleException ||
				e instanceof PrincipalException ||
				e instanceof RolePermissionsException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.enterprise_admin.error");
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getRole(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchRoleException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.enterprise_admin.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.enterprise_admin.edit_role_permissions"));
	}

	protected void deletePermission(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long roleId = ParamUtil.getLong(actionRequest, "roleId");
		long permissionId = ParamUtil.getLong(actionRequest, "permissionId");
		String name = ParamUtil.getString(actionRequest, "name");
		int scope = ParamUtil.getInteger(actionRequest, "scope");
		String primKey = ParamUtil.getString(actionRequest, "primKey");
		String actionId = ParamUtil.getString(actionRequest, "actionId");

		Role role = RoleLocalServiceUtil.getRole(roleId);

		if (role.getName().equals(RoleConstants.ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.OWNER) ||
			role.getName().equals(RoleConstants.COMMUNITY_ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.COMMUNITY_OWNER) ||
			role.getName().equals(RoleConstants.ORGANIZATION_ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.ORGANIZATION_OWNER)) {

			throw new RolePermissionsException(role.getName());
		}

		if (PropsValues.PERMISSIONS_USER_CHECK_ALGORITHM == 6) {
			ResourcePermissionServiceUtil.removeResourcePermission(
				themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
				name, scope, primKey, roleId, actionId);
		}
		else {
			PermissionServiceUtil.unsetRolePermission(
				roleId, themeDisplay.getScopeGroupId(), permissionId);
		}

		// Send redirect

		SessionMessages.add(actionRequest, "permissionDeleted");

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		actionResponse.sendRedirect(redirect);
	}

	protected void updateAction_1to5(
			Role role, long groupId, String selResource, String actionId,
			boolean selected, int scope, String[] groupIds)
		throws Exception {

		long roleId = role.getRoleId();

		if (selected) {
			if (scope == ResourceConstants.SCOPE_COMPANY) {
				PermissionServiceUtil.setRolePermission(
					roleId, groupId, selResource, scope,
					String.valueOf(role.getCompanyId()), actionId);
			}
			else if (scope == ResourceConstants.SCOPE_GROUP_TEMPLATE) {
				PermissionServiceUtil.setRolePermission(
					roleId, groupId, selResource,
					ResourceConstants.SCOPE_GROUP_TEMPLATE,
					String.valueOf(GroupConstants.DEFAULT_PARENT_GROUP_ID),
					actionId);
			}
			else {
				PermissionServiceUtil.unsetRolePermissions(
					roleId, groupId, selResource, ResourceConstants.SCOPE_GROUP,
					actionId);

				for (String curGroupId : groupIds) {
					PermissionServiceUtil.setRolePermission(
						roleId, groupId, selResource,
						ResourceConstants.SCOPE_GROUP, curGroupId, actionId);
				}
			}
		}
		else {

			// Remove company, group template, and group permissions

			PermissionServiceUtil.unsetRolePermissions(
				roleId, groupId, selResource, ResourceConstants.SCOPE_COMPANY,
				actionId);

			PermissionServiceUtil.unsetRolePermissions(
				roleId, groupId, selResource,
				ResourceConstants.SCOPE_GROUP_TEMPLATE, actionId);

			PermissionServiceUtil.unsetRolePermissions(
				roleId, groupId, selResource, ResourceConstants.SCOPE_GROUP,
				actionId);
		}
	}

	protected void updateAction_6(
			Role role, long groupId, String selResource, String actionId,
			boolean selected, int scope, String[] groupIds)
		throws Exception {

		long companyId = role.getCompanyId();
		long roleId = role.getRoleId();

		if (selected) {
			if (scope == ResourceConstants.SCOPE_COMPANY) {
				ResourcePermissionServiceUtil.addResourcePermission(
					groupId, companyId, selResource, scope,
					String.valueOf(role.getCompanyId()), roleId, actionId);
			}
			else if (scope == ResourceConstants.SCOPE_GROUP_TEMPLATE) {
				ResourcePermissionServiceUtil.addResourcePermission(
					groupId, companyId, selResource,
					ResourceConstants.SCOPE_GROUP_TEMPLATE,
					String.valueOf(GroupConstants.DEFAULT_PARENT_GROUP_ID),
					roleId, actionId);
			}
			else if (scope == ResourceConstants.SCOPE_GROUP) {
				ResourcePermissionServiceUtil.removeResourcePermissions(
					groupId, companyId, selResource,
					ResourceConstants.SCOPE_GROUP, roleId, actionId);

				for (String curGroupId : groupIds) {
					ResourcePermissionServiceUtil.addResourcePermission(
						groupId, companyId, selResource,
						ResourceConstants.SCOPE_GROUP, curGroupId, roleId,
						actionId);
				}
			}
		}
		else {

			// Remove company, group template, and group permissions

			ResourcePermissionServiceUtil.removeResourcePermissions(
				groupId, companyId, selResource,
				ResourceConstants.SCOPE_COMPANY, roleId, actionId);

			ResourcePermissionServiceUtil.removeResourcePermissions(
				groupId, companyId, selResource,
				ResourceConstants.SCOPE_GROUP_TEMPLATE, roleId, actionId);

			ResourcePermissionServiceUtil.removeResourcePermissions(
				groupId, companyId, selResource, ResourceConstants.SCOPE_GROUP,
				roleId, actionId);
		}
	}

	protected void updateActions(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long roleId = ParamUtil.getLong(actionRequest, "roleId");

		Role role = RoleLocalServiceUtil.getRole(roleId);

		if (role.getName().equals(RoleConstants.ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.OWNER) ||
			role.getName().equals(RoleConstants.COMMUNITY_ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.COMMUNITY_OWNER) ||
			role.getName().equals(RoleConstants.ORGANIZATION_ADMINISTRATOR) ||
			role.getName().equals(RoleConstants.ORGANIZATION_OWNER)) {

			throw new RolePermissionsException(role.getName());
		}

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");
		String[] modelResources = StringUtil.split(
			ParamUtil.getString(actionRequest, "modelResources"));
		boolean showModelResources = ParamUtil.getBoolean(
			actionRequest, "showModelResources");

		Map<String, List<String>> resourceActionsMap =
			new HashMap<String, List<String>>();

		if (showModelResources) {
			for (String modelResource : modelResources) {
				resourceActionsMap.put(
					modelResource,
					ResourceActionsUtil.getResourceActions(
						null, modelResource));
			}
		}
		else if (Validator.isNotNull(portletResource)) {
			resourceActionsMap.put(
				portletResource,
				ResourceActionsUtil.getResourceActions(portletResource, null));
		}

		String[] selectedTargets = StringUtil.split(
			ParamUtil.getString(actionRequest, "selectedTargets"));

		for (Map.Entry<String, List<String>> entry :
				resourceActionsMap.entrySet()) {

			String selResource = entry.getKey();
			List<String> actions = entry.getValue();

			actions = ListUtil.sort(
				actions, new ActionComparator(themeDisplay.getLocale()));

			for (String actionId : actions) {
				String target = selResource + actionId;

				boolean selected = ArrayUtil.contains(selectedTargets, target);

				String[] groupIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "groupIds" + target));

				groupIds = ArrayUtil.distinct(groupIds);

				int scope = ResourceConstants.SCOPE_COMPANY;

				if ((role.getType() == RoleConstants.TYPE_COMMUNITY) ||
					(role.getType() == RoleConstants.TYPE_ORGANIZATION)) {

					scope = ResourceConstants.SCOPE_GROUP_TEMPLATE;
				}
				else {
					if (groupIds.length > 0) {
						scope = ResourceConstants.SCOPE_GROUP;
					}
				}

				if (PropsValues.PERMISSIONS_USER_CHECK_ALGORITHM == 6) {
					updateAction_6(
						role, themeDisplay.getScopeGroupId(), selResource,
						actionId, selected, scope, groupIds);
				}
				else {
					updateAction_1to5(
						role, themeDisplay.getScopeGroupId(), selResource,
						actionId, selected, scope, groupIds);
				}
			}
		}

		// Send redirect

		SessionMessages.add(actionRequest, "permissionsUpdated");

		String redirect =
			ParamUtil.getString(actionRequest, "redirect") + "&" +
				Constants.CMD + "=" + Constants.VIEW;

		actionResponse.sendRedirect(redirect);
	}

}