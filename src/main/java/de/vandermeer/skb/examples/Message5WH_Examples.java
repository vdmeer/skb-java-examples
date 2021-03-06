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

package de.vandermeer.skb.examples;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;
import de.vandermeer.skb.base.managers.MessageRenderer;
import de.vandermeer.skb.base.message.E_MessageType;
import de.vandermeer.skb.base.message.Message5WH;
import de.vandermeer.skb.base.message.Message5WH_Builder;

/**
 * Examples on how to use the message object {@link Message5WH}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class Message5WH_Examples implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "message-5wh-examples";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "Message 5WH Examples";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	@Override
	public int executeApplication(String[] args) {
		//fill a new message object with information
		Message5WH msg = new Message5WH_Builder()
			.setWho("from "+this.getClass().getSimpleName())
			.addWhat("showing a test message")
			.setWhen(null)
			.setWhere("the class API documentation", 0, 0)
			.addWhy("as a demo")
			.addHow("added to the class JavaDoc")
			.setReporter("The Author")
			.setType(E_MessageType.INFO)
			.build()
		;

		//print that information
		System.out.println(msg.render());

		System.out.println("\n");

		//define a new template for a message
		final String newTemplate =
				"where(location, line, column) ::= <<\n" +
				"<location;separator=\".\"><if(line&&column)> <line>:<column><elseif(!line&&!column)><elseif(!line)> -:<column><elseif(!column)> <line>:-<endif>\n"+
				">>\n\n" +
				"message5wh(reporter, type, who, when, where, what, why, how) ::= <<\n" +
					"<if(reporter)>Reporter = <reporter><endif>\n" +
					"<if(type)>Type     = <type><endif>\n" +
					"<if(who)>Who      = <who><endif>\n" +
					"<if(when)>When     = <when><endif>\n" +
					"<if(where)>Where    = <where><endif>\n" +
					"<if(what)>What     = <what><endif>\n" +
					"<if(why)>Why      = <why><endif>\n" +
					"<if(how)>How      = <how><endif>\n" +
				">>\n";

		//set a new group and add group to message
		STGroup stg = new STGroupString(newTemplate);

		//create a new renderer
		MessageRenderer ren = new MessageRenderer(stg);

		//print same message with new template
		System.out.println(ren.render(msg));

		return 0;
	}

	@Override
	public void appHelpScreen() {
		System.out.println("Messages:");
		System.out.println("Prints examples for Message5WH (skb-base), using the default and custom templates.");

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
		return "Prints examples for Message5WH (skb-base), using the default and custom templates.";
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
