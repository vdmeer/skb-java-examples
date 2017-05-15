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
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * AsciiTable example for content with conditional line breaks.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_09b_ConditionalLinebreak implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "conditional linebreaks";
	}

	@Override
	public String getName() {
		return "cond-linebreak";
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"String text = \"line 1<br>\" +",
				"	\"line 2<br/>\" +",
				"	\"line three \\n still line three\"",
				";",
				"",
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(text);",
				"at.addRule();",
				"System.out.println(at.render(50));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public void showOutput(){
		// tag::example[]
		String text = "line 1<br>" +
			"line 2<br/>" +
			"line three \n still line three"
		;
//		String text = new LoremIpsum().getParagraphs(1) + "\r\n\n<br><br><br>" + new LoremIpsum().getParagraphs(1);

		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow(text);
		at.addRule();
		at.setTextAlignment(TextAlignment.LEFT);
		System.out.println(at.render(50));
		// end::example[]
	}
}
