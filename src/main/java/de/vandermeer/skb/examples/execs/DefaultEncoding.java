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

import de.vandermeer.execs.AbstractAppliction;
import de.vandermeer.skb.interfaces.application.ApoCliParser;
import de.vandermeer.skb.interfaces.console.MessageConsole;

/**
 * Example for console utilities showing console default encoding.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class DefaultEncoding extends AbstractAppliction {

	/** Application name. */
	public final static String APP_NAME = "default-encoding";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "Default-Encoding";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	/**
	 * Creates the example object.
	 */
	public DefaultEncoding(){
		super(APP_NAME, ApoCliParser.defaultParser(), null, null, null);
	}

	@Override
	public void runApplication() {
		System.out.println(MessageConsole.getDefaultEncoding());
		System.out.println();
		return;
	}

	@Override
	public String getName() {
		return APP_NAME;
	}

	@Override
	public String getDisplayName(){
		return APP_DISPLAY_NAME;
	}

	@Override
	public String getDescription() {
		return "Prints the default encoding.";
	}

	@Override
	public String getVersion() {
		return APP_VERSION;
	}
}
