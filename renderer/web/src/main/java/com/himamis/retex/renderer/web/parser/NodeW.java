/**
 * This file is part of the ReTeX library - https://github.com/himamis/ReTeX
 *
 * Copyright (C) 2015 Balazs Bencze
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 *
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package com.himamis.retex.renderer.web.parser;

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
