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

/**
 * The model interface for the PollsVote service. Represents a row in the &quot;PollsVote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.polls.model.impl.PollsVoteImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsVoteModel
 * @see com.liferay.portlet.polls.model.impl.PollsVoteImpl
 * @see com.liferay.portlet.polls.model.impl.PollsVoteModelImpl
 * @generated
 */
public interface PollsVote extends PollsVoteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a polls vote model instance should use the {@link PollsVote} interface instead.
	 */
	public com.liferay.portlet.polls.model.PollsChoice getChoice()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}