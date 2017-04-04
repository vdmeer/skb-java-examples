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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiTable example for a simple table as getting started example.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_02_ColSpan implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow(null, null, null, null, "span all 5 columns");
		at.addRule();
		at.addRow(null, null, null, "span 4 columns", "just 1 column");
		at.addRule();
		at.addRow(null, null, "span 3 columns", null, "span 2 columns");
		at.addRule();
		at.addRow(null, "span 2 columns", null, null, "span 3 columns");
		at.addRule();
		at.addRow("just 1 column", null, null, null, "span 4 columns");
		at.addRule();
		at.addRow("just 1 column", "just 1 column", "just 1 column", "just 1 column", "just 1 column");
		at.addRule();
		System.out.println(at.render(71));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(null, null, null, null, \"span all 5 columns\");",
				"at.addRule();",
				"at.addRow(null, null, null, \"span 4 columns\", \"just 1 column\");",
				"at.addRule();",
				"at.addRow(null, null, \"span 3 columns\", null, \"span 2 columns\");",
				"at.addRule();",
				"at.addRow(null, \"span 2 columns\", null, null, \"span 3 columns\");",
				"at.addRule();",
				"at.addRow(\"just 1 column\", null, null, null, \"span 4 columns\");",
				"at.addRule();",
				"at.addRow(\"just 1 column\", \"just 1 column\", \"just 1 column\", \"just 1 column\", \"just 1 column\");",
				"at.addRule();",
				"System.out.println(at.render(71));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "table with different column span examples";
	}

	@Override
	public String getID() {
		return "colspan";
	}
}
