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

import de.vandermeer.skb.base.shell.SkbShellCommandCategory;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Static definitions for {@link V2_AsciiTable_Shell}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.6 build 150812 (12-Aug-15) for Java 1.8
 * @since      v0.0.7
 */
public abstract class ShellStatics {

	/** A category for table width example commands. */
	public static SkbShellCommandCategory WIDTH_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Width", "examples for table width options");

	/** A category for table padding example commands. */
	public static SkbShellCommandCategory PADDING_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Padding", "examples for padding options");

	/** A category for table theme and rule style example commands. */
	public static SkbShellCommandCategory THEME_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Theme & Style", "examples for table/row themes and styles");

	/** A category for table column example commands. */
	public static SkbShellCommandCategory COLUMNS_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Columns", "examples for different options for table columns and cells");

	/** A category for table column content example commands. */
	public static SkbShellCommandCategory COLUMNS_CONTENT_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Columns", "examples for different possible table column contents");

	/** A category for basic table example commands. */
	public static SkbShellCommandCategory BASIC_COMMANDS = SkbShellFactory.newCategory("AsciiTable V2 Basic", "basic table examples");

}
