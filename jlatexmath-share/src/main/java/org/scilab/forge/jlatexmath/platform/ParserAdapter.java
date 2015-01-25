package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Element;
import org.scilab.forge.jlatexmath.platform.parser.Parser;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;

public class ParserAdapter {
	
	private final ParserFactory parserFactory;
	
	public ParserAdapter() {
		parserFactory = FactoryProvider.INSTANCE.getParserFactory();
	}
	
	public Parser createParser() {
		return parserFactory.createParser();
	}

	public Element createParserAndParseFile(Object file, boolean ignoreComments, boolean ignoreWhitespace) throws ResourceParseException {
		Parser parser = createParser();
		parser.setIgnoringComments(ignoreComments);
		parser.setIgnoringElementContentWhitespace(ignoreWhitespace);
		Document document = parser.parse(file);
		return document.getDocumentElement();
	}
	
	public Element createParserAndParseFile(Object file) throws ResourceParseException {
		Parser parser = createParser();
		Document document = parser.parse(file);
		return document.getDocumentElement();
	}
}
