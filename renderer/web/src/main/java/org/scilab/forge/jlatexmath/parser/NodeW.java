package org.scilab.forge.jlatexmath.parser;

import com.himamis.retex.renderer.share.platform.parser.Attr;
import com.himamis.retex.renderer.share.platform.parser.Element;
import com.himamis.retex.renderer.share.platform.parser.Node;

public class NodeW implements Node {

	private com.google.gwt.xml.client.Node node;

	public NodeW(com.google.gwt.xml.client.Node node) {
		this.node = node;
	}

	@Override
	public short getNodeType() {
		return getNodeType(node.getNodeType());
	}

	@Override
	public Element castToElement() {
		return new ElementW((com.google.gwt.xml.client.Element) node);
	}

	@Override
	public Attr castToAttr() {
		return new AttrW((com.google.gwt.xml.client.Attr) node);
	}

	private static short getNodeType(short nodeType) {
		switch (nodeType) {
		case com.google.gwt.xml.client.Element.ATTRIBUTE_NODE:
			return ATTRIBUTE_NODE;
		case com.google.gwt.xml.client.Element.CDATA_SECTION_NODE:
			return CDATA_SECTION_NODE;
		case com.google.gwt.xml.client.Element.COMMENT_NODE:
			return COMMENT_NODE;
		case com.google.gwt.xml.client.Element.DOCUMENT_FRAGMENT_NODE:
			return DOCUMENT_FRAGMENT_NODE;
		case com.google.gwt.xml.client.Element.DOCUMENT_NODE:
			return DOCUMENT_NODE;
		case com.google.gwt.xml.client.Element.DOCUMENT_TYPE_NODE:
			return DOCUMENT_TYPE_NODE;
		case com.google.gwt.xml.client.Element.ELEMENT_NODE:
			return ELEMENT_NODE;
		case com.google.gwt.xml.client.Element.ENTITY_NODE:
			return ENTITY_NODE;
		case com.google.gwt.xml.client.Element.ENTITY_REFERENCE_NODE:
			return ENTITY_REFERENCE_NODE;
		case com.google.gwt.xml.client.Element.NOTATION_NODE:
			return NOTATION_NODE;
		case com.google.gwt.xml.client.Element.PROCESSING_INSTRUCTION_NODE:
			return PROCESSING_INSTRUCTION_NODE;
		case com.google.gwt.xml.client.Element.TEXT_NODE:
			return TEXT_NODE;
		default:
			return TEXT_NODE;
		}
	}
}
