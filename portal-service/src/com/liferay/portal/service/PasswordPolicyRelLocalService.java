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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the password policy rel local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PasswordPolicyRelLocalServiceUtil
 * @see com.liferay.portal.service.base.PasswordPolicyRelLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.PasswordPolicyRelLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PasswordPolicyRelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PasswordPolicyRelLocalServiceUtil} to access the password policy rel local service. Add custom service methods to {@link com.liferay.portal.service.impl.PasswordPolicyRelLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the password policy rel to the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to add
	* @return the password policy rel that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel addPasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new password policy rel with the primary key. Does not add the password policy rel to the database.
	*
	* @param passwordPolicyRelId the primary key for the new password policy rel
	* @return the new password policy rel
	*/
	public com.liferay.portal.model.PasswordPolicyRel createPasswordPolicyRel(
		long passwordPolicyRelId);

	/**
	* Deletes the password policy rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to delete
	* @throws PortalException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePasswordPolicyRel(long passwordPolicyRelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the password policy rel from the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the password policy rel with the primary key.
	*
	* @param passwordPolicyRelId the primary key of the password policy rel to get
	* @return the password policy rel
	* @throws PortalException if a password policy rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		long passwordPolicyRelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.PasswordPolicyRel> getPasswordPolicyRels(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of password policy rels.
	*
	* @return the number of password policy rels
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPasswordPolicyRelsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the password policy rel in the database. Also notifies the appropriate model listeners.
	*
	* @param passwordPolicyRel the password policy rel to update
	* @return the password policy rel that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.PasswordPolicyRel updatePasswordPolicyRel(
		com.liferay.portal.model.PasswordPolicyRel passwordPolicyRel)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.PasswordPolicyRel addPasswordPolicyRel(
		long passwordPolicyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addPasswordPolicyRels(long passwordPolicyId,
		java.lang.String className, long[] classPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deletePasswordPolicyRel(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deletePasswordPolicyRel(long passwordPolicyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deletePasswordPolicyRels(long passwordPolicyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deletePasswordPolicyRels(long passwordPolicyId,
		java.lang.String className, long[] classPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PasswordPolicyRel getPasswordPolicyRel(
		long passwordPolicyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPasswordPolicyRel(long passwordPolicyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;
}