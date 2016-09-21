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

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Jorge Ferrer
 */
public class TreeNodeView {

	public TreeNodeView(int id) {
		_id = id;
	}

	public int getDepth() {
		return _depth;
	}

	public void setDepth(int depth) {
		_depth = depth;
	}

	public String getHref() {
		return _href;
	}

	public void setHref(String href) {
		_href = href;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getImg() {
		return _img;
	}

	public void setImg(String img) {
		_img = img;
	}

	public String getLs() {
		return _ls;
	}

	public void setLs(String ls) {
		_ls = ls;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getObjId() {
		return _objId;
	}

	public void setObjId(String objId) {
		_objId = objId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private int _depth;
	private String _href = "javascript:;";
	private long _id;
	private String _img = StringPool.BLANK;
	private String _ls = StringPool.BLANK;
	private String _name = StringPool.BLANK;
	private String _objId = StringPool.BLANK;
	private long _parentId;

}