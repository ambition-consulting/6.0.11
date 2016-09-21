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
 * This class is a wrapper for {@link ContactService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ContactService
 * @generated
 */
public class ContactServiceWrapper implements ContactService {
	public ContactServiceWrapper(ContactService contactService) {
		_contactService = contactService;
	}

	public ContactService getWrappedContactService() {
		return _contactService;
	}

	public void setWrappedContactService(ContactService contactService) {
		_contactService = contactService;
	}

	private ContactService _contactService;
}