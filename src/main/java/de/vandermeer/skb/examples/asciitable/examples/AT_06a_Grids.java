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
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

/**
 * AsciiTable example for grids.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_06a_Grids implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "adding a grid to a table";
	}

	@Override
	public String getName() {
		return "grid";
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(\"rc 11\", \"rc 12\");",
				"at.addRule();",
				"at.addRow(\"rc 21\", \"rc 22\");",
				"at.addRule();",
				"at.getContext().setWidth(13);",
				"",
				"System.out.println(at.render());",
				"",
				"at.getContext().setGrid(A7_Grids.minusBarPlusEquals());",
				"System.out.println(at.render());",
				"",
				"at.getContext().setGrid(A8_Grids.lineDobuleBlocks());",
				"System.out.println(at.render());",
				"",
				"at.getContext().setGrid(U8_Grids.borderDoubleLight());",
				"System.out.println(at.render());",
				"",
				"at.getContext().setGrid(U8_Grids.borderLight());",
				"System.out.println(at.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("rc 11", "rc 12");
		at.addRule();
		at.addRow("rc 21", "rc 22");
		at.addRule();
		at.getContext().setWidth(13);

		System.out.println(at.render());

		at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
		System.out.println(at.render());

		at.getContext().setGrid(A8_Grids.lineDoubleBlocks());
		System.out.println(at.render());

		at.getContext().setGrid(U8_Grids.borderDoubleLight());
		System.out.println(at.render());

		at.getContext().setGrid(U8_Grids.borderDouble());
		System.out.println(at.render());
		// end::example[]
	}
}
