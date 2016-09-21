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

package com.liferay.portal.freemarker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.journal.NoSuchTemplateException;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Mika Koivisto
 */
public class JournalTemplateLoader extends FreeMarkerTemplateLoader {

	public Object findTemplateSource(String name) throws IOException {
		try {
			int pos = name.indexOf(JOURNAL_SEPARATOR + StringPool.SLASH);

			if (pos != -1) {
				int x = name.indexOf(CharPool.SLASH, pos);
				int y = name.indexOf(CharPool.SLASH, x + 1);
				int z = name.indexOf(CharPool.SLASH, y + 1);

				long companyId = GetterUtil.getLong(name.substring(x + 1, y));
				long groupId = GetterUtil.getLong(name.substring(y + 1, z));
				String templateId = name.substring(z + 1);

				if (_log.isDebugEnabled()) {
					_log.debug(
						"Loading {companyId=" + companyId + ",groupId=" +
							groupId + ",templateId=" + templateId + "}");
				}

				JournalTemplate template =
					JournalTemplateLocalServiceUtil.getTemplate(
						groupId, templateId);

				return template;
			}
		}
		catch (NoSuchTemplateException nste) {
			return null;
		}
		catch (PortalException pe) {
			throw new IOException("Template {" + name + "} not found");
		}
		catch (SystemException se) {
			throw new IOException("Template {" + name + "} not found");
		}

		return null;
	}

	public long getLastModified(Object templateSource) {
		if (templateSource instanceof JournalTemplate) {
			JournalTemplate template = (JournalTemplate)templateSource;

			return template.getModifiedDate().getTime();
		}

		return -1;
	}

	public Reader getReader(Object templateSource, String encoding)
		throws IOException {

		if (templateSource instanceof JournalTemplate) {
			JournalTemplate template = (JournalTemplate)templateSource;

			String xsl = template.getXsl();

			return new UnsyncBufferedReader(
				new InputStreamReader(
					new UnsyncByteArrayInputStream(xsl.getBytes()), encoding));
		}

		return null;
	}

	private static Log _log = LogFactoryUtil.getLog(
		JournalTemplateLoader.class);

}