/* Copyright 2017 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.examples.asciiparagraph;

import de.vandermeer.skb.base.shell.SkbShellCommandCategory;
import de.vandermeer.skb.base.shell.SkbShellFactory;

/**
 * Static definitions for {@link AsciiParagraph_Shell}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.7
 */
public class ShellStatics {

	/** A category for paragraph width example commands. */
	public static SkbShellCommandCategory WIDTH_COMMANDS = SkbShellFactory.newCategory("AsciiParagraph Width", "examples for paragraph width options");

	/** A category for basic paragraph example commands. */
	public static SkbShellCommandCategory BASIC_COMMANDS = SkbShellFactory.newCategory("AsciiParagraph Basic", "basic paragraph examples");

}
