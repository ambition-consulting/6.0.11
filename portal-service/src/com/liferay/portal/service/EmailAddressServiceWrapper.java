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
 * This class is a wrapper for {@link EmailAddressService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EmailAddressService
 * @generated
 */
public class EmailAddressServiceWrapper implements EmailAddressService {
	public EmailAddressServiceWrapper(EmailAddressService emailAddressService) {
		_emailAddressService = emailAddressService;
	}

	public com.liferay.portal.model.EmailAddress addEmailAddress(
		java.lang.String className, long classPK, java.lang.String address,
		int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAddressService.addEmailAddress(className, classPK,
			address, typeId, primary);
	}

	public void deleteEmailAddress(long emailAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_emailAddressService.deleteEmailAddress(emailAddressId);
	}

	public com.liferay.portal.model.EmailAddress getEmailAddress(
		long emailAddressId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAddressService.getEmailAddress(emailAddressId);
	}

	public java.util.List<com.liferay.portal.model.EmailAddress> getEmailAddresses(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAddressService.getEmailAddresses(className, classPK);
	}

	public com.liferay.portal.model.EmailAddress updateEmailAddress(
		long emailAddressId, java.lang.String address, int typeId,
		boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailAddressService.updateEmailAddress(emailAddressId, address,
			typeId, primary);
	}

	public EmailAddressService getWrappedEmailAddressService() {
		return _emailAddressService;
	}

	public void setWrappedEmailAddressService(
		EmailAddressService emailAddressService) {
		_emailAddressService = emailAddressService;
	}

	private EmailAddressService _emailAddressService;
}