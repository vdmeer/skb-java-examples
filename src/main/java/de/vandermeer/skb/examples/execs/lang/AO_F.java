package de.vandermeer.skb.examples.execs.lang;

import org.apache.commons.cli.Option;

import de.vandermeer.execs.options.AbstractApplicationOption;

public class AO_F extends AbstractApplicationOption<String> {

	/**
	 * Returns the new option.
	 */
	public AO_F(){
		super("for an French greeting", "Will simply print a French greeting when activated.");

		Option.Builder builder = Option.builder("f");
		builder.longOpt("french");
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
