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

package com.liferay.util.ldap;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.OperationNotSupportedException;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyContext implements Context {

	public Object addToEnvironment(String propName, Object propVal)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public void bind(Name name, Object obj) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void bind(String name, Object obj) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void close() throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Name composeName(Name name, Name prefix) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public String composeName(String name, String prefix)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public Context createSubcontext(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Context createSubcontext(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void destroySubcontext(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void destroySubcontext(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Hashtable<?, ?> getEnvironment() throws NamingException {
		throw new OperationNotSupportedException();
	}

	public String getNameInNamespace() throws NamingException {
		throw new OperationNotSupportedException();
	}

	public NameParser getNameParser(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public NameParser getNameParser(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public NamingEnumeration<NameClassPair> list(Name name)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public NamingEnumeration<NameClassPair> list(String name)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public NamingEnumeration<Binding> listBindings(Name name)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public NamingEnumeration<Binding> listBindings(String name)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public Object lookup(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Object lookup(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Object lookupLink(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Object lookupLink(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void rebind(Name name, Object obj) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void rebind(String name, Object obj) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public Object removeFromEnvironment(String propName)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public void rename(Name oldName, Name newName) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void rename(String oldName, String newName)
		throws NamingException {

		throw new OperationNotSupportedException();
	}

	public void unbind(Name name) throws NamingException {
		throw new OperationNotSupportedException();
	}

	public void unbind(String name) throws NamingException {
		throw new OperationNotSupportedException();
	}

}