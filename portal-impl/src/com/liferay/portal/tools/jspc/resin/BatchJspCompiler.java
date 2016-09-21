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

package com.liferay.portal.tools.jspc.resin;

import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.util.FileImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;

/**
 * @author Brian Wing Shun Chan
 */
public class BatchJspCompiler {

	public static void main(String[] args) {
		if (args.length == 2) {
			new BatchJspCompiler(args[0], args[1]);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public BatchJspCompiler(String appDir, String classDir) {
		try {
			_appDir = appDir;
			_classDir = classDir;

			DirectoryScanner ds = new DirectoryScanner();

			ds.setBasedir(appDir);
			ds.setIncludes(new String[] {"**\\*.jsp"});

			ds.scan();

			String[] files = ds.getIncludedFiles();

			Arrays.sort(files);

			List<String> fileNames = new ArrayList<String>();

			for (int i = 0; i < files.length; i++) {
				String fileName = files[i];

				fileNames.add(fileName);

				if (((i > 0) && ((i % 200) == 0)) ||
					((i + 1) == files.length)) {

					_compile(fileNames);

					fileNames.clear();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void _compile(List<String> fileNames) throws Exception {
		if (fileNames.size() == 0) {
			return;
		}

		List<String> arguments = new ArrayList<String>();

		arguments.add("-app-dir");
		arguments.add(_appDir);
		arguments.add("-class-dir");
		arguments.add(_classDir);
		arguments.addAll(fileNames);

		MethodKey methodKey = new MethodKey(
			"com.caucho.jsp.JspCompiler", "main", String[].class);

		MethodHandler methodHandler = new MethodHandler(
			methodKey,
			(Object)arguments.toArray(new String[arguments.size()]));

		try {
			methodHandler.invoke(false);
		}
		catch (Exception e) {
			_fileUtil.write(
				_appDir + "/../jspc_error", StackTraceUtil.getStackTrace(e));
		}
	}

	private static FileImpl _fileUtil = FileImpl.getInstance();

	private String _appDir;
	private String _classDir;

}