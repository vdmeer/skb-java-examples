package de.vandermeer.skb.examples;

import de.vandermeer.execs.Skb_Executable;
import de.vandermeer.skb.asciitable.AsciiTable;
import de.vandermeer.skb.asciitable.StandardTableThemes;
import de.vandermeer.skb.asciitable.TableOptions;

public class ConsoleTable implements Skb_Executable {

	@Override
	public int executeService(String[] args) {
		if(args.length==0){
			this.serviceHelpScreen();
			return -1;
		}

		//simple table with auto column width
		AsciiTable auto=AsciiTable.newTable(3, 76);
		auto.addRow(null, null, "Table Heading");
		auto.addRow("first row (col1)", "with some information", "and more information");
		auto.addRow("second row (col1)", "with some information (col2)", "and more information (col3)");

		//table with pre-defined column width
		Integer[] columns=new Integer[]{10, 15, 20};
		AsciiTable at=AsciiTable.newTable(columns);
		at.addRow(null, null, "Table Heading");
		at.addRow("row 1", "this is col 2", "and this is column 3");
		at.addRow("row 2", "some text for column 2", "and some text for column 3");

		//table options
		TableOptions to = new TableOptions();

		switch(args[0]){
			case "-a":
				break;
			case "-l":
				to.setRenderTheme(StandardTableThemes.LIGHT);
				break;
			case "-d":
				to.setRenderTheme(StandardTableThemes.DOUBLE);
				break;
			case "-dl":
				to.setRenderTheme(StandardTableThemes.DOUBLE_LIGHT);
				break;
			case "-ld":
				to.setRenderTheme(StandardTableThemes.LIGHT_DOUBLE);
				break;
			case "-y":
				to.setRenderTheme(StandardTableThemes.HEAVY);
				break;
			case "-yl":
				to.setRenderTheme(StandardTableThemes.HEAVY_LIGHT);
				break;
			case "-ly":
				to.setRenderTheme(StandardTableThemes.LIGHT_HEAVY);
				break;
			case "-la-7":
				to.setRenderTheme(StandardTableThemes.LATEX_7BIT);
				break;
			case "-la-d":
				to.setRenderTheme(StandardTableThemes.LATEX_DOUBLE);
				break;
			case "-la-h":
				to.setRenderTheme(StandardTableThemes.LATEX_HEAVY);
				break;
			case "-la-l":
				to.setRenderTheme(StandardTableThemes.LATEX_LIGHT);
				break;
			case "-la-dd":
				to.setRenderTheme(StandardTableThemes.LATEX_LIGHT_DOUBLE_DASH);
				break;
			case "-la-td":
				to.setRenderTheme(StandardTableThemes.LATEX_LIGHT_TRIPLE_DASH);
				break;

			default:
				System.out.println("ConsoleTable: unknown option: " + args[0]);
				return -1;
		}

		System.out.println(auto.render(to));
		System.out.println(at.render(to));

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
}
