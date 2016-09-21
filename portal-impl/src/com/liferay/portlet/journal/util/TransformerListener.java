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
 * @author Brian Wing Shun Chan
 */
public abstract class TransformerListener {

	public TransformerListener() {
	}

	public boolean isTemplateDriven() {
		return _templateDriven;
	}

	public void setTemplateDriven(boolean templateDriven) {
		_templateDriven = templateDriven;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public Map<String, String> getTokens() {
		return _tokens;
	}

	public void setTokens(Map<String, String> tokens) {
		_tokens = tokens;
	}

	public abstract String onXml(String s);

	public abstract String onScript(String s);

	public abstract String onOutput(String s);

	private boolean _templateDriven;
	private String _languageId;
	private Map<String, String> _tokens;

}