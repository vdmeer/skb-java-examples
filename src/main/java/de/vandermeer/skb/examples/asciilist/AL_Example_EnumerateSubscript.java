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

package de.vandermeer.skb.examples.asciilist;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.asciilist.EnumerateList;
import de.vandermeer.skb.examples.StandardExample;
import de.vandermeer.asciilist.styles.NestedEnumerateStyles;

/**
 * AsciiList example for an enumerate list with subscripts.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_EnumerateSubscript implements StandardExample {

	@Override
	public void showOutput(){
		// tag::example[]
		AsciiList enumerate = new EnumerateList()
		.addItem("item 1")
		.addItem("item 2")
		.addItem("item 3")
		.setPreLabelString("E")
		.setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)
		;
		System.out.println(enumerate.render());
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiList enumerate = new EnumerateList()",
				".addItem(\"item 1\")",
				".addItem(\"item 2\")",
				".addItem(\"item 3\")",
				".setPreLabelString(\"E\")",
				".setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)",
				";",
				"System.out.println(enumerate.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}
}
