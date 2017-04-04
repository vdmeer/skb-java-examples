/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.skb.examples.execs.lang;

import org.junit.Test;

import de.vandermeer.skb.examples.execs.ExamplesExecS;

/**
 * Tests for {@link Application_Lang}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class Test_Service_Lang {

	@Test
	public void test_Service(){
		Application_Lang svc = new Application_Lang();

		svc.executeApplication(new String[]{});

		svc.executeApplication(new String[]{
				"-g"
		});

		svc.executeApplication(new String[]{
				"-f"
		});

		svc.executeApplication(new String[]{
				"-e"
		});

		svc.executeApplication(new String[]{
				"-f", "-e", "-g"
		});
	}

	@Test
	public void test_ServiceHelp(){
		ExamplesExecS execs = new ExamplesExecS();
		execs.execute(new String[]{
				Application_Lang.class.getName(),
				"-h"
		});
	}

}
