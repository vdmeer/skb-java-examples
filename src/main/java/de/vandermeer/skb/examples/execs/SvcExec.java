package de.vandermeer.skb.examples.execs;

import de.vandermeer.execs.Skb_Exec;

public class SvcExec extends Skb_Exec {

	public SvcExec(){
		super("svc-exec");
		this.addService("svc1", Service1.class);
		this.addService("svc2", Service2.class);
	}

	/**
	 * Public main to start any SKB Service.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SvcExec run = new SvcExec();
		int ret = run.execute(args);
		System.exit(ret);
	}

}
