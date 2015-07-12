package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Element;
import org.scilab.forge.jlatexmath.platform.parser.NamedNodeMap;
import org.scilab.forge.jlatexmath.platform.parser.NodeList;
import org.w3c.dom.Node;

public class ElementD extends NodeD implements Element {
	
	private org.w3c.dom.Element impl;
	
	public ElementD(org.w3c.dom.Element impl) {
		super((Node) impl);
		this.impl = impl;
	}

	public NodeList getElementsByTagName(String name) {
		return new NodeListD(impl.getElementsByTagName(name));
	}
	
	public String getAttribute(String name) {
		return impl.getAttribute(name);
	}
	
	public String getTagName() {
		return impl.getTagName();
	}

	public NodeList getChildNodes() {
		return new NodeListD(impl.getChildNodes());
	}

	public NamedNodeMap getAttributes() {
		return new NamedNodeMapD(impl.getAttributes());
	}

	public boolean isNull() {
		return impl == null;
	}
}
