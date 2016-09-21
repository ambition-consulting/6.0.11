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

package com.liferay.portlet.messageboards.util;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Alexander Chow
 */
public class BBCodeTag {

	public BBCodeTag() {
	}

	public String getElement() {
		return _element;
	}

	public void setElement(String element) {
		_element = element;
	}

	public boolean hasElement() {
		if (_element != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getEndPos() {
		return _endPos;
	}

	public void setEndPos(int pos) {
		_endPos = pos;
	}

	public String getParameter() {
		return _parameter;
	}

	public void setParameter(String parameter) {
		_parameter = parameter.trim();

		if (_parameter.startsWith(StringPool.APOSTROPHE) ||
			_parameter.startsWith(StringPool.QUOTE)) {

			_parameter = _parameter.substring(1);
		}

		if (_parameter.endsWith(StringPool.APOSTROPHE) ||
			_parameter.endsWith(StringPool.QUOTE)) {

			_parameter = _parameter.substring(0, _parameter.length() - 1);
		}

		_parameter = _parameter.trim();
	}

	public boolean hasParameter() {
		if (_parameter != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getStartPos() {
		return _startPos;
	}

	public void setStartPos(int pos) {
		_startPos = pos;
	}

	private String _element;
	private int _endPos;
	private String _parameter;
	private int _startPos;

}