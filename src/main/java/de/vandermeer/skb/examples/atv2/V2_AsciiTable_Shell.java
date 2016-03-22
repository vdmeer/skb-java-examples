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
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;
import de.vandermeer.skb.base.shell.Ci_Exit;
import de.vandermeer.skb.base.shell.Ci_HelpTable;
import de.vandermeer.skb.base.shell.SkbShell;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Examples for using {@link V2_AsciiTable} implemented as an SKB shell.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 160319 (19-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public final class V2_AsciiTable_Shell implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "astv2-shell";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "AsciiTable V2 Example Shell";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8-SNAPSHOT build 160319 (19-Mar-16) for Java 1.8";

	/** The shell used by this application. */
	protected SkbShell atsh;

	/**
	 * Returns a new shell.
	 */
	public V2_AsciiTable_Shell(){
		this.atsh = SkbShellFactory.newShell(APP_NAME, true);

		this.atsh.addCommandInterpreter(new Ci_Exit());
		this.atsh.addCommandInterpreter(new Ci_HelpTable(atsh, V2_E_TableThemes.UTF_LIGHT));
		this.atsh.addCommandInterpreter(new Example_Simple());
		this.atsh.addCommandInterpreter(new Example_Columns());
		this.atsh.addCommandInterpreter(new Example_Colspan());
		this.atsh.addCommandInterpreter(new Example_PaddingChar());
		this.atsh.addCommandInterpreter(new Example_Themes());
		this.atsh.addCommandInterpreter(new Example_Alignment());
		this.atsh.addCommandInterpreter(new Example_AlignmentJustified());
		this.atsh.addCommandInterpreter(new Example_Padding());
		this.atsh.addCommandInterpreter(new Example_RuleStyles());
		this.atsh.addCommandInterpreter(new Example_WidthAbsEvent());
		this.atsh.addCommandInterpreter(new Example_WidthFixedColumns());
		this.atsh.addCommandInterpreter(new Example_WidthLongestWord());
		this.atsh.addCommandInterpreter(new Example_WidthLongestWordMax());
		this.atsh.addCommandInterpreter(new Example_WidthLongestWordMin());
		this.atsh.addCommandInterpreter(new Example_WidthLongestLine());
		this.atsh.addCommandInterpreter(new Example_CondNewLine());
		this.atsh.addCommandInterpreter(new Example_CondNewlineList());
		this.atsh.addCommandInterpreter(new Example_NoBorder());
		this.atsh.addCommandInterpreter(new Example_AsciiList());
		this.atsh.addCommandInterpreter(new Example_URI());
		this.atsh.addCommandInterpreter(new Example_All(this.atsh));
	}

	@Override
	public int executeApplication(String[] args) {
		return this.atsh.runShell();
	}

	@Override
	public String getAppName() {
		return APP_NAME;
	}

	@Override
	public String getAppDisplayName() {
		return APP_DISPLAY_NAME;
	}

	@Override
	public void appHelpScreen(){
		System.out.println();
		System.out.println("The AsciiTale V2 Example Shell");
	}

	@Override
	public String getAppDescription() {
		return "The AsciiTale V2 Example Shell";
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
