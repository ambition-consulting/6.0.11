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

package com.liferay.portal.kernel.upload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Zongliang Li
 * @author Harry Mark
 */
public interface UploadServletRequest extends HttpServletRequest {

	public void cleanUp();

	public String getContentType(String name);

	public File getFile(String name);

	public String getFileName(String name);

	public String getFullFileName(String name);

	public Boolean isFormField(String name);

}