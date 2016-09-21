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

package com.liferay.portlet.wiki.model;

import java.io.Serializable;

/**
 * @author Jorge Ferrer
 */
public interface WikiPageDisplay extends Serializable {

	public long getUserId();

	public void setUserId(long userId);

	public long getNodeId();

	public void setNodeId(long nodeId);

	public String getTitle();

	public void setTitle(String title);

	public double getVersion();

	public void setVersion(double version);

	public String getContent();

	public void setContent(String content);

	public String getFormattedContent();

	public void setFormattedContent(String formattedContent);

	public String getFormat();

	public void setFormat(String format);

	public boolean getHead();

	public boolean isHead();

	public void setHead(boolean head);

	public String[] getAttachments();

	public void setAttachments(String[] attachments);

}