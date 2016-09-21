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

package com.liferay.portlet.polls.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.polls.QuestionChoiceException;
import com.liferay.portlet.polls.QuestionDescriptionException;
import com.liferay.portlet.polls.QuestionExpirationDateException;
import com.liferay.portlet.polls.QuestionTitleException;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.base.PollsQuestionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class PollsQuestionLocalServiceImpl
	extends PollsQuestionLocalServiceBaseImpl {

	public PollsQuestion addQuestion(
			long userId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, List<PollsChoice> choices,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Question

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date expirationDate = null;

		if (!neverExpire) {
			expirationDate = PortalUtil.getDate(
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, user.getTimeZone(),
				new QuestionExpirationDateException());
		}

		Date now = new Date();

		validate(titleMap, descriptionMap, choices);

		long questionId = counterLocalService.increment();

		PollsQuestion question = pollsQuestionPersistence.create(questionId);

		question.setUuid(serviceContext.getUuid());
		question.setGroupId(groupId);
		question.setCompanyId(user.getCompanyId());
		question.setUserId(user.getUserId());
		question.setUserName(user.getFullName());
		question.setCreateDate(serviceContext.getCreateDate(now));
		question.setModifiedDate(serviceContext.getModifiedDate(now));
		question.setTitleMap(titleMap);
		question.setDescriptionMap(descriptionMap);
		question.setExpirationDate(expirationDate);

		pollsQuestionPersistence.update(question, false);

		// Resources

		if (serviceContext.getAddCommunityPermissions() ||
			serviceContext.getAddGuestPermissions()) {

			addQuestionResources(
				question, serviceContext.getAddCommunityPermissions(),
				serviceContext.getAddGuestPermissions());
		}
		else {
			addQuestionResources(
				question, serviceContext.getCommunityPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Choices

		if (choices != null) {
			for (PollsChoice choice : choices) {
				pollsChoiceLocalService.addChoice(
					questionId, choice.getName(), choice.getDescription(),
					new ServiceContext());
			}
		}

		return question;
	}

	public void addQuestionResources(
			long questionId, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		PollsQuestion question = pollsQuestionPersistence.findByPrimaryKey(
			questionId);

		addQuestionResources(
			question, addCommunityPermissions, addGuestPermissions);
	}

	public void addQuestionResources(
			long questionId, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		PollsQuestion question = pollsQuestionPersistence.findByPrimaryKey(
			questionId);

		addQuestionResources(question, communityPermissions, guestPermissions);
	}

	public void addQuestionResources(
			PollsQuestion question, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			question.getCompanyId(), question.getGroupId(),
			question.getUserId(), PollsQuestion.class.getName(),
			question.getQuestionId(), false, addCommunityPermissions,
			addGuestPermissions);
	}

	public void addQuestionResources(
			PollsQuestion question, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			question.getCompanyId(), question.getGroupId(),
			question.getUserId(), PollsQuestion.class.getName(),
			question.getQuestionId(), communityPermissions, guestPermissions);
	}

	public void deleteQuestion(long questionId)
		throws PortalException, SystemException {

		PollsQuestion question = pollsQuestionPersistence.findByPrimaryKey(
			questionId);

		deleteQuestion(question);
	}

	public void deleteQuestion(PollsQuestion question)
		throws PortalException, SystemException {

		// Question

		pollsQuestionPersistence.remove(question);

		// Resources

		resourceLocalService.deleteResource(
			question.getCompanyId(), PollsQuestion.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, question.getQuestionId());

		// Choices

		pollsChoicePersistence.removeByQuestionId(question.getQuestionId());

		// Votes

		pollsVotePersistence.removeByQuestionId(question.getQuestionId());
	}

	public void deleteQuestions(long groupId)
		throws PortalException, SystemException {

		for (PollsQuestion question :
				pollsQuestionPersistence.findByGroupId(groupId)) {

			deleteQuestion(question);
		}
	}

	public PollsQuestion getQuestion(long questionId)
		throws PortalException, SystemException {

		return pollsQuestionPersistence.findByPrimaryKey(questionId);
	}

	public List<PollsQuestion> getQuestions(long groupId)
		throws SystemException {

		return pollsQuestionPersistence.findByGroupId(groupId);
	}

	public List<PollsQuestion> getQuestions(long groupId, int start, int end)
		throws SystemException {

		return pollsQuestionPersistence.findByGroupId(groupId, start, end);
	}

	public int getQuestionsCount(long groupId) throws SystemException {
		return pollsQuestionPersistence.countByGroupId(groupId);
	}

	public PollsQuestion updateQuestion(
			long userId, long questionId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, List<PollsChoice> choices,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Question

		User user = userPersistence.findByPrimaryKey(userId);

		Date expirationDate = null;

		if (!neverExpire) {
			expirationDate = PortalUtil.getDate(
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, user.getTimeZone(),
				new QuestionExpirationDateException());
		}

		validate(titleMap, descriptionMap, choices);

		PollsQuestion question = pollsQuestionPersistence.findByPrimaryKey(
			questionId);

		question.setModifiedDate(serviceContext.getModifiedDate(null));
		question.setTitleMap(titleMap);
		question.setDescriptionMap(descriptionMap);
		question.setExpirationDate(expirationDate);

		pollsQuestionPersistence.update(question, false);

		// Choices

		if (choices != null) {
			int oldChoicesCount = pollsChoicePersistence.countByQuestionId(
				questionId);

			if (oldChoicesCount > choices.size()) {
				throw new QuestionChoiceException();
			}

			for (PollsChoice choice : choices) {
				String choiceName = choice.getName();
				String choiceDescription = choice.getDescription();

				choice = pollsChoicePersistence.fetchByQ_N(
					questionId, choiceName);

				if (choice == null) {
					pollsChoiceLocalService.addChoice(
						questionId, choiceName, choiceDescription,
						new ServiceContext());
				}
				else {
					pollsChoiceLocalService.updateChoice(
						choice.getChoiceId(), questionId, choiceName,
						choiceDescription);
				}
			}
		}

		return question;
	}

	protected void validate(
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			List<PollsChoice> choices)
		throws PortalException {

		Locale locale = LocaleUtil.getDefault();

		String title = titleMap.get(locale);

		if (Validator.isNull(title)) {
			throw new QuestionTitleException();
		}

		String description = descriptionMap.get(locale);

		if (Validator.isNull(description)) {
			throw new QuestionDescriptionException();
		}

		if ((choices != null) && (choices.size() < 2)) {
			throw new QuestionChoiceException();
		}

		if (choices != null) {
			for (PollsChoice choice : choices) {
				String choiceDescription = choice.getDescription(locale);

				if (Validator.isNull(choiceDescription)) {
					throw new QuestionChoiceException();
				}
			}
		}
	}

}