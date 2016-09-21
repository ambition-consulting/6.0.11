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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserTrackerPath service. Represents a row in the &quot;UserTrackerPath&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserTrackerPathModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserTrackerPathImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerPath
 * @see com.liferay.portal.model.impl.UserTrackerPathImpl
 * @see com.liferay.portal.model.impl.UserTrackerPathModelImpl
 * @generated
 */
public interface UserTrackerPathModel extends BaseModel<UserTrackerPath> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user tracker path model instance should use the {@link UserTrackerPath} interface instead.
	 */

	/**
	 * Gets the primary key of this user tracker path.
	 *
	 * @return the primary key of this user tracker path
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user tracker path
	 *
	 * @param pk the primary key of this user tracker path
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the user tracker path id of this user tracker path.
	 *
	 * @return the user tracker path id of this user tracker path
	 */
	public long getUserTrackerPathId();

	/**
	 * Sets the user tracker path id of this user tracker path.
	 *
	 * @param userTrackerPathId the user tracker path id of this user tracker path
	 */
	public void setUserTrackerPathId(long userTrackerPathId);

	/**
	 * Gets the user tracker id of this user tracker path.
	 *
	 * @return the user tracker id of this user tracker path
	 */
	public long getUserTrackerId();

	/**
	 * Sets the user tracker id of this user tracker path.
	 *
	 * @param userTrackerId the user tracker id of this user tracker path
	 */
	public void setUserTrackerId(long userTrackerId);

	/**
	 * Gets the path of this user tracker path.
	 *
	 * @return the path of this user tracker path
	 */
	@AutoEscape
	public String getPath();

	/**
	 * Sets the path of this user tracker path.
	 *
	 * @param path the path of this user tracker path
	 */
	public void setPath(String path);

	/**
	 * Gets the path date of this user tracker path.
	 *
	 * @return the path date of this user tracker path
	 */
	public Date getPathDate();

	/**
	 * Sets the path date of this user tracker path.
	 *
	 * @param pathDate the path date of this user tracker path
	 */
	public void setPathDate(Date pathDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UserTrackerPath userTrackerPath);

	public int hashCode();

	public UserTrackerPath toEscapedModel();

	public String toString();

	public String toXmlString();
}