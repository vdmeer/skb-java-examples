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

import de.vandermeer.execs.AbstractAppliction;
import de.vandermeer.shell.SkbShell;
import de.vandermeer.shell.commands.simple.Cmd_ExampleRunner;
import de.vandermeer.shell.commands.standard.Cmd_Bye;
import de.vandermeer.shell.commands.standard.Cmd_Exit;
import de.vandermeer.shell.commands.standard.Cmd_HelpSetList;
import de.vandermeer.shell.commands.standard.Cmd_HelpSetTable;
import de.vandermeer.shell.commands.standard.Cmd_Quit;
import de.vandermeer.shell.commands.standard.Cmd_Script;
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
import de.vandermeer.skb.interfaces.application.ApoCliParser;

/**
 * Examples for using AsciiParagraph implemented as an SKB shell.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.7
 */
public class AsciiParagraph_Shell extends AbstractAppliction {

	/** Application name. */
	public final static String APP_NAME = "asciiparagraph-shell";

	/** Application display name. */
	public final static String APP_DISPLAY_NAME = "AsciiParagraph Example Shell";

	/** Application version, should be same as the version in the class JavaDoc. */
	public final static String APP_VERSION = "v0.0.8 build 170404 (04-Apr-17) for Java 1.8";

	/** The shell used by this application. */
	protected SkbShell atsh;

	/** List of commands added to the shell. */
	protected final ArrayList<String> commands = new ArrayList<>();

	/**
	 * Returns a new shell.
	 */
	public AsciiParagraph_Shell(){
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

		this.atsh.addCommand(new Cmd_Script(ShellCategories.STD));

		this.atsh.addCommand(new Cmd_Exit(ShellCategories.STD));
		this.atsh.addCommand(new Cmd_Quit(ShellCategories.STD));
		this.atsh.addCommand(new Cmd_Bye(ShellCategories.STD));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_00_Getting_Started(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_00b_Width_Behavior(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_01a_WS_Behavior_Simple(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_01b_WS_Behavior_More(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_01c_ConditionalLineBreak(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_01d_Inner_WS(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_02_Alignment_Behavior(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_03_Format_Behavior(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_04_Left_Text_Margin(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_05_Right_Text_Margin(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_06_LineStartEnd_Behavior(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_07_InclusiveWidth(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_08a_Frames(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_08b_Frames_Doc(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_09a_TargetTranslators_LaTeX(), ShellCategories.BASICS));
		this.atsh.addCommand(new Cmd_ExampleRunner(new AP_09b_TargetTranslators_HTML(), ShellCategories.BASICS));

		this.atsh.addCommand(new Cmd_AllExamples(this.atsh.getCommands(), ShellCategories.BASICS));
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
		return "The AsciiParagraph Example Shell";
	}

	@Override
	public String getVersion() {
		return APP_VERSION;
	}

}
