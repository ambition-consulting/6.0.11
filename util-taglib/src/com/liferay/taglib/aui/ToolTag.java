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

package com.liferay.taglib.aui;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public class ToolTag extends TagSupport {

	public int doStartTag() {
		PanelTag parentTag = (PanelTag)findAncestorWithClass(
			this, PanelTag.class);

		parentTag.addToolTag(this);

		return EVAL_PAGE;
	}

	public String getHandler() {
		return _handler;
	}

	public String getIcon() {
		return _icon;
	}

	public String getId() {
		return _id;
	}

	public void setHandler(String handler) {
		_handler = handler;
	}

	public void setIcon(String icon) {
		_icon = icon;
	}

	public void setId(String id) {
		_id = id;
	}

	protected void cleanUp() {
		_handler = null;
		_icon = null;
		_id = null;
	}

	private String _handler;
	private String _icon;
	private String _id;

}