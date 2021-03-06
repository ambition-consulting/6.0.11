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
 * <p>
 * This class is a wrapper for {@link MBMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMessage
 * @generated
 */
public class MBMessageWrapper implements MBMessage {
	public MBMessageWrapper(MBMessage mbMessage) {
		_mbMessage = mbMessage;
	}

	/**
	* Gets the primary key of this message-boards message.
	*
	* @return the primary key of this message-boards message
	*/
	public long getPrimaryKey() {
		return _mbMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message-boards message
	*
	* @param pk the primary key of this message-boards message
	*/
	public void setPrimaryKey(long pk) {
		_mbMessage.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this message-boards message.
	*
	* @return the uuid of this message-boards message
	*/
	public java.lang.String getUuid() {
		return _mbMessage.getUuid();
	}

	/**
	* Sets the uuid of this message-boards message.
	*
	* @param uuid the uuid of this message-boards message
	*/
	public void setUuid(java.lang.String uuid) {
		_mbMessage.setUuid(uuid);
	}

	/**
	* Gets the message id of this message-boards message.
	*
	* @return the message id of this message-boards message
	*/
	public long getMessageId() {
		return _mbMessage.getMessageId();
	}

	/**
	* Sets the message id of this message-boards message.
	*
	* @param messageId the message id of this message-boards message
	*/
	public void setMessageId(long messageId) {
		_mbMessage.setMessageId(messageId);
	}

	/**
	* Gets the group id of this message-boards message.
	*
	* @return the group id of this message-boards message
	*/
	public long getGroupId() {
		return _mbMessage.getGroupId();
	}

	/**
	* Sets the group id of this message-boards message.
	*
	* @param groupId the group id of this message-boards message
	*/
	public void setGroupId(long groupId) {
		_mbMessage.setGroupId(groupId);
	}

	/**
	* Gets the company id of this message-boards message.
	*
	* @return the company id of this message-boards message
	*/
	public long getCompanyId() {
		return _mbMessage.getCompanyId();
	}

	/**
	* Sets the company id of this message-boards message.
	*
	* @param companyId the company id of this message-boards message
	*/
	public void setCompanyId(long companyId) {
		_mbMessage.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this message-boards message.
	*
	* @return the user id of this message-boards message
	*/
	public long getUserId() {
		return _mbMessage.getUserId();
	}

	/**
	* Sets the user id of this message-boards message.
	*
	* @param userId the user id of this message-boards message
	*/
	public void setUserId(long userId) {
		_mbMessage.setUserId(userId);
	}

	/**
	* Gets the user uuid of this message-boards message.
	*
	* @return the user uuid of this message-boards message
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessage.getUserUuid();
	}

	/**
	* Sets the user uuid of this message-boards message.
	*
	* @param userUuid the user uuid of this message-boards message
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_mbMessage.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this message-boards message.
	*
	* @return the user name of this message-boards message
	*/
	public java.lang.String getUserName() {
		return _mbMessage.getUserName();
	}

	/**
	* Sets the user name of this message-boards message.
	*
	* @param userName the user name of this message-boards message
	*/
	public void setUserName(java.lang.String userName) {
		_mbMessage.setUserName(userName);
	}

	/**
	* Gets the create date of this message-boards message.
	*
	* @return the create date of this message-boards message
	*/
	public java.util.Date getCreateDate() {
		return _mbMessage.getCreateDate();
	}

	/**
	* Sets the create date of this message-boards message.
	*
	* @param createDate the create date of this message-boards message
	*/
	public void setCreateDate(java.util.Date createDate) {
		_mbMessage.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this message-boards message.
	*
	* @return the modified date of this message-boards message
	*/
	public java.util.Date getModifiedDate() {
		return _mbMessage.getModifiedDate();
	}

	/**
	* Sets the modified date of this message-boards message.
	*
	* @param modifiedDate the modified date of this message-boards message
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mbMessage.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the class name of the model instance this message-boards message is polymorphically associated with.
	*
	* @return the class name of the model instance this message-boards message is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _mbMessage.getClassName();
	}

	/**
	* Gets the class name id of this message-boards message.
	*
	* @return the class name id of this message-boards message
	*/
	public long getClassNameId() {
		return _mbMessage.getClassNameId();
	}

	/**
	* Sets the class name id of this message-boards message.
	*
	* @param classNameId the class name id of this message-boards message
	*/
	public void setClassNameId(long classNameId) {
		_mbMessage.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this message-boards message.
	*
	* @return the class p k of this message-boards message
	*/
	public long getClassPK() {
		return _mbMessage.getClassPK();
	}

	/**
	* Sets the class p k of this message-boards message.
	*
	* @param classPK the class p k of this message-boards message
	*/
	public void setClassPK(long classPK) {
		_mbMessage.setClassPK(classPK);
	}

	/**
	* Gets the category id of this message-boards message.
	*
	* @return the category id of this message-boards message
	*/
	public long getCategoryId() {
		return _mbMessage.getCategoryId();
	}

	/**
	* Sets the category id of this message-boards message.
	*
	* @param categoryId the category id of this message-boards message
	*/
	public void setCategoryId(long categoryId) {
		_mbMessage.setCategoryId(categoryId);
	}

	/**
	* Gets the thread id of this message-boards message.
	*
	* @return the thread id of this message-boards message
	*/
	public long getThreadId() {
		return _mbMessage.getThreadId();
	}

	/**
	* Sets the thread id of this message-boards message.
	*
	* @param threadId the thread id of this message-boards message
	*/
	public void setThreadId(long threadId) {
		_mbMessage.setThreadId(threadId);
	}

	/**
	* Gets the root message id of this message-boards message.
	*
	* @return the root message id of this message-boards message
	*/
	public long getRootMessageId() {
		return _mbMessage.getRootMessageId();
	}

	/**
	* Sets the root message id of this message-boards message.
	*
	* @param rootMessageId the root message id of this message-boards message
	*/
	public void setRootMessageId(long rootMessageId) {
		_mbMessage.setRootMessageId(rootMessageId);
	}

	/**
	* Gets the parent message id of this message-boards message.
	*
	* @return the parent message id of this message-boards message
	*/
	public long getParentMessageId() {
		return _mbMessage.getParentMessageId();
	}

	/**
	* Sets the parent message id of this message-boards message.
	*
	* @param parentMessageId the parent message id of this message-boards message
	*/
	public void setParentMessageId(long parentMessageId) {
		_mbMessage.setParentMessageId(parentMessageId);
	}

	/**
	* Gets the subject of this message-boards message.
	*
	* @return the subject of this message-boards message
	*/
	public java.lang.String getSubject() {
		return _mbMessage.getSubject();
	}

	/**
	* Sets the subject of this message-boards message.
	*
	* @param subject the subject of this message-boards message
	*/
	public void setSubject(java.lang.String subject) {
		_mbMessage.setSubject(subject);
	}

	/**
	* Gets the body of this message-boards message.
	*
	* @return the body of this message-boards message
	*/
	public java.lang.String getBody() {
		return _mbMessage.getBody();
	}

	/**
	* Sets the body of this message-boards message.
	*
	* @param body the body of this message-boards message
	*/
	public void setBody(java.lang.String body) {
		_mbMessage.setBody(body);
	}

	/**
	* Gets the attachments of this message-boards message.
	*
	* @return the attachments of this message-boards message
	*/
	public boolean getAttachments() {
		return _mbMessage.getAttachments();
	}

	/**
	* Determines if this message-boards message is attachments.
	*
	* @return <code>true</code> if this message-boards message is attachments; <code>false</code> otherwise
	*/
	public boolean isAttachments() {
		return _mbMessage.isAttachments();
	}

	/**
	* Sets whether this message-boards message is attachments.
	*
	* @param attachments the attachments of this message-boards message
	*/
	public void setAttachments(boolean attachments) {
		_mbMessage.setAttachments(attachments);
	}

	/**
	* Gets the anonymous of this message-boards message.
	*
	* @return the anonymous of this message-boards message
	*/
	public boolean getAnonymous() {
		return _mbMessage.getAnonymous();
	}

	/**
	* Determines if this message-boards message is anonymous.
	*
	* @return <code>true</code> if this message-boards message is anonymous; <code>false</code> otherwise
	*/
	public boolean isAnonymous() {
		return _mbMessage.isAnonymous();
	}

	/**
	* Sets whether this message-boards message is anonymous.
	*
	* @param anonymous the anonymous of this message-boards message
	*/
	public void setAnonymous(boolean anonymous) {
		_mbMessage.setAnonymous(anonymous);
	}

	/**
	* Gets the priority of this message-boards message.
	*
	* @return the priority of this message-boards message
	*/
	public double getPriority() {
		return _mbMessage.getPriority();
	}

	/**
	* Sets the priority of this message-boards message.
	*
	* @param priority the priority of this message-boards message
	*/
	public void setPriority(double priority) {
		_mbMessage.setPriority(priority);
	}

	/**
	* Gets the allow pingbacks of this message-boards message.
	*
	* @return the allow pingbacks of this message-boards message
	*/
	public boolean getAllowPingbacks() {
		return _mbMessage.getAllowPingbacks();
	}

	/**
	* Determines if this message-boards message is allow pingbacks.
	*
	* @return <code>true</code> if this message-boards message is allow pingbacks; <code>false</code> otherwise
	*/
	public boolean isAllowPingbacks() {
		return _mbMessage.isAllowPingbacks();
	}

	/**
	* Sets whether this message-boards message is allow pingbacks.
	*
	* @param allowPingbacks the allow pingbacks of this message-boards message
	*/
	public void setAllowPingbacks(boolean allowPingbacks) {
		_mbMessage.setAllowPingbacks(allowPingbacks);
	}

	/**
	* Gets the status of this message-boards message.
	*
	* @return the status of this message-boards message
	*/
	public int getStatus() {
		return _mbMessage.getStatus();
	}

	/**
	* Sets the status of this message-boards message.
	*
	* @param status the status of this message-boards message
	*/
	public void setStatus(int status) {
		_mbMessage.setStatus(status);
	}

	/**
	* Gets the status by user id of this message-boards message.
	*
	* @return the status by user id of this message-boards message
	*/
	public long getStatusByUserId() {
		return _mbMessage.getStatusByUserId();
	}

	/**
	* Sets the status by user id of this message-boards message.
	*
	* @param statusByUserId the status by user id of this message-boards message
	*/
	public void setStatusByUserId(long statusByUserId) {
		_mbMessage.setStatusByUserId(statusByUserId);
	}

	/**
	* Gets the status by user uuid of this message-boards message.
	*
	* @return the status by user uuid of this message-boards message
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessage.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this message-boards message.
	*
	* @param statusByUserUuid the status by user uuid of this message-boards message
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_mbMessage.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Gets the status by user name of this message-boards message.
	*
	* @return the status by user name of this message-boards message
	*/
	public java.lang.String getStatusByUserName() {
		return _mbMessage.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this message-boards message.
	*
	* @param statusByUserName the status by user name of this message-boards message
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_mbMessage.setStatusByUserName(statusByUserName);
	}

	/**
	* Gets the status date of this message-boards message.
	*
	* @return the status date of this message-boards message
	*/
	public java.util.Date getStatusDate() {
		return _mbMessage.getStatusDate();
	}

	/**
	* Sets the status date of this message-boards message.
	*
	* @param statusDate the status date of this message-boards message
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_mbMessage.setStatusDate(statusDate);
	}

	/**
	* @deprecated {@link #isApproved}
	*/
	public boolean getApproved() {
		return _mbMessage.getApproved();
	}

	/**
	* Determines if this message-boards message is approved.
	*
	* @return <code>true</code> if this message-boards message is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _mbMessage.isApproved();
	}

	/**
	* Determines if this message-boards message is a draft.
	*
	* @return <code>true</code> if this message-boards message is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _mbMessage.isDraft();
	}

	/**
	* Determines if this message-boards message is expired.
	*
	* @return <code>true</code> if this message-boards message is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _mbMessage.isExpired();
	}

	/**
	* Determines if this message-boards message is pending.
	*
	* @return <code>true</code> if this message-boards message is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _mbMessage.isPending();
	}

	public boolean isNew() {
		return _mbMessage.isNew();
	}

	public void setNew(boolean n) {
		_mbMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _mbMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_mbMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _mbMessage.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_mbMessage.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _mbMessage.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mbMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mbMessage.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new MBMessageWrapper((MBMessage)_mbMessage.clone());
	}

	public int compareTo(
		com.liferay.portlet.messageboards.model.MBMessage mbMessage) {
		return _mbMessage.compareTo(mbMessage);
	}

	public int hashCode() {
		return _mbMessage.hashCode();
	}

	public com.liferay.portlet.messageboards.model.MBMessage toEscapedModel() {
		return new MBMessageWrapper(_mbMessage.toEscapedModel());
	}

	public java.lang.String toString() {
		return _mbMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _mbMessage.toXmlString();
	}

	public java.lang.String[] getAssetTagNames()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessage.getAssetTagNames();
	}

	public java.lang.String getAttachmentsDir() {
		return _mbMessage.getAttachmentsDir();
	}

	public java.lang.String[] getAttachmentsFiles()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessage.getAttachmentsFiles();
	}

	public java.lang.String getBody(boolean translate) {
		return _mbMessage.getBody(translate);
	}

	public com.liferay.portlet.messageboards.model.MBCategory getCategory() {
		return _mbMessage.getCategory();
	}

	public com.liferay.portlet.messageboards.model.MBThread getThread()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessage.getThread();
	}

	public java.lang.String getThreadAttachmentsDir() {
		return _mbMessage.getThreadAttachmentsDir();
	}

	public java.lang.String getWorkflowClassName() {
		return _mbMessage.getWorkflowClassName();
	}

	public boolean isDiscussion() {
		return _mbMessage.isDiscussion();
	}

	public boolean isReply() {
		return _mbMessage.isReply();
	}

	public boolean isRoot() {
		return _mbMessage.isRoot();
	}

	public void setAttachmentsDir(java.lang.String attachmentsDir) {
		_mbMessage.setAttachmentsDir(attachmentsDir);
	}

	public MBMessage getWrappedMBMessage() {
		return _mbMessage;
	}

	private MBMessage _mbMessage;
}