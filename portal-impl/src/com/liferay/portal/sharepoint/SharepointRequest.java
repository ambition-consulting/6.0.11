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

package com.liferay.portal.sharepoint;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bruno Farache
 */
public class SharepointRequest {

	public SharepointRequest(String rootPath) {
		_rootPath = rootPath;
	}

	public SharepointRequest(
		HttpServletRequest request, HttpServletResponse response, User user) {

		_request = request;
		_response = response;
		_user = user;

		_params.putAll(request.getParameterMap());
	}

	public void addParam(String key, String value) {
		_params.put(key, new String[] {value});
	}

	public byte[] getBytes() {
		return _bytes;
	}

	public long getCompanyId() {
		return _user.getCompanyId();
	}

	public HttpServletRequest getHttpServletRequest() {
		return _request;
	}

	public HttpServletResponse getHttpServletResponse() {
		return _response;
	}

	public String getParameterValue(String name) {
		String[] values = _params.get(name);

		if ((values != null) && (values.length > 0)) {
			return GetterUtil.getString(_params.get(name)[0]);
		}
		else {
			return StringPool.BLANK;
		}
	}

	public String getRootPath() {
		return _rootPath;
	}

	public SharepointStorage getSharepointStorage() {
		return _storage;
	}

	public User getUser() {
		return _user;
	}

	public long getUserId() {
		return _user.getUserId();
	}

	public void setBytes(byte[] bytes) {
		_bytes = bytes;
	}

	public void setRootPath(String rootPath) {
		_rootPath = SharepointUtil.replaceBackSlashes(rootPath);
	}

	public void setSharepointStorage(SharepointStorage storage) {
		_storage = storage;
	}

	private SharepointStorage _storage;
	private HttpServletRequest _request;
	private HttpServletResponse _response;
	private String _rootPath = StringPool.BLANK;
	private User _user;
	private byte[] _bytes;
	private Map<String, String[]> _params = new HashMap<String, String[]>();

}