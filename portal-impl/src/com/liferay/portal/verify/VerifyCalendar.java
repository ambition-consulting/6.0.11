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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;

import java.util.List;

/**
 * @author Juan Fernández
 */
public class VerifyCalendar extends VerifyProcess {

	protected void doVerify() throws Exception {
		List<CalEvent> events = CalEventLocalServiceUtil.getNoAssetEvents();

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Processing " + events.size() + " events with no asset");
		}

		for (CalEvent event : events) {
			try {
				CalEventLocalServiceUtil.updateAsset(
					event.getUserId(), event, null, null);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to update asset for event " +
							event.getEventId() + ": " + e.getMessage());
				}
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Assets verified for events");
		}

	}

	private static Log _log = LogFactoryUtil.getLog(VerifyCalendar.class);

}