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

import de.vandermeer.asciiparagraph.AP_Context;
import de.vandermeer.asciiparagraph.AsciiParagraph;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import de.vandermeer.translation.targets.Text2Latex;

/**
 * AsciiParagraph example demonstrating a LaTeX target translator.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AP_09a_TargetTranslators_LaTeX implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AP_Context ctx = new AP_Context();
		ctx.setAlignment(TextAlignment.LEFT);

		AsciiParagraph ap = new AsciiParagraph(ctx);
		ap.addText("A sentence with some normal text, not specific to LaTeX.");
		ap.addText("Now for some characters that require conversion: # % &.");
		ap.addText("And some more: © § ¤.");
		ap.addText("And even more: È É Ê Ë.");
		ap.addText("And some arrows as well: ← ↑ → ↓ ↔");
		System.out.println(ap.render(35));

		ctx.setTargetTranslator(new Text2Latex());
		System.out.println(ap.render(35));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AP_Context ctx = new AP_Context();",
				"ctx.setAlignment(AP_Alignment.LEFT);",
				"",
				"AsciiParagraph ap = new AsciiParagraph(ctx);",
				"ap.addText(\"A sentence with some normal text, not specific to LaTeX.\");",
				"ap.addText(\"Now for some characters that require conversion: # % &.\");",
				"ap.addText(\"And some more: © § ¤.\");",
				"ap.addText(\"And even more: È É Ê Ë.\");",
				"ap.addText(\"And some arrows as well: ← ↑ → ↓ ↔\");",
				"System.out.println(ap.render(35));",
				"",
				"ctx.setTargetTranslator(new Text2Latex());",
				"System.out.println(ap.render(35));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "text translation for LaTeX target";
	}

	@Override
	public String getID() {
		return "target-latex";
	}
}
