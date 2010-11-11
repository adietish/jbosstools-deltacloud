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
package org.jboss.tools.deltacloud.ui.commands;

import java.util.Collection;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.jboss.tools.deltacloud.core.DeltaCloudInstance;
import org.jboss.tools.internal.deltacloud.ui.utils.UIUtils;

/**
 * A dialog that allows the user to select CVInstanceElements
 * 
 * @see DeltaCloudInstance
 */
public class DeltaCloudInstanceDialog extends ListSelectionDialog {

	private static class CloudElementNameProvider extends LabelProvider {
		public String getText(Object element) {
			DeltaCloudInstance instance = UIUtils.adapt(element, DeltaCloudInstance.class);
			if (instance != null) {
				return instance.getName();
			} else {
				return null;
			}
		}
	};

	public DeltaCloudInstanceDialog(Shell parentShell, Collection<DeltaCloudInstance> cloudViewElements, String title, String message) {
		super(parentShell
				, cloudViewElements
				, ArrayContentProvider.getInstance()
				, new CloudElementNameProvider()
				, message);
		setTitle(title);
	}
}