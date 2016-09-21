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

package com.liferay.portalweb.portal;

import com.liferay.portalweb.plugins.chat.ChatTests;
import com.liferay.portalweb.plugins.flash.FlashTests;
import com.liferay.portalweb.plugins.googleadsense.GoogleAdSenseTests;
import com.liferay.portalweb.plugins.googlemaps.GoogleMapsTests;
import com.liferay.portalweb.plugins.ipgeocoder.IPGeocoderTests;
import com.liferay.portalweb.plugins.mail.MailTests;
import com.liferay.portalweb.plugins.socialcoding.SocialCodingTests;
import com.liferay.portalweb.plugins.socialnetworking.SocialNetworkingTests;
import com.liferay.portalweb.plugins.twitter.TwitterTests;
import com.liferay.portalweb.plugins.weather.WeatherTests;
import com.liferay.portalweb.plugins.webform.WebFormTests;
import com.liferay.portalweb.plugins.wsrp.WSRPTests;
import com.liferay.portalweb.portal.login.LoginTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class EEPluginsTestSuite extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(ChatTests.suite());
		testSuite.addTest(FlashTests.suite());
		testSuite.addTest(GoogleAdSenseTests.suite());
		testSuite.addTest(GoogleMapsTests.suite());
		testSuite.addTest(IPGeocoderTests.suite());
		testSuite.addTest(MailTests.suite());
		testSuite.addTest(SocialCodingTests.suite());
		testSuite.addTest(SocialNetworkingTests.suite());
		testSuite.addTest(TwitterTests.suite());
		testSuite.addTest(WeatherTests.suite());
		testSuite.addTest(WebFormTests.suite());
		testSuite.addTest(WSRPTests.suite());

		testSuite.addTestSuite(StopSeleniumTest.class);

		return testSuite;
	}

}