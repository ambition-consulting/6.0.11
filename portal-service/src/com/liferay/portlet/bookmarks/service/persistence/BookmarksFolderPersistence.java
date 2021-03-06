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

package com.liferay.portlet.bookmarks.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.bookmarks.model.BookmarksFolder;

/**
 * The persistence interface for the bookmarks folder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookmarksFolderPersistenceImpl
 * @see BookmarksFolderUtil
 * @generated
 */
public interface BookmarksFolderPersistence extends BasePersistence<BookmarksFolder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookmarksFolderUtil} to access the bookmarks folder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bookmarks folder in the entity cache if it is enabled.
	*
	* @param bookmarksFolder the bookmarks folder to cache
	*/
	public void cacheResult(
		com.liferay.portlet.bookmarks.model.BookmarksFolder bookmarksFolder);

	/**
	* Caches the bookmarks folders in the entity cache if it is enabled.
	*
	* @param bookmarksFolders the bookmarks folders to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> bookmarksFolders);

	/**
	* Creates a new bookmarks folder with the primary key. Does not add the bookmarks folder to the database.
	*
	* @param folderId the primary key for the new bookmarks folder
	* @return the new bookmarks folder
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder create(
		long folderId);

	/**
	* Removes the bookmarks folder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param folderId the primary key of the bookmarks folder to remove
	* @return the bookmarks folder that was removed
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder remove(
		long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	public com.liferay.portlet.bookmarks.model.BookmarksFolder updateImpl(
		com.liferay.portlet.bookmarks.model.BookmarksFolder bookmarksFolder,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the bookmarks folder with the primary key or throws a {@link com.liferay.portlet.bookmarks.NoSuchFolderException} if it could not be found.
	*
	* @param folderId the primary key of the bookmarks folder to find
	* @return the bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByPrimaryKey(
		long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folder with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param folderId the primary key of the bookmarks folder to find
	* @return the bookmarks folder, or <code>null</code> if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder fetchByPrimaryKey(
		long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the bookmarks folders where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the bookmarks folders where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the bookmarks folders where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first bookmarks folder in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the last bookmarks folder in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folders before and after the current bookmarks folder in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current bookmarks folder
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder[] findByUuid_PrevAndNext(
		long folderId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folder where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.bookmarks.NoSuchFolderException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching bookmarks folder, or <code>null</code> if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the bookmarks folder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching bookmarks folder, or <code>null</code> if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the bookmarks folders where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the bookmarks folders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the bookmarks folders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first bookmarks folder in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the last bookmarks folder in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folders before and after the current bookmarks folder in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current bookmarks folder
	* @param groupId the group id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder[] findByGroupId_PrevAndNext(
		long folderId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Filters by the user's permissions and finds all the bookmarks folders where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the bookmarks folders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the bookmarks folders where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the bookmarks folders where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the bookmarks folders where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the bookmarks folders where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first bookmarks folder in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the last bookmarks folder in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folders before and after the current bookmarks folder in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current bookmarks folder
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder[] findByCompanyId_PrevAndNext(
		long folderId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @return the matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByG_P(
		long groupId, long parentFolderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByG_P(
		long groupId, long parentFolderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findByG_P(
		long groupId, long parentFolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first bookmarks folder in the ordered set where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByG_P_First(
		long groupId, long parentFolderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the last bookmarks folder in the ordered set where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a matching bookmarks folder could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder findByG_P_Last(
		long groupId, long parentFolderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Finds the bookmarks folders before and after the current bookmarks folder in the ordered set where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current bookmarks folder
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next bookmarks folder
	* @throws com.liferay.portlet.bookmarks.NoSuchFolderException if a bookmarks folder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.bookmarks.model.BookmarksFolder[] findByG_P_PrevAndNext(
		long folderId, long groupId, long parentFolderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Filters by the user's permissions and finds all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @return the matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByG_P(
		long groupId, long parentFolderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByG_P(
		long groupId, long parentFolderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> filterFindByG_P(
		long groupId, long parentFolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the bookmarks folders.
	*
	* @return the bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the bookmarks folders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @return the range of bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the bookmarks folders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks folders to return
	* @param end the upper bound of the range of bookmarks folders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.bookmarks.model.BookmarksFolder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks folders where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bookmarks folder where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.bookmarks.NoSuchFolderException;

	/**
	* Removes all the bookmarks folders where groupId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks folders where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks folders where groupId = &#63; and parentFolderId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_P(long groupId, long parentFolderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks folders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the bookmarks folders where groupId = &#63;.
	*
	* @param groupId the group id to search with
	* @return the number of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @return the number of matching bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_P(long groupId, long parentFolderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the bookmarks folders where groupId = &#63; and parentFolderId = &#63;.
	*
	* @param groupId the group id to search with
	* @param parentFolderId the parent folder id to search with
	* @return the number of matching bookmarks folders that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_P(long groupId, long parentFolderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the bookmarks folders.
	*
	* @return the number of bookmarks folders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}