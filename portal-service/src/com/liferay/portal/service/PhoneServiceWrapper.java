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
 * This class is a wrapper for {@link PhoneService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PhoneService
 * @generated
 */
public class PhoneServiceWrapper implements PhoneService {
	public PhoneServiceWrapper(PhoneService phoneService) {
		_phoneService = phoneService;
	}

	public com.liferay.portal.model.Phone addPhone(java.lang.String className,
		long classPK, java.lang.String number, java.lang.String extension,
		int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _phoneService.addPhone(className, classPK, number, extension,
			typeId, primary);
	}

	public void deletePhone(long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_phoneService.deletePhone(phoneId);
	}

	public com.liferay.portal.model.Phone getPhone(long phoneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _phoneService.getPhone(phoneId);
	}

	public java.util.List<com.liferay.portal.model.Phone> getPhones(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _phoneService.getPhones(className, classPK);
	}

	public com.liferay.portal.model.Phone updatePhone(long phoneId,
		java.lang.String number, java.lang.String extension, int typeId,
		boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _phoneService.updatePhone(phoneId, number, extension, typeId,
			primary);
	}

	public PhoneService getWrappedPhoneService() {
		return _phoneService;
	}

	public void setWrappedPhoneService(PhoneService phoneService) {
		_phoneService = phoneService;
	}

	private PhoneService _phoneService;
}