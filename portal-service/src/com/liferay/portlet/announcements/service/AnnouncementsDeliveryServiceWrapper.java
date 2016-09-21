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

package com.liferay.portlet.announcements.service;

/**
 * <p>
 * This class is a wrapper for {@link AnnouncementsDeliveryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AnnouncementsDeliveryService
 * @generated
 */
public class AnnouncementsDeliveryServiceWrapper
	implements AnnouncementsDeliveryService {
	public AnnouncementsDeliveryServiceWrapper(
		AnnouncementsDeliveryService announcementsDeliveryService) {
		_announcementsDeliveryService = announcementsDeliveryService;
	}

	public com.liferay.portlet.announcements.model.AnnouncementsDelivery updateDelivery(
		long userId, java.lang.String type, boolean email, boolean sms,
		boolean website)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementsDeliveryService.updateDelivery(userId, type,
			email, sms, website);
	}

	public AnnouncementsDeliveryService getWrappedAnnouncementsDeliveryService() {
		return _announcementsDeliveryService;
	}

	public void setWrappedAnnouncementsDeliveryService(
		AnnouncementsDeliveryService announcementsDeliveryService) {
		_announcementsDeliveryService = announcementsDeliveryService;
	}

	private AnnouncementsDeliveryService _announcementsDeliveryService;
}