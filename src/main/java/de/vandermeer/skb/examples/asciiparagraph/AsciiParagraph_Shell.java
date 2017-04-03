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

import java.util.ArrayList;

import de.vandermeer.asciiparagraph.AsciiParagraph;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.execs.ExecS_Application;
import de.vandermeer.execs.options.ApplicationOption;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.Ci_Exit;
import de.vandermeer.skb.base.shell.Ci_HelpTable;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShell;
import de.vandermeer.skb.base.shell.SkbShellCommandCategory;
import de.vandermeer.skb.base.shell.SkbShellFactory;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_00_Getting_Started;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_00b_Width_Behavior;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_01a_WS_Behavior_Simple;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_01b_WS_Behavior_More;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_01c_ConditionalLineBreak;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_01d_Inner_WS;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_02_Alignment_Behavior;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_03_Format_Behavior;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_04_Left_Text_Margin;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_05_Right_Text_Margin;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_06_LineStartEnd_Behavior;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_07_InclusiveWidth;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_08a_Frames;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_08b_Frames_Doc;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_09a_TargetTranslators_LaTeX;
import de.vandermeer.skb.examples.asciiparagraph.examples.AP_09b_TargetTranslators_HTML;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.StandardExampleRunner;

/**
 * Examples for using {@link AsciiParagraph} implemented as an SKB shell.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.0.7
 */
public class AsciiParagraph_Shell implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "asciiparagraph-shell";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "AsciiParagraph Example Shell";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8";

	/** The shell used by this application. */
	protected SkbShell atsh;

	/** List of commands added to the shell. */
	protected final ArrayList<String> commands = new ArrayList<>();

	/**
	 * Returns a new shell.
	 */
	public AsciiParagraph_Shell(){
		this.atsh = SkbShellFactory.newShell(APP_NAME, true);

		this.atsh.addCommandInterpreter(new Ci_Exit());
		this.atsh.addCommandInterpreter(new Ci_HelpTable(atsh, A7_Grids.minusBarPlusEquals()));

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_00_Getting_Started());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_00b_Width_Behavior());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_01a_WS_Behavior_Simple());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_01b_WS_Behavior_More());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_01c_ConditionalLineBreak());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_01d_Inner_WS());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_02_Alignment_Behavior());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_03_Format_Behavior());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_04_Left_Text_Margin());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_05_Right_Text_Margin());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_06_LineStartEnd_Behavior());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_07_InclusiveWidth());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_08a_Frames());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_08b_Frames_Doc());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_09a_TargetTranslators_LaTeX());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AP_09b_TargetTranslators_HTML());

		this.atsh.addCommandInterpreter(new Example_All(this.atsh, this.commands));
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
		System.out.println("The AsciiParagraph Example Shell");
	}

	@Override
	public String getAppDescription() {
		return "The AsciiParagraph Example Shell";
	}

	@Override
	public String getAppVersion() {
		return APP_VERSION;
	}

	@Override
	public ApplicationOption<?>[] getAppOptions() {
		return null;
	}

	/**
	 * Adds a new command for an example.
	 * @param category the example category
	 * @param example the example to add
	 */
	protected final void addCommand(SkbShellCommandCategory category, StandardExampleAsCmd example){
		this.commands.add(example.getCmd());
		this.atsh.addCommandInterpreter(this.createCmd(category, example));
	}

	/**
	 * Creates a new command for the example shell
	 * @param cmd the command
	 * @param category command category
	 * @param help additional help information
	 * @param example the example to execute
	 * @return
	 */
	public AbstractCommandInterpreter createCmd(SkbShellCommandCategory category, StandardExampleAsCmd example){
		return new AbstractCommandInterpreter(SkbShellFactory.newCommand(example.getCmd(), category, example.getDescription(), null)) {
			@Override
			public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
				if(command.equals(example.getCmd())){
					StandardExampleRunner ser = new StandardExampleRunner() {};
					System.out.println("\n\n");
					ser.runExampleWithCode(example);
					return 0;
				}
				return -1;
			}
		};
	}
}
