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

import de.vandermeer.execs.ExecutableService;
import de.vandermeer.skb.base.utils.Skb_ConsoleUtils;

/**
 * Example for console utilities showing console default encoding.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 150623 (23-Jun-15) for Java 1.8
 */
public class DefaultEncoding implements ExecutableService {

	@Override
	public int executeService(String[] arg0) {
		System.out.println(Skb_ConsoleUtils.getDefaultEncoding());
		System.out.println();
		return 0;
	}

	@Override
	public void serviceHelpScreen() {
		System.out.println("Prints the default encoding.");
		System.out.println();
	}

	@Override
	public String getName() {
		return "example-encoding";
	}
}
