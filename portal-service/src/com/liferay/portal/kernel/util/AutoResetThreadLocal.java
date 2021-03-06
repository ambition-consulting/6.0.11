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

/**
 * @author Shuyang Zhou
 */
public class AutoResetThreadLocal<T> extends InitialThreadLocal<T> {

	public AutoResetThreadLocal(String name) {
		super(name, null);
	}

	public AutoResetThreadLocal(String name, T initialValue) {
		super(name, initialValue);
	}

	public void set(T value) {
		ThreadLocalRegistry.registerThreadLocal(this);

		super.set(value);
	}

	protected T initialValue() {
		ThreadLocalRegistry.registerThreadLocal(this);

		return super.initialValue();
	}

}