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

package com.liferay.portal.kernel.util;

import java.util.List;
import java.util.Vector;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalLifecycleUtil {

	public static synchronized void flushDestroys() {
		_inFlushDestroys = true;

		for (PortalLifecycle portalLifecycle : _portalLifecyclesDestroy) {
			portalLifecycle.portalDestroy();
		}

		_portalLifecyclesDestroy.clear();

		_inFlushDestroys = false;
	}

	@SuppressWarnings("deprecation")
	public static synchronized void flushInits() {
		if (_portalLifecyclesInit != null) {
			for (PortalLifecycle portalLifecycle : _portalLifecyclesInit) {
				portalLifecycle.portalInit();
			}

			_portalLifecyclesInit = null;
		}

		PortalInitableUtil.flushInitables();
	}

	public static synchronized void register(PortalLifecycle portalLifecycle) {
		register(portalLifecycle, PortalLifecycle.METHOD_ALL);
	}

	public static synchronized void register(
		PortalLifecycle portalLifecycle, int method) {

		if ((method == PortalLifecycle.METHOD_ALL) ||
			(method == PortalLifecycle.METHOD_INIT)) {

			if (_portalLifecyclesInit == null) {
				portalLifecycle.portalInit();
			}
			else {
				_portalLifecyclesInit.add(portalLifecycle);
			}
		}

		if ((method == PortalLifecycle.METHOD_ALL) ||
			(method == PortalLifecycle.METHOD_DESTROY)) {

			_portalLifecyclesDestroy.add(portalLifecycle);
		}
	}

	public static synchronized void removeDestroy(
		PortalLifecycle portalLifecycle) {

		if (!_inFlushDestroys) {
			_portalLifecyclesDestroy.remove(portalLifecycle);
		}
	}

	private static boolean _inFlushDestroys;
	private static List<PortalLifecycle> _portalLifecyclesDestroy =
		new Vector<PortalLifecycle>();
	private static List<PortalLifecycle> _portalLifecyclesInit =
		new Vector<PortalLifecycle>();

}