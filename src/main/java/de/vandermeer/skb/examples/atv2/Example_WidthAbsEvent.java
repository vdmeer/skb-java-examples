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
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthAbsoluteEven;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating a simple table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8-SNAPSHOT build 160306 (06-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class Example_WidthAbsEvent extends AbstractCommandInterpreter {

	/**
	 * Returns a new interpreter.
	 */
	public Example_WidthAbsEvent(){
		super(
				SkbShellFactory.newCommand("width-abs-even", ShellStatics.WIDTH_COMMANDS, "prints 3 tables with table width for absolute size and even column distribution", null)
		);
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		V2_AsciiTable at = new V2_AsciiTable();
		at.addRule();
		at.addRow("col1", "col2", "col3");
		at.addRule();

		V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());

		rend.setWidth(new WidthAbsoluteEven(50));
		System.out.println("absolute even 1");
		System.out.println(rend.render(at));

		rend.setWidth(new WidthAbsoluteEven(30));
		System.out.println("absolute even 2");
		System.out.println(rend.render(at));

		rend.setWidth(new WidthAbsoluteEven(20));
		System.out.println("absolute even 3");
		System.out.println(rend.render(at));
		return 0;
	}

}
