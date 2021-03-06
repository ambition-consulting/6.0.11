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

/**
 * The model interface for the SCProductVersion service. Represents a row in the &quot;SCProductVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.softwarecatalog.model.impl.SCProductVersionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductVersionModel
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCProductVersionImpl
 * @see com.liferay.portlet.softwarecatalog.model.impl.SCProductVersionModelImpl
 * @generated
 */
public interface SCProductVersion extends SCProductVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a s c product version model instance should use the {@link SCProductVersion} interface instead.
	 */
	public java.util.List<com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion> getFrameworkVersions()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.softwarecatalog.model.SCProductEntry getProductEntry();
}