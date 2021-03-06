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

package com.liferay.util.bridges.jsf.sun;

import com.sun.faces.renderkit.RenderKitImpl;

import java.io.Writer;

import javax.faces.context.ResponseWriter;

/**
 * @author Brian Myunghun Kim
 */
public class LiferayRenderKitImpl extends RenderKitImpl {

	public ResponseWriter createResponseWriter(
		Writer writer, String contentTypeList, String characterEncoding) {

		WriterWrapper writerWrapper = new WriterWrapper(writer);

		return super.createResponseWriter(
			writerWrapper, contentTypeList, characterEncoding);
	}

}