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

package de.vandermeer.skb.examples.execs;

import de.vandermeer.execs.ExecS;
import de.vandermeer.skb.examples.Message5WH_Examples;
import de.vandermeer.skb.examples.asciiparagraph.AsciiParagraph_Examples;
import de.vandermeer.skb.examples.asciiparagraph.AsciiParagraph_Shell;
import de.vandermeer.skb.examples.asciitable.AsciiTable_Examples;
import de.vandermeer.skb.examples.asciitable.AsciiTable_Shell;
import de.vandermeer.skb.examples.execs.lang.Application_Lang;

/**
 * An ExecS class for the examples and an example for an ExecS class.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.8 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.6
 */
public class ExamplesExecS extends ExecS {

	public ExamplesExecS(){
		super("examples-execs");

		this.addApplication(Message5WH_Examples.APP_NAME,		Message5WH_Examples.class);
		this.addApplication(DefaultEncoding.APP_NAME,			DefaultEncoding.class);
		this.addApplication(Application1.APP_NAME,				Application1.class);
		this.addApplication(Application_Lang.APP_NAME,			Application_Lang.class);

		this.addApplication(AsciiTable_Shell.APP_NAME,			AsciiTable_Shell.class);
		this.addApplication(AsciiTable_Examples.APP_NAME,		AsciiTable_Examples.class);

		this.addApplication(AsciiParagraph_Shell.APP_NAME,		AsciiParagraph_Shell.class);
		this.addApplication(AsciiParagraph_Examples.APP_NAME,	AsciiParagraph_Examples.class);
	}

	/**
	 * Public main to start the application executor.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		ExamplesExecS execs = new ExamplesExecS();
		int ret = execs.execute(args);
		System.exit(ret);
	}

}
