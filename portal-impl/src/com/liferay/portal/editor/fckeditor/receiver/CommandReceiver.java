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

package com.liferay.portal.editor.fckeditor.receiver;

import com.liferay.portal.editor.fckeditor.command.CommandArgument;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivica Cardic
 */
public interface CommandReceiver {

	public void createFolder(
		CommandArgument argument, HttpServletRequest request,
		HttpServletResponse response);

	public void fileUpload(
		CommandArgument argument, HttpServletRequest request,
		HttpServletResponse response);

	public void getFolders(
		CommandArgument argument, HttpServletRequest request,
		HttpServletResponse response);

	public void getFoldersAndFiles(
		CommandArgument argument, HttpServletRequest request,
		HttpServletResponse response);

}