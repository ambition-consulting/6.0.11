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

package com.liferay.taglib.ui;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class AssetTagsSelectorTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setContentCallback(String contentCallback) {
		_contentCallback = contentCallback;
	}

	public void setCurTags(String curTags) {
		_curTags = curTags;
	}

	public void setFocus(boolean focus) {
		_focus = focus;
	}

	public void setHiddenInput(String hiddenInput) {
		_hiddenInput = hiddenInput;
	}

	protected void cleanUp() {
		_className = null;
		_classPK = 0;
		_contentCallback = null;
		_curTags = null;
		_focus = false;
		_hiddenInput = "assetTagNames";
	}

	protected String getPage() {
		return _PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"liferay-ui:asset-tags-selector:className", _className);
		request.setAttribute(
			"liferay-ui:asset-tags-selector:classPK", String.valueOf(_classPK));
		request.setAttribute(
			"liferay-ui:asset-tags-selector:contentCallback",
			String.valueOf(_contentCallback));
		request.setAttribute(
			"liferay-ui:asset-tags-selector:curTags", _curTags);
		request.setAttribute(
			"liferay-ui:asset-tags-selector:focus", String.valueOf(_focus));
		request.setAttribute(
			"liferay-ui:asset-tags-selector:hiddenInput", _hiddenInput);
	}

	private static final String _PAGE =
		"/html/taglib/ui/asset_tags_selector/page.jsp";

	private String _className;
	private long _classPK;
	private String _contentCallback;
	private String _curTags;
	private boolean _focus;
	private String _hiddenInput = "assetTagNames";

}