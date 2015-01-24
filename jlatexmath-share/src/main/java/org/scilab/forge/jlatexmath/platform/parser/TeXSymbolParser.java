package org.scilab.forge.jlatexmath.platform.parser;

import java.util.Map;

import org.scilab.forge.jlatexmath.SymbolAtom;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;

/**
 * Parses TeX symbol definitions from an XML-file.
 */
public interface TeXSymbolParser {
	
	public static final String RESOURCE_NAME = "TeXSymbols.xml",
	         DELIMITER_ATTR = "del", TYPE_ATTR = "type";
	
	public Map<String,SymbolAtom> readSymbols() throws ResourceParseException;
}
