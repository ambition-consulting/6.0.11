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

package com.liferay.portal.kernel.webdav;

import com.liferay.portal.model.Lock;

import java.io.InputStream;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public interface Resource {

 	public String getHREF();

	public String getDisplayName();

	public Lock getLock();

	public boolean isCollection();

	public boolean isLocked();

 	public String getCreateDate();

 	public String getModifiedDate();

 	public long getSize();

	public Object getModel();

	public void setModel(Object model);

 	public String getClassName();

 	public void setClassName(String className);

 	public long getPrimaryKey();

 	public void setPrimaryKey(long primaryKey);

	public String getContentType();

	public InputStream getContentAsStream() throws WebDAVException ;

}