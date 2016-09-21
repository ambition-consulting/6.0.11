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

package com.liferay.portal.kernel.freemarker;

import java.io.Writer;

/**
 * @author Mika Koivisto
 */
public class FreeMarkerEngineUtil {

	public static FreeMarkerEngine getFreeMarkerEngine() {
		return _freeMarkerEngine;
	}

	public static FreeMarkerContext getWrappedRestrictedToolsContext() {
		return getFreeMarkerEngine().getWrappedRestrictedToolsContext();
	}

	public static FreeMarkerContext getWrappedStandardToolsContext() {
		return getFreeMarkerEngine().getWrappedStandardToolsContext();
	}

	public static void init() throws Exception {
		getFreeMarkerEngine().init();
	}

	public static boolean mergeTemplate(
			String freeMarkerTemplateId, FreeMarkerContext freeMarkerContext,
			Writer writer)
		throws Exception {

		return getFreeMarkerEngine().mergeTemplate(
			freeMarkerTemplateId, freeMarkerContext, writer);
	}

	public static boolean mergeTemplate(
			String freeMarkerTemplateId, String freemarkerTemplateContent,
			FreeMarkerContext freeMarkerContext, Writer writer)
		throws Exception {

		return getFreeMarkerEngine().mergeTemplate(
			freeMarkerTemplateId, freemarkerTemplateContent, freeMarkerContext,
			writer);
	}

	public static boolean resourceExists(String resource) {
		return getFreeMarkerEngine().resourceExists(resource);
	}

	public void setFreeMarkerEngine(FreeMarkerEngine freeMarkerEngine) {
		_freeMarkerEngine = freeMarkerEngine;
	}

	private static FreeMarkerEngine _freeMarkerEngine;

}