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
 * The utility for the journal template remote service. This utility wraps {@link com.liferay.portlet.journal.service.impl.JournalTemplateServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalTemplateService
 * @see com.liferay.portlet.journal.service.base.JournalTemplateServiceBaseImpl
 * @see com.liferay.portlet.journal.service.impl.JournalTemplateServiceImpl
 * @generated
 */
public class JournalTemplateServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.journal.service.impl.JournalTemplateServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portlet.journal.model.JournalTemplate addTemplate(
		long groupId, java.lang.String templateId, boolean autoTemplateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTemplate(groupId, templateId, autoTemplateId,
			structureId, name, description, xsl, formatXsl, langType,
			cacheable, serviceContext);
	}

	public static com.liferay.portlet.journal.model.JournalTemplate addTemplate(
		long groupId, java.lang.String templateId, boolean autoTemplateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTemplate(groupId, templateId, autoTemplateId,
			structureId, name, description, xsl, formatXsl, langType,
			cacheable, smallImage, smallImageURL, smallFile, serviceContext);
	}

	public static com.liferay.portlet.journal.model.JournalTemplate copyTemplate(
		long groupId, java.lang.String oldTemplateId,
		java.lang.String newTemplateId, boolean autoTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .copyTemplate(groupId, oldTemplateId, newTemplateId,
			autoTemplateId);
	}

	public static void deleteTemplate(long groupId, java.lang.String templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTemplate(groupId, templateId);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalTemplate> getStructureTemplates(
		long groupId, java.lang.String structureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStructureTemplates(groupId, structureId);
	}

	public static com.liferay.portlet.journal.model.JournalTemplate getTemplate(
		long groupId, java.lang.String templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTemplate(groupId, templateId);
	}

	public static com.liferay.portlet.journal.model.JournalTemplate updateTemplate(
		long groupId, java.lang.String templateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTemplate(groupId, templateId, structureId, name,
			description, xsl, formatXsl, langType, cacheable, serviceContext);
	}

	public static com.liferay.portlet.journal.model.JournalTemplate updateTemplate(
		long groupId, java.lang.String templateId,
		java.lang.String structureId, java.lang.String name,
		java.lang.String description, java.lang.String xsl, boolean formatXsl,
		java.lang.String langType, boolean cacheable, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTemplate(groupId, templateId, structureId, name,
			description, xsl, formatXsl, langType, cacheable, smallImage,
			smallImageURL, smallFile, serviceContext);
	}

	public static JournalTemplateService getService() {
		if (_service == null) {
			_service = (JournalTemplateService)PortalBeanLocatorUtil.locate(JournalTemplateService.class.getName());

			ReferenceRegistry.registerReference(JournalTemplateServiceUtil.class,
				"_service");
			MethodCache.remove(JournalTemplateService.class);
		}

		return _service;
	}

	public void setService(JournalTemplateService service) {
		MethodCache.remove(JournalTemplateService.class);

		_service = service;

		ReferenceRegistry.registerReference(JournalTemplateServiceUtil.class,
			"_service");
		MethodCache.remove(JournalTemplateService.class);
	}

	private static JournalTemplateService _service;
}