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

package com.liferay.portal.kernel.portlet;

import javax.portlet.ActionResponse;
import javax.portlet.filter.ActionResponseWrapper;

/**
 * @author Brian Wing Shun Chan
 */
public class NoRedirectActionResponse extends ActionResponseWrapper {

	public NoRedirectActionResponse(ActionResponse actionResponse) {
		super(actionResponse);
	}

	public String getRedirectLocation() {
		return _redirectLocation;
	}

	public void sendRedirect(String location) {

		// Disable send redirect

		_redirectLocation = location;
	}

	private String _redirectLocation;

}