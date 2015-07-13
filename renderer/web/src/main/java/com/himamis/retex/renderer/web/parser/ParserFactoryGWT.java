package com.himamis.retex.renderer.web.parser;

import com.himamis.retex.renderer.share.platform.parser.Parser;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;

public class ParserFactoryGWT extends ParserFactory {

	@Override
	public Parser createParser() {
		return new ParserW();
	}

}
