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

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.webdav.methods.Method;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Based on <a href="http://www.webdav.org/neon/litmus/">litmus</a> 0.12.1
 * "basic" test.
 * </p>
 *
 * @author Alexander Chow
 */
public class WebDAVLitmusBasicTest extends BaseWebDAVTestCase {

	public void test02Options() {
		Tuple tuple = service(Method.OPTIONS, StringPool.BLANK, null, null);

		assertCode(HttpServletResponse.SC_OK, tuple);

		Map<String, String> headers = getHeaders(tuple);

		String allowMethods = headers.get("Allow");

		for (String method : Method.SUPPORTED_METHODS_ARRAY) {
			assertTrue(
				"Does not allow " + method, allowMethods.contains(method));
		}
	}

	public void test03PutGet() {
		putGet("res");
	}

	public void test04PutGetUTF8() {
		putGet("res-\u20AC");
	}

	public void test05PutNoParent() {
		assertCode(
			HttpServletResponse.SC_CONFLICT,
			service(Method.MKCOL, "409me/noparent", null, null));
		assertCode(
			HttpServletResponse.SC_CONFLICT,
			servicePut("409me/noparent.txt", _TEST_CONTENT.getBytes()));
	}

	public void test06MkcolOverPlain() {
		assertCode(
			HttpServletResponse.SC_METHOD_NOT_ALLOWED,
			service(Method.MKCOL, "res-\u20AC", null, null));
	}

	public void test07Delete() {
		assertCode(
			HttpServletResponse.SC_NO_CONTENT, serviceDelete("res-\u20AC"));
	}

	public void test08DeleteNull() {
		assertCode(
			HttpServletResponse.SC_NOT_FOUND, serviceDelete("404me"));
	}

	public void test09DeleteFragment() {
		assertCode(
			HttpServletResponse.SC_CREATED,
			service(Method.MKCOL, "frag", null, null));
		assertCode(
			HttpServletResponse.SC_NOT_FOUND, serviceDelete("frag/#ment"));
		assertCode(HttpServletResponse.SC_NO_CONTENT, serviceDelete("frag"));
	}

	public void test10Mkcol() {
		assertCode(
			HttpServletResponse.SC_CREATED,
			service(Method.MKCOL, "col", null, null));
	}

	public void test11MkcolAgain() {
		assertCode(
			HttpServletResponse.SC_METHOD_NOT_ALLOWED,
			service(Method.MKCOL, "col", null, null));
	}

	public void test12DeleteColl() {
		assertCode(HttpServletResponse.SC_NO_CONTENT, serviceDelete("col"));
	}

	public void test13MkcolNoParent() {
		assertCode(
			HttpServletResponse.SC_CONFLICT,
			service(Method.MKCOL, "409me/col", null, null));
	}

	public void test14MkcolWithBody() {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put(HttpHeaders.CONTENT_TYPE, "xyz-foo/bar-512");

		assertCode(
			HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
			service(
				Method.MKCOL, "mkcolbody", headers, _TEST_CONTENT.getBytes()));
	}

	protected void putGet(String fileName) {
		assertCode(
			HttpServletResponse.SC_CREATED,
			servicePut(fileName, _TEST_CONTENT.getBytes()));

		Tuple tuple = serviceGet(fileName);

		assertCode(HttpServletResponse.SC_OK, tuple);
		assertBytes(_TEST_CONTENT.getBytes(), getResponseBody(tuple));
	}

	private static final String _TEST_CONTENT =
		"LIFERAY\n" + "Enterprise.  Open Source.  For Life.";

}