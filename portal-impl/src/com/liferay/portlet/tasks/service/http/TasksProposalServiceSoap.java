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

package com.liferay.portlet.tasks.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portlet.tasks.service.TasksProposalServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portlet.tasks.service.TasksProposalServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portlet.tasks.model.TasksProposalSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portlet.tasks.model.TasksProposal}, that is translated to a
 * {@link com.liferay.portlet.tasks.model.TasksProposalSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <b>tunnel.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TasksProposalServiceHttp
 * @see       com.liferay.portlet.tasks.model.TasksProposalSoap
 * @see       com.liferay.portlet.tasks.service.TasksProposalServiceUtil
 * @generated
 */
public class TasksProposalServiceSoap {
	public static com.liferay.portlet.tasks.model.TasksProposalSoap addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			com.liferay.portlet.tasks.model.TasksProposal returnValue = TasksProposalServiceUtil.addProposal(groupId,
					className, classPK, name, description, reviewUserId,
					addCommunityPermissions, addGuestPermissions);

			return com.liferay.portlet.tasks.model.TasksProposalSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.tasks.model.TasksProposalSoap addProposal(
		long groupId, java.lang.String className, java.lang.String classPK,
		java.lang.String name, java.lang.String description, long reviewUserId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.liferay.portlet.tasks.model.TasksProposal returnValue = TasksProposalServiceUtil.addProposal(groupId,
					className, classPK, name, description, reviewUserId,
					communityPermissions, guestPermissions);

			return com.liferay.portlet.tasks.model.TasksProposalSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteProposal(long proposalId)
		throws RemoteException {
		try {
			TasksProposalServiceUtil.deleteProposal(proposalId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.tasks.model.TasksProposalSoap updateProposal(
		long proposalId, java.lang.String description, int dueDateMonth,
		int dueDateDay, int dueDateYear, int dueDateHour, int dueDateMinute)
		throws RemoteException {
		try {
			com.liferay.portlet.tasks.model.TasksProposal returnValue = TasksProposalServiceUtil.updateProposal(proposalId,
					description, dueDateMonth, dueDateDay, dueDateYear,
					dueDateHour, dueDateMinute);

			return com.liferay.portlet.tasks.model.TasksProposalSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TasksProposalServiceSoap.class);
}