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
import org.stringtemplate.v4.ST;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

/**
 * AsciiTable example demonstrating that {@link ST} objects are automatically added as text.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_00c_AddColumn_ST implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "add column from StringTemplate";
	}

	@Override
	public String getName() {
		return "col-st";
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"ST st = new ST(new LoremIpsum().getWords(10));",
				"AsciiTable at = new AsciiTable();",
				"at.addRule();",
				"at.addRow(st);",
				"at.addRule();",
				"System.out.println(at.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public void showOutput(){
		// tag::example[]
		ST st = new ST(new LoremIpsum().getWords(10));
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow(st);
		at.addRule();
		System.out.println(at.render());
		// end::example[]
	}
}
