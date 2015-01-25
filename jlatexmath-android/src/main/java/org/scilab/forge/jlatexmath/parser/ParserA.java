package org.scilab.forge.jlatexmath.parser;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Parser;
import org.xml.sax.InputSource;

public class ParserA implements Parser {

	private DocumentBuilderFactory factory;

	public ParserA() {
		factory = DocumentBuilderFactory.newInstance();
	}

	public Document parse(Object input) throws ResourceParseException {
		// On the desktop platform, the input is an InputSource object
		// Please refer to the ResourceLoaderD class
		InputSource is = (InputSource) input;
		org.w3c.dom.Document document = tryParse(is);
		return new DocumentA(document);
	}

	private org.w3c.dom.Document tryParse(InputSource is) throws ResourceParseException {
		try {
			return factory.newDocumentBuilder().parse(is);
		} catch (Exception ex) {
			ResourceParseException rpe = new ResourceParseException(
					"Could not parse resource", ex);
			throw rpe;
		}
	}

	public void setIgnoringElementContentWhitespace(boolean whitespace) {
		factory.setIgnoringElementContentWhitespace(whitespace);
	}

	public void setIgnoringComments(boolean ignoreComments) {
		factory.setIgnoringComments(ignoreComments);
	}
}
