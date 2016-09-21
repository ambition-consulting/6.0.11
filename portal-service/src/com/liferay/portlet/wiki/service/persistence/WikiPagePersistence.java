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

package com.liferay.portlet.wiki.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.wiki.model.WikiPage;

/**
 * The persistence interface for the wiki page service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPagePersistenceImpl
 * @see WikiPageUtil
 * @generated
 */
public interface WikiPagePersistence extends BasePersistence<WikiPage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WikiPageUtil} to access the wiki page persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the wiki page in the entity cache if it is enabled.
	*
	* @param wikiPage the wiki page to cache
	*/
	public void cacheResult(com.liferay.portlet.wiki.model.WikiPage wikiPage);

	/**
	* Caches the wiki pages in the entity cache if it is enabled.
	*
	* @param wikiPages the wiki pages to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.wiki.model.WikiPage> wikiPages);

	/**
	* Creates a new wiki page with the primary key. Does not add the wiki page to the database.
	*
	* @param pageId the primary key for the new wiki page
	* @return the new wiki page
	*/
	public com.liferay.portlet.wiki.model.WikiPage create(long pageId);

	/**
	* Removes the wiki page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pageId the primary key of the wiki page to remove
	* @return the wiki page that was removed
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage remove(long pageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	public com.liferay.portlet.wiki.model.WikiPage updateImpl(
		com.liferay.portlet.wiki.model.WikiPage wikiPage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the wiki page with the primary key or throws a {@link com.liferay.portlet.wiki.NoSuchPageException} if it could not be found.
	*
	* @param pageId the primary key of the wiki page to find
	* @return the wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByPrimaryKey(long pageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pageId the primary key of the wiki page to find
	* @return the wiki page, or <code>null</code> if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByPrimaryKey(
		long pageId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the wiki pages where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByUuid_PrevAndNext(
		long pageId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.wiki.NoSuchPageException} if it could not be found.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the wiki page where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the wiki pages where nodeId = &#63;.
	*
	* @param nodeId the node id to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByNodeId(
		long nodeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByNodeId(
		long nodeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByNodeId(
		long nodeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByNodeId_First(
		long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByNodeId_Last(
		long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByNodeId_PrevAndNext(
		long pageId, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where format = &#63;.
	*
	* @param format the format to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByFormat(
		java.lang.String format)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where format = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param format the format to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByFormat(
		java.lang.String format, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where format = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param format the format to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByFormat(
		java.lang.String format, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where format = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param format the format to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByFormat_First(
		java.lang.String format,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where format = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param format the format to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByFormat_Last(
		java.lang.String format,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where format = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param format the format to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByFormat_PrevAndNext(
		long pageId, java.lang.String format,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N(
		long resourcePrimKey, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N(
		long resourcePrimKey, long nodeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N(
		long resourcePrimKey, long nodeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByR_N_First(
		long resourcePrimKey, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByR_N_Last(
		long resourcePrimKey, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByR_N_PrevAndNext(
		long pageId, long resourcePrimKey, long nodeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and title = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T(
		long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T(
		long nodeId, java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T(
		long nodeId, java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_First(
		long nodeId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_Last(long nodeId,
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_T_PrevAndNext(
		long pageId, long nodeId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and head = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H(
		long nodeId, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H(
		long nodeId, boolean head, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H(
		long nodeId, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_First(
		long nodeId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_Last(long nodeId,
		boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_H_PrevAndNext(
		long pageId, long nodeId, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and parentTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_P(
		long nodeId, java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_P(
		long nodeId, java.lang.String parentTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_P(
		long nodeId, java.lang.String parentTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_P_First(
		long nodeId, java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_P_Last(long nodeId,
		java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_P_PrevAndNext(
		long pageId, long nodeId, java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and redirectTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_R(
		long nodeId, java.lang.String redirectTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and redirectTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_R(
		long nodeId, java.lang.String redirectTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and redirectTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_R(
		long nodeId, java.lang.String redirectTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and redirectTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_R_First(
		long nodeId, java.lang.String redirectTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and redirectTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_R_Last(long nodeId,
		java.lang.String redirectTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and redirectTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_R_PrevAndNext(
		long pageId, long nodeId, java.lang.String redirectTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_S(
		long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_S(
		long nodeId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_S(
		long nodeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_S_First(
		long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_S_Last(long nodeId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_S_PrevAndNext(
		long pageId, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where resourcePrimKey = &#63; and nodeId = &#63; and version = &#63; or throws a {@link com.liferay.portlet.wiki.NoSuchPageException} if it could not be found.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param version the version to search with
	* @return the matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByR_N_V(
		long resourcePrimKey, long nodeId, double version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where resourcePrimKey = &#63; and nodeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param version the version to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByR_N_V(
		long resourcePrimKey, long nodeId, double version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the wiki page where resourcePrimKey = &#63; and nodeId = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param version the version to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByR_N_V(
		long resourcePrimKey, long nodeId, double version,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N_S(
		long resourcePrimKey, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N_S(
		long resourcePrimKey, long nodeId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByR_N_S(
		long resourcePrimKey, long nodeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByR_N_S_First(
		long resourcePrimKey, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByR_N_S_Last(
		long resourcePrimKey, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByR_N_S_PrevAndNext(
		long pageId, long resourcePrimKey, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByU_N_S(
		long userId, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByU_N_S(
		long userId, long nodeId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByU_N_S(
		long userId, long nodeId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByU_N_S_First(
		long userId, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByU_N_S_Last(
		long userId, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByU_N_S_PrevAndNext(
		long pageId, long userId, long nodeId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where nodeId = &#63; and title = &#63; and version = &#63; or throws a {@link com.liferay.portlet.wiki.NoSuchPageException} if it could not be found.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param version the version to search with
	* @return the matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_V(long nodeId,
		java.lang.String title, double version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki page where nodeId = &#63; and title = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param version the version to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByN_T_V(long nodeId,
		java.lang.String title, double version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the wiki page where nodeId = &#63; and title = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param version the version to search with
	* @return the matching wiki page, or <code>null</code> if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage fetchByN_T_V(long nodeId,
		java.lang.String title, double version, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_H(
		long nodeId, java.lang.String title, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_H(
		long nodeId, java.lang.String title, boolean head, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_H(
		long nodeId, java.lang.String title, boolean head, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_H_First(
		long nodeId, java.lang.String title, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_H_Last(
		long nodeId, java.lang.String title, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_T_H_PrevAndNext(
		long pageId, long nodeId, java.lang.String title, boolean head,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_S(
		long nodeId, java.lang.String title, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_S(
		long nodeId, java.lang.String title, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_T_S(
		long nodeId, java.lang.String title, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_S_First(
		long nodeId, java.lang.String title, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_T_S_Last(
		long nodeId, java.lang.String title, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_T_S_PrevAndNext(
		long pageId, long nodeId, java.lang.String title, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P(
		long nodeId, boolean head, java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P(
		long nodeId, boolean head, java.lang.String parentTitle, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P(
		long nodeId, boolean head, java.lang.String parentTitle, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_P_First(
		long nodeId, boolean head, java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_P_Last(
		long nodeId, boolean head, java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_H_P_PrevAndNext(
		long pageId, long nodeId, boolean head, java.lang.String parentTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_S(
		long nodeId, boolean head, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_S(
		long nodeId, boolean head, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_S(
		long nodeId, boolean head, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_S_First(
		long nodeId, boolean head, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_S_Last(
		long nodeId, boolean head, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_H_S_PrevAndNext(
		long pageId, long nodeId, boolean head, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @return the matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P_S(
		long nodeId, boolean head, java.lang.String parentTitle, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P_S(
		long nodeId, boolean head, java.lang.String parentTitle, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findByN_H_P_S(
		long nodeId, boolean head, java.lang.String parentTitle, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_P_S_First(
		long nodeId, boolean head, java.lang.String parentTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the last wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a matching wiki page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage findByN_H_P_S_Last(
		long nodeId, boolean head, java.lang.String parentTitle, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds the wiki pages before and after the current wiki page in the ordered set where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pageId the primary key of the current wiki page
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next wiki page
	* @throws com.liferay.portlet.wiki.NoSuchPageException if a wiki page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.wiki.model.WikiPage[] findByN_H_P_S_PrevAndNext(
		long pageId, long nodeId, boolean head, java.lang.String parentTitle,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Finds all the wiki pages.
	*
	* @return the wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the wiki pages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @return the range of wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the wiki pages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wiki pages to return
	* @param end the upper bound of the range of wiki pages to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.wiki.model.WikiPage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the wiki page where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Removes all the wiki pages where nodeId = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNodeId(long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where format = &#63; from the database.
	*
	* @param format the format to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFormat(java.lang.String format)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_N(long resourcePrimKey, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and title = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_T(long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and head = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_H(long nodeId, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and parentTitle = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_P(long nodeId, java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and redirectTitle = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_R(long nodeId, java.lang.String redirectTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and status = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_S(long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the wiki page where resourcePrimKey = &#63; and nodeId = &#63; and version = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param version the version to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_N_V(long resourcePrimKey, long nodeId, double version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Removes all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_N_S(long resourcePrimKey, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where userId = &#63; and nodeId = &#63; and status = &#63; from the database.
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_N_S(long userId, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the wiki page where nodeId = &#63; and title = &#63; and version = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param version the version to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_T_V(long nodeId, java.lang.String title,
		double version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.wiki.NoSuchPageException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and title = &#63; and head = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_T_H(long nodeId, java.lang.String title, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and title = &#63; and status = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_T_S(long nodeId, java.lang.String title, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_H_P(long nodeId, boolean head,
		java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and head = &#63; and status = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_H_S(long nodeId, boolean head, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63; from the database.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_H_P_S(long nodeId, boolean head,
		java.lang.String parentTitle, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wiki pages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid to search with
	* @param groupId the group id to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63;.
	*
	* @param nodeId the node id to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByNodeId(long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where format = &#63;.
	*
	* @param format the format to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByFormat(java.lang.String format)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63;.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_N(long resourcePrimKey, long nodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and title = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_T(long nodeId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and head = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_H(long nodeId, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and parentTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param parentTitle the parent title to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_P(long nodeId, java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and redirectTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param redirectTitle the redirect title to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_R(long nodeId, java.lang.String redirectTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_S(long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and version = &#63;.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param version the version to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_N_V(long resourcePrimKey, long nodeId, double version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where resourcePrimKey = &#63; and nodeId = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_N_S(long resourcePrimKey, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where userId = &#63; and nodeId = &#63; and status = &#63;.
	*
	* @param userId the user id to search with
	* @param nodeId the node id to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_N_S(long userId, long nodeId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and title = &#63; and version = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param version the version to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_T_V(long nodeId, java.lang.String title, double version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and title = &#63; and head = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param head the head to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_T_H(long nodeId, java.lang.String title, boolean head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and title = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param title the title to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_T_S(long nodeId, java.lang.String title, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_H_P(long nodeId, boolean head,
		java.lang.String parentTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and head = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_H_S(long nodeId, boolean head, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages where nodeId = &#63; and head = &#63; and parentTitle = &#63; and status = &#63;.
	*
	* @param nodeId the node id to search with
	* @param head the head to search with
	* @param parentTitle the parent title to search with
	* @param status the status to search with
	* @return the number of matching wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_H_P_S(long nodeId, boolean head,
		java.lang.String parentTitle, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the wiki pages.
	*
	* @return the number of wiki pages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}