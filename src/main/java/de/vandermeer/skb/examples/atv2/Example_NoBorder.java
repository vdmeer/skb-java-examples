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

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthFixedColumns;
import de.vandermeer.asciitable.v2.row.ContentRow;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating a simple table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150812 (12-Aug-15) for Java 1.8
 * @since      v0.0.7
 */
public class Example_NoBorder extends AbstractCommandInterpreter {

	/**
	 * Returns a new interpreter.
	 */
	public Example_NoBorder(){
		super(
				SkbShellFactory.newCommand("no-border", ShellStatics.THEME_COMMANDS, "prints a table using a table theme without borders, useful for text formatting", null)
		);
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		ContentRow row;
		V2_AsciiTable at = new V2_AsciiTable(0);
		at.addRule();
		row = at.addRow(new LoremIpsum().getParagraphs(1));
		row.setAlignment(new char[]{'j'});
		at.addRule();
		row = at.addRow(new LoremIpsum().getParagraphs(1));
		row.setPadding(new int[]{5});
		row.setAlignment(new char[]{'j'});
		at.addRule();
		V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.NO_BORDERS.get());
		rend.setWidth(new WidthFixedColumns().add(60));
		System.out.println("no border");
		System.out.println(rend.render(at));
		return 0;
	}

}