package com.himamis.retex.renderer.desktop.parser;

import org.w3c.dom.Node;

import com.himamis.retex.renderer.share.platform.parser.Attr;

public class AttrD extends NodeD implements Attr {
	
	public org.w3c.dom.Attr impl;
	
	public AttrD(org.w3c.dom.Attr impl) {
		super((Node) impl);
		this.impl = impl;
	}

	public String getName() {
		return impl.getName();
	}

	public boolean isSpecified() {
		return impl.getSpecified();
	}

	public String getValue() {
		return impl.getValue();
	}

}
