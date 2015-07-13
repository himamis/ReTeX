package com.himamis.retex.renderer.desktop.parser;

import com.himamis.retex.renderer.share.platform.parser.Document;
import com.himamis.retex.renderer.share.platform.parser.Element;

public class DocumentD implements Document {
	
	private org.w3c.dom.Document impl;
	
	public DocumentD(org.w3c.dom.Document impl) {
		this.impl = impl;
	}

	public Element getDocumentElement() {
		return new ElementD(impl.getDocumentElement());
	}

}
