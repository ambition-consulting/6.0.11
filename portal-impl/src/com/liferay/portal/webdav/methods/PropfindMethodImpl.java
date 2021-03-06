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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Namespace;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.webdav.InvalidRequestException;
import com.liferay.util.xml.XMLFormatter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class PropfindMethodImpl extends BasePropMethodImpl implements Method {

	public int process(WebDAVRequest webDavRequest) throws WebDAVException {
		try {
			Set<Tuple> props = getProps(webDavRequest);

			return writeResponseXML(webDavRequest, props);
		}
		catch (InvalidRequestException ire) {
			return HttpServletResponse.SC_BAD_REQUEST;
		}
		catch (Exception e) {
			throw new WebDAVException(e);
		}
	}

	protected Set<Tuple> getProps(WebDAVRequest webDavRequest)
		throws InvalidRequestException {

		try {
			Set<Tuple> props = new HashSet<Tuple>();

			HttpServletRequest request = webDavRequest.getHttpServletRequest();

			String xml = new String(
				FileUtil.getBytes(request.getInputStream()));

			if (Validator.isNull(xml)) {

				// Windows XP does not generate an xml request so the PROPFIND
				// must be generated manually. See LEP-4920.

				return generateProps(props);
			}

			if (_log.isDebugEnabled()) {
				_log.debug(
					"Request XML: \n" +
						XMLFormatter.toString(xml, StringPool.FOUR_SPACES));
			}

			Document doc = SAXReaderUtil.read(xml);

			Element root = doc.getRootElement();

			if (root.element(ALLPROP) != null) {

				// Generate props if <allprop> tag is used. See LEP-6162.

				return generateProps(props);
			}

			Element prop = root.element("prop");

			Iterator<Element> itr = prop.elements().iterator();

			while (itr.hasNext()) {
				Element el = itr.next();

				String prefix = el.getNamespacePrefix();
				String uri = el.getNamespaceURI();

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

				props.add(new Tuple(el.getName(), namespace));
			}

			return props;
		}
		catch (Exception e) {
			throw new InvalidRequestException(e);
		}
	}

	protected Set<Tuple> generateProps(Set<Tuple> props) {
		props.add(DISPLAYNAME_PAIR);
		props.add(RESOURCETYPE_PAIR);
		props.add(GETCONTENTTYPE_PAIR);
		props.add(GETCONTENTLENGTH_PAIR);
		props.add(GETLASTMODIFIED_PAIR);
		props.add(LOCKDISCOVERY_PAIR);

		// RFC 3253 Currently Unsupported

		//props.add(new Tuple("checked-in", WebDAVUtil.DAV_URI));
		//props.add(new Tuple("checked-out", WebDAVUtil.DAV_URI));
		//props.add(new Tuple("version-name", WebDAVUtil.DAV_URI));

		return props;
	}

	private static Log _log = LogFactoryUtil.getLog(PropfindMethodImpl.class);

}