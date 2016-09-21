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

package com.liferay.portlet.messageboards.model;

/**
 * The model interface for the MBMessage service. Represents a row in the &quot;MBMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.messageboards.model.impl.MBMessageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBMessageModel
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageModelImpl
 * @generated
 */
public interface MBMessage extends MBMessageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a message-boards message model instance should use the {@link MBMessage} interface instead.
	 */
	public java.lang.String[] getAssetTagNames()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getAttachmentsDir();

	public java.lang.String[] getAttachmentsFiles()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getBody(boolean translate);

	public com.liferay.portlet.messageboards.model.MBCategory getCategory();

	public com.liferay.portlet.messageboards.model.MBThread getThread()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getThreadAttachmentsDir();

	public java.lang.String getWorkflowClassName();

	public boolean isDiscussion();

	public boolean isReply();

	public boolean isRoot();

	public void setAttachmentsDir(java.lang.String attachmentsDir);
}