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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.NumberFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class MathUtil {

	public static int base2Log(long x) {
		return _base2LogValues.get(x);
	}

	public static long base2Pow(int x) {
		if (x == 0) {
			return 1;
		}
		else {
			return 2L << (x - 1);
		}
	}

	public static int factorial(int x) {
		if (x < 0) {
			return 0;
		}

		int factorial = 1;

		while (x > 1) {
			factorial = factorial * x;
			x = x - 1;
		}

		return factorial;
	}

	public static double format(double x, int max, int min) {
		NumberFormat nf = NumberFormat.getInstance();

		nf.setMaximumFractionDigits(max);
		nf.setMinimumFractionDigits(min);

		try {
			Number number = nf.parse(nf.format(x));

			x = number.doubleValue();
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}

		return x;
	}

	public static boolean isEven(int x) {
		if ((x % 2) == 0) {
			return true;
		}

		return false;
	}

	public static boolean isOdd(int x) {
		return !isEven(x);
	}

	public static int[] generatePrimes(int max) {
		if (max < 2) {
			return new int[0];
		}
		else {
			boolean[] crossedOut = new boolean[max + 1];

			for (int i = 2; i < crossedOut.length; i++) {
				crossedOut[i] = false;
			}

			int limit = (int)Math.sqrt(crossedOut.length);

			for (int i = 2; i <= limit; i++) {
				if (!crossedOut[i]) {
					for (int multiple = 2 * i; multiple < crossedOut.length;
							multiple += i) {

						crossedOut[multiple] = true;
					}
				}
			}

			int uncrossedCount = 0;

			for (int i = 2; i < crossedOut.length; i++) {
				if (!crossedOut[i]) {
					uncrossedCount++;
				}
			}

			int[] result = new int[uncrossedCount];

			for (int i = 2, j = 0; i < crossedOut.length; i++) {
				if (!crossedOut[i]) {
					result[j++] = i;
				}
			}

			return result;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MathUtil.class);

	private static Map<Long, Integer> _base2LogValues =
		new HashMap<Long, Integer>();

	static {
		_base2LogValues.put(0L, Integer.MIN_VALUE);

		for (int i = 0; i < 63; i++) {
			_base2LogValues.put(base2Pow(i), i);
		}
	}

}