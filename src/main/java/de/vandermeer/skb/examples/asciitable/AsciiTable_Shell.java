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

package de.vandermeer.skb.examples.asciitable;

import java.util.ArrayList;

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
import de.vandermeer.skb.examples.asciitable.examples.AT_00_Getting_Started;
import de.vandermeer.skb.examples.asciitable.examples.AT_00b_WidthBehavior;
import de.vandermeer.skb.examples.asciitable.examples.AT_01b_1Column;
import de.vandermeer.skb.examples.asciitable.examples.AT_01c_2Columns;
import de.vandermeer.skb.examples.asciitable.examples.AT_01d_3Columns;
import de.vandermeer.skb.examples.asciitable.examples.AT_01e_4Columns;
import de.vandermeer.skb.examples.asciitable.examples.AT_01f_5Columns;
import de.vandermeer.skb.examples.asciitable.examples.AT_02_ColSpan;
import de.vandermeer.skb.examples.asciitable.examples.AT_03_AlignmentOptions;
import de.vandermeer.skb.examples.asciitable.examples.AT_03a_AlignmentTable;
import de.vandermeer.skb.examples.asciitable.examples.AT_03b_AlignmentRow;
import de.vandermeer.skb.examples.asciitable.examples.AT_03c_AlignmentCell;
import de.vandermeer.skb.examples.asciitable.examples.AT_04a_Padding_Table;
import de.vandermeer.skb.examples.asciitable.examples.AT_04b_Padding_Row;
import de.vandermeer.skb.examples.asciitable.examples.AT_04c_Padding_Cell;
import de.vandermeer.skb.examples.asciitable.examples.AT_05_MarginBehavior;
import de.vandermeer.skb.examples.asciitable.examples.AT_06a_Grids;
import de.vandermeer.skb.examples.asciitable.examples.AT_06b_GridRuleStyle;
import de.vandermeer.skb.examples.asciitable.examples.AT_06c_GridThemes;
import de.vandermeer.skb.examples.asciitable.examples.AT_06d_NewGrid;
import de.vandermeer.skb.examples.asciitable.examples.AT_07a_Width_AbsoluteEven;
import de.vandermeer.skb.examples.asciitable.examples.AT_07b_Width_Fixed;
import de.vandermeer.skb.examples.asciitable.examples.AT_07c_LongestLine;
import de.vandermeer.skb.examples.asciitable.examples.AT_07d_LongestWord;
import de.vandermeer.skb.examples.asciitable.examples.AT_07e_LongestWordMax;
import de.vandermeer.skb.examples.asciitable.examples.AT_07f_LongestWordMin;
import de.vandermeer.skb.examples.asciitable.examples.AT_08a_TargetTranslator_Latex;
import de.vandermeer.skb.examples.asciitable.examples.AT_08b_TargetTranslator_HTML;
import de.vandermeer.skb.examples.asciitable.examples.AT_09a_URIs;
import de.vandermeer.skb.examples.asciitable.examples.AT_09b_ConditionalLinebreak;
import de.vandermeer.skb.examples.asciitable.examples.AT_09c_ListWithLinebreaks;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.StandardExampleRunner;

/**
 * Examples for using {@link AsciiTable} implemented as an SKB shell.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.7
 */
public final class AsciiTable_Shell implements ExecS_Application {

	/** Application name. */
	public final static String APP_NAME = "asciitable-shell";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "AsciiTable Example Shell";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8";

	/** The shell used by this application. */
	protected SkbShell atsh;

	/** List of commands added to the shell. */
	protected final ArrayList<String> commands = new ArrayList<>();

	/**
	 * Returns a new shell.
	 */
	public AsciiTable_Shell(){
		this.atsh = SkbShellFactory.newShell(APP_NAME, true);

		this.atsh.addCommandInterpreter(new Ci_Exit());
		this.atsh.addCommandInterpreter(new Ci_HelpTable(atsh, A7_Grids.minusBarPlusEquals()));

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_00_Getting_Started());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_00b_WidthBehavior());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_01b_1Column());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_01c_2Columns());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_01d_3Columns());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_01e_4Columns());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_01f_5Columns());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_02_ColSpan());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_03_AlignmentOptions());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_03a_AlignmentTable());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_03b_AlignmentRow());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_03c_AlignmentCell());

		this.addCommand(ShellStatics.PADDING_COMMANDS, new AT_04a_Padding_Table());
		this.addCommand(ShellStatics.PADDING_COMMANDS, new AT_04b_Padding_Row());
		this.addCommand(ShellStatics.PADDING_COMMANDS, new AT_04c_Padding_Cell());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_05_MarginBehavior());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_06a_Grids());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_06b_GridRuleStyle());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_06c_GridThemes());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_06d_NewGrid());

		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07a_Width_AbsoluteEven());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07b_Width_Fixed());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07c_LongestLine());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07d_LongestWord());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07e_LongestWordMax());
		this.addCommand(ShellStatics.WIDTH_COMMANDS, new AT_07f_LongestWordMin());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_08a_TargetTranslator_Latex());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_08b_TargetTranslator_HTML());

		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_09a_URIs());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_09b_ConditionalLinebreak());
		this.addCommand(ShellStatics.BASIC_COMMANDS, new AT_09c_ListWithLinebreaks());

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
		System.out.println("The AsciiTable Example Shell");
	}

	@Override
	public String getAppDescription() {
		return "The AsciiTable Example Shell";
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
