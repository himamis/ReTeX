package com.himamis.retex.renderer.share.platform;

import com.himamis.retex.renderer.share.exception.ResourceParseException;
import com.himamis.retex.renderer.share.platform.parser.Document;
import com.himamis.retex.renderer.share.platform.parser.Element;
import com.himamis.retex.renderer.share.platform.parser.Parser;
import com.himamis.retex.renderer.share.platform.parser.ParserFactory;

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
