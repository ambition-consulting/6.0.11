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

package com.liferay.portal.kernel.scheduler;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerRequest;

import java.util.List;

/**
 * @author Michael C. Han
 * @author Bruno Farache
 * @author Shuyang Zhou
 * @author Tina Tian
 */
public interface SchedulerEngine {

	public static final String DESCRIPTION = "DESCRIPTION";

	public static final int DESCRIPTION_MAX_LENGTH = 120;

	public static final String DESTINATION_NAME = "DESTINATION_NAME";

	public static final String DISABLE = "DISABLE";

	public static final String END_TIME = "END_TIME";

	public static final String EXCEPTIONS_MAX_SIZE = "EXCEPTIONS_MAX_SIZE";

	public static final String FINAL_FIRE_TIME = "FINAL_FIRE_TIME";

	public static final int GROUP_NAME_MAX_LENGTH = 80;

	public static final int JOB_NAME_MAX_LENGTH = 80;

	public static final String JOB_STATE = "JOB_STATE";

	public static final String LANGUAGE = "LANGUAGE";

	public static final String MESSAGE = "MESSAGE";

	public static final String MESSAGE_LISTENER_UUID = "MESSAGE_LISTENER_UUID";

	public static final String NEXT_FIRE_TIME = "NEXT_FIRE_TIME";

	public static final String PERMANENT = "PERMANENT";

	public static final String PREVIOUS_FIRE_TIME = "PREVIOUS_FIRE_TIME";

	public static final String RECEIVER_KEY = "RECEIVER_KEY";

	public static final String SCRIPT = "SCRIPT";

	public static final String START_TIME = "START_TIME";

	public void delete(String groupName) throws SchedulerException;

	public void delete(String jobName, String groupName)
		throws SchedulerException;

	public SchedulerRequest getScheduledJob(String jobName, String groupName)
		throws SchedulerException;

	public List<SchedulerRequest> getScheduledJobs()
		throws SchedulerException;

	public List<SchedulerRequest> getScheduledJobs(String groupName)
		throws SchedulerException;

	public void pause(String groupName) throws SchedulerException;

	public void pause(String jobName, String groupName)
		throws SchedulerException;

	public void resume(String groupName) throws SchedulerException;

	public void resume(String jobName, String groupName)
		throws SchedulerException;

	public void schedule(
			Trigger trigger, String description, String destinationName,
			Message message)
		throws SchedulerException;

	public void shutdown() throws SchedulerException;

	public void start() throws SchedulerException;

	public void suppressError(String jobName, String groupName)
		throws SchedulerException;

	public void unschedule(String groupName) throws SchedulerException;

	public void unschedule(String jobName, String groupName)
		throws SchedulerException;

	/**
	 * @deprecated {@link #unschedule(String, String)}
	 */
	public void unschedule(Trigger trigger) throws SchedulerException;

	public void update(Trigger trigger) throws SchedulerException;

}