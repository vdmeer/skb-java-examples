package de.vandermeer.skb.examples.execs;

import org.junit.Test;

import de.vandermeer.skb.base.utils.Skb_EncodingUtils;

public class TestMe {

//	@Test
//	public void testMe(){
//		SvcExec ne = new SvcExec();
//
//		String[] args = new String[]{
//				"svc2",
//				"-f"
//		};
//
//		//ne.execute(args);
//
//		Messages ct = new Messages();
//		ct.executeService(new String[]{"-y"});
//	}

	@Test
	public void testMe2(){
		SvcExec ne = new SvcExec();
		String[] args = new String[]{
				"de.vandermeer.skb.examples.ConsoleTable",
				"-l"
		};
		ne.execute(args);
		System.err.println(Skb_EncodingUtils.getDefaultEncoding());
	}
}
