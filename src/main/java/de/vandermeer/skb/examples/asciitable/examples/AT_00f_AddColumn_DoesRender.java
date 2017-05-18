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
import de.vandermeer.skb.interfaces.render.DoesRender;

/**
 * AsciiTable example demonstrating that {@link DoesRender} objects are automatically added as text.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_00f_AddColumn_DoesRender implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "add column from doesRender";
	}

	@Override
	public Object getLongDescription() {
		return
				"This example creates a simple DoesRender object with some text, and adds it to a table."
		;
	}

	@Override
	public String getName() {
		return "col-does-render";
	}

	@Override
	public String getSource(){
		return
				"AsciiTable at = new AsciiTable();\r\n" + 
				"class ObjectDoesRender implements DoesRender{\r\n" + 
				"	@Override\r\n" + 
				"	public String render() {\r\n" + 
				"		return new LoremIpsum().getWords(10);\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(new ObjectDoesRender());\r\n" + 
				"at.addRule();\r\n" + 
				"System.out.println(at.render());"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		class ObjectDoesRender implements DoesRender{
			@Override
			public String render() {
				return new LoremIpsum().getWords(10);
			}
		}

		at.addRule();
		at.addRow(new ObjectDoesRender());
		at.addRule();
		System.out.println(at.render());
		// end::example[]
	}
}
