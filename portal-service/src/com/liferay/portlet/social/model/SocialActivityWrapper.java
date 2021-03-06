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

package com.liferay.portlet.social.model;

/**
 * <p>
 * This class is a wrapper for {@link SocialActivity}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialActivity
 * @generated
 */
public class SocialActivityWrapper implements SocialActivity {
	public SocialActivityWrapper(SocialActivity socialActivity) {
		_socialActivity = socialActivity;
	}

	/**
	* Gets the primary key of this social activity.
	*
	* @return the primary key of this social activity
	*/
	public long getPrimaryKey() {
		return _socialActivity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social activity
	*
	* @param pk the primary key of this social activity
	*/
	public void setPrimaryKey(long pk) {
		_socialActivity.setPrimaryKey(pk);
	}

	/**
	* Gets the activity id of this social activity.
	*
	* @return the activity id of this social activity
	*/
	public long getActivityId() {
		return _socialActivity.getActivityId();
	}

	/**
	* Sets the activity id of this social activity.
	*
	* @param activityId the activity id of this social activity
	*/
	public void setActivityId(long activityId) {
		_socialActivity.setActivityId(activityId);
	}

	/**
	* Gets the group id of this social activity.
	*
	* @return the group id of this social activity
	*/
	public long getGroupId() {
		return _socialActivity.getGroupId();
	}

	/**
	* Sets the group id of this social activity.
	*
	* @param groupId the group id of this social activity
	*/
	public void setGroupId(long groupId) {
		_socialActivity.setGroupId(groupId);
	}

	/**
	* Gets the company id of this social activity.
	*
	* @return the company id of this social activity
	*/
	public long getCompanyId() {
		return _socialActivity.getCompanyId();
	}

	/**
	* Sets the company id of this social activity.
	*
	* @param companyId the company id of this social activity
	*/
	public void setCompanyId(long companyId) {
		_socialActivity.setCompanyId(companyId);
	}

	/**
	* Gets the user id of this social activity.
	*
	* @return the user id of this social activity
	*/
	public long getUserId() {
		return _socialActivity.getUserId();
	}

	/**
	* Sets the user id of this social activity.
	*
	* @param userId the user id of this social activity
	*/
	public void setUserId(long userId) {
		_socialActivity.setUserId(userId);
	}

	/**
	* Gets the user uuid of this social activity.
	*
	* @return the user uuid of this social activity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialActivity.getUserUuid();
	}

	/**
	* Sets the user uuid of this social activity.
	*
	* @param userUuid the user uuid of this social activity
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_socialActivity.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this social activity.
	*
	* @return the create date of this social activity
	*/
	public long getCreateDate() {
		return _socialActivity.getCreateDate();
	}

	/**
	* Sets the create date of this social activity.
	*
	* @param createDate the create date of this social activity
	*/
	public void setCreateDate(long createDate) {
		_socialActivity.setCreateDate(createDate);
	}

	/**
	* Gets the mirror activity id of this social activity.
	*
	* @return the mirror activity id of this social activity
	*/
	public long getMirrorActivityId() {
		return _socialActivity.getMirrorActivityId();
	}

	/**
	* Sets the mirror activity id of this social activity.
	*
	* @param mirrorActivityId the mirror activity id of this social activity
	*/
	public void setMirrorActivityId(long mirrorActivityId) {
		_socialActivity.setMirrorActivityId(mirrorActivityId);
	}

	/**
	* Gets the class name of the model instance this social activity is polymorphically associated with.
	*
	* @return the class name of the model instance this social activity is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _socialActivity.getClassName();
	}

	/**
	* Gets the class name id of this social activity.
	*
	* @return the class name id of this social activity
	*/
	public long getClassNameId() {
		return _socialActivity.getClassNameId();
	}

	/**
	* Sets the class name id of this social activity.
	*
	* @param classNameId the class name id of this social activity
	*/
	public void setClassNameId(long classNameId) {
		_socialActivity.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this social activity.
	*
	* @return the class p k of this social activity
	*/
	public long getClassPK() {
		return _socialActivity.getClassPK();
	}

	/**
	* Sets the class p k of this social activity.
	*
	* @param classPK the class p k of this social activity
	*/
	public void setClassPK(long classPK) {
		_socialActivity.setClassPK(classPK);
	}

	/**
	* Gets the type of this social activity.
	*
	* @return the type of this social activity
	*/
	public int getType() {
		return _socialActivity.getType();
	}

	/**
	* Sets the type of this social activity.
	*
	* @param type the type of this social activity
	*/
	public void setType(int type) {
		_socialActivity.setType(type);
	}

	/**
	* Gets the extra data of this social activity.
	*
	* @return the extra data of this social activity
	*/
	public java.lang.String getExtraData() {
		return _socialActivity.getExtraData();
	}

	/**
	* Sets the extra data of this social activity.
	*
	* @param extraData the extra data of this social activity
	*/
	public void setExtraData(java.lang.String extraData) {
		_socialActivity.setExtraData(extraData);
	}

	/**
	* Gets the receiver user id of this social activity.
	*
	* @return the receiver user id of this social activity
	*/
	public long getReceiverUserId() {
		return _socialActivity.getReceiverUserId();
	}

	/**
	* Sets the receiver user id of this social activity.
	*
	* @param receiverUserId the receiver user id of this social activity
	*/
	public void setReceiverUserId(long receiverUserId) {
		_socialActivity.setReceiverUserId(receiverUserId);
	}

	/**
	* Gets the receiver user uuid of this social activity.
	*
	* @return the receiver user uuid of this social activity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getReceiverUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialActivity.getReceiverUserUuid();
	}

	/**
	* Sets the receiver user uuid of this social activity.
	*
	* @param receiverUserUuid the receiver user uuid of this social activity
	*/
	public void setReceiverUserUuid(java.lang.String receiverUserUuid) {
		_socialActivity.setReceiverUserUuid(receiverUserUuid);
	}

	public boolean isNew() {
		return _socialActivity.isNew();
	}

	public void setNew(boolean n) {
		_socialActivity.setNew(n);
	}

	public boolean isCachedModel() {
		return _socialActivity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_socialActivity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _socialActivity.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_socialActivity.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _socialActivity.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialActivity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialActivity.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SocialActivityWrapper((SocialActivity)_socialActivity.clone());
	}

	public int compareTo(
		com.liferay.portlet.social.model.SocialActivity socialActivity) {
		return _socialActivity.compareTo(socialActivity);
	}

	public int hashCode() {
		return _socialActivity.hashCode();
	}

	public com.liferay.portlet.social.model.SocialActivity toEscapedModel() {
		return new SocialActivityWrapper(_socialActivity.toEscapedModel());
	}

	public java.lang.String toString() {
		return _socialActivity.toString();
	}

	public java.lang.String toXmlString() {
		return _socialActivity.toXmlString();
	}

	public SocialActivity getWrappedSocialActivity() {
		return _socialActivity;
	}

	private SocialActivity _socialActivity;
}