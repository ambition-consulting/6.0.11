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

package com.liferay.portal.webdav;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.webdav.WebDAVUtil;
import com.liferay.portal.webdav.methods.Method;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Based on Microsoft Office 2008 for OS X.
 * </p>
 *
 * @author Alexander Chow
 */
public class WebDAVOSXTest extends BaseWebDAVTestCase {

	public void testMSOffice0Setup() throws Exception {
		_testFileBytes = FileUtil.getBytes(new File(_OFFICE_TEST_DOCX));
		_testMetaBytes = FileUtil.getBytes(new File(_OFFICE_TEST_META_DOCX));
		_testDeltaBytes = FileUtil.getBytes(new File(_OFFICE_TEST_DELTA_DOCX));
	}

	public void testMSOffice1Create() throws Exception {
		Tuple tuple = null;

		assertCode(
			HttpServletResponse.SC_NOT_FOUND, servicePropFind(_TEST_FILE_NAME));
		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(
				_TEST_FILE_NAME, _testFileBytes, getLock(_TEST_FILE_NAME)));

		for (int i = 0; i < 3; i++) {
			lock(_TEST_FILE_NAME);
			unlock(_TEST_FILE_NAME);
		}

		lock(_TEST_FILE_NAME);

		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(
				_TEST_FILE_NAME, _testFileBytes, getLock(_TEST_FILE_NAME)));

		unlock(_TEST_FILE_NAME);

		for (int i = 0 ; i < 3; i++) {
			lock(_TEST_FILE_NAME);

			tuple = serviceGet(_TEST_FILE_NAME);

			assertCode(HttpServletResponse.SC_OK, tuple);
			assertBytes(_testFileBytes, getResponseBody(tuple));

			unlock(_TEST_FILE_NAME);
		}

		for (int i = 0; i < 2; i++) {
			assertCode(
				HttpServletResponse.SC_NOT_FOUND,
				servicePropFind(_TEST_META_NAME));
			assertCode(
				HttpServletResponse.SC_CREATED,
				servicePut(_TEST_META_NAME, _testMetaBytes));

			lock(_TEST_META_NAME);

			assertCode(
				HttpServletResponse.SC_CREATED,
				servicePut(
					_TEST_META_NAME, _testMetaBytes, getLock(_TEST_META_NAME)));
			assertCode(
				WebDAVUtil.SC_MULTI_STATUS, servicePropFind(_TEST_META_NAME));

			unlock(_TEST_META_NAME);
			lock(_TEST_META_NAME);

			if (i == 0) {
				unlock(_TEST_META_NAME);

				assertCode(
					HttpServletResponse.SC_NO_CONTENT,
					serviceDelete(_TEST_META_NAME));
			}
			else {
				tuple = serviceGet(_TEST_META_NAME);

				assertCode(HttpServletResponse.SC_OK, tuple);
				assertBytes(_testMetaBytes, getResponseBody(tuple));
				assertCode(
					HttpServletResponse.SC_CREATED,
					servicePut(
						_TEST_META_NAME, _testMetaBytes,
						getLock(_TEST_META_NAME)));
				assertCode(
					WebDAVUtil.SC_MULTI_STATUS,
					servicePropFind(_TEST_META_NAME));

				unlock(_TEST_META_NAME);
				lock(_TEST_META_NAME);

				tuple = serviceGet(_TEST_META_NAME);

				assertCode(HttpServletResponse.SC_OK, tuple);
				assertBytes(_testMetaBytes, getResponseBody(tuple));

				unlock(_TEST_META_NAME);
			}
		}
	}

	public void testMSOffice2Open() throws Exception {
		Tuple tuple = null;

		assertCode(
			WebDAVUtil.SC_MULTI_STATUS, servicePropFind(_TEST_FILE_NAME));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND, servicePropFind("MCF-Test.docx"));

		lock(_TEST_FILE_NAME);

		tuple = serviceGet(_TEST_FILE_NAME);

		assertCode(HttpServletResponse.SC_OK, tuple);
		assertBytes(_testFileBytes, getResponseBody(tuple));

		unlock(_TEST_FILE_NAME);
		lock(_TEST_FILE_NAME);

		tuple = serviceGet(_TEST_FILE_NAME);

		assertCode(HttpServletResponse.SC_OK, tuple);
		assertBytes(_testFileBytes, getResponseBody(tuple));
	}

	public void testMSOffice3Modify() throws Exception {
		Tuple tuple = null;

		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_FILE_NAME_1));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind("MCF-Word Work File D_1.tmp"));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_FILE_NAME_1));
		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(_TEMP_FILE_NAME_1, _testDeltaBytes));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_META_NAME_1));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_META_NAME_1));
		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(_TEMP_META_NAME_1, _testMetaBytes));

		lock(_TEMP_META_NAME_1);

		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(
				_TEMP_META_NAME_1, _testMetaBytes, getLock(_TEMP_META_NAME_1)));
		assertCode(
			WebDAVUtil.SC_MULTI_STATUS, servicePropFind(_TEMP_FILE_NAME_1));

		unlock(_TEMP_META_NAME_1);
		lock(_TEMP_FILE_NAME_1);
		unlock(_TEMP_FILE_NAME_1);
		lock(_TEMP_FILE_NAME_1);

		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(
				_TEMP_FILE_NAME_1, _testDeltaBytes,
				getLock(_TEMP_FILE_NAME_1)));
		assertCode(
			WebDAVUtil.SC_MULTI_STATUS, servicePropFind(_TEMP_FILE_NAME_1));

		unlock(_TEST_FILE_NAME);
		lock(_TEST_FILE_NAME);

		tuple = serviceGet(_TEST_FILE_NAME);

		assertCode(HttpServletResponse.SC_OK, tuple);
		assertBytes(_testFileBytes, getResponseBody(tuple));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind("Backup of Test.docx"));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_FILE_NAME_2));

		unlock(_TEST_FILE_NAME);

		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_FILE_NAME_2));
		assertCode(
			HttpServletResponse.SC_CREATED,
			serviceCopyOrMove(Method.MOVE, _TEST_FILE_NAME, _TEMP_FILE_NAME_2));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_META_NAME_2));
		assertCode(
			HttpServletResponse.SC_CREATED,
			serviceCopyOrMove(Method.MOVE, _TEST_META_NAME, _TEMP_META_NAME_2));

		for (int i = 0; i < 2; i++) {
			lock(_TEMP_FILE_NAME_2);

			tuple = serviceGet(_TEMP_FILE_NAME_2);

			assertCode(HttpServletResponse.SC_OK, tuple);
			assertBytes(_testFileBytes, getResponseBody(tuple));

			unlock(_TEMP_FILE_NAME_2);
		}

		for (int i = 0; i < 2; i++) {
			String orig = _TEMP_FILE_NAME_1;
			String dest = _TEST_FILE_NAME;

			if (i == 1) {
				orig = _TEMP_META_NAME_1;
				dest = _TEST_META_NAME;
			}

			assertCode(HttpServletResponse.SC_NOT_FOUND, servicePropFind(dest));
			assertCode(HttpServletResponse.SC_NOT_FOUND, servicePropFind(dest));
			assertCode(
				HttpServletResponse.SC_CREATED,
				serviceCopyOrMove(Method.MOVE, orig, dest, getLock(orig)));

			moveLock(orig, dest);
		}

		for (int i = 0; i < 2; i++) {
			lock(_TEST_FILE_NAME);

			tuple = serviceGet(_TEST_FILE_NAME);

			assertCode(HttpServletResponse.SC_OK, tuple);
			assertBytes(_testDeltaBytes, getResponseBody(tuple));

			unlock(_TEST_FILE_NAME);
		}

		lock(_TEST_META_NAME);

		tuple = serviceGet(_TEST_META_NAME);

		assertCode(HttpServletResponse.SC_OK, tuple);
		assertBytes(_testMetaBytes, getResponseBody(tuple));
		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(
				_TEST_META_NAME, _testMetaBytes, getLock(_TEST_META_NAME)));
		assertCode(
			WebDAVUtil.SC_MULTI_STATUS, servicePropFind(_TEST_META_NAME));

		unlock(_TEST_META_NAME);
		unlock(_TEMP_FILE_NAME_2);

		assertCode(
			HttpServletResponse.SC_NO_CONTENT,
			serviceDelete(_TEMP_FILE_NAME_2));
		assertCode(
			HttpServletResponse.SC_NO_CONTENT,
			serviceDelete(_TEMP_META_NAME_2));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_META_NAME_2));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND,
			servicePropFind(_TEMP_FILE_NAME_2));
	}

	protected String getLock(String fileName) {
		return _lockMap.get(fileName);
	}

	protected String getUserAgent() {
		return _USER_AGENT;
	}

	protected void lock(String fileName) {
		Tuple tuple = serviceLock(fileName, null, 0);

		assertCode(HttpServletResponse.SC_OK, tuple);

		_lockMap.put(fileName, getLock(tuple));
	}

	protected void moveLock(String orig, String dest) {
		String lock = _lockMap.remove(orig);

		if (lock != null) {
			_lockMap.put(dest, lock);
		}
	}

	protected void unlock(String fileName) {
		String lock = _lockMap.remove(fileName);

		assertCode(
			HttpServletResponse.SC_NO_CONTENT,
			serviceUnlock(fileName, lock));
	}

	private static final String _OFFICE_TEST_FILE_PREFIX =
		"portal-impl/test/com/liferay/portal/webdav/dependencies/";

	private static final String _OFFICE_TEST_DELTA_DOCX =
		_OFFICE_TEST_FILE_PREFIX + "OSX_Test_Delta.docx";

	private static final String _OFFICE_TEST_DOCX =
		_OFFICE_TEST_FILE_PREFIX + "OSX_Test.docx";

	private static final String _OFFICE_TEST_META_DOCX =
		_OFFICE_TEST_FILE_PREFIX + "OSX_Test_Meta.docx";

	private static final String _TEMP_FILE_NAME_1 = "Word Work File D_1.tmp";

	private static final String _TEMP_FILE_NAME_2 = "Word Work File L_2.tmp";

	private static final String _TEMP_META_NAME_1 = "._Word Work File D_1.tmp";

	private static final String _TEMP_META_NAME_2 = "._Word Work File L_2.tmp";

	private static final String _TEST_FILE_NAME = "Test.docx";

	private static final String _TEST_META_NAME = "._Test.docx";

	private static final String _USER_AGENT =
		"WebDAVFS/1.8 (01808000) Darwin/10.3.0 (i386)";

	private static byte[] _testDeltaBytes;
	private static byte[] _testFileBytes;
	private static byte[] _testMetaBytes;

	private Map<String, String> _lockMap = new HashMap<String, String>();

}