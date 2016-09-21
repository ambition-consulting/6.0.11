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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBThreadService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBThreadService
 * @generated
 */
public class MBThreadServiceWrapper implements MBThreadService {
	public MBThreadServiceWrapper(MBThreadService mbThreadService) {
		_mbThreadService = mbThreadService;
	}

	public void deleteThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbThreadService.deleteThread(threadId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, boolean subscribed,
		boolean includeAnonymous, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreads(groupId, userId, status,
			subscribed, includeAnonymous, start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, boolean subscribed, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreads(groupId, userId, status,
			subscribed, start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreads(groupId, userId, status, start,
			end);
	}

	public int getGroupThreadsCount(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreadsCount(groupId, userId, status);
	}

	public int getGroupThreadsCount(long groupId, long userId, int status,
		boolean subscribed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreadsCount(groupId, userId, status,
			subscribed);
	}

	public int getGroupThreadsCount(long groupId, long userId, int status,
		boolean subscribed, boolean includeAnonymous)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getGroupThreadsCount(groupId, userId, status,
			subscribed, includeAnonymous);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBThread> getThreads(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getThreads(groupId, categoryId, status, start,
			end);
	}

	public int getThreadsCount(long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.getThreadsCount(groupId, categoryId, status);
	}

	public com.liferay.portal.model.Lock lockThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.lockThread(threadId);
	}

	public com.liferay.portlet.messageboards.model.MBThread moveThread(
		long categoryId, long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.moveThread(categoryId, threadId);
	}

	public com.liferay.portlet.messageboards.model.MBThread splitThread(
		long messageId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbThreadService.splitThread(messageId, serviceContext);
	}

	public void unlockThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbThreadService.unlockThread(threadId);
	}

	public MBThreadService getWrappedMBThreadService() {
		return _mbThreadService;
	}

	public void setWrappedMBThreadService(MBThreadService mbThreadService) {
		_mbThreadService = mbThreadService;
	}

	private MBThreadService _mbThreadService;
}