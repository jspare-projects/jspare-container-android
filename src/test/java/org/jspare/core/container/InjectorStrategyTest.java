/*
 * Copyright 2016 JSpare.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.jspare.core.container;

import static org.jspare.core.container.Environment.my;

import org.jspare.core.AbstractApplicationTest;
import org.jspare.core.bootstrap.EnvironmentBuilder;
import org.jspare.core.dummy.DummyBar;
import org.jspare.core.dummy.DummyBarStrategy;
import org.jspare.core.dummy.FooDummyResource;
import org.junit.Assert;
import org.junit.Test;

public class InjectorStrategyTest extends AbstractApplicationTest {

	@Test
	public void injectStrategyTest() {

		FooDummyResource foo = my(FooDummyResource.class);

		Assert.assertNotNull(foo.getBar());
	}

	@Override
	protected EnvironmentBuilder toLoad() {

		return EnvironmentBuilder.create().addInjector(DummyBar.class, new DummyBarStrategy());
	}
}