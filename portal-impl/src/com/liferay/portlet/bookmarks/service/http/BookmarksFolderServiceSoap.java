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

package com.liferay.portlet.bookmarks.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portlet.bookmarks.service.BookmarksFolderServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portlet.bookmarks.service.BookmarksFolderServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portlet.bookmarks.model.BookmarksFolderSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portlet.bookmarks.model.BookmarksFolder}, that is translated to a
 * {@link com.liferay.portlet.bookmarks.model.BookmarksFolderSoap}. Methods that SOAP cannot
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
 * @see       BookmarksFolderServiceHttp
 * @see       com.liferay.portlet.bookmarks.model.BookmarksFolderSoap
 * @see       com.liferay.portlet.bookmarks.service.BookmarksFolderServiceUtil
 * @generated
 */
public class BookmarksFolderServiceSoap {
	public static com.liferay.portlet.bookmarks.model.BookmarksFolderSoap addFolder(
		long parentFolderId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.bookmarks.model.BookmarksFolder returnValue = BookmarksFolderServiceUtil.addFolder(parentFolderId,
					name, description, serviceContext);

			return com.liferay.portlet.bookmarks.model.BookmarksFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteFolder(long folderId) throws RemoteException {
		try {
			BookmarksFolderServiceUtil.deleteFolder(folderId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.bookmarks.model.BookmarksFolderSoap getFolder(
		long folderId) throws RemoteException {
		try {
			com.liferay.portlet.bookmarks.model.BookmarksFolder returnValue = BookmarksFolderServiceUtil.getFolder(folderId);

			return com.liferay.portlet.bookmarks.model.BookmarksFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.bookmarks.model.BookmarksFolderSoap updateFolder(
		long folderId, long parentFolderId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentFolder,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.bookmarks.model.BookmarksFolder returnValue = BookmarksFolderServiceUtil.updateFolder(folderId,
					parentFolderId, name, description, mergeWithParentFolder,
					serviceContext);

			return com.liferay.portlet.bookmarks.model.BookmarksFolderSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BookmarksFolderServiceSoap.class);
}