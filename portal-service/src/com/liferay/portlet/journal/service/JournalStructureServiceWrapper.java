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

/**
 * <p>
 * This class is a wrapper for {@link JournalStructureService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JournalStructureService
 * @generated
 */
public class JournalStructureServiceWrapper implements JournalStructureService {
	public JournalStructureServiceWrapper(
		JournalStructureService journalStructureService) {
		_journalStructureService = journalStructureService;
	}

	public com.liferay.portlet.journal.model.JournalStructure addStructure(
		long groupId, java.lang.String structureId, boolean autoStructureId,
		java.lang.String parentStructureId, java.lang.String name,
		java.lang.String description, java.lang.String xsd,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalStructureService.addStructure(groupId, structureId,
			autoStructureId, parentStructureId, name, description, xsd,
			serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalStructure copyStructure(
		long groupId, java.lang.String oldStructureId,
		java.lang.String newStructureId, boolean autoStructureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalStructureService.copyStructure(groupId, oldStructureId,
			newStructureId, autoStructureId);
	}

	public void deleteStructure(long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_journalStructureService.deleteStructure(groupId, structureId);
	}

	public com.liferay.portlet.journal.model.JournalStructure getStructure(
		long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalStructureService.getStructure(groupId, structureId);
	}

	public com.liferay.portlet.journal.model.JournalStructure updateStructure(
		long groupId, java.lang.String structureId,
		java.lang.String parentStructureId, java.lang.String name,
		java.lang.String description, java.lang.String xsd,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalStructureService.updateStructure(groupId, structureId,
			parentStructureId, name, description, xsd, serviceContext);
	}

	public JournalStructureService getWrappedJournalStructureService() {
		return _journalStructureService;
	}

	public void setWrappedJournalStructureService(
		JournalStructureService journalStructureService) {
		_journalStructureService = journalStructureService;
	}

	private JournalStructureService _journalStructureService;
}