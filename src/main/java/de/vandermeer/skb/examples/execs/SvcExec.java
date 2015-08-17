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

/**
 * Example for using ExecS service executor.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150812 (12-Aug-15) for Java 1.8
 * @since      v0.0.1
 */
public class SvcExec extends ExecS {

	public SvcExec(){
		super("svc-exec");
		this.addService("svc1", Service1.class);
		this.addService("svc2", Service2.class);
	}

	/**
	 * Public main to start any SKB Service.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SvcExec run = new SvcExec();
		int ret = run.execute(args);
		System.exit(ret);
	}

}
