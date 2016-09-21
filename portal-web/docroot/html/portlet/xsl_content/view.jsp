<%--
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
--%>

<%@ include file="/html/portlet/xsl_content/init.jsp" %>

<%
try {
	String variablePropertyKey = StringPool.BLANK;
	String variablePropertyValue = StringPool.BLANK;

	xmlURL = StringUtil.replace(xmlURL,"@portal_url@", themeDisplay.getPortalURL());
	xslURL = StringUtil.replace(xslURL,"@portal_url@", themeDisplay.getPortalURL());

	int bracketBegin = xmlURL.indexOf("[");
	int bracketEnd = -1;

	if (bracketBegin > -1) {
		bracketEnd = xmlURL.indexOf("]", bracketBegin);

		if (bracketEnd > -1 && ((bracketEnd - bracketBegin) > 0)) {
			String[] compilerTagNames = (String[])request.getAttribute(WebKeys.TAGS_COMPILER_ENTRIES);

			if (compilerTagNames.length > 0) {
				String category = null;
				String propertyName = null;

				variablePropertyKey = xmlURL.substring(bracketBegin + 1, bracketEnd);

				category = variablePropertyKey;

				int pos = variablePropertyKey.indexOf(StringPool.PERIOD);

				if (pos != -1) {
					category = variablePropertyKey.substring(0, pos);
					propertyName = variablePropertyKey.substring(pos + 1);
				}

				for (String tagName : compilerTagNames) {
					try {
						AssetTag assetTag = AssetTagLocalServiceUtil.getTag(scopeGroupId, tagName);

						AssetTagProperty assetTagProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(assetTag.getTagId(), "category");

						variablePropertyValue = assetTagProperty.getValue();

						if (category.equals(variablePropertyValue)) {
							if (pos == -1) {
								variablePropertyValue = assetTag.getName();
							}
							else {
								assetTagProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(assetTag.getTagId(), propertyName);

								variablePropertyValue = assetTagProperty.getValue();
							}

							xmlURL = StringUtil.replace(xmlURL, "[" + variablePropertyKey + "]", variablePropertyValue.toUpperCase());

							break;
						}
					}
					catch (NoSuchTagException nste) {
						_log.warn(nste);
					}
					catch (NoSuchTagPropertyException nstpe) {
						_log.warn(nstpe);
					}
				}
			}
		}
	}

	String content = XSLContentUtil.transform(new URL(xmlURL), new URL(xslURL));
%>

	<%= content %>

<%
}
catch (Exception e) {
	_log.error(e.getMessage());
%>

	<div class="portlet-msg-error">
		<liferay-ui:message key="an-error-occurred-while-processing-your-xml-and-xsl" />
	</div>

<%
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.xsl_content.view.jsp");
%>