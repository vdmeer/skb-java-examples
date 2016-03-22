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

import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShell;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating a simple table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 160319 (19-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class Example_All extends AbstractCommandInterpreter {

	/** Shell to get all commands from. */
	protected SkbShell shell;

	/**
	 * Returns a new interpreter.
	 * @param shell the shell to run commands in
	 */
	public Example_All(SkbShell shell){
		super(
				SkbShellFactory.newCommand("all", ShellStatics.BASIC_COMMANDS, "prints all examples", null)
		);
		this.shell = shell;
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		shell.parseLine("alignment");
		shell.parseLine("alignment-justified");
		shell.parseLine("ascii-list");
		shell.parseLine("colspan");
		shell.parseLine("columns cols:0");
		shell.parseLine("conditional-newline");
		shell.parseLine("conditional-newline-list");
		shell.parseLine("no-border");
		shell.parseLine("padding");
		shell.parseLine("padding-char");
		shell.parseLine("rule-styles");
		shell.parseLine("simple");
		shell.parseLine("themes");

		shell.parseLine("width-abs-even");
		shell.parseLine("width-fixed-columns");
		shell.parseLine("width-longest-line");
		shell.parseLine("width-longest-word");
		shell.parseLine("width-longest-word-max");
		shell.parseLine("width-longest-word-min");

		return 0;
	}

}
