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

import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;

/**
 * Example of a simple application with command line arguments.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.7-SNAPSHOT build 160301 (01-Mar-16) for Java 1.8
 * @since      v0.0.1
 */
public class Application_Lang implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "app-lang";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "Application-Lang";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.7-SNAPSHOT build 160301 (01-Mar-16) for Java 1.8";

	@Override
	public int executeApplication(String[] args) {
		if(args.length==0){
			this.appHelpScreen();
			return -1;
		}

		switch(args[0]){
			case "-g":
				System.out.println("Hallo, hier ist die Anwendung Sprache.");
				break;
			case "-f":
				System.out.println("Bonjour, ceci est le application lang.");
				break;
			case "-e":
				System.out.println("Hi, this is application language.");
				break;
			default:
				System.out.println(this.getAppName() + ": unknown option: " + args[0]);
				return -1;
		}
		return 0;
	}

	@Override
	public void appHelpScreen() {
		System.out.println(this.getAppName() + " help:");
		System.out.println("- this is a simple application called " + this.getAppName());

		System.out.println("-g for a German greeting");
		System.out.println("-e for an English greeting");
		System.out.println("-f for a French greeting");
	}

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	public String getAppDisplayName(){
		return APP_DISPLAY_NAME;
	}

	@Override
	public String getAppDescription() {
		return "Application example with language options";
	}

	@Override
	public ApplicationOption<?>[] getAppOptions() {
		return null;
	}

	@Override
	public String getAppVersion() {
		return APP_VERSION;
	}
}
