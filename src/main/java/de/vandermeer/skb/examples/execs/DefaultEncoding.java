package de.vandermeer.skb.examples.execs;

import de.vandermeer.execs.Skb_Executable;
import de.vandermeer.skb.base.utils.Skb_EncodingUtils;

public class DefaultEncoding implements Skb_Executable {

	@Override
	public int executeService(String[] arg0) {
		System.out.println(Skb_EncodingUtils.getDefaultEncoding());
		System.out.println();
		return 0;
	}

	@Override
	public void serviceHelpScreen() {
		System.out.println("Prints the default encoding.");
		System.out.println();
	}

}
