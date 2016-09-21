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

package com.liferay.portlet.communities.search;

import com.liferay.portal.kernel.dao.search.RowChecker;

import javax.portlet.RenderResponse;

/**
 * @author Raymond Augé
 */
public class ExportPageChecker extends RowChecker {

	public ExportPageChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}

	public ExportPageChecker(
		RenderResponse renderResponse, String align, String valign,
		String formName, String allRowsId, String rowId) {

		super(
			renderResponse, align, valign, COLSPAN, formName, allRowsId, rowId);
	}

	public ExportPageChecker(
		RenderResponse renderResponse, String align, String valign, int colspan,
		String formName, String allRowsId, String rowId) {

		super(
			renderResponse, align, valign, colspan, formName, allRowsId, rowId);
	}

	public boolean isChecked(Object obj) {
		return true;
	}

}