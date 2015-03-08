package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Element;

public class DocumentW implements Document {

	private com.google.gwt.xml.client.Document document;

	public DocumentW(com.google.gwt.xml.client.Document document) {
		this.document = document;
	}

	@Override
	public Element getDocumentElement() {
		return new ElementW(document.getDocumentElement());
	}

}
