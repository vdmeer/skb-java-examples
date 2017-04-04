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
import de.vandermeer.skb.interfaces.render.DoesRenderToWidth;
import de.vandermeer.skb.interfaces.transformers.textformat.Text_To_FormattedText;

/**
 * AsciiTable example demonstrating that {@link DoesRenderToWidth} objects are automatically added as text.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 *
 *
 */
public class AT_00g_AddColumn_DoesRenderToWidth implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiTable at = new AsciiTable();
		class ObjectDoesRenderToWidth implements DoesRenderToWidth{
			@Override
			public String render(int width) {
				return new StrBuilder().appendWithSeparators(Text_To_FormattedText.left(new LoremIpsum().getWords(10), width), "\n").toString();
			}
		}

		at.addRule();
		at.addRow(new ObjectDoesRenderToWidth());
		at.addRule();
		System.out.println(at.render(30));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiTable at = new AsciiTable();",
				"class ObjectDoesRenderToWidth implements DoesRenderToWidth{",
				"	@Override",
				"	public String render(int width) {",
				"		return new StrBuilder().appendWithSeparators(Text_To_FormattedText.left(new LoremIpsum().getWords(10), width), \"\n\").toString();",
				"	}",
				"}",
				"",
				"at.addRule();",
				"at.addRow(new ObjectDoesRenderToWidth());",
				"at.addRule();",
				"System.out.println(at.render(30));",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
}
