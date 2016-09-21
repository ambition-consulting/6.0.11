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

package com.liferay.portal.webdav.methods;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVStorage;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class GetMethodImpl implements Method {

	public int process(WebDAVRequest webDavRequest) throws WebDAVException {
		InputStream is = null;

		try {
			WebDAVStorage storage = webDavRequest.getWebDAVStorage();
			HttpServletResponse response =
				webDavRequest.getHttpServletResponse();

			Resource resource = storage.getResource(webDavRequest);

			if (resource != null) {
				try {
					is = resource.getContentAsStream();
				}
				catch (Exception e) {
					if (_log.isErrorEnabled()) {
						_log.error(e.getMessage());
					}
				}
			}

			int status = HttpServletResponse.SC_NOT_FOUND;

			if (is != null) {
				try {
					response.setContentType(resource.getContentType());

					ServletResponseUtil.write(response, is);
				}
				catch (Exception e) {
					if (_log.isWarnEnabled()) {
						_log.warn(e);
					}
				}

				status = HttpServletResponse.SC_OK;
			}

			return status;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(GetMethodImpl.class);

}