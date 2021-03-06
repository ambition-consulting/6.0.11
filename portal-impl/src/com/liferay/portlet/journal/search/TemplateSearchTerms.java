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

package com.liferay.portlet.journal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class TemplateSearchTerms extends TemplateDisplayTerms {

	public TemplateSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		description = DAOParamUtil.getLike(portletRequest, DESCRIPTION);
		groupId = ParamUtil.getLong(
			portletRequest, GROUP_ID, themeDisplay.getScopeGroupId());
		name = DAOParamUtil.getLike(portletRequest, NAME);
		structureId = DAOParamUtil.getString(portletRequest, STRUCTURE_ID);
		templateId = DAOParamUtil.getLike(portletRequest, TEMPLATE_ID);
	}

	public String getStructureIdComparator() {
		return structureIdComparator;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public void setStructureId(String structureId) {
		this.structureId = structureId;
	}

	public void setStructureIdComparator(String structureIdComparator) {
		this.structureIdComparator = structureIdComparator;
	}

	protected String structureIdComparator;

}