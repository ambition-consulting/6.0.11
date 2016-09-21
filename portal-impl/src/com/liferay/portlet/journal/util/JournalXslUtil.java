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

import java.util.Map;

/**
 * @author	   Alexander Chow
 * @author	   Raymond Augé
 * @deprecated
 */
public class JournalXslUtil {

	public static String transform(
			Map<String, String> tokens, String viewMode, String languageId,
			String xml, String script)
		throws Exception {

		return _instance._templateParser.transform(
			null, tokens, viewMode, languageId, xml, script);
	}

	private JournalXslUtil() {
		_templateParser = new XSLTemplateParser();
	}

	private static JournalXslUtil _instance = new JournalXslUtil();

	private TemplateParser _templateParser;

}