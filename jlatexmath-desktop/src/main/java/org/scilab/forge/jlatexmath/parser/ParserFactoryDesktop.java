package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.GlueSettingsParser;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.parser.PredefinedTeXFormulaParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXFontParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXFormulaSettingsParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXSymbolParser;

public class ParserFactoryDesktop extends ParserFactory {

	@Override
	public PredefinedTeXFormulaParser createPredefinedTeXFormulaParser(String resourceName, String type) {
		return new PredefinedTeXFormulaParserD(resourceName, type);
	}

	@Override
	public GlueSettingsParser createGlueSettingsParser() {
		return new GlueSettingsParserD();
	}

	@Override
	public TeXSymbolParser createTeXSymbolParser(String name) {
		return new TeXSymbolParserD(name);
	}

	@Override
	public TeXFormulaSettingsParser createTeXFormulaSettingsParser(String name) {
		return new TeXFormulaSettingsParserD(name);
	}
	
	@Override
	public TeXFontParser createTeXFontParser(String name) {
		return new TeXFontParserD(name);
	}

}
