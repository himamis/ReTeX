package org.scilab.forge.jlatexmath.platform.parser;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface TeXFormulaSettingsParser {
	
	public static final String RESOURCE_NAME = "TeXFormulaSettings.xml";
    public static final String CHARTODEL_MAPPING_EL = "Map";
	
	public void parseSymbolToFormulaMappings(String[] mappings, String[] textMappings) throws ResourceParseException;
	
	public void parseSymbolMappings(String[] mappings, String[] textMappings) throws ResourceParseException;
}
