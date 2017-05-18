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
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * AsciiTable example for for text alignment options (row).
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_03b_AlignmentRow implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "set text alignment for a whole row";
	}

	@Override
	public Object getLongDescription() {
		return
				"The alignment of text can be set for individual table rows.\r\n" + 
				"This example creates a table, adds text objects, and then sets the text alignment for the second row to right leaving the first row to the default justified alignment."
		;
	}

	@Override
	public String getName() {
		return "alignment-row";
	}

	@Override
	public String getSource(){
		return
				"AsciiTable at = new AsciiTable();\r\n" + 
				"String text = new LoremIpsum().getWords(9);\r\n" + 
				"at.addRule();\r\n" + 
				"at.addRow(text, text, text);\r\n" + 
				"at.addRule();\r\n" + 
				"AT_Row row = at.addRow(text, text, text);\r\n" + 
				"at.addRule();\r\n" + 
				"row.setTextAlignment(TextAlignment.RIGHT);\r\n" + 
				"System.out.println(at.render(76));"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		String text = new LoremIpsum().getWords(9);
		at.addRule();
		at.addRow(text, text, text);
		at.addRule();
		AT_Row row = at.addRow(text, text, text);
		at.addRule();
		row.setTextAlignment(TextAlignment.RIGHT);
		System.out.println(at.render(76));
		// end::example[]
	}
}
