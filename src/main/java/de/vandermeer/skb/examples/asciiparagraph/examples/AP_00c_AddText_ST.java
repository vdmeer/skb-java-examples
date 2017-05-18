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

import org.stringtemplate.v4.ST;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciiparagraph.AsciiParagraph;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

/**
 * AsciiParagraph example demonstrating that {@link ST} objects are automatically added as text.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AP_00c_AddText_ST implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "add text from StringTemplate";
	}

	@Override
	public Object getLongDescription() {
		return
				"This example creates a simple ST object with some text, and adds it to a paragraph."
		;
	}

	@Override
	public String getName() {
		return "text-st";
	}

	@Override
	public String getSource(){
		return
				"ST st = new ST(new LoremIpsum().getWords(10));\r\n" + 
				"AsciiParagraph ap = new AsciiParagraph();\r\n" + 
				"ap.addText(st);\r\n" + 
				"System.out.println(ap.render());"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		ST st = new ST(new LoremIpsum().getWords(10));
		AsciiParagraph ap = new AsciiParagraph();
		ap.addText(st);
		System.out.println(ap.render());
		// end::example[]
	}
}