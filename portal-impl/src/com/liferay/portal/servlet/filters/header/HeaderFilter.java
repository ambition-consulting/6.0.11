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

package com.liferay.portal.servlet.filters.header;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;

import java.text.Format;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 * @author Eduardo Lundgren
 */
public class HeaderFilter extends BasePortalFilter {

	public void init(FilterConfig filterConfig) {
		super.init(filterConfig);

		_filterConfig = filterConfig;
		_dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(
			_DATE_FORMAT, Locale.US, TimeZoneUtil.getTimeZone(_TIME_ZONE));
	}

	protected long getLastModified(HttpServletRequest request) {
		long lasModified = -1;

		Map<String, String[]> parameterMap = HttpUtil.getParameterMap(
			request.getQueryString());

		String[] value = parameterMap.get("t");

		if ((value != null) && (value.length > 0)) {
			lasModified = GetterUtil.getLong(value[0]);
		}

		return lasModified;
	}

	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		Enumeration<String> enu = _filterConfig.getInitParameterNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();

			if (name.equals(_URL_REGEX_PATTERN)) {
				continue;
			}

			String value = _filterConfig.getInitParameter(name);

			if (name.equals(_EXPIRES) && Validator.isNumber(value)) {
				int seconds = GetterUtil.getInteger(value);

				Calendar cal = new GregorianCalendar();

				cal.add(Calendar.SECOND, seconds);

				value = _dateFormat.format(cal.getTime());
			}

			// LEP-5895

			boolean addHeader = true;

			if (PropsValues.WEB_SERVER_PROXY_LEGACY_MODE) {
				String contextPath = request.getContextPath();

				if (name.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL) &&
					contextPath.equals(PortalUtil.getPathContext())) {

					HttpSession session = request.getSession(false);

					if ((session == null) || session.isNew()) {
						addHeader = false;
					}
				}
			}

			if (addHeader) {
				response.addHeader(name, value);
			}
		}

		long lastModified = getLastModified(request);
		long ifModifiedSince = request.getDateHeader(
			HttpHeaders.IF_MODIFIED_SINCE);

		if (lastModified > 0) {
			response.setDateHeader(HttpHeaders.LAST_MODIFIED, lastModified);

			if (lastModified <= ifModifiedSince) {
				response.setDateHeader(
					HttpHeaders.LAST_MODIFIED, ifModifiedSince);
				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);

				return;
			}
		}

		processFilter(HeaderFilter.class, request, response, filterChain);
	}

	private static final String _DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";

	private static final String _EXPIRES = "Expires";

	private static final String _TIME_ZONE = StringPool.UTC;

	private static final String _URL_REGEX_PATTERN = "url-regex-pattern";

	private Format _dateFormat;
	private FilterConfig _filterConfig;

}