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

package com.liferay.portlet.amazonrankings;

import com.liferay.portlet.amazonrankings.model.AmazonRankings;
import com.liferay.portlet.amazonrankings.util.AmazonRankingsUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

/**
 * @author Brian Wing Shun Chan
 */
public class AmazonRankingsPreferencesValidator
	implements PreferencesValidator {

	public void validate(PortletPreferences preferences)
		throws ValidatorException {

		List<String> badIsbns = new ArrayList<String>();

		String[] isbns = preferences.getValues("isbns", new String[0]);

		for (int i = 0; i < isbns.length; i++) {
			AmazonRankings amazonRankings =
				AmazonRankingsUtil.getAmazonRankings(isbns[i]);

			if (amazonRankings == null) {
				badIsbns.add(isbns[i]);
			}
		}

		if (badIsbns.size() > 0) {
			throw new ValidatorException(
				"Failed to retrieve ISBNs", badIsbns);
		}
	}

}