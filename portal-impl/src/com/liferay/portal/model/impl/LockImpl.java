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

package com.liferay.portal.model.impl;

import com.liferay.portal.model.Lock;

/**
 * @author Brian Wing Shun Chan
 */
public class LockImpl extends LockModelImpl implements Lock {

	public LockImpl() {
	}

	public long getExpirationTime() {
		if (isNeverExpires()) {
			return 0;
		}
		else {
			return getExpirationDate().getTime() - getCreateDate().getTime();
		}
	}

	public boolean isExpired() {
		if (isNeverExpires()) {
			return false;
		}
		else if (System.currentTimeMillis() > getExpirationDate().getTime()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isNeverExpires() {
		if (getExpirationDate() == null) {
			return true;
		}
		else {
			return false;
		}
	}

}