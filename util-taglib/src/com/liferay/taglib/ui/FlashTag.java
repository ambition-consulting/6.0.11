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

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class FlashTag extends IncludeTag {

	public void setAlign(String align) {
		if (Validator.isNotNull(align)) {
			_align = align;
		}
	}

	public void setAllowFullScreen(String allowFullScreen) {
		if (Validator.isNotNull(allowFullScreen)) {
			_allowFullScreen = allowFullScreen;
		}
	}

	public void setAllowScriptAccess(String allowScriptAccess) {
		if (Validator.isNotNull(allowScriptAccess)) {
			_allowScriptAccess = allowScriptAccess;
		}
	}

	public void setBase(String base) {
		if (Validator.isNotNull(base)) {
			_base = base;
		}
	}

	public void setBgcolor(String bgcolor) {
		if (Validator.isNotNull(bgcolor)) {
			_bgcolor = bgcolor;
		}
	}

	public void setDevicefont(String devicefont) {
		if (Validator.isNotNull(devicefont)) {
			_devicefont = devicefont;
		}
	}

	public void setFlashvars(String flashvars) {
		if (Validator.isNotNull(flashvars)) {
			_flashvars = flashvars;
		}
	}

	public void setHeight(String height) {
		if (Validator.isNotNull(height)) {
			_height = height;
		}
	}

	public void setId(String id) {
		if (Validator.isNotNull(id)) {
			_id = id;
		}
	}

	public void setLoop(String loop) {
		if (Validator.isNotNull(loop)) {
			_loop = loop;
		}
	}

	public void setMenu(String menu) {
		if (Validator.isNotNull(menu)) {
			_menu = menu;
		}
	}

	public void setMovie(String movie) {
		_movie = movie;
	}

	public void setPlay(String play) {
		if (Validator.isNotNull(play)) {
			_play = play;
		}
	}

	public void setQuality(String quality) {
		if (Validator.isNotNull(quality)) {
			_quality = quality;
		}
	}

	public void setSalign(String salign) {
		if (Validator.isNotNull(salign)) {
			_salign = salign;
		}
	}

	public void setScale(String scale) {
		if (Validator.isNotNull(scale)) {
			_scale = scale;
		}
	}

	public void setSwliveconnect(String swliveconnect) {
		if (Validator.isNotNull(swliveconnect)) {
			_swliveconnect = swliveconnect;
		}
	}

	public void setVersion(String version) {
		if (Validator.isNotNull(version)) {
			_version = version;
		}
	}

	public void setWidth(String width) {
		if (Validator.isNotNull(width)) {
			_width = width;
		}
	}

	public void setWmode(String wmode) {
		if (Validator.isNotNull(wmode)) {
			_wmode = wmode;
		}
	}

	protected void cleanUp() {
		_align = "left";
		_allowFullScreen = Boolean.FALSE.toString();
		_allowScriptAccess = "sameDomain";
		_base = StringPool.PERIOD;
		_bgcolor = "#FFFFFF";
		_devicefont = Boolean.TRUE.toString();
		_flashvars = StringPool.BLANK;
		_height = "500";
		_id = StringPool.BLANK;
		_loop = Boolean.TRUE.toString();
		_menu = Boolean.FALSE.toString();
		_movie = StringPool.BLANK;
		_play = Boolean.FALSE.toString();
		_quality = "best";
		_salign = StringPool.BLANK;
		_scale = "showall";
		_swliveconnect = Boolean.FALSE.toString();
		_version = "7";
		_width = "100%";
		_wmode = "opaque";
	}

	protected String getPage() {
		return _PAGE;
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("liferay-ui:flash:align", _align);
		request.setAttribute(
			"liferay-ui:flash:allowFullScreen", _allowFullScreen);
		request.setAttribute(
			"liferay-ui:flash:allowScriptAccess", _allowScriptAccess);
		request.setAttribute("liferay-ui:flash:base", _base);
		request.setAttribute("liferay-ui:flash:bgcolor", _bgcolor);
		request.setAttribute("liferay-ui:flash:devicefont", _devicefont);
		request.setAttribute("liferay-ui:flash:flashvars", _flashvars);
		request.setAttribute("liferay-ui:flash:height", _height);
		request.setAttribute("liferay-ui:flash:id", _id);
		request.setAttribute("liferay-ui:flash:loop", _loop);
		request.setAttribute("liferay-ui:flash:menu", _menu);
		request.setAttribute("liferay-ui:flash:movie", _movie);
		request.setAttribute("liferay-ui:flash:play", _play);
		request.setAttribute("liferay-ui:flash:quality", _quality);
		request.setAttribute("liferay-ui:flash:salign", _salign);
		request.setAttribute("liferay-ui:flash:scale", _scale);
		request.setAttribute("liferay-ui:flash:swliveconnect", _swliveconnect);
		request.setAttribute("liferay-ui:flash:version", _version);
		request.setAttribute("liferay-ui:flash:width", _width);
		request.setAttribute("liferay-ui:flash:wmode", _wmode);
	}

	private static final String _PAGE = "/html/taglib/ui/flash/page.jsp";

	private String _align = "left";
	private String _allowFullScreen = Boolean.FALSE.toString();
	private String _allowScriptAccess = "sameDomain";
	private String _base = StringPool.PERIOD;
	private String _bgcolor = "#FFFFFF";
	private String _devicefont = Boolean.TRUE.toString();
	private String _flashvars = StringPool.BLANK;
	private String _height = "500";
	private String _id = StringPool.BLANK;
	private String _loop = Boolean.TRUE.toString();
	private String _menu = Boolean.FALSE.toString();
	private String _movie = StringPool.BLANK;
	private String _play = Boolean.FALSE.toString();
	private String _quality = "best";
	private String _salign = StringPool.BLANK;
	private String _scale = "showall";
	private String _swliveconnect = Boolean.FALSE.toString();
	private String _version = "7";
	private String _width = "100%";
	private String _wmode = "opaque";

}