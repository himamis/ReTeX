package com.himamis.retex.renderer.web.parser;

import com.google.gwt.xml.client.XMLParser;
import com.google.gwt.xml.client.impl.DOMParseException;
import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.platform.parser.Document;
import com.himamis.retex.renderer.share.platform.parser.Parser;

public class ParserW implements Parser {

	@Override
	public Document parse(Object input) throws ResourceParseException {
		try {
			return new DocumentW(XMLParser.parse((String) input));
		} catch (DOMParseException exception) {
			ResourceParseException rpe = new ResourceParseException("Could not parse resource", exception);
			throw rpe;
		}
	}

	@Override
	public void setIgnoringElementContentWhitespace(boolean whitespace) {
		// NO-OP
	}

	@Override
	public void setIgnoringComments(boolean ignoreComments) {
		// NO-OP
	}

}
