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

package com.liferay.portlet.wiki.engines.mediawiki.matchers;

import javax.portlet.PortletURL;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public class ViewURLMatcher extends PortletURLMatcher {

	public ViewURLMatcher(PortletURL portletURL) {
		super(portletURL);

		setRegex(_REGEX);
	}

	private static final String _REGEX =
		"<a href=\"[^\"]*?Special:Node[^\"]*?/([^\"/]+?/?)\"";

}