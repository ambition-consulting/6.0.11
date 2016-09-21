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

package com.liferay.portlet.asset.model.impl;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.model.AssetVocabulary;

/**
 * @author Brian Wing Shun Chan
 */
public class AssetVocabularyImpl
	extends AssetVocabularyModelImpl implements AssetVocabulary {

	public AssetVocabularyImpl() {
	}

	public String getTitle(String languageId) {
		String value = super.getTitle(languageId);

		if (Validator.isNull(value)) {
			value = getName();
		}

		return value;
	}

	public String getTitle(String languageId, boolean useDefault) {
		String value = super.getTitle(languageId, useDefault);

		if (Validator.isNull(value)) {
			value = getName();
		}

		return value;
	}

}