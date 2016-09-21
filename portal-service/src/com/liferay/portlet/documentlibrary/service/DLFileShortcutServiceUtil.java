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

package com.liferay.portlet.documentlibrary.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the d l file shortcut remote service. This utility wraps {@link com.liferay.portlet.documentlibrary.service.impl.DLFileShortcutServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileShortcutService
 * @see com.liferay.portlet.documentlibrary.service.base.DLFileShortcutServiceBaseImpl
 * @see com.liferay.portlet.documentlibrary.service.impl.DLFileShortcutServiceImpl
 * @generated
 */
public class DLFileShortcutServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.documentlibrary.service.impl.DLFileShortcutServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.documentlibrary.model.DLFileShortcut addFileShortcut(
		long groupId, long folderId, long toFileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFileShortcut(groupId, folderId, toFileEntryId,
			serviceContext);
	}

	public static void deleteFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFileShortcut(fileShortcutId);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFileShortcut getFileShortcut(
		long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileShortcut(fileShortcutId);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFileShortcut updateFileShortcut(
		long fileShortcutId, long folderId, long toFileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFileShortcut(fileShortcutId, folderId, toFileEntryId,
			serviceContext);
	}

	public static DLFileShortcutService getService() {
		if (_service == null) {
			_service = (DLFileShortcutService)PortalBeanLocatorUtil.locate(DLFileShortcutService.class.getName());

			ReferenceRegistry.registerReference(DLFileShortcutServiceUtil.class,
				"_service");
			MethodCache.remove(DLFileShortcutService.class);
		}

		return _service;
	}

	public void setService(DLFileShortcutService service) {
		MethodCache.remove(DLFileShortcutService.class);

		_service = service;

		ReferenceRegistry.registerReference(DLFileShortcutServiceUtil.class,
			"_service");
		MethodCache.remove(DLFileShortcutService.class);
	}

	private static DLFileShortcutService _service;
}