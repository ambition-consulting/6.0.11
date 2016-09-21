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

package com.liferay.portlet.documentlibrary.model;

/**
 * The model interface for the DLFileEntry service. Represents a row in the &quot;DLFileEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileEntryModel
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileEntryModelImpl
 * @generated
 */
public interface DLFileEntry extends DLFileEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a d l file entry model instance should use the {@link DLFileEntry} interface instead.
	 */
	public java.lang.String getExtraSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getExtraSettingsProperties();

	public com.liferay.portlet.documentlibrary.model.DLFileVersion getFileVersion()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.documentlibrary.model.DLFileVersion getFileVersion(
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> getFileVersions(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.documentlibrary.model.DLFolder getFolder();

	public java.lang.String getIcon();

	public com.liferay.portlet.documentlibrary.model.DLFileVersion getLatestFileVersion()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Lock getLock();

	public java.lang.String getLuceneProperties();

	public long getRepositoryId();

	public boolean hasLock(long userId);

	public boolean isLocked();

	public void setExtraSettings(java.lang.String extraSettings);

	public void setExtraSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties extraSettingsProperties);
}