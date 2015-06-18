package de.vandermeer.skb.examples;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import de.vandermeer.execs.Skb_Executable;
import de.vandermeer.skb.base.message.EMessageType;
import de.vandermeer.skb.base.message.Message5WH;

public class Messages implements Skb_Executable {

	@Override
	public int executeService(String[] args) {
		//fill a new message object with information
		Message5WH msg=new Message5WH()
			.setWho("from "+this.getClass().getSimpleName())
			.addWhat("showing a test message")
			.setWhen(null)
			.setWhere("the class API documentation", 0, 0)
			.addWhy("as a demo")
			.addHow("added to the class JavaDoc")
			.setReporter("The Author")
			.setType(EMessageType.INFO)
		;
		//print that information
		System.out.println(msg.render());

		System.out.println("\n");
		//define a new template for a message
		final String newTemplate=
				"where(location, line, column) ::= <<\n" +
				"<location;separator=\".\"><if(line&&column)> <line>:<column><elseif(!line&&!column)><elseif(!line)> -:<column><elseif(!column)> <line>:-<endif>\n"+
				">>\n\n" +
				"message5wh(reporter, type, who, when, where, what, why, how) ::= <<\n" +
					"<if(reporter)>Reporter = <reporter><endif>\n" +
					"<if(type)>Type     = <type><endif>\n" +
					"<if(who)>Who      = <who><endif>\n" +
					"<if(when)>When     = <when><endif>\n" +
					"<if(where)>Where    = <where><endif>\n" +
					"<if(what)>What     = <what><endif>\n" +
					"<if(why)>Why      = <why><endif>\n" +
					"<if(how)>How      = <how><endif>\n" +
				">>\n";
		//set a new group and add group to message
		STGroup stg = new STGroupString(newTemplate);
		msg.setSTG(stg);
		//print same message with new template
		System.out.println(msg.render());

		return 0;
	}

	@Override
	public void serviceHelpScreen() {
		System.out.println("Messages:");
		System.out.println("Prints examples for Message5WH (skb-base), using the default and custom templates.");

	}

	@Override
	public String getName() {
		return "example-messages";
	}
}
