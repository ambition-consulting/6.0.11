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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.OrgLabor;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.base.OrganizationServiceBaseImpl;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.service.permission.PasswordPolicyPermissionUtil;
import com.liferay.portal.service.permission.PortalPermissionUtil;
import com.liferay.portlet.enterpriseadmin.util.EnterpriseAdminUtil;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @author Julio Camarero
 */
public class OrganizationServiceImpl extends OrganizationServiceBaseImpl {

	public void addGroupOrganizations(long groupId, long[] organizationIds)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);

		organizationLocalService.addGroupOrganizations(
			groupId, organizationIds);
	}

	public Organization addOrganization(
			long parentOrganizationId, String name, String type,
			boolean recursable, long regionId, long countryId, int statusId,
			String comments, List<Address> addresses,
			List<EmailAddress> emailAddresses, List<OrgLabor> orgLabors,
			List<Phone> phones, List<Website> websites,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Organization organization = addOrganization(
			parentOrganizationId, name, type, recursable, regionId, countryId,
			statusId, comments, serviceContext);

		EnterpriseAdminUtil.updateAddresses(
			Organization.class.getName(), organization.getOrganizationId(),
			addresses);

		EnterpriseAdminUtil.updateEmailAddresses(
			Organization.class.getName(), organization.getOrganizationId(),
			emailAddresses);

		EnterpriseAdminUtil.updateOrgLabors(organization.getOrganizationId(),
			orgLabors);

		EnterpriseAdminUtil.updatePhones(
			Organization.class.getName(), organization.getOrganizationId(),
			phones);

		EnterpriseAdminUtil.updateWebsites(
			Organization.class.getName(), organization.getOrganizationId(),
			websites);

		return organization;
	}

	public Organization addOrganization(
			long parentOrganizationId, String name, String type,
			boolean recursable, long regionId, long countryId, int statusId,
			String comments, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (!OrganizationPermissionUtil.contains(
				getPermissionChecker(), parentOrganizationId,
				ActionKeys.MANAGE_SUBORGANIZATIONS) &&
			!PortalPermissionUtil.contains(
				getPermissionChecker(), ActionKeys.ADD_ORGANIZATION)) {

			throw new PrincipalException(
				"User " + getUserId() + " does not have permissions to add " +
					"an organization with parent " + parentOrganizationId);
		}

		return organizationLocalService.addOrganization(
			getUserId(), parentOrganizationId, name, type, recursable,
			regionId, countryId, statusId, comments, serviceContext);
	}

	public void addPasswordPolicyOrganizations(
			long passwordPolicyId, long[] organizationIds)
		throws PortalException, SystemException {

		PasswordPolicyPermissionUtil.check(
			getPermissionChecker(), passwordPolicyId, ActionKeys.UPDATE);

		organizationLocalService.addPasswordPolicyOrganizations(
			passwordPolicyId, organizationIds);
	}

	public void deleteLogo(long organizationId)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.UPDATE);

		organizationLocalService.deleteLogo(organizationId);
	}

	public void deleteOrganization(long organizationId)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.DELETE);

		organizationLocalService.deleteOrganization(organizationId);
	}

	public List<Organization> getManageableOrganizations(
			String actionId, int max)
		throws PortalException, SystemException {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (permissionChecker.isCompanyAdmin()) {
			return organizationLocalService.search(
				permissionChecker.getCompanyId(),
				OrganizationConstants.ANY_PARENT_ORGANIZATION_ID, null, null,
				null, null, null, 0, max);
		}

		LinkedHashMap<String, Object> params =
			new LinkedHashMap<String, Object>();

		List<Organization> userOrganizations =
			organizationLocalService.getUserOrganizations(
				permissionChecker.getUserId());

		Long[][] leftAndRightOrganizationIds =
			EnterpriseAdminUtil.getLeftAndRightOrganizationIds(
				userOrganizations);

		params.put("organizationsTree", leftAndRightOrganizationIds);

		List<Organization> manageableOrganizations =
			organizationLocalService.search(
				permissionChecker.getCompanyId(),
				OrganizationConstants.ANY_PARENT_ORGANIZATION_ID, null, null,
				null, null, params, 0, max);

		manageableOrganizations = ListUtil.copy(manageableOrganizations);

		Iterator<Organization> itr = manageableOrganizations.iterator();

		while (itr.hasNext()) {
			Organization organization = itr.next();

			if (!OrganizationPermissionUtil.contains(
					permissionChecker, organization, actionId)) {

				itr.remove();
			}
		}

		return manageableOrganizations;
	}

	public Organization getOrganization(long organizationId)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.VIEW);

		return organizationLocalService.getOrganization(organizationId);
	}

	public long getOrganizationId(long companyId, String name)
		throws SystemException {

		return organizationLocalService.getOrganizationId(companyId, name);
	}

	public List<Organization> getOrganizations(
			long companyId, long parentOrganizationId)
		throws SystemException {

		return organizationPersistence.filterFindByC_P(
			companyId, parentOrganizationId);
	}

	public List<Organization> getOrganizations(
			long companyId, long parentOrganizationId, int start, int end)
		throws SystemException {

		return organizationPersistence.filterFindByC_P(
			companyId, parentOrganizationId, start, end);
	}

	public int getOrganizationsCount(
			long companyId, long parentOrganizationId)
		throws SystemException {

		return organizationPersistence.filterCountByC_P(
			companyId, parentOrganizationId);
	}

	public List<Organization> getUserOrganizations(long userId)
		throws PortalException, SystemException {

		return organizationLocalService.getUserOrganizations(userId);
	}

	public List<Organization> getUserOrganizations(
			long userId, boolean inheritUserGroups)
		throws PortalException, SystemException {

		return organizationLocalService.getUserOrganizations(
			userId, inheritUserGroups);
	}

	public void setGroupOrganizations(long groupId, long[] organizationIds)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);

		organizationLocalService.setGroupOrganizations(
			groupId, organizationIds);
	}

	public void unsetGroupOrganizations(long groupId, long[] organizationIds)
		throws PortalException, SystemException {

		GroupPermissionUtil.check(
			getPermissionChecker(), groupId, ActionKeys.ASSIGN_MEMBERS);

		organizationLocalService.unsetGroupOrganizations(
			groupId, organizationIds);
	}

	public void unsetPasswordPolicyOrganizations(
			long passwordPolicyId, long[] organizationIds)
		throws PortalException, SystemException {

		PasswordPolicyPermissionUtil.check(
			getPermissionChecker(), passwordPolicyId, ActionKeys.UPDATE);

		organizationLocalService.unsetPasswordPolicyOrganizations(
			passwordPolicyId, organizationIds);
	}

	public Organization updateOrganization(
			long organizationId, long parentOrganizationId, String name,
			String type, boolean recursable, long regionId, long countryId,
			int statusId, String comments, List<Address> addresses,
			List<EmailAddress> emailAddresses, List<OrgLabor> orgLabors,
			List<Phone> phones, List<Website> websites,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		EnterpriseAdminUtil.updateAddresses(
			Organization.class.getName(), organizationId, addresses);

		EnterpriseAdminUtil.updateEmailAddresses(
			Organization.class.getName(), organizationId, emailAddresses);

		EnterpriseAdminUtil.updateOrgLabors(organizationId, orgLabors);

		EnterpriseAdminUtil.updatePhones(
			Organization.class.getName(), organizationId, phones);

		EnterpriseAdminUtil.updateWebsites(
			Organization.class.getName(), organizationId, websites);

		Organization organization = updateOrganization(
			organizationId, parentOrganizationId, name, type, recursable,
			regionId, countryId, statusId, comments, serviceContext);

		return organization;
	}

	public Organization updateOrganization(
			long organizationId, long parentOrganizationId, String name,
			String type, boolean recursable, long regionId, long countryId,
			int statusId, String comments, ServiceContext serviceContext)
		throws PortalException, SystemException {

		OrganizationPermissionUtil.check(
			getPermissionChecker(), organizationId, ActionKeys.UPDATE);

		User user = getUser();

		return organizationLocalService.updateOrganization(
			user.getCompanyId(), organizationId, parentOrganizationId,
			name, type, recursable, regionId, countryId, statusId, comments,
			serviceContext);
	}

}