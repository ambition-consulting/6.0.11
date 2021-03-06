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

package com.liferay.portlet.softwarecatalog.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SCProductScreenshot service. Represents a row in the &quot;SCProductScreenshot&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.softwarecatalog.model.impl.SCProductScreenshotModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.softwarecatalog.model.impl.SCProductScreenshotImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductScreenshot
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCProductScreenshotImpl
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCProductScreenshotModelImpl
 * @generated
 */
public interface SCProductScreenshotModel extends BaseModel<SCProductScreenshot> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s c product screenshot model instance should use the {@link SCProductScreenshot} interface instead.
	 */

	/**
	 * Gets the primary key of this s c product screenshot.
	 *
	 * @return the primary key of this s c product screenshot
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s c product screenshot
	 *
	 * @param pk the primary key of this s c product screenshot
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the product screenshot id of this s c product screenshot.
	 *
	 * @return the product screenshot id of this s c product screenshot
	 */
	public long getProductScreenshotId();

	/**
	 * Sets the product screenshot id of this s c product screenshot.
	 *
	 * @param productScreenshotId the product screenshot id of this s c product screenshot
	 */
	public void setProductScreenshotId(long productScreenshotId);

	/**
	 * Gets the company id of this s c product screenshot.
	 *
	 * @return the company id of this s c product screenshot
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this s c product screenshot.
	 *
	 * @param companyId the company id of this s c product screenshot
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the group id of this s c product screenshot.
	 *
	 * @return the group id of this s c product screenshot
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this s c product screenshot.
	 *
	 * @param groupId the group id of this s c product screenshot
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the product entry id of this s c product screenshot.
	 *
	 * @return the product entry id of this s c product screenshot
	 */
	public long getProductEntryId();

	/**
	 * Sets the product entry id of this s c product screenshot.
	 *
	 * @param productEntryId the product entry id of this s c product screenshot
	 */
	public void setProductEntryId(long productEntryId);

	/**
	 * Gets the thumbnail id of this s c product screenshot.
	 *
	 * @return the thumbnail id of this s c product screenshot
	 */
	public long getThumbnailId();

	/**
	 * Sets the thumbnail id of this s c product screenshot.
	 *
	 * @param thumbnailId the thumbnail id of this s c product screenshot
	 */
	public void setThumbnailId(long thumbnailId);

	/**
	 * Gets the full image id of this s c product screenshot.
	 *
	 * @return the full image id of this s c product screenshot
	 */
	public long getFullImageId();

	/**
	 * Sets the full image id of this s c product screenshot.
	 *
	 * @param fullImageId the full image id of this s c product screenshot
	 */
	public void setFullImageId(long fullImageId);

	/**
	 * Gets the priority of this s c product screenshot.
	 *
	 * @return the priority of this s c product screenshot
	 */
	public int getPriority();

	/**
	 * Sets the priority of this s c product screenshot.
	 *
	 * @param priority the priority of this s c product screenshot
	 */
	public void setPriority(int priority);

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

	public int compareTo(SCProductScreenshot scProductScreenshot);

	public int hashCode();

	public SCProductScreenshot toEscapedModel();

	public String toString();

	public String toXmlString();
}