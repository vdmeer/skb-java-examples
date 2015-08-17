/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples;

import de.vandermeer.asciitable.v1.V1_AsciiTable;
import de.vandermeer.asciitable.v1.V1_StandardTableThemes;
import de.vandermeer.execs.ExecutableService;

/**
 * Examples for using the ASCII table.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150812 (12-Aug-15) for Java 1.8
 * @since      v0.0.1
 */
public class ConsoleTable implements ExecutableService {

	@Override
	public int executeService(String[] args) {
		if(args.length==0){
			this.serviceHelpScreen();
			return -1;
		}

		//simple table with auto column width
		V1_AsciiTable auto = V1_AsciiTable.newTable(3, 76);
		auto.addRow(null, null, "Table Heading");
		auto.addRow("first row (col1)", "with some information", "and more information");
		auto.addRow("second row (col1)", "with some information (col2)", "and more information (col3)");

		//table with pre-defined column width
		Integer[] columns = new Integer[]{10, 15, 20};
		V1_AsciiTable at = V1_AsciiTable.newTable(columns);
		at.addRow(null, null, "Table Heading");
		at.addRow("row 1", "this is col 2", "and this is column 3");
		at.addRow("row 2", "some text for column 2", "and some text for column 3");

		switch(args[0]){
			case "-a":
				break;
			case "-l":
				auto.setTheme(V1_StandardTableThemes.LIGHT);
				at.setTheme(V1_StandardTableThemes.LIGHT);
				break;
			case "-d":
				auto.setTheme(V1_StandardTableThemes.DOUBLE);
				at.setTheme(V1_StandardTableThemes.DOUBLE);
				break;
			case "-dl":
				auto.setTheme(V1_StandardTableThemes.DOUBLE_LIGHT);
				at.setTheme(V1_StandardTableThemes.DOUBLE_LIGHT);
				break;
			case "-ld":
				auto.setTheme(V1_StandardTableThemes.LIGHT_DOUBLE);
				at.setTheme(V1_StandardTableThemes.LIGHT_DOUBLE);
				break;
			case "-y":
				auto.setTheme(V1_StandardTableThemes.HEAVY);
				at.setTheme(V1_StandardTableThemes.HEAVY);
				break;
			case "-yl":
				auto.setTheme(V1_StandardTableThemes.HEAVY_LIGHT);
				at.setTheme(V1_StandardTableThemes.HEAVY_LIGHT);
				break;
			case "-ly":
				auto.setTheme(V1_StandardTableThemes.LIGHT_HEAVY);
				at.setTheme(V1_StandardTableThemes.LIGHT_HEAVY);
				break;
			case "-la-7":
				auto.setTheme(V1_StandardTableThemes.LATEX_7BIT);
				at.setTheme(V1_StandardTableThemes.LATEX_7BIT);
				break;
			case "-la-d":
				auto.setTheme(V1_StandardTableThemes.LATEX_DOUBLE);
				at.setTheme(V1_StandardTableThemes.LATEX_DOUBLE);
				break;
			case "-la-h":
				auto.setTheme(V1_StandardTableThemes.LATEX_HEAVY);
				at.setTheme(V1_StandardTableThemes.LATEX_HEAVY);
				break;
			case "-la-l":
				auto.setTheme(V1_StandardTableThemes.LATEX_LIGHT);
				at.setTheme(V1_StandardTableThemes.LATEX_LIGHT);
				break;
			case "-la-dd":
				auto.setTheme(V1_StandardTableThemes.LATEX_LIGHT_DOUBLE_DASH);
				at.setTheme(V1_StandardTableThemes.LATEX_LIGHT_DOUBLE_DASH);
				break;
			case "-la-td":
				auto.setTheme(V1_StandardTableThemes.LATEX_LIGHT_TRIPLE_DASH);
				at.setTheme(V1_StandardTableThemes.LATEX_LIGHT_TRIPLE_DASH);
				break;

			default:
				System.out.println("ConsoleTable: unknown option: " + args[0]);
				return -1;
		}

		System.out.println(auto.render());
		System.out.println(at.render());

		return 0;
	}

	@Override
	public void serviceHelpScreen() {
		System.out.println("ConsoleTable:");
		System.out.println("Examples for AsciiTable (skb-asciitable). Each options prints tow tables in different styles");

		System.out.println("-a      - prints a table using 7-Bit ASCII characters");
		System.out.println("-l      - prints a table using UTF-8 light box characters");
		System.out.println("-d      - prints a table using UTF-8 double box characters");
		System.out.println("-dl     - prints a table using UTF-8 double (vertical) and light (horizontal) box characters");
		System.out.println("-ld     - prints a table using UTF-8 light (vertical) and double (horizontal) box characters");
		System.out.println("-y      - prints a table using UTF-8 heavy box characters");
		System.out.println("-yl     - prints a table using UTF-8 heavy (vertical) and light (horizontal) box characters");
		System.out.println("-ly     - prints a table using UTF-8 light (vertical) and heavy (horizontal) box characters");
		System.out.println("-la-7   - prints a LaTeX style table using 7-Bit ASCII characters");
		System.out.println("-la-d   - prints a LaTeX style table using UTF-8 double box characters");
		System.out.println("-la-dd  - prints a LaTeX style table using UTF-8 double dash characters");
		System.out.println("-la-h   - prints a LaTeX style table using UTF-8 heavy box characters");
		System.out.println("-la-l   - prints a LaTeX style table using UTF-8 light box characters");
		System.out.println("-la-td  - prints a LaTeX style table using UTF-8 triple dash characters");
	}

	@Override
	public String getName() {
		return "example-console-table";
	}
}
