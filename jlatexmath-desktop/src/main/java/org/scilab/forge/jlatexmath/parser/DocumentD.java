package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Document;
import org.scilab.forge.jlatexmath.platform.parser.Element;

public class DocumentD implements Document {
	
	private org.w3c.dom.Document impl;
	
	public DocumentD(org.w3c.dom.Document impl) {
		this.impl = impl;
	}

	public Element getDocumentElement() {
		return new ElementD(impl.getDocumentElement());
	}

}
