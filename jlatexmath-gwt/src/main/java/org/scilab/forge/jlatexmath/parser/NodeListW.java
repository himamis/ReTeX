package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Node;
import org.scilab.forge.jlatexmath.platform.parser.NodeList;

public class NodeListW implements NodeList {

	private com.google.gwt.xml.client.NodeList nodeList;

	public NodeListW(com.google.gwt.xml.client.NodeList nodeList) {
		this.nodeList = nodeList;
	}

	@Override
	public int getLength() {
		return nodeList.getLength();
	}

	@Override
	public Node item(int index) {
		return new NodeW(nodeList.item(index));
	}

}
