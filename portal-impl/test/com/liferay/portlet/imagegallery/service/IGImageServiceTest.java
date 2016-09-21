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

package com.liferay.portlet.imagegallery.service;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.BaseServiceTestCase;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.TestPropsValues;
import com.liferay.portlet.imagegallery.DuplicateImageNameException;
import com.liferay.portlet.imagegallery.NoSuchFolderException;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGFolderConstants;

import java.io.File;

/**
 * @author Alexander Chow
 */
public class IGImageServiceTest extends BaseServiceTestCase {

	public void setUp() throws Exception {
		super.setUp();

		String name = "Test Folder";
		String description = "This is a test folder.";

		boolean addCommunityPermissions = true;
		boolean addGuestPermissions = true;

		Layout layout = LayoutLocalServiceUtil.getLayout(
			TestPropsValues.LAYOUT_PLID);

		try {
			_folder = IGFolderServiceUtil.getFolder(
				layout.getGroupId(), IGFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				name);

			IGFolderServiceUtil.deleteFolder(_folder.getFolderId());

			_folder = null;
		}
		catch (NoSuchFolderException nsfe) {
		}

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(addCommunityPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);
		serviceContext.setScopeGroupId(layout.getGroupId());
		serviceContext.setPlid(layout.getPlid());

		_folder = IGFolderServiceUtil.addFolder(
			IGFolderConstants.DEFAULT_PARENT_FOLDER_ID, name, description,
			serviceContext);
	}

	public void tearDown() throws Exception {
		if (_folder != null) {
			IGFolderServiceUtil.deleteFolder(_folder.getFolderId());
		}

		super.tearDown();
	}

	public void testAddImageWithDuplicateName() throws Exception {
		String name = "liferay.png";
		String description = StringPool.BLANK;
		File image = new File(getClassResource(
			"com/liferay/portlet/imagegallery/dependencies/" + name).getPath());
		String contentType = "png";

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		IGImageServiceUtil.addImage(
			_folder.getGroupId(), _folder.getFolderId(), name, description,
			image, contentType, serviceContext);

		try {
			IGImageServiceUtil.addImage(
				_folder.getGroupId(), _folder.getFolderId(), name, description,
				image, contentType, serviceContext);

			fail("Able to add two images of the name " + name);
		}
		catch (DuplicateImageNameException dine) {
		}
	}

	private IGFolder _folder;

}