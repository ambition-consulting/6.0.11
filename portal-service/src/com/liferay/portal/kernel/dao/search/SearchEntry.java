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

package com.liferay.portal.kernel.dao.search;

import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class SearchEntry implements Cloneable {

	public static final String DEFAULT_ALIGN = "left";

	public static final String DEFAULT_VALIGN = "middle";

	public static final int DEFAULT_COLSPAN = 1;

	public SearchEntry() {
		this(DEFAULT_ALIGN, DEFAULT_VALIGN, DEFAULT_COLSPAN);
	}

	public SearchEntry(String align, String valign, int colspan) {
		_align = align;
		_valign = valign;
		_colspan = colspan;
	}

	public int getIndex() {
		return _index;
	}

	public void setIndex(int index) {
		_index = index;
	}

	public String getAlign() {
		return _align;
	}

	public void setAlign(String align) {
		_align = align;
	}

	public String getValign() {
		return _valign;
	}

	public void setValign(String valign) {
		_valign = valign;
	}

	public int getColspan() {
		return _colspan;
	}

	public void setColspan(int colspan) {
		_colspan = colspan;
	}

	public abstract void print(PageContext pageContext) throws Exception;

	private int _index;
	private String _align;
	private String _valign;
	private int _colspan;

}