/* Copyright 2016 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples.asciitable.examples;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.render.HasText;

/**
 * AsciiTable example demonstrating that {@link HasText} objects are automatically added as text.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_00d_AddColumn_HasText implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "add column from hasText";
	}

	@Override
	public Object getLongDescription() {
		return
				"This example creates a simple HasText object with some text, and adds it to a table."
		;
	}

	@Override
	public String getName() {
		return "col-hastext";
	}

	@Override
	public String getSource(){
		return
				"AsciiTable at = new AsciiTable();\r\n" + 
				"class ObjectHasText implements HasText{\r\n" + 
				"	@Override\r\n" + 
				"	public String getText() {\r\n" + 
				"		return new LoremIpsum().getWords(10);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(new ObjectHasText());\r\n" + 
				"at.addRule();\r\n" + 
				"System.out.println(at.render());"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		class ObjectHasText implements HasText{
			@Override
			public String getText() {
				return new LoremIpsum().getWords(10);
			}
		}

		at.addRule();
		at.addRow(new ObjectHasText());
		at.addRule();
		System.out.println(at.render());
		// end::example[]
	}
}
