package org.scilab.forge.jlatexmath.platform.parser;

import java.util.Map;

/**
 * Parses and creates predefined TeXFormula objects form an XML-file.
 */
public interface PredefinedTeXFormulaParser {
	
	public static final String RESOURCE_NAME = "PredefinedTeXFormulas.xml";
	
	public void parse(Map predefinedTeXFormulas);
}
