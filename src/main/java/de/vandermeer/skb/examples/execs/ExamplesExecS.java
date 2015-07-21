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
import de.vandermeer.skb.examples.ConsoleTable;
import de.vandermeer.skb.examples.Messages;

/**
 * An ExecS class for the examples and an example for an ExecS class.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150721 (21-Jul-15) for Java 1.8
 * @since      v0.0.6
 */
public class ExamplesExecS extends ExecS {

	public ExamplesExecS(){
		super("examples-execs");

		this.classmap.clear();
		this.addService("console-table", ConsoleTable.class);
		this.addService("messages", Messages.class);
		this.addService("default-encoding", DefaultEncoding.class);
		this.addService("service1", Service1.class);
		this.addService("service2", Service2.class);
	}
}
