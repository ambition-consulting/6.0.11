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

package com.liferay.portal.kernel.xml;

import java.io.IOException;

/**
 * @author Brian Wing Shun Chan
 */
public interface Document extends Branch {

	public Document addComment(String comment);

	public Document addDocType(String name, String publicId, String systemId);

	public String formattedString() throws IOException;

	public String formattedString(String indent) throws IOException;

	public String formattedString(String indent, boolean expandEmptyElements)
		throws IOException;

	public Element getRootElement();

	public String getXMLEncoding();

	public void setRootElement(Element rootElement);

	public void setXMLEncoding(String encoding);

}