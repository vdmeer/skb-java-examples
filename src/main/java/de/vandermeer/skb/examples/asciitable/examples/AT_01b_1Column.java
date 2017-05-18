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

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

/**
 * AsciiTable example for a simple table as getting started example.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_01b_1Column implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "table with 1 column";
	}

	@Override
	public Object getLongDescription() {
		return
				"The number of columns of a table is automatically set by the first content row added to the table.\r\n" + 
				"If the first row has 1 text object, then the table has 1 column.\r\n" + 
				"If the first row has 2 text objects, then the table has 2 columns, and so forth.\r\n" + 
				"<br /><br />" +
				"This example show this behavior for 1 column."
		;
	}

	@Override
	public String getName() {
		return "1col";
	}

	@Override
	public String getSource(){
		return
				"AsciiTable at = new AsciiTable();\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(\"Table Heading\");\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(\"first row (col1)\");\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(\"second row (col1)\");\r\n" + 
				"at.addRule();\r\n" + 
				"System.out.println(at.render(30));"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("Table Heading");
		at.addRule();
		at.addRow("first row (col1)");
		at.addRule();
		at.addRow("second row (col1)");
		at.addRule();
		System.out.println(at.render(30));
		// end::example[]
	}
}
