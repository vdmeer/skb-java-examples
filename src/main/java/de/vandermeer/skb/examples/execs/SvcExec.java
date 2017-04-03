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

package de.vandermeer.skb.examples.execs;

import de.vandermeer.execs.ExecS;
import de.vandermeer.skb.examples.execs.lang.Application_Lang;

/**
 * Example for using ExecS application executor.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.0.1
 */
public class SvcExec extends ExecS {

	public SvcExec(){
		super("svc-exec");
		this.addApplication("svc1", Application1.class);
		this.addApplication("svc2", Application_Lang.class);
	}

	/**
	 * Public main to start the application executor.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SvcExec execs = new SvcExec();
		int ret = execs.execute(args);
		System.exit(ret);
	}

}
