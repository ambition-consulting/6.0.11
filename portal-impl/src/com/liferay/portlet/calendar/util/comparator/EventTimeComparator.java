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

package com.liferay.portlet.calendar.util.comparator;

import com.liferay.portal.kernel.util.Time;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.util.CalUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Samuel Kong
 */
public class EventTimeComparator implements Comparator<CalEvent> {

	public EventTimeComparator(TimeZone timeZone, Locale locale) {
		_timeZone = timeZone;
		_locale = locale;
	}

	public int compare(CalEvent event1, CalEvent event2) {
		boolean allDay1 = CalUtil.isAllDay(event1, _timeZone, _locale);
		boolean allDay2 = CalUtil.isAllDay(event2, _timeZone, _locale);

		if (allDay1 && allDay2) {
			return compareTitle(event1, event2);
		}
		else if (allDay1) {
			return -1;
		}
		else if (allDay2) {
			return 1;
		}

		Date startDate1 = getStartDate(event1, _timeZone);
		Date startDate2 = getStartDate(event2, _timeZone);

		int value = startDate1.compareTo(startDate2);

		if (value != 0) {
			return value;
		}

		Date endDate1 = getEndDate(event1, _timeZone);
		Date endDate2 = getEndDate(event2, _timeZone);

		value = endDate1.compareTo(endDate2);

		if (value != 0) {
			return value;
		}

		return compareTitle(event1, event2);
	}

	protected int compareTitle(CalEvent event1, CalEvent event2) {
		return event1.getTitle().toLowerCase().compareTo(
			event2.getTitle().toLowerCase());
	}

	protected Date getEndDate(CalEvent event, TimeZone timeZone) {
		if (event.isTimeZoneSensitive()) {
			return Time.getDate(CalUtil.getEndTime(event), timeZone);
		}
		else {
			return CalUtil.getEndTime(event);
		}
	}

	protected Date getStartDate(CalEvent event, TimeZone timeZone) {
		if (event.isTimeZoneSensitive()) {
			return Time.getDate(event.getStartDate(), timeZone);
		}
		else {
			return event.getStartDate();
		}
	}

	private TimeZone _timeZone;
	private Locale _locale;

}