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
 * This class is a wrapper for {@link JournalTemplateService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JournalTemplateService
 * @generated
 */
public class JournalTemplateServiceWrapper implements JournalTemplateService {
	public JournalTemplateServiceWrapper(
		JournalTemplateService journalTemplateService) {
		_journalTemplateService = journalTemplateService;
	}

	public com.liferay.portlet.journal.model.JournalTemplate addTemplate(
		long groupId, java.lang.String templateId, boolean autoTemplateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.addTemplate(groupId, templateId,
			autoTemplateId, structureId, name, description, xsl, formatXsl,
			langType, cacheable, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalTemplate addTemplate(
		long groupId, java.lang.String templateId, boolean autoTemplateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.addTemplate(groupId, templateId,
			autoTemplateId, structureId, name, description, xsl, formatXsl,
			langType, cacheable, smallImage, smallImageURL, smallFile,
			serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalTemplate copyTemplate(
		long groupId, java.lang.String oldTemplateId,
		java.lang.String newTemplateId, boolean autoTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.copyTemplate(groupId, oldTemplateId,
			newTemplateId, autoTemplateId);
	}

	public void deleteTemplate(long groupId, java.lang.String templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_journalTemplateService.deleteTemplate(groupId, templateId);
	}

	public java.util.List<com.liferay.portlet.journal.model.JournalTemplate> getStructureTemplates(
		long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.getStructureTemplates(groupId,
			structureId);
	}

	public com.liferay.portlet.journal.model.JournalTemplate getTemplate(
		long groupId, java.lang.String templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.getTemplate(groupId, templateId);
	}

	public com.liferay.portlet.journal.model.JournalTemplate updateTemplate(
		long groupId, java.lang.String templateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.updateTemplate(groupId, templateId,
			structureId, name, description, xsl, formatXsl, langType,
			cacheable, serviceContext);
	}

	public com.liferay.portlet.journal.model.JournalTemplate updateTemplate(
		long groupId, java.lang.String templateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _journalTemplateService.updateTemplate(groupId, templateId,
			structureId, name, description, xsl, formatXsl, langType,
			cacheable, smallImage, smallImageURL, smallFile, serviceContext);
	}

	public JournalTemplateService getWrappedJournalTemplateService() {
		return _journalTemplateService;
	}

	public void setWrappedJournalTemplateService(
		JournalTemplateService journalTemplateService) {
		_journalTemplateService = journalTemplateService;
	}

	private JournalTemplateService _journalTemplateService;
}