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

/**
 * The model interface for the Website service. Represents a row in the &quot;Website&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.WebsiteImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebsiteModel
 * @see com.liferay.portal.model.impl.WebsiteImpl
 * @see com.liferay.portal.model.impl.WebsiteModelImpl
 * @generated
 */
public interface Website extends WebsiteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a website model instance should use the {@link Website} interface instead.
	 */
	public com.liferay.portal.model.ListType getType()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}