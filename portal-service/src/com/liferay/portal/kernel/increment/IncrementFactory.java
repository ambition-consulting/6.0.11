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

package com.liferay.portal.kernel.increment;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.social.model.SocialEquityValue;

import java.lang.reflect.Constructor;

/**
 * @author Shuyang Zhou
 */
public class IncrementFactory {

	@SuppressWarnings("rawtypes")
	public static Increment createIncrement(
			Class<? extends Increment<?>> counterClass, Object value)
		throws SystemException {

		if ((counterClass == NumberIncrement.class) &&
			(value instanceof Number)) {

			return new NumberIncrement((Number)value);
		}
		else if ((counterClass == SocialEquityIncrement.class) &&
				 (value instanceof SocialEquityValue)) {

			return new SocialEquityIncrement((SocialEquityValue)value);
		}

		try {
			Constructor<? extends Increment<?>> constructor =
				counterClass.getConstructor(value.getClass());

			return constructor.newInstance(value);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

}