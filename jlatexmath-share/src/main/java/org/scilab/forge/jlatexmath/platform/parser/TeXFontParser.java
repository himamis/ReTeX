package org.scilab.forge.jlatexmath.platform.parser;

import java.util.Map;

import org.scilab.forge.jlatexmath.CharFont;
import org.scilab.forge.jlatexmath.FontInfo;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;

public interface TeXFontParser {
	
    public static final String RESOURCE_NAME = "DefaultTeXFont.xml";
    
    public static final String STYLE_MAPPING_EL = "TextStyleMapping";
    public static final String SYMBOL_MAPPING_EL = "SymbolMapping";
    public static final String GEN_SET_EL = "GeneralSettings";
    public static final String MUFONTID_ATTR = "mufontid";
    public static final String SPACEFONTID_ATTR = "spacefontid";
	
	public FontInfo[] parseFontDescriptions(FontInfo[] fi) throws ResourceParseException;

	public Map<String,CharFont> parseSymbolMappings() throws ResourceParseException;
	
	public String[] parseDefaultTextStyleMappings()
		    throws ResourceParseException;
	
	public Map<String,Float> parseParameters() throws ResourceParseException;
	
	public Map<String,Number> parseGeneralSettings() throws ResourceParseException;
	
	public Map<String,CharFont[]> parseTextStyleMappings();
}
