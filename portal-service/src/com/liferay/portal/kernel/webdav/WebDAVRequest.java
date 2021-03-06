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

package com.liferay.portal.kernel.webdav;

import com.liferay.portal.security.permission.PermissionChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public interface WebDAVRequest {

	public WebDAVStorage getWebDAVStorage();

	public HttpServletRequest getHttpServletRequest();

	public HttpServletResponse getHttpServletResponse();

	public String getRootPath();

	public String getPath();

	public String[] getPathArray();

	public long getCompanyId();

	public long getGroupId() ;

	public long getUserId();

	public String getLockUuid();

	public PermissionChecker getPermissionChecker();

	public boolean isLitmus();

	public boolean isMac();

	public boolean isWindows();

}