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

package com.liferay.portlet.polls.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PollsVote service. Represents a row in the &quot;PollsVote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.polls.model.impl.PollsVoteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.polls.model.impl.PollsVoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsVote
 * @see com.liferay.portlet.polls.model.impl.PollsVoteImpl
 * @see com.liferay.portlet.polls.model.impl.PollsVoteModelImpl
 * @generated
 */
public interface PollsVoteModel extends BaseModel<PollsVote> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a polls vote model instance should use the {@link PollsVote} interface instead.
	 */

	/**
	 * Gets the primary key of this polls vote.
	 *
	 * @return the primary key of this polls vote
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this polls vote
	 *
	 * @param pk the primary key of this polls vote
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the vote id of this polls vote.
	 *
	 * @return the vote id of this polls vote
	 */
	public long getVoteId();

	/**
	 * Sets the vote id of this polls vote.
	 *
	 * @param voteId the vote id of this polls vote
	 */
	public void setVoteId(long voteId);

	/**
	 * Gets the user id of this polls vote.
	 *
	 * @return the user id of this polls vote
	 */
	public long getUserId();

	/**
	 * Sets the user id of this polls vote.
	 *
	 * @param userId the user id of this polls vote
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this polls vote.
	 *
	 * @return the user uuid of this polls vote
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this polls vote.
	 *
	 * @param userUuid the user uuid of this polls vote
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the question id of this polls vote.
	 *
	 * @return the question id of this polls vote
	 */
	public long getQuestionId();

	/**
	 * Sets the question id of this polls vote.
	 *
	 * @param questionId the question id of this polls vote
	 */
	public void setQuestionId(long questionId);

	/**
	 * Gets the choice id of this polls vote.
	 *
	 * @return the choice id of this polls vote
	 */
	public long getChoiceId();

	/**
	 * Sets the choice id of this polls vote.
	 *
	 * @param choiceId the choice id of this polls vote
	 */
	public void setChoiceId(long choiceId);

	/**
	 * Gets the vote date of this polls vote.
	 *
	 * @return the vote date of this polls vote
	 */
	public Date getVoteDate();

	/**
	 * Sets the vote date of this polls vote.
	 *
	 * @param voteDate the vote date of this polls vote
	 */
	public void setVoteDate(Date voteDate);

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

	public int compareTo(PollsVote pollsVote);

	public int hashCode();

	public PollsVote toEscapedModel();

	public String toString();

	public String toXmlString();
}