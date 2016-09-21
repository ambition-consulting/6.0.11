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

package com.liferay.portal.tools;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.FileImpl;

import java.io.File;

/**
 * @author Brian Wing Shun Chan
 */
public class CSSFormatter {

	public static void main(String[] args) {
		if (args.length == 1) {
			new CSSFormatter(new File(args[0]));
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public CSSFormatter(File file) {
		try {
			String content = _fileUtil.read(file);

			content = StringUtil.replace(
				content,
				new String[] {
					"*/\n", "*/ /*", "*/" + StringPool.FOUR_SPACES + "/*"
				},
				new String[] {
					"*/\n\n", "*/\n\n/*", "*/\n\n/*"
				});

			_fileUtil.write(file, content, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static FileImpl _fileUtil = FileImpl.getInstance();

}