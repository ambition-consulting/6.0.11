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

package com.liferay.portal.kernel.cal;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author Samuel Kong
 */
public class TZSRecurrence extends Recurrence {

	public TZSRecurrence() {
	}

	public TZSRecurrence(Calendar start, Duration duration) {
		super(start, duration);
	}

	public TZSRecurrence(Calendar start, Duration duration, int frequency) {
		super(start, duration, frequency);
	}

	public TimeZone getTimeZone() {
		return _timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		_timeZone = timeZone;
	}

	protected boolean matchesByField(
		int[] array, int field, Calendar candidate, boolean allowNegative,
		TimeZone timeZone) {

		Calendar adjustedCandidate = candidate;

		if (Validator.isNotNull(timeZone)) {
			adjustedCandidate = CalendarFactoryUtil.getCalendar(timeZone);

			adjustedCandidate.setTime(candidate.getTime());
		}

		return matchesByField(array, field, adjustedCandidate, allowNegative);
	}

	protected boolean matchesIndividualByDay(
		Calendar candidate, DayAndPosition pos) {

		Calendar adjustedCandidate = candidate;

		if (Validator.isNotNull(_timeZone)) {
			adjustedCandidate = CalendarFactoryUtil.getCalendar(_timeZone);

			adjustedCandidate.setTime(candidate.getTime());
		}

		return super.matchesIndividualByDay(adjustedCandidate, pos);
	}

	protected boolean matchesByMonthDay(Calendar candidate) {
		return matchesByField(
			byMonthDay, Calendar.DATE, candidate, true, _timeZone);
	}

	protected boolean matchesByYearDay(Calendar candidate) {
		return matchesByField(
			byYearDay, Calendar.DAY_OF_YEAR, candidate, true, _timeZone);
	}

	protected boolean matchesByWeekNo(Calendar candidate) {
		return matchesByField(
			byWeekNo, Calendar.WEEK_OF_YEAR, candidate, true, _timeZone);
	}

	protected boolean matchesByMonth(Calendar candidate) {
		return matchesByField(
			byMonth, Calendar.MONTH, candidate, false, _timeZone);
	}

	private TimeZone _timeZone;

}