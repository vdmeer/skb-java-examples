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
import de.vandermeer.translation.targets.Text2Latex;

/**
 * AsciiTable example for target translation (LaTeX).
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_08a_TargetTranslator_Latex implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "translate cell content for LaTeX";
	}

	@Override
	public String getName() {
		return "target-latex";
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"String text = \"A sentence with some normal text, not specific to LaTeX. \" +",
				"		\"Now for some characters that require conversion: # % &. \" +",
				"		\"And some more: © § ¤. \" +",
				"		\"And even more: È É Ê Ë. \" +",
				"		\"And some arrows as well: ← ↑ → ↓ ↔\"",
				";",
				"",
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(text, text).getCells().get(1).getContext().setTargetTranslator(new Text2Latex());",
				"at.addRule();",
				"at.setTextAlignment(TextAlignment.LEFT);",
				"",
				"System.out.println(at.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public void showOutput(){
		// tag::example[]
		String text = "A sentence with some normal text, not specific to LaTeX. " +
			"Now for some characters that require conversion: # % &. " +
			"And some more: © § ¤. " +
			"And even more: È É Ê Ë. " +
			"And some arrows as well: ← ↑ → ↓ ↔"
		;

		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow(text, text).getCells().get(1).getContext().setTargetTranslator(new Text2Latex());
		at.addRule();
		at.setTextAlignment(TextAlignment.LEFT);

		System.out.println(at.render());
		// end::example[]
	}
}
