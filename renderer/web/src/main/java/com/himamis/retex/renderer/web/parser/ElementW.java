package com.himamis.retex.renderer.web.parser;

import com.himamis.retex.renderer.share.platform.parser.Element;
import com.himamis.retex.renderer.share.platform.parser.NamedNodeMap;
import com.himamis.retex.renderer.share.platform.parser.NodeList;

public class ElementW extends NodeW implements Element {

	private com.google.gwt.xml.client.Element element;

	public ElementW(com.google.gwt.xml.client.Element element) {
		super(element);
		this.element = element;
	}

	@Override
	public NodeList getElementsByTagName(String name) {
		return new NodeListW(element.getElementsByTagName(name));
	}

	@Override
	public String getAttribute(String name) {
		// make sure attritbute is not null
		String attr = element.getAttribute(name);
		attr = (attr == null ? "" : attr);
		return attr;
	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public NodeList getChildNodes() {
		return new NodeListW(element.getChildNodes());
	}

	@Override
	public NamedNodeMap getAttributes() {
		return new NamedNodeMapW(element.getAttributes());
	}

	@Override
	public boolean isNull() {
		return element == null;
	}

}
