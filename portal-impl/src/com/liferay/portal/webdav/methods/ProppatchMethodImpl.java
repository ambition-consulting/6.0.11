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

package com.liferay.portal.webdav.methods;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVStorage;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Namespace;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Lock;
import com.liferay.portal.model.WebDAVProps;
import com.liferay.portal.service.WebDAVPropsLocalServiceUtil;
import com.liferay.portal.webdav.InvalidRequestException;
import com.liferay.portal.webdav.LockException;
import com.liferay.util.xml.XMLFormatter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alexander Chow
 */
public class ProppatchMethodImpl extends BasePropMethodImpl {

	public int process(WebDAVRequest webDavRequest) throws WebDAVException {
		try {
			Set<Tuple> props = processInstructions(webDavRequest);

			return writeResponseXML(webDavRequest, props);
		}
		catch (InvalidRequestException ire) {
			if (_log.isInfoEnabled()) {
				_log.info(ire.getMessage(), ire);
			}

			return HttpServletResponse.SC_BAD_REQUEST;
		}
		catch (LockException le) {
			return WebDAVUtil.SC_LOCKED;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	protected WebDAVProps getStoredProperties(WebDAVRequest webDavRequest)
		throws PortalException, SystemException {

		WebDAVStorage storage = webDavRequest.getWebDAVStorage();

		Resource resource = storage.getResource(webDavRequest);

		WebDAVProps webDavProps = null;

		if (resource.getPrimaryKey() <= 0) {
			if (_log.isWarnEnabled()) {
				_log.warn("There is no primary key set for resource");
			}

			throw new InvalidRequestException();
		}
		else if (resource.isLocked()) {
			Lock lock = resource.getLock();

			if ((lock == null) ||
				!lock.getUuid().equals(webDavRequest.getLockUuid())) {

				throw new LockException();
			}
		}

		webDavProps = WebDAVPropsLocalServiceUtil.getWebDAVProps(
			webDavRequest.getCompanyId(), resource.getClassName(),
			resource.getPrimaryKey());

		return webDavProps;
	}

	protected Set<Tuple> processInstructions(WebDAVRequest webDavRequest)
		throws InvalidRequestException, LockException {

		try {
			Set<Tuple> newProps = new HashSet<Tuple>();

			HttpServletRequest request = webDavRequest.getHttpServletRequest();

			WebDAVProps webDavProps = getStoredProperties(webDavRequest);

			String xml = new String(
				FileUtil.getBytes(request.getInputStream()));

			if (Validator.isNull(xml)) {
				return newProps;
			}

			if (_log.isInfoEnabled()) {
				_log.info(
					"Request XML: \n" +
						XMLFormatter.toString(xml, StringPool.FOUR_SPACES));
			}

			Document document = SAXReaderUtil.read(xml);

			Element rootElement = document.getRootElement();

			Iterator<Element> itr = rootElement.elements().iterator();

			while (itr.hasNext()) {
				Element instructionElement = itr.next();

				List<Element> propElements = instructionElement.elements();

				if (propElements.size() != 1) {
					throw new InvalidRequestException(
						"There should only be one <prop /> per set or remove " +
							"instruction.");
				}

				Element propElement = propElements.get(0);

				if (!propElement.getName().equals("prop") ||
					!propElement.getNamespaceURI().equals(
						WebDAVUtil.DAV_URI.getURI())) {

					throw new InvalidRequestException(
						"Invalid <prop /> element " + propElement);
				}

				List<Element> customPropElements = propElement.elements();

				for (Element customPropElement : customPropElements) {
					String name = customPropElement.getName();
					String prefix = customPropElement.getNamespacePrefix();
					String uri = customPropElement.getNamespaceURI();
					String text = customPropElement.getText();

					Namespace namespace = null;

					if (uri.equals(WebDAVUtil.DAV_URI.getURI())) {
						namespace = WebDAVUtil.DAV_URI;
					}
					else if (Validator.isNull(prefix)) {
						namespace = SAXReaderUtil.createNamespace(uri);
					}
					else {
						namespace = SAXReaderUtil.createNamespace(prefix, uri);
					}

					if (instructionElement.getName().equals("set")) {
						if (Validator.isNull(text)) {
							webDavProps.addProp(name, prefix, uri);
						}
						else {
							webDavProps.addProp(name, prefix, uri, text);
						}

						newProps.add(
							new Tuple(customPropElement.getName(), namespace));
					}
					else if (instructionElement.getName().equals("remove")) {
						webDavProps.removeProp(name, prefix, uri);
					}
					else {
						throw new InvalidRequestException(
							"Instead of set/remove instruction, received " +
								instructionElement);
					}
				}
			}

			WebDAVPropsLocalServiceUtil.storeWebDAVProps(webDavProps);

			return newProps;
		}
		catch (LockException le) {
			throw le;
		}
		catch (Exception e) {
			throw new InvalidRequestException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProppatchMethodImpl.class);

}