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

package com.liferay.portlet.wiki.model.impl;

import com.liferay.portlet.wiki.model.WikiPageDisplay;

/**
 * @author Jorge Ferrer
 */
public class WikiPageDisplayImpl implements WikiPageDisplay {

	public WikiPageDisplayImpl(
		long userId, long nodeId, String title, double version, String content,
		String formattedContent, String format, boolean head,
		String[] attachments) {

		_userId = userId;
		_nodeId = nodeId;
		_title = title;
		_version = version;
		_content = content;
		_formattedContent = formattedContent;
		_format = format;
		_head = head;
		_attachments = attachments;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getFormattedContent() {
		return _formattedContent;
	}

	public void setFormattedContent(String formattedContent) {
		_formattedContent = formattedContent;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public boolean getHead() {
		return _head;
	}

	public boolean isHead() {
		return _head;
	}

	public void setHead(boolean head) {
		_head = head;
	}

	public String[] getAttachments() {
		return _attachments;
	}

	public void setAttachments(String[] attachments) {
		_attachments = attachments;
	}

	private long _userId;
	private long _nodeId;
	private String _title;
	private double _version;
	private String _content;
	private String _formattedContent;
	private String _format;
	private boolean _head;
	private String[] _attachments;

}