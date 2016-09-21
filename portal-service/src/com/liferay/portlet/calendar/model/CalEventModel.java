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

package com.liferay.portlet.calendar.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CalEvent service. Represents a row in the &quot;CalEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.calendar.model.impl.CalEventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.calendar.model.impl.CalEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CalEvent
 * @see com.liferay.portlet.calendar.model.impl.CalEventImpl
 * @see com.liferay.portlet.calendar.model.impl.CalEventModelImpl
 * @generated
 */
public interface CalEventModel extends BaseModel<CalEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cal event model instance should use the {@link CalEvent} interface instead.
	 */

	/**
	 * Gets the primary key of this cal event.
	 *
	 * @return the primary key of this cal event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cal event
	 *
	 * @param pk the primary key of this cal event
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this cal event.
	 *
	 * @return the uuid of this cal event
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this cal event.
	 *
	 * @param uuid the uuid of this cal event
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the event id of this cal event.
	 *
	 * @return the event id of this cal event
	 */
	public long getEventId();

	/**
	 * Sets the event id of this cal event.
	 *
	 * @param eventId the event id of this cal event
	 */
	public void setEventId(long eventId);

	/**
	 * Gets the group id of this cal event.
	 *
	 * @return the group id of this cal event
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this cal event.
	 *
	 * @param groupId the group id of this cal event
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this cal event.
	 *
	 * @return the company id of this cal event
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this cal event.
	 *
	 * @param companyId the company id of this cal event
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this cal event.
	 *
	 * @return the user id of this cal event
	 */
	public long getUserId();

	/**
	 * Sets the user id of this cal event.
	 *
	 * @param userId the user id of this cal event
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this cal event.
	 *
	 * @return the user uuid of this cal event
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this cal event.
	 *
	 * @param userUuid the user uuid of this cal event
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this cal event.
	 *
	 * @return the user name of this cal event
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this cal event.
	 *
	 * @param userName the user name of this cal event
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this cal event.
	 *
	 * @return the create date of this cal event
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this cal event.
	 *
	 * @param createDate the create date of this cal event
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this cal event.
	 *
	 * @return the modified date of this cal event
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cal event.
	 *
	 * @param modifiedDate the modified date of this cal event
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the title of this cal event.
	 *
	 * @return the title of this cal event
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this cal event.
	 *
	 * @param title the title of this cal event
	 */
	public void setTitle(String title);

	/**
	 * Gets the description of this cal event.
	 *
	 * @return the description of this cal event
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this cal event.
	 *
	 * @param description the description of this cal event
	 */
	public void setDescription(String description);

	/**
	 * Gets the start date of this cal event.
	 *
	 * @return the start date of this cal event
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this cal event.
	 *
	 * @param startDate the start date of this cal event
	 */
	public void setStartDate(Date startDate);

	/**
	 * Gets the end date of this cal event.
	 *
	 * @return the end date of this cal event
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this cal event.
	 *
	 * @param endDate the end date of this cal event
	 */
	public void setEndDate(Date endDate);

	/**
	 * Gets the duration hour of this cal event.
	 *
	 * @return the duration hour of this cal event
	 */
	public int getDurationHour();

	/**
	 * Sets the duration hour of this cal event.
	 *
	 * @param durationHour the duration hour of this cal event
	 */
	public void setDurationHour(int durationHour);

	/**
	 * Gets the duration minute of this cal event.
	 *
	 * @return the duration minute of this cal event
	 */
	public int getDurationMinute();

	/**
	 * Sets the duration minute of this cal event.
	 *
	 * @param durationMinute the duration minute of this cal event
	 */
	public void setDurationMinute(int durationMinute);

	/**
	 * Gets the all day of this cal event.
	 *
	 * @return the all day of this cal event
	 */
	public boolean getAllDay();

	/**
	 * Determines if this cal event is all day.
	 *
	 * @return <code>true</code> if this cal event is all day; <code>false</code> otherwise
	 */
	public boolean isAllDay();

	/**
	 * Sets whether this cal event is all day.
	 *
	 * @param allDay the all day of this cal event
	 */
	public void setAllDay(boolean allDay);

	/**
	 * Gets the time zone sensitive of this cal event.
	 *
	 * @return the time zone sensitive of this cal event
	 */
	public boolean getTimeZoneSensitive();

	/**
	 * Determines if this cal event is time zone sensitive.
	 *
	 * @return <code>true</code> if this cal event is time zone sensitive; <code>false</code> otherwise
	 */
	public boolean isTimeZoneSensitive();

	/**
	 * Sets whether this cal event is time zone sensitive.
	 *
	 * @param timeZoneSensitive the time zone sensitive of this cal event
	 */
	public void setTimeZoneSensitive(boolean timeZoneSensitive);

	/**
	 * Gets the type of this cal event.
	 *
	 * @return the type of this cal event
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this cal event.
	 *
	 * @param type the type of this cal event
	 */
	public void setType(String type);

	/**
	 * Gets the repeating of this cal event.
	 *
	 * @return the repeating of this cal event
	 */
	public boolean getRepeating();

	/**
	 * Determines if this cal event is repeating.
	 *
	 * @return <code>true</code> if this cal event is repeating; <code>false</code> otherwise
	 */
	public boolean isRepeating();

	/**
	 * Sets whether this cal event is repeating.
	 *
	 * @param repeating the repeating of this cal event
	 */
	public void setRepeating(boolean repeating);

	/**
	 * Gets the recurrence of this cal event.
	 *
	 * @return the recurrence of this cal event
	 */
	public String getRecurrence();

	/**
	 * Sets the recurrence of this cal event.
	 *
	 * @param recurrence the recurrence of this cal event
	 */
	public void setRecurrence(String recurrence);

	/**
	 * Gets the remind by of this cal event.
	 *
	 * @return the remind by of this cal event
	 */
	public int getRemindBy();

	/**
	 * Sets the remind by of this cal event.
	 *
	 * @param remindBy the remind by of this cal event
	 */
	public void setRemindBy(int remindBy);

	/**
	 * Gets the first reminder of this cal event.
	 *
	 * @return the first reminder of this cal event
	 */
	public int getFirstReminder();

	/**
	 * Sets the first reminder of this cal event.
	 *
	 * @param firstReminder the first reminder of this cal event
	 */
	public void setFirstReminder(int firstReminder);

	/**
	 * Gets the second reminder of this cal event.
	 *
	 * @return the second reminder of this cal event
	 */
	public int getSecondReminder();

	/**
	 * Sets the second reminder of this cal event.
	 *
	 * @param secondReminder the second reminder of this cal event
	 */
	public void setSecondReminder(int secondReminder);

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

	public int compareTo(CalEvent calEvent);

	public int hashCode();

	public CalEvent toEscapedModel();

	public String toString();

	public String toXmlString();
}