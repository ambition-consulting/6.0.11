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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link PasswordPolicyRelLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PasswordPolicyRelLocalService
 * @generated
 */
public class PasswordPolicyRelLocalServiceWrapper
	implements PasswordPolicyRelLocalService {
	public PasswordPolicyRelLocalServiceWrapper(
		PasswordPolicyRelLocalService passwordPolicyRelLocalService) {
		_passwordPolicyRelLocalService = passwordPolicyRelLocalService;
	}

	/**
	* Adds the password policy rel to the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to add
	* @return the password policy rel that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel addPasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.addPasswordPolicyRel(passwordPolicyRel);
	}

	/**
	* Creates a new password policy rel with the primary key. Does not add the password policy rel to the database.
	*
	* @param passwordPolicyRelId the primary key for the new password policy rel
	* @return the new password policy rel
	*/
	public com.liferay.portal.model.PasswordPolicyRel createPasswordPolicyRel(
		long passwordPolicyRelId) {
		return _passwordPolicyRelLocalService.createPasswordPolicyRel(passwordPolicyRelId);
	}

	/**
	* Deletes the password policy rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to delete
	* @throws PortalException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePasswordPolicyRel(long passwordPolicyRelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRel(passwordPolicyRelId);
	}

	/**
	* Deletes the password policy rel from the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRel(passwordPolicyRel);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the password policy rel with the primary key.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to get
	* @return the password policy rel
	* @throws PortalException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		long passwordPolicyRelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.getPasswordPolicyRel(passwordPolicyRelId);
	}

	/**
	* Gets a range of all the password policy rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of password policy rels to return
	* @param end the upper bound of the range of password policy rels to return (not inclusive)
	* @return the range of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.PasswordPolicyRel> getPasswordPolicyRels(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.getPasswordPolicyRels(start, end);
	}

	/**
	* Gets the number of password policy rels.
	*
	* @return the number of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	public int getPasswordPolicyRelsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.getPasswordPolicyRelsCount();
	}

	/**
	* Updates the password policy rel in the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to update
	* @return the password policy rel that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel updatePasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.updatePasswordPolicyRel(passwordPolicyRel);
	}

	/**
	* Updates the password policy rel in the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to update
	* @param merge whether to merge the password policy rel with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the password policy rel that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel updatePasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.updatePasswordPolicyRel(passwordPolicyRel,
			merge);
	}

	public com.liferay.portal.model.PasswordPolicyRel addPasswordPolicyRel(
		long passwordPolicyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.addPasswordPolicyRel(passwordPolicyId,
			className, classPK);
	}

	public void addPasswordPolicyRels(long passwordPolicyId,
		java.lang.String className, long[] classPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.addPasswordPolicyRels(passwordPolicyId,
			className, classPKs);
	}

	public void deletePasswordPolicyRel(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRel(className,
			classPK);
	}

	public void deletePasswordPolicyRel(long passwordPolicyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRel(passwordPolicyId,
			className, classPK);
	}

	public void deletePasswordPolicyRels(long passwordPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRels(passwordPolicyId);
	}

	public void deletePasswordPolicyRels(long passwordPolicyId,
		java.lang.String className, long[] classPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_passwordPolicyRelLocalService.deletePasswordPolicyRels(passwordPolicyId,
			className, classPKs);
	}

	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.getPasswordPolicyRel(className,
			classPK);
	}

	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		long passwordPolicyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.getPasswordPolicyRel(passwordPolicyId,
			className, classPK);
	}

	public boolean hasPasswordPolicyRel(long passwordPolicyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _passwordPolicyRelLocalService.hasPasswordPolicyRel(passwordPolicyId,
			className, classPK);
	}

	public PasswordPolicyRelLocalService getWrappedPasswordPolicyRelLocalService() {
		return _passwordPolicyRelLocalService;
	}

	public void setWrappedPasswordPolicyRelLocalService(
		PasswordPolicyRelLocalService passwordPolicyRelLocalService) {
		_passwordPolicyRelLocalService = passwordPolicyRelLocalService;
	}

	private PasswordPolicyRelLocalService _passwordPolicyRelLocalService;
}