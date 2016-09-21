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
 * This class is a wrapper for {@link SocialRelation}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialRelation
 * @generated
 */
public class SocialRelationWrapper implements SocialRelation {
	public SocialRelationWrapper(SocialRelation socialRelation) {
		_socialRelation = socialRelation;
	}

	/**
	* Gets the primary key of this social relation.
	*
	* @return the primary key of this social relation
	*/
	public long getPrimaryKey() {
		return _socialRelation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social relation
	*
	* @param pk the primary key of this social relation
	*/
	public void setPrimaryKey(long pk) {
		_socialRelation.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this social relation.
	*
	* @return the uuid of this social relation
	*/
	public java.lang.String getUuid() {
		return _socialRelation.getUuid();
	}

	/**
	* Sets the uuid of this social relation.
	*
	* @param uuid the uuid of this social relation
	*/
	public void setUuid(java.lang.String uuid) {
		_socialRelation.setUuid(uuid);
	}

	/**
	* Gets the relation id of this social relation.
	*
	* @return the relation id of this social relation
	*/
	public long getRelationId() {
		return _socialRelation.getRelationId();
	}

	/**
	* Sets the relation id of this social relation.
	*
	* @param relationId the relation id of this social relation
	*/
	public void setRelationId(long relationId) {
		_socialRelation.setRelationId(relationId);
	}

	/**
	* Gets the company id of this social relation.
	*
	* @return the company id of this social relation
	*/
	public long getCompanyId() {
		return _socialRelation.getCompanyId();
	}

	/**
	* Sets the company id of this social relation.
	*
	* @param companyId the company id of this social relation
	*/
	public void setCompanyId(long companyId) {
		_socialRelation.setCompanyId(companyId);
	}

	/**
	* Gets the create date of this social relation.
	*
	* @return the create date of this social relation
	*/
	public long getCreateDate() {
		return _socialRelation.getCreateDate();
	}

	/**
	* Sets the create date of this social relation.
	*
	* @param createDate the create date of this social relation
	*/
	public void setCreateDate(long createDate) {
		_socialRelation.setCreateDate(createDate);
	}

	/**
	* Gets the user id1 of this social relation.
	*
	* @return the user id1 of this social relation
	*/
	public long getUserId1() {
		return _socialRelation.getUserId1();
	}

	/**
	* Sets the user id1 of this social relation.
	*
	* @param userId1 the user id1 of this social relation
	*/
	public void setUserId1(long userId1) {
		_socialRelation.setUserId1(userId1);
	}

	/**
	* Gets the user id2 of this social relation.
	*
	* @return the user id2 of this social relation
	*/
	public long getUserId2() {
		return _socialRelation.getUserId2();
	}

	/**
	* Sets the user id2 of this social relation.
	*
	* @param userId2 the user id2 of this social relation
	*/
	public void setUserId2(long userId2) {
		_socialRelation.setUserId2(userId2);
	}

	/**
	* Gets the type of this social relation.
	*
	* @return the type of this social relation
	*/
	public int getType() {
		return _socialRelation.getType();
	}

	/**
	* Sets the type of this social relation.
	*
	* @param type the type of this social relation
	*/
	public void setType(int type) {
		_socialRelation.setType(type);
	}

	public boolean isNew() {
		return _socialRelation.isNew();
	}

	public void setNew(boolean n) {
		_socialRelation.setNew(n);
	}

	public boolean isCachedModel() {
		return _socialRelation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_socialRelation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _socialRelation.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_socialRelation.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _socialRelation.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialRelation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialRelation.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SocialRelationWrapper((SocialRelation)_socialRelation.clone());
	}

	public int compareTo(
		com.liferay.portlet.social.model.SocialRelation socialRelation) {
		return _socialRelation.compareTo(socialRelation);
	}

	public int hashCode() {
		return _socialRelation.hashCode();
	}

	public com.liferay.portlet.social.model.SocialRelation toEscapedModel() {
		return new SocialRelationWrapper(_socialRelation.toEscapedModel());
	}

	public java.lang.String toString() {
		return _socialRelation.toString();
	}

	public java.lang.String toXmlString() {
		return _socialRelation.toXmlString();
	}

	public SocialRelation getWrappedSocialRelation() {
		return _socialRelation;
	}

	private SocialRelation _socialRelation;
}