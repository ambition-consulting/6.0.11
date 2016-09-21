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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the message boards thread remote service. This utility wraps {@link com.liferay.portlet.messageboards.service.impl.MBThreadServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBThreadService
 * @see com.liferay.portlet.messageboards.service.base.MBThreadServiceBaseImpl
 * @see com.liferay.portlet.messageboards.service.impl.MBThreadServiceImpl
 * @generated
 */
public class MBThreadServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.messageboards.service.impl.MBThreadServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void deleteThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThread(threadId);
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, boolean subscribed,
		boolean includeAnonymous, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupThreads(groupId, userId, status, subscribed,
			includeAnonymous, start, end);
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, boolean subscribed, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupThreads(groupId, userId, status, subscribed, start,
			end);
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupThreads(groupId, userId, status, start, end);
	}

	public static int getGroupThreadsCount(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupThreadsCount(groupId, userId, status);
	}

	public static int getGroupThreadsCount(long groupId, long userId,
		int status, boolean subscribed)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupThreadsCount(groupId, userId, status, subscribed);
	}

	public static int getGroupThreadsCount(long groupId, long userId,
		int status, boolean subscribed, boolean includeAnonymous)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupThreadsCount(groupId, userId, status, subscribed,
			includeAnonymous);
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getThreads(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThreads(groupId, categoryId, status, start, end);
	}

	public static int getThreadsCount(long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThreadsCount(groupId, categoryId, status);
	}

	public static com.liferay.portal.model.Lock lockThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().lockThread(threadId);
	}

	public static com.liferay.portlet.messageboards.model.MBThread moveThread(
		long categoryId, long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().moveThread(categoryId, threadId);
	}

	public static com.liferay.portlet.messageboards.model.MBThread splitThread(
		long messageId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().splitThread(messageId, serviceContext);
	}

	public static void unlockThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unlockThread(threadId);
	}

	public static MBThreadService getService() {
		if (_service == null) {
			_service = (MBThreadService)PortalBeanLocatorUtil.locate(MBThreadService.class.getName());

			ReferenceRegistry.registerReference(MBThreadServiceUtil.class,
				"_service");
			MethodCache.remove(MBThreadService.class);
		}

		return _service;
	}

	public void setService(MBThreadService service) {
		MethodCache.remove(MBThreadService.class);

		_service = service;

		ReferenceRegistry.registerReference(MBThreadServiceUtil.class,
			"_service");
		MethodCache.remove(MBThreadService.class);
	}

	private static MBThreadService _service;
}