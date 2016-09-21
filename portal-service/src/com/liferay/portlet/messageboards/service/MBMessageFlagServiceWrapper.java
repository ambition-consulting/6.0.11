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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBMessageFlagService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMessageFlagService
 * @generated
 */
public class MBMessageFlagServiceWrapper implements MBMessageFlagService {
	public MBMessageFlagServiceWrapper(
		MBMessageFlagService mbMessageFlagService) {
		_mbMessageFlagService = mbMessageFlagService;
	}

	public void addAnswerFlag(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageFlagService.addAnswerFlag(messageId);
	}

	public void deleteAnswerFlag(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageFlagService.deleteAnswerFlag(messageId);
	}

	public MBMessageFlagService getWrappedMBMessageFlagService() {
		return _mbMessageFlagService;
	}

	public void setWrappedMBMessageFlagService(
		MBMessageFlagService mbMessageFlagService) {
		_mbMessageFlagService = mbMessageFlagService;
	}

	private MBMessageFlagService _mbMessageFlagService;
}