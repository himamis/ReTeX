package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Node;
import org.scilab.forge.jlatexmath.platform.parser.NodeList;

public class NodeListA implements NodeList {
	
	private org.w3c.dom.NodeList impl;
	
	public NodeListA(org.w3c.dom.NodeList impl) {
		this.impl = impl;
	}

	public int getLength() {
		return impl.getLength();
	}

	public Node item(int index) {
		return new NodeA(impl.item(index));
	}

}
