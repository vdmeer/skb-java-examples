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

import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShell;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command for running all paragraph examples.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.8
 */
public class Example_All extends AbstractCommandInterpreter {

	/** Shell to get all commands from. */
	protected SkbShell shell;

	/** The commands of the shell. */
	protected ArrayList<String> commands;

	/**
	 * Returns a new interpreter.
	 * @param shell the shell to run commands in
	 * @param commands list of commands the shell supports
	 */
	public Example_All(SkbShell shell, ArrayList<String> commands){
		super(
				SkbShellFactory.newCommand("all", ShellStatics.BASIC_COMMANDS, "prints all paragraph examples", null)
		);
		this.shell = shell;
		this.commands = commands;
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		for(String cmd : this.commands){
			shell.parseLine(cmd);
		}
		return 0;
	}
}
