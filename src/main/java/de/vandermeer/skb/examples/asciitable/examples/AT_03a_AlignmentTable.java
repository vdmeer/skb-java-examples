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

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * AsciiTable example for for text alignment options (table).
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_03a_AlignmentTable implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		String text = new LoremIpsum().getWords(9);
		at.addRule();
		at.addRow(text, text, text);
		at.addRule();
		at.addRow(text, text, text);
		at.addRule();
		at.setTextAlignment(TextAlignment.RIGHT);
		System.out.println(at.render(76));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiTable at = new AsciiTable();",
				"String text = new LoremIpsum().getWords(9);",
				"at.addRule();",
				"at.addRow(text, text, text);",
				"at.addRule();",
				"at.addRow(text, text, text);",
				"at.addRule();",
				"at.setTextAlignment(TextAlignment.RIGHT);",
				"System.out.println(at.render(76));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "set text alignment for a whole table";
	}

	@Override
	public String getID() {
		return "alignment-table";
	}
}
