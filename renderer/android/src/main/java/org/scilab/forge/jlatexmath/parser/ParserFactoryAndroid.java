package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Parser;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;

public class ParserFactoryAndroid extends ParserFactory {

	@Override
	public Parser createParser() {
		return new ParserA();
	}

}
