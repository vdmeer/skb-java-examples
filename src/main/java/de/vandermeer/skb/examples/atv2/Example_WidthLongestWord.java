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
import de.vandermeer.asciitable.v2.render.WidthLongestWord;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating a simple table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.7 build 160301 (01-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class Example_WidthLongestWord extends AbstractCommandInterpreter {

	/**
	 * Returns a new interpreter.
	 */
	public Example_WidthLongestWord(){
		super(
				SkbShellFactory.newCommand("width-longest-word", ShellStatics.WIDTH_COMMANDS, "prints 3 tables with calculated by the longest word in all columns", null)
		);
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		V2_AsciiTable at = new V2_AsciiTable(0);
		at.addRule();
		at.addRow("first", "information");
		at.addRule();
		at.addRow("second", "info");
		at.addRule();
		V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());
		rend.setWidth(new WidthLongestWord());
		System.out.println("longest word 1");
		System.out.println(rend.render(at));

		at = new V2_AsciiTable(1);
		at.addRule();
		at.addRow("first", "information");
		at.addRule();
		at.addRow("second", "info");
		at.addRule();
		rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());
		rend.setWidth(new WidthLongestWord());
		System.out.println("longest word 2");
		System.out.println(rend.render(at));

		at = new V2_AsciiTable(0);
		at.addRule();
		at.addRow("first", "information").setPadding(new int[]{2, 3});
		at.addRule();
		at.addRow("second", "info").setPadding(new int[]{3, 4});
		at.addRule();
		rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());
		rend.setWidth(new WidthLongestWord());
		System.out.println("longest word 3 - w/padding");
		System.out.println(rend.render(at));
		return 0;
	}

}
