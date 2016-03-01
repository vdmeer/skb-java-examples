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

import de.vandermeer.asciitable.v2.RenderedTable;
import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthFixedColumns;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating a simple table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.7-SNAPSHOT build 160301 (01-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class Example_URI extends AbstractCommandInterpreter {

	/**
	 * Returns a new interpreter.
	 */
	public Example_URI(){
		super(
				SkbShellFactory.newCommand("uri", ShellStatics.BASIC_COMMANDS, "prints a table with URN examples", null)
		);
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		V2_AsciiTable at = new V2_AsciiTable();

		at.addRule();
		at.addRow("scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]", "scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]");
		at.addRule();
		at.addRow(null, "scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]");
		at.addRule();
		at.addRow("abc://username:password@example.com:123/path/data?key=value#fragid1", "abc://username:password@example.com:123/path/data?key=value#fragid1");
		at.addRule();
		at.addRow(null, "abc://username:password@example.com:123/path/data?key=value#fragid1");
		at.addRule();
		at.addRow("urn:example:mammal:monotreme:echidna", "urn:example:mammal:monotreme:echidna");
		at.addRule();
		at.addRow(null, "urn:example:mammal:monotreme:echidna");
		at.addRule();
		at.addRow("http://www.example.com/test1/test2", "http://www.example.com/test1/test2");
		at.addRule();
		at.addRow(null, "http://www.example.com/test1/test2");
		at.addRule();
		at.addRow("mailto:user1@example.com", "mailto:firstname.lastname@example.com");
		at.addRule();
		at.addRow(null, "mailto:firstname.lastname@example.com");
		at.addRule();

		V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());
		rend.setWidth(new WidthFixedColumns().add(35).add(35));

		RenderedTable rt = rend.render(at);
		System.out.println("URIs examples");
		System.out.println(rt);
		return 0;
	}

}
