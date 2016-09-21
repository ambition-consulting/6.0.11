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

package com.liferay.portal.util;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.test.TestCase;
import com.liferay.portal.util.InitUtil;
import com.liferay.util.PwdGenerator;

import java.util.Date;
import java.util.Random;

/**
 * @author Brian Wing Shun Chan
 * @author Ganesh Ram
 */
public class BaseTestCase extends TestCase {

	public BaseTestCase() {
		if (System.getProperty("external-properties") == null) {
			System.setProperty("external-properties", "portal-test.properties");
		}

		InitUtil.initWithSpring();
	}

	protected Date nextDate() throws Exception {
		return new Date();
	}

	protected double nextDouble() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	protected int nextInt() throws Exception {
		return (int)CounterLocalServiceUtil.increment();
	}

	protected long nextLong() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	protected boolean randomBoolean() throws Exception {
		return _random.nextBoolean();
	}

	protected String randomString() throws Exception {
		return PwdGenerator.getPassword();
	}

	private Random _random = new Random();

}