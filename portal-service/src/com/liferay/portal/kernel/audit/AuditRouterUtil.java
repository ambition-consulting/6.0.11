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

package com.liferay.portal.kernel.audit;

/**
 * @author Michael C. Han
 */
public class AuditRouterUtil {

	public static AuditRouter getAuditRouter() {
		return _auditRouter;
	}

	public static void route(AuditMessage auditMessage) throws AuditException {
		_auditRouter.route(auditMessage);
	}

	public void setAuditRouter(AuditRouter auditRouter) {
		_auditRouter = auditRouter;
	}

	private static AuditRouter _auditRouter;

}