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

package com.liferay.portlet.layoutconfiguration.util.xml;

import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class RenderURLLogic extends ActionURLLogic {

	public static final String OPEN_TAG = "<runtime-render-url";

	public static final String CLOSE_1_TAG = "</runtime-render-url>";

	public static final String CLOSE_2_TAG = "/>";

	public RenderURLLogic(RenderResponse renderResponse) {
		super(renderResponse);
	}

	public String getOpenTag() {
		return OPEN_TAG;
	}

	public String getClose1Tag() {
		return CLOSE_1_TAG;
	}

	public String getLifecycle() {
		return _lifecycle;
	}

	private String _lifecycle = PortletRequest.RENDER_PHASE;

}