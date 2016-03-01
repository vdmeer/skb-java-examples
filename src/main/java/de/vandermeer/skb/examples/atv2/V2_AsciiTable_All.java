/* Copyright 2015 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples.atv2;

import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;

/**
 * Prints all examples for using {@link V2_AsciiTable} implemented in the {@link V2_AsciiTable_Shell}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.7 build 160301 (01-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class V2_AsciiTable_All implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "astv2-all";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "All AsciiTable V2 Examples";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.7 build 160301 (01-Mar-16) for Java 1.8";

	@Override
	public int executeApplication(String[] args) {
		V2_AsciiTable_Shell shell = new V2_AsciiTable_Shell();
		shell.atsh.parseLine("all");
		return 0;
	}

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	public String getAppDescription() {
		return "All AsciiTale V2 Examples";
	}

	@Override
	public String getAppVersion() {
		return APP_VERSION;
	}

	@Override
	public ApplicationOption<?>[] getAppOptions() {
		return null;
	}

}
