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

package com.liferay.portal.service.persistence;

import com.liferay.portal.model.Ticket;

/**
 * The persistence interface for the ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketPersistenceImpl
 * @see TicketUtil
 * @generated
 */
public interface TicketPersistence extends BasePersistence<Ticket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketUtil} to access the ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ticket in the entity cache if it is enabled.
	*
	* @param ticket the ticket to cache
	*/
	public void cacheResult(com.liferay.portal.model.Ticket ticket);

	/**
	* Caches the tickets in the entity cache if it is enabled.
	*
	* @param tickets the tickets to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.Ticket> tickets);

	/**
	* Creates a new ticket with the primary key. Does not add the ticket to the database.
	*
	* @param ticketId the primary key for the new ticket
	* @return the new ticket
	*/
	public com.liferay.portal.model.Ticket create(long ticketId);

	/**
	* Removes the ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ticketId the primary key of the ticket to remove
	* @return the ticket that was removed
	* @throws com.liferay.portal.NoSuchTicketException if a ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket remove(long ticketId)
		throws com.liferay.portal.NoSuchTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Ticket updateImpl(
		com.liferay.portal.model.Ticket ticket, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ticket with the primary key or throws a {@link com.liferay.portal.NoSuchTicketException} if it could not be found.
	*
	* @param ticketId the primary key of the ticket to find
	* @return the ticket
	* @throws com.liferay.portal.NoSuchTicketException if a ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket findByPrimaryKey(long ticketId)
		throws com.liferay.portal.NoSuchTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ticket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ticketId the primary key of the ticket to find
	* @return the ticket, or <code>null</code> if a ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket fetchByPrimaryKey(long ticketId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ticket where key = &#63; or throws a {@link com.liferay.portal.NoSuchTicketException} if it could not be found.
	*
	* @param key the key to search with
	* @return the matching ticket
	* @throws com.liferay.portal.NoSuchTicketException if a matching ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket findByKey(java.lang.String key)
		throws com.liferay.portal.NoSuchTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ticket where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key to search with
	* @return the matching ticket, or <code>null</code> if a matching ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket fetchByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ticket where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key to search with
	* @return the matching ticket, or <code>null</code> if a matching ticket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket fetchByKey(java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the tickets.
	*
	* @return the tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Ticket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tickets to return
	* @param end the upper bound of the range of tickets to return (not inclusive)
	* @return the range of tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Ticket> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tickets to return
	* @param end the upper bound of the range of tickets to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of tickets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Ticket> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ticket where key = &#63; from the database.
	*
	* @param key the key to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByKey(java.lang.String key)
		throws com.liferay.portal.NoSuchTicketException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tickets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the tickets where key = &#63;.
	*
	* @param key the key to search with
	* @return the number of matching tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the tickets.
	*
	* @return the number of tickets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}