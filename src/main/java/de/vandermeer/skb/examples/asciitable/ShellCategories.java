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

package de.vandermeer.skb.examples.asciitable;

import de.vandermeer.skb.interfaces.shell.CmdCategory;

/**
 * Static definitions for {@link AsciiTable_Shell}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.7
 */
public abstract class ShellCategories {

	/** A category for standard commands. */
	public static CmdCategory STD = CmdCategory.create(
			"standard",
			"Standard",
			"Standard shell commands"
	);

	/** A category for all commands. */
	public static CmdCategory ALL = CmdCategory.create(
			"all",
			"All",
			"all commands"
	);

	/** A category for table width example commands. */
	public static CmdCategory WIDTH = CmdCategory.create(
			"width",
			"AsciiTable Width",
			"examples for table width options"
	);

	/** A category for table padding example commands. */
	public static CmdCategory PADDING = CmdCategory.create(
			"padding",
			"AsciiTable Padding",
			"examples for padding options"
	);

	/** A category for table theme and rule style example commands. */
	public static CmdCategory THEME = CmdCategory.create(
			"themes",
			"AsciiTable Theme & Style",
			"examples for table/row themes and styles"
	);

	/** A category for table column example commands. */
	public static CmdCategory COLUMNS = CmdCategory.create(
			"columns",
			"AsciiTable Columns",
			"examples for different options for table columns and cells"
	);

	/** A category for table margin example commands. */
	public static CmdCategory MARGINS = CmdCategory.create(
			"margins",
			"AsciiTable Margins",
			"examples for different options for table margins"
	);

	/** A category for table column content example commands. */
	public static CmdCategory COLUMNS_CONTENT = CmdCategory.create(
			"col-content",
			"AsciiTable Columns, Content",
			"examples for different possible table column contents"
	);

	/** A category for table content translators example commands. */
	public static CmdCategory TRANSLATORS = CmdCategory.create(
			"translators",
			"AsciiTable Translators",
			"examples for different possible content translators"
	);

	/** A category for basic table example commands. */
	public static CmdCategory BASIC = CmdCategory.create(
			"basic",
			"AsciiTable Basic",
			"basic table examples"
	);

	/** A category for misc table example commands. */
	public static CmdCategory MISC = CmdCategory.create(
			"misc",
			"AsciiTable Misc",
			"misc table examples"
	);

}
