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

import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;

/**
 * Example of a simple application.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 160319 (19-Mar-16) for Java 1.8
 * @since      v0.0.1
 */
public class Application1 implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "app-1";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "Application-1";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8-SNAPSHOT build 160319 (19-Mar-16) for Java 1.8";

	@Override
	public int executeApplication(String[] args) {
		System.out.println("Application1 executed");
		return 0;
	}

	@Override
	public void appHelpScreen() {
		System.out.println("Application1 help:");
		System.out.println("- This is a simple application called Application1");
		System.out.println("- no arguments, does nothing");
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
		return "Example Application1";
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
