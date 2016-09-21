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

package com.liferay.portlet.asset.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AssetEntry service. Represents a row in the &quot;AssetEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.asset.model.impl.AssetEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.asset.model.impl.AssetEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntry
 * @see com.liferay.portlet.asset.model.impl.AssetEntryImpl
 * @see com.liferay.portlet.asset.model.impl.AssetEntryModelImpl
 * @generated
 */
public interface AssetEntryModel extends BaseModel<AssetEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a asset entry model instance should use the {@link AssetEntry} interface instead.
	 */

	/**
	 * Gets the primary key of this asset entry.
	 *
	 * @return the primary key of this asset entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset entry
	 *
	 * @param pk the primary key of this asset entry
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the entry id of this asset entry.
	 *
	 * @return the entry id of this asset entry
	 */
	public long getEntryId();

	/**
	 * Sets the entry id of this asset entry.
	 *
	 * @param entryId the entry id of this asset entry
	 */
	public void setEntryId(long entryId);

	/**
	 * Gets the group id of this asset entry.
	 *
	 * @return the group id of this asset entry
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this asset entry.
	 *
	 * @param groupId the group id of this asset entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this asset entry.
	 *
	 * @return the company id of this asset entry
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this asset entry.
	 *
	 * @param companyId the company id of this asset entry
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this asset entry.
	 *
	 * @return the user id of this asset entry
	 */
	public long getUserId();

	/**
	 * Sets the user id of this asset entry.
	 *
	 * @param userId the user id of this asset entry
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this asset entry.
	 *
	 * @return the user uuid of this asset entry
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this asset entry.
	 *
	 * @param userUuid the user uuid of this asset entry
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this asset entry.
	 *
	 * @return the user name of this asset entry
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this asset entry.
	 *
	 * @param userName the user name of this asset entry
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this asset entry.
	 *
	 * @return the create date of this asset entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset entry.
	 *
	 * @param createDate the create date of this asset entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this asset entry.
	 *
	 * @return the modified date of this asset entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this asset entry.
	 *
	 * @param modifiedDate the modified date of this asset entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the class name of the model instance this asset entry is polymorphically associated with.
	 *
	 * @return the class name of the model instance this asset entry is polymorphically associated with
	 */
	public String getClassName();

	/**
	 * Gets the class name id of this asset entry.
	 *
	 * @return the class name id of this asset entry
	 */
	public long getClassNameId();

	/**
	 * Sets the class name id of this asset entry.
	 *
	 * @param classNameId the class name id of this asset entry
	 */
	public void setClassNameId(long classNameId);

	/**
	 * Gets the class p k of this asset entry.
	 *
	 * @return the class p k of this asset entry
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this asset entry.
	 *
	 * @param classPK the class p k of this asset entry
	 */
	public void setClassPK(long classPK);

	/**
	 * Gets the class uuid of this asset entry.
	 *
	 * @return the class uuid of this asset entry
	 */
	@AutoEscape
	public String getClassUuid();

	/**
	 * Sets the class uuid of this asset entry.
	 *
	 * @param classUuid the class uuid of this asset entry
	 */
	public void setClassUuid(String classUuid);

	/**
	 * Gets the visible of this asset entry.
	 *
	 * @return the visible of this asset entry
	 */
	public boolean getVisible();

	/**
	 * Determines if this asset entry is visible.
	 *
	 * @return <code>true</code> if this asset entry is visible; <code>false</code> otherwise
	 */
	public boolean isVisible();

	/**
	 * Sets whether this asset entry is visible.
	 *
	 * @param visible the visible of this asset entry
	 */
	public void setVisible(boolean visible);

	/**
	 * Gets the start date of this asset entry.
	 *
	 * @return the start date of this asset entry
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this asset entry.
	 *
	 * @param startDate the start date of this asset entry
	 */
	public void setStartDate(Date startDate);

	/**
	 * Gets the end date of this asset entry.
	 *
	 * @return the end date of this asset entry
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this asset entry.
	 *
	 * @param endDate the end date of this asset entry
	 */
	public void setEndDate(Date endDate);

	/**
	 * Gets the publish date of this asset entry.
	 *
	 * @return the publish date of this asset entry
	 */
	public Date getPublishDate();

	/**
	 * Sets the publish date of this asset entry.
	 *
	 * @param publishDate the publish date of this asset entry
	 */
	public void setPublishDate(Date publishDate);

	/**
	 * Gets the expiration date of this asset entry.
	 *
	 * @return the expiration date of this asset entry
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this asset entry.
	 *
	 * @param expirationDate the expiration date of this asset entry
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Gets the mime type of this asset entry.
	 *
	 * @return the mime type of this asset entry
	 */
	@AutoEscape
	public String getMimeType();

	/**
	 * Sets the mime type of this asset entry.
	 *
	 * @param mimeType the mime type of this asset entry
	 */
	public void setMimeType(String mimeType);

	/**
	 * Gets the title of this asset entry.
	 *
	 * @return the title of this asset entry
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this asset entry.
	 *
	 * @param title the title of this asset entry
	 */
	public void setTitle(String title);

	/**
	 * Gets the description of this asset entry.
	 *
	 * @return the description of this asset entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this asset entry.
	 *
	 * @param description the description of this asset entry
	 */
	public void setDescription(String description);

	/**
	 * Gets the summary of this asset entry.
	 *
	 * @return the summary of this asset entry
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this asset entry.
	 *
	 * @param summary the summary of this asset entry
	 */
	public void setSummary(String summary);

	/**
	 * Gets the url of this asset entry.
	 *
	 * @return the url of this asset entry
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this asset entry.
	 *
	 * @param url the url of this asset entry
	 */
	public void setUrl(String url);

	/**
	 * Gets the height of this asset entry.
	 *
	 * @return the height of this asset entry
	 */
	public int getHeight();

	/**
	 * Sets the height of this asset entry.
	 *
	 * @param height the height of this asset entry
	 */
	public void setHeight(int height);

	/**
	 * Gets the width of this asset entry.
	 *
	 * @return the width of this asset entry
	 */
	public int getWidth();

	/**
	 * Sets the width of this asset entry.
	 *
	 * @param width the width of this asset entry
	 */
	public void setWidth(int width);

	/**
	 * Gets the priority of this asset entry.
	 *
	 * @return the priority of this asset entry
	 */
	public double getPriority();

	/**
	 * Sets the priority of this asset entry.
	 *
	 * @param priority the priority of this asset entry
	 */
	public void setPriority(double priority);

	/**
	 * Gets the view count of this asset entry.
	 *
	 * @return the view count of this asset entry
	 */
	public int getViewCount();

	/**
	 * Sets the view count of this asset entry.
	 *
	 * @param viewCount the view count of this asset entry
	 */
	public void setViewCount(int viewCount);

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

	public int compareTo(AssetEntry assetEntry);

	public int hashCode();

	public AssetEntry toEscapedModel();

	public String toString();

	public String toXmlString();
}