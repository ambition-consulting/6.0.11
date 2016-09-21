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
 * This class is a wrapper for {@link MBBanService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBBanService
 * @generated
 */
public class MBBanServiceWrapper implements MBBanService {
	public MBBanServiceWrapper(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	public com.liferay.portlet.messageboards.model.MBBan addBan(
		long banUserId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbBanService.addBan(banUserId, serviceContext);
	}

	public void deleteBan(long banUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbBanService.deleteBan(banUserId, serviceContext);
	}

	public MBBanService getWrappedMBBanService() {
		return _mbBanService;
	}

	public void setWrappedMBBanService(MBBanService mbBanService) {
		_mbBanService = mbBanService;
	}

	private MBBanService _mbBanService;
}