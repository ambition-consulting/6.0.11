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

package com.liferay.portal.scheduler.job;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.scheduler.JobState;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.TriggerState;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.Trigger;

/**
 * @author Michael C. Han
 * @author Bruno Farache
 */
public class MessageSenderJob implements Job {

	public void execute(JobExecutionContext jobExecutionContext) {
		try {
			doExecute(jobExecutionContext);
		}
		catch (Exception e) {
			_log.error("Unable to execute job", e);
		}
	}

	protected void doExecute(JobExecutionContext jobExecutionContext)
		throws Exception {

		JobDetail jobDetail = jobExecutionContext.getJobDetail();

		JobDataMap jobDataMap = jobDetail.getJobDataMap();

		String destinationName = jobDataMap.getString(
			SchedulerEngine.DESTINATION_NAME);

		String messageJSON = (String)jobDataMap.get(SchedulerEngine.MESSAGE);

		Message message = null;

		if (messageJSON == null) {
			message = new Message();
		}
		else {
			message = (Message)JSONFactoryUtil.deserialize(messageJSON);
		}

		message.put(SchedulerEngine.DESTINATION_NAME, destinationName);

		Scheduler scheduler = jobExecutionContext.getScheduler();

		SchedulerContext schedulerContext = scheduler.getContext();

		JobState jobState = (JobState)schedulerContext.get(
			jobDetail.getFullName());

		if (jobExecutionContext.getNextFireTime() == null) {
			if (message.getBoolean(SchedulerEngine.PERMANENT)) {
				Trigger trigger = jobExecutionContext.getTrigger();

				jobState.setTriggerTimeInfomation(
					SchedulerEngine.END_TIME, trigger.getEndTime());
				jobState.setTriggerTimeInfomation(
					SchedulerEngine.FINAL_FIRE_TIME,
					trigger.getFinalFireTime());
				jobState.setTriggerTimeInfomation(
					SchedulerEngine.NEXT_FIRE_TIME, null);
				jobState.setTriggerTimeInfomation(
					SchedulerEngine.PREVIOUS_FIRE_TIME,
					trigger.getPreviousFireTime());
				jobState.setTriggerTimeInfomation(
					SchedulerEngine.START_TIME, trigger.getStartTime());

				jobState.setTriggerState(TriggerState.COMPLETE);

				JobState jobStateClone = (JobState)jobState.clone();

				jobStateClone.clearExceptions();

				jobDataMap.put(SchedulerEngine.JOB_STATE, jobStateClone);

				scheduler.addJob(jobDetail, true);
			}
			else {
				message.put(SchedulerEngine.DISABLE, true);
			}
		}

		message.put(SchedulerEngine.JOB_STATE, jobState);

		MessageBusUtil.sendMessage(destinationName, message);
	}

	private static Log _log = LogFactoryUtil.getLog(MessageSenderJob.class);

}