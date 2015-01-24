package org.scilab.forge.jlatexmath.platform.parser;

public abstract class ParserFactory {
	public abstract PredefinedTeXFormulaParser createPredefinedTeXFormulaParser(String resourceName, String type);
	
	public abstract GlueSettingsParser createGlueSettingsParser();
	
	public abstract TeXSymbolParser createTeXSymbolParser(String name);
	
	public abstract TeXFormulaSettingsParser createTeXFormulaSettingsParser(String name);
	
	public abstract TeXFontParser createTeXFontParser(String name);
}
