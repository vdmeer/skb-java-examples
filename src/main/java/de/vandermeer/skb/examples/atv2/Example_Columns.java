/* Copyright 2015 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples.atv2;

import java.util.Map;

import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthAbsoluteEven;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import de.vandermeer.skb.base.managers.MessageMgr;
import de.vandermeer.skb.base.shell.AbstractCommandInterpreter;
import de.vandermeer.skb.base.shell.LineParser;
import de.vandermeer.skb.base.shell.SkbShellArgument;
import de.vandermeer.skb.base.shell.SkbShellArgumentType;
import de.vandermeer.skb.base.shell.SkbShellCommand;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Command interpreter for generating table with variable number of columns.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.7 build 160301 (01-Mar-16) for Java 1.8
 * @since      v0.0.7
 */
public class Example_Columns extends AbstractCommandInterpreter {

	static final SkbShellArgument ARG_COLS = SkbShellFactory.newArgument(
			"cols", false, SkbShellArgumentType.Integer, new Integer[]{0, 1, 2, 3, 4, 5}, "number of columns for the table (use 0 for all examples)", null
	);

	static final SkbShellCommand COLUMNS = SkbShellFactory.newCommand(
			"columns",
			new SkbShellArgument[]{ARG_COLS},
			ShellStatics.COLUMNS_COMMANDS,
			"prints a table of <cols> columns", null
	);

	/**
	 * Returns a new interpreter.
	 */
	public Example_Columns(){
		super(COLUMNS);
	}

	@Override
	public int interpretCommand(String command, LineParser lp, MessageMgr mm) {
		Map<SkbShellArgument, Object> args = lp.getArgMap(COLUMNS.getArguments());
		Integer cols = (Integer)args.get(ARG_COLS);
		if(cols==null){
			mm.report(MessageMgr.createErrorMessage("number of columns not specified"));
			return 1;
		}
		if(cols<0){
			mm.report(MessageMgr.createErrorMessage("number of columns must be 0 or larger"));
			return 2;
		}
		if(cols>5){
			mm.report(MessageMgr.createErrorMessage("number of columns must be 5 or smaller"));
			return 3;
		}

		if(cols==0){
			for(int i=1;i<6; i++){
				this.printTable(i);
			}
		}
		else{
			this.printTable(cols);
		}

		return 0;
	}


	protected void printTable(int cols){
		V2_AsciiTable at = new V2_AsciiTable();
		at.addRule();

		switch(cols){
			case 1:
				at.addRow("first row (col1)");
				at.addRule();
				at.addRow("second row (col1)");
				break;
			case 2:
				at.addRow("first row (col1)", "with some information (col2)");
				at.addRule();
				at.addRow("second row (col1)", "with some information (col2)");
				break;
			case 3:
				at.addRow("first row (col1)", "with some information", "and more information");
				at.addRule();
				at.addRow("second row (col1)", "with some information (col2)", "and more information (col3)");
				break;
			case 4:
				at.addRow("first row (col1)", "with some information", "and more information", "even more");
				at.addRule();
				at.addRow("second row (col1)", "with some information (col2)", "and more information (col3)", "even more");
				break;
			case 5:
				at.addRow("first row (col1)", "with some information", "and more information", "even more", "more");
				at.addRule();
				at.addRow("second row (col1)", "with some information (col2)", "and more information (col3)", "even more", "more");
				break;
		}

		at.addRule();

		V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
		rend.setTheme(V2_E_TableThemes.UTF_LIGHT.get());
		rend.setWidth(new WidthAbsoluteEven(76));
		System.out.println("table " + cols + " columns");
		System.out.println(rend.render(at));
	}

}
