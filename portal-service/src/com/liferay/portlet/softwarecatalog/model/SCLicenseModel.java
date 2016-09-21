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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SCLicense service. Represents a row in the &quot;SCLicense&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.softwarecatalog.model.impl.SCLicenseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.softwarecatalog.model.impl.SCLicenseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCLicense
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCLicenseImpl
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCLicenseModelImpl
 * @generated
 */
public interface SCLicenseModel extends BaseModel<SCLicense> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s c license model instance should use the {@link SCLicense} interface instead.
	 */

	/**
	 * Gets the primary key of this s c license.
	 *
	 * @return the primary key of this s c license
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s c license
	 *
	 * @param pk the primary key of this s c license
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the license id of this s c license.
	 *
	 * @return the license id of this s c license
	 */
	public long getLicenseId();

	/**
	 * Sets the license id of this s c license.
	 *
	 * @param licenseId the license id of this s c license
	 */
	public void setLicenseId(long licenseId);

	/**
	 * Gets the name of this s c license.
	 *
	 * @return the name of this s c license
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this s c license.
	 *
	 * @param name the name of this s c license
	 */
	public void setName(String name);

	/**
	 * Gets the url of this s c license.
	 *
	 * @return the url of this s c license
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this s c license.
	 *
	 * @param url the url of this s c license
	 */
	public void setUrl(String url);

	/**
	 * Gets the open source of this s c license.
	 *
	 * @return the open source of this s c license
	 */
	public boolean getOpenSource();

	/**
	 * Determines if this s c license is open source.
	 *
	 * @return <code>true</code> if this s c license is open source; <code>false</code> otherwise
	 */
	public boolean isOpenSource();

	/**
	 * Sets whether this s c license is open source.
	 *
	 * @param openSource the open source of this s c license
	 */
	public void setOpenSource(boolean openSource);

	/**
	 * Gets the active of this s c license.
	 *
	 * @return the active of this s c license
	 */
	public boolean getActive();

	/**
	 * Determines if this s c license is active.
	 *
	 * @return <code>true</code> if this s c license is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this s c license is active.
	 *
	 * @param active the active of this s c license
	 */
	public void setActive(boolean active);

	/**
	 * Gets the recommended of this s c license.
	 *
	 * @return the recommended of this s c license
	 */
	public boolean getRecommended();

	/**
	 * Determines if this s c license is recommended.
	 *
	 * @return <code>true</code> if this s c license is recommended; <code>false</code> otherwise
	 */
	public boolean isRecommended();

	/**
	 * Sets whether this s c license is recommended.
	 *
	 * @param recommended the recommended of this s c license
	 */
	public void setRecommended(boolean recommended);

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

	public int compareTo(SCLicense scLicense);

	public int hashCode();

	public SCLicense toEscapedModel();

	public String toString();

	public String toXmlString();
}