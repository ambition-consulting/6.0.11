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
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class SocialRelationConstants {

	public static final int TYPE_BI_COWORKER = 1;

	public static final int TYPE_BI_FRIEND = 2;

	public static final int TYPE_BI_ROMANTIC_PARTNER = 3;

	public static final int TYPE_BI_SIBLING = 4;

	public static final int TYPE_BI_SPOUSE = 5;

	public static final int TYPE_UNI_CHILD = 6;

	public static final int TYPE_UNI_PARENT = 7;

	public static boolean isTypeBi(int type) {
		return !isTypeUni(type);
	}

	public static boolean isTypeUni(int type) {
		if ((type == SocialRelationConstants.TYPE_UNI_CHILD) ||
			(type == SocialRelationConstants.TYPE_UNI_PARENT)) {

			return true;
		}
		else {
			return false;
		}
	}

}