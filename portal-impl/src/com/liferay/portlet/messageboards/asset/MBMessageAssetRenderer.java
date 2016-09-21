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

package com.liferay.portlet.messageboards.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.permission.MBDiscussionPermission;
import com.liferay.portlet.messageboards.service.permission.MBMessagePermission;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Julio Camarero
 * @author Juan Fernández
 */
public class MBMessageAssetRenderer extends BaseAssetRenderer {

	public MBMessageAssetRenderer(MBMessage message) {
		_message = message;
	}

	public long getClassPK() {
		return _message.getMessageId();
	}

	public long getGroupId() {
		return _message.getGroupId();
	}

	public String getSummary() {
		return HtmlUtil.stripHtml(_message.getBody());
	}

	public String getTitle() {
		return _message.getSubject();
	}

	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		PortletURL editPortletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.MESSAGE_BOARDS);

		editPortletURL.setParameter(
			"struts_action", "/message_boards/edit_message");
		editPortletURL.setParameter(
			"messageId", String.valueOf(_message.getMessageId()));

		return editPortletURL;
	}
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return themeDisplay.getPortalURL() + themeDisplay.getPathMain() +
			"/message_boards/find_message?messageId=" + _message.getMessageId();
	}

	public long getUserId() {
		return _message.getUserId();
	}

	public String getUuid() {
		return _message.getUuid();
	}

	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		if (_message.isDiscussion()) {
			return MBDiscussionPermission.contains(
				permissionChecker, _message.getCompanyId(),
				_message.getGroupId(), _message.getClassName(),
				_message.getClassPK(), _message.getMessageId(),
				_message.getUserId(), ActionKeys.UPDATE);
		}
		else {
			return MBMessagePermission.contains(
				permissionChecker, _message, ActionKeys.UPDATE);
		}
	}

	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {

		if (_message.isDiscussion()) {
			return MBDiscussionPermission.contains(
				permissionChecker, _message.getCompanyId(),
				_message.getGroupId(), _message.getClassName(),
				_message.getClassPK(), _message.getMessageId(),
				_message.getUserId(), ActionKeys.VIEW);
		}
		else {
			return MBMessagePermission.contains(
				permissionChecker, _message, ActionKeys.VIEW);
		}
	}

	public boolean isPrintable() {
		return true;
	}

	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String template)
		throws Exception {

		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			renderRequest.setAttribute(
				WebKeys.MESSAGE_BOARDS_MESSAGE, _message);

			return "/html/portlet/message_boards/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/conversation.png";
	}

	private MBMessage _message;

}