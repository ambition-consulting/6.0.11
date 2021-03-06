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
 * The model interface for the Company service. Represents a row in the &quot;Company&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.CompanyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyModel
 * @see com.liferay.portal.model.impl.CompanyImpl
 * @see com.liferay.portal.model.impl.CompanyModelImpl
 * @generated
 */
public interface Company extends CompanyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a company model instance should use the {@link Company} interface instead.
	 */
	public int compareTo(com.liferay.portal.model.Company company);

	public com.liferay.portal.model.Account getAccount()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getAdminName();

	public java.lang.String getAuthType()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.User getDefaultUser()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getDefaultWebId();

	public java.lang.String getEmailAddress();

	public com.liferay.portal.model.Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.security.Key getKeyObj();

	public java.util.Locale getLocale()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getShardName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getShortName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.TimeZone getTimeZone()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean hasCompanyMx(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isAutoLogin()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isCommunityLogo()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isSendPassword()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isSendPasswordResetLink()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isStrangers()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isStrangersVerify()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isStrangersWithMx()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setKey(java.lang.String key);

	public void setKeyObj(java.security.Key keyObj);
}