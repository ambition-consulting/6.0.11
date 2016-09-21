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

package com.liferay.portlet.words.util.comparator;

import java.io.Serializable;

import java.util.Comparator;

/**
 * @author Brian Wing Shun Chan
 */
public class WordComparator implements Comparator<String>, Serializable {

	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		else if (s1.length() > s2.length()) {
			return 1;
		}
		else {
			return s1.compareTo(s2);
		}
	}

}