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

package com.liferay.portal.servlet.filters.threaddump;

import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PropsValues;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class ThreadDumpFilter extends BasePortalFilter {

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		ScheduledFuture<?> scheduledFuture =
			_scheduledExecutorService.schedule(
				_threadDumper, PropsValues.THREAD_DUMP_SPEED_THRESHOLD,
				TimeUnit.SECONDS);

		try {
			processFilter(
				ThreadDumpFilter.class, request, response, filterChain);
		}
		finally {
			scheduledFuture.cancel(true);
		}
	}

	private static int _MAX_THREAD_DUMPERS = 5;

	private static ScheduledExecutorService _scheduledExecutorService =
		Executors.newScheduledThreadPool(_MAX_THREAD_DUMPERS);
	private static ThreadDumper _threadDumper = new ThreadDumper();

}