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

import de.vandermeer.asciitable.AT_Cell;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * AsciiTable example for padding behavior (individual cell).
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_04c_Padding_Cell implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("row 1 col 1", "row 1 col 2");
		at.addRule();
		AT_Cell cell = at.addRow("row 2 col 1", "row 2 col 2").getCells().get(1);
		at.addRule();

		cell.getContext().setPaddingTopChar('v');
		cell.getContext().setPaddingBottomChar('^');
		cell.getContext().setPaddingLeftChar('>');
		cell.getContext().setPaddingRightChar('<');
		cell.getContext().setTextAlignment(TextAlignment.CENTER);
		cell.getContext().setPadding(1);
		System.out.println(at.render(33));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(\"row 1 col 1\", \"row 1 col 2\");",
				"at.addRule();",
				"AT_Cell cell = at.addRow(\"row 2 col 1\", \"row 2 col 2\").getCells().get(1);",
				"at.addRule();",
				"",
				"at.setPaddingTopChar('v');",
				"at.setPaddingBottomChar('^');",
				"at.setPaddingLeftChar('>');",
				"at.setPaddingRightChar('<');",
				"at.setTextAlignment(TextAlignment.CENTER);",
				"at.setPadding(1);",
				"System.out.println(at.render(33));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "set padding for a specific cell";
	}

	@Override
	public String getID() {
		return "padding-cell";
	}
}
