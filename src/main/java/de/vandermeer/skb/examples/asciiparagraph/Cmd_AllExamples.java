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

import org.apache.commons.lang3.Validate;

import de.vandermeer.shell.commands.AbstractSimpleCmd;
import de.vandermeer.skb.interfaces.shell.Sh_CmdBase;
import de.vandermeer.skb.interfaces.shell.Sh_CmdCategory;
import de.vandermeer.skb.interfaces.shell.Sh_CommandSet;

/**
 * Command for running all paragraph examples.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.8
 */
public class Cmd_AllExamples extends AbstractSimpleCmd {

	/** Command set with all commands. */
	protected final Sh_CommandSet set;

	/**
	 * New command.
	 * @param set command set
	 * @param category the command's category
	 */
	public Cmd_AllExamples(Sh_CommandSet set, Sh_CmdCategory category){
		super("all", "All Examples", "runs all examples", category);
		Validate.notNull(set);
		this.set = set;
	}

	@Override
	public int executeCommand() {
		for(Sh_CmdBase cmd : this.set.sortedList()){
			if(cmd.getName()!=this.getName() && cmd.getCategory().getName()!="standard"){
				cmd.executeCommand();
			}
		}
		return 0;
	}

}
