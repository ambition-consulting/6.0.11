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

package com.liferay.portal.sharepoint.methods;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.sharepoint.ResponseElement;
import com.liferay.portal.sharepoint.SharepointException;
import com.liferay.portal.sharepoint.SharepointRequest;
import com.liferay.portal.sharepoint.SharepointUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import java.util.List;

/**
 * @author Bruno Farache
 */
public abstract class BaseMethodImpl implements Method {

	public String getRootPath(SharepointRequest sharepointRequest) {
		return StringPool.BLANK;
	}

	public void process(SharepointRequest sharepointRequest)
		throws SharepointException {

		try {
			doProcess(sharepointRequest);
		}
		catch (Exception e) {
			throw new SharepointException(e);
		}
	}

	protected abstract List<ResponseElement> getElements(
			SharepointRequest sharepointRequest)
		throws Exception;

	protected void doProcess(SharepointRequest sharepointRequest)
		throws Exception {

		ServletResponseUtil.write(
			sharepointRequest.getHttpServletResponse(),
			getResponseBuffer(sharepointRequest).toString());
	}

	protected StringBuilder getResponseBuffer(
			SharepointRequest sharepointRequest)
		throws Exception {

		StringBuilder sb = new StringBuilder();

		SharepointUtil.addTop(sb, getMethodName());

		List<ResponseElement> elements = getElements(sharepointRequest);

		for (ResponseElement element : elements) {
			sb.append(element.parse());
		}

		SharepointUtil.addBottom(sb);

		return sb;
	}

}