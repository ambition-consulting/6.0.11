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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portlet.tasks.service.http.TasksReviewServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.tasks.service.http.TasksReviewServiceSoap
 * @generated
 */
public class TasksReviewSoap implements Serializable {
	public static TasksReviewSoap toSoapModel(TasksReview model) {
		TasksReviewSoap soapModel = new TasksReviewSoap();

		soapModel.setReviewId(model.getReviewId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProposalId(model.getProposalId());
		soapModel.setAssignedByUserId(model.getAssignedByUserId());
		soapModel.setAssignedByUserName(model.getAssignedByUserName());
		soapModel.setStage(model.getStage());
		soapModel.setCompleted(model.getCompleted());
		soapModel.setRejected(model.getRejected());

		return soapModel;
	}

	public static TasksReviewSoap[] toSoapModels(TasksReview[] models) {
		TasksReviewSoap[] soapModels = new TasksReviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TasksReviewSoap[][] toSoapModels(TasksReview[][] models) {
		TasksReviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TasksReviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TasksReviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TasksReviewSoap[] toSoapModels(List<TasksReview> models) {
		List<TasksReviewSoap> soapModels = new ArrayList<TasksReviewSoap>(models.size());

		for (TasksReview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TasksReviewSoap[soapModels.size()]);
	}

	public TasksReviewSoap() {
	}

	public long getPrimaryKey() {
		return _reviewId;
	}

	public void setPrimaryKey(long pk) {
		setReviewId(pk);
	}

	public long getReviewId() {
		return _reviewId;
	}

	public void setReviewId(long reviewId) {
		_reviewId = reviewId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getProposalId() {
		return _proposalId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public long getAssignedByUserId() {
		return _assignedByUserId;
	}

	public void setAssignedByUserId(long assignedByUserId) {
		_assignedByUserId = assignedByUserId;
	}

	public String getAssignedByUserName() {
		return _assignedByUserName;
	}

	public void setAssignedByUserName(String assignedByUserName) {
		_assignedByUserName = assignedByUserName;
	}

	public int getStage() {
		return _stage;
	}

	public void setStage(int stage) {
		_stage = stage;
	}

	public boolean getCompleted() {
		return _completed;
	}

	public boolean isCompleted() {
		return _completed;
	}

	public void setCompleted(boolean completed) {
		_completed = completed;
	}

	public boolean getRejected() {
		return _rejected;
	}

	public boolean isRejected() {
		return _rejected;
	}

	public void setRejected(boolean rejected) {
		_rejected = rejected;
	}

	private long _reviewId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _proposalId;
	private long _assignedByUserId;
	private String _assignedByUserName;
	private int _stage;
	private boolean _completed;
	private boolean _rejected;
}