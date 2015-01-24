package org.jlatexmath.android.parser;

import java.io.IOException;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.GlueSettingsParser;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.parser.PredefinedTeXFormulaParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXFontParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXFormulaSettingsParser;
import org.scilab.forge.jlatexmath.platform.parser.TeXSymbolParser;

import android.content.res.AssetManager;

public class ParserFactoryAndroid extends ParserFactory  {
	
	private AssetManager mAssetManager;
	
	public ParserFactoryAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	@Override
	public PredefinedTeXFormulaParser createPredefinedTeXFormulaParser(
			String resourceName, String type) {
		try {
			return new PredefinedTeXFormulaParserA(mAssetManager, resourceName, type);
		} catch (ResourceParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException("Could not open the file named '" + resourceName + "'" , e);
		}
	}

	@Override
	public GlueSettingsParser createGlueSettingsParser() {
		return new GlueSettingsParserA(mAssetManager);
	}

	@Override
	public TeXSymbolParser createTeXSymbolParser(String name) {
		try {
			return new TeXSymbolParserA(mAssetManager, name);
		} catch (ResourceParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException("Could not open the file named '" + name + "'" , e);
		}
	}

	@Override
	public TeXFormulaSettingsParser createTeXFormulaSettingsParser(String name) {
		try {
			return new TeXFormulaSettingsParserA(mAssetManager, name);
		} catch (ResourceParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException("Could not open the file named '" + name + "'" , e);
		}
	}

	@Override
	public TeXFontParser createTeXFontParser(String name) {
		try {
			return new TeXFontParserA(mAssetManager, name);
		} catch (ResourceParseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException("Could not open the file named '" + name + "'" , e);
		}
	}

}
