package de.vandermeer.skb.examples.execs.lang;

import org.apache.commons.cli.Option;

import de.vandermeer.execs.options.AbstractApplicationOption;

public class AO_E extends AbstractApplicationOption<String> {

	/**
	 * Returns the new option.
	 */
	public AO_E(){
		super("for an English greeting", "Will simply print an English greeting when activated.");

		Option.Builder builder = Option.builder("e");
		builder.longOpt("english");
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
