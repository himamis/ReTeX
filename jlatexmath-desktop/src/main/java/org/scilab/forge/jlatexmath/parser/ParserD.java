package org.scilab.forge.jlatexmath.parser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Parser;

public class ParserD implements Parser {

	private DocumentBuilderFactory factory;

	public ParserD() {
		factory = DocumentBuilderFactory.newInstance();
	}

	public Document parse(Object input) throws ResourceParseException {
		// On the desktop platform, the input is an InputSource object
		// Please refer to the ResourceLoaderD class
		InputStream is = (InputStream) input;
		org.w3c.dom.Document document = tryParse(is);
		return new DocumentD(document);
	}

	private org.w3c.dom.Document tryParse(InputStream is) throws ResourceParseException {
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
