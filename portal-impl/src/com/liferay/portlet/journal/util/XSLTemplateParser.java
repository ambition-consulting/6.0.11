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

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.velocity.VelocityResourceListener;
import com.liferay.util.ContentUtil;
import com.liferay.util.PwdGenerator;

import java.util.Locale;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class XSLTemplateParser extends BaseTemplateParser {

	protected String doTransform(
			ThemeDisplay themeDisplay, Map<String, String> tokens,
			String viewMode, String languageId, String xml, String script)
		throws Exception {

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		long companyId = GetterUtil.getLong(tokens.get("company_id"));
		Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
		long groupId = GetterUtil.getLong(tokens.get("group_id"));
		String journalTemplatesPath =
			VelocityResourceListener.JOURNAL_SEPARATOR + StringPool.SLASH +
				companyId + StringPool.SLASH + groupId;
		String randomNamespace =
			PwdGenerator.getPassword(PwdGenerator.KEY3, 4) +
				StringPool.UNDERLINE;
		Locale locale = LocaleUtil.fromLanguageId(languageId);

		XSLErrorListener xslErrorListener = new XSLErrorListener(locale);

		StreamSource xmlSource = new StreamSource(new UnsyncStringReader(xml));

		TransformerFactory transformerFactory =
			TransformerFactory.newInstance();

		transformerFactory.setURIResolver(new URIResolver(tokens, languageId));
		transformerFactory.setErrorListener(xslErrorListener);

		try {
			StreamSource scriptSource = new StreamSource(
				new UnsyncStringReader(script));

			Transformer transformer = transformerFactory.newTransformer(
				scriptSource);

			transformer.setParameter("company", company);
			transformer.setParameter("companyId", new Long(companyId));
			transformer.setParameter("groupId", String.valueOf(groupId));
			transformer.setParameter(
				"journalTemplatesPath", journalTemplatesPath);
			transformer.setParameter("viewMode", viewMode);
			transformer.setParameter("locale", locale);
			transformer.setParameter(
				"permissionChecker",
				PermissionThreadLocal.getPermissionChecker());
			transformer.setParameter("randomNamespace", randomNamespace);

			transformer.transform(
				xmlSource, new StreamResult(unsyncByteArrayOutputStream));
		}
		catch (Exception e1) {
			String errorTemplate = ContentUtil.get(
				PropsValues.JOURNAL_ERROR_TEMPLATE_XSL);

			StreamSource scriptSource = new StreamSource(
				new UnsyncStringReader(errorTemplate));

			Transformer transformer = transformerFactory.newTransformer(
				scriptSource);

			transformer.setParameter("company", company);
			transformer.setParameter("companyId", new Long(companyId));
			transformer.setParameter("groupId", String.valueOf(groupId));
			transformer.setParameter(
				"journalTemplatesPath", journalTemplatesPath);
			transformer.setParameter("locale", locale);
			transformer.setParameter("randomNamespace", randomNamespace);

			transformer.setParameter(
				"exception", xslErrorListener.getMessageAndLocation());
			transformer.setParameter("script", script);

			if (xslErrorListener.getLocation() != null) {
				transformer.setParameter(
					"column", new Integer(xslErrorListener.getColumnNumber()));
				transformer.setParameter(
					"line", new Integer(xslErrorListener.getLineNumber()));
			}

			transformer.transform(
				xmlSource, new StreamResult(unsyncByteArrayOutputStream));
		}

		return unsyncByteArrayOutputStream.toString(StringPool.UTF8);
	}

}