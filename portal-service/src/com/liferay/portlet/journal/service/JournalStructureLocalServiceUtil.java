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

package com.liferay.portlet.journal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the journal structure local service. This utility wraps {@link com.liferay.portlet.journal.service.impl.JournalStructureLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalStructureLocalService
 * @see com.liferay.portlet.journal.service.base.JournalStructureLocalServiceBaseImpl
 * @see com.liferay.portlet.journal.service.impl.JournalStructureLocalServiceImpl
 * @generated
 */
public class JournalStructureLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.journal.service.impl.JournalStructureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the journal structure to the database. Also notifies the appropriate model listeners.
	*
	* @param journalStructure the journal structure to add
	* @return the journal structure that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalStructure addJournalStructure(
		com.liferay.portlet.journal.model.JournalStructure journalStructure)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJournalStructure(journalStructure);
	}

	/**
	* Creates a new journal structure with the primary key. Does not add the journal structure to the database.
	*
	* @param id the primary key for the new journal structure
	* @return the new journal structure
	*/
	public static com.liferay.portlet.journal.model.JournalStructure createJournalStructure(
		long id) {
		return getService().createJournalStructure(id);
	}

	/**
	* Deletes the journal structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the journal structure to delete
	* @throws PortalException if a journal structure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJournalStructure(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJournalStructure(id);
	}

	/**
	* Deletes the journal structure from the database. Also notifies the appropriate model listeners.
	*
	* @param journalStructure the journal structure to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJournalStructure(
		com.liferay.portlet.journal.model.JournalStructure journalStructure)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJournalStructure(journalStructure);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the journal structure with the primary key.
	*
	* @param id the primary key of the journal structure to get
	* @return the journal structure
	* @throws PortalException if a journal structure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalStructure getJournalStructure(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalStructure(id);
	}

	/**
	* Gets the journal structure with the UUID and group id.
	*
	* @param uuid the UUID of journal structure to get
	* @param groupId the group id of the journal structure to get
	* @return the journal structure
	* @throws PortalException if a journal structure with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalStructure getJournalStructureByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalStructureByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Gets a range of all the journal structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of journal structures to return
	* @param end the upper bound of the range of journal structures to return (not inclusive)
	* @return the range of journal structures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> getJournalStructures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalStructures(start, end);
	}

	/**
	* Gets the number of journal structures.
	*
	* @return the number of journal structures
	* @throws SystemException if a system exception occurred
	*/
	public static int getJournalStructuresCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJournalStructuresCount();
	}

	/**
	* Updates the journal structure in the database. Also notifies the appropriate model listeners.
	*
	* @param journalStructure the journal structure to update
	* @return the journal structure that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalStructure updateJournalStructure(
		com.liferay.portlet.journal.model.JournalStructure journalStructure)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJournalStructure(journalStructure);
	}

	/**
	* Updates the journal structure in the database. Also notifies the appropriate model listeners.
	*
	* @param journalStructure the journal structure to update
	* @param merge whether to merge the journal structure with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the journal structure that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.journal.model.JournalStructure updateJournalStructure(
		com.liferay.portlet.journal.model.JournalStructure journalStructure,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJournalStructure(journalStructure, merge);
	}

	public static com.liferay.portlet.journal.model.JournalStructure addStructure(
		long userId, long groupId, java.lang.String structureId,
		boolean autoStructureId, java.lang.String parentStructureId,
		java.lang.String name, java.lang.String description,
		java.lang.String xsd,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addStructure(userId, groupId, structureId, autoStructureId,
			parentStructureId, name, description, xsd, serviceContext);
	}

	public static void addStructureResources(
		com.liferay.portlet.journal.model.JournalStructure structure,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addStructureResources(structure, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addStructureResources(
		com.liferay.portlet.journal.model.JournalStructure structure,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addStructureResources(structure, communityPermissions,
			guestPermissions);
	}

	public static void addStructureResources(long groupId,
		java.lang.String structureId, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addStructureResources(groupId, structureId,
			addCommunityPermissions, addGuestPermissions);
	}

	public static void addStructureResources(long groupId,
		java.lang.String structureId, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addStructureResources(groupId, structureId, communityPermissions,
			guestPermissions);
	}

	public static void checkNewLine(long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkNewLine(groupId, structureId);
	}

	public static com.liferay.portlet.journal.model.JournalStructure copyStructure(
		long userId, long groupId, java.lang.String oldStructureId,
		java.lang.String newStructureId, boolean autoStructureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .copyStructure(userId, groupId, oldStructureId,
			newStructureId, autoStructureId);
	}

	public static void deleteStructure(
		com.liferay.portlet.journal.model.JournalStructure structure)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStructure(structure);
	}

	public static void deleteStructure(long groupId,
		java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStructure(groupId, structureId);
	}

	public static void deleteStructures(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStructures(groupId);
	}

	public static com.liferay.portlet.journal.model.JournalStructure getStructure(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructure(id);
	}

	public static com.liferay.portlet.journal.model.JournalStructure getStructure(
		long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructure(groupId, structureId);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> getStructures()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructures();
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> getStructures(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructures(groupId);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> getStructures(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructures(groupId, start, end);
	}

	public static int getStructuresCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructuresCount(groupId);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> search(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, groupId, keywords, start, end, obc);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalStructure> search(
		long companyId, long groupId, java.lang.String structureId,
		java.lang.String name, java.lang.String description,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, structureId, name, description,
			andOperator, start, end, obc);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(companyId, groupId, keywords);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchCount(companyId, groupId, structureId, name,
			description, andOperator);
	}

	public static com.liferay.portlet.journal.model.JournalStructure updateStructure(
		long groupId, java.lang.String structureId,
		java.lang.String parentStructureId, java.lang.String name,
		java.lang.String description, java.lang.String xsd,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStructure(groupId, structureId, parentStructureId,
			name, description, xsd, serviceContext);
	}

	public static JournalStructureLocalService getService() {
		if (_service == null) {
			_service = (JournalStructureLocalService)PortalBeanLocatorUtil.locate(JournalStructureLocalService.class.getName());

			ReferenceRegistry.registerReference(JournalStructureLocalServiceUtil.class,
				"_service");
			MethodCache.remove(JournalStructureLocalService.class);
		}

		return _service;
	}

	public void setService(JournalStructureLocalService service) {
		MethodCache.remove(JournalStructureLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(JournalStructureLocalServiceUtil.class,
			"_service");
		MethodCache.remove(JournalStructureLocalService.class);
	}

	private static JournalStructureLocalService _service;
}