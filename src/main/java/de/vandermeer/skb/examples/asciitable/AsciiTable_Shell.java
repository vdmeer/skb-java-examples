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

import de.vandermeer.execs.AbstractAppliction;
import de.vandermeer.shell.SkbShell;
import de.vandermeer.shell.commands.simple.Cmd_ExampleRunner;
import de.vandermeer.shell.commands.standard.Cmd_HelpSetList;
import de.vandermeer.shell.commands.standard.Cmd_HelpSetTable;
import de.vandermeer.shell.commands.standard.Cmd_Bye;
import de.vandermeer.shell.commands.standard.Cmd_Exit;
import de.vandermeer.shell.commands.standard.Cmd_Quit;
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
import de.vandermeer.skb.interfaces.application.ApoCliParser;

/**
 * Examples for using AsciiTable implemented as an SKB shell.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.7
 */
public final class AsciiTable_Shell extends AbstractAppliction {

	/** Application name. */
	public final static String APP_NAME = "asciitable-shell";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "AsciiTable Example Shell";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	/** The shell used by this application. */
	protected SkbShell atsh;

	/** List of commands added to the shell. */
	protected final ArrayList<String> commands = new ArrayList<>();

	/**
	 * Returns a new shell.
	 */
	public AsciiTable_Shell(){
		super(APP_NAME, ApoCliParser.defaultParser(), null, null, null);
		this.atsh = new SkbShell(APP_NAME, APP_DISPLAY_NAME, APP_VERSION, this.getDescription());

		this.atsh.addCommand(
				new Cmd_HelpSetTable(
						ShellCategories.STD,
						this.atsh.getCommands()
				)
		);
		this.atsh.addCommand(
				new Cmd_HelpSetList(
						ShellCategories.STD,
						this.atsh.getCommands()
				)
		);

		this.atsh.addCommand(new Cmd_Exit(ShellCategories.STD));
		this.atsh.addCommand(new Cmd_Quit(ShellCategories.STD));
		this.atsh.addCommand(new Cmd_Bye(ShellCategories.STD));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_00_Getting_Started(), ShellCategories.BASIC));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_00b_WidthBehavior(), ShellCategories.WIDTH));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_01b_1Column(), ShellCategories.COLUMNS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_01c_2Columns(), ShellCategories.COLUMNS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_01d_3Columns(), ShellCategories.COLUMNS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_01e_4Columns(), ShellCategories.COLUMNS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_01f_5Columns(), ShellCategories.COLUMNS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_02_ColSpan(), ShellCategories.COLUMNS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_03_AlignmentOptions(), ShellCategories.COLUMNS_CONTENT));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_03a_AlignmentTable(), ShellCategories.COLUMNS_CONTENT));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_03b_AlignmentRow(), ShellCategories.COLUMNS_CONTENT));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_03c_AlignmentCell(), ShellCategories.COLUMNS_CONTENT));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_04a_Padding_Table(), ShellCategories.PADDING));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_04b_Padding_Row(), ShellCategories.PADDING));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_04c_Padding_Cell(), ShellCategories.PADDING));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_05_MarginBehavior(), ShellCategories.MARGINS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_06a_Grids(), ShellCategories.THEME));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_06b_GridRuleStyle(), ShellCategories.THEME));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_06c_GridThemes(), ShellCategories.THEME));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_06d_NewGrid(), ShellCategories.THEME));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07a_Width_AbsoluteEven(), ShellCategories.WIDTH));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07b_Width_Fixed(), ShellCategories.WIDTH));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07c_LongestLine(), ShellCategories.WIDTH));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07d_LongestWord(), ShellCategories.WIDTH));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07e_LongestWordMax(), ShellCategories.WIDTH));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_07f_LongestWordMin(), ShellCategories.WIDTH));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_08a_TargetTranslator_Latex(), ShellCategories.TRANSLATORS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_08b_TargetTranslator_HTML(), ShellCategories.TRANSLATORS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_09a_URIs(), ShellCategories.MISC));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_09b_ConditionalLinebreak(), ShellCategories.MISC));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AT_09c_ListWithLinebreaks(), ShellCategories.MISC));

		this.atsh.addCommand(new Cmd_AllExamples(this.atsh.getCommands(), ShellCategories.ALL));
	}

	@Override
	public void runApplication() {
		this.atsh.runShell();
	}

	@Override
	public String getName() {
		return APP_NAME;
	}

	@Override
	public String getDisplayName() {
		return APP_DISPLAY_NAME;
	}

	@Override
	public String getDescription() {
		return "The AsciiTable Example Shell";
	}

	@Override
	public String getVersion() {
		return APP_VERSION;
	}

}
