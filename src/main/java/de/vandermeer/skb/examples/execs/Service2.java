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

import de.vandermeer.execs.ExecutableService;

/**
 * Example of a simple executable service with command line arguments.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150812 (12-Aug-15) for Java 1.8
 * @since      v0.0.1
 */
public class Service2 implements ExecutableService {

	@Override
	public int executeService(String[] args) {
		if(args.length==0){
			this.serviceHelpScreen();
			return -1;
		}

		switch(args[0]){
			case "-g":
				System.out.println("Hallo, hier ist service zwei.");
				break;
			case "-f":
				System.out.println("Bonjour, ceci est le service deux.");
				break;
			case "-e":
				System.out.println("Hi, this is service two.");
				break;
			default:
				System.out.println("Service2: unknown option: " + args[0]);
				return -1;
		}
		return 0;
	}

	@Override
	public void serviceHelpScreen() {
		System.out.println("Service2 help:");
		System.out.println("- this is a simple service called Service2");

		System.out.println("-g for a German greeting");
		System.out.println("-e for an English greeting");
		System.out.println("-f for a French greeting");
	}

	@Override
	public String getName() {
		return "example-service-2";
	}
}
