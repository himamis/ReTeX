package org.scilab.forge.jlatexmath.parser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.SymbolAtom;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.exception.XMLResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.TeXSymbolParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TeXSymbolParserD implements TeXSymbolParser {

	private static Map<String, Integer> typeMappings = new HashMap<String, Integer>();

	private Element root;

	public TeXSymbolParserD() throws ResourceParseException {
		this(ClassLoader.getSystemResourceAsStream(RESOURCE_NAME),
				RESOURCE_NAME);
	}
	
	public TeXSymbolParserD(String name) throws ResourceParseException {
		this(ClassLoader.getSystemResourceAsStream(name),
				name);
	}

	public TeXSymbolParserD(InputStream file, String name)
			throws ResourceParseException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setIgnoringComments(true);
			root = factory.newDocumentBuilder().parse(file)
					.getDocumentElement();
			// set possible valid symbol type mappings
			setTypeMappings();
		} catch (Exception e) { // JDOMException or IOException
			throw new XMLResourceParseException(name, e);
		}
	}

	public Map<String, SymbolAtom> readSymbols() throws ResourceParseException {
		Map<String, SymbolAtom> res = new HashMap<String, SymbolAtom>();
		// iterate all "symbol"-elements
		NodeList list = root.getElementsByTagName("Symbol");
		for (int i = 0; i < list.getLength(); i++) {
			Element symbol = (Element) list.item(i);
			// retrieve and check required attributes
			String name = getAttrValueAndCheckIfNotNull("name", symbol), type = getAttrValueAndCheckIfNotNull(
					TYPE_ATTR, symbol);
			// retrieve optional attribute
			String del = symbol.getAttribute(DELIMITER_ATTR);
			boolean isDelimiter = (del != null && del.equals("true"));
			// check if type is known
			Object typeVal = typeMappings.get(type);
			if (typeVal == null) // unknown type
				throw new XMLResourceParseException(RESOURCE_NAME, "Symbol",
						"type", "has an unknown value '" + type + "'!");
			// add symbol to the hash table
			res.put(name, new SymbolAtom(name, ((Integer) typeVal).intValue(),
					isDelimiter));
		}
		return res;
	}

	private void setTypeMappings() {
		typeMappings.put("ord", TeXConstants.TYPE_ORDINARY);
		typeMappings.put("op", TeXConstants.TYPE_BIG_OPERATOR);
		typeMappings.put("bin", TeXConstants.TYPE_BINARY_OPERATOR);
		typeMappings.put("rel", TeXConstants.TYPE_RELATION);
		typeMappings.put("open", TeXConstants.TYPE_OPENING);
		typeMappings.put("close", TeXConstants.TYPE_CLOSING);
		typeMappings.put("punct", TeXConstants.TYPE_PUNCTUATION);
		typeMappings.put("acc", TeXConstants.TYPE_ACCENT);
	}

	private static String getAttrValueAndCheckIfNotNull(String attrName,
			Element element) throws ResourceParseException {
		String attrValue = element.getAttribute(attrName);
		if (attrValue.equals(""))
			throw new XMLResourceParseException(RESOURCE_NAME,
					element.getTagName(), attrName, null);
		return attrValue;
	}
}
