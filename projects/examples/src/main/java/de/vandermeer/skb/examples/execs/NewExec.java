package de.vandermeer.skb.examples.execs;

import de.vandermeer.skb.execs.Skb_Exec;

public class NewExec extends Skb_Exec {

	public NewExec(){
		super("new-exec");
		this.addService("svc1", Service1.class);
		this.addService("svc2", Service2.class);
	}

	/**
	 * Public main to start any SKB Service.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		NewExec run = new NewExec();
		int ret = run.execute(args);
		System.exit(ret);
	}

}
