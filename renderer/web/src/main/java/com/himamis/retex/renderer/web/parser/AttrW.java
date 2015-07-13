package com.himamis.retex.renderer.web.parser;

import com.himamis.retex.renderer.share.platform.parser.Attr;

public class AttrW extends NodeW implements Attr {

	private com.google.gwt.xml.client.Attr attr;

	public AttrW(com.google.gwt.xml.client.Attr attr) {
		super(attr);
		this.attr = attr;
	}

	@Override
	public String getName() {
		return attr.getName();
	}

	@Override
	public boolean isSpecified() {
		return attr.getSpecified();
	}

	@Override
	public String getValue() {
		return attr.getValue();
	}
}
