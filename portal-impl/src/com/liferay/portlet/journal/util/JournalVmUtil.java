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

import com.liferay.portal.kernel.xml.Element;
import com.liferay.portlet.journal.TransformException;

import java.util.List;
import java.util.Map;

/**
 * @author	   Alexander Chow
 * @author	   Brian Wing Shun Chan
 * @author	   Raymond Augé
 * @deprecated
 */
public class JournalVmUtil {

	public static List<TemplateNode> extractDynamicContents(Element parent)
		throws TransformException {

		return _instance._velocityTemplateParser.extractDynamicContents(
			null, parent);
	}

	public static String transform(
			Map<String, String> tokens, String viewMode, String languageId,
			String xml, String script)
		throws TransformException {

		return _instance._velocityTemplateParser.transform(
			null, tokens, viewMode, languageId, xml, script);
	}

	private JournalVmUtil() {
		_velocityTemplateParser = new VelocityTemplateParser();
	}

	private static JournalVmUtil _instance = new JournalVmUtil();

	private VelocityTemplateParser _velocityTemplateParser;

}