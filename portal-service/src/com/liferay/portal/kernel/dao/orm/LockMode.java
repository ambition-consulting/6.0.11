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

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public interface LockMode {

	public static final LockMode FORCE = new LockModeImpl("FORCE");

	public static final LockMode NONE = new LockModeImpl("NONE");

	public static final LockMode OPTIMISTIC = new LockModeImpl("OPTIMISTIC");

	public static final LockMode OPTIMISTIC_FORCE_INCREMENT = new LockModeImpl(
		"OPTIMISTIC_FORCE_INCREMENT");

	public static final LockMode PESSIMISTIC_FORCE_INCREMENT = new LockModeImpl(
		"PESSIMISTIC_FORCE_INCREMENT");

	public static final LockMode PESSIMISTIC_READ = new LockModeImpl(
		"PESSIMISTIC_READ");

	public static final LockMode PESSIMISTIC_WRITE = new LockModeImpl(
		"PESSIMISTIC_WRITE");

	public static final LockMode READ = new LockModeImpl("READ");

	public static final LockMode UPGRADE = new LockModeImpl("UPGRADE");

	public static final LockMode UPGRADE_NOWAIT =
		new LockModeImpl("UPGRADE_NOWAIT");

	public static final LockMode WRITE = new LockModeImpl("WRITE");

	public String getName();

}