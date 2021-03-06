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

package com.liferay.portal.kernel.log;

import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.util.StackTraceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;

/**
 * @author Brian Wing Shun Chan
 */
public class LogUtil {

	public static final int STACK_TRACE_LENGTH = 20;

	public static final boolean REMOVE_UNKNOWN_SOURCE = true;

	public static void debug(Log log, Properties props) {
		if (log.isDebugEnabled()) {
			UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter(
				props.size() + 1);

			props.list(new UnsyncPrintWriter(unsyncStringWriter));

			log.debug(unsyncStringWriter.toString());
		}
	}

	public static void log(Log log, Throwable t) {
		if (t instanceof JspException) {
			log(log, (JspException)t);
		}
		else if (t instanceof ServletException) {
			log(log, (ServletException)t);
		}
		else {
			Throwable cause = t.getCause();

			if (cause != null) {
				log(log, cause);
			}
			else {
				_log(log, t);
			}
		}
	}

	public static void log(Log log, JspException jspe) {
		Throwable cause = jspe.getCause();

		if (cause == null) {
			cause = jspe;
		}

		if ((cause != jspe) && (cause instanceof JspException)) {
			log(log, (JspException)cause);
		}
		else if (cause instanceof ServletException) {
			log(log, (ServletException)cause);
		}
		else {
			_log(log, cause);
		}
	}

	public static void log(Log log, ServletException se) {
		Throwable cause = se.getRootCause();

		if (cause == null) {
			cause = se;
		}

		if (cause instanceof JspException) {
			log(log, (JspException)cause);
		}
		else if ((cause != se) && (cause instanceof ServletException)) {
			log(log, (ServletException)cause);
		}
		else {
			_log(log, cause);
		}
	}

	private static void _log(Log log, Throwable cause) {
		StackTraceElement[] steArray = cause.getStackTrace();

		// Make the stack trace more readable by limiting the number of
		// elements.

		if (steArray.length > STACK_TRACE_LENGTH) {
			int count = 0;

			List<StackTraceElement> steList =
				new ArrayList<StackTraceElement>();

			for (int i = 0; i < steArray.length; i++) {
				StackTraceElement ste = steArray[i];

				// Make the stack trace more readable by removing elements that
				// refer to classes with no packages, or starts with a $, or are
				// Spring classes, or are standard reflection classes.

				String className = ste.getClassName();

				boolean addElement = true;

				if (REMOVE_UNKNOWN_SOURCE && (ste.getLineNumber() < 0)) {
					addElement = false;
				}

				if (className.startsWith("$") ||
					className.startsWith("java.lang.reflect.") ||
					className.startsWith("org.springframework.") ||
					className.startsWith("sun.reflect.")) {

					addElement = false;
				}

				if (addElement) {
					steList.add(ste);

					count++;
				}

				if (count >= STACK_TRACE_LENGTH) {
					break;
				}
			}

			steArray = steList.toArray(new StackTraceElement[steList.size()]);

			cause.setStackTrace(steArray);
		}

		log.error(StackTraceUtil.getStackTrace(cause));
	}

}