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

package com.liferay.portlet.imagegallery.model;

/**
 * The model interface for the IGFolder service. Represents a row in the &quot;IGFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.imagegallery.model.impl.IGFolderImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IGFolderModel
 * @see com.liferay.portlet.imagegallery.model.impl.IGFolderImpl
 * @see com.liferay.portlet.imagegallery.model.impl.IGFolderModelImpl
 * @generated
 */
public interface IGFolder extends IGFolderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a i g folder model instance should use the {@link IGFolder} interface instead.
	 */
	public java.util.List<com.liferay.portlet.imagegallery.model.IGFolder> getAncestors()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.imagegallery.model.IGFolder getParentFolder()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean isRoot();
}