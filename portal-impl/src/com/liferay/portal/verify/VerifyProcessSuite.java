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

package com.liferay.portal.verify;

/**
 * @author Alexander Chow
 */
public class VerifyProcessSuite extends VerifyProcess {

	protected void doVerify() throws Exception {
		verify(new VerifyProperties());

		verify(new VerifyMySQL());
		verify(new VerifySQLServer());

		verify(new VerifyCounter());
		verify(new VerifyUUID());

		verify(new VerifyPermission());
		verify(new VerifyRole());

		verify(new VerifyBlogs());
		verify(new VerifyBookmarks());
		verify(new VerifyCalendar());
		verify(new VerifyDocumentLibrary());
		verify(new VerifyGroup());
		verify(new VerifyImageGallery());
		verify(new VerifyJournal());
		verify(new VerifyLayout());
		verify(new VerifyMessageBoards());
		verify(new VerifyOrganization());
		verify(new VerifySocial());
		verify(new VerifyUser());
		verify(new VerifyWiki());

		// VerifyBlogsTrackbacks looks at every blog comment to see if it is a
		// trackback and verifies that the source URL is a valid URL.

		//verify(new VerifyBlogsTrackbacks());

		// VerifyImage is very powerful because it removes all images that it
		// believes is stale. Do not run this unless you are also not managing
		// images in Liferay's Image service for your custom models.

		//verify(new VerifyImage());
	}

}