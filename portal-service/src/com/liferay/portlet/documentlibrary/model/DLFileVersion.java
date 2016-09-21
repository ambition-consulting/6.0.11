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
 * The model interface for the DLFileVersion service. Represents a row in the &quot;DLFileVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionModel
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionImpl
 * @see com.liferay.portlet.documentlibrary.model.impl.DLFileVersionModelImpl
 * @generated
 */
public interface DLFileVersion extends DLFileVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a d l file version model instance should use the {@link DLFileVersion} interface instead.
	 */
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge();

	public com.liferay.portlet.documentlibrary.model.DLFileEntry getFileEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @deprecated {@link #getFileEntry()}
	*/
	public long getFolderId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getIcon();

	/**
	* @deprecated {@link #getFileEntry()}
	*/
	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}