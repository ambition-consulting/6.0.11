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

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageTag extends TagSupport {

	public int doEndTag() throws JspException {
		try {
			String value =  StringPool.BLANK;

			if (_arguments == null) {
				value = LanguageUtil.get(pageContext, _key);
			}
			else {
				value = LanguageUtil.format(
					pageContext, _key, _arguments, _translateArguments);
			}

			JspWriter jspWriter = pageContext.getOut();

			jspWriter.write(value);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
		finally {
			if (!ServerDetector.isResin()) {
				_arguments = null;
				_key = null;
				_translateArguments = true;
			}
		}
	}

	public void setArguments(Object argument) {
		_arguments = new Object[] {argument};
	}

	public void setArguments(Object[] arguments) {
		_arguments = arguments;
	}

	public void setKey(String key) {
		_key = key;
	}

	public void setTranslateArguments(boolean translateArguments) {
		_translateArguments = translateArguments;
	}

	private Object[] _arguments;
	private String _key;
	private boolean _translateArguments = true;

}