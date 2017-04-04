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
import de.vandermeer.execs.options.ExecS_CliParser;

/**
 * Example of a simple executable application with command line arguments.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.6
 */
public class Application_Lang_CLI implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "app-lang-cli";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "Application-Lang-CLI";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	/** Our CLI parser. */
	ExecS_CliParser cli;

	/** Our option for German. */
	AO_G optionG = new AO_G();

	/** Our option for French. */
	AO_F optionF = new AO_F();

	/** Our option for English. */
	AO_E optionE = new AO_E();

	/**
	 * Returns a new language application.
	 */
	public Application_Lang_CLI(){
		this.cli = new ExecS_CliParser();
		this.cli.addOption(this.optionG);
		this.cli.addOption(this.optionF);
		this.cli.addOption(this.optionE);
	}

	@Override
	public int executeApplication(String[] args) {
		// parse command line, exit with help screen if error
		int ret = ExecS_Application.super.executeApplication(args);
		if(ret!=0){
			return ret;
		}

		if(this.optionG.inCli()){
			System.out.println("Hallo, hier ist die Anwendung Sprache.");
		}
		if(this.optionF.inCli()){
			System.out.println("Bonjour, ceci est le application lang.");
		}
		if(this.optionE.inCli()){
			System.out.println("Hi, this is application language.");
		}
		return 0;
	}

	@Override
	public ExecS_CliParser getCli() {
		return this.cli;
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
		return "Application example with language options and CLI options";
	}

	@Override
	public ApplicationOption<?>[] getAppOptions() {
		return new ApplicationOption<?>[]{this.optionE, this.optionF, this.optionG};
	}

	@Override
	public String getAppVersion() {
		return APP_VERSION;
	}
}
