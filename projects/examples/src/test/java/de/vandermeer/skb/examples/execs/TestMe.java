package de.vandermeer.skb.examples.execs;

import org.junit.Test;

public class TestMe {

	@Test
	public void testMe(){
		NewExec ne = new NewExec();

		String[] args = new String[]{
				"svc2",
				"-j"
		};

		ne.execute(args);
	}
}
