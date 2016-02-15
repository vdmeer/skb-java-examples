package de.vandermeer.skb.examples.execs.lang;

import org.apache.commons.cli.Option;

import de.vandermeer.execs.options.AbstractApplicationOption;

public class AO_G extends AbstractApplicationOption<String> {

	/**
	 * Returns the new option.
	 */
	public AO_G(){
		super("for an German greeting", "Will simply print a German greeting when activated.");

		Option.Builder builder = Option.builder("g");
		builder.longOpt("german");
		builder.required(false);
		this.setCliOption(builder.build());
	}

	@Override
	public String convertValue(Object value) {
		if(value==null){
			return null;
		}
		return value.toString();
	}

}
