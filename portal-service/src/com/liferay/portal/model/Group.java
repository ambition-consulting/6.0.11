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

package com.liferay.portal.model;

/**
 * The model interface for the Group service. Represents a row in the &quot;Group_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.GroupImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupModel
 * @see com.liferay.portal.model.impl.GroupImpl
 * @see com.liferay.portal.model.impl.GroupModelImpl
 * @generated
 */
public interface Group extends GroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a group model instance should use the {@link Group} interface instead.
	 */
	public long getDefaultPrivatePlid();

	public long getDefaultPublicPlid();

	public java.lang.String getDescriptiveName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group getLiveGroup();

	public long getOrganizationId();

	public java.lang.String getPathFriendlyURL(boolean privateLayout,
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	public com.liferay.portal.model.LayoutSet getPrivateLayoutSet();

	public int getPrivateLayoutsPageCount();

	public com.liferay.portal.model.LayoutSet getPublicLayoutSet();

	public int getPublicLayoutsPageCount();

	public com.liferay.portal.model.Group getStagingGroup();

	public java.lang.String getTypeLabel();

	public java.lang.String getTypeSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getTypeSettingsProperties();

	public java.lang.String getTypeSettingsProperty(java.lang.String key);

	public java.lang.String getWorkflowRoleNames();

	public int getWorkflowStages();

	public boolean hasPrivateLayouts();

	public boolean hasPublicLayouts();

	public boolean hasStagingGroup();

	public boolean isCommunity();

	public boolean isCompany();

	public boolean isControlPanel();

	public boolean isLayout();

	public boolean isLayoutPrototype();

	public boolean isLayoutSetPrototype();

	public boolean isOrganization();

	public boolean isStaged();

	public boolean isStagedPortlet(java.lang.String portletId);

	public boolean isStagedRemotely();

	public boolean isStagingGroup();

	public boolean isUser();

	public boolean isUserGroup();

	public boolean isWorkflowEnabled();

	public void setTypeSettings(java.lang.String typeSettings);

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties);
}