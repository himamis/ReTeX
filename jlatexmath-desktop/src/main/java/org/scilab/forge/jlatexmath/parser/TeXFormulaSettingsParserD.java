package org.scilab.forge.jlatexmath.parser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.exception.XMLResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.TeXFormulaSettingsParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TeXFormulaSettingsParserD implements TeXFormulaSettingsParser {
	private Element root;

	public TeXFormulaSettingsParserD() throws ResourceParseException {
		this(ClassLoader.getSystemResourceAsStream(RESOURCE_NAME), RESOURCE_NAME);
	}

	public TeXFormulaSettingsParserD(String name) throws ResourceParseException {
		this(ClassLoader.getSystemResourceAsStream(name), name);
	}

	public TeXFormulaSettingsParserD(InputStream file, String name)
			throws ResourceParseException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setIgnoringComments(true);
			root = factory.newDocumentBuilder().parse(file)
					.getDocumentElement();
		} catch (Exception e) { // JDOMException or IOException
			throw new XMLResourceParseException(name, e);
		}
	}

	public void parseSymbolToFormulaMappings(String[] mappings,
			String[] textMappings) throws ResourceParseException {
		Element charToSymbol = (Element) root.getElementsByTagName(
				"CharacterToFormulaMappings").item(0);
		if (charToSymbol != null) // element present
			addFormulaToMap(charToSymbol.getElementsByTagName("Map"), mappings,
					textMappings);
	}

	public void parseSymbolMappings(String[] mappings, String[] textMappings)
			throws ResourceParseException {
		Element charToSymbol = (Element) root.getElementsByTagName(
				"CharacterToSymbolMappings").item(0);
		if (charToSymbol != null) // element present
			addToMap(charToSymbol.getElementsByTagName("Map"), mappings,
					textMappings);
	}

	private static void addToMap(NodeList mapList, String[] tableMath,
			String[] tableText) throws ResourceParseException {
		for (int i = 0; i < mapList.getLength(); i++) {
			Element map = (Element) mapList.item(i);
			String ch = map.getAttribute("char");
			String symbol = map.getAttribute("symbol");
			String text = map.getAttribute("text");
			// both attributes are required!
			if (ch.equals("")) {
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "char", null);
			} else if (symbol.equals("")) {
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "symbol", null);
			}

			if (ch.length() == 1) {// valid element found
				tableMath[ch.charAt(0)] = symbol;
			} else {
				// only single-character mappings allowed, ignore others
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "char",
						"must have a value that contains exactly 1 character!");
			}

			if (tableText != null && !text.equals("")) {
				tableText[ch.charAt(0)] = text;
			}
		}
	}

	private static void addFormulaToMap(NodeList mapList, String[] tableMath,
			String[] tableText) throws ResourceParseException {
		for (int i = 0; i < mapList.getLength(); i++) {
			Element map = (Element) mapList.item(i);
			String ch = map.getAttribute("char");
			String formula = map.getAttribute("formula");
			String text = map.getAttribute("text");
			// both attributes are required!
			if (ch.equals(""))
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "char", null);
			else if (formula.equals(""))
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "formula", null);
			if (ch.length() == 1) {// valid element found
				tableMath[ch.charAt(0)] = formula;
			} else
				// only single-character mappings allowed, ignore others
				throw new XMLResourceParseException(RESOURCE_NAME,
						map.getTagName(), "char",
						"must have a value that contains exactly 1 character!");

			if (tableText != null && !text.equals("")) {
				tableText[ch.charAt(0)] = text;
			}
		}
	}
}
