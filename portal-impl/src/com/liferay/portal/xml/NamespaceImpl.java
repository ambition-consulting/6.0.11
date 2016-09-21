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

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.Namespace;

/**
 * @author Brian Wing Shun Chan
 */
public class NamespaceImpl extends NodeImpl implements Namespace {

	public NamespaceImpl(org.dom4j.Namespace namespace) {
		super(namespace);

		_namespace = namespace;
	}

	public boolean equals(Object obj) {
		org.dom4j.Namespace namespace =
			((NamespaceImpl)obj).getWrappedNamespace();

		return _namespace.equals(namespace);
	}

	public short getNodeType() {
		return _namespace.getNodeType();
	}

	public String getPrefix() {
		return _namespace.getPrefix();
	}

	public String getURI() {
		return _namespace.getURI();
	}

	public org.dom4j.Namespace getWrappedNamespace() {
		return _namespace;
	}

	public String getXPathNameStep() {
		return _namespace.getXPathNameStep();
	}

	public int hashCode() {
		return _namespace.hashCode();
	}

	public String toString() {
		return _namespace.toString();
	}

	private org.dom4j.Namespace _namespace;

}