/*******************************************************************************
 * Copyright (c) 2010 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.internal.deltacloud.ui.wizards;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.deltacloud.client.utils.StringUtils;
import org.eclipse.core.runtime.Platform;
import org.jboss.tools.common.ui.preferencevalue.StringPreferenceValue;
import org.jboss.tools.common.ui.preferencevalue.StringsPreferenceValue;
import org.jboss.tools.deltacloud.core.DeltaCloudException;

/**
 * @author André Dietisheim
 */
public class SshPrivateKeysPreferences {

	private static final String PLUGIN_ID = "org.eclipse.jsch.core";
	/**
	 * Preference keys defined by org.eclipse.jsch.
	 * 
	 * these keys are replicates from org.eclipse.jsch.internal.core.IConstants
	 */
	private static final String PRIVATEKEY = "PRIVATEKEY";
	private static final String SSH2HOME = "SSH2HOME";

	private static final String SSH_USERHOME = ".ssh";
	private static final String SSH_USERHOME_WIN32 = "ssh";

	private static StringsPreferenceValue sshPrivateKeyPreference =
			new StringsPreferenceValue(',', PRIVATEKEY, PLUGIN_ID);
	private static StringPreferenceValue sshHome = new StringPreferenceValue(SSH2HOME, PLUGIN_ID);

	/**
	 * Adds the given keyName to the ssh-preferences
	 * 
	 * @param keyName
	 *            the name of the key to add
	 */
	public static void add(String keyName) {
		sshPrivateKeyPreference.add(keyName);
	}
	
	public static String[] getKeys() {
		return sshPrivateKeyPreference.get();
	}
	
	/**
	 * Removes the given keyName from the ssh-preferences
	 * 
	 * @param keyName
	 *            the name of the key to remove
	 */
	public static void remove(String keyName) {
		sshPrivateKeyPreference.remove(keyName);
	}

	/**
	 * Returns the path to the folder that ssh keys get stored to. It either
	 * gets the preferences value from org.eclipse.jsch or uses a ssh folder in
	 * the user home. This code was built according to what
	 * org.eclipse.jsch.internal.core.PreferenceInitializer is doing.
	 * 
	 * @return the directory to store or load the ssh keys from
	 * @throws DeltaCloudException
	 *             if the directory could not be determined
	 */
	public static String getSshKeyDirectory() throws FileNotFoundException {
		String sshHomePath = sshHome.get();
		if (StringUtils.isEmpty(sshHomePath)) {
			sshHomePath = getSshSystemHome();
		}

		if (StringUtils.isEmpty(sshHomePath)) {
			throw new FileNotFoundException("Could not determine path to ssh keys directory.");
		}
		return sshHomePath;
	}

	private static String getSshSystemHome() {
		String userHomePath = System.getProperty("user.home");
		StringBuilder builder = new StringBuilder(userHomePath);
		builder.append(File.separatorChar);
		if (Platform.getOS().equals(Platform.OS_WIN32)) {
			builder.append(SSH_USERHOME_WIN32); //$NON-NLS-1$
		} else {
			builder.append(SSH_USERHOME);
		}
		return builder.toString();
	}
}
