package org.scilab.forge.jlatexmath.parser;

import com.himamis.retex.renderer.share.platform.parser.Document;
import com.himamis.retex.renderer.share.platform.parser.Element;

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
