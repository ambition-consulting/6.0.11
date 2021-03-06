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

package com.liferay.portlet.messageboards.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MBCategory service. Represents a row in the &quot;MBCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.messageboards.model.impl.MBCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBCategory
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl
 * @generated
 */
public interface MBCategoryModel extends BaseModel<MBCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message boards category model instance should use the {@link MBCategory} interface instead.
	 */

	/**
	 * Gets the primary key of this message boards category.
	 *
	 * @return the primary key of this message boards category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message boards category
	 *
	 * @param pk the primary key of this message boards category
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this message boards category.
	 *
	 * @return the uuid of this message boards category
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this message boards category.
	 *
	 * @param uuid the uuid of this message boards category
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the category id of this message boards category.
	 *
	 * @return the category id of this message boards category
	 */
	public long getCategoryId();

	/**
	 * Sets the category id of this message boards category.
	 *
	 * @param categoryId the category id of this message boards category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Gets the group id of this message boards category.
	 *
	 * @return the group id of this message boards category
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this message boards category.
	 *
	 * @param groupId the group id of this message boards category
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this message boards category.
	 *
	 * @return the company id of this message boards category
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this message boards category.
	 *
	 * @param companyId the company id of this message boards category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this message boards category.
	 *
	 * @return the user id of this message boards category
	 */
	public long getUserId();

	/**
	 * Sets the user id of this message boards category.
	 *
	 * @param userId the user id of this message boards category
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this message boards category.
	 *
	 * @return the user uuid of this message boards category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this message boards category.
	 *
	 * @param userUuid the user uuid of this message boards category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this message boards category.
	 *
	 * @return the user name of this message boards category
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this message boards category.
	 *
	 * @param userName the user name of this message boards category
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this message boards category.
	 *
	 * @return the create date of this message boards category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this message boards category.
	 *
	 * @param createDate the create date of this message boards category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this message boards category.
	 *
	 * @return the modified date of this message boards category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this message boards category.
	 *
	 * @param modifiedDate the modified date of this message boards category
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the parent category id of this message boards category.
	 *
	 * @return the parent category id of this message boards category
	 */
	public long getParentCategoryId();

	/**
	 * Sets the parent category id of this message boards category.
	 *
	 * @param parentCategoryId the parent category id of this message boards category
	 */
	public void setParentCategoryId(long parentCategoryId);

	/**
	 * Gets the name of this message boards category.
	 *
	 * @return the name of this message boards category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this message boards category.
	 *
	 * @param name the name of this message boards category
	 */
	public void setName(String name);

	/**
	 * Gets the description of this message boards category.
	 *
	 * @return the description of this message boards category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this message boards category.
	 *
	 * @param description the description of this message boards category
	 */
	public void setDescription(String description);

	/**
	 * Gets the thread count of this message boards category.
	 *
	 * @return the thread count of this message boards category
	 */
	public int getThreadCount();

	/**
	 * Sets the thread count of this message boards category.
	 *
	 * @param threadCount the thread count of this message boards category
	 */
	public void setThreadCount(int threadCount);

	/**
	 * Gets the message count of this message boards category.
	 *
	 * @return the message count of this message boards category
	 */
	public int getMessageCount();

	/**
	 * Sets the message count of this message boards category.
	 *
	 * @param messageCount the message count of this message boards category
	 */
	public void setMessageCount(int messageCount);

	/**
	 * Gets the last post date of this message boards category.
	 *
	 * @return the last post date of this message boards category
	 */
	public Date getLastPostDate();

	/**
	 * Sets the last post date of this message boards category.
	 *
	 * @param lastPostDate the last post date of this message boards category
	 */
	public void setLastPostDate(Date lastPostDate);

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

	public int compareTo(MBCategory mbCategory);

	public int hashCode();

	public MBCategory toEscapedModel();

	public String toString();

	public String toXmlString();
}