package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Parser;

import com.google.gwt.xml.client.XMLParser;
import com.google.gwt.xml.client.impl.DOMParseException;

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
