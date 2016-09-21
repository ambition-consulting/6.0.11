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

package com.liferay.portlet.flags.service;

/**
 * <p>
 * This class is a wrapper for {@link FlagsEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       FlagsEntryService
 * @generated
 */
public class FlagsEntryServiceWrapper implements FlagsEntryService {
	public FlagsEntryServiceWrapper(FlagsEntryService flagsEntryService) {
		_flagsEntryService = flagsEntryService;
	}

	public void addEntry(java.lang.String className, long classPK,
		java.lang.String reporterEmailAddress, long reportedUserId,
		java.lang.String contentTitle, java.lang.String contentURL,
		java.lang.String reason,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flagsEntryService.addEntry(className, classPK, reporterEmailAddress,
			reportedUserId, contentTitle, contentURL, reason, serviceContext);
	}

	public FlagsEntryService getWrappedFlagsEntryService() {
		return _flagsEntryService;
	}

	public void setWrappedFlagsEntryService(FlagsEntryService flagsEntryService) {
		_flagsEntryService = flagsEntryService;
	}

	private FlagsEntryService _flagsEntryService;
}