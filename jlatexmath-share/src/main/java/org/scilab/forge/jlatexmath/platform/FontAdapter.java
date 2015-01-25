package org.scilab.forge.jlatexmath.platform;

import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.font.FontLoader;
import org.scilab.forge.jlatexmath.platform.font.FontRenderContext;
import org.scilab.forge.jlatexmath.platform.font.TextLayout;

public class FontAdapter {

	private final FontFactory fontFactory;
	private final FontLoader fontLoader;

	public FontAdapter() {
		fontFactory = FactoryProvider.INSTANCE.getFontFactory();
		fontLoader = fontFactory.createFontLoader();
	}

	public Font loadFont(String name) throws ResourceParseException {
		return loadFont(null, name);
	}

	public Font loadFont(Object fontType, String name) throws ResourceParseException {
		return fontLoader.loadFont(fontType, name);
	}

	public Font createFont(String name, int style, int size) {
		return fontFactory.createFont(name, style, size);
	}

	public TextLayout createTextLayout(String string, Font font, FontRenderContext fontRenderContext) {
		return fontFactory.createTextLayout(string, font, fontRenderContext);
	}
}
