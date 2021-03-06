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

package com.liferay.portal.search.lucene.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.util.SystemProperties;
import com.liferay.util.ant.DeleteTask;

/**
 * @author Brian Wing Shun Chan
 */
public class CleanUpMessageListener extends BaseMessageListener {

	protected void doReceive(Message message) throws Exception {

		// LEP-2180

		DeleteTask.deleteFiles(
			SystemProperties.get(SystemProperties.TMP_DIR),
			"LUCENE_liferay_com*.ljt", null);
	}

}