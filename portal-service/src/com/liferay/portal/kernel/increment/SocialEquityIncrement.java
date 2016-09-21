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

import com.liferay.portlet.social.model.SocialEquityValue;

/**
 * @author Zsolt Berentey
 */
public class SocialEquityIncrement implements Increment<SocialEquityValue> {

	public SocialEquityIncrement(SocialEquityValue value) {
		_value = value;
	}

	public void decrease(SocialEquityValue delta) {
		_value.subtract(delta);
	}

	public Increment<SocialEquityValue> decreaseForNew(
		SocialEquityValue delta) {

		return new SocialEquityIncrement(
			new SocialEquityValue(
				_value.getK() - delta.getK(),
				_value.getB() - delta.getB()
			)
		);
	}

	public SocialEquityValue getValue() {
		return _value;
	}

	public void increase(SocialEquityValue delta) {
		_value.add(delta);
	}

	public Increment<SocialEquityValue> increaseForNew(
		SocialEquityValue delta) {

		SocialEquityValue value = new SocialEquityValue(
			_value.getK() + delta.getK(), _value.getB() + delta.getB());

		return new SocialEquityIncrement(value);
	}

	public void setValue(SocialEquityValue value) {
		_value = value;
	}

	private SocialEquityValue _value;

}