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

package com.liferay.portal.servlet.filters.threadlocal;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InitialThreadLocal;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ThreadLocalRegistry;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ThreadLocalFilter extends BasePortalFilter {

	public static final boolean ENABLED = GetterUtil.getBoolean(
		PropsUtil.get(ThreadLocalFilter.class.getName()));

	public static boolean isInUse() {
		if (_useCountThreadLocal.get() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		_useCountThreadLocal.set(_useCountThreadLocal.get() + 1);

		try {
			processFilter(
				ThreadLocalFilter.class, request, response, filterChain);
		}
		finally {
			_useCountThreadLocal.set(_useCountThreadLocal.get() - 1);

			ThreadLocalRegistry.resetThreadLocals();
		}
	}

	private static ThreadLocal<Long> _useCountThreadLocal =
		new InitialThreadLocal<Long>(
			ThreadLocalFilter.class + "_useCountThreadLocal", 0L);

}