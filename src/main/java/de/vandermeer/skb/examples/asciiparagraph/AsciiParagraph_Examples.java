/* Copyright 2017 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples.asciiparagraph;

import de.vandermeer.asciiparagraph.AsciiParagraph;
import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;

/**
 * Prints all examples for using {@link AsciiParagraph} implemented in the {@link AsciiParagraph_Shell}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.8
 */
public class AsciiParagraph_Examples implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "asciiparagraph-examples";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "All AsciiParagraph Examples";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	@Override
	public int executeApplication(String[] args) {
		AsciiParagraph_Shell shell = new AsciiParagraph_Shell();
		shell.atsh.parseLine("all");
		return 0;
	}

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	public String getAppDescription() {
		return "All AsciiParagraph Examples";
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
