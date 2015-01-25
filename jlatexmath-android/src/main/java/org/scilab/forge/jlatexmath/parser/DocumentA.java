package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Element;

public class DocumentA implements Document {
	
	private org.w3c.dom.Document impl;
	
	public DocumentA(org.w3c.dom.Document impl) {
		this.impl = impl;
	}

	public Element getDocumentElement() {
		return new ElementA(impl.getDocumentElement());
	}

}
