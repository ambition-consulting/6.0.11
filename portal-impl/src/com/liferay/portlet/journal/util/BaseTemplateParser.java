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

package com.liferay.portlet.journal.util;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.TransformException;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseTemplateParser implements TemplateParser {

	public String transform(
			ThemeDisplay themeDisplay, Map<String, String> tokens,
			String viewMode, String languageId, String xml, String script)
		throws TransformException {

		try {
			return doTransform(
				themeDisplay, tokens, viewMode, languageId, xml, script);
		}
		catch (TransformException te) {
			throw te;
		}
		catch (Exception e) {
			throw new TransformException(e);
		}
	}

	protected String doTransform(
			ThemeDisplay themeDisplay, Map<String, String> tokens,
			String viewMode, String languageId, String xml, String script)
		throws Exception {

		return null;
	}

}