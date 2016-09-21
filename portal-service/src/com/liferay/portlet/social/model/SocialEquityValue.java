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

package com.liferay.portlet.social.model;

import com.liferay.portal.kernel.util.Time;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Zsolt Berentey
 */
public class SocialEquityValue {

	public SocialEquityValue(double k, double b) {
		_k = k;
		_b = b;
	}

	public void add(SocialEquityValue socialEquityValue) {
		_k = _k + socialEquityValue._k;
		_b = _b + socialEquityValue._b;
	}

	public double getB() {
		return _b;
	}

	public double getK() {
		return _k;
	}

	public double getValue() {
		return getValue(getEquityDate());
	}

	public double getValue(int equityDate) {
		return _k * equityDate + _b;
	}

	public void subtract(SocialEquityValue socialEquityValue) {
		_k = _k - socialEquityValue._k;
		_b = _b - socialEquityValue._b;
	}

	protected int getEquityDate() {
		long d = System.currentTimeMillis() - _BASE_TIME;

		return (int)(d / Time.DAY);
	}

	private static final long _BASE_TIME =
		new GregorianCalendar(2010, Calendar.JANUARY, 1).getTimeInMillis();

	private double _b;
	private double _k;

}