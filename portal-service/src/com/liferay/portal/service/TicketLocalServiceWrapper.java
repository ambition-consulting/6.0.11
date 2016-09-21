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
 * This class is a wrapper for {@link TicketLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TicketLocalService
 * @generated
 */
public class TicketLocalServiceWrapper implements TicketLocalService {
	public TicketLocalServiceWrapper(TicketLocalService ticketLocalService) {
		_ticketLocalService = ticketLocalService;
	}

	/**
	* Adds the ticket to the database. Also notifies the appropriate model listeners.
	*
	* @param ticket the ticket to add
	* @return the ticket that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket addTicket(
		com.liferay.portal.model.Ticket ticket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.addTicket(ticket);
	}

	/**
	* Creates a new ticket with the primary key. Does not add the ticket to the database.
	*
	* @param ticketId the primary key for the new ticket
	* @return the new ticket
	*/
	public com.liferay.portal.model.Ticket createTicket(long ticketId) {
		return _ticketLocalService.createTicket(ticketId);
	}

	/**
	* Deletes the ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ticketId the primary key of the ticket to delete
	* @throws PortalException if a ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTicket(long ticketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ticketLocalService.deleteTicket(ticketId);
	}

	/**
	* Deletes the ticket from the database. Also notifies the appropriate model listeners.
	*
	* @param ticket the ticket to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTicket(com.liferay.portal.model.Ticket ticket)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ticketLocalService.deleteTicket(ticket);
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
		return _ticketLocalService.dynamicQuery(dynamicQuery);
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
		return _ticketLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ticketLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _ticketLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the ticket with the primary key.
	*
	* @param ticketId the primary key of the ticket to get
	* @return the ticket
	* @throws PortalException if a ticket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket getTicket(long ticketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.getTicket(ticketId);
	}

	/**
	* Gets a range of all the tickets.
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
	public java.util.List<com.liferay.portal.model.Ticket> getTickets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.getTickets(start, end);
	}

	/**
	* Gets the number of tickets.
	*
	* @return the number of tickets
	* @throws SystemException if a system exception occurred
	*/
	public int getTicketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.getTicketsCount();
	}

	/**
	* Updates the ticket in the database. Also notifies the appropriate model listeners.
	*
	* @param ticket the ticket to update
	* @return the ticket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket updateTicket(
		com.liferay.portal.model.Ticket ticket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.updateTicket(ticket);
	}

	/**
	* Updates the ticket in the database. Also notifies the appropriate model listeners.
	*
	* @param ticket the ticket to update
	* @param merge whether to merge the ticket with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ticket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Ticket updateTicket(
		com.liferay.portal.model.Ticket ticket, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.updateTicket(ticket, merge);
	}

	public com.liferay.portal.model.Ticket addTicket(long companyId,
		java.lang.String className, long classPK,
		java.util.Date expirationDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.addTicket(companyId, className, classPK,
			expirationDate, serviceContext);
	}

	public com.liferay.portal.model.Ticket getTicket(java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ticketLocalService.getTicket(key);
	}

	public TicketLocalService getWrappedTicketLocalService() {
		return _ticketLocalService;
	}

	public void setWrappedTicketLocalService(
		TicketLocalService ticketLocalService) {
		_ticketLocalService = ticketLocalService;
	}

	private TicketLocalService _ticketLocalService;
}