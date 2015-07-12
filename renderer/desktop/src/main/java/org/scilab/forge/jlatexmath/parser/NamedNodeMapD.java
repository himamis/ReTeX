package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.NamedNodeMap;
import org.scilab.forge.jlatexmath.platform.parser.Node;

public class NamedNodeMapD implements NamedNodeMap {
	
	private org.w3c.dom.NamedNodeMap impl;
	
	public NamedNodeMapD(org.w3c.dom.NamedNodeMap impl) {
		this.impl = impl;
	}

	public int getLength() {
		return impl.getLength();
	}

	public Node item(int index) {
		return new NodeD(impl.item(index));
	}

}
