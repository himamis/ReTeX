package org.scilab.forge.jlatexmath.parser;

import com.himamis.retex.renderer.share.platform.parser.Node;
import com.himamis.retex.renderer.share.platform.parser.NodeList;

public class NodeListD implements NodeList {
	
	private org.w3c.dom.NodeList impl;
	
	public NodeListD(org.w3c.dom.NodeList impl) {
		this.impl = impl;
	}

	public int getLength() {
		return impl.getLength();
	}

	public Node item(int index) {
		return new NodeD(impl.item(index));
	}

}
