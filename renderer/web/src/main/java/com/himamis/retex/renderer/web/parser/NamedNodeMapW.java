package com.himamis.retex.renderer.web.parser;

import com.himamis.retex.renderer.share.platform.parser.NamedNodeMap;
import com.himamis.retex.renderer.share.platform.parser.Node;

public class NamedNodeMapW implements NamedNodeMap {

	private com.google.gwt.xml.client.NamedNodeMap namedNodeMap;

	public NamedNodeMapW(com.google.gwt.xml.client.NamedNodeMap namedNodeMap) {
		this.namedNodeMap = namedNodeMap;
	}

	@Override
	public int getLength() {
		return namedNodeMap.getLength();
	}

	@Override
	public Node item(int index) {
		return new NodeW(namedNodeMap.item(index));
	}

}
