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

package com.liferay.portlet.tasks.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TasksReview service. Represents a row in the &quot;TasksReview&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.tasks.model.impl.TasksReviewModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.tasks.model.impl.TasksReviewImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TasksReview
 * @see com.liferay.portlet.tasks.model.impl.TasksReviewImpl
 * @see com.liferay.portlet.tasks.model.impl.TasksReviewModelImpl
 * @generated
 */
public interface TasksReviewModel extends BaseModel<TasksReview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tasks review model instance should use the {@link TasksReview} interface instead.
	 */

	/**
	 * Gets the primary key of this tasks review.
	 *
	 * @return the primary key of this tasks review
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tasks review
	 *
	 * @param pk the primary key of this tasks review
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the review id of this tasks review.
	 *
	 * @return the review id of this tasks review
	 */
	public long getReviewId();

	/**
	 * Sets the review id of this tasks review.
	 *
	 * @param reviewId the review id of this tasks review
	 */
	public void setReviewId(long reviewId);

	/**
	 * Gets the group id of this tasks review.
	 *
	 * @return the group id of this tasks review
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this tasks review.
	 *
	 * @param groupId the group id of this tasks review
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this tasks review.
	 *
	 * @return the company id of this tasks review
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this tasks review.
	 *
	 * @param companyId the company id of this tasks review
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this tasks review.
	 *
	 * @return the user id of this tasks review
	 */
	public long getUserId();

	/**
	 * Sets the user id of this tasks review.
	 *
	 * @param userId the user id of this tasks review
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this tasks review.
	 *
	 * @return the user uuid of this tasks review
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this tasks review.
	 *
	 * @param userUuid the user uuid of this tasks review
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this tasks review.
	 *
	 * @return the user name of this tasks review
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this tasks review.
	 *
	 * @param userName the user name of this tasks review
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this tasks review.
	 *
	 * @return the create date of this tasks review
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this tasks review.
	 *
	 * @param createDate the create date of this tasks review
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this tasks review.
	 *
	 * @return the modified date of this tasks review
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tasks review.
	 *
	 * @param modifiedDate the modified date of this tasks review
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the proposal id of this tasks review.
	 *
	 * @return the proposal id of this tasks review
	 */
	public long getProposalId();

	/**
	 * Sets the proposal id of this tasks review.
	 *
	 * @param proposalId the proposal id of this tasks review
	 */
	public void setProposalId(long proposalId);

	/**
	 * Gets the assigned by user id of this tasks review.
	 *
	 * @return the assigned by user id of this tasks review
	 */
	public long getAssignedByUserId();

	/**
	 * Sets the assigned by user id of this tasks review.
	 *
	 * @param assignedByUserId the assigned by user id of this tasks review
	 */
	public void setAssignedByUserId(long assignedByUserId);

	/**
	 * Gets the assigned by user uuid of this tasks review.
	 *
	 * @return the assigned by user uuid of this tasks review
	 * @throws SystemException if a system exception occurred
	 */
	public String getAssignedByUserUuid() throws SystemException;

	/**
	 * Sets the assigned by user uuid of this tasks review.
	 *
	 * @param assignedByUserUuid the assigned by user uuid of this tasks review
	 */
	public void setAssignedByUserUuid(String assignedByUserUuid);

	/**
	 * Gets the assigned by user name of this tasks review.
	 *
	 * @return the assigned by user name of this tasks review
	 */
	@AutoEscape
	public String getAssignedByUserName();

	/**
	 * Sets the assigned by user name of this tasks review.
	 *
	 * @param assignedByUserName the assigned by user name of this tasks review
	 */
	public void setAssignedByUserName(String assignedByUserName);

	/**
	 * Gets the stage of this tasks review.
	 *
	 * @return the stage of this tasks review
	 */
	public int getStage();

	/**
	 * Sets the stage of this tasks review.
	 *
	 * @param stage the stage of this tasks review
	 */
	public void setStage(int stage);

	/**
	 * Gets the completed of this tasks review.
	 *
	 * @return the completed of this tasks review
	 */
	public boolean getCompleted();

	/**
	 * Determines if this tasks review is completed.
	 *
	 * @return <code>true</code> if this tasks review is completed; <code>false</code> otherwise
	 */
	public boolean isCompleted();

	/**
	 * Sets whether this tasks review is completed.
	 *
	 * @param completed the completed of this tasks review
	 */
	public void setCompleted(boolean completed);

	/**
	 * Gets the rejected of this tasks review.
	 *
	 * @return the rejected of this tasks review
	 */
	public boolean getRejected();

	/**
	 * Determines if this tasks review is rejected.
	 *
	 * @return <code>true</code> if this tasks review is rejected; <code>false</code> otherwise
	 */
	public boolean isRejected();

	/**
	 * Sets whether this tasks review is rejected.
	 *
	 * @param rejected the rejected of this tasks review
	 */
	public void setRejected(boolean rejected);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(TasksReview tasksReview);

	public int hashCode();

	public TasksReview toEscapedModel();

	public String toString();

	public String toXmlString();
}