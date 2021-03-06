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

package com.liferay.portlet.imagegallery.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import com.liferay.portlet.imagegallery.service.IGFolderServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portlet.imagegallery.service.IGFolderServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portlet.imagegallery.model.IGFolderSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portlet.imagegallery.model.IGFolder}, that is translated to a
 * {@link com.liferay.portlet.imagegallery.model.IGFolderSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <b>tunnel.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       IGFolderServiceHttp
 * @see       com.liferay.portlet.imagegallery.model.IGFolderSoap
 * @see       com.liferay.portlet.imagegallery.service.IGFolderServiceUtil
 * @generated
 */
public class IGFolderServiceSoap {
	public static com.liferay.portlet.imagegallery.model.IGFolderSoap addFolder(
		long parentFolderId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.addFolder(parentFolderId,
					name, description, serviceContext);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap copyFolder(
		long sourceFolderId, long parentFolderId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.copyFolder(sourceFolderId,
					parentFolderId, name, description, serviceContext);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteFolder(long folderId) throws RemoteException {
		try {
			IGFolderServiceUtil.deleteFolder(folderId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap getFolder(
		long folderId) throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.getFolder(folderId);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap getFolder(
		long groupId, long parentFolderId, java.lang.String name)
		throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.getFolder(groupId,
					parentFolderId, name);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap[] getFolders(
		long groupId, long parentFolderId) throws RemoteException {
		try {
			java.util.List<com.liferay.portlet.imagegallery.model.IGFolder> returnValue =
				IGFolderServiceUtil.getFolders(groupId, parentFolderId);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap[] getFolders(
		long groupId, long parentFolderId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portlet.imagegallery.model.IGFolder> returnValue =
				IGFolderServiceUtil.getFolders(groupId, parentFolderId, start,
					end);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getFoldersCount(long groupId, long parentFolderId)
		throws RemoteException {
		try {
			int returnValue = IGFolderServiceUtil.getFoldersCount(groupId,
					parentFolderId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void getSubfolderIds(Long[] folderIds, long groupId,
		long folderId) throws RemoteException {
		try {
			IGFolderServiceUtil.getSubfolderIds(ListUtil.toList(folderIds),
				groupId, folderId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.imagegallery.model.IGFolderSoap updateFolder(
		long folderId, long parentFolderId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentFolder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.imagegallery.model.IGFolder returnValue = IGFolderServiceUtil.updateFolder(folderId,
					parentFolderId, name, description, mergeWithParentFolder,
					serviceContext);

			return com.liferay.portlet.imagegallery.model.IGFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(IGFolderServiceSoap.class);
}