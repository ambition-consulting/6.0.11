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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link OrgLaborService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OrgLaborService
 * @generated
 */
public class OrgLaborServiceWrapper implements OrgLaborService {
	public OrgLaborServiceWrapper(OrgLaborService orgLaborService) {
		_orgLaborService = orgLaborService;
	}

	public com.liferay.portal.model.OrgLabor addOrgLabor(long organizationId,
		int typeId, int sunOpen, int sunClose, int monOpen, int monClose,
		int tueOpen, int tueClose, int wedOpen, int wedClose, int thuOpen,
		int thuClose, int friOpen, int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborService.addOrgLabor(organizationId, typeId, sunOpen,
			sunClose, monOpen, monClose, tueOpen, tueClose, wedOpen, wedClose,
			thuOpen, thuClose, friOpen, friClose, satOpen, satClose);
	}

	public void deleteOrgLabor(long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_orgLaborService.deleteOrgLabor(orgLaborId);
	}

	public com.liferay.portal.model.OrgLabor getOrgLabor(long orgLaborId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborService.getOrgLabor(orgLaborId);
	}

	public java.util.List<com.liferay.portal.model.OrgLabor> getOrgLabors(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborService.getOrgLabors(organizationId);
	}

	public com.liferay.portal.model.OrgLabor updateOrgLabor(long orgLaborId,
		int typeId, int sunOpen, int sunClose, int monOpen, int monClose,
		int tueOpen, int tueClose, int wedOpen, int wedClose, int thuOpen,
		int thuClose, int friOpen, int friClose, int satOpen, int satClose)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLaborService.updateOrgLabor(orgLaborId, typeId, sunOpen,
			sunClose, monOpen, monClose, tueOpen, tueClose, wedOpen, wedClose,
			thuOpen, thuClose, friOpen, friClose, satOpen, satClose);
	}

	public OrgLaborService getWrappedOrgLaborService() {
		return _orgLaborService;
	}

	public void setWrappedOrgLaborService(OrgLaborService orgLaborService) {
		_orgLaborService = orgLaborService;
	}

	private OrgLaborService _orgLaborService;
}