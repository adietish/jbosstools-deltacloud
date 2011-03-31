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
package org.jboss.tools.internal.deltacloud.client.test;

import org.jboss.tools.internal.deltacloud.client.test.core.client.APIDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.test.core.client.HardwareProfileDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.test.core.client.ImageDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.test.core.client.InstanceDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.test.core.client.KeyDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.test.core.client.RealmDomUnmarshallingTest;
import org.jboss.tools.internal.deltacloud.client.utils.test.UrlBuilderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Andre Dietisheim
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	KeyDomUnmarshallingTest.class,
	InstanceDomUnmarshallingTest.class,
	ImageDomUnmarshallingTest.class,
	HardwareProfileDomUnmarshallingTest.class,
	APIDomUnmarshallingTest.class,
	RealmDomUnmarshallingTest.class,
	UrlBuilderTest.class})
public class DeltaCloudClientTestSuite {
}