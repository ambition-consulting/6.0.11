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

package com.liferay.portlet.wiki.engines.mediawiki;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.wiki.PageContentException;
import com.liferay.portlet.wiki.engines.WikiEngine;
import com.liferay.portlet.wiki.engines.mediawiki.matchers.EditURLMatcher;
import com.liferay.portlet.wiki.engines.mediawiki.matchers.ImageURLMatcher;
import com.liferay.portlet.wiki.engines.mediawiki.matchers.ViewURLMatcher;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletURL;

import org.apache.commons.lang.LocaleUtils;

import org.jamwiki.model.WikiUser;
import org.jamwiki.parser.ParserException;
import org.jamwiki.parser.ParserInput;
import org.jamwiki.parser.ParserOutput;
import org.jamwiki.parser.ParserUtil;
import org.jamwiki.parser.TableOfContents;

/**
 * @author Jonathan Potter
 */
public class MediaWikiEngine implements WikiEngine {

	public String convert(
			WikiPage page, PortletURL viewPageURL, PortletURL editPageURL,
			String attachmentURLPrefix)
		throws PageContentException {

		String html = parsePage(page, new ParserOutput());

		html = postParsePage(
			html, viewPageURL, editPageURL, attachmentURLPrefix);

		return html;
	}

	public Map<String, Boolean> getOutgoingLinks(WikiPage page)
		throws PageContentException {

		ParserOutput parserOutput = getParserOutput(page);

		Map<String, Boolean> outgoingLinks = new HashMap<String, Boolean>();

		for (String title : parserOutput.getLinks()) {
			Boolean existsObj = outgoingLinks.get(title);

			if (existsObj == null) {
				int pagesCount = 0;

				try {
					pagesCount = WikiPageLocalServiceUtil.getPagesCount(
						page.getNodeId(), title, true);
				}
				catch (SystemException se) {
					throw new PageContentException(se);
				}

				if (pagesCount > 0) {
					existsObj = Boolean.TRUE;
				}
				else {
					existsObj = Boolean.FALSE;

					// JAMWiki turns images into links. The postProcess method
					// turns them back to images, but the getOutgoingLinks does
					// not call postProcess, so we must manual process this
					// case.

					if (StringUtil.startsWith(title, "image:")) {
						continue;
					}
				}

				outgoingLinks.put(title.toLowerCase(), existsObj);
			}
		}

		return outgoingLinks;
	}

	public void setInterWikiConfiguration(String interWikiConfiguration) {
	}

	public void setMainConfiguration(String mainConfiguration) {
	}

	public boolean validate(long nodeId, String content) {
		return true;
	}

	protected ParserInput getParserInput(long nodeId, String topicName) {
		ParserInput parserInput = new ParserInput();

		// Dummy values

		parserInput.setContext("/wiki");
		parserInput.setLocale(LocaleUtils.toLocale("en_US"));
		parserInput.setUserDisplay("0.0.0.0");
		parserInput.setWikiUser(new WikiUser("DummyUser"));

		// Useful values

		parserInput.setAllowSectionEdit(false);
		parserInput.setTopicName(topicName);

		// Encode node id

		parserInput.setVirtualWiki("Special:Node:" + nodeId);

		// Table of contents

		TableOfContents tableOfContents = new TableOfContents();

		tableOfContents.setForceTOC(true);

		parserInput.setTableOfContents(tableOfContents);

		return parserInput;
	}

	protected ParserOutput getParserOutput(WikiPage page)
		throws PageContentException {

		ParserInput parserInput = getParserInput(
			page.getNodeId(), page.getTitle());

		ParserOutput parserOutput = null;

		try {
			parserOutput = ParserUtil.parseMetadata(
				parserInput, page.getContent());
		}
		catch (ParserException pe) {
			throw new PageContentException(pe);
		}

		return parserOutput;
	}

	protected String parsePage(WikiPage page, ParserOutput parserOutput)
		throws PageContentException {

		ParserInput parserInput = getParserInput(
			page.getNodeId(), page.getTitle());

		String html = StringPool.BLANK;

		try {
			html = ParserUtil.parse(
				parserInput, parserOutput, page.getContent());
		}
		catch (ParserException pe) {
			throw new PageContentException(pe);
		}

		return html;
	}

	protected String postParsePage(
		String content, PortletURL viewPageURL, PortletURL editPageURL,
		String attachmentURLPrefix) {

		EditURLMatcher editURLMatcher = new EditURLMatcher(editPageURL);

		content = editURLMatcher.replaceMatches(content);

		ImageURLMatcher imageURLMatcher = new ImageURLMatcher(
			attachmentURLPrefix);

		content = imageURLMatcher.replaceMatches(content);

		ViewURLMatcher viewURLMatcher = new ViewURLMatcher(viewPageURL);

		content = viewURLMatcher.replaceMatches(content);

		return content;
	}

}