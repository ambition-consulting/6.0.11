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

package com.liferay.portal.kernel.poller;

import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Brian Wing Shun Chan
 */
public class PollerHeader {

	public PollerHeader(
		long companyId, long userId, long browserKey, String[] portletIds,
		boolean initialRequest, boolean startPolling) {

		_companyId = companyId;
		_userId = userId;
		_browserKey = browserKey;
		_portletIds = portletIds;
		_initialRequest = initialRequest;
		_startPolling = startPolling;
	}

	public long getBrowserKey() {
		return _browserKey;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public String[] getPortletIds() {
		return _portletIds;
	}

	public long getTimestamp() {
		return _timestamp;
	}

	public long getUserId() {
		return _userId;
	}

	public boolean isInitialRequest() {
		return _initialRequest;
	}

	public boolean isStartPolling() {
		return _startPolling;
	}

	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{_browserKey=");
		sb.append(_browserKey);
		sb.append(", companyId=");
		sb.append(_companyId);
		sb.append(", initialRequest=");
		sb.append(_initialRequest);
		sb.append(", portletIds=");
		sb.append(_portletIds);
		sb.append(", startPolling=");
		sb.append(_startPolling);
		sb.append(", timestamp=");
		sb.append(_timestamp);
		sb.append(", userId=");
		sb.append(_userId);
		sb.append("}");

		return sb.toString();
	}

	private long _browserKey;
	private long _companyId;
	private boolean _initialRequest;
	private String[] _portletIds;
	private boolean _startPolling;
	private long _timestamp = System.currentTimeMillis();
	private long _userId;

}