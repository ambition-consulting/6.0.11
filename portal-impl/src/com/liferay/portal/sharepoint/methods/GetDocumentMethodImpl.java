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

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.sharepoint.Property;
import com.liferay.portal.sharepoint.ResponseElement;
import com.liferay.portal.sharepoint.SharepointRequest;
import com.liferay.portal.sharepoint.SharepointStorage;
import com.liferay.portal.sharepoint.Tree;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Farache
 */
public class GetDocumentMethodImpl extends BaseMethodImpl {

	public String getMethodName() {
		return _METHOD_NAME;
	}

	public String getRootPath(SharepointRequest sharepointRequest) {
		return sharepointRequest.getParameterValue("document_name");
	}

	protected void doProcess(SharepointRequest sharepointRequest)
		throws Exception {

		SharepointStorage storage = sharepointRequest.getSharepointStorage();

		StringBuilder sb = getResponseBuffer(sharepointRequest);

		sb.append(StringPool.NEW_LINE);

		InputStream is = storage.getDocumentInputStream(sharepointRequest);

		byte[] bytes = ArrayUtil.append(
			sb.toString().getBytes(), FileUtil.getBytes(is));

		ServletResponseUtil.write(
			sharepointRequest.getHttpServletResponse(), bytes);
	}

	protected List<ResponseElement> getElements(
			SharepointRequest sharepointRequest)
		throws Exception {

		List<ResponseElement> elements = new ArrayList<ResponseElement>();

		SharepointStorage storage = sharepointRequest.getSharepointStorage();

		elements.add(new Property("message", StringPool.BLANK));

		Tree documentTree = storage.getDocumentTree(sharepointRequest);

		Property documentProperty = new Property("document", documentTree);

		elements.add(documentProperty);

		return elements;
	}

	private static final String _METHOD_NAME = "get document";

}