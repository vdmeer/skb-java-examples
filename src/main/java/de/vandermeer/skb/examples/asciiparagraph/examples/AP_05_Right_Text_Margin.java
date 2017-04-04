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

package de.vandermeer.skb.examples.asciiparagraph.examples;

import org.apache.commons.lang3.text.StrBuilder;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciiparagraph.AP_Context;
import de.vandermeer.asciiparagraph.AsciiParagraph;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * AsciiParagraph example demonstrating right text behavior.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AP_05_Right_Text_Margin implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AP_Context ctx = new AP_Context();
		ctx.setAlignment(TextAlignment.RIGHT);
		ctx.setWidth(29);
		ctx.setEndString("|");

		AsciiParagraph ap = new AsciiParagraph(ctx);
		ap.addText(new LoremIpsum().getWords(29));
		System.out.println(ap.render());

		ctx.setTextRightMargin(5);
		System.out.println(ap.render());

		ctx.setTextRightMargin(10);
		ctx.setTextRightChar('<');
		System.out.println(ap.render());
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AP_Context ctx = new AP_Context();",
				"ctx.setAlignment(AP_Alignment.RIGHT);",
				"ctx.setWidth(29);",
				"ctx.setEndString(\"|\");",
				"",
				"AsciiParagraph ap = new AsciiParagraph(ctx);",
				"ap.addText(new LoremIpsum().getWords(29));",
				"System.out.println(ap.render());",
				"",
				"ctx.setTextRightMargin(5);",
				"System.out.println(ap.render());",
				"",
				"ctx.setTextRightMargin(10);",
				"ctx.setTextRightChar('<');",
				"System.out.println(ap.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "behavior of right margin";
	}

	@Override
	public String getID() {
		return "margin-right";
	}
}